package com.cisco.peo.bean;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="xxpeo_approval_detail")
public class ApprovalDetail {
	
	@Id
	@Column(name="program_name")
	private String programName;
	
	@Column(name="approved_on")
	private String approvedOn;
	
	@Column(name="adjustment_type")
	private String adjustmentType;
	
	@Column(name="uploaded_by")
	private String uploadedBy;
	
	@Column(name="approver")
	private String approver;
	
	@Column(name="file_name")
	private String fileName;
	
	@Column(name="total_transaction")
	private Integer totalTransaction;
	
	@Column(name="status")
	private String status;
	
	@Column(name="upload_comment")
	private String uploadComment;
	
	@Column(name="approver_comment")
	private String approverComment;
	
	@Column(name="uploaded_on")
	private String uploadedOn;
	
	@Column(name="theatre")
	private String theatre;
	
	
	
	

	public String getTheatre() {
		return theatre;
	}

	public void setTheatre(String theatre) {
		this.theatre = theatre;
	}

	public String getUploadedOn() {
		return uploadedOn;
	}

	public void setUploadedOn(String uploadedOn) {
		this.uploadedOn = uploadedOn;
	}

	public String getProgramName() {
		return programName;
	}

	public void setProgramName(String programnName) {
		this.programName = programnName;
	}

	public String getApprovedOn() {
		return approvedOn;
	}

	public void setApprovedOn(String approvedOn) {
		this.approvedOn = approvedOn;
	}

	public String getAdjustmentType() {
		return adjustmentType;
	}

	public void setAdjustmentType(String adjustmentType) {
		this.adjustmentType = adjustmentType;
	}

	public String getUploadedBy() {
		return uploadedBy;
	}

	public void setUploadedBy(String uploadedBy) {
		this.uploadedBy = uploadedBy;
	}

	public String getApprover() {
		return approver;
	}

	public void setApprover(String approver) {
		this.approver = approver;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public Integer getTotalTransaction() {
		return totalTransaction;
	}

	public void setTotalTransaction(Integer totalTransaction) {
		this.totalTransaction = totalTransaction;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getUploadComment() {
		return uploadComment;
	}

	public void setUploadComment(String uploadComment) {
		this.uploadComment = uploadComment;
	}

	public String getApproverComment() {
		return approverComment;
	}

	public void setApproverComment(String approverComment) {
		this.approverComment = approverComment;
	}

	@Override
	public String toString() {
		return "ApprovalDetail [programName=" + programName + ", approvedOn=" + approvedOn + ", adjustmentType="
				+ adjustmentType + ", uploadedBy=" + uploadedBy + ", approver=" + approver + ", fileName=" + fileName
				+ ", totalTransaction=" + totalTransaction + ", status=" + status + ", uploadComment=" + uploadComment
				+ ", approverComment=" + approverComment + ", uploadedOn=" + uploadedOn + ", theatre=" + theatre + "]";
	}

	

	
	
	
	
	
	}
