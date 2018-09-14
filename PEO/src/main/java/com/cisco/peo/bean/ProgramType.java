package com.cisco.peo.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="xxpeo_program_type")
public class ProgramType {
	
	@Id
	@Column(name="program_type_id")
	private Integer programTypeId;
	
	@Column(name="program_type")
	@NotNull
	private String programType;
	
	
	public Integer getProgramTypeId() {
		return programTypeId;
	}
	public void setProgramTypeId(Integer programTypeId) {
		this.programTypeId = programTypeId;
	}
	public String getProgramType() {
		return programType;
	}
	public void setProgramType(String programType) {
		this.programType = programType;
	}
	
	@Override
	public String toString() {
		return "ProgramType [programTypeId=" + programTypeId + ", programType="
				+ programType + "]";
	}
}
