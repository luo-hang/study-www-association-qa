package com.shiant.study.core.legal.service;

import java.util.Map;

import com.shiant.common.exception.ServiceException;
import com.shiant.rmi.user.vo.UserRmiVo;
import com.shiant.study.core.legal.vo.ComplaintVo;

public interface ComplaintService {

	/**
	 * <p> @方法描述：    根据编号获取投诉				</p>
	 * <p> @创建人：        AkatsukiSimo Xie		</p>
	 * <p> @创建时间：    2020年9月18日 下午3:38:27	</p>
	 * <p> @修改人：        AkatsukiSimo Xie		</p>
	 * <p> @修改时间：    2020年9月18日 下午3:38:27	</p>
	 * @param id 		投诉编号
	 * @param user		用户信息
	 * @return
	 * @throws ServiceException
	 */
	ComplaintVo getBean(Long id,UserRmiVo user) throws ServiceException;
	
	/**
	 * <p> @方法描述：    获取平台投诉				</p>
	 * <p> @创建人：        AkatsukiSimo Xie		</p>
	 * <p> @创建时间：    2020年9月18日 下午3:38:27	</p>
	 * <p> @修改人：        AkatsukiSimo Xie		</p>
	 * <p> @修改时间：    2020年9月18日 下午3:38:27	</p>
	 * @param from 			当前页
	 * @param size			每页总页数
	 * @param creater		用户账号
	 * @param title         投诉标题
	 * @param orgName       投诉机构
	 * @param status		状态
	 * @param user
	 * @return
	 * @throws ServiceException
	 */
	Map<String, Object> getBeans(int from,int size,String creater, String title, String orgName, Integer status, UserRmiVo user)
			throws ServiceException;
	
	/**
	 * <p> @方法描述：    删除投诉					</p>
	 * <p> @创建人：        AkatsukiSimo Xie		</p>
	 * <p> @创建时间：    2020年9月18日 下午3:40:03	</p>
	 * <p> @修改人：        AkatsukiSimo Xie		</p>
	 * <p> @修改时间：    2020年9月18日 下午3:40:03	</p>
	 * @param id	投诉编号
	 * @param user  用户信息
	 * @throws ServiceException
	 */
	void deleteBean(Long id ,UserRmiVo user) throws ServiceException;
	
	/**
	 * <p> @方法描述：    添加投诉					</p>
	 * <p> @创建人：        AkatsukiSimo Xie		</p>
	 * <p> @创建时间：    2020年9月18日 下午3:40:03	</p>
	 * <p> @修改人：        AkatsukiSimo Xie		</p>
	 * <p> @修改时间：    2020年9月18日 下午3:40:03	</p>
	 * @param bean	投诉信息
	 * @param user  用户信息
	 * @return 
	 * @throws ServiceException
	 */
	Long addBean(ComplaintVo bean,UserRmiVo user) throws ServiceException;
	
	/**
	 * <p> @方法描述： 更新投诉	                </p>
	 * <p> @创建人：        AkatsukiSimo Xie		</p>
	 * <p> @创建时间：    2020年9月18日 下午3:40:03	</p>
	 * <p> @修改人：        AkatsukiSimo Xie		</p>
	 * <p> @修改时间：    2020年9月18日 下午3:40:03	</p>
	 * @param bean	投诉信息
	 * @param user 	用户信息
	 * @throws ServiceException
	 */
	void updateBean(ComplaintVo bean,UserRmiVo user) throws ServiceException;

	/**
	 * <p> @方法描述：    修改维权状态				</p>
	 * <p> @创建人：        AkatsukiSimo Xie		</p>
	 * <p> @创建时间：    2020年9月20日 下午4:18:47	</p>
	 * <p> @修改人：        AkatsukiSimo Xie		</p>
	 * <p> @修改时间：    2020年9月20日 下午4:18:47	</p>
	 * @param bean		维权实体
	 * @param user		用户信息
	 */
	void updateStatus(String bean, UserRmiVo user) throws ServiceException;


}
