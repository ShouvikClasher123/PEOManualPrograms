package com.cisco.peo.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="xxpeo_category_type")
public class CategoryType {
	
	@Id
	@Column(name="category_type_id")
	private Integer categoryTypeId;
	
	@Column(name="category_type")
	@NotNull
	private String categoryType;
	
	
	public Integer getCategoryTypeId() {
		return categoryTypeId;
	}
	public void setCategoryTypeId(Integer categoryTypeId) {
		this.categoryTypeId = categoryTypeId;
	}
	public String getCategoryType() {
		return categoryType;
	}
	public void setCategoryType(String categoryType) {
		this.categoryType = categoryType;
	}
	@Override
	public String toString() {
		return "CategoryType [categoryTypeId=" + categoryTypeId + ", categoryType=" + categoryType + "]";
	}
	
	
}
