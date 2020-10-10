package com.shiant.study.core.demo.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.shiant.study.core.demo.model.Case;

@Repository(value = "caseRepository")
public interface CaseRepository extends JpaRepository<Case, Long>,JpaSpecificationExecutor<Case>{

	Page<Case> findByOrgid(Long orgid, Pageable pageable);
	
	Page<Case> findByOrgidAndTitleLike(Long orgid, String title, Pageable pageable);
	
	Page<Case> findByOrgidAndIsPublic(Long orgid, boolean isPublic, Pageable pageable);

	Page<Case> findByOrgidAndTitleLikeAndIsPublic(Long orgid, String title, boolean isPublic, Pageable pageable);

}
