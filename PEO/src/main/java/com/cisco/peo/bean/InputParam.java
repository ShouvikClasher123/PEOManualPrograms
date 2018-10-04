package com.cisco.peo.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="xxpeo_program_params_val")
@GenericGenerator(name="idgen", strategy="increment")
public class InputParam {
	
	/*@Id
	@Column(name="program_id")
	@GeneratedValue(generator="idgen")
	private Integer programId;
	*/
	@Column(name="so_num")
	private String soNum;
	
	@Column(name="territory_type")
	private String territoryType;
	
	@Column(name="from_pid")
	private String fromPid;
	
	@Column(name="trans_group_code")
	private String transGroupCode;
	
	@Id
	@Column(name="program_name")
	private String programName;
	
	/*@Column(name="program_param_name")
	private String programParamName;
	
	@Column(name="program_param_val")
	private String programParamVal;*/

	@Column(name="to_pid")
	private String toPid;

	
	/*public Integer getProgramId() {
		return programId;
	}

	public void setProgramId(Integer programId) {
		this.programId = programId;
	}
*/
	public String getSoNum() {
		return soNum;
	}

	public void setSoNum(String soNum) {
		this.soNum = soNum;
	}

	public String getTerritoryType() {
		return territoryType;
	}

	public void setTerritoryType(String territoryType) {
		this.territoryType = territoryType;
	}

	public String getFromPid() {
		return fromPid;
	}

	public void setFromPid(String fromPid) {
		this.fromPid = fromPid;
	}

	public String getTransGroupCode() {
		return transGroupCode;
	}

	public void setTransGroupCode(String transGroupCode) {
		this.transGroupCode = transGroupCode;
	}

	public String getProgramName() {
		return programName;
	}

	public void setProgramName(String programName) {
		this.programName = programName;
	}

	/*public String getProgramParamName() {
		return programParamName;
	}

	public void setProgramParamName(String programParamName) {
		this.programParamName = programParamName;
	}

	public String getProgramParamVal() {
		return programParamVal;
	}

	public void setProgramParamVal(String programParamVal) {
		this.programParamVal = programParamVal;
	}
*/	

	public String getToPid() {
		return toPid;
	}

	public void setToPid(String toPid) {
		this.toPid = toPid;
	}

	@Override
	public String toString() {
		return "InputParam [ soNum=" + soNum + ", territoryType=" + territoryType
				+ ", fromPid=" + fromPid + ", transGroupCode=" + transGroupCode + ", programName=" + programName
				+ ", toPid=" + toPid + "]";
	}

	
	
	}
