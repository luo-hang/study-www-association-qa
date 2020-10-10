package com.shiant.user.core.service.impl;

import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaBuilder.In;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

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

import com.shiant.common.exception.ServiceException;
import com.shiant.common.util.StringUtil;
import com.shiant.rmi.user.vo.OrganizationRmiVo;
import com.shiant.rmi.user.vo.UserRmiVo;
import com.shiant.user.core.dao.OrganizationRepository;
import com.shiant.user.core.model.Organization;
import com.shiant.user.core.service.OrganizationService;
import com.shiant.user.core.transfer.OrganizationTransfer;


@Service(value = "/organizationService")
public class OrganizationServiceImpl implements OrganizationService {

	@Autowired
	private OrganizationRepository organizationRepository;
	
	private static OrganizationTransfer transfer = new OrganizationTransfer();
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public Organization addBean(OrganizationRmiVo bean, UserRmiVo user) throws ServiceException {
		try {
			Organization entity = transfer.transferVoToEntity(bean);
			entity.setOrgid(null);
			entity.setCreateDate(new Date());
			entity.setCreater(user.getUserRealName());
			entity.setUpdateDate(new Date());
			entity.setUpdater(user.getUserRealName());
			return organizationRepository.save(entity);
		} catch (ServiceException e) {
			if (e.getErrorMsg() ==  null) {
				e.setErrorMsg("添加组织机构失败");
			}
			throw e;
		} catch (Exception e) {
			throw new ServiceException("添加组织机构失败", e);
		}
	}

	@Override
	@Transactional(propagation = Propagation.NOT_SUPPORTED)
	public Map<String, Object> getBeans(int from,int size,String orgName,UserRmiVo user)
			throws ServiceException {
		try {
			Map<String,Object> maps = new HashMap<>();
			if(StringUtil.isNotBlank(orgName)) {
				orgName = URLDecoder.decode(URLDecoder.decode(orgName, "utf8"), "utf8");
			}
			Sort sort = Sort.by(Direction.DESC, "createDate");
			Pageable pageable = PageRequest.of(from-1, size, sort);
			Page<Organization> beans = null;
			if(StringUtil.isNotBlank(orgName)) {
				beans = organizationRepository.findByOrgNameLike("%"+orgName+"%", pageable);
			}else {
				beans = organizationRepository.findAll(pageable);
			}
			
			if(beans.getSize()>0) {
				maps.put("beans", transfer.transferCollectionEntityToBaseVos(beans.getContent()));
			}else {
				maps.put("beans",new ArrayList<>());
			}
			maps.put("total", beans.getTotalElements());
			maps.put("totalPages", beans.getTotalPages());
			return maps;
		}catch(ServiceException e){
			if(e.getErrorMsg() == null){
				e.setErrorMsg("根据条件分页获取组织机构集合");
			}
			throw new ServiceException(e.getErrorMsg(),e);
		}catch(Exception e){
			throw new ServiceException("根据条件分页获取组织机构集合失败!",e);
		}
	}

	@Override
	@Transactional(propagation = Propagation.NOT_SUPPORTED)
	public Map<String, Object> getBeans(int from,int size,String orgName,Integer status, UserRmiVo user)
			throws ServiceException {
		try {
			Map<String,Object> maps = new HashMap<>();
			if(StringUtil.isNotBlank(orgName)) {
				orgName = URLDecoder.decode(URLDecoder.decode(orgName, "utf8"), "utf8");
			}
			Sort sort = Sort.by(Direction.DESC, "createDate");
			Pageable pageable = PageRequest.of(from-1, size, sort);
			Page<Organization> beans = null;
			
			if(StringUtil.isNotBlank(orgName)) {
				if(StringUtil.isNotBlank(status)) {
					beans = organizationRepository.findByOrgNameLikeAndStatus("%"+orgName+"%", status, pageable);
				}else {
					beans = organizationRepository.findByOrgNameLike("%"+orgName+"%", pageable);
				}
			}else {
				if(StringUtil.isNotBlank(status)) {
					beans = organizationRepository.findByStatus(status, pageable);
				}else {
					beans = organizationRepository.findAll(pageable);
				}
			}
			
			if(beans.getSize()>0) {
				maps.put("beans", transfer.transferCollectionEntityToBaseVos(beans.getContent()));
			}else {
				maps.put("beans",new ArrayList<>());
			}
			maps.put("total", beans.getTotalElements());
			maps.put("totalPages", beans.getTotalPages());
			return maps;
		}catch(ServiceException e){
			if(e.getErrorMsg() == null){
				e.setErrorMsg("根据条件分页获取组织机构集合");
			}
			throw new ServiceException(e.getErrorMsg(),e);
		}catch(Exception e){
			throw new ServiceException("根据条件分页获取组织机构集合失败!",e);
		}
	}
	
	@Override
	@Transactional(propagation = Propagation.NOT_SUPPORTED)
	public Map<String, Object> getBeansByUser(int from, int size, String orgName, UserRmiVo user) throws ServiceException {
		try {
			Map<String,Object> maps = new HashMap<>();
			Sort sort = Sort.by(Direction.ASC, "orgid");
			Pageable pageable = PageRequest.of(from-1, size, sort);
			Page<Organization> beans = null;
			if(user.getOrgid() == 1L) {
				if(StringUtil.isNotBlank(orgName)) {
					beans = organizationRepository.findByOrgNameLike("%"+orgName+"%", pageable);
				}else {
					beans = organizationRepository.findAll(pageable);
				}
			}else{
				if(StringUtil.isNotBlank(orgName)) {
					beans = organizationRepository.findByOrgNameLikeAndOrgNameLike(user.getOrgName()+"%","%"+orgName+"%",pageable);
				}else {
					beans = organizationRepository.findByOrgNameLike(user.getOrgName()+"%",pageable);
				}
			}
			
			if(beans.getSize()>0) {
				maps.put("beans", transfer.transferCollectionEntityToBaseVos(beans.getContent()));
			}else {
				maps.put("beans",new ArrayList<>());
			}
			maps.put("total", beans.getTotalElements());
			maps.put("totalPages", beans.getTotalPages());
			return maps;
		}catch(ServiceException e){
			if(e.getErrorMsg() == null){
				e.setErrorMsg("根据条件分页获取组织机构集合");
			}
			throw new ServiceException(e.getErrorMsg(),e);
		}catch(Exception e){
			throw new ServiceException("根据条件分页获取组织机构集合失败!",e);
		}
	}

	@Override
	@Transactional(propagation = Propagation.NOT_SUPPORTED,rollbackFor = Exception.class)
	public OrganizationRmiVo getBean(Long id, UserRmiVo user) throws ServiceException {
		try {
			return transfer.transferEntityToBaseVo(organizationRepository.findById(id).orElse(null));
		}catch(Exception e){
			throw new ServiceException("根据组织机构编号获取实体失败!",e);
		}
	}
	
	@Override
	@Transactional(propagation = Propagation.NOT_SUPPORTED,rollbackFor = Exception.class)
	public Organization findByid(Long id, UserRmiVo user) throws ServiceException {
		try {
			return organizationRepository.findById(id).orElse(null);
		}catch(Exception e){
			throw new ServiceException("根据组织机构编号获取实体失败",e);
		}
	}

	@Override
	@Transactional(propagation = Propagation.NOT_SUPPORTED,rollbackFor = Exception.class)
	public Organization findByName(String orgName, UserRmiVo user) throws ServiceException {
		try {
			return organizationRepository.findByOrgName(orgName);
		}catch(Exception e){
			throw new ServiceException("根据组织机构名称获取实体失败",e);
		}
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
	public void deleteBean(Long id,UserRmiVo user) throws ServiceException {
		try {
			organizationRepository.deleteById(id);
		} catch (Exception e) {
			throw new ServiceException("删除组织机构失败",e);
		}
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
	public void updateBean(OrganizationRmiVo vo, UserRmiVo user) throws ServiceException {
		try {
			Organization bean = organizationRepository.findById(vo.getOrgid()).orElse(null);
			if(bean != null) {
				bean.setUpdater(user.getUserRealName());
				bean.setUpdateDate(new Date());
				if(StringUtil.isNotBlank(vo.getAddress())) {
					bean.setAddress(vo.getAddress());
				}
				if(StringUtil.isNotBlank(vo.getCity())) {
					bean.setCity(vo.getCity());
				}
				if(StringUtil.isNotBlank(vo.getCounty())) {
					bean.setCounty(vo.getCounty());
				}
				if(StringUtil.isNotBlank(vo.getCustomerNum())) {
					bean.setCustomerNum(vo.getCustomerNum());
				}
				if(StringUtil.isNotBlank(vo.getIndustry())) {
					bean.setIndustry(vo.getIndustry());
				}
				if(StringUtil.isNotBlank(vo.getLegalPerson())) {
					bean.setLegalPerson(vo.getLegalPerson());
				}
				if(StringUtil.isNotBlank(vo.getLegalPersonPhone())) {
					bean.setLegalPersonPhone(vo.getLegalPersonPhone());
				}
				if(StringUtil.isNotBlank(vo.getOrgCode())) {
					bean.setOrgCode(vo.getOrgCode());
				}
				if(StringUtil.isNotBlank(vo.getOrgName())) {
					bean.setOrgName(vo.getOrgName());
				}
				if(StringUtil.isNotBlank(vo.getOrgLogo())) {
					bean.setOrgLogo(vo.getOrgLogo());
				}
				if(StringUtil.isNotBlank(vo.getOrgScale())) {
					bean.setOrgScale(vo.getOrgScale());
				}
				if(StringUtil.isNotBlank(vo.getProvince())) {
					bean.setProvince(vo.getProvince());
				}
				if(StringUtil.isNotBlank(vo.getBusinessLicense())) {
					bean.setBusinessLicense(vo.getBusinessLicense());
				}
				if(StringUtil.isNotBlank(vo.getConsultationPhone())) {
					bean.setConsultationPhone(vo.getConsultationPhone());
				}
				if(StringUtil.isNotBlank(vo.getFoundDate())) {
					bean.setFoundDate(vo.getFoundDate());
				}
				if(StringUtil.isNotBlank(vo.getLegalPersonIdCard())) {
					bean.setLegalPersonIdCard(vo.getLegalPersonIdCard());
				}
				if(StringUtil.isNotBlank(vo.getOrgIntroduction())) {
					bean.setOrgIntroduction(vo.getOrgIntroduction());
				}
				if(StringUtil.isNotBlank(vo.getQq())) {
					bean.setQq(vo.getQq());
				}
				if(StringUtil.isNotBlank(vo.getStatus())) {
					bean.setStatus(vo.getStatus());
				}
				if(StringUtil.isNotBlank(vo.getReason())) {
					bean.setReason(vo.getReason());
				}
				if(StringUtil.isNotBlank(vo.getVerifyDate())) {
					bean.setVerifyDate(vo.getVerifyDate());
				}
				if(StringUtil.isNotBlank(vo.getWebsite())) {
					bean.setWebsite(vo.getWebsite());
				}
				if(StringUtil.isNotBlank(vo.getWechat())) {
					bean.setWechat(vo.getWechat());
				}
				if(StringUtil.isNotBlank(vo.getWechatMp())) {
					bean.setWechatMp(vo.getWechatMp());
				}
				if(StringUtil.isNotBlank(vo.getWechatMpQrCode())) {
					bean.setWechatMpQrCode(vo.getWechatMpQrCode());
				}
				if(StringUtil.isNotBlank(vo.getWechatQrCode())) {
					bean.setWechatQrCode(vo.getWechatQrCode());
				}
				if(StringUtil.isNotBlank(vo.getWeibo())) {
					bean.setWeibo(vo.getWeibo());
				}
			}else {
				throw new ServiceException("未找到对应组织机构信息");
			}
		} catch (ServiceException e) {
			throw e;
		} catch(Exception e){
			throw new ServiceException("更新组织机构失败",e);
		}
	}

	@Override
	@Transactional(propagation = Propagation.NOT_SUPPORTED,rollbackFor = Exception.class)
	public OrganizationRmiVo curOrganization(UserRmiVo user) throws ServiceException {
		try {
			return transfer.transferEntityToBaseVo(
					organizationRepository.findById(user.getOrgid()).orElse(null));
		}catch(Exception e){
			throw new ServiceException("获取当前组织机构信息失败!",e);
		}
	}

	@Override
	@Transactional(propagation = Propagation.NOT_SUPPORTED,rollbackFor = Exception.class)
	public List<OrganizationRmiVo> getBeans(List<Long> orgids) throws ServiceException {
		try {
			List<Organization> beans = organizationRepository.findByOrgidIn(orgids);
			List<OrganizationRmiVo> orgs = new ArrayList<>();
			if(!beans.isEmpty()) {
				orgs.addAll(transfer.transferCollectionEntityToBaseVos(beans));
			}
			return orgs;
		}catch(ServiceException e){
			if(e.getErrorMsg() == null){
				e.setErrorMsg("根据编号获取机构列表集合失败");
			}
			throw new ServiceException(e.getErrorMsg(),e);
		}catch(Exception e){
			throw new ServiceException("根据编号获取机构列表集合失败!",e);
		}
	}

	@Override
	@Transactional(propagation = Propagation.NOT_SUPPORTED,rollbackFor = Exception.class)
	public Map<String,Object> getBeans(int from, int size, List<Long> orgids, String province,
			Date startYear, Date endYear) throws ServiceException {
		try {
			Map<String,Object> maps = new HashMap<>();
			Sort sort = Sort.by(Direction.DESC, "createDate");
			Pageable pageable = PageRequest.of(from-1, size, sort);
			@SuppressWarnings("serial")
			Specification<Organization> specification = new Specification<Organization>() {
				@Override
				public Predicate toPredicate(Root<Organization> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder cb) {
					List<Predicate> predicates = new ArrayList<>();
					if (StringUtil.isNotBlank(orgids)) {
						In<Long> in = cb.in(root.get("orgid"));
						for(Long orgid : orgids) {
							in.value(orgid);
						}
						predicates.add(in);
					}
					if (StringUtil.isNotBlank(province)) {
						predicates.add(cb.equal(root.get("province").as(String.class), province));
					}
					if (StringUtil.isNotBlank(startYear)) {
						predicates.add(cb.greaterThanOrEqualTo(root.get("foundDate").as(Date.class), startYear));
					}
					if (StringUtil.isNotBlank(endYear)) {
						predicates.add(cb.lessThanOrEqualTo(root.get("foundDate").as(Date.class), endYear));
					}
					return cb.and(predicates.toArray(new Predicate[predicates.size()]));
				}
		 	};
		 	Page<Organization> beans = organizationRepository.findAll(specification,pageable);
			
			if(beans.getSize()>0) {
				maps.put("beans", transfer.transferCollectionEntityToBaseVos(beans.getContent()));
			}else {
				maps.put("beans",new ArrayList<>());
			}
			maps.put("total", beans.getTotalElements());
			maps.put("totalPages", beans.getTotalPages());
			return maps;
		}catch(ServiceException e){
			if(e.getErrorMsg() == null){
				e.setErrorMsg("根据查询条件获取机构失败");
			}
			throw new ServiceException(e.getErrorMsg(),e);
		}catch(Exception e){
			throw new ServiceException("根据查询条件获取机构失败",e);
		}
	}

}
