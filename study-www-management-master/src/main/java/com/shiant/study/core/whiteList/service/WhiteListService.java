package com.shiant.study.core.whiteList.service;


import java.util.List;
import java.util.Map;

import com.shiant.common.exception.ServiceException;
import com.shiant.rmi.user.vo.UserRmiVo;
import com.shiant.study.core.whiteList.vo.WhiteListVo;

public interface WhiteListService {

	/**
	 * <p> @方法描述：    获取当前用户白名单条目数据		</p>
	 * <p> @创建人：        AkatsukiSimo Xie		</p>
	 * <p> @创建时间：    2020年9月17日 下午9:56:08	</p>
	 * <p> @修改人：        AkatsukiSimo Xie		</p>
	 * <p> @修改时间：    2020年9月17日 下午9:56:08	</p>
	 * @param user	用户信息
	 * @return
	 */
	WhiteListVo getCurWhiteList(UserRmiVo user) throws ServiceException;

	/**
	 * <p> @方法描述：    修改白名单条目				</p>
	 * <p> @创建人：        AkatsukiSimo Xie		</p>
	 * <p> @创建时间：    2020年9月18日 下午3:03:00	</p>
	 * <p> @修改人：        AkatsukiSimo Xie		</p>
	 * <p> @修改时间：    2020年9月18日 下午3:03:00	</p>
	 * @param bean	白名单条目信息
	 * @param user	用户信息
	 */
	Long updateBean(WhiteListVo bean, UserRmiVo user) throws ServiceException;

	/**
	 * <p> @方法描述：    获取白名单机构列表			</p>
	 * <p> @创建人：        AkatsukiSimo Xie		</p>
	 * <p> @创建时间：    2020年9月23日 上午11:40:08	</p>
	 * <p> @修改人：        AkatsukiSimo Xie		</p>
	 * <p> @修改时间：    2020年9月23日 上午11:40:08	</p>
	 * @param from		页码
	 * @param size		页长
	 * @param wlNo		资质号
	 * @param orgName	机构名称
	 * @param status	状态
	 * @param user		用户信息
	 * @return
	 */
	Map<String, Object> getBeans(int from, int size, String wlNo, String orgName, 
			Integer status, UserRmiVo user) throws ServiceException;

	/**
	 * <p> @方法描述：    获取白名单详细信息			</p>
	 * <p> @创建人：        AkatsukiSimo Xie		</p>
	 * <p> @创建时间：    2020年9月23日 上午11:40:13	</p>
	 * <p> @修改人：        AkatsukiSimo Xie		</p>
	 * <p> @修改时间：    2020年9月23日 上午11:40:13	</p>
	 * @param id		白名单编号
	 * @param user		用户信息
	 * @return
	 */
	WhiteListVo getBean(Long id, UserRmiVo user) throws ServiceException;

	/**
	 * <p> @方法描述：    获取白名单详细信息			</p>
	 * <p> @创建人：        AkatsukiSimo Xie		</p>
	 * <p> @创建时间：    2020年9月23日 上午11:40:13	</p>
	 * <p> @修改人：        AkatsukiSimo Xie		</p>
	 * <p> @修改时间：    2020年9月23日 上午11:40:13	</p>
	 * @param orgid		机构编号
	 * @param user		用户信息
	 * @return
	 */
	WhiteListVo getBeanByOrgid(Long orgid, UserRmiVo user) throws ServiceException;

	/**
	 * <p> @方法描述：    获取白名单详细信息			</p>
	 * <p> @创建人：        AkatsukiSimo Xie		</p>
	 * <p> @创建时间：    2020年9月23日 上午11:40:13	</p>
	 * <p> @修改人：        AkatsukiSimo Xie		</p>
	 * <p> @修改时间：    2020年9月23日 上午11:40:13	</p>
	 * @param orgid		机构编号
	 * @return
	 */
	List<WhiteListVo> getBeansByOrgid(List<Long> orgid) throws ServiceException;


}
