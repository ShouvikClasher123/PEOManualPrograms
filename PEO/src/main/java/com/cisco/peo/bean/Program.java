package com.cisco.peo.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="xxpeo_program")
@GenericGenerator(name="idgen", strategy="increment")
public class Program {
	
	@Id
	@Column(name="program_id")
	@GeneratedValue(generator="idgen")
	private Integer programId;
	
	@Column(name="program_name")
	private String programName;
	
	@Column(name="program_type")
	private String programType;
	
	@Column(name="program_category")
	private String programCategory;
	
	@Column(name="status")
	private Integer status;
	
	@Column(name="approver_id")
	private String approverId;
	
	@Column(name="adjustment_type")
	private String adjustmentType;
	
	@Column(name="category_type")
	private String categoryType;
	
	
	public String getCategoryType() {
		return categoryType;
	}
	public void setCategoryType(String categoryType) {
		this.categoryType = categoryType;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public String getApproverId() {
		return approverId;
	}
	public void setApproverId(String approverId) {
		this.approverId = approverId;
	}
	public String getAdjustmentType() {
		return adjustmentType;
	}
	public void setAdjustmentType(String adjustmentType) {
		this.adjustmentType = adjustmentType;
	}
	public String getProgramType() {
		return programType;
	}
	public void setProgramType(String programType) {
		this.programType = programType;
	}
	public String getProgramCategory() {
		return programCategory;
	}
	public void setProgramCategory(String programCategory) {
		this.programCategory = programCategory;
	}
	public Integer getProgramId() {
		return programId;
	}
	public void setProgramId(Integer programId) {
		this.programId = programId;
	}
	public String getProgramName() {
		return programName;
	}
	public void setProgramName(String programName) {
		this.programName = programName;
	}
	@Override
	public String toString() {
		return "Program [programId=" + programId + ", programName=" + programName + ", programType=" + programType
				+ ", programCategory=" + programCategory + ", status=" + status + ", approverId=" + approverId
				+ ", adjustmentType=" + adjustmentType + ", categoryType=" + categoryType + "]";
	}
	
	
	
}
