package com.shiant.study.core.school.dao.impl;

import java.math.BigInteger;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.shiant.common.exception.DaoException;
import com.shiant.common.util.StringUtil;
import com.shiant.study.core.legal.dao.ComplaintDao;
import com.shiant.study.core.legal.model.Complaint;
import com.shiant.study.core.school.dao.ProfessionDao;
import com.shiant.study.core.school.model.Profession;

@Repository(value = "professionDao")
public class ProfessionDaoImpl implements ProfessionDao {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public List<Profession> getBeans(int from, int size, Long orgid, String creater, String title, String orgName,
			Integer status) throws DaoException {
		try{
			String jpql = "SELECT c FROM t_study_complaint c " + 
					"WHERE 1=1 ";
			if(orgid!=null) {
				jpql = jpql+" AND c.orgid = ?1 ";
			}
			if(status!=null) {
				jpql = jpql+" AND c.status = ?2 ";
			}
			if(StringUtil.isNotBlank(creater)) {
				jpql = jpql+" AND c.creater like ?3 ";
			}
			if(StringUtil.isNotBlank(title)) {
				jpql = jpql+" AND c.title like ?4 ";
			}
			if(StringUtil.isNotBlank(orgName)) {
				jpql = jpql+" AND c.orgName like ?5 ";
			}
			jpql = jpql+" ORDER BY c.createDate ";
			Query query = entityManager.createQuery(jpql);
			if(orgid!=null) {
				query.setParameter(1, orgid);
			}
			if(status!=null) {
				query.setParameter(2, status);
			}
			if(StringUtil.isNotBlank(creater)) {
				query.setParameter(3, "%"+creater+"%");
			}
			if(StringUtil.isNotBlank(title)) {
				query.setParameter(4, "%"+title+"%");
			}
			if(StringUtil.isNotBlank(orgName)) {
				query.setParameter(5, "%"+orgName+"%");
			}
			query.setFirstResult(from);
			query.setMaxResults(size);
			@SuppressWarnings("unchecked")
			List<Profession> beans = query.getResultList();
			return beans;
		}catch(Exception e){
			throw new DaoException("获取投诉列表",e);
		}
	}

	@Override
	public Long countBeans(Long orgid, String creater, String title, String orgName, Integer status)
			throws DaoException {
		try{
			String jpql = "SELECT count(DISTINCT c.cid) FROM t_study_complaint c " + 
					"WHERE 1=1 ";
			if(orgid!=null) {
				jpql = jpql+" AND c.org_id = ?1 ";
			}
			if(status!=null) {
				jpql = jpql+" AND c.status = ?2 ";
			}
			if(StringUtil.isNotBlank(creater)) {
				jpql = jpql+" AND c.creater like ?3 ";
			}
			if(StringUtil.isNotBlank(title)) {
				jpql = jpql+" AND c.title like ?4 ";
			}
			if(StringUtil.isNotBlank(orgName)) {
				jpql = jpql+" AND c.org_name like ?5 ";
			}
			Query query = entityManager.createNativeQuery(jpql);
			if(orgid!=null) {
				query.setParameter(1, orgid);
			}
			if(status!=null) {
				query.setParameter(2, status);
			}
			if(StringUtil.isNotBlank(creater)) {
				query.setParameter(3, "%"+creater+"%");
			}
			if(StringUtil.isNotBlank(title)) {
				query.setParameter(4, "%"+title+"%");
			}
			if(StringUtil.isNotBlank(orgName)) {
				query.setParameter(5, "%"+orgName+"%");
			}
			return ((BigInteger) query.getSingleResult()).longValue();
		}catch(Exception e){
			throw new DaoException("获取投诉列表数量",e);
		}
	}
	

}
