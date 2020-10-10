package com.shiant.user.core.rmi.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shiant.common.exception.ServiceException;
import com.shiant.rmi.user.ExpertToEnterpriseRmiService;
import com.shiant.rmi.user.vo.ExpertToEnterpriseRmiVo;
import com.shiant.rmi.user.vo.UserRmiVo;
import com.shiant.user.core.service.ExpertToEnterpriseService;

@Service("expertToEnterpriseRmiService")
public class ExpertToEnterpriseRmiServiceImpl implements ExpertToEnterpriseRmiService{
	
	@Autowired 
	ExpertToEnterpriseService expertToEnterpriseService;

	@Override
	public ExpertToEnterpriseRmiVo getBean(Long id, UserRmiVo user) throws ServiceException{
		return expertToEnterpriseService.getBean(id, user);
	}

	@Override
	public Map<String, Object> getBeans(int from, int size, Long enterpriseid, UserRmiVo user)
			throws ServiceException{
		return expertToEnterpriseService.getBeans(from, size, enterpriseid, user);
	}

	@Override
	public Map<String, Object> getBindBeans(int from, int size, Long enterpriseid, UserRmiVo user)
			throws ServiceException{
		return expertToEnterpriseService.getBindBeans(from, size, enterpriseid, user);
	}

	@Override
	public Map<String, Object> getUnbindBeans(int from, int size, Long enterpriseid, String orgName, UserRmiVo user)
			throws ServiceException{
		return expertToEnterpriseService.getUnbindBeans(from, size, enterpriseid, orgName, user);
	}

	@Override
	public void bind(Long orgid, Long bindid, UserRmiVo user) throws ServiceException {
		expertToEnterpriseService.bind(orgid,bindid,user);
	}

	@Override
	public void unbind(Long orgid, Long unbindid, UserRmiVo user) throws ServiceException {
		expertToEnterpriseService.unbind(orgid,unbindid,user);
	}


}
