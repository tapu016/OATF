package com.cpg.pojo;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import java.util.SortedMap;
import java.util.TreeMap;

import org.springframework.util.CollectionUtils;

public class ProjectDetails {
	
	private static ProjectDetails instance;

	private ProjectDetails() {
	}

	protected Object readResolve() {
		return getInstance();
	}

	public static ProjectDetails getInstance() {
		if (instance == null) {
			synchronized (ProjectDetails.class) {
				if (instance == null) {
					instance = new ProjectDetails();
				}
			}
		}
		return instance;
	}
	
	private String projectName; 
	private String projectSector;
	private String description;
	private String moduleName;
	private String customizationType;
	
	SortedMap<String, String> projectNameMap;
	SortedMap<String, String> projectSectorMap;
	SortedMap<String, String> moduleNameMap;
	SortedMap<String, String> customizationTypeMap;
	
	private boolean searchParam;
	
	private Connection connection;
	//supporting_documents BLOB
	List<ProjectInfo> projectInfo;
	
	/**
	 * @return the projectName
	 */
	public String getProjectName() {
		return projectName;
	}
	/**
	 * @param projectName the projectName to set
	 */
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	/**
	 * @return the projectSector
	 */
	public String getProjectSector() {
		return projectSector;
	}
	/**
	 * @param projectSector the projectSector to set
	 */
	public void setProjectSector(String projectSector) {
		this.projectSector = projectSector;
	}
	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}
	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	/**
	 * @return the moduleName
	 */
	public String getModuleName() {
		return moduleName;
	}
	/**
	 * @param moduleName the moduleName to set
	 */
	public void setModuleName(String moduleName) {
		this.moduleName = moduleName;
	}
	/**
	 * @return the customizationType
	 */
	public String getCustomizationType() {
		return customizationType;
	}
	/**
	 * @param customizationType the customizationType to set
	 */
	public void setCustomizationType(String customizationType) {
		this.customizationType = customizationType;
	}
	/**
	 * @return the projectNameMap
	 */
	public SortedMap<String, String> getProjectNameMap() {
		if(CollectionUtils.isEmpty(projectNameMap)){
			projectNameMap = new TreeMap<String, String>();
		}
		return projectNameMap;
	}
	/**
	 * @param projectNameMap the projectNameMap to set
	 */
	public void setProjectNameMap(SortedMap<String, String> projectNameMap) {
		this.projectNameMap = projectNameMap;
	}
	/**
	 * @return the projectSectorMap
	 */
	public SortedMap<String, String> getProjectSectorMap() {
		if(CollectionUtils.isEmpty(projectSectorMap)){
			projectSectorMap = new TreeMap<String, String>();
		}
		return projectSectorMap;
	}
	/**
	 * @param projectSectorMap the projectSectorMap to set
	 */
	public void setProjectSectorMap(SortedMap<String, String> projectSectorMap) {
		this.projectSectorMap = projectSectorMap;
	}
	/**
	 * @return the moduleNameMap
	 */
	public SortedMap<String, String> getModuleNameMap() {
		if(CollectionUtils.isEmpty(moduleNameMap)){
			moduleNameMap = new TreeMap<String, String>();
		}
		return moduleNameMap;
	}
	/**
	 * @param moduleNameMap the moduleNameMap to set
	 */
	public void setModuleNameMap(SortedMap<String, String> moduleNameMap) {
		this.moduleNameMap = moduleNameMap;
	}
	/**
	 * @return the customizationTypeMap
	 */
	public SortedMap<String, String> getCustomizationTypeMap() {
		if(CollectionUtils.isEmpty(customizationTypeMap)){
			customizationTypeMap = new TreeMap<String, String>();
		}
		return customizationTypeMap;
	}
	/**
	 * @param customizationTypeMap the customizationTypeMap to set
	 */
	public void setCustomizationTypeMap(
			SortedMap<String, String> customizationTypeMap) {
		this.customizationTypeMap = customizationTypeMap;
	}

	/**
	 * @return the searchParam
	 */
	public boolean isSearchParam() {
		return searchParam;
	}

	/**
	 * @param searchParam the searchParam to set
	 */
	public void setSearchParam(boolean searchParam) {
		this.searchParam = searchParam;
	}

	/**
	 * @return the projectInfo
	 */
	public List<ProjectInfo> getProjectInfo() {
		if(CollectionUtils.isEmpty(projectInfo)){
			projectInfo = new ArrayList<ProjectInfo>();
		}
		return projectInfo;
	}

	/**
	 * @param projectInfo the projectInfo to set
	 */
	public void setProjectInfo(List<ProjectInfo> projectInfo) {
		this.projectInfo = projectInfo;
	}

	/**
	 * @return the connection
	 */
	public Connection getConnection() {
		return connection;
	}

	/**
	 * @param connection the connection to set
	 */
	public void setConnection(Connection connection) {
		this.connection = connection;
	}

}
