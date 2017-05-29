package com.cpg.service;

import java.sql.Connection;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cpg.dao.SearchDAOImpl;
import com.cpg.pojo.ProjectDetails;
import com.cpg.pojo.ProjectInfo;

public class SearchDetails {

	public List<ProjectInfo> fetchDetails(ProjectDetails projDtls) {
		final Connection conn = projDtls.getConnection();
		final String projectName = projDtls.getProjectName();
		final String projectSector = projDtls.getProjectSector();
		final String moduleName = projDtls.getModuleName();
		final String custType = projDtls.getCustomizationType();
		final String keyword = projDtls.getDescription();

		SearchDAOImpl impl = new SearchDAOImpl();
		List<ProjectInfo> projInfoList = impl.fetchDetails(conn, projectName,
				projectSector, moduleName, custType, keyword);

		return projInfoList;
	}

	public void getFileFromDataBase(HttpServletRequest request,
			HttpServletResponse response, Connection conn, final String custId) {
		SearchDAOImpl impl = new SearchDAOImpl();
		impl.fetchFileData(request, response, conn, custId);
	}
}
