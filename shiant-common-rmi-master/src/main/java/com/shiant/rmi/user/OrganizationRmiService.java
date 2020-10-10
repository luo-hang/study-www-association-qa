package com.shiant.rmi.user;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.shiant.common.exception.ServiceException;
import com.shiant.rmi.user.vo.OrganizationRmiVo;
import com.shiant.rmi.user.vo.UserRmiVo;

public interface OrganizationRmiService{

	/**
	 * <p> @方法描述：    根本编号获取组织机构			</p>
	 * <p> @创建人：        AkatsukiSimo Xie		</p>
	 * <p> @创建时间：    2020年4月15日 下午3:38:27	</p>
	 * <p> @修改人：        AkatsukiSimo Xie		</p>
	 * <p> @修改时间：    2020年4月15日 下午3:38:27	</p>
	 * @param id 		类型编号
	 * @param user		用户信息
	 * @return
	 * @throws ServiceException
	 */
	OrganizationRmiVo getBean(Long id,UserRmiVo user) throws ServiceException;
	
	/**
	 * <p> @方法描述：    获取组织机构				</p>
	 * <p> @创建人：        AkatsukiSimo Xie		</p>
	 * <p> @创建时间：    2020年4月15日 下午3:38:27	</p>
	 * <p> @修改人：        AkatsukiSimo Xie		</p>
	 * <p> @修改时间：    2020年4月15日 下午3:38:27	</p>
	 * @param from 			当前页
	 * @param size			每页总页数
	 * @param orgName		企业名称
	 * @param user
	 * @return
	 * @throws ServiceException
	 */
	Map<String,Object> getBeans(int from,int size,String orgName,UserRmiVo user)
			throws ServiceException;
	
	/**
	 * <p> @方法描述：    获取组织机构				</p>
	 * <p> @创建人：        AkatsukiSimo Xie		</p>
	 * <p> @创建时间：    2020年9月23日 上午10:23:39	</p>
	 * <p> @修改人：        AkatsukiSimo Xie		</p>
	 * <p> @修改时间：    2020年9月23日 上午10:23:39	</p>
	 * @param from 			当前页
	 * @param size			每页总页数
	 * @param orgName		企业名称
	 * @param status		状态
	 * @param user			用户信息
	 * @return
	 */
	Map<String, Object> getBeans(int from, int size, String orgName, Integer status, UserRmiVo user)
			throws ServiceException;

	/**
	 * <p> @方法描述：    根据当前用户获取组织机构		</p>
	 * <p> @创建人：        AkatsukiSimo Xie		</p>
	 * <p> @创建时间：    2020年7月24日 下午12:38:45	</p>
	 * <p> @修改人：        AkatsukiSimo Xie		</p>
	 * <p> @修改时间：    2020年7月24日 下午12:38:45	</p>
	 * @param from 			当前页
	 * @param size			每页总页数
	 * @param orgName		企业名称
	 * @param user			用户信息
	 * @return
	 */
	Map<String, Object> getBeansByUser(int from,int size,String orgName,UserRmiVo user)
			throws ServiceException;
	
	/**
	 * <p> @方法描述：    删除组织机构				</p>
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
	 * <p> @方法描述：    添加组织机构				</p>
	 * <p> @创建人：        AkatsukiSimo Xie		</p>
	 * <p> @创建时间：    2020年4月15日 下午3:40:03	</p>
	 * <p> @修改人：        AkatsukiSimo Xie		</p>
	 * <p> @修改时间：    2020年4月15日 下午3:40:03	</p>
	 * @param bean	组织机构
	 * @param user  用户信息
	 * @throws ServiceException
	 */
	void addBean(OrganizationRmiVo bean,UserRmiVo user) throws ServiceException;
	
	/**
	 * <p> @方法描述： 更新组织机构	            </p>
	 * <p> @创建人：        AkatsukiSimo Xie		</p>
	 * <p> @创建时间：    2020年4月15日 下午3:40:03	</p>
	 * <p> @修改人：        AkatsukiSimo Xie		</p>
	 * <p> @修改时间：    2020年4月15日 下午3:40:03	</p>
	 * @param bean	组织机构
	 * @param user 	用户信息
	 * @throws ServiceException
	 */
	void updateBean(OrganizationRmiVo bean,UserRmiVo user) throws ServiceException;

	/**
	 * <p> @方法描述：    获取当前组织机构	信息			</p>
	 * <p> @创建人：        AkatsukiSimo Xie		</p>
	 * <p> @创建时间：    2020年9月12日 上午11:22:26	</p>
	 * <p> @修改人：        AkatsukiSimo Xie		</p>
	 * <p> @修改时间：    2020年9月12日 上午11:22:26	</p>
	 * @param user	用户信息
	 * @return
	 */
	OrganizationRmiVo curOrganization(UserRmiVo user) throws ServiceException;

	/**
	 * <p> @方法描述：    根据编号获取机构列表			</p>
	 * <p> @创建人：        AkatsukiSimo Xie		</p>
	 * <p> @创建时间：    2020年10月4日 下午10:57:12	</p>
	 * <p> @修改人：        AkatsukiSimo Xie		</p>
	 * <p> @修改时间：    2020年10月4日 下午10:57:12	</p>
	 * @param orgids	机构编号
	 */
	List<OrganizationRmiVo> getBeans(List<Long> orgids) throws ServiceException;

	/**
	 * <p> @方法描述：    根据查询条件获取机构			</p>
	 * <p> @创建人：        AkatsukiSimo Xie		</p>
	 * <p> @创建时间：    2020年10月6日 下午3:24:50	</p>
	 * <p> @修改人：        AkatsukiSimo Xie		</p>
	 * <p> @修改时间：    2020年10月6日 下午3:24:50	</p>
	 * @param from 			当前页
	 * @param size			每页总页数
	 * @param orgids		机构编号
	 * @param province		机构省份
	 * @param startYear		开始成立年份
	 * @param endYear		结束成立年份
	 */
	Map<String, Object> getBeansByQuery(int from, int size, List<Long> orgids, String province, 
			Date startYear, Date endYear) throws ServiceException;


}
