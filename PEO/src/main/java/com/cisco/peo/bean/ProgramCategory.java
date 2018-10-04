package com.cisco.peo.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="xxpeo_prgm_type_categry_map")
//@GenericGenerator(name="idgen", strategy="increment")

public class ProgramCategory {
	

	@Id
	@Column(name="program_category")
	@NotNull
	private String programCategory;
	
	@Column(name="category_type")
	private String categoryType;

	public String getProgramCategory() {
		return programCategory;
	}

	public void setProgramCategory(String programCategory) {
		this.programCategory = programCategory;
	}

	public String getCategoryType() {
		return categoryType;
	}

	public void setCategoryType(String categoryType) {
		this.categoryType = categoryType;
	}

	@Override
	public String toString() {
		return "ProgramCategory [programCategory=" + programCategory
				+ ", categoryType=" + categoryType + "]";
	}

	
	
	}
