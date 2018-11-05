package com.cisco.peo.repository;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.cisco.peo.bean.ApprovalDetail;


public interface ProgramApprovalDetailRepository extends JpaRepository<ApprovalDetail, String>{
	
	@Query("SELECT ad from ApprovalDetail ad WHERE ad.approver=?1")
	public Iterable<ApprovalDetail> fetchAdminDetail(String userId);

	@Query("SELECT ad from ApprovalDetail ad WHERE ad.uploadedBy=?1")
	public Iterable<ApprovalDetail> fetchUserDetail(String userId);
	
	@Transactional
	@Modifying
	@Query("UPDATE ApprovalDetail ad SET ad.status= ?3, ad.approverComment=?2 WHERE ad.programName IN ?1")
	public void editApprovalDetail(List<String> programName, String approverComment, String flag);
	
	@Query("SELECT ad from ApprovalDetail ad WHERE ad.status= ?2 and ad.theatre = ?5 and ad.uploadedBy=?1 and ad.uploadedOn BETWEEN ?3 and ?4")
	public Iterable<ApprovalDetail> fetchUserFilteredDetail(String userId, String batchStatus,String fromUpload, String toUpload, String theatre);

	@Query("SELECT ad from ApprovalDetail ad WHERE ad.status= ?2 and ad.theatre = ?5 and ad.approver=?1 and ad.uploadedOn BETWEEN ?3 and ?4")
	public Iterable<ApprovalDetail> fetchAdminFilteredDetail(String userId, String batchStatus, String fromUpload,
			String toUpload, String theatre);
	
	
}
