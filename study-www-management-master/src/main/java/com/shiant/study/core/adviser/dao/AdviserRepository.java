package com.shiant.study.core.adviser.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.shiant.study.core.adviser.model.Adviser;

@Repository(value = "adviserRepository")
public interface AdviserRepository extends JpaRepository<Adviser, Long>,JpaSpecificationExecutor<Adviser>{

	Page<Adviser> findByNameLike(String string, Pageable pageable);

	Page<Adviser> findByOrgid(Long orgid, Pageable pageable);

	Page<Adviser> findByOrgidAndNameLike(Long orgid, String string, Pageable pageable);


}
