package com.cisco.peo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cisco.peo.bean.ProgramType;

public interface ProgramTypeRepository extends JpaRepository<ProgramType, String> {

}
