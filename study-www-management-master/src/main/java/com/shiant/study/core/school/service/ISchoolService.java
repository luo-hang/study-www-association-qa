package com.shiant.study.core.school.service;

import com.alibaba.fastjson.JSONArray;
import com.shiant.common.exception.ServiceException;
import com.shiant.study.core.school.model.School;
import com.shiant.study.core.school.vo.SchoolVo;

import java.util.Date;
import java.util.Map;

/**
 * @program: study-www-association
 * @description
 * @author: z p、
 * @create: 2020-09-17 14:52
 **/
public interface ISchoolService {

    /**
     * 获取所有院校信息
     *
     * @return
     */
    JSONArray getAll(School school);

    /**
     * 添加院校信息
     */
    void addData(String namec, String nameE, String schoolLog,
                 String schooLling, String schoolProperty, String professionNum,
                 String schoolAbout, String createDate, String updateDate) throws ServiceException;

    void addData1(School school) throws ServiceException;

    /**
     * 删除信息
     *
     * @param
     */
    void deleteData(String schoolName) throws ServiceException;

    /**
     * 动态更新（问题）
     *
     * @param school
     * @throws ServiceException
     */
    void updateDataBySchoolNameCAndSchoolNameEAndId(School school) throws ServiceException;

    /**
     * 动态查询
     *
     * @return
     */
    JSONArray queryXxxs(School school) throws ServiceException;

	/**
	 * <p> @方法描述：    根据国家查询院校			</p>
	 * <p> @创建人：        AkatsukiSimo Xie		</p>
	 * <p> @创建时间：    2020年10月3日 下午4:30:44	</p>
	 * <p> @修改人：        AkatsukiSimo Xie		</p>
	 * <p> @修改时间：    2020年10月3日 下午4:30:44	</p>
	 * @param from  		页码
	 * @param size 			页长
	 * @param country		国家
	 * @return
	 */
	JSONArray findByCountry(int from, int size, String country) throws ServiceException;

	/**
	 * <p> @方法描述：    查询国家列表				</p>
	 * <p> @创建人：        AkatsukiSimo Xie		</p>
	 * <p> @创建时间：    2020年10月3日 下午6:29:51	</p>
	 * <p> @修改人：        AkatsukiSimo Xie		</p>
	 * <p> @修改时间：    2020年10月3日 下午6:29:51	</p>
	 * @param from  			页码
	 * @param size 				页长
	 * @param country			国家
	 * @param schoolProperty	院校性质
	 * @param degree			目标学位
	 * @return
	 */
	Map<String, Object> getBeans(int from, int size, String country, String schoolProperty, String degree)
			throws ServiceException;

	/**
	 * <p> @方法描述：    根据编号获取院校详细			</p>
	 * <p> @创建人：        AkatsukiSimo Xie		</p>
	 * <p> @创建时间：    2020年10月3日 下午10:55:02	</p>
	 * <p> @修改人：        AkatsukiSimo Xie		</p>
	 * <p> @修改时间：    2020年10月3日 下午10:55:02	</p>
	 * @param id		编号
	 * @return
	 */
	SchoolVo getBeanBySid(Long id) throws ServiceException;

}
