package com.cisco.peo.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.cisco.peo.bean.Program;


public interface ProgramRepository extends JpaRepository<Program, String>{

	@Query("SELECT p FROM Program p WHERE p.programName=?1")
	public List<Program> fetchProgram(String programName);
	
	@Transactional
	@Modifying
	@Query("UPDATE Program p set p.programCategory=?2, p.programType=?3, p.adjustmentType=?4, p.approverId=?5, p.categoryType=?6 where p.programName=?1")
	public void editProgram(String programName, String programCategory, String programType, String adjustmentType, String approverId, String categoryType);
	
	@Transactional
	@Modifying
	@Query("UPDATE Program p set p.status=?2 where p.programName=?1")
	public void editProgramStatus(String programName, Integer status);

}
