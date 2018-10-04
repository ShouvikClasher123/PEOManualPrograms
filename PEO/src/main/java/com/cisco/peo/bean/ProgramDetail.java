package com.cisco.peo.bean;

public class ProgramDetail {
	
	private String year;
	private String terrType;
	private String fet;
	private String uniqueName;
	private String programType;
	private String adjustmentType;
	private String approverId;
	private String categoryType;
	public String getCategoryType() {
		return categoryType;
	}
	public void setCategoryType(String categoryType) {
		this.categoryType = categoryType;
	}
	private Integer status;
	
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public String getAdjustmentType() {
		return adjustmentType;
	}
	public void setAdjustmentType(String adjustmentType) {
		this.adjustmentType = adjustmentType;
	}
	public String getApproverId() {
		return approverId;
	}
	public void setApproverId(String approverId) {
		this.approverId = approverId;
	}
	private String category;
	
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public String getTerrType() {
		return terrType;
	}
	public void setTerrType(String terrType) {
		this.terrType = terrType;
	}
	public String getFet() {
		return fet;
	}
	public void setFet(String fet) {
		this.fet = fet;
	}
	public String getUniqueName() {
		return uniqueName;
	}
	public void setUniqueName(String uniqueName) {
		this.uniqueName = uniqueName;
	}
	public String getProgramType() {
		return programType;
	}
	public void setProgramType(String type) {
		this.programType = type;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	@Override
	public String toString() {
		return "ProgramDetail [year=" + year + ", terrType=" + terrType + ", fet=" + fet + ", uniqueName=" + uniqueName
				+ ", type=" + programType + ", adjustmentType=" + adjustmentType + ", approverId=" + approverId
				+ ", categoryType=" + categoryType + ", status=" + status + ", category=" + category + "]";
	}
	
	
	

}
