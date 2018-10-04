package com.cisco.peo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cisco.peo.bean.CategoryType;


public interface CategoryTypeRepository extends JpaRepository<CategoryType, String>{

	@Query("SELECT ct.categoryType FROM CategoryType ct")
	public List<CategoryType> fetchProgramType();
	
}
