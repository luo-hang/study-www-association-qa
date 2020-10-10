package com.shiant.study.core.system.service;

import java.util.Map;

import com.shiant.common.exception.ServiceException;

public interface OrganizationService {

	/**
	 * <p> @方法描述：    根据能力获取机构			</p>
	 * <p> @创建人：        AkatsukiSimo Xie		</p>
	 * <p> @创建时间：    2020年10月4日 下午9:44:18	</p>
	 * <p> @修改人：        AkatsukiSimo Xie		</p>
	 * <p> @修改时间：    2020年10月4日 下午9:44:18	</p>
	 * @param page		页码
	 * @param limit		页长
	 * @param ability	能力
	 * @return
	 */
	Map<String, Object> getBeansByAbility(int page, int limit, String ability) throws ServiceException;

	/**
	 * <p> @方法描述：    根据能力获取机构			</p>
	 * <p> @创建人：        AkatsukiSimo Xie		</p>
	 * <p> @创建时间：    2020年10月6日 下午3:09:05	</p>
	 * <p> @修改人：        AkatsukiSimo Xie		</p>
	 * <p> @修改时间：    2020年10月6日 下午3:09:05	</p>
	 * @param page		页码
	 * @param limit		页长
	 * @param province	机构位置
	 * @param country	覆盖国家
	 * @param ability	服务领域
	 * @param year		机构年限
	 * @return
	 */
	Map<String, Object> getBeansByQuery(int page, int limit, String province, String country, String ability,
			String year) throws ServiceException;


}
