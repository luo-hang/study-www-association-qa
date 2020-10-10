package com.shiant.study.core.school.service;

import java.util.Map;

import com.shiant.common.exception.ServiceException;
import com.shiant.rmi.user.vo.UserRmiVo;
import com.shiant.study.core.school.vo.ProfessionVo;

public interface ProfessionService {

	/**
	 * <p> @方法描述：    根据编号获取专业			</p>
	 * <p> @创建人：        AkatsukiSimo Xie		</p>
	 * <p> @创建时间：    2020年10月03日 下午3:38:27	</p>
	 * <p> @修改人：        AkatsukiSimo Xie		</p>
	 * <p> @修改时间：    2020年10月03日 下午3:38:27	</p>
	 * @param id 		专业编号
	 * @param user		用户信息
	 * @return
	 * @throws ServiceException
	 */
	ProfessionVo getBean(Long id,UserRmiVo user) throws ServiceException;

	/**
	 * <p> @方法描述：    获取专业					</p>
	 * <p> @创建人：        AkatsukiSimo Xie		</p>
	 * <p> @创建时间：    2020年10月03日 下午3:38:27	</p>
	 * <p> @修改人：        AkatsukiSimo Xie		</p>
	 * <p> @修改时间：    2020年10月03日 下午3:38:27	</p>
	 * @param from 			当前页
	 * @param size			每页总页数
	 * @param sid			学院编号
	 * @param user			用户信息
	 * @return
	 * @throws ServiceException
	 */
	Map<String, Object> getBeans(int from,int size,Long sid, UserRmiVo user)
			throws ServiceException;
	
	/**
	 * <p> @方法描述：    删除专业					</p>
	 * <p> @创建人：        AkatsukiSimo Xie		</p>
	 * <p> @创建时间：    2020年10月03日 下午3:40:03	</p>
	 * <p> @修改人：        AkatsukiSimo Xie		</p>
	 * <p> @修改时间：    2020年10月03日 下午3:40:03	</p>
	 * @param id	专业编号
	 * @param user  用户信息
	 * @throws ServiceException
	 */
	void deleteBean(Long id ,UserRmiVo user) throws ServiceException;
	
	/**
	 * <p> @方法描述：    添加专业					</p>
	 * <p> @创建人：        AkatsukiSimo Xie		</p>
	 * <p> @创建时间：    2020年10月03日 下午3:40:03	</p>
	 * <p> @修改人：        AkatsukiSimo Xie		</p>
	 * <p> @修改时间：    2020年10月03日 下午3:40:03	</p>
	 * @param bean	专业信息
	 * @param user  用户信息
	 * @return 
	 * @throws ServiceException
	 */
	Long addBean(ProfessionVo bean,UserRmiVo user) throws ServiceException;
	
	/**
	 * <p> @方法描述： 更新专业	                </p>
	 * <p> @创建人：        AkatsukiSimo Xie		</p>
	 * <p> @创建时间：    2020年10月03日 下午3:40:03	</p>
	 * <p> @修改人：        AkatsukiSimo Xie		</p>
	 * <p> @修改时间：    2020年10月03日 下午3:40:03	</p>
	 * @param bean	专业信息
	 * @param user 	用户信息
	 * @throws ServiceException
	 */
	void updateBean(ProfessionVo bean,UserRmiVo user) throws ServiceException;


}
