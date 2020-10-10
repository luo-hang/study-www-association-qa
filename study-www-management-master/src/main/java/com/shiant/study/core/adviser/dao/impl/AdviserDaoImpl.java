package com.shiant.study.core.adviser.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.shiant.common.exception.DaoException;
import com.shiant.study.core.adviser.dao.AdviserDao;
import com.shiant.study.core.adviser.model.Adviser;

@Repository(value = "adviserDao")
public class AdviserDaoImpl implements AdviserDao {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public List<Adviser> getAdvisersByAbility(int from, int size, String ability) throws DaoException {
		try{
			String jpql = "SELECT a.* FROM t_study_adviser a " + 
						  "WHERE 1=1 ";
			if("留学咨询及办理".equals(ability)) {
				jpql += " AND ability_1 = '"+ability+"' ";
			}else if("背景提升".equals(ability)) {
				jpql += " AND ability_2 = '"+ability+"' ";
			}else if("艺术留学".equals(ability)) {
				jpql += " AND ability_3 = '"+ability+"' ";
			}else if("留学金融".equals(ability)) {
				jpql += " AND ability_4 = '"+ability+"' ";
			}else if("航空服务".equals(ability)) {
				jpql += " AND ability_5 = '"+ability+"' ";
			}else if("境外转学".equals(ability)) {
				jpql += " AND ability_6 = '"+ability+"' ";
			}else if("升学指导".equals(ability)) {
				jpql += " AND ability_7 = '"+ability+"' ";
			}else if("留学安全".equals(ability)) {
				jpql += " AND ability_8 = '"+ability+"' ";
			}else if("留学保险".equals(ability)) {
				jpql += " AND ability_9 = '"+ability+"' ";
			}else if("海外租房".equals(ability)) {
				jpql += " AND ability_10 = '"+ability+"' ";
			}else if("学历认证".equals(ability)) {
				jpql += " AND ability_11 = '"+ability+"' ";
			}else if("积分落户".equals(ability)) {
				jpql += " AND ability_12 = '"+ability+"' ";
			}else if("就业/创业".equals(ability)) {
				jpql += " AND ability_13 = '"+ability+"' ";
			}
			jpql += " GROUP BY a.org_id ";
			Query query = entityManager.createNativeQuery(jpql,Adviser.class);
			if(from>=0&&size>0) {
				query.setFirstResult((from-1)*size);
				query.setMaxResults(size);
			}
			@SuppressWarnings("unchecked")
			List<Adviser> beans = query.getResultList();
			return beans;
		}catch(Exception e){
			throw new DaoException("根据能力获取顾问机构",e);
		}
	}

}
