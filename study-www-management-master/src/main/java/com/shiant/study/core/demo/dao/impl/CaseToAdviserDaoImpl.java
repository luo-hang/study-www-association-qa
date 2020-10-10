package com.shiant.study.core.demo.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.shiant.common.exception.DaoException;
import com.shiant.study.core.adviser.model.Adviser;
import com.shiant.study.core.demo.dao.CaseToAdviserDao;
import com.shiant.study.core.demo.model.Case;

@Repository(value = "caseToAdviserDao")
public class CaseToAdviserDaoImpl implements CaseToAdviserDao {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public List<Adviser> getAdvisersByCid(Long cid) throws DaoException {
		try{
			String jpql = "SELECT a.* FROM t_study_adviser a " + 
						  "JOIN t_study_case_to_adviser c2a ON c2a.aid = a.aid " +
						  "WHERE 1=1 AND c2a.cid = ?1 ";
			Query query = entityManager.createNativeQuery(jpql,Adviser.class);
			query.setParameter(1, cid);
			@SuppressWarnings("unchecked")
			List<Adviser> beans = query.getResultList();
			return beans;
		}catch(Exception e){
			throw new DaoException("根据案例获取顾问列表",e);
		}
	}

	@Override
	public Map<Long, Long> getCountByAid(List<Long> aids) throws DaoException {
		try{
			String jpql = "SELECT c2a.aid,count(DISTINCT c2a.cid) FROM \n" + 
					"t_study_case_to_adviser c2a \n" + 
					"WHERE  1=1 AND c2a.aid IN (?1) \n" + 
					"GROUP BY c2a.aid"; 
			Query query = entityManager.createNativeQuery(jpql);
			query.setParameter(1, aids);
			@SuppressWarnings("unchecked")
			List<Object[]> beans = query.getResultList();
			Map<Long, Long> results = new HashMap<Long, Long>();
			for(Object[] bean:beans) {
				results.put(Long.parseLong(bean[0].toString()), Long.parseLong(bean[1].toString()));
			}
			return results;
		}catch(Exception e){
			throw new DaoException("获取顾问对应案例失败",e);
		}
	}

	@Override
	public List<Case> getCasesByAid(Long aid) throws DaoException {
		try{
			String jpql = "SELECT c.* FROM t_study_case c " + 
						  "JOIN t_study_case_to_adviser c2a ON c2a.cid = c.cid " +
						  "WHERE 1=1 AND c2a.aid = ?1 ORDER BY c.create_date";
			Query query = entityManager.createNativeQuery(jpql,Case.class);
			query.setParameter(1, aid);
			@SuppressWarnings("unchecked")
			List<Case> beans = query.getResultList();
			return beans;
		}catch(Exception e){
			throw new DaoException("根据顾问获取案例列表",e);
		}
	}
	

}
