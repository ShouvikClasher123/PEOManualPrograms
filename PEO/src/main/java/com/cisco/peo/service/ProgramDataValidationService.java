package com.cisco.peo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cisco.peo.bean.DataValidation;
import com.cisco.peo.repository.ECPSourceDataRepository;

@Service
public class ProgramDataValidationService {
	
	@Autowired
	private ECPSourceDataRepository eCPSourceDataRepository;
	
	@Autowired 
	private ProgramStatus programStatus;

//	@Cacheable(value = "programTypeCache")
	public Iterable<DataValidation> fetchSourceData(String programName, String status) {
		//programStatus.setprogramStatus(programName,3);
		return eCPSourceDataRepository.fetchSourceData(programName,status);
	}
	
}
