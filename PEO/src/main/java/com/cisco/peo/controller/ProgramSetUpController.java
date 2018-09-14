package com.cisco.peo.controller;

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
import org.springframework.web.bind.annotation.RestController;

import com.cisco.peo.bean.Program;
import com.cisco.peo.bean.ProgramCategory;
import com.cisco.peo.bean.ProgramDetail;
import com.cisco.peo.bean.ProgramType;
import com.cisco.peo.exceptions.PEOException;
import com.cisco.peo.exceptions.SILogger;
import com.cisco.peo.service.ProgramTypeService;

import io.swagger.annotations.Api;


@RestController
@RequestMapping("/programSetUp")
@Api(value = "Program Set-up Resource")
public class ProgramSetUpController {

	private static final Logger LOG = LoggerFactory.getLogger(ProgramSetUpController.class);

	@Autowired
	private ProgramTypeService programTypeService;
	
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
			return ResponseEntity.ok(this.programTypeService.fetchAllProgram());
		} catch (Exception e) {
			this.peoException.initialize("amigaura", "order-error", (" " + e).trim(), e);
			this.logException.logException(this.peoException);
			return (ResponseEntity<Iterable<Program>>) ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR);
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
			return ResponseEntity.ok(this.programTypeService.fetchAllProgramType());
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
	public ResponseEntity<Iterable<ProgramCategory>> fetchAllProgramCategory() {
		try {
			if (LOG.isInfoEnabled()) {
				LOG.info("Request received. PathVariable is: ");
			}
			return ResponseEntity.ok(this.programTypeService.fetchAllProgramCategory());
		} catch (Exception e) {
			this.peoException.initialize("amigaura", "order-error", (" " + e).trim(), e);
			this.logException.logException(this.peoException);
			return (ResponseEntity<Iterable<ProgramCategory>>) ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@SuppressWarnings("unchecked")
	@CrossOrigin(allowCredentials = "true")
	@RequestMapping(value = "/saveProgram", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Program> saveProgram(
			@RequestBody ProgramDetail programDetail) {
		try {
			if (LOG.isInfoEnabled()) {
				LOG.info("Request received. PathVariable is: ", programDetail);
			}
			return ResponseEntity.ok(this.programTypeService.saveProgram(programDetail));
		} catch (Exception e) {
			this.peoException.initialize("amigaura", "order-error", (" " + e).trim(), e);
			this.logException.logException(this.peoException);
			return (ResponseEntity<Program>) ResponseEntity
					.status(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	
	

}