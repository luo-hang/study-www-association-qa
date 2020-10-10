package com.shiant.rmi.course;

import java.util.List;
import java.util.Map;

import com.shiant.common.exception.ServiceException;
import com.shiant.rmi.course.vo.CourseRmiVo;
import com.shiant.rmi.user.vo.UserRmiVo;

public interface CourseRmiService{

	/**
	 * <p> @方法描述：    根本编号获取平台实训			</p>
	 * <p> @创建人：        AkatsukiSimo Xie		</p>
	 * <p> @创建时间：    2020年4月15日 下午3:38:27	</p>
	 * <p> @修改人：        AkatsukiSimo Xie		</p>
	 * <p> @修改时间：    2020年4月15日 下午3:38:27	</p>
	 * @param id 		实训编号
	 * @param user		用户信息
	 * @return
	 * @throws ServiceException
	 */
	public CourseRmiVo getBean(Long id,UserRmiVo user) throws ServiceException;
	
	/**
	 * <p> @方法描述：    获取平台实训列表				</p>
	 * <p> @创建人：        AkatsukiSimo Xie		</p>
	 * <p> @创建时间：    2020年4月15日 下午3:38:27	</p>
	 * <p> @修改人：        AkatsukiSimo Xie		</p>
	 * <p> @修改时间：    2020年4月15日 下午3:38:27	</p>
	 * @param from 			当前页
	 * @param size			每页总页数
	 * @param title			标题
	 * @param user
	 * @return
	 * @throws ServiceException
	 */
	Map<String,Object> getBeans(int from,int size,String title,UserRmiVo user)
			throws ServiceException;
	
	/**
	 * <p> @方法描述：    获取平台实训列表			</p>
	 * <p> @创建人：        AkatsukiSimo Xie		</p>
	 * <p> @创建时间：    2020年7月1日 下午5:05:01	</p>
	 * <p> @修改人：        AkatsukiSimo Xie		</p>
	 * <p> @修改时间：    2020年7月1日 下午5:05:01	</p>
	 * @param from 			当前页
	 * @param size			每页总页数
	 * @param title			标题
	 * @param expertids		作者集合
	 * @param user			用户信息
	 * @return
	 */
	public Map<String, Object> getBeans(int from, int size,
			String title, List<Long> expertids, UserRmiVo user) throws ServiceException;
	
	/**
	 * <p> @方法描述：    根据类型获取平台实训列表		</p>
	 * <p> @创建人：        AkatsukiSimo Xie		</p>
	 * <p> @创建时间：    2020年7月1日 下午5:05:01	</p>
	 * <p> @修改人：        AkatsukiSimo Xie		</p>
	 * <p> @修改时间：    2020年7月1日 下午5:05:01	</p>
	 * @param typeid		类型编号
	 * @param from 			当前页
	 * @param size			每页总页数
	 * @param keyWord		查询条件
	 * @param expertids		作者集合
	 * @param user			用户信息
	 * @return
	 */
	public Map<String, Object> getBeansByType(Long typeid, int from, int size,
			String keyWord, List<Long> expertids, UserRmiVo user) throws ServiceException;
	
	/**
	 * <p> @方法描述：    删除实训					</p>
	 * <p> @创建人：        AkatsukiSimo Xie		</p>
	 * <p> @创建时间：    2020年4月15日 下午3:40:03	</p>
	 * <p> @修改人：        AkatsukiSimo Xie		</p>
	 * <p> @修改时间：    2020年4月15日 下午3:40:03	</p>
	 * @param id	实训编号
	 * @param user  用户信息
	 * @throws ServiceException
	 */
	void deleteBean(Long id ,UserRmiVo user) throws ServiceException;
	
	/**
	 * <p> @方法描述：    添加实训					</p>
	 * <p> @创建人：        AkatsukiSimo Xie		</p>
	 * <p> @创建时间：    2020年4月15日 下午3:40:03	</p>
	 * <p> @修改人：        AkatsukiSimo Xie		</p>
	 * <p> @修改时间：    2020年4月15日 下午3:40:03	</p>
	 * @param bean	实训信息
	 * @param user  用户信息
	 * @return 
	 * @throws ServiceException
	 */
	Long addBean(CourseRmiVo bean,UserRmiVo user) throws ServiceException;
	
	/**
	 * <p> @方法描述： 更新实训	                </p>
	 * <p> @创建人：        AkatsukiSimo Xie		</p>
	 * <p> @创建时间：    2020年4月15日 下午3:40:03	</p>
	 * <p> @修改人：        AkatsukiSimo Xie		</p>
	 * <p> @修改时间：    2020年4月15日 下午3:40:03	</p>
	 * @param bean	实训信息
	 * @param user 	用户信息
	 * @throws ServiceException
	 */
	void updateBean(CourseRmiVo bean,UserRmiVo user) throws ServiceException;

	/**
	 * <p> @方法描述： 发布实训	                </p>
	 * <p> @创建人：        AkatsukiSimo Xie		</p>
	 * <p> @创建时间：    2020年4月15日 下午3:40:03	</p>
	 * <p> @修改人：        AkatsukiSimo Xie		</p>
	 * <p> @修改时间：    2020年4月15日 下午3:40:03	</p>
	 * @param id	编号
	 * @param user 	用户信息
	 * @throws ServiceException
	 */
	void publishBean(Long id,UserRmiVo user) throws ServiceException;

	/**
	 * <p> @方法描述：    存草稿					</p>
	 * <p> @创建人：        AkatsukiSimo Xie		</p>
	 * <p> @创建时间：    2020年6月29日 下午12:31:45	</p>
	 * <p> @修改人：        AkatsukiSimo Xie		</p>
	 * <p> @修改时间：    2020年6月29日 下午12:31:45	</p>
	 * @param bean	实训对象
	 * @param user	用户信息
	 */
	void saveDraft(CourseRmiVo bean, UserRmiVo user) throws ServiceException;

	/**
	 * <p> @方法描述：    获取上传课程数量				</p>
	 * <p> @创建人：        AkatsukiSimo Xie		</p>
	 * <p> @创建时间：    2020年6月30日 下午8:08:01	</p>
	 * <p> @修改人：        AkatsukiSimo Xie		</p>
	 * <p> @修改时间：    2020年6月30日 下午8:08:01	</p>
	 * @param user	用户信息
	 * @return
	 */
	Long getUploadNum(UserRmiVo user) throws ServiceException;

	/**
	 * <p> @方法描述：    增加浏览次数				</p>
	 * <p> @创建人：        AkatsukiSimo Xie		</p>
	 * <p> @创建时间：    2020年7月2日 下午1:03:25	</p>
	 * <p> @修改人：        AkatsukiSimo Xie		</p>
	 * <p> @修改时间：    2020年7月2日 下午1:03:25	</p>
	 * @param cid	实训编号
	 * @param user	用户信息
	 */
	public void addShowTime(Long cid, UserRmiVo user) throws ServiceException;



}
