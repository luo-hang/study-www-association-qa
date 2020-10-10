package com.shiant.rmi.user;

import java.util.Map;

import com.shiant.common.exception.ServiceException;
import com.shiant.rmi.user.vo.UserRmiVo;

public interface UserRmiService{

	/**
	 * <p> @方法描述：    根本编号获取用户				</p>
	 * <p> @创建人：        AkatsukiSimo Xie		</p>
	 * <p> @创建时间：    2020年4月15日 下午3:38:27	</p>
	 * <p> @修改人：        AkatsukiSimo Xie		</p>
	 * <p> @修改时间：    2020年4月15日 下午3:38:27	</p>
	 * @param id 		用户编号
	 * @param user		用户信息
	 * @return
	 * @throws ServiceException
	 */
	UserRmiVo getBean(Long id,UserRmiVo user) throws ServiceException;
	
	/**
	 * <p> @方法描述：    获取用户					</p>
	 * <p> @创建人：        AkatsukiSimo Xie		</p>
	 * <p> @创建时间：    2020年4月15日 下午3:38:27	</p>
	 * <p> @修改人：        AkatsukiSimo Xie		</p>
	 * <p> @修改时间：    2020年4月15日 下午3:38:27	</p>
	 * @param from 			当前页
	 * @param size			每页总页数
	 * @param userName		账号名
	 * @param phone 		手机号
	 * @param roleid 		角色
	 * @param user			用户信息
	 * @return
	 * @throws ServiceException
	 */
	Map<String,Object> getBeans(int from,int size,String userName,String phone, Long roleid, UserRmiVo user)
			throws ServiceException;
	
	/**
	 * <p> @方法描述：    删除用户					</p>
	 * <p> @创建人：        AkatsukiSimo Xie		</p>
	 * <p> @创建时间：    2020年4月15日 下午3:40:03	</p>
	 * <p> @修改人：        AkatsukiSimo Xie		</p>
	 * <p> @修改时间：    2020年4月15日 下午3:40:03	</p>
	 * @param id	配置编号
	 * @param user  用户信息
	 * @throws ServiceException
	 */
	void deleteBean(Long id ,UserRmiVo user) throws ServiceException;
	
	/**
	 * <p> @方法描述：    添加用户					</p>
	 * <p> @创建人：        AkatsukiSimo Xie		</p>
	 * <p> @创建时间：    2020年4月15日 下午3:40:03	</p>
	 * <p> @修改人：        AkatsukiSimo Xie		</p>
	 * <p> @修改时间：    2020年4月15日 下午3:40:03	</p>
	 * @param bean	用户
	 * @param user  用户信息
	 * @throws ServiceException
	 */
	void addBean(UserRmiVo bean,UserRmiVo user) throws ServiceException;
	
	/**
	 * <p> @方法描述： 更新用户	            	</p>
	 * <p> @创建人：        AkatsukiSimo Xie		</p>
	 * <p> @创建时间：    2020年4月15日 下午3:40:03	</p>
	 * <p> @修改人：        AkatsukiSimo Xie		</p>
	 * <p> @修改时间：    2020年4月15日 下午3:40:03	</p>
	 * @param bean	用户
	 * @param user 	用户信息
	 * @throws ServiceException
	 */
	void updateBean(UserRmiVo bean,UserRmiVo user) throws ServiceException;

	/**
	 * <p> @方法描述： 	  重置密码	            	</p>
	 * <p> @创建人：        AkatsukiSimo Xie		</p>
	 * <p> @创建时间：    2020年4月15日 下午3:40:03	</p>
	 * <p> @修改人：        AkatsukiSimo Xie		</p>
	 * <p> @修改时间：    2020年4月15日 下午3:40:03	</p>
	 * @param bean	用户信息
	 * @throws ServiceException
	 */
	void resetPassword(UserRmiVo bean) throws ServiceException;
	
	/**
	 * <p> @方法描述：    查询并注册账号				</p>
	 * <p> @创建人：        AkatsukiSimo Xie		</p>
	 * <p> @创建时间：    2020年4月15日 下午3:40:03	</p>
	 * <p> @修改人：        AkatsukiSimo Xie		</p>
	 * <p> @修改时间：    2020年4月15日 下午3:40:03	</p>
	 * @param bean	用户
	 * @param user 	用户信息
	 * @throws ServiceException
	 */
	UserRmiVo getBeanWithAdd(UserRmiVo bean,UserRmiVo user) throws ServiceException;

	/**
	 * <p> @方法描述：    根据用户账号获取已注册的用户	</p>
	 * <p> @创建人：        AkatsukiSimo Xie		</p>
	 * <p> @创建时间：    2020年9月25日 下午11:20:10	</p>
	 * <p> @修改人：        AkatsukiSimo Xie		</p>
	 * <p> @修改时间：    2020年9月25日 下午11:20:10	</p>
	 * @param userName	用户账号
	 * @param user		用户信息
	 * @return
	 * @throws ServiceException
	 */
	UserRmiVo getHasBeanByUserName(String userName, UserRmiVo user) throws ServiceException;
}
