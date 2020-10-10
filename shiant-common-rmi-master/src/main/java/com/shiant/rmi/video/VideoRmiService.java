package com.shiant.rmi.video;

import java.util.List;
import java.util.Map;

import com.shiant.common.exception.ServiceException;
import com.shiant.rmi.user.vo.UserRmiVo;
import com.shiant.rmi.video.vo.VideoRmiVo;

public interface VideoRmiService{

	/**
	 * <p> @方法描述：    根本编号获取视频				</p>
	 * <p> @创建人：        AkatsukiSimo Xie		</p>
	 * <p> @创建时间：    2020年4月15日 下午3:38:27	</p>
	 * <p> @修改人：        AkatsukiSimo Xie		</p>
	 * <p> @修改时间：    2020年4月15日 下午3:38:27	</p>
	 * @param id 		视频编号
	 * @param user		用户信息
	 * @return
	 * @throws ServiceException
	 */
	public VideoRmiVo getBean(Long id,UserRmiVo user) throws ServiceException;
	
	/**
	 * <p> @方法描述：    获取视频列表				</p>
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
	 * <p> @方法描述：    获取视频列表				</p>
	 * <p> @创建人：        AkatsukiSimo Xie		</p>
	 * <p> @创建时间：    2020年7月31日 下午2:52:19	</p>
	 * <p> @修改人：        AkatsukiSimo Xie		</p>
	 * <p> @修改时间：    2020年7月31日 下午2:52:19	</p>
	 * @param page		当前页
	 * @param limit		每页总页数
	 * @param title		标题
	 * @param typeid	类型
	 * @param uploaders	作者
	 * @param user		用户信息
	 * @return
	 */
	public Map<String, Object> getBeans(int page, int limit, String title, Long typeid, List<Long> uploaders, UserRmiVo user)
			throws ServiceException;
	
	/**
	 * <p> @方法描述：    删除视频					</p>
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
	 * <p> @方法描述：    添加视频					</p>
	 * <p> @创建人：        AkatsukiSimo Xie		</p>
	 * <p> @创建时间：    2020年4月15日 下午3:40:03	</p>
	 * <p> @修改人：        AkatsukiSimo Xie		</p>
	 * <p> @修改时间：    2020年4月15日 下午3:40:03	</p>
	 * @param bean	视频信息
	 * @param user  用户信息
	 * @throws ServiceException
	 */
	void addBean(VideoRmiVo bean,UserRmiVo user) throws ServiceException;
	
	/**
	 * <p> @方法描述： 更新视频	                </p>
	 * <p> @创建人：        AkatsukiSimo Xie		</p>
	 * <p> @创建时间：    2020年4月15日 下午3:40:03	</p>
	 * <p> @修改人：        AkatsukiSimo Xie		</p>
	 * <p> @修改时间：    2020年4月15日 下午3:40:03	</p>
	 * @param bean	视频信息
	 * @param user 	用户信息
	 * @throws ServiceException
	 */
	void updateBean(VideoRmiVo bean,UserRmiVo user) throws ServiceException;

	/**
	 * <p> @方法描述：    增加浏览次数				</p>
	 * <p> @创建人：        AkatsukiSimo Xie		</p>
	 * <p> @创建时间：    2020年7月2日 下午1:03:25	</p>
	 * <p> @修改人：        AkatsukiSimo Xie		</p>
	 * <p> @修改时间：    2020年7月2日 下午1:03:25	</p>
	 * @param qid	视频编号
	 * @param user	用户信息
	 */
	public void addShowTime(Long qid, UserRmiVo user) throws ServiceException;

}
