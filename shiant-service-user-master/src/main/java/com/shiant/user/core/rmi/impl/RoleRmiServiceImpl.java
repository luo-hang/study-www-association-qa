package com.shiant.user.core.rmi.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//import com.fsnip.rmi.RMIServiceBootStrapManager;
import com.shiant.common.exception.ServiceException;
import com.shiant.rmi.user.RoleRmiService;
import com.shiant.rmi.user.vo.RoleRmiVo;
import com.shiant.rmi.user.vo.UserRmiVo;
import com.shiant.user.core.service.RoleService;

@Service("roleRmiService")
public class RoleRmiServiceImpl  implements RoleRmiService{

	@Autowired 
	RoleService roleService;
	
	@Override
	public RoleRmiVo getBean(Long id, UserRmiVo user) throws ServiceException{
		return roleService.getBean(id, user);
	}

	@Override
	public Map<String, Object> getBeans(int from, int size, String condition, UserRmiVo user)
			throws ServiceException{
		// TODO 自动生成的方法存根
		return null;
	}

	@Override
	public void deleteBean(Long id, UserRmiVo user) throws ServiceException{
		// TODO 自动生成的方法存根
		
	}

	@Override
	public void addBean(String bean, UserRmiVo user) throws ServiceException{
		// TODO 自动生成的方法存根
		
	}

	@Override
	public void updateBean(String bean, UserRmiVo user) throws ServiceException{
		// TODO 自动生成的方法存根
		
	}


}
