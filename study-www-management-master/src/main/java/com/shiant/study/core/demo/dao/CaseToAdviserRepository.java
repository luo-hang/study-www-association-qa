package com.shiant.study.core.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.shiant.study.core.demo.model.CaseToAdviser;

@Repository(value = "caseToAdviserRepository")
public interface CaseToAdviserRepository extends JpaRepository<CaseToAdviser, Long>,JpaSpecificationExecutor<CaseToAdviser>{

	void deleteByCid(Long cid);

}
