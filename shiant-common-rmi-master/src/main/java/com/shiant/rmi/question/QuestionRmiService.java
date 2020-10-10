package com.shiant.rmi.question;

import java.util.Map;

import com.shiant.common.exception.ServiceException;
import com.shiant.rmi.question.vo.QuestionBaseRmiVo;
import com.shiant.rmi.question.vo.QuestionRmiVo;
import com.shiant.rmi.user.vo.UserRmiVo;

public interface QuestionRmiService{

	/**
	 * <p> @方法描述：    根据编号获取问题			</p>
	 * <p> @创建人：        AkatsukiSimo Xie		</p>
	 * <p> @创建时间：    2020年4月15日 下午3:38:27	</p>
	 * <p> @修改人：        AkatsukiSimo Xie		</p>
	 * <p> @修改时间：    2020年4月15日 下午3:38:27	</p>
	 * @param id 		问题编号
	 * @param user		用户信息
	 * @return
	 * @throws ServiceException
	 */
	QuestionRmiVo getBean(Long id,UserRmiVo user) throws ServiceException;
	
	/**
	 * <p> @方法描述：    获取问题					</p>
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
	 * <p> @方法描述：    删除问题					</p>
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
	 * <p> @方法描述：    添加问题					</p>
	 * <p> @创建人：        AkatsukiSimo Xie		</p>
	 * <p> @创建时间：    2020年4月15日 下午3:40:03	</p>
	 * <p> @修改人：        AkatsukiSimo Xie		</p>
	 * <p> @修改时间：    2020年4月15日 下午3:40:03	</p>
	 * @param bean	问题信息
	 * @param user  用户信息
	 * @return 
	 * @throws ServiceException
	 */
	Long addBean(QuestionRmiVo bean,UserRmiVo user) throws ServiceException;
	
	/**
	 * <p> @方法描述： 更新问题	                </p>
	 * <p> @创建人：        AkatsukiSimo Xie		</p>
	 * <p> @创建时间：    2020年4月15日 下午3:40:03	</p>
	 * <p> @修改人：        AkatsukiSimo Xie		</p>
	 * <p> @修改时间：    2020年4月15日 下午3:40:03	</p>
	 * @param bean	问题信息
	 * @param user 	用户信息
	 * @throws ServiceException
	 */
	void updateBean(QuestionRmiVo bean,UserRmiVo user) throws ServiceException;

	/**
	 * <p> @方法描述：    待回答问题				</p>
	 * <p> @创建人：        AkatsukiSimo Xie		</p>
	 * <p> @创建时间：    2020年6月29日 下午4:08:55	</p>
	 * <p> @修改人：        AkatsukiSimo Xie		</p>
	 * <p> @修改时间：    2020年6月29日 下午4:08:55	</p>
	 * @param from 	当前页
	 * @param size	每页总页数
	 * @param user	用户信息	
	 */
	Map<String,Object> getWaitAnswer(int from,int size,UserRmiVo user) throws ServiceException;

	/**
	 * <p> @方法描述：    已回答问题				</p>
	 * <p> @创建人：        AkatsukiSimo Xie		</p>
	 * <p> @创建时间：    2020年6月29日 下午4:09:00	</p>
	 * <p> @修改人：        AkatsukiSimo Xie		</p>
	 * <p> @修改时间：    2020年6月29日 下午4:09:00	</p>
	 * @param from 	当前页
	 * @param size	每页总页数
	 * @param user	用户信息	
	 */
	Map<String,Object> getHasAnswer(int from,int size,UserRmiVo user) throws ServiceException;

	/**
	 * <p> @方法描述：    待回答问题				</p>
	 * <p> @创建人：        AkatsukiSimo Xie		</p>
	 * <p> @创建时间：    2020年6月29日 下午4:08:55	</p>
	 * <p> @修改人：        AkatsukiSimo Xie		</p>
	 * <p> @修改时间：    2020年6月29日 下午4:08:55	</p>
	 * @param from 	当前页
	 * @param size	每页总页数
	 * @param user	用户信息	
	 */
	Map<String,Object> getUserWaitAnswer(int from,int size,UserRmiVo user) throws ServiceException;
	
	/**
	 * <p> @方法描述：    已回答问题				</p>
	 * <p> @创建人：        AkatsukiSimo Xie		</p>
	 * <p> @创建时间：    2020年6月29日 下午4:09:00	</p>
	 * <p> @修改人：        AkatsukiSimo Xie		</p>
	 * <p> @修改时间：    2020年6月29日 下午4:09:00	</p>
	 * @param from 	当前页
	 * @param size	每页总页数
	 * @param user	用户信息	
	 */
	Map<String,Object> getUserHasAnswer(int from,int size,UserRmiVo user) throws ServiceException;

	/**
	 * <p> @方法描述：    获取解答问题数				</p>
	 * <p> @创建人：        AkatsukiSimo Xie		</p>
	 * <p> @创建时间：    2020年6月30日 下午8:15:52	</p>
	 * <p> @修改人：        AkatsukiSimo Xie		</p>
	 * <p> @修改时间：    2020年6月30日 下午8:15:52	</p>
	 * @param user	用户信息
	 * @return
	 */
	Long getAnswerNum(UserRmiVo user) throws ServiceException;

	/**
	 * <p> @方法描述：    获取为机构解答问题数			</p>
	 * <p> @创建人：        AkatsukiSimo Xie		</p>
	 * <p> @创建时间：    2020年6月30日 下午8:15:52	</p>
	 * <p> @修改人：        AkatsukiSimo Xie		</p>
	 * <p> @修改时间：    2020年6月30日 下午8:15:52	</p>
	 * @param user	用户信息
	 * @return
	 */
	Long getAnswerOrgNum(UserRmiVo user) throws ServiceException;

	/**
	 * <p> @方法描述：    分类问题					</p>
	 * <p> @创建人：        AkatsukiSimo Xie		</p>
	 * <p> @创建时间：    2020年8月7日 下午5:00:56	</p>
	 * <p> @修改人：        AkatsukiSimo Xie		</p>
	 * <p> @修改时间：    2020年8月7日 下午5:00:56	</p>
	 * @param qid		问题编号
	 * @param class1	分类一
	 * @param class2	分类二
	 * @param class3	分类三
	 * @param class4	分类四
	 * @param user		用户信息
	 */
	void classify(Long qid, int class1, int class2, int class3, int class4, UserRmiVo user)
			throws ServiceException;

	/**
	 * <p> @方法描述：    分配问题					</p>
	 * <p> @创建人：        AkatsukiSimo Xie		</p>
	 * <p> @创建时间：    2020年8月7日 下午5:07:24	</p>
	 * <p> @修改人：        AkatsukiSimo Xie		</p>
	 * <p> @修改时间：    2020年8月7日 下午5:07:24	</p>
	 * @param qid		问题编号
	 * @param orgid		机构编号
	 * @param orgName   机构名称
	 * @param user		用户信息
	 */
	void assign(Long qid, Long orgid, String orgName, UserRmiVo user) throws ServiceException;

	/**
	 * <p> @方法描述：    获取已解决问题				</p>
	 * <p> @创建人：        AkatsukiSimo Xie		</p>
	 * <p> @创建时间：    2020年8月7日 下午5:04:22	</p>
	 * <p> @修改人：        AkatsukiSimo Xie		</p>
	 * <p> @修改时间：    2020年8月7日 下午5:04:22	</p>
	 * @param from 		当前页
	 * @param size		每页总页数
	 * @param keyWord	关键字
	 * @param user		用户信息
	 * @return
	 */
	Map<String, Object> getHasBeans(int from, int size, String keyWord, UserRmiVo user)
			throws ServiceException;

	/**
	 * <p> @方法描述：    获取未解决问题				</p>
	 * <p> @创建人：        AkatsukiSimo Xie		</p>
	 * <p> @创建时间：    2020年8月7日 下午5:04:33	</p>
	 * <p> @修改人：        AkatsukiSimo Xie		</p>
	 * <p> @修改时间：    2020年8月7日 下午5:04:33	</p>
	 * @param from 		当前页
	 * @param size		每页总页数
	 * @param keyWord	关键字
	 * @param user		用户信息
	 * @return
	 */
	Map<String, Object> getHasNotBeans(int from, int size, String keyWord, UserRmiVo user)
			throws ServiceException;

	/**
	 * <p> @方法描述：    问题分类选择				</p>
	 * <p> @创建人：        AkatsukiSimo Xie		</p>
	 * <p> @创建时间：    2020年8月18日 下午3:20:46	</p>
	 * <p> @修改人：        AkatsukiSimo Xie		</p>
	 * <p> @修改时间：    2020年8月18日 下午3:20:46	</p>
	 * @param bean	问题类型
	 * @param user 	用户信息
	 */
	void assignType(QuestionBaseRmiVo bean, UserRmiVo user) throws ServiceException;

}
