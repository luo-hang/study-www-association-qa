package com.shiant.user.core.rmi.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shiant.common.exception.ServiceException;
import com.shiant.rmi.user.UserRmiService;
import com.shiant.rmi.user.vo.UserRmiVo;
import com.shiant.user.core.service.UserService;

@Service("userRmiService")
public class UserRmiServiceImpl implements UserRmiService{

	@Autowired 
	UserService userService;
	
	@Override
	public UserRmiVo getBean(Long id, UserRmiVo user) throws ServiceException{
		return userService.getBean(id, user);
	}

	@Override
	public Map<String, Object> getBeans(int from,int size,String userName,String phone, Long roleid, UserRmiVo user)
			throws ServiceException{
		return userService.getBeans(from, size, userName, phone, roleid, user);
	}
	
	@Override
	public void deleteBean(Long id, UserRmiVo user) throws ServiceException{
		userService.deleteBean(id, user);
	}

	@Override
	public void addBean(UserRmiVo bean, UserRmiVo user) throws ServiceException{
		userService.addBean(bean, user);
	}

	@Override
	public void updateBean(UserRmiVo bean, UserRmiVo user) throws ServiceException{
		userService.updateBean(bean, user);
	}

	@Override
	public void resetPassword(UserRmiVo bean) throws ServiceException {
		userService.resetPassword(bean);
	}

	@Override
	public UserRmiVo getHasBeanByUserName(String userName, UserRmiVo user) throws ServiceException{
		return userService.getHasBeanByUserName(userName,user);
	}

	@Override
	public UserRmiVo getBeanWithAdd(UserRmiVo bean, UserRmiVo user) throws ServiceException {
		return userService.getBeanWithAdd(bean,user);
	}

}
