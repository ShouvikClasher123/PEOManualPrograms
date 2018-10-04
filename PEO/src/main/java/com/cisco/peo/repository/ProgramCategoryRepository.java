package com.cisco.peo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cisco.peo.bean.ProgramCategory;


public interface ProgramCategoryRepository extends JpaRepository<ProgramCategory, String>{

	@Query("SELECT pc.programCategory FROM ProgramCategory pc where pc.categoryType=?1")
	public List<ProgramCategory> fetchProgramCategory(String programType);
}
