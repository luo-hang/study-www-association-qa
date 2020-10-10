package com.shiant.study.core.school.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.shiant.common.exception.ServiceException;
import com.shiant.common.util.StringUtil;
import com.shiant.study.core.school.dao.ISchoolDAO;
import com.shiant.study.core.school.dao.ISchoolDeleteRespository;
import com.shiant.study.core.school.dao.ISchoolRepository;
import com.shiant.study.core.school.model.Profession;
import com.shiant.study.core.school.model.School;
import com.shiant.study.core.school.service.ISchoolService;
import com.shiant.study.core.school.service.ProfessionService;
import com.shiant.study.core.school.transfer.ProfessionTransfer;
import com.shiant.study.core.school.transfer.SchoolTransfer;
import com.shiant.study.core.school.vo.ProfessionVo;
import com.shiant.study.core.school.vo.SchoolVo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @program: study-www-association
 * @description
 * @author: z p、
 * @create: 2020-09-17 14:55
 **/
@Service
public class SchoolServiceImpl implements ISchoolService {

    @Autowired
    private ISchoolDAO schoolDAO;

    @Autowired(required = true)
    private ISchoolRepository schoolRepository;

    @Autowired
    private ProfessionService professionService;

    @Autowired
    private ISchoolDeleteRespository deleteRespository;
    
    private static SchoolTransfer transfer = new SchoolTransfer();

    @Override
    public JSONArray getAll(School school) {
        JSONArray array = new JSONArray();
        List<School> all = schoolRepository.findAllBySchoolNameCAndSchoolNameE(school.getSchoolNameC(), school.getSchoolNameE());
        for (School sc : all) {
            array.add(sc);
        }
        return array;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public void addData(String nameC, String nameE, String schoolLogo,
                        String schoolLing, String schoolProperty, String professionNum,
                        String schoolAbout, String createDate, String updateDate) throws ServiceException {
        try {
            School sc = new School();
            sc.setSchoolNameC(nameC);
            sc.setSchoolNameE(nameE);
            sc.setSchoolLogo(schoolLogo);
            sc.setSchooLing(schoolLing);
            sc.setSchoolProperty(schoolProperty);
            sc.setSchoolAbout(schoolAbout);
            sc.setCreateDate(createDate);
            sc.setUpdateDate(updateDate);

            schoolRepository.save(sc);
        } catch (Exception e) {
            throw new ServiceException("添加数据失败!", e);
        }
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public void addData1(School school) throws ServiceException {
        try {
            School sc = new School();
            sc.setSchoolNameC(school.getSchoolNameC());
            sc.setSchoolNameE(school.getSchoolNameE());
            sc.setSchoolLogo(school.getSchoolLogo());
            sc.setSchooLing(school.getSchooLing());
            sc.setSchoolProperty(school.getSchoolProperty());
            sc.setStudentsEnrollment(school.getStudentsEnrollment());
            sc.setSchoolAddress(school.getSchoolAddress());
            sc.setSchoolAbout(school.getSchoolAbout());
            sc.setCreateDate(school.getCreateDate());
            sc.setUpdateDate(school.getUpdateDate());

            schoolRepository.save(sc);
        } catch (Exception e) {
            throw new ServiceException("更新失败!", e);
        }
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public void deleteData(String name) {
        deleteRespository.deleteSchoolBySchoolNameCStartingWith(name);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public void updateDataBySchoolNameCAndSchoolNameEAndId(School school) throws ServiceException {
        try {
            School sc = schoolRepository.findBySchoolNameCAndSchoolNameEAndId(
                    school.getSchoolNameC(),
                    school.getSchoolNameE(),
                    school.getId());

            sc.setSchoolNameE(school.getSchoolNameE());
            sc.setSchoolNameC(school.getSchoolNameC());
            sc.setSchoolLogo(school.getSchoolLogo());
            sc.setSchooLing(school.getSchooLing());
            sc.setSchoolProperty(school.getSchoolProperty());
            sc.setStudentsEnrollment(school.getStudentsEnrollment());
            sc.setSchoolAddress(school.getSchoolAddress());
            sc.setSchoolAbout(school.getSchoolAbout());
            sc.setCreateDate(school.getCreateDate());
            sc.setUpdateDate(school.getUpdateDate());

            schoolRepository.save(sc);
        } catch (NullPointerException e) {
            throw new ServiceException("更新失败，无该字段值!", e);
        } catch (Exception e) {
            throw new ServiceException("更新失败!", e);
        }
    }


    @Override
    @Transactional(propagation = Propagation.NOT_SUPPORTED)
    public JSONArray queryXxxs(School school) {
        Specification<School> specification = new Specification<School>() {
            @Override
            public Predicate toPredicate(Root<School> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder cb) {
                List<Predicate> predicates = new ArrayList<>();
                if (StringUtil.isNotBlank(school.getSchoolNameC())) {
                    predicates.add(cb.equal(root.get("schoolNameC").as(String.class), school.getSchoolNameC()));
                }
                if (StringUtil.isNotBlank(school.getSchoolNameE())) {
                    predicates.add(cb.equal(root.get("schoolNameE").as(String.class), school.getSchoolNameE()));
                }
                return cb.and(predicates.toArray(new Predicate[predicates.size()]));
            }
        };
        Sort sort = Sort.by(Sort.Direction.DESC, "createDate");
        Pageable pageable = PageRequest.of(0, 10, sort);
        List<School> content = schoolRepository.findAll(specification, pageable).getContent();

        JSONArray array = JSONArray.parseArray(JSON.toJSONString(content));
        return array;
    }

	@Override
	public JSONArray findByCountry(int from, int size, String country) throws ServiceException {
		JSONArray array = new JSONArray();
		Sort sort = Sort.by(Sort.Direction.DESC, "createDate");
		Pageable pageable = PageRequest.of(from-1, size, sort);
		Page<School> all = null;	
		if("全部".equals(country)) {
			all = schoolRepository.findAll(pageable);
		}else {
			all = schoolRepository.findBySchoolCountry(country,pageable);
		}
        for (School sc : all.getContent()) {
            array.add(sc);
        }
        return array;
	}

	@Override
	public Map<String, Object> getBeans(int from, int size, String country, String schoolProperty, String degree)
			throws ServiceException {
		try {
			Map<String, Object> maps = new HashMap<String, Object>();
			if("全部".equals(country)) {
				country = null;
			}
			List<SchoolVo> beans = schoolDAO.getBeans(from, size, country, schoolProperty, degree);
			Long count = schoolDAO.count(country, schoolProperty, degree);
			
			maps.put("beans", beans);
			maps.put("count", count);
			return maps;
		}catch(Exception e){
			throw new ServiceException("根据条件分页获取专业集合服务失败!",e);
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public SchoolVo getBeanBySid(Long id) throws ServiceException {
		try {
			School bean = schoolRepository.findById(id).orElse(null);
			SchoolVo vo = transfer.transferEntityToBaseVo(bean);
			Map<String, Object> map = professionService.getBeans(1, 100, id, null);
			vo.setProfessions((List<ProfessionVo>)map.get("beans"));
			return vo;
		}catch(Exception e){
			throw new ServiceException("根据学院编号获取学院详细信息失败!",e);
		}
	}
}
