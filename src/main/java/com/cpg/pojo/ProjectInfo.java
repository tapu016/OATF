package com.cpg.pojo;

public class ProjectInfo {

	private String projectName; 
	private String projectSector;
	private String customizationId;
	private String description;
	private String moduleName;
	private String customizationType;
	private String complexity;         
	private String plannedEffort;
	private String actualEffort;
	private String percentReuse;
	private String functionalGap;
	private String technicalSoln;
	private int fileSize;
	/**
	 * 
	 */
	public ProjectInfo() {
		super();
	}
	
	/**
	 * @param projectName
	 * @param projectSector
	 * @param customizationId
	 * @param description
	 * @param moduleName
	 * @param customizationType
	 * @param complexity
	 * @param plannedEffort
	 * @param actualEffort
	 * @param percentReuse
	 * @param functionalGap
	 * @param technicalSoln
	 * @param fileSize
	 */
	public ProjectInfo(String projectName, String projectSector,
			String customizationId, String description, String moduleName,
			String customizationType, String complexity, String plannedEffort,
			String actualEffort, String percentReuse, String functionalGap,
			String technicalSoln, int fileSize) {
		super();
		this.projectName = projectName;
		this.projectSector = projectSector;
		this.customizationId = customizationId;
		this.description = description;
		this.moduleName = moduleName;
		this.customizationType = customizationType;
		this.complexity = complexity;
		this.plannedEffort = plannedEffort;
		this.actualEffort = actualEffort;
		this.percentReuse = percentReuse;
		this.functionalGap = functionalGap;
		this.technicalSoln = technicalSoln;
		this.fileSize = fileSize;
	}

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
	 * @return the customizationId
	 */
	public String getCustomizationId() {
		return customizationId;
	}
	/**
	 * @param customizationId the customizationId to set
	 */
	public void setCustomizationId(String customizationId) {
		this.customizationId = customizationId;
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
	 * @return the complexity
	 */
	public String getComplexity() {
		return complexity;
	}
	/**
	 * @param complexity the complexity to set
	 */
	public void setComplexity(String complexity) {
		this.complexity = complexity;
	}
	/**
	 * @return the plannedEffort
	 */
	public String getPlannedEffort() {
		return plannedEffort;
	}
	/**
	 * @param plannedEffort the plannedEffort to set
	 */
	public void setPlannedEffort(String plannedEffort) {
		this.plannedEffort = plannedEffort;
	}
	/**
	 * @return the actualEffort
	 */
	public String getActualEffort() {
		return actualEffort;
	}
	/**
	 * @param actualEffort the actualEffort to set
	 */
	public void setActualEffort(String actualEffort) {
		this.actualEffort = actualEffort;
	}
	/**
	 * @return the percentReuse
	 */
	public String getPercentReuse() {
		return percentReuse;
	}
	/**
	 * @param percentReuse the percentReuse to set
	 */
	public void setPercentReuse(String percentReuse) {
		this.percentReuse = percentReuse;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ProjectInfo [projectName=" + projectName + ", projectSector="
				+ projectSector + ", customizationId=" + customizationId
				+ ", description=" + description + ", moduleName=" + moduleName
				+ ", customizationType=" + customizationType + ", complexity="
				+ complexity + ", plannedEffort=" + plannedEffort
				+ ", actualEffort=" + actualEffort + ", percentReuse="
				+ percentReuse + "]";
	}

	/**
	 * @return the fileSize
	 */
	public int getFileSize() {
		return fileSize;
	}

	/**
	 * @param fileSize the fileSize to set
	 */
	public void setFileSize(int fileSize) {
		this.fileSize = fileSize;
	}

	/**
	 * @return the functionalGap
	 */
	public String getFunctionalGap() {
		return functionalGap;
	}

	/**
	 * @param functionalGap the functionalGap to set
	 */
	public void setFunctionalGap(String functionalGap) {
		this.functionalGap = functionalGap;
	}

	/**
	 * @return the technicalSoln
	 */
	public String getTechnicalSoln() {
		return technicalSoln;
	}

	/**
	 * @param technicalSoln the technicalSoln to set
	 */
	public void setTechnicalSoln(String technicalSoln) {
		this.technicalSoln = technicalSoln;
	}
}
