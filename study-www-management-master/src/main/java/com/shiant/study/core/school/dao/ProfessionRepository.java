package com.shiant.study.core.school.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.shiant.study.core.school.model.Profession;

@Repository(value = "professionRepository")
public interface ProfessionRepository extends JpaRepository<Profession, Long>,JpaSpecificationExecutor<Profession>{

	Page<Profession> findBySid(Long sid, Pageable pageable);

}
