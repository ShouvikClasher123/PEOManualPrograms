package com.cisco.peo.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="xxpeo_program_category")
public class ProgramCategory {
	
	@Id
	@Column(name="program_category_id")
	private Integer programCategoryId;
	
	@Column(name="program_category")
	@NotNull
	private String programCategory;
	
	public Integer getProgramCategoryId() {
		return programCategoryId;
	}
	public void setProgramCategoryId(Integer programCategoryId) {
		this.programCategoryId = programCategoryId;
	}
	public String getProgramCategory() {
		return programCategory;
	}
	public void setProgramCategory(String programCategory) {
		this.programCategory = programCategory;
	}
	
	@Override
	public String toString() {
		return "ProgramCategory [programCategoryId=" + programCategoryId + ", programCategory="
				+ programCategory + "]";
	}
}
