package com.cpg.dao;

import java.sql.Connection;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cpg.pojo.ProjectDetails;
import com.cpg.pojo.ProjectInfo;

/**
 * @author navinkum
 * 
 */
public interface SearchDAO {
	public ProjectDetails getSearchParameter();

	public List<ProjectInfo> fetchDetails(final Connection conn,
			final String projectName, final String projectSector,
			final String moduleName, final String custType, final String keyword);

	public void fetchFileData(HttpServletRequest request,
			HttpServletResponse response, final Connection conn,
			final String custId);
}
