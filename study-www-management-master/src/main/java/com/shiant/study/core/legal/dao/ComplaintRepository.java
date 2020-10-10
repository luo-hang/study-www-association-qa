package com.shiant.study.core.legal.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.shiant.study.core.legal.model.Complaint;

@Repository(value = "complaintRepository")
public interface ComplaintRepository extends JpaRepository<Complaint, Long>,JpaSpecificationExecutor<Complaint>{

	Page<Complaint> findByOrgid(Long orgid, Pageable pageable);

	Page<Complaint> findByOrgidAndTitleLike(Long orgid, String title, Pageable pageable);

	Page<Complaint> findByOrgidAndStatus(Long orgid, Integer status, Pageable pageable);

	Page<Complaint> findByOrgidAndTitleLikeAndStatus(Long orgid, String title, Integer status, Pageable pageable);
	
}
