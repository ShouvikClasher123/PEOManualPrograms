package com.cisco.peo.controller;


import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cisco.peo.bean.ApprovalDetail;
import com.cisco.peo.bean.DataValidation;
import com.cisco.peo.exceptions.PEOException;
import com.cisco.peo.exceptions.SILogger;
import com.cisco.peo.service.ProgramApprovalDetailService;

import io.swagger.annotations.Api;


@RestController
@RequestMapping("/programApproval")
@Api(value = "Program Set-up Resource")
public class ProgramApprovalDetailController {

	private static final Logger LOG = LoggerFactory.getLogger(ProgramSetUpController.class);

	@Autowired
	private ProgramApprovalDetailService programApprovalDetailService;
	
	@Autowired
	private SILogger logException;
	
	@Autowired
	private PEOException peoException;
	
	
	@SuppressWarnings("unchecked")
	@CrossOrigin(allowCredentials = "true")
	@RequestMapping(value = "/fetchApprovalDetail", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Iterable<ApprovalDetail> fetchApprovalDetail(@RequestParam String userId, String role) {
	  try {
			System.out.println("in controller");
			if (LOG.isInfoEnabled()) {
				LOG.info("Request received. PathVariable is: ");
			}
			
			return programApprovalDetailService.fetchApprovalDetail(userId,role);
						
		} catch (Exception e) {
			this.peoException.initialize("amigaura", "order-error", (" " + e).trim(), e);
			this.logException.logException(this.peoException);
			return programApprovalDetailService.fetchApprovalDetail(userId,role);
		}
	}

	@SuppressWarnings("unchecked")
	@CrossOrigin(allowCredentials = "true")
	@PostMapping(value="/saveApprovalDetail")
	public void saveApprovalDetail(
			@RequestBody ApprovalDetail approvalDetail) {
		try {
			
			if (LOG.isInfoEnabled()) {
				LOG.info("Request received. PathVariable is: ", approvalDetail);
			}
				programApprovalDetailService.saveApprovalDetail(approvalDetail);
			
		} catch (Exception e) {
			this.peoException.initialize("amigaura", "order-error", (" " + e).trim(), e);
			this.logException.logException(this.peoException);
		}
	}
	
	@SuppressWarnings("unchecked")
	@CrossOrigin(allowCredentials = "true")
	@PostMapping(value="/editApprovalDetail")
	public void editApprovalDetail(
			@RequestParam String programName, String flag ) {
		try {
			
			if (LOG.isInfoEnabled()) {
				LOG.info("Request received. PathVariable is: ");
			}
				programApprovalDetailService.editApprovalDetail(programName, flag);
			
		} catch (Exception e) {
			this.peoException.initialize("amigaura", "order-error", (" " + e).trim(), e);
			this.logException.logException(this.peoException);
		}
	}

	@SuppressWarnings("unchecked")
	@CrossOrigin(allowCredentials = "true")
	@RequestMapping(value = "/fetchFilteredDetail", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Iterable<ApprovalDetail> fetchFilteredDetail(@RequestParam String userId, String batchStatus, String theatre, String fromUpload, String toUpload) {
	  try {
			System.out.println("in controller");
			if (LOG.isInfoEnabled()) {
				LOG.info("Request received. PathVariable is: ");
			}
			
			return programApprovalDetailService.fetchFilteredDetail(userId, batchStatus,fromUpload,toUpload,theatre);
						
		} catch (Exception e) {
			this.peoException.initialize("amigaura", "order-error", (" " + e).trim(), e);
			this.logException.logException(this.peoException);
			return programApprovalDetailService.fetchFilteredDetail(userId, batchStatus,fromUpload,toUpload, theatre);
		}
	}

	
}