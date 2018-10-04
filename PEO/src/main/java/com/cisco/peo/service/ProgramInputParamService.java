package com.cisco.peo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cisco.peo.bean.InputParam;
import com.cisco.peo.bean.Program;
import com.cisco.peo.bean.ProgramDetail;
import com.cisco.peo.repository.ProgramInputParamRepository;

@Service
public class ProgramInputParamService {
	
	@Autowired
	private ProgramStatus programStatus;
	
	@Autowired
	private ProgramInputParamRepository programInputParamRepository;

	public InputParam fetchInputParam(String programName) {
		return programInputParamRepository.fetchInputParam(programName);
	}
	
public void saveInputParam(InputParam inputParam) {
		
		InputParam inputParams = new InputParam();
		
		inputParams.setProgramName(inputParam.getProgramName());
		inputParams.setFromPid(inputParam.getFromPid());
		inputParams.setSoNum(inputParam.getSoNum());
		inputParams.setTerritoryType(inputParam.getTerritoryType());
		inputParams.setTransGroupCode(inputParam.getTransGroupCode());
		inputParams.setToPid(inputParam.getToPid());
		programInputParamRepository.save(inputParams);
		//programStatus.setprogramStatus(inputParam.getProgramName(),2);
		
		
	}
	
	public void editInputParam(InputParam inputParam) {
		
		programInputParamRepository.editInputParam(inputParam.getFromPid(), inputParam.getProgramName(),inputParam.getSoNum(), inputParam.getTerritoryType(),inputParam.getTransGroupCode(), inputParam.getToPid());
		//programStatus.setprogramStatus(inputParam.getProgramName(),2);
		
	}

	
}
