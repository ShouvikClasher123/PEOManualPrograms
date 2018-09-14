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
		return "Program [programId=" + programId + ", programName="
				+ programName + "]";
	}
}
