package com.shiant.study.core.school.service.impl;

import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.shiant.common.exception.ServiceException;
import com.shiant.common.util.StringUtil;
import com.shiant.rmi.user.vo.UserRmiVo;
import com.shiant.study.core.school.dao.ProfessionDao;
import com.shiant.study.core.school.dao.ProfessionRepository;
import com.shiant.study.core.school.model.Profession;
import com.shiant.study.core.school.service.ProfessionService;
import com.shiant.study.core.school.transfer.ProfessionTransfer;
import com.shiant.study.core.school.vo.ProfessionVo;

import net.sf.json.JSONObject;


@Service(value = "/professionService")
public class ProfessionServiceImpl implements ProfessionService {

	@Autowired
	private ProfessionRepository professionRepository;

	@Autowired
	private ProfessionDao professionDao;

	private static ProfessionTransfer transfer = new ProfessionTransfer();
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public Long addBean(ProfessionVo bean, UserRmiVo user) throws ServiceException {
		try {
			Profession entity = transfer.transferVoToEntity(bean);
			entity.setPid(null);
			entity.setCreateDate(new Date());
			entity.setCreater(user.getUserName());
			entity.setUpdateDate(new Date());
			entity.setUpdater(user.getUserRealName());
			
			professionRepository.save(entity);
			return entity.getPid();
		} catch (ServiceException e) {
			if (e.getErrorMsg() ==  null) {
				e.setErrorMsg("添加专业失败");
			}
			throw e;
		} catch (Exception e) {
			throw new ServiceException("添加专业失败!", e);
		}
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
	public void updateBean(ProfessionVo vo, UserRmiVo user) throws ServiceException {
		try {
			Profession bean = professionRepository.findById(vo.getPid()).orElse(null);
			if(bean != null) {
				bean.setUpdateDate(new Date());
				bean.setUpdater(user.getUserRealName());
				bean.setName(vo.getName());
				bean.setCollege(vo.getCollege());
				bean.setDegree(vo.getDegree());
				bean.setFee(vo.getFee());
				bean.setSemester(vo.getSemester());
				bean.setSid(vo.getSid());
			}else {
				throw new ServiceException("未找到相关专业信息!");
			}
		}catch(ServiceException e){
			if(e.getErrorMsg() == null){
				e.setErrorMsg("更新专业");
			}
			throw new ServiceException(e.getErrorMsg(),e);
		}catch(Exception e){
			throw new ServiceException("更新专业失败!",e);
		}
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
	public void deleteBean(Long id,UserRmiVo user) throws ServiceException {
		try {
			professionRepository.deleteById(id);
		} catch (Exception e) {
			throw new ServiceException("删除专业失败!",e);
		}
	}

	@Override
	@Transactional(propagation = Propagation.NOT_SUPPORTED)
	public Map<String, Object> getBeans(int from, int size, Long sid, UserRmiVo user) throws ServiceException {
		try {
			Map<String, Object> maps = new HashMap<String, Object>();
			Sort sort = Sort.by(Direction.DESC, "updateDate");
			Pageable pageable = PageRequest.of(from-1, size, sort);
			Page<Profession> beans = null;
			if(StringUtil.isBlank(sid)) {
				beans = professionRepository.findAll(pageable);
			}else {
				beans = professionRepository.findBySid(sid,pageable);
			}
			if(beans.getSize()>0) {
				Collection<ProfessionVo> vos = transfer.transferCollectionEntityToBaseVos(beans.getContent());
				maps.put("beans", vos);
			}else {
				maps.put("beans",new ArrayList<>());
			}
			maps.put("total", beans.getTotalElements());
			maps.put("totalPages", beans.getTotalPages());
			return maps;
		}catch(Exception e){
			throw new ServiceException("根据条件分页获取专业集合服务失败!",e);
		}
	}
	
	@Override
	@Transactional(propagation = Propagation.NOT_SUPPORTED,rollbackFor = Exception.class)
	public ProfessionVo getBean(Long id, UserRmiVo user) throws ServiceException {
		try {
			return transfer.transferEntityToBaseVo(professionRepository.findById(id).orElse(null));
		}catch(Exception e){
			throw new ServiceException("根据专业编号获取实体失败!",e);
		}
	}

}
