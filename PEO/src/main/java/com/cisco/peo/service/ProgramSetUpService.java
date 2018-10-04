package com.cisco.peo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cisco.peo.bean.InputParam;
import com.cisco.peo.bean.Program;
import com.cisco.peo.bean.ProgramCategory;
import com.cisco.peo.bean.ProgramDetail;
import com.cisco.peo.bean.ProgramType;
import com.cisco.peo.bean.CategoryType;
import com.cisco.peo.repository.ProgramCategoryRepository;
import com.cisco.peo.repository.ProgramInputParamRepository;
import com.cisco.peo.repository.ProgramRepository;
import com.cisco.peo.repository.ProgramTypeRepository;
import com.cisco.peo.repository.CategoryTypeRepository;

@Service
public class ProgramSetUpService {

	/*@Autowired
   public ProgramTypeService(ProgramRepository programRepository) {
		this.programRepository = programRepository;
	}*/
	@Autowired
	private ProgramStatus programStatus;
	
	@Autowired
	private CategoryTypeRepository categoryTypeRepository;
	
	@Autowired
	private ProgramRepository programRepository;
	
	@Autowired
	private ProgramCategoryRepository programCategoryRepository;
	
	@Autowired 
	private ProgramInputParamRepository programInputParamRepository;

	@Autowired 
	private ProgramTypeRepository programTypeRepository;

//	@Cacheable(value = "programTypeCache")
	public Iterable<CategoryType> fetchAllCategoryType() {
		return categoryTypeRepository.findAll();
	}
	
	public Iterable<Program> fetchAllProgram() {
		System.out.println("in service");
		return programRepository.findAll();
	
	}
	
	public Iterable<Program> fetchProgram(String programName) {
		System.out.println("in service");
		System.out.println(programRepository.fetchProgram(programName));
		return programRepository.fetchProgram(programName);
		
	
	}
	
	public Iterable<ProgramCategory> fetchAllProgramCategory(String programType) {
		return programCategoryRepository.fetchProgramCategory(programType);
	}

	public void saveProgram(ProgramDetail programDetail) {
		
		String programName = formProgramName(programDetail);
		Program program = new Program();
		InputParam inputParam = new InputParam();
		inputParam.setProgramName(programName);
		inputParam.setTerritoryType("DR");
		inputParam.setTransGroupCode("BOOK,REV");
		programInputParamRepository.save(inputParam);
		
		program.setProgramName(programName);
		program.setProgramCategory(programDetail.getCategory());
		program.setProgramType(programDetail.getProgramType());
		program.setAdjustmentType(programDetail.getAdjustmentType());
		program.setApproverId(programDetail.getApproverId());
		program.setCategoryType(programDetail.getCategoryType());
		programRepository.save(program);
	    //programStatus.setprogramStatus(programName,1);
		
	}

	private String formProgramName(ProgramDetail programDetail) {
		return programDetail.getYear()+"_"+programDetail.getTerrType()+"_"+programDetail.getFet()+"_"+programDetail.getUniqueName();
	}
	
	public void editProgram(ProgramDetail programDetail) {
		
		String programName = formProgramName(programDetail);
		String programCategory = programDetail.getCategory();
		String programType = programDetail.getProgramType();
		String adjustmentType = programDetail.getAdjustmentType();
		String approverId = programDetail.getApproverId();
		String categoryType = programDetail.getCategoryType();
		programRepository.editProgram(programName, programCategory, programType,adjustmentType, approverId,categoryType);
		
	}

	public Iterable<ProgramType> fetchAllProgramType() {
		return programTypeRepository.findAll();
	}
	
	
	

}
