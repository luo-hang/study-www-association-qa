package com.shiant.study.core.adviser.service;

import java.util.List;
import java.util.Map;

import com.shiant.common.exception.ServiceException;
import com.shiant.rmi.user.vo.UserRmiVo;
import com.shiant.study.core.adviser.model.Adviser;
import com.shiant.study.core.adviser.vo.AdviserVo;

public interface AdviserService {

	/**
	 * <p> @方法描述：    根本编号获取顾问				</p>
	 * <p> @创建人：        AkatsukiSimo Xie		</p>
	 * <p> @创建时间：    2020年9月18日 下午3:38:27	</p>
	 * <p> @修改人：        AkatsukiSimo Xie		</p>
	 * <p> @修改时间：    2020年9月18日 下午3:38:27	</p>
	 * @param id 		顾问编号
	 * @param user		用户信息
	 * @return
	 * @throws ServiceException
	 */
	AdviserVo getBean(Long id,UserRmiVo user) throws ServiceException;
	
	/**
	 * <p> @方法描述：    获取顾问					</p>
	 * <p> @创建人：        AkatsukiSimo Xie		</p>
	 * <p> @创建时间：    2020年9月18日 下午3:38:27	</p>
	 * <p> @修改人：        AkatsukiSimo Xie		</p>
	 * <p> @修改时间：    2020年9月18日 下午3:38:27	</p>
	 * @param from 			当前页
	 * @param size			每页总页数
	 * @param name			名字
	 * @param orgid			组织机构
	 * @return
	 * @throws ServiceException
	 */
	Map<String, Object> getBeans(int from,int size,String name,Long orgid)
			throws ServiceException;
	
	/**
	 * <p> @方法描述：    删除顾问					</p>
	 * <p> @创建人：        AkatsukiSimo Xie		</p>
	 * <p> @创建时间：    2020年9月18日 下午3:40:03	</p>
	 * <p> @修改人：        AkatsukiSimo Xie		</p>
	 * <p> @修改时间：    2020年9月18日 下午3:40:03	</p>
	 * @param id	顾问编号
	 * @param user  用户信息
	 * @throws ServiceException
	 */
	void deleteBean(Long id ,UserRmiVo user) throws ServiceException;
	
	/**
	 * <p> @方法描述：    下架顾问					</p>
	 * <p> @创建人：        AkatsukiSimo Xie		</p>
	 * <p> @创建时间：    2020年9月18日 下午8:54:40	</p>
	 * <p> @修改人：        AkatsukiSimo Xie		</p>
	 * <p> @修改时间：    2020年9月18日 下午8:54:40	</p>
	 * @param id	顾问编号
	 * @param user  用户信息
	 */
	void stop(Long id, UserRmiVo user) throws ServiceException;
	
	/**
	 * <p> @方法描述：    添加顾问					</p>
	 * <p> @创建人：        AkatsukiSimo Xie		</p>
	 * <p> @创建时间：    2020年9月18日 下午3:40:03	</p>
	 * <p> @修改人：        AkatsukiSimo Xie		</p>
	 * <p> @修改时间：    2020年9月18日 下午3:40:03	</p>
	 * @param bean	顾问信息
	 * @param user  用户信息
	 * @return 
	 * @throws ServiceException
	 */
	Long addBean(AdviserVo bean,UserRmiVo user) throws ServiceException;
	
	/**
	 * <p> @方法描述： 更新顾问	                </p>
	 * <p> @创建人：        AkatsukiSimo Xie		</p>
	 * <p> @创建时间：    2020年9月18日 下午3:40:03	</p>
	 * <p> @修改人：        AkatsukiSimo Xie		</p>
	 * <p> @修改时间：    2020年9月18日 下午3:40:03	</p>
	 * @param bean	顾问信息
	 * @param user 	用户信息
	 * @throws ServiceException
	 */
	void updateBean(AdviserVo bean,UserRmiVo user) throws ServiceException;

	/**
	 * <p> @方法描述：    增加浏览次数				</p>
	 * <p> @创建人：        AkatsukiSimo Xie		</p>
	 * <p> @创建时间：    2020年9月18日 下午1:04:19	</p>
	 * <p> @修改人：        AkatsukiSimo Xie		</p>
	 * <p> @修改时间：    2020年9月18日 下午1:04:19	</p>
	 * @param cid	顾问编号
	 * @param user	用户信息
	 */
	void addShowTime(Long cid, UserRmiVo user) throws ServiceException;

	/**
	 * <p> @方法描述：    根据案例编号获取顾问			</p>
	 * <p> @创建人：        AkatsukiSimo Xie		</p>
	 * <p> @创建时间：    2020年9月23日 下午7:26:04	</p>
	 * <p> @修改人：        AkatsukiSimo Xie		</p>
	 * <p> @修改时间：    2020年9月23日 下午7:26:04	</p>
	 * @param cid	案例编号
	 * @param user	用户信息
	 * @return
	 */
	List<AdviserVo> getBeansByCid(Long cid, UserRmiVo user) throws ServiceException;

	/**
	 * <p> @方法描述：    根据能力获取顾问对应机构		</p>
	 * <p> @创建人：        AkatsukiSimo Xie		</p>
	 * <p> @创建时间：    2020年10月04日 下午7:26:04	</p>
	 * <p> @修改人：        AkatsukiSimo Xie		</p>
	 * <p> @修改时间：    2020年10月04日 下午7:26:04	</p>
	 * @param from 			当前页
	 * @param size			每页总页数
	 * @param ability		能力
	 * @return
	 */
	List<Adviser> getBeansByAbility(int from,int size,String ability) throws ServiceException;
}
