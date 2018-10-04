package com.cisco.peo.controller;

import java.util.Iterator;
import java.util.StringTokenizer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cisco.peo.bean.Program;
import com.cisco.peo.bean.ProgramCategory;
import com.cisco.peo.bean.ProgramDetail;
import com.cisco.peo.bean.ProgramType;
import com.cisco.peo.bean.CategoryType;
import com.cisco.peo.exceptions.PEOException;
import com.cisco.peo.exceptions.SILogger;
import com.cisco.peo.service.ProgramSetUpService;

import io.swagger.annotations.Api;


@RestController
@RequestMapping("/programSetUp")
@Api(value = "Program Set-up Resource")
public class ProgramSetUpController {

	private static final Logger LOG = LoggerFactory.getLogger(ProgramSetUpController.class);

	@Autowired
	private ProgramSetUpService programSetUpService;
	
	@Autowired
	private SILogger logException;
	
	@Autowired
	private PEOException peoException;
	
	/*********** List of program*****/
	
	@SuppressWarnings("unchecked")
	@CrossOrigin(allowCredentials = "true")
	@RequestMapping(value = "/fetchAllProgram", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Iterable<Program>> fetchAllProgram() {
		try {
			System.out.println("in controller");
			if (LOG.isInfoEnabled()) {
				LOG.info("Request received. PathVariable is: ");
			}
			return ResponseEntity.ok(this.programSetUpService.fetchAllProgram());
		} catch (Exception e) {
			this.peoException.initialize("amigaura", "order-error", (" " + e).trim(), e);
			this.logException.logException(this.peoException);
			return (ResponseEntity<Iterable<Program>>) ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@SuppressWarnings("unchecked")
	@CrossOrigin(allowCredentials = "true")
	@RequestMapping(value = "/fetchProgram", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	//public ResponseEntity<ProgramDetail> fetchProgram(@RequestParam String programName) {
	public ProgramDetail fetchProgram(@RequestParam String programName) {
		ProgramDetail programDetail = null;
	  try {
			System.out.println("in controller");
			if (LOG.isInfoEnabled()) {
				LOG.info("Request received. PathVariable is: ");
			}
			
			Iterable<Program> programs = this.programSetUpService.fetchProgram(programName);
			programDetail = separateProgramAttributes(programs);
			
			//return ResponseEntity.ok(programDetail);
			return programDetail;
		} catch (Exception e) {
			this.peoException.initialize("amigaura", "order-error", (" " + e).trim(), e);
			this.logException.logException(this.peoException);
			//return (ResponseEntity<ProgramDetail>) ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR);
			return programDetail;
		}
	}

	private ProgramDetail separateProgramAttributes(Iterable<Program> programs) {
		Iterator<Program> iterator = programs.iterator();
		ProgramDetail programDetail = null;
		while(iterator.hasNext()){
			Program program = iterator.next();
			String programName = program.getProgramName();
			
			System.out.println("programName : " +programName);
			
			StringTokenizer stringTokenizer = new StringTokenizer(programName, "_");
			int position = 1;
			programDetail = new ProgramDetail();
			while(stringTokenizer.hasMoreTokens()){
				if(position == 1){
					programDetail.setYear(stringTokenizer.nextToken());
					++position;
				}else if(position == 2){
					programDetail.setTerrType(stringTokenizer.nextToken());
					++position;
				}else if(position == 3){
					programDetail.setFet(stringTokenizer.nextToken());
					++position;
				}else if(position == 4){
					programDetail.setUniqueName(stringTokenizer.nextToken());
				}
			}
			
			programDetail.setCategory(program.getProgramCategory());
			programDetail.setProgramType(program.getProgramType());
			programDetail.setAdjustmentType(program.getAdjustmentType());
			programDetail.setApproverId(program.getApproverId());
			programDetail.setCategoryType(program.getCategoryType());
			programDetail.setStatus(program.getStatus());
			
			
			System.out.println(programDetail);
		}
		return programDetail;
	}

	/*********** List of category types*****/
	
	@SuppressWarnings("unchecked")
	@CrossOrigin(allowCredentials = "true")
	@RequestMapping(value = "/fetchAllCategoryType", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Iterable<CategoryType>> fetchAllCategoryType() {
		try {
			if (LOG.isInfoEnabled()) {
				LOG.info("Request received. PathVariable is: ");
			}
			return ResponseEntity.ok(this.programSetUpService.fetchAllCategoryType());
		} catch (Exception e) {
			this.peoException.initialize("amigaura", "order-error", (" " + e).trim(), e);
			this.logException.logException(this.peoException);
			return (ResponseEntity<Iterable<CategoryType>>) ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	

	/*********** List of program types*****/
	
	@SuppressWarnings("unchecked")
	@CrossOrigin(allowCredentials = "true")
	@RequestMapping(value = "/fetchAllProgramType", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Iterable<ProgramType>> fetchAllProgramType() {
		try {
			if (LOG.isInfoEnabled()) {
				LOG.info("Request received. PathVariable is: ");
			}
			return ResponseEntity.ok(this.programSetUpService.fetchAllProgramType());
		} catch (Exception e) {
			this.peoException.initialize("amigaura", "order-error", (" " + e).trim(), e);
			this.logException.logException(this.peoException);
			return (ResponseEntity<Iterable<ProgramType>>) ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	

	
	/*********** List of program categories*****/
	
	@SuppressWarnings("unchecked")
	@CrossOrigin(allowCredentials = "true")
	@RequestMapping(value = "/fetchAllProgramCategory", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Iterable<ProgramCategory> fetchAllProgramCategory(@RequestParam String categoryType) {
		try {
			if (LOG.isInfoEnabled()) {
				LOG.info("Request received. PathVariable is: ");
			}
			return programSetUpService.fetchAllProgramCategory(categoryType);
		} catch (Exception e) {
			this.peoException.initialize("amigaura", "order-error", (" " + e).trim(), e);
			this.logException.logException(this.peoException);
			return null;
		}
	}
	
	/***************Save Program Details********/
	
	@SuppressWarnings("unchecked")
	@CrossOrigin(allowCredentials = "true")
	@RequestMapping(value = "/saveProgram", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public void saveProgram(
			@RequestBody ProgramDetail programDetail, String flag) {
		try {
			
			if (LOG.isInfoEnabled()) {
				LOG.info("Request received. PathVariable is: ", programDetail);
			}
			if(flag.equals("save")){
				programSetUpService.saveProgram(programDetail);
			}
			else if(flag.equals("update")){
				programSetUpService.editProgram(programDetail);	
			}
			
		} catch (Exception e) {
			this.peoException.initialize("amigaura", "order-error", (" " + e).trim(), e);
			this.logException.logException(this.peoException);
		}
	}
	
		/*@SuppressWarnings("unchecked")
	@CrossOrigin(allowCredentials = "true")
	@RequestMapping(value = "/editProgram", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Program> editProgram(
			@RequestBody ProgramDetail programDetail) {
		try {
			if (LOG.isInfoEnabled()) {
				LOG.info("Request received. PathVariable is: ", programDetail);
			}
			return ResponseEntity.ok(this.programSetUpService.editProgram(programDetail));
		} catch (Exception e) {
			this.peoException.initialize("amigaura", "order-error", (" " + e).trim(), e);
			this.logException.logException(this.peoException);
			return (ResponseEntity<Program>) ResponseEntity
					.status(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}*/

}