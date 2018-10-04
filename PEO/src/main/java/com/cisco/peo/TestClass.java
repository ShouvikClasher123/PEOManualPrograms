package com.cisco.peo;

import java.util.StringTokenizer;

import com.cisco.peo.bean.ProgramDetail;

import ch.qos.logback.classic.net.SyslogAppender;

public class TestClass {
	
	public static void main(String args[]){
		
		ProgramDetail programDetail = null;
		
		String programName = "2018_APJC_33318834527_Test1-PID Mapping";
		StringTokenizer stringTokenizer = new StringTokenizer(programName, "_");
		int position = 1;
		programDetail = new ProgramDetail();
		while(stringTokenizer.hasMoreTokens()){
			String val = stringTokenizer.nextToken();
			if(position == 1){
				programDetail.setYear(val);
				++position;
			}else if(position == 2){
				programDetail.setTerrType(val);
				++position;
			}else if(position == 3){
				programDetail.setFet(val);
				++position;
			}else if(position == 4){
				programDetail.setUniqueName(val);
			}
		}
		
		System.out.println(programDetail);
	}
	
	

}
