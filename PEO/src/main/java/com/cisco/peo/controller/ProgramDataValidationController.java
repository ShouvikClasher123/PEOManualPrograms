package com.cisco.peo.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.StringTokenizer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cisco.peo.bean.DataValidation;
import com.cisco.peo.exceptions.PEOException;
import com.cisco.peo.exceptions.SILogger;
import com.cisco.peo.service.ProgramDataValidationService;

import io.swagger.annotations.Api;


@RestController
@RequestMapping("/programData")
@Api(value = "Program Set-up Resource")
public class ProgramDataValidationController {

	private static final Logger LOG = LoggerFactory.getLogger(ProgramSetUpController.class);

	@Autowired
	private ProgramDataValidationService programDataValidationService;
	
	@Autowired
	private SILogger logException;
	
	@Autowired
	private PEOException peoException;
	
	
	@SuppressWarnings("unchecked")
	@CrossOrigin(allowCredentials = "true")
	@RequestMapping(value = "/fetchValidData", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	//public ResponseEntity<ProgramDetail> fetchProgram(@RequestParam String programName) {
	public Iterable<DataValidation> fetchValidData(@RequestParam String programName, String status) {
		Iterable<DataValidation> dataValidations = null;
	  try {
			System.out.println("in controller");
			if (LOG.isInfoEnabled()) {
				LOG.info("Request received. PathVariable is: ");
			}
			
			dataValidations = this.programDataValidationService.fetchSourceData(programName, status);
			System.out.println("dataValidations : " +dataValidations);
			separateMessage(dataValidations);
			
			
			return dataValidations;
		} catch (Exception e) {
			this.peoException.initialize("amigaura", "order-error", (" " + e).trim(), e);
			this.logException.logException(this.peoException);
			return dataValidations;
		}
	}

	private DataValidation separateMessage(Iterable<DataValidation> dataValidations) {
		Iterator<DataValidation> iterator = dataValidations.iterator();
		DataValidation dataValidation = null;
		while(iterator.hasNext()){
			dataValidation = iterator.next();
			//System.out.println("dataValidation : " +dataValidation);
			String errorMessages = dataValidation.getErrorMsg();
			String errorFields = dataValidation.getError();
			
			System.out.println("errorMessages : " +errorMessages);
			
			if(null == errorMessages || "".equals(errorMessages)){
				continue;
			}
			
			if(null == errorFields || "".equals(errorFields)){
				continue;
			}
			
			System.out.println("errorMessages : " +errorMessages);
			
			StringTokenizer stringMsgTokenizer = new StringTokenizer(errorMessages, ",");
			StringTokenizer stringFldTokenizer = new StringTokenizer(errorFields, ",");
			
			List<String> errorMsgs = new ArrayList<>();
			List<String> errorFlds = new ArrayList<>();
			
			while(stringMsgTokenizer.hasMoreTokens()){
				errorMsgs.add(stringMsgTokenizer.nextToken());
			}
			
			while(stringMsgTokenizer.hasMoreTokens()){
				errorFlds.add(stringFldTokenizer.nextToken());
			}
			System.out.println("errorMsgs: "+errorMsgs);
			System.out.println("errorFlds: "+errorFlds);
			
			dataValidation.setErrorMessage(errorMsgs);
			dataValidation.setErrorFields(errorFlds);
		}
		return dataValidation;
	}


	
}