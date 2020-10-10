package com.shiant.user.core.dao.impl;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.shiant.common.exception.DaoException;
import com.shiant.common.util.StringUtil;
import com.shiant.rmi.user.vo.ExpertToEnterpriseRmiVo;
import com.shiant.user.core.dao.ExpertToEnterpriseDao;
import com.shiant.user.core.model.Organization;

@Repository(value = "expertToEnterpriseDao")
public class ExpertToEnterpriseDaoImpl implements ExpertToEnterpriseDao {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public Map<Long, Long> getCountByOrgids(List<Long> orgids) throws DaoException {
		try{
			Map<Long, Long> map = new HashMap<Long, Long>();
			String sql = "SELECT p.org_id,COUNT(p.pid) " + 
					"FROM t_buss_product p " + 
					"WHERE p.org_id IN (?1) GROUP BY p.org_id";
			Query query = entityManager.createNativeQuery(sql);
			query.setParameter(1, orgids);
			@SuppressWarnings("unchecked")
			List<Object[]> results = query.getResultList();
			for(Object[] result : results) {
				map.put(Long.parseLong(result[0].toString()), Long.parseLong(result[1].toString()));
			}
			return map;
		}catch(Exception e){
			throw new DaoException(" 根据组织机构获取产品数量数据查询失败", e) ;
		}
	}

	@Override
	public List<Organization> getBindBeans(int from, int size, Long enterpriseid) throws DaoException {
		try{
			String jpql = "SELECT DISTINCT o.* FROM t_pms_organization o " + 
					"JOIN t_pms_user u ON u.org_id = o.org_id " + 
					"JOIN t_buss_expert_to_enterprise e2e ON e2e.expert_id = u.user_id " + 
					"WHERE e2e.enterprise_id = ?1";
			Query query = entityManager.createNativeQuery(jpql,Organization.class);
			query.setParameter(1, enterpriseid.intValue());
			query.setFirstResult(from);
			query.setMaxResults(size);
			@SuppressWarnings("unchecked")
			List<Organization> beans = query.getResultList();
			return beans;
		}catch(Exception e){
			throw new DaoException("获取企业已绑定企业",e);
		}
	}

	@Override
	public Long countBindBeans(Long enterpriseid) throws DaoException {
		try{
			String jpql = "SELECT count(DISTINCT o.org_id) FROM t_pms_organization o " + 
					"JOIN t_pms_user u ON u.org_id = o.org_id " + 
					"JOIN t_buss_expert_to_enterprise e2e ON e2e.expert_id = u.user_id " + 
					"WHERE e2e.enterprise_id = ?1";
			Query query = entityManager.createNativeQuery(jpql);
			query.setParameter(1, enterpriseid.intValue());
			return ((BigInteger) query.getSingleResult()).longValue();
		}catch(Exception e){
			throw new DaoException("获取企业已绑定企业数量",e);
		}
	}

	@Override
	public List<Organization> getUnbindBeans(int from, int size, Long enterpriseid, String orgName)
			throws DaoException {
		try{
			String jpql = "SELECT o.* FROM t_pms_organization o " + 
					"WHERE o.org_id NOT IN (" + 
					"SELECT DISTINCT o.org_id FROM t_pms_organization o " + 
					"JOIN t_pms_user u ON u.org_id = o.org_id " + 
					"JOIN t_buss_expert_to_enterprise e2e ON e2e.expert_id = u.user_id " + 
					"WHERE e2e.enterprise_id = ?1)";
			if(StringUtil.isNotBlank(orgName)) {
				jpql = jpql+" AND o.org_name like ?2";
			}
			Query query = entityManager.createNativeQuery(jpql,Organization.class);
			query.setParameter(1, enterpriseid.intValue());
			if(StringUtil.isNotBlank(orgName)) {
				query.setParameter(2, "%"+orgName+"%");
			}
			query.setFirstResult(from);
			query.setMaxResults(size);
			@SuppressWarnings("unchecked")
			List<Organization> beans = query.getResultList();
			return beans;
		}catch(Exception e){
			throw new DaoException("获取企业未绑定企业",e);
		}
	}

	@Override
	public Long countUnbindBeans(Long enterpriseid, String orgName)
			throws DaoException {
		try{
			String jpql = "SELECT count(DISTINCT o.org_id) FROM t_pms_organization o " + 
					"WHERE o.org_id NOT IN (" + 
					"SELECT DISTINCT o.org_id FROM t_pms_organization o " + 
					"JOIN t_pms_user u ON u.org_id = o.org_id " + 
					"JOIN t_buss_expert_to_enterprise e2e ON e2e.expert_id = u.user_id " + 
					"WHERE e2e.enterprise_id = ?1)";
			if(StringUtil.isNotBlank(orgName)) {
				jpql = jpql+" AND o.org_name like ?2";
			}
			Query query = entityManager.createNativeQuery(jpql);
			query.setParameter(1, enterpriseid.intValue());
			if(StringUtil.isNotBlank(orgName)) {
				query.setParameter(2, "%"+orgName+"%");
			}
			return ((BigInteger) query.getSingleResult()).longValue();
		}catch(Exception e){
			throw new DaoException("获取企业未绑定企业数量",e);
		}
	}

	@Override
	public List<ExpertToEnterpriseRmiVo> getBeansByEnterpriseid(Long enterpriseid) throws DaoException {
		try{
			String jpql = "SELECT e2e.e2e_id,e2e.enterprise_id,e2e.expert_id,u.org_id " + 
					"FROM t_buss_expert_to_enterprise e2e " + 
					"JOIN t_pms_user u ON u.user_id = e2e.expert_id " + 
					"WHERE 1=1 AND e2e.enterprise_id = ?1";
			Query query = entityManager.createNativeQuery(jpql);
			query.setParameter(1, enterpriseid.intValue());
			List<ExpertToEnterpriseRmiVo> beans = new ArrayList<ExpertToEnterpriseRmiVo>();
			@SuppressWarnings("unchecked")
			List<Object[]> objects = query.getResultList();
			for(Object[] object : objects) {
				ExpertToEnterpriseRmiVo bean = new ExpertToEnterpriseRmiVo();
				bean.setE2eid(Long.parseLong(object[0].toString()));
				bean.setEnterpriseid(Long.parseLong(object[1].toString()));
				bean.setExpertid(Long.parseLong(object[2].toString()));
				bean.setExpertOrgid(Long.parseLong(object[3].toString()));
				beans.add(bean);
			}
			return beans;
		}catch(Exception e){
			throw new DaoException("根据企业获取企业已绑定企业列表",e);
		}
	}
	

}
