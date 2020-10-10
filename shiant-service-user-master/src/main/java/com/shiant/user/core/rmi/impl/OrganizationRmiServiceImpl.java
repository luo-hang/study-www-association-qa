package com.shiant.user.core.rmi.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shiant.common.exception.ServiceException;
import com.shiant.rmi.user.OrganizationRmiService;
import com.shiant.rmi.user.vo.OrganizationRmiVo;
import com.shiant.rmi.user.vo.UserRmiVo;
import com.shiant.user.core.service.OrganizationService;

@Service("organizationRmiService")
public class OrganizationRmiServiceImpl implements OrganizationRmiService{
	
	@Autowired 
	OrganizationService organizationService;

	@Override
	public OrganizationRmiVo getBean(Long id, UserRmiVo user) throws ServiceException{
		return organizationService.getBean(id, user);
	}

	@Override
	public Map<String, Object> getBeans(int from, int size, String orgName, UserRmiVo user)
			throws ServiceException{
		return organizationService.getBeans(from, size, orgName, user);
	}

	@Override
	public Map<String, Object> getBeans(int from, int size, String orgName, Integer status, UserRmiVo user)
			throws ServiceException {
		return organizationService.getBeans(from, size, orgName, status, user);
	}

	@Override
	public void deleteBean(Long id, UserRmiVo user) throws ServiceException{
		organizationService.deleteBean(id, user);
	}

	@Override
	public void addBean(OrganizationRmiVo bean, UserRmiVo user) throws ServiceException{
		organizationService.addBean(bean, user);
	}

	@Override
	public void updateBean(OrganizationRmiVo bean, UserRmiVo user) throws ServiceException{
		organizationService.updateBean(bean, user);
	}

	@Override
	public Map<String, Object> getBeansByUser(int from, int size, String orgName, UserRmiVo user) throws ServiceException {
		return organizationService.getBeansByUser(from, size, orgName, user);
	}

	@Override
	public OrganizationRmiVo curOrganization(UserRmiVo user) throws ServiceException {
		return organizationService.curOrganization(user);
	}

	@Override
	public List<OrganizationRmiVo> getBeans(List<Long> orgids) throws ServiceException {
		return organizationService.getBeans(orgids);
	}

	@Override
	public Map<String, Object> getBeansByQuery(int from, int size, List<Long> orgids, String province,
			Date startYear, Date endYear) throws ServiceException {
		return organizationService.getBeans(from,size,orgids,province,startYear,endYear);
	}

}
