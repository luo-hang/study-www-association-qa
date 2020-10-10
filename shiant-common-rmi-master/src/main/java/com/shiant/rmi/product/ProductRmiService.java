package com.shiant.rmi.product;

import java.util.List;
import java.util.Map;

import com.shiant.common.exception.ServiceException;
import com.shiant.rmi.product.vo.ProductRmiVo;
import com.shiant.rmi.user.vo.UserRmiVo;

public interface ProductRmiService{

	/**
	 * <p> @方法描述：    根本编号获取产品			</p>
	 * <p> @创建人：        AkatsukiSimo Xie		</p>
	 * <p> @创建时间：    2020年4月15日 下午3:38:27	</p>
	 * <p> @修改人：        AkatsukiSimo Xie		</p>
	 * <p> @修改时间：    2020年4月15日 下午3:38:27	</p>
	 * @param id 		产品编号
	 * @param user		用户信息
	 * @return
	 * @throws ServiceException
	 */
	public ProductRmiVo getBean(Long id,UserRmiVo user) throws ServiceException;
	
	/**
	 * <p> @方法描述：    获取产品列表				</p>
	 * <p> @创建人：        AkatsukiSimo Xie		</p>
	 * <p> @创建时间：    2020年4月15日 下午3:38:27	</p>
	 * <p> @修改人：        AkatsukiSimo Xie		</p>
	 * <p> @修改时间：    2020年4月15日 下午3:38:27	</p>
	 * @param from 			当前页
	 * @param size			每页总页数
	 * @param keyWord		查询条件
	 * @param user
	 * @return
	 * @throws ServiceException
	 */
	Map<String,Object> getBeans(int from,int size,String keyWord,UserRmiVo user)
			throws ServiceException;
	
	/**
	 * <p> @方法描述：    删除产品					</p>
	 * <p> @创建人：        AkatsukiSimo Xie		</p>
	 * <p> @创建时间：    2020年4月15日 下午3:40:03	</p>
	 * <p> @修改人：        AkatsukiSimo Xie		</p>
	 * <p> @修改时间：    2020年4月15日 下午3:40:03	</p>
	 * @param id	产品编号
	 * @param user  用户信息
	 * @throws ServiceException
	 */
	void deleteBean(Long id ,UserRmiVo user) throws ServiceException;
	
	/**
	 * <p> @方法描述：    添加产品					</p>
	 * <p> @创建人：        AkatsukiSimo Xie		</p>
	 * <p> @创建时间：    2020年4月15日 下午3:40:03	</p>
	 * <p> @修改人：        AkatsukiSimo Xie		</p>
	 * <p> @修改时间：    2020年4月15日 下午3:40:03	</p>
	 * @param bean	产品信息
	 * @param user  用户信息
	 * @throws ServiceException
	 */
	void addBean(String bean,UserRmiVo user) throws ServiceException;
	
	/**
	 * <p> @方法描述： 更新产品	                </p>
	 * <p> @创建人：        AkatsukiSimo Xie		</p>
	 * <p> @创建时间：    2020年4月15日 下午3:40:03	</p>
	 * <p> @修改人：        AkatsukiSimo Xie		</p>
	 * <p> @修改时间：    2020年4月15日 下午3:40:03	</p>
	 * @param bean	产品信息
	 * @param user 	用户信息
	 * @throws ServiceException
	 */
	void updateBean(String bean,UserRmiVo user) throws ServiceException;

	/**
	 * <p> @方法描述：    根据组织机构获取产品数量		</p>
	 * <p> @创建人：        AkatsukiSimo Xie		</p>
	 * <p> @创建时间：    2020年7月23日 下午5:24:38	</p>
	 * <p> @修改人：        AkatsukiSimo Xie		</p>
	 * <p> @修改时间：    2020年7月23日 下午5:24:38	</p>
	 * @param orgids	组织机构编号集合
	 */
	Map<Long,Long> getCountByOrgids(List<Long> orgids) throws ServiceException;

}
