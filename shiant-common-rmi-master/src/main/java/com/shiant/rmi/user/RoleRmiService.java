package com.shiant.rmi.user;

import java.util.Map;

import com.shiant.common.exception.ServiceException;
import com.shiant.rmi.user.vo.RoleRmiVo;
import com.shiant.rmi.user.vo.UserRmiVo;

public interface RoleRmiService{

	/**
	 * <p> @方法描述：    根本编号获取角色				</p>
	 * <p> @创建人：        AkatsukiSimo Xie		</p>
	 * <p> @创建时间：    2020年4月15日 下午3:38:27	</p>
	 * <p> @修改人：        AkatsukiSimo Xie		</p>
	 * <p> @修改时间：    2020年4月15日 下午3:38:27	</p>
	 * @param id 		类型编号
	 * @param user		用户信息
	 * @return
	 * @throws ServiceException
	 */
	RoleRmiVo getBean(Long id,UserRmiVo user) throws ServiceException;
	
	/**
	 * <p> @方法描述：    获取角色					</p>
	 * <p> @创建人：        AkatsukiSimo Xie		</p>
	 * <p> @创建时间：    2020年4月15日 下午3:38:27	</p>
	 * <p> @修改人：        AkatsukiSimo Xie		</p>
	 * <p> @修改时间：    2020年4月15日 下午3:38:27	</p>
	 * @param from 			当前页
	 * @param size			每页总页数
	 * @param condition		其他条件
	 * @param user
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
	 * @param id	配置编号
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
	 * @param bean	角色
	 * @param user  用户信息
	 * @throws ServiceException
	 */
	void addBean(String bean,UserRmiVo user) throws ServiceException;
	
	/**
	 * <p> @方法描述： 更新角色	            	</p>
	 * <p> @创建人：        AkatsukiSimo Xie		</p>
	 * <p> @创建时间：    2020年4月15日 下午3:40:03	</p>
	 * <p> @修改人：        AkatsukiSimo Xie		</p>
	 * <p> @修改时间：    2020年4月15日 下午3:40:03	</p>
	 * @param bean	角色
	 * @param user 	用户信息
	 * @throws ServiceException
	 */
	void updateBean(String bean,UserRmiVo user) throws ServiceException;
}
