package com.cisco.peo.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.cisco.peo.bean.InputParam;


public interface ProgramInputParamRepository extends JpaRepository<InputParam, String>{

	@Query("SELECT ip FROM InputParam ip WHERE ip.programName=?1")
	public InputParam fetchInputParam(String programName);
	
	@Transactional
	@Modifying
	@Query("UPDATE InputParam  set fromPid=?1, soNum=?3, territoryType=?4, transGroupCode=?5, toPid = ?6 where programName=?2")
	public void editInputParam(String fromPid, String programName, String soNum, String territoryType, String transGroupCode, String toPid);

}
