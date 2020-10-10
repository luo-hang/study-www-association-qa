package com.shiant.study.core.adviser.dao;

import java.util.List;

import com.shiant.common.exception.DaoException;
import com.shiant.study.core.adviser.model.Adviser;

public interface AdviserDao {
	
	List<Adviser> getAdvisersByAbility(int from,int size,String ability) throws DaoException;

}
