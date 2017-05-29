package com.cpg.dao;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.SortedMap;
import java.util.TreeMap;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import com.cpg.pojo.ProjectDetails;
import com.cpg.pojo.ProjectInfo;

/**
 * @author navinkum
 * 
 */
public class SearchDAOImpl implements SearchDAO {
	private static final int BUFFER_SIZE = 26214400;
	private DataSource dataSource;

	/**
	 * @param dataSource
	 */
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.cpg.dao.CodeRulesDAO#warning()
	 */
	public ProjectDetails getSearchParameter() {
		ProjectDetails projDtls = ProjectDetails.getInstance();
		SortedMap<String, String> projectNameMap = new TreeMap<String, String>();
		SortedMap<String, String> projectSectorMap = new TreeMap<String, String>();
		SortedMap<String, String> moduleNameMap = new TreeMap<String, String>();
		SortedMap<String, String> customizationTypeMap = new TreeMap<String, String>();
		String projectName = null;
		String projectSector = null;
		String moduleName = null;
		String customizationType = null;

		final String sql = "SELECT PROJECT_NAME, PROJECT_SECTOR, MODULE_NAME, CUSTOMIZATION_TYPE FROM XX_CEMLI_REPO_LIST";
		Connection conn = null;
		try {
			conn = dataSource.getConnection();
			projDtls.setConnection(conn);
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				projectName = rs.getString("PROJECT_NAME");
				projectSector = rs.getString("PROJECT_SECTOR");
				moduleName = rs.getString("MODULE_NAME");
				customizationType = rs.getString("CUSTOMIZATION_TYPE");
				if (projectName != null) {
					projectNameMap.put(projectName, projectName);
				}
				if (projectSector != null) {
					projectSectorMap.put(projectSector, projectSector);
				}
				if (moduleName != null) {
					moduleNameMap.put(moduleName, moduleName);
				}
				if (customizationType != null) {
					customizationTypeMap.put(customizationType,
							customizationType);
				}
			}
			projDtls.setProjectNameMap(projectNameMap);
			projDtls.setProjectSectorMap(projectSectorMap);
			projDtls.setModuleNameMap(moduleNameMap);
			projDtls.setCustomizationTypeMap(customizationTypeMap);
			projDtls.setSearchParam(true);
			rs.close();
			ps.close();
			return projDtls;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}

	/**
	 * @param projectName
	 * @param moduleName
	 * @param custType
	 * @param keyword
	 * @return
	 */
	public List<ProjectInfo> fetchDetails(final Connection conn,
			final String projectName, final String projectSector,
			final String moduleName, final String custType, final String keyword) {
		final String sql = "SELECT PROJECT_NAME, PROJECT_SECTOR, CUSTOMIZATION_ID, DESCRIPTION, MODULE_NAME, "
				+ "CUSTOMIZATION_TYPE, COMPLEXITY, PLANNED_EFFORTS, ACTUAL_EFFORTS, PERCENT_REUSE, "
				+ "FUNCTIONAL_GAP, TECHNICAL_SOLUTION, SUPPORTING_DOCUMENTS "
				+ "FROM XX_CEMLI_REPO_LIST WHERE ";
		StringBuffer query = new StringBuffer(sql);
		if (!projectName.equalsIgnoreCase("ALL")) {
			query.append("PROJECT_NAME = '" + projectName + "' AND ");
		}
		if (!projectSector.equalsIgnoreCase("ALL")) {
			query.append("PROJECT_SECTOR = '" + projectSector + "' AND ");
		}
		if (!moduleName.equalsIgnoreCase("ALL")) {
			query.append("MODULE_NAME = '" + moduleName + "' AND ");
		}
		if (!custType.equalsIgnoreCase("ALL")) {
			query.append("CUSTOMIZATION_TYPE = '" + custType + "' AND ");
		}
		query.append("LOWER(DESCRIPTION) like '%" + keyword.toLowerCase() + "%'");

		ProjectInfo projInfo = null;
		List<ProjectInfo> projInfoList = new ArrayList<ProjectInfo>();
		try {
			Statement ps = conn.createStatement();
			ResultSet rs = ps.executeQuery(query.toString());
			while (rs.next()) {
				int fileSize = 0;
				if (rs.getBlob("SUPPORTING_DOCUMENTS") != null) {
					fileSize = (int) rs.getBlob("SUPPORTING_DOCUMENTS")
							.length();
				}
				projInfo = new ProjectInfo(rs.getString("PROJECT_NAME"),
						rs.getString("PROJECT_SECTOR"),
						rs.getString("CUSTOMIZATION_ID"),
						rs.getString("DESCRIPTION"),
						rs.getString("MODULE_NAME"),
						rs.getString("CUSTOMIZATION_TYPE"),
						rs.getString("COMPLEXITY"),
						rs.getString("PLANNED_EFFORTS"),
						rs.getString("ACTUAL_EFFORTS"),
						rs.getString("PERCENT_REUSE"), 
						rs.getString("FUNCTIONAL_GAP"), 
						rs.getString("TECHNICAL_SOLUTION"), fileSize);
				projInfoList.add(projInfo);
			}

			rs.close();
			ps.close();
			return projInfoList;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public void fetchFileData(HttpServletRequest request,
			HttpServletResponse response, final Connection conn,
			final String custId) {
		final String sql = "SELECT SUPPORTING_DOCUMENTS "
				+ "FROM XX_CEMLI_REPO_LIST WHERE " + "CUSTOMIZATION_ID = ?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, custId);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Blob blob = rs.getBlob("SUPPORTING_DOCUMENTS");
				InputStream inputStream = blob.getBinaryStream();
				int fileLength = (int) blob.length();

				System.out.println("fileLength = " + fileLength);
				ServletContext context = request.getSession()
						.getServletContext();
				String fileName = custId + ".zip";
				String mimeType = context.getMimeType(fileName);
				if (mimeType == null) {
					mimeType = "application/octet-stream";
				}
				response.setContentType(mimeType);
				response.setContentLength(fileLength);
				String headerKey = "Content-Disposition";
				String headerValue = String.format(
						"attachment; filename=\"%s\"", fileName);
				response.setHeader(headerKey, headerValue);
				OutputStream outStream = response.getOutputStream();
				byte[] buffer = new byte[BUFFER_SIZE];
				int bytesRead = -1;
				while ((bytesRead = inputStream.read(buffer)) != -1) {
					outStream.write(buffer, 0, bytesRead);
				}
				inputStream.close();
				outStream.close();
			}
			rs.close();
			ps.close();

		} catch (SQLException ex) {
			ex.printStackTrace();
		} catch (IOException ex) {
			ex.printStackTrace();
		}

	}
}
