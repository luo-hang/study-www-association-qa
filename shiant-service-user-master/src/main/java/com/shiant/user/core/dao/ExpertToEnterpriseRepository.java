package com.shiant.user.core.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.shiant.user.core.model.ExpertToEnterprise;

@Repository(value = "expertToEnterpriseRepository")
public interface ExpertToEnterpriseRepository extends JpaRepository<ExpertToEnterprise, Long>,JpaSpecificationExecutor<ExpertToEnterprise>{

	Page<ExpertToEnterprise> findByEnterpriseid(Long enterpriseid, Pageable pageable);

	void deleteByExpertidAndEnterpriseid(Long userid, Long orgid);
	
}
