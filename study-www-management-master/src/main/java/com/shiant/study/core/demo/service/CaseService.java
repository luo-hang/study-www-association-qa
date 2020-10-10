package com.shiant.study.core.demo.service;

import java.util.Map;

import com.shiant.common.exception.ServiceException;
import com.shiant.rmi.user.vo.UserRmiVo;
import com.shiant.study.core.demo.vo.CaseVo;

public interface CaseService {

	/**
	 * <p> @方法描述：    根本编号获取案例				</p>
	 * <p> @创建人：        AkatsukiSimo Xie		</p>
	 * <p> @创建时间：    2020年9月18日 下午3:38:27	</p>
	 * <p> @修改人：        AkatsukiSimo Xie		</p>
	 * <p> @修改时间：    2020年9月18日 下午3:38:27	</p>
	 * @param id 		案例编号
	 * @param user		用户信息
	 * @return
	 * @throws ServiceException
	 */
	CaseVo getBean(Long id,UserRmiVo user) throws ServiceException;
	
	/**
	 * <p> @方法描述：    获取平台案例				</p>
	 * <p> @创建人：        AkatsukiSimo Xie		</p>
	 * <p> @创建时间：    2020年9月18日 下午3:38:27	</p>
	 * <p> @修改人：        AkatsukiSimo Xie		</p>
	 * <p> @修改时间：    2020年9月18日 下午3:38:27	</p>
	 * @param from 			当前页
	 * @param size			每页总页数
	 * @param keyWord		查询条件
	 * @param isPublic		是否上架
	 * @param user
	 * @return
	 * @throws ServiceException
	 */
	Map<String, Object> getBeans(int from,int size,String keyWord,Boolean isPublic,UserRmiVo user)
			throws ServiceException;
	
	/**
	 * <p> @方法描述：    删除案例					</p>
	 * <p> @创建人：        AkatsukiSimo Xie		</p>
	 * <p> @创建时间：    2020年9月18日 下午3:40:03	</p>
	 * <p> @修改人：        AkatsukiSimo Xie		</p>
	 * <p> @修改时间：    2020年9月18日 下午3:40:03	</p>
	 * @param id	案例编号
	 * @param user  用户信息
	 * @throws ServiceException
	 */
	void deleteBean(Long id ,UserRmiVo user) throws ServiceException;
	
	/**
	 * <p> @方法描述：    下架案例					</p>
	 * <p> @创建人：        AkatsukiSimo Xie		</p>
	 * <p> @创建时间：    2020年9月18日 下午8:54:40	</p>
	 * <p> @修改人：        AkatsukiSimo Xie		</p>
	 * <p> @修改时间：    2020年9月18日 下午8:54:40	</p>
	 * @param id	案例编号
	 * @param user  用户信息
	 */
	void stop(Long id, UserRmiVo user) throws ServiceException;
	
	/**
	 * <p> @方法描述：    添加案例					</p>
	 * <p> @创建人：        AkatsukiSimo Xie		</p>
	 * <p> @创建时间：    2020年9月18日 下午3:40:03	</p>
	 * <p> @修改人：        AkatsukiSimo Xie		</p>
	 * <p> @修改时间：    2020年9月18日 下午3:40:03	</p>
	 * @param bean	案例信息
	 * @param user  用户信息
	 * @return 
	 * @throws ServiceException
	 */
	Long addBean(CaseVo bean,UserRmiVo user) throws ServiceException;
	
	/**
	 * <p> @方法描述： 更新案例	                </p>
	 * <p> @创建人：        AkatsukiSimo Xie		</p>
	 * <p> @创建时间：    2020年9月18日 下午3:40:03	</p>
	 * <p> @修改人：        AkatsukiSimo Xie		</p>
	 * <p> @修改时间：    2020年9月18日 下午3:40:03	</p>
	 * @param bean	案例信息
	 * @param user 	用户信息
	 * @throws ServiceException
	 */
	void updateBean(CaseVo bean,UserRmiVo user) throws ServiceException;

	/**
	 * <p> @方法描述：    增加浏览次数				</p>
	 * <p> @创建人：        AkatsukiSimo Xie		</p>
	 * <p> @创建时间：    2020年9月18日 下午1:04:19	</p>
	 * <p> @修改人：        AkatsukiSimo Xie		</p>
	 * <p> @修改时间：    2020年9月18日 下午1:04:19	</p>
	 * @param cid	案例编号
	 * @param user	用户信息
	 */
	void addShowTime(Long cid, UserRmiVo user) throws ServiceException;

	/**
	 * <p> @方法描述：    根据机构获取案例				</p>
	 * <p> @创建人：        AkatsukiSimo Xie		</p>
	 * <p> @创建时间：    2020年10月5日 下午4:49:59	</p>
	 * <p> @修改人：        AkatsukiSimo Xie		</p>
	 * <p> @修改时间：    2020年10月5日 下午4:49:59	</p>
	 * @param from		页码
	 * @param size		页长
	 * @param orgid		机构编号
	 * @return
	 */
	Map<String, Object> getBeansByOrgid(int from, int size, Long orgid) throws ServiceException;

	/**
	 * <p> @方法描述：    根据顾问获取案例				</p>
	 * <p> @创建人：        AkatsukiSimo Xie		</p>
	 * <p> @创建时间：    2020年10月5日 下午5:37:19	</p>
	 * <p> @修改人：        AkatsukiSimo Xie		</p>
	 * <p> @修改时间：    2020年10月5日 下午5:37:19	</p>
	 * @param page		页码
	 * @param limit		页长
	 * @param aid		顾问编号
	 * @return
	 */
	Map<String, Object> getBeansByAdviser(int from, int size, Long aid) throws ServiceException;

	/**
	 * <p> @方法描述：    获取热门案例				</p>
	 * <p> @创建人：        AkatsukiSimo Xie		</p>
	 * <p> @创建时间：    2020年10月7日 下午2:33:19	</p>
	 * <p> @修改人：        AkatsukiSimo Xie		</p>
	 * <p> @修改时间：    2020年10月7日 下午2:33:19	</p>
	 * @param from		页码
	 * @param size		页长
	 * @return
	 */
	Map<String, Object> getBeansByHot(int from, int size) throws ServiceException;


}
