package com.cisco.peo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cisco.peo.bean.ProgramType;


public interface ProgramTypeRepository extends JpaRepository<ProgramType, String>{

	@Query("SELECT pt.programType FROM ProgramType pt")
	public List<ProgramType> fetchProgramType();
	
}
