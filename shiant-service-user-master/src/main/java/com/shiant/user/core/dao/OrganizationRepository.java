package com.shiant.user.core.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.shiant.user.core.model.Organization;

@Repository(value = "organizationRepository")
public interface OrganizationRepository extends JpaRepository<Organization, Long>,JpaSpecificationExecutor<Organization>{
	
	Page<Organization> findByOrgNameLike(String orgName, Pageable pageable);

	Page<Organization> findByStatus(Integer status, Pageable pageable);

	Page<Organization> findByOrgNameLikeAndOrgNameLike(String orgName, String keyword, Pageable pageable);

	Page<Organization> findByOrgNameLikeAndStatus(String string, Integer status, Pageable pageable);

	Organization findByOrgName(String orgName);

	List<Organization> findByOrgidIn(List<Long> orgids);

	
}
