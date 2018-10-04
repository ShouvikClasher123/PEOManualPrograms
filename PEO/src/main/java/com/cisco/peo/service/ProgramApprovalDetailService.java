package com.cisco.peo.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.StringTokenizer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cisco.peo.bean.ApprovalDetail;
import com.cisco.peo.bean.ProgramDetail;
import com.cisco.peo.repository.ProgramApprovalDetailRepository;

@Service
public class ProgramApprovalDetailService {
	
	@Autowired
	private ProgramStatus programStatus;
	
	@Autowired
	private ProgramApprovalDetailRepository programApprovalDetailRepository;

		public Iterable<ApprovalDetail> fetchApprovalDetail(String userId, String role){
		if(role.equals("admin")){
			userId="admin";
			return programApprovalDetailRepository.fetchAdminDetail(userId);
		}
		else{
			return programApprovalDetailRepository.fetchUserDetail(userId);
		}
	}
		
	public String formatDate(Date date){

		 String date1;
		 SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	     date1 = dateFormat.format(date);
	     
	     return date1;
		
		
	}
	
	public void saveApprovalDetail(ApprovalDetail approvalDetail) throws ParseException {
		
		approvalDetail.setApprovedOn(formatDate(new Date()));
		approvalDetail.setUploadedOn(formatDate(new Date()));
		approvalDetail.setStatus("Pending");

		programApprovalDetailRepository.save(approvalDetail);
		
	}
	
	 public void editApprovalDetail(String programNames, String flag) {
		 
		 List<String> programName = new ArrayList<String>();
		 
		 StringTokenizer stringTokenizer = new StringTokenizer(programNames, ",");
			
			while(stringTokenizer.hasMoreTokens()){
				programName.add(stringTokenizer.nextToken());
			}
			
		 
		  programApprovalDetailRepository.editApprovalDetail(programName, flag);
		 
	}

	public Iterable<ApprovalDetail> fetchFilteredDetail(String userId, String batchStatus,
			String fromUpload, String toUpload, String theatre) {
		
		if(userId.equals("admin")){
			return programApprovalDetailRepository.fetchAdminFilteredDetail(userId,batchStatus,fromUpload, toUpload, theatre);
		}
		else{
			return programApprovalDetailRepository.fetchUserFilteredDetail(userId,batchStatus,fromUpload, toUpload, theatre);
		}		
	}

}
