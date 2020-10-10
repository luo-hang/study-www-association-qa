package com.shiant.study.core.school.dao.impl;

import com.shiant.common.dao.impl.AbstractModelDAOImpl;
import com.shiant.common.util.StringUtil;
import com.shiant.study.core.school.dao.ISchoolDAO;
import com.shiant.study.core.school.model.School;
import com.shiant.study.core.school.vo.SchoolVo;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Repository(value = "schoolDao")
public class SchoolDAOImpl extends AbstractModelDAOImpl<School> implements ISchoolDAO {
    @PersistenceContext
    private EntityManager entityManager;

	@Override
	public List<SchoolVo> getBeans(int from, int size, String country, String schoolProperty, String degree) {
		String jpql = "SELECT s.id,s.school_name_c,s.school_name_e,s.school_img,"
				+ "s.school_logo,s.schooling,s.school_property,s.new_students_enrollment,s.school_country,"
				+ "s.province,s.city,s.school_address,s.school_about,COUNT(p.pid),GROUP_CONCAT(p.`name`) "
				+ "FROM t_study_school s "
				+ "LEFT JOIN t_study_profession p ON s.id=p.sid "
				+ "WHERE 1=1 ";
		if(StringUtil.isNotBlank(country)){
			jpql = jpql + "AND s.school_country=?1 ";
		}
		if(StringUtil.isNotBlank(schoolProperty)){
			jpql = jpql + "AND s.school_property=?2 ";
		}
		if(StringUtil.isNotBlank(degree)){
			jpql = jpql + "AND p.degree=?3 ";
		}
		jpql = jpql + "GROUP BY s.id ";
		Query query = entityManager.createNativeQuery(jpql);
		if(StringUtil.isNotBlank(country)){
			query.setParameter(1, country);
		}
		if(StringUtil.isNotBlank(schoolProperty)){
			query.setParameter(2, schoolProperty);
		}
		if(StringUtil.isNotBlank(degree)){
			query.setParameter(3, degree);
		}
		query.setFirstResult((from-1)*size);
		query.setMaxResults(size);
		@SuppressWarnings("unchecked")
		List<Object[]> results = query.getResultList();
		List<SchoolVo> vos = new ArrayList<SchoolVo>();
		for(Object[] result : results) {
			SchoolVo vo = new SchoolVo();
			if(StringUtil.isBlank(result[1])) {
				continue;
			}
			vo.setId(Long.parseLong(result[0].toString()));
			if(StringUtil.isNotBlank(result[1])) {
				vo.setSchoolNameC(result[1].toString());
			}
			if(StringUtil.isNotBlank(result[2])) {
				vo.setSchoolNameE(result[2].toString());
			}
			if(StringUtil.isNotBlank(result[3])) {
				vo.setSchoolImg(result[3].toString());
			}
			if(StringUtil.isNotBlank(result[4])) {
				vo.setSchoolLogo(result[4].toString());
			}
			if(StringUtil.isNotBlank(result[5])) {
				vo.setSchooLing(result[5].toString());
			}
			if(StringUtil.isNotBlank(result[6])) {
				vo.setSchoolProperty(result[6].toString());
			}
			if(StringUtil.isNotBlank(result[7])) {
				vo.setStudentsEnrollment(result[7].toString());
			}
			if(StringUtil.isNotBlank(result[8])) {
				vo.setSchoolCountry(result[8].toString());
			}
			if(StringUtil.isNotBlank(result[9])) {
				vo.setProvince(result[9].toString());
			}
			if(StringUtil.isNotBlank(result[10])) {
				vo.setCity(result[10].toString());
			}
			if(StringUtil.isNotBlank(result[11])) {
				vo.setSchoolAddress(result[11].toString());
			}
			if(StringUtil.isNotBlank(result[12])) {
				vo.setSchoolAbout(result[12].toString());
			}
			if(StringUtil.isNotBlank(result[13])) {
				vo.setProfessionNum(Long.parseLong(result[13].toString()));
			}
			if(StringUtil.isNotBlank(result[14])) {
				vo.setProfession(result[14].toString());
			}
			vos.add(vo);
		}
		return vos;
	}

	@Override
	public Long count(String country, String schoolProperty, String degree) {
		String jpql = "SELECT COUNT(*) FROM (SELECT COUNT(s.id) "
				+ "FROM t_study_school s "
				+ "LEFT JOIN t_study_profession p ON s.id=p.sid "
				+ "WHERE 1=1 ";
		if(StringUtil.isNotBlank(country)){
			jpql = jpql + "AND s.school_country=?1 ";
		}
		if(StringUtil.isNotBlank(schoolProperty)){
			jpql = jpql + "AND s.school_property=?2 ";
		}
		if(StringUtil.isNotBlank(degree)){
			jpql = jpql + "AND p.degree=?3 ";
		}
		jpql = jpql + "GROUP BY s.id ) a";
		Query query = entityManager.createNativeQuery(jpql);
		if(StringUtil.isNotBlank(country)){
			query.setParameter(1, country);
		}
		if(StringUtil.isNotBlank(schoolProperty)){
			query.setParameter(2, schoolProperty);
		}
		if(StringUtil.isNotBlank(degree)){
			query.setParameter(3, degree);
		}
		return Long.parseLong(query.getSingleResult().toString());
	}
}
