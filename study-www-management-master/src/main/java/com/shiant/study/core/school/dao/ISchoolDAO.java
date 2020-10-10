package com.shiant.study.core.school.dao;

import com.shiant.common.dao.AbstractModelDAO;
import com.shiant.study.core.school.model.School;
import com.shiant.study.core.school.vo.SchoolVo;


import java.util.List;

public interface ISchoolDAO  extends AbstractModelDAO<School> {

	List<SchoolVo> getBeans(int from, int size, String country, String schoolProperty, String degree);

	Long count(String country, String schoolProperty, String degree);
}
