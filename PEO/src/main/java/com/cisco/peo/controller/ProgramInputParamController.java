package com.cisco.peo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cisco.peo.bean.InputParam;
import com.cisco.peo.exceptions.PEOException;
import com.cisco.peo.exceptions.SILogger;
import com.cisco.peo.service.ProgramInputParamService;

import io.swagger.annotations.Api;


@RestController
@RequestMapping("/programInputParam")
@Api(value = "Program Set-up Resource")
public class ProgramInputParamController {

	private static final Logger LOG = LoggerFactory.getLogger(ProgramSetUpController.class);

	@Autowired
	private ProgramInputParamService programInputParamService;
	
	@Autowired
	private SILogger logException;
	
	@Autowired
	private PEOException peoException;
	
	
	@SuppressWarnings("unchecked")
	@CrossOrigin(allowCredentials = "true")
	@RequestMapping(value = "/fetchInputParam", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public InputParam fetchInputParam(@RequestParam String programName) {
	  try {
			System.out.println("in controller");
			if (LOG.isInfoEnabled()) {
				LOG.info("Request received. PathVariable is: ");
			}
			
			return this.programInputParamService.fetchInputParam(programName);
			
		} catch (Exception e) {
			this.peoException.initialize("amigaura", "order-error", (" " + e).trim(), e);
			this.logException.logException(this.peoException);
			//return (ResponseEntity<ProgramDetail>) ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR);
			return null;
		}
	}
	
	@SuppressWarnings("unchecked")
	@CrossOrigin(allowCredentials = "true")
	@RequestMapping(value = "/saveInputParam", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public void saveProgram(
			@RequestBody InputParam inputParam, String flag) {
		try {
			
			if (LOG.isInfoEnabled()) {
				LOG.info("Request received. PathVariable is: ", inputParam);
			}
			if(flag.equals("save")){
				programInputParamService.saveInputParam(inputParam);
			}
			else if(flag.equals("update")){
				programInputParamService.editInputParam(inputParam);	
			}
			
		} catch (Exception e) {
			this.peoException.initialize("amigaura", "order-error", (" " + e).trim(), e);
			this.logException.logException(this.peoException);
		}
	}

}