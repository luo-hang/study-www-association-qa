package com.shiant.user.core.service;

import java.util.Map;

import com.shiant.common.exception.ServiceException;
import com.shiant.rmi.user.vo.RoleRmiVo;
import com.shiant.rmi.user.vo.UserRmiVo;
import com.shiant.user.core.model.Role;

public interface RoleService {

	/**
	 * <p> @方法描述：    根本编号获取角色				</p>
	 * <p> @创建人：        AkatsukiSimo Xie		</p>
	 * <p> @创建时间：    2020年4月15日 下午3:38:27	</p>
	 * <p> @修改人：        AkatsukiSimo Xie		</p>
	 * <p> @修改时间：    2020年4月15日 下午3:38:27	</p>
	 * @param id 		编号
	 * @param user		用户信息
	 * @return
	 * @throws ServiceException
	 */
	RoleRmiVo getBean(Long id,UserRmiVo user) throws ServiceException;
	
	/**
	 * <p> @方法描述：    获取角色				</p>
	 * <p> @创建人：        AkatsukiSimo Xie		</p>
	 * <p> @创建时间：    2020年4月15日 下午3:38:27	</p>
	 * <p> @修改人：        AkatsukiSimo Xie		</p>
	 * <p> @修改时间：    2020年4月15日 下午3:38:27	</p>
	 * @param from 			当前页
	 * @param size			每页总页数
	 * @param condition		其他条件
	 * @param user			用户信息
	 * @return
	 * @throws ServiceException
	 */
	Map<String,Object> getBeans(int from,int size,String condition,UserRmiVo user)
			throws ServiceException;

	/**
	 * <p> @方法描述：    删除角色					</p>
	 * <p> @创建人：        AkatsukiSimo Xie		</p>
	 * <p> @创建时间：    2020年4月15日 下午3:40:03	</p>
	 * <p> @修改人：        AkatsukiSimo Xie		</p>
	 * <p> @修改时间：    2020年4月15日 下午3:40:03	</p>
	 * @param id	配置
	 * @param user  用户信息
	 * @throws ServiceException
	 */
	void deleteBean(Long id ,UserRmiVo user) throws ServiceException;
	
	/**
	 * <p> @方法描述：    添加角色					</p>
	 * <p> @创建人：        AkatsukiSimo Xie		</p>
	 * <p> @创建时间：    2020年4月15日 下午3:40:03	</p>
	 * <p> @修改人：        AkatsukiSimo Xie		</p>
	 * <p> @修改时间：    2020年4月15日 下午3:40:03	</p>
	 * @param bean	角色信息
	 * @param user  用户信息
	 * @throws ServiceException
	 */
	void addBean(RoleRmiVo bean,UserRmiVo user) throws ServiceException;
	
	/**
	 * <p> @方法描述： 更新角色	            	</p>
	 * <p> @创建人：        AkatsukiSimo Xie		</p>
	 * <p> @创建时间：    2020年4月15日 下午3:40:03	</p>
	 * <p> @修改人：        AkatsukiSimo Xie		</p>
	 * <p> @修改时间：    2020年4月15日 下午3:40:03	</p>
	 * @param bean	角色信息
	 * @param user 	用户信息
	 * @throws ServiceException
	 */
	void updateBean(RoleRmiVo bean,UserRmiVo user) throws ServiceException;

	/**
	 * <p> @方法描述：    根本编号获取角色				</p>
	 * <p> @创建人：        AkatsukiSimo Xie		</p>
	 * <p> @创建时间：    2020年7月4日 下午6:23:01	</p>
	 * <p> @修改人：        AkatsukiSimo Xie		</p>
	 * <p> @修改时间：    2020年7月4日 下午6:23:01	</p>
	 * @param id 		编号
	 * @param user		用户信息
	 * @return
	 */
	Role findByid(Long id, UserRmiVo user) throws ServiceException;

}
