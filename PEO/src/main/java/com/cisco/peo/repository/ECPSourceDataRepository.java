package com.cisco.peo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cisco.peo.bean.DataValidation;


public interface ECPSourceDataRepository extends JpaRepository<DataValidation, String>{

	/*@Query("SELECT p FROM Program p WHERE p.programName=?1")
	public List<Program> fetchProgram(String programName);
	}*/

	@Query("SELECT dv FROM DataValidation dv WHERE dv.programName=?1 and dv.status=?2 order by dv.transNumber")
	public List<DataValidation> fetchSourceData(String programName, String status);
	
}
