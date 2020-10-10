package com.shiant.rmi.page;

import java.util.Map;

import com.shiant.common.exception.ServiceException;
import com.shiant.rmi.page.vo.CarouselRmiVo;
import com.shiant.rmi.user.vo.UserRmiVo;

public interface CarouselRmiService{

	/**
	 * <p> @方法描述：    根本编号获取轮播				</p>
	 * <p> @创建人：        AkatsukiSimo Xie		</p>
	 * <p> @创建时间：    2020年8月28日 下午3:38:27	</p>
	 * <p> @修改人：        AkatsukiSimo Xie		</p>
	 * <p> @修改时间：    2020年8月28日 下午3:38:27	</p>
	 * @param id 		轮播编号
	 * @param user		用户信息
	 * @return
	 * @throws ServiceException
	 */
	public CarouselRmiVo getBean(Long id,UserRmiVo user) throws ServiceException;
	
	/**
	 * <p> @方法描述：    获取轮播列表				</p>
	 * <p> @创建人：        AkatsukiSimo Xie		</p>
	 * <p> @创建时间：    2020年8月28日 下午3:38:27	</p>
	 * <p> @修改人：        AkatsukiSimo Xie		</p>
	 * <p> @修改时间：    2020年8月28日 下午3:38:27	</p>
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
	 * <p> @方法描述：    根据类型获取轮播列表			</p>
	 * <p> @创建人：        AkatsukiSimo Xie		</p>
	 * <p> @创建时间：    2020年8月29日 上午11:17:30	</p>
	 * <p> @修改人：        AkatsukiSimo Xie		</p>
	 * <p> @修改时间：    2020年8月29日 上午11:17:30	</p>
	 * @param from 			当前页
	 * @param size			每页总页数
	 * @param type			类型
	 * @param keyWord		查询条件
	 * @param user			用户信息
	 * @return
	 * @throws ServiceException
	 */
	Map<String, Object> getBeansByType(int from, int size, String type, String keyWord, UserRmiVo user)
			throws ServiceException;
	
	/**
	 * <p> @方法描述：    删除轮播					</p>
	 * <p> @创建人：        AkatsukiSimo Xie		</p>
	 * <p> @创建时间：    2020年8月28日 下午3:40:03	</p>
	 * <p> @修改人：        AkatsukiSimo Xie		</p>
	 * <p> @修改时间：    2020年8月28日 下午3:40:03	</p>
	 * @param id	轮播编号
	 * @param user  用户信息
	 * @throws ServiceException
	 */
	void deleteBean(Long id ,UserRmiVo user) throws ServiceException;
	
	/**
	 * <p> @方法描述：    添加轮播					</p>
	 * <p> @创建人：        AkatsukiSimo Xie		</p>
	 * <p> @创建时间：    2020年8月28日 下午3:40:03	</p>
	 * <p> @修改人：        AkatsukiSimo Xie		</p>
	 * <p> @修改时间：    2020年8月28日 下午3:40:03	</p>
	 * @param bean	轮播信息
	 * @param user  用户信息
	 * @throws ServiceException
	 */
	Long addBean(CarouselRmiVo bean,UserRmiVo user) throws ServiceException;
	
	/**
	 * <p> @方法描述： 更新轮播	                </p>
	 * <p> @创建人：        AkatsukiSimo Xie		</p>
	 * <p> @创建时间：    2020年8月28日 下午3:40:03	</p>
	 * <p> @修改人：        AkatsukiSimo Xie		</p>
	 * <p> @修改时间：    2020年8月28日 下午3:40:03	</p>
	 * @param bean	轮播信息
	 * @param user 	用户信息
	 * @throws ServiceException
	 */
	void updateBean(CarouselRmiVo bean,UserRmiVo user) throws ServiceException;

}
