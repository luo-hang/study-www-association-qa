package com.shiant.study.core.whiteList.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.shiant.study.core.whiteList.model.WhiteList;


@Repository(value = "whiteListRepository")
public interface WhiteListRepository extends JpaRepository<WhiteList, Long>,JpaSpecificationExecutor<WhiteList>{

	WhiteList findByOrgid(Long orgid);

	Page<WhiteList> findByOrgNameLikeAndStatus(String string, Integer status, Pageable pageable);

	Page<WhiteList> findByOrgNameLike(String string, Pageable pageable);

	Page<WhiteList> findByStatus(Integer status, Pageable pageable);

	Page<WhiteList> findByOrgNameLikeAndStatusAndWlNo(String string, Integer status, String wlNo, Pageable pageable);

	Page<WhiteList> findByWlNo(String wlNo, Pageable pageable);

	Page<WhiteList> findByOrgNameLikeAndWlNo(String string, String wlNo, Pageable pageable);

	Page<WhiteList> findByStatusAndWlNo(Integer status, String wlNo, Pageable pageable);

	List<WhiteList> findByOrgidIn(List<Long> orgid);


}
