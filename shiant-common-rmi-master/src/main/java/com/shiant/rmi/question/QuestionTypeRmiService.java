package com.shiant.rmi.question;

import java.util.List;
import java.util.Map;

import com.shiant.common.exception.ServiceException;
import com.shiant.rmi.question.vo.QuestionTypeRmiVo;
import com.shiant.rmi.user.vo.UserRmiVo;

public interface QuestionTypeRmiService{

	/**
	 * <p> @方法描述：    根本编号获取问题类型			</p>
	 * <p> @创建人：        AkatsukiSimo Xie		</p>
	 * <p> @创建时间：    2020年4月15日 下午3:38:27	</p>
	 * <p> @修改人：        AkatsukiSimo Xie		</p>
	 * <p> @修改时间：    2020年4月15日 下午3:38:27	</p>
	 * @param id 		类型编号
	 * @param user		用户信息
	 * @return
	 * @throws ServiceException
	 */
	QuestionTypeRmiVo getBean(Long id,UserRmiVo user) throws ServiceException;
	
	/**
	 * <p> @方法描述：    获取问题类型				</p>
	 * <p> @创建人：        AkatsukiSimo Xie		</p>
	 * <p> @创建时间：    2020年4月15日 下午3:38:27	</p>
	 * <p> @修改人：        AkatsukiSimo Xie		</p>
	 * <p> @修改时间：    2020年4月15日 下午3:38:27	</p>
	 * @param user			用户信息
	 * @return
	 * @throws ServiceException
	 */
	Map<String,Object> getBeans(UserRmiVo user) throws ServiceException;
	
	/**
	 * <p> @方法描述：    根据父元素获取问题类型		</p>
	 * <p> @创建人：        AkatsukiSimo Xie		</p>
	 * <p> @创建时间：    2020年8月14日 下午4:08:12	</p>
	 * <p> @修改人：        AkatsukiSimo Xie		</p>
	 * <p> @修改时间：    2020年8月14日 下午4:08:12	</p>
	 * @param parentid	父元素编号
	 * @param user		用户信息
	 * @return
	 */
	Map<String, Object> getBeans(Long parentid, UserRmiVo user) throws ServiceException;
	
	/**
	 * <p> @方法描述：    删除问题类型				</p>
	 * <p> @创建人：        AkatsukiSimo Xie		</p>
	 * <p> @创建时间：    2020年4月15日 下午3:40:03	</p>
	 * <p> @修改人：        AkatsukiSimo Xie		</p>
	 * <p> @修改时间：    2020年4月15日 下午3:40:03	</p>
	 * @param id	问题编号
	 * @param user  用户信息
	 * @throws ServiceException
	 */
	void deleteBean(Long id ,UserRmiVo user) throws ServiceException;
	
	/**
	 * <p> @方法描述：    添加问题类型				</p>
	 * <p> @创建人：        AkatsukiSimo Xie		</p>
	 * <p> @创建时间：    2020年4月15日 下午3:40:03	</p>
	 * <p> @修改人：        AkatsukiSimo Xie		</p>
	 * <p> @修改时间：    2020年4月15日 下午3:40:03	</p>
	 * @param bean	问题类型
	 * @param user  用户信息
	 * @return 
	 * @throws ServiceException
	 */
	Long addBean(QuestionTypeRmiVo bean,UserRmiVo user) throws ServiceException;
	
	/**
	 * <p> @方法描述： 更新问题类型	            </p>
	 * <p> @创建人：        AkatsukiSimo Xie		</p>
	 * <p> @创建时间：    2020年4月15日 下午3:40:03	</p>
	 * <p> @修改人：        AkatsukiSimo Xie		</p>
	 * <p> @修改时间：    2020年4月15日 下午3:40:03	</p>
	 * @param bean	问题类型
	 * @param user 	用户信息
	 * @throws ServiceException
	 */
	void updateBean(QuestionTypeRmiVo bean,UserRmiVo user) throws ServiceException;

}
