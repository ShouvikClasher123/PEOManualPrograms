package com.cisco.peo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cisco.peo.bean.Program;


public interface ProgramRepository extends JpaRepository<Program, String>{

	@Query("SELECT p.programName FROM Program p")
	public List<Program> fetchProgram();

}
