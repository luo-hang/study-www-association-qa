package com.shiant.rmi.video;

import java.util.List;
import java.util.Map;

import com.shiant.common.exception.ServiceException;
import com.shiant.rmi.user.vo.UserRmiVo;
import com.shiant.rmi.video.vo.VideoTypeRmiVo;

public interface VideoTypeRmiService{

	/**
	 * <p> @方法描述：    根本编号获取视频类型			</p>
	 * <p> @创建人：        AkatsukiSimo Xie		</p>
	 * <p> @创建时间：    2020年4月15日 下午3:38:27	</p>
	 * <p> @修改人：        AkatsukiSimo Xie		</p>
	 * <p> @修改时间：    2020年4月15日 下午3:38:27	</p>
	 * @param id 		类型编号
	 * @param user		用户信息
	 * @return
	 * @throws ServiceException
	 */
	VideoTypeRmiVo getBean(Long id,UserRmiVo user) throws ServiceException;
	
	/**
	 * <p> @方法描述：    获取视频类型				</p>
	 * <p> @创建人：        AkatsukiSimo Xie		</p>
	 * <p> @创建时间：    2020年4月15日 下午3:38:27	</p>
	 * <p> @修改人：        AkatsukiSimo Xie		</p>
	 * <p> @修改时间：    2020年4月15日 下午3:38:27	</p>
	 * @param from 			当前页
	 * @param size			每页总页数
	 * @param name			名称
	 * @param user			用户信息
	 * @return
	 * @throws ServiceException
	 */
	Map<String,Object> getBeans(int from,int size,String name,UserRmiVo user)
			throws ServiceException;
	
	/**
	 * <p> @方法描述：    获取视频类型				</p>
	 * <p> @创建人：        AkatsukiSimo Xie		</p>
	 * <p> @创建时间：    2020年8月9日 上午10:19:58	</p>
	 * <p> @修改人：        AkatsukiSimo Xie		</p>
	 * <p> @修改时间：    2020年8月9日 上午10:19:58	</p>
	 * @param from 			当前页
	 * @param size			每页总页数
	 * @param name			名称
	 * @param orgids		作者机构
	 * @param user			用户信息
	 * @return
	 */
	Map<String, Object> getBeans(int from, int size, String name, List<Long> orgids, UserRmiVo user) 
			throws ServiceException;
	
	/**
	 * <p> @方法描述：    删除视频类型				</p>
	 * <p> @创建人：        AkatsukiSimo Xie		</p>
	 * <p> @创建时间：    2020年4月15日 下午3:40:03	</p>
	 * <p> @修改人：        AkatsukiSimo Xie		</p>
	 * <p> @修改时间：    2020年4月15日 下午3:40:03	</p>
	 * @param id	视频编号
	 * @param user  用户信息
	 * @throws ServiceException
	 */
	void deleteBean(Long id ,UserRmiVo user) throws ServiceException;
	
	/**
	 * <p> @方法描述：    添加视频类型				</p>
	 * <p> @创建人：        AkatsukiSimo Xie		</p>
	 * <p> @创建时间：    2020年4月15日 下午3:40:03	</p>
	 * <p> @修改人：        AkatsukiSimo Xie		</p>
	 * <p> @修改时间：    2020年4月15日 下午3:40:03	</p>
	 * @param bean	视频类型
	 * @param user  用户信息
	 * @throws ServiceException
	 */
	void addBean(VideoTypeRmiVo bean,UserRmiVo user) throws ServiceException;
	
	/**
	 * <p> @方法描述： 更新视频类型	            </p>
	 * <p> @创建人：        AkatsukiSimo Xie		</p>
	 * <p> @创建时间：    2020年4月15日 下午3:40:03	</p>
	 * <p> @修改人：        AkatsukiSimo Xie		</p>
	 * <p> @修改时间：    2020年4月15日 下午3:40:03	</p>
	 * @param bean	视频类型
	 * @param user 	用户信息
	 * @throws ServiceException
	 */
	void updateBean(VideoTypeRmiVo bean,UserRmiVo user) throws ServiceException;

}
