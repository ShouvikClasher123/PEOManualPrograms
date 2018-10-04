package com.cisco.peo.bean;

import java.sql.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="XXPEO_OIC_UPLOAD_DATA")
@GenericGenerator(name="idgen", strategy="increment")
public class DataValidation {

	@Id
	@Column(name="oic_upload_data_id")
	@GeneratedValue(generator="idgen")
	private Integer oicUploadDataId;
	
	@Column(name="so_num")
	private String soNum;
	
	@Column(name="trans_number")
	private String transNumber;
	
	@Column(name="book_date_bonus_earned_date")
	private Date bookDateBonusEarnedDate;
	
	@Column(name="trx_date_bonus_paid_date")
	private Date trxDateBonusPaidDate;
	
	@Column(name="part_number")
	private String partNumber;
	
	@Column(name="sales_value_pymnt_amt")
	private Integer salesValuePymntAmt;
	
	@Column(name="split_percentage")
	private Integer splitPercentage;
	
	@Column(name="trans_group_code")
	private String transGroupCode;
	
	@Column(name="salesrep_number")
	private Integer salesrepNumber;
	
	@Column(name="share_segment_1")
	private String shareSegment1;
	
	@Column(name="territory_type")
	private String territoryType;
	
	@Column(name="hierarchy_name")
	private String hierarchyName;
	
	@Column(name="roll_up_flag")
	private String rollUpFlag;
	
	@Column(name="po_number")
	private String poNumber;
	
	@Column(name="bill_to")
	private String billTo;
	
	@Column(name="ship_to")
	private String shipTo;
	
	@Column(name="end_user")
	private String endUser;
	
	@Column(name="end_customer_country")
	private String endCustomerCountry;
	
	@Column(name="end_user_number")
	private String endUserNumber;
	
	@Column(name="deal_id")
	private Integer dealId;

	@Column(name="service_type")
	private String serviceType;
	
	@Column(name="sales_motion")
	private String salesMotion;
	
	@Column(name="currency_code")
	private String currencyCode;
	
	@Column(name="goalsheet_id")
	private Integer goalsheetId;
	
	@Column(name="bonus_type")
	private String bonusType;

	@Column(name="bonus_code")
	private String bonusCode;
	
	@Column(name="charge_to_department")
	private String chargeToDepartment;
	
	@Column(name="comments")
	private String comments;
	
	@Column(name="created_by")
	private String createdBy;
	
	@Column(name="program_name")
	private String programName;
	
	@Column(name="from_pid")
	private String fromPid;
	
	@Column(name="error_msg")
	private String errorMsg;
	
	@Column(name="error")
	private String error;
	
	@Column(name="status")
	private String status;
	
	@Column(name="last_adj_amt")
	private Integer lastAdjAmt;
	
	@Column(name="error_status")
	private String errorStatus;
	
	@Column(name="validate_link")
	private String validateLink;
	
	@Column(name="to_pid")
	private String toPid;
	
	@Column(name="fiscal_year")
	private String fiscalYear;
	
	@Column(name="source_transaction_date")
	private Date sourceTransactionDate;
	
	@Column(name="territory_name")
	private String territoryName;
	
	@Column(name="ro_flag")
	private String roFlag;
	
	@Column(name="commission_status")
	private String commissionStatus;
	
	@Column(name="rev")
	private Integer rev;
	
	@Column(name="from_sales_value_pymnt_amt")
	private Integer fromSalesValuePymntAmt;
	
	@Column(name="to_sales_value_pymnt_amt")
	private Integer toSalesValuePymntAmt;
	
	@Column(name="exception_type")
	private String exceptionType;
	
	@Column(name="seq_no")
	private Integer seqNo;
	
	public Integer getSeqNo() {
		return seqNo;
	}

	public void setSeqNo(Integer seqNo) {
		this.seqNo = seqNo;
	}

	@Transient
	private List<String> errorMessage;
	
	@Transient
	private List<String> errorFields;

	public List<String> getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(List<String> errorMessage) {
		this.errorMessage = errorMessage;
	}

	public List<String> getErrorFields() {
		return errorFields;
	}

	public void setErrorFields(List<String> errorFields) {
		this.errorFields = errorFields;
	}
	
	public String getExceptionType() {
		return exceptionType;
	}

	public void setExceptionType(String exceptionType) {
		this.exceptionType = exceptionType;
	}


	public Integer getOicUploadDataId() {
		return oicUploadDataId;
	}

	public void setOicUploadDataId(Integer oicUploadDataId) {
		this.oicUploadDataId = oicUploadDataId;
	}

	public String getSoNum() {
		return soNum;
	}

	public void setSoNum(String soNum) {
		this.soNum = soNum;
	}

	public String getTransNumber() {
		return transNumber;
	}

	public void setTransNumber(String transNumber) {
		this.transNumber = transNumber;
	}

	public Date getBookDateBonusEarnedDate() {
		return bookDateBonusEarnedDate;
	}

	public void setBookDateBonusEarnedDate(Date bookDateBonusEarnedDate) {
		this.bookDateBonusEarnedDate = bookDateBonusEarnedDate;
	}

	public Date getTrxDateBonusPaidDate() {
		return trxDateBonusPaidDate;
	}

	public void setTrxDateBonusPaidDate(Date trxDateBonusPaidDate) {
		this.trxDateBonusPaidDate = trxDateBonusPaidDate;
	}

	public String getPartNumber() {
		return partNumber;
	}

	public void setPartNumber(String partNumber) {
		this.partNumber = partNumber;
	}

	public Integer getSalesValuePymntAmt() {
		return salesValuePymntAmt;
	}

	public void setSalesValuePymntAmt(Integer salesValuePymntAmt) {
		this.salesValuePymntAmt = salesValuePymntAmt;
	}

	public Integer getSplitPercentage() {
		return splitPercentage;
	}

	public void setSplitPercentage(Integer splitPercentage) {
		this.splitPercentage = splitPercentage;
	}

	public String getTransGroupCode() {
		return transGroupCode;
	}

	public void setTransGroupCode(String transGroupCode) {
		this.transGroupCode = transGroupCode;
	}

	public Integer getSalesrepNumber() {
		return salesrepNumber;
	}

	public void setSalesrepNumber(Integer salesrepNumber) {
		this.salesrepNumber = salesrepNumber;
	}

	public String getShareSegment1() {
		return shareSegment1;
	}

	public void setShareSegment1(String shareSegment1) {
		this.shareSegment1 = shareSegment1;
	}

	public String getTerritoryType() {
		return territoryType;
	}

	public void setTerritoryType(String territoryType) {
		this.territoryType = territoryType;
	}

	public String getHierarchyName() {
		return hierarchyName;
	}

	public void setHierarchyName(String hierarchyName) {
		this.hierarchyName = hierarchyName;
	}

	public String getRollUpFlag() {
		return rollUpFlag;
	}

	public void setRollUpFlag(String rollUpFlag) {
		this.rollUpFlag = rollUpFlag;
	}

	public String getPoNumber() {
		return poNumber;
	}

	public void setPoNumber(String poNumber) {
		this.poNumber = poNumber;
	}

	public String getBillTo() {
		return billTo;
	}

	public void setBillTo(String billTo) {
		this.billTo = billTo;
	}

	public String getShipTo() {
		return shipTo;
	}

	public void setShipTo(String shipTo) {
		this.shipTo = shipTo;
	}

	public String getEndUser() {
		return endUser;
	}

	public void setEndUser(String endUser) {
		this.endUser = endUser;
	}

	public String getEndCustomerCountry() {
		return endCustomerCountry;
	}

	public void setEndCustomerCountry(String endCustomerCountry) {
		this.endCustomerCountry = endCustomerCountry;
	}

	public String getEndUserNumber() {
		return endUserNumber;
	}

	public void setEndUserNumber(String endUserNumber) {
		this.endUserNumber = endUserNumber;
	}

	public Integer getDealId() {
		return dealId;
	}

	public void setDealId(Integer dealId) {
		this.dealId = dealId;
	}

	public String getServiceType() {
		return serviceType;
	}

	public void setServiceType(String serviceType) {
		this.serviceType = serviceType;
	}

	public String getSalesMotion() {
		return salesMotion;
	}

	public void setSalesMotion(String salesMotion) {
		this.salesMotion = salesMotion;
	}

	public String getCurrencyCode() {
		return currencyCode;
	}

	public void setCurrencyCode(String currencyCode) {
		this.currencyCode = currencyCode;
	}

	public Integer getGoalsheetId() {
		return goalsheetId;
	}

	public void setGoalsheetId(Integer goalsheetId) {
		this.goalsheetId = goalsheetId;
	}

	public String getBonusType() {
		return bonusType;
	}

	public void setBonusType(String bonusType) {
		this.bonusType = bonusType;
	}

	public String getBonusCode() {
		return bonusCode;
	}

	public void setBonusCode(String bonusCode) {
		this.bonusCode = bonusCode;
	}

	public String getChargeToDepartment() {
		return chargeToDepartment;
	}

	public void setChargeToDepartment(String chargeToDepartment) {
		this.chargeToDepartment = chargeToDepartment;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getProgramName() {
		return programName;
	}

	public void setProgramName(String programName) {
		this.programName = programName;
	}

	public String getFromPid() {
		return fromPid;
	}

	public void setFromPid(String fromPid) {
		this.fromPid = fromPid;
	}

	public String getErrorMsg() {
		return errorMsg;
	}

	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Integer getLastAdjAmt() {
		return lastAdjAmt;
	}

	public void setLastAdjAmt(Integer lastAdjAmt) {
		this.lastAdjAmt = lastAdjAmt;
	}

	public String getErrorStatus() {
		return errorStatus;
	}

	public void setErrorStatus(String errorStatus) {
		this.errorStatus = errorStatus;
	}

	public String getValidateLink() {
		return validateLink;
	}

	public void setValidateLink(String validateLink) {
		this.validateLink = validateLink;
	}

	public String getToPid() {
		return toPid;
	}

	public void setToPid(String toPid) {
		this.toPid = toPid;
	}

	public String getFiscalYear() {
		return fiscalYear;
	}

	public void setFiscalYear(String fiscalYear) {
		this.fiscalYear = fiscalYear;
	}

	public Date getSourceTransactionDate() {
		return sourceTransactionDate;
	}

	public void setSourceTransactionDate(Date sourceTransactionDate) {
		this.sourceTransactionDate = sourceTransactionDate;
	}

	public String getTerritoryName() {
		return territoryName;
	}

	public void setTerritoryName(String territoryName) {
		this.territoryName = territoryName;
	}

	public String getRoFlag() {
		return roFlag;
	}

	public void setRoFlag(String roFlag) {
		this.roFlag = roFlag;
	}

	public String getCommissionStatus() {
		return commissionStatus;
	}

	public void setCommissionStatus(String commissionStatus) {
		this.commissionStatus = commissionStatus;
	}

	public Integer getRev() {
		return rev;
	}

	public void setRev(Integer rev) {
		this.rev = rev;
	}

	public Integer getFromSalesValuePymntAmt() {
		return fromSalesValuePymntAmt;
	}

	public void setFromSalesValuePymntAmt(Integer fromSalesValuePymntAmt) {
		this.fromSalesValuePymntAmt = fromSalesValuePymntAmt;
	}

	public Integer getToSalesValuePymntAmt() {
		return toSalesValuePymntAmt;
	}

	public void setToSalesValuePymntAmt(Integer toSalesValuePymntAmt) {
		this.toSalesValuePymntAmt = toSalesValuePymntAmt;
	}

	@Override
	public String toString() {
		return "DataValidation [oicUploadDataId=" + oicUploadDataId + ", soNum=" + soNum + ", transNumber="
				+ transNumber + ", bookDateBonusEarnedDate=" + bookDateBonusEarnedDate + ", trxDateBonusPaidDate="
				+ trxDateBonusPaidDate + ", partNumber=" + partNumber + ", salesValuePymntAmt=" + salesValuePymntAmt
				+ ", splitPercentage=" + splitPercentage + ", transGroupCode=" + transGroupCode + ", salesrepNumber="
				+ salesrepNumber + ", shareSegment1=" + shareSegment1 + ", territoryType=" + territoryType
				+ ", hierarchyName=" + hierarchyName + ", rollUpFlag=" + rollUpFlag + ", poNumber=" + poNumber
				+ ", billTo=" + billTo + ", shipTo=" + shipTo + ", endUser=" + endUser + ", endCustomerCountry="
				+ endCustomerCountry + ", endUserNumber=" + endUserNumber + ", dealId=" + dealId + ", serviceType="
				+ serviceType + ", salesMotion=" + salesMotion + ", currencyCode=" + currencyCode + ", goalsheetId="
				+ goalsheetId + ", bonusType=" + bonusType + ", bonusCode=" + bonusCode + ", chargeToDepartment="
				+ chargeToDepartment + ", comments=" + comments + ", createdBy=" + createdBy + ", programName="
				+ programName + ", fromPid=" + fromPid + ", errorMsg=" + errorMsg + ", error=" + error + ", status="
				+ status + ", lastAdjAmt=" + lastAdjAmt + ", errorStatus=" + errorStatus + ", validateLink="
				+ validateLink + ", toPid=" + toPid + ", fiscalYear=" + fiscalYear + ", sourceTransactionDate="
				+ sourceTransactionDate + ", territoryName=" + territoryName + ", roFlag=" + roFlag
				+ ", commissionStatus=" + commissionStatus + ", rev=" + rev + ", fromSalesValuePymntAmt="
				+ fromSalesValuePymntAmt + ", toSalesValuePymntAmt=" + toSalesValuePymntAmt + ", exceptionType="
				+ exceptionType + ", seqNo=" + seqNo + ", errorMessage=" + errorMessage + ", errorFields=" + errorFields
				+ "]";
	}

	
}
