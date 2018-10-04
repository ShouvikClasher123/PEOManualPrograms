package com.cisco.peo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cisco.peo.repository.ProgramRepository;

@Service
public class ProgramStatus {
	
	@Autowired
	private ProgramRepository programRepository;
	
	public void setprogramStatus(String programName, Integer status){
		
		programRepository.editProgramStatus(programName, status);
		
	}

}
