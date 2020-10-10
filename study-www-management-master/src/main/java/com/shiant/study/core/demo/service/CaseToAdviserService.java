package com.shiant.study.core.demo.service;

import java.util.List;
import java.util.Map;

import com.shiant.common.exception.ServiceException;
import com.shiant.rmi.user.vo.UserRmiVo;
import com.shiant.study.core.adviser.vo.AdviserVo;
import com.shiant.study.core.demo.model.Case;
import com.shiant.study.core.demo.model.CaseToAdviser;

public interface CaseToAdviserService {

	/**
	 * <p> @方法描述：    根据顾问编号获取案例数量		</p>
	 * <p> @创建人：        AkatsukiSimo Xie		</p>
	 * <p> @创建时间：    2020年9月18日 下午3:38:27	</p>
	 * <p> @修改人：        AkatsukiSimo Xie		</p>
	 * <p> @修改时间：    2020年9月18日 下午3:38:27	</p>
	 * @param aids 	顾问编号
	 * @return
	 * @throws ServiceException
	 */
	Map<Long, Long> getCountByAid(List<Long> aids) throws ServiceException;
	
	/**
	 * <p> @方法描述：    根据案例获取顾问				</p>
	 * <p> @创建人：        AkatsukiSimo Xie		</p>
	 * <p> @创建时间：    2020年9月23日 下午5:07:20	</p>
	 * <p> @修改人：        AkatsukiSimo Xie		</p>
	 * <p> @修改时间：    2020年9月23日 下午5:07:20	</p>
	 * @param cid	案例编号
	 * @param user	用户信息
	 * @return
	 * @throws ServiceException
	 */
	List<AdviserVo> getAdvisersByCid(Long cid,UserRmiVo user) throws ServiceException;

	/**
	 * <p> @方法描述：    根据顾问	获取案例			</p>
	 * <p> @创建人：        AkatsukiSimo Xie		</p>
	 * <p> @创建时间：    2020年9月23日 下午5:07:20	</p>
	 * <p> @修改人：        AkatsukiSimo Xie		</p>
	 * <p> @修改时间：    2020年9月23日 下午5:07:20	</p>
	 * @param aid	顾问编号
	 * @return
	 * @throws ServiceException
	 */
	List<Case> getCasesByAid(Long aid) throws ServiceException;
	
	/**
	 * <p> @方法描述：    添加案例对应顾问				</p>
	 * <p> @创建人：        AkatsukiSimo Xie		</p>
	 * <p> @创建时间：    2020年9月18日 下午3:40:03	</p>
	 * <p> @修改人：        AkatsukiSimo Xie		</p>
	 * <p> @修改时间：    2020年9月18日 下午3:40:03	</p>
	 * @param bean	案例信息
	 * @param user  用户信息
	 * @return 
	 * @throws ServiceException
	 */
	Long addBean(CaseToAdviser bean,UserRmiVo user) throws ServiceException;
	
	/**
	 * <p> @方法描述： 更新案例对应顾问		        </p>
	 * <p> @创建人：        AkatsukiSimo Xie		</p>
	 * <p> @创建时间：    2020年9月18日 下午3:40:03	</p>
	 * <p> @修改人：        AkatsukiSimo Xie		</p>
	 * <p> @修改时间：    2020年9月18日 下午3:40:03	</p>
	 * @param cids	案例编号
	 * @param aids	顾问编号
	 * @param user 	用户信息
	 * @throws ServiceException
	 */
	void updateBean(List<Long> cids, List<Long> aids, UserRmiVo user) throws ServiceException;


}
