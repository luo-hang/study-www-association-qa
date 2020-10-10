package com.shiant.user.core.dao;

import java.util.List;
import java.util.Map;

import org.springframework.data.domain.Pageable;

import com.shiant.common.exception.DaoException;
import com.shiant.rmi.user.vo.ExpertToEnterpriseRmiVo;
import com.shiant.user.core.model.Organization;

public interface ExpertToEnterpriseDao{

	/**
	 * <p> @方法描述：    根据组织机构获取产品数量		</p>
	 * <p> @创建人：        AkatsukiSimo Xie		</p>
	 * <p> @创建时间：    2020年7月23日 下午5:24:38	</p>
	 * <p> @修改人：        AkatsukiSimo Xie		</p>
	 * <p> @修改时间：    2020年7月23日 下午5:24:38	</p>
	 * @param orgids	组织机构编号集合
	 * @return
	 */
	Map<Long, Long> getCountByOrgids(List<Long> orgids) throws DaoException;

	/**
	 * <p> @方法描述：    获取企业已绑定企业			</p>
	 * <p> @创建人：        AkatsukiSimo Xie		</p>
	 * <p> @创建时间：    2020年8月7日 上午11:57:03	</p>
	 * <p> @修改人：        AkatsukiSimo Xie		</p>
	 * <p> @修改时间：    2020年8月7日 上午11:57:03	</p>
	 * @param from			页码
	 * @param size			页长
	 * @param enterpriseid	企业编号
	 * @return 
	 */
	List<Organization> getBindBeans(int from, int size, Long enterpriseid) throws DaoException;

	/**
	 * <p> @方法描述：    获取企业未绑定企业			</p>
	 * <p> @创建人：        AkatsukiSimo Xie		</p>
	 * <p> @创建时间：    2020年8月7日 上午11:57:03	</p>
	 * <p> @修改人：        AkatsukiSimo Xie		</p>
	 * <p> @修改时间：    2020年8月7日 上午11:57:03	</p>
	 * @param from			页码
	 * @param size			页长
	 * @param enterpriseid	企业编号
	 * @param orgName		企业名称
	 * @return 
	 */
	List<Organization> getUnbindBeans(int from, int size, Long enterpriseid, String orgName) throws DaoException;

	/**
	 * <p> @方法描述：    获取已绑定企业数				</p>
	 * <p> @创建人：        AkatsukiSimo Xie		</p>
	 * <p> @创建时间：    2020年8月7日 下午1:11:12	</p>
	 * <p> @修改人：        AkatsukiSimo Xie		</p>
	 * <p> @修改时间：    2020年8月7日 下午1:11:12	</p>
	 * @param enterpriseid 	企业编号
	 * @return
	 * @throws DaoException
	 */
	Long countBindBeans(Long enterpriseid) throws DaoException;

	/**
	 * <p> @方法描述：    获取未绑定企业数				</p>
	 * <p> @创建人：        AkatsukiSimo Xie		</p>
	 * <p> @创建时间：    2020年8月7日 下午1:12:16	</p>
	 * <p> @修改人：        AkatsukiSimo Xie		</p>
	 * <p> @修改时间：    2020年8月7日 下午1:12:16	</p>
	 * @param enterpriseid 	企业编号
	 * @param orgName		机构名称
	 * @return
	 * @throws DaoException
	 */
	Long countUnbindBeans(Long enterpriseid, String orgName) throws DaoException;

	/**
	 * <p> @方法描述：   根据企业获取企业已绑定企业列表	</p>
	 * <p> @创建人：        AkatsukiSimo Xie		</p>
	 * <p> @创建时间：    2020年8月9日 上午10:29:14	</p>
	 * <p> @修改人：        AkatsukiSimo Xie		</p>
	 * <p> @修改时间：    2020年8月9日 上午10:29:14	</p>
	 * @param enterpriseid	企业编号
	 * @return
	 */
	List<ExpertToEnterpriseRmiVo> getBeansByEnterpriseid(Long enterpriseid)
			throws DaoException;
	
}
