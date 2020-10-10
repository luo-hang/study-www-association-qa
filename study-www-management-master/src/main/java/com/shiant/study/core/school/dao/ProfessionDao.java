package com.shiant.study.core.school.dao;

import java.util.List;


import com.shiant.common.exception.DaoException;
import com.shiant.study.core.legal.model.Complaint;
import com.shiant.study.core.school.model.Profession;

public interface ProfessionDao {
	
	List<Profession> getBeans(int from, int size, Long orgid, String creater, 
			String title, String orgName, Integer status) throws DaoException;

	Long countBeans(Long orgid, String creater, String title, String orgName,
			Integer status) throws DaoException;

}
