package com.shiant.user.core.service;

import java.util.Map;

import com.shiant.common.exception.ServiceException;
import com.shiant.rmi.user.vo.ExpertToEnterpriseRmiVo;
import com.shiant.rmi.user.vo.UserRmiVo;
import com.shiant.user.core.model.ExpertToEnterprise;

public interface ExpertToEnterpriseService {

	/**
	 * <p> @方法描述：    根据编号获取专家对应企业		</p>
	 * <p> @创建人：        AkatsukiSimo Xie		</p>
	 * <p> @创建时间：    2020年8月5日 下午3:38:27	</p>
	 * <p> @修改人：        AkatsukiSimo Xie		</p>
	 * <p> @修改时间：    2020年8月5日 下午3:38:27	</p>
	 * @param id		用户编号
	 * @param user		用户信息
	 * @return
	 * @throws ServiceException
	 */
	ExpertToEnterpriseRmiVo getBean(Long id, UserRmiVo user) throws ServiceException;
	
	/**
	 * <p> @方法描述：    根据编号获取专家对应企业		</p>
	 * <p> @创建人：        AkatsukiSimo Xie		</p>
	 * <p> @创建时间：    2020年7月4日 下午5:54:06	</p>
	 * <p> @修改人：        AkatsukiSimo Xie		</p>
	 * <p> @修改时间：    2020年7月4日 下午5:54:06	</p>
	 * @param id		用户编号
	 * @param user		用户信息
	 * @return
	 * @throws ServiceException
	 */
	ExpertToEnterprise findByid(Long id, UserRmiVo user) throws ServiceException;
	
	/**
	 * <p> @方法描述：    获取专家对应企业			</p>
	 * <p> @创建人：        AkatsukiSimo Xie		</p>
	 * <p> @创建时间：    2020年8月5日 下午3:38:27	</p>
	 * <p> @修改人：        AkatsukiSimo Xie		</p>
	 * <p> @修改时间：    2020年8月5日 下午3:38:27	</p>
	 * @param from 			当前页
	 * @param size			每页总页数
	 * @param enterpriseid	企业编号
	 * @param user			用户信息
	 * @return
	 * @throws ServiceException
	 */
	Map<String, Object> getBeans(int from, int size, Long enterpriseid, UserRmiVo user)
			throws ServiceException;
	
	/**
	 * <p> @方法描述：    获取已绑定专家对应企业		</p>
	 * <p> @创建人：        AkatsukiSimo Xie		</p>
	 * <p> @创建时间：    2020年8月5日 下午3:38:27	</p>
	 * <p> @修改人：        AkatsukiSimo Xie		</p>
	 * <p> @修改时间：    2020年8月5日 下午3:38:27	</p>
	 * @param from 			当前页
	 * @param size			每页总页数
	 * @param enterpriseid	企业编号
	 * @param user			用户信息
	 * @return
	 * @throws ServiceException
	 */
	Map<String, Object> getBindBeans(int from, int size, Long enterpriseid, UserRmiVo user)
			throws ServiceException;

	/**
	 * <p> @方法描述：    获取未绑定专家对应企业		</p>
	 * <p> @创建人：        AkatsukiSimo Xie		</p>
	 * <p> @创建时间：   2020年8月5日 下午12:58:20	</p>
	 * <p> @修改人：        AkatsukiSimo Xie		</p>
	 * <p> @修改时间：   2020年8月5日 下午12:58:20	</p>
	 * @param from 			当前页
	 * @param size			每页总页数
	 * @param enterpriseid	企业编号
	 * @param orgName		企业名称
	 * @param user			用户信息
	 * @return
	 * @throws ServiceException
	 */
	Map<String,Object> getUnbindBeans(int from, int size, Long enterpriseid, String orgName, UserRmiVo user)
			throws ServiceException;
	
	/**
	 * <p> @方法描述：    删除专家对应企业			</p>
	 * <p> @创建人：        AkatsukiSimo Xie		</p>
	 * <p> @创建时间：    2020年8月5日 下午3:40:03	</p>
	 * <p> @修改人：        AkatsukiSimo Xie		</p>
	 * <p> @修改时间：    2020年8月5日 下午3:40:03	</p>
	 * @param id	专家对应企业编号
	 * @param user  用户信息
	 * @throws ServiceException
	 */
	void deleteBean(Long id,UserRmiVo user) throws ServiceException;
	
	/**
	 * <p> @方法描述：    添加专家对应企业			</p>
	 * <p> @创建人：        AkatsukiSimo Xie		</p>
	 * <p> @创建时间：    2020年8月5日 下午3:40:03	</p>
	 * <p> @修改人：        AkatsukiSimo Xie		</p>
	 * <p> @修改时间：    2020年8月5日 下午3:40:03	</p>
	 * @param bean  专家对应企业
	 * @param user  用户信息
	 * @throws ServiceException
	 */
	void addBean(ExpertToEnterpriseRmiVo bean, UserRmiVo user) throws ServiceException;
	
	/**
	 * <p> @方法描述： 更新专家对应企业	            </p>
	 * <p> @创建人：        AkatsukiSimo Xie		</p>
	 * <p> @创建时间：    2020年8月5日 下午3:40:03	</p>
	 * <p> @修改人：        AkatsukiSimo Xie		</p>
	 * <p> @修改时间：    2020年8月5日 下午3:40:03	</p>
	 * @param bean	专家对应企业
	 * @param user	用户信息
	 * @throws ServiceException
	 */
	void updateBean(ExpertToEnterpriseRmiVo bean, UserRmiVo user) throws ServiceException;

	/**
	 * <p> @方法描述：    绑定企业与专家关系			</p>
	 * <p> @创建人：        AkatsukiSimo Xie		</p>
	 * <p> @创建时间：    2020年8月7日 上午11:23:53	</p>
	 * <p> @修改人：        AkatsukiSimo Xie		</p>
	 * <p> @修改时间：    2020年8月7日 上午11:23:53	</p>
	 * @param orgid		当前企业编号
	 * @param bindid	绑定企业编号
	 * @param user		用户信息
	 * @return
	 */
	void bind(Long orgid, Long bindid, UserRmiVo user) throws ServiceException;

	/**
	 * <p> @方法描述：    解绑企业与专家关系			</p>
	 * <p> @创建人：        AkatsukiSimo Xie		</p>
	 * <p> @创建时间：    2020年8月7日 上午11:23:53	</p>
	 * <p> @修改人：        AkatsukiSimo Xie		</p>
	 * <p> @修改时间：    2020年8月7日 上午11:23:53	</p>
	 * @param orgid		当前企业编号
	 * @param unbindid	解绑企业编号
	 * @param user		用户信息
	 * @return
	 */
	void unbind(Long orgid, Long unbindid, UserRmiVo user) throws ServiceException;


}
