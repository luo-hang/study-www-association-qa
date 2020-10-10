package com.shiant.rmi.course;

import java.util.Map;

import com.shiant.common.exception.ServiceException;
import com.shiant.rmi.course.vo.CourseStepRmiVo;
import com.shiant.rmi.user.vo.UserRmiVo;

public interface CourseStepRmiService{

	/**
	 * <p> @方法描述：    根据编号获取实训步骤			</p>
	 * <p> @创建人：        AkatsukiSimo Xie		</p>
	 * <p> @创建时间：    2020年4月15日 下午3:38:27	</p>
	 * <p> @修改人：        AkatsukiSimo Xie		</p>
	 * <p> @修改时间：    2020年4月15日 下午3:38:27	</p>
	 * @param id 		编号
	 * @param user		用户信息
	 * @return
	 * @throws ServiceException
	 */
	CourseStepRmiVo getBean(Long id,UserRmiVo user) throws ServiceException;
	
	/**
	 * <p> @方法描述：    获取实训步骤				</p>
	 * <p> @创建人：        AkatsukiSimo Xie		</p>
	 * <p> @创建时间：    2020年4月15日 下午3:38:27	</p>
	 * <p> @修改人：        AkatsukiSimo Xie		</p>
	 * <p> @修改时间：    2020年4月15日 下午3:38:27	</p>
	 * @param from 			当前页
	 * @param size			每页总页数
	 * @param condition		其他条件
	 * @param user			用户信息
	 * @return
	 * @throws ServiceException
	 */
	Map<String,Object> getBeans(int from,int size,String condition,UserRmiVo user)
			throws ServiceException;

	/**
	 * <p> @方法描述：    根据实训获取实训步骤			</p>
	 * <p> @创建人：        AkatsukiSimo Xie		</p>
	 * <p> @创建时间：    2020年6月29日 上午9:53:03	</p>
	 * <p> @修改人：        AkatsukiSimo Xie		</p>
	 * <p> @修改时间：    2020年6月29日 上午9:53:03	</p>
	 * @param cid	实训编号
	 * @param user	用户信息
	 * @return
	 * @throws ServiceException
	 */
	Map<String,Object> getBeans(Long cid,UserRmiVo user) throws ServiceException;
	
	/**
	 * <p> @方法描述：    删除实训步骤				</p>
	 * <p> @创建人：        AkatsukiSimo Xie		</p>
	 * <p> @创建时间：    2020年4月15日 下午3:40:03	</p>
	 * <p> @修改人：        AkatsukiSimo Xie		</p>
	 * <p> @修改时间：    2020年4月15日 下午3:40:03	</p>
	 * @param id	配置
	 * @param user  用户信息
	 * @throws ServiceException
	 */
	void deleteBean(Long id ,UserRmiVo user) throws ServiceException;
	
	/**
	 * <p> @方法描述：    添加实训步骤				</p>
	 * <p> @创建人：        AkatsukiSimo Xie		</p>
	 * <p> @创建时间：    2020年4月15日 下午3:40:03	</p>
	 * <p> @修改人：        AkatsukiSimo Xie		</p>
	 * <p> @修改时间：    2020年4月15日 下午3:40:03	</p>
	 * @param bean	实训步骤信息
	 * @param user  用户信息
	 * @return 
	 * @throws ServiceException
	 */
	Long addBean(CourseStepRmiVo bean,UserRmiVo user) throws ServiceException;
	
	/**
	 * <p> @方法描述： 更新实训步骤	            </p>
	 * <p> @创建人：        AkatsukiSimo Xie		</p>
	 * <p> @创建时间：    2020年4月15日 下午3:40:03	</p>
	 * <p> @修改人：        AkatsukiSimo Xie		</p>
	 * <p> @修改时间：    2020年4月15日 下午3:40:03	</p>
	 * @param bean	实训步骤信息
	 * @param user 	用户信息
	 * @throws ServiceException
	 */
	void updateBean(CourseStepRmiVo bean,UserRmiVo user) throws ServiceException;

	/**
	 * <p> @方法描述：    更新排序					</p>
	 * <p> @创建人：        AkatsukiSimo Xie		</p>
	 * <p> @创建时间：    2020年6月29日 下午12:38:36	</p>
	 * <p> @修改人：        AkatsukiSimo Xie		</p>
	 * <p> @修改时间：    2020年6月29日 下午12:38:36	</p>
	 * @param step	实训步骤信息
	 * @param user 用户信息
	 */
	void updateOrder(CourseStepRmiVo step, UserRmiVo user) throws ServiceException;

	/**
	 * <p> @方法描述：    根据编号获取实训步骤			</p>
	 * <p> @创建人：        AkatsukiSimo Xie		</p>
	 * <p> @创建时间：    2020年4月15日 下午3:38:27	</p>
	 * <p> @修改人：        AkatsukiSimo Xie		</p>
	 * <p> @修改时间：    2020年4月15日 下午3:38:27	</p>
	 * @param id 		编号
	 * @param user		用户信息
	 * @return
	 * @throws ServiceException
	 */
	CourseStepRmiVo getBeanWithCourse(Long id,UserRmiVo user) throws ServiceException;

}
