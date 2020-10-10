package com.shiant.study.core.article.service;

import java.util.List;
import java.util.Map;

import com.shiant.common.exception.ServiceException;
import com.shiant.rmi.user.vo.UserRmiVo;
import com.shiant.study.core.article.vo.ArticleVo;

public interface ArticleService {

	/**
	 * <p> @方法描述：    根本编号获取文章				</p>
	 * <p> @创建人：        AkatsukiSimo Xie		</p>
	 * <p> @创建时间：    2020年9月18日 下午3:38:27	</p>
	 * <p> @修改人：        AkatsukiSimo Xie		</p>
	 * <p> @修改时间：    2020年9月18日 下午3:38:27	</p>
	 * @param id 		文章编号
	 * @param user		用户信息
	 * @return
	 * @throws ServiceException
	 */
	ArticleVo getBean(Long id,UserRmiVo user) throws ServiceException;
	
	/**
	 * <p> @方法描述：    获取文章					</p>
	 * <p> @创建人：        AkatsukiSimo Xie		</p>
	 * <p> @创建时间：    2020年9月18日 下午3:38:27	</p>
	 * <p> @修改人：        AkatsukiSimo Xie		</p>
	 * <p> @修改时间：    2020年9月18日 下午3:38:27	</p>
	 * @param from 			当前页
	 * @param size			每页总页数
	 * @param type			类型
	 * @return
	 * @throws ServiceException
	 */
	Map<String, Object> getBeans(int from,int size,String type)
			throws ServiceException;
	
	/**
	 * <p> @方法描述：    删除文章					</p>
	 * <p> @创建人：        AkatsukiSimo Xie		</p>
	 * <p> @创建时间：    2020年9月18日 下午3:40:03	</p>
	 * <p> @修改人：        AkatsukiSimo Xie		</p>
	 * <p> @修改时间：    2020年9月18日 下午3:40:03	</p>
	 * @param id	文章编号
	 * @param user  用户信息
	 * @throws ServiceException
	 */
	void deleteBean(Long id ,UserRmiVo user) throws ServiceException;
	
	/**
	 * <p> @方法描述：    添加文章					</p>
	 * <p> @创建人：        AkatsukiSimo Xie		</p>
	 * <p> @创建时间：    2020年9月18日 下午3:40:03	</p>
	 * <p> @修改人：        AkatsukiSimo Xie		</p>
	 * <p> @修改时间：    2020年9月18日 下午3:40:03	</p>
	 * @param bean	文章信息
	 * @param user  用户信息
	 * @return 
	 * @throws ServiceException
	 */
	Long addBean(ArticleVo bean,UserRmiVo user) throws ServiceException;
	
	/**
	 * <p> @方法描述： 更新文章	                </p>
	 * <p> @创建人：        AkatsukiSimo Xie		</p>
	 * <p> @创建时间：    2020年9月18日 下午3:40:03	</p>
	 * <p> @修改人：        AkatsukiSimo Xie		</p>
	 * <p> @修改时间：    2020年9月18日 下午3:40:03	</p>
	 * @param bean	文章信息
	 * @param user 	用户信息
	 * @throws ServiceException
	 */
	void updateBean(ArticleVo bean,UserRmiVo user) throws ServiceException;

	/**
	 * <p> @方法描述：    增加浏览次数				</p>
	 * <p> @创建人：        AkatsukiSimo Xie		</p>
	 * <p> @创建时间：    2020年9月18日 下午1:04:19	</p>
	 * <p> @修改人：        AkatsukiSimo Xie		</p>
	 * <p> @修改时间：    2020年9月18日 下午1:04:19	</p>
	 * @param cid	文章编号
	 * @param user	用户信息
	 */
	void addShowTime(Long cid, UserRmiVo user) throws ServiceException;

}
