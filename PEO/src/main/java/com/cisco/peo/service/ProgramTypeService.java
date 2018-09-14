package com.cisco.peo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cisco.peo.bean.Program;
import com.cisco.peo.bean.ProgramCategory;
import com.cisco.peo.bean.ProgramDetail;
import com.cisco.peo.bean.ProgramType;
import com.cisco.peo.repository.ProgramCategoryRepository;
import com.cisco.peo.repository.ProgramRepository;
import com.cisco.peo.repository.ProgramTypeRepository;

@Service
public class ProgramTypeService {

	/*@Autowired
   public ProgramTypeService(ProgramRepository programRepository) {
		this.programRepository = programRepository;
	}*/
	@Autowired
	private ProgramTypeRepository programTypeRepository;
	
	@Autowired
	private ProgramRepository programRepository;
	
	@Autowired
	private ProgramCategoryRepository programCategoryRepository;

//	@Cacheable(value = "programTypeCache")
	public Iterable<ProgramType> fetchAllProgramType() {
		return programTypeRepository.findAll();
	}
	
	public Iterable<Program> fetchAllProgram() {
		System.out.println("in service");
		return programRepository.findAll();
	
	}
	
	public Iterable<ProgramCategory> fetchAllProgramCategory() {
		return programCategoryRepository.findAll();
	}

	public Program saveProgram(ProgramDetail programDetail) {
		
		String programName = programDetail.getYear()+"_"+programDetail.getTerrType()+"_"+programDetail.getFet()+"_"+programDetail.getUniqueName();
		Program program = new Program();
		
//		program.setProgramId(1);
		program.setProgramName(programName);
		program.setProgramCategory(programDetail.getCategory());
		program.setProgramType(programDetail.getType());
		return programRepository.save(program);
		
	}

}
