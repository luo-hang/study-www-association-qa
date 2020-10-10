package com.shiant.study.core.demo.dao;

import java.util.List;
import java.util.Map;

import com.shiant.common.exception.DaoException;
import com.shiant.study.core.adviser.model.Adviser;
import com.shiant.study.core.demo.model.Case;

public interface CaseToAdviserDao {
	
	List<Adviser> getAdvisersByCid(Long cid) throws DaoException;

	Map<Long,Long> getCountByAid(List<Long> aids) throws DaoException;

	List<Case> getCasesByAid(Long aid) throws DaoException;
}
