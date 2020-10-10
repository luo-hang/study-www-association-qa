package com.shiant.study.core.legal.service.impl;

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
import com.shiant.study.core.legal.dao.ComplaintDao;
import com.shiant.study.core.legal.dao.ComplaintRepository;
import com.shiant.study.core.legal.model.Complaint;
import com.shiant.study.core.legal.service.ComplaintService;
import com.shiant.study.core.legal.transfer.ComplaintTransfer;
import com.shiant.study.core.legal.vo.ComplaintVo;

import net.sf.json.JSONObject;


@Service(value = "/complaintService")
public class ComplaintServiceImpl implements ComplaintService {

	@Autowired
	private ComplaintRepository complaintRepository;

	@Autowired
	private ComplaintDao complaintDao;

	private static ComplaintTransfer transfer = new ComplaintTransfer();
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public Long addBean(ComplaintVo bean, UserRmiVo user) throws ServiceException {
		try {
			Complaint entity = transfer.transferVoToEntity(bean);
			entity.setCid(null);
			entity.setCreateDate(new Date());
			entity.setCreaterid(user.getUserid());
			entity.setCreater(user.getUserName());
			entity.setUpdateDate(new Date());
			entity.setUpdater(user.getUserRealName());
			entity.setOrgid(user.getOrgid());
			if(user.getOrgid()!=null) {
				entity.setCreaterType("机构");
			}else {
				entity.setCreaterType("用户");
			}
			
			complaintRepository.save(entity);
			return entity.getCid();
		} catch (ServiceException e) {
			if (e.getErrorMsg() ==  null) {
				e.setErrorMsg("添加投诉失败");
			}
			throw e;
		} catch (Exception e) {
			throw new ServiceException("添加投诉失败!", e);
		}
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
	public void updateBean(ComplaintVo vo, UserRmiVo user) throws ServiceException {
		try {
			Complaint bean = complaintRepository.findById(vo.getCid()).orElse(null);
			if(bean != null) {
				bean.setUpdateDate(new Date());
				bean.setUpdater(user.getUserRealName());
				bean.setContent(vo.getContent());
				bean.setTitle(vo.getTitle());
				bean.setOrgid(vo.getOrgid());
				bean.setOrgName(user.getOrgName());
			}else {
				throw new ServiceException("未找到相关投诉信息!");
			}
		}catch(ServiceException e){
			if(e.getErrorMsg() == null){
				e.setErrorMsg("更新投诉");
			}
			throw new ServiceException(e.getErrorMsg(),e);
		}catch(Exception e){
			throw new ServiceException("更新投诉失败!",e);
		}
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
	public void updateStatus(String str, UserRmiVo user) throws ServiceException {
		try {
			JSONObject json = JSONObject.fromObject(str);
			Integer status = json.getInt("status");
			String reason = null;
			if(json.containsKey("reason")) {
				reason = json.getString("reason");
			}
			Complaint bean = complaintRepository.findById(json.getLong("id")).orElse(null);
			if(bean != null) {
				bean.setUpdateDate(new Date());
				bean.setUpdater(user.getUserRealName());
				bean.setStatus(status);
				bean.setReason(reason);
			}else {
				throw new ServiceException("未找到相关投诉信息!");
			}
		}catch(ServiceException e){
			if(e.getErrorMsg() == null){
				e.setErrorMsg("更新投诉失败");
			}
			throw new ServiceException(e.getErrorMsg(),e);
		}catch(Exception e){
			throw new ServiceException("更新投诉失败!",e);
		}
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
	public void deleteBean(Long id,UserRmiVo user) throws ServiceException {
		try {
//			Complaint bean = complaintRepository.findById(id).orElse(null);
//			bean.setDelete(true);
//			bean.setUpdater(user.getUserRealName());
//			bean.setUpdateDate(new Date());
			complaintRepository.deleteById(id);
//		} catch (ServiceException e) {
//			if (e.getErrorMsg() == null) {
//				e.setErrorMsg("删除投诉数据操作失败!");
//			}
//			throw new ServiceException(e.getErrorMsg(),e);
		} catch (Exception e) {
			throw new ServiceException("删除投诉失败!",e);
		}
	}

	@Override
	@Transactional(propagation = Propagation.NOT_SUPPORTED)
	public Map<String, Object> getBeans(int from,int size,String creater, String title, String orgName, 
			Integer status, UserRmiVo user) throws ServiceException {
		try {
			Map<String, Object> maps = new HashMap<String, Object>();
			Sort sort = Sort.by(Direction.DESC, "updateDate");
			Pageable pageable = PageRequest.of(from-1, size, sort);
			Long orgid = user.getOrgid();
			if(user.getUserid().intValue() ==1) {
				orgid = null;
			}
			List<Complaint> beans = complaintDao.getBeans(from-1, size, orgid, creater, title, orgName, status);
			Long total = complaintDao.countBeans(orgid, creater, title, orgName, status);
//			if(status == null && StringUtil.isBlank(title)) {
//				beans = complaintRepository.findByOrgid(user.getOrgid(),pageable);
//			}else if(status == null && StringUtil.isNotBlank(title)) {
//				title = URLDecoder.decode(URLDecoder.decode(title, "utf8"),"utf8");
//				beans = complaintRepository.findByOrgidAndTitleLike(user.getOrgid(),"%"+title+"%",pageable);
//			}else if(status != null && StringUtil.isBlank(title)) {
//				beans = complaintRepository.findByOrgidAndStatus(user.getOrgid(), status, pageable);
//			}else if(status != null && StringUtil.isNotBlank(title)) {
//				beans = complaintRepository.findByOrgidAndTitleLikeAndStatus(user.getOrgid(), "%"+title+"%", status, pageable);
//			}
			if(!beans.isEmpty()) {
				Collection<ComplaintVo> vos = transfer.transferCollectionEntityToBaseVos(beans);
				maps.put("beans", vos);
			}else {
				maps.put("beans",new ArrayList<>());
			}
			maps.put("total", total);
			maps.put("totalPages", (total/size)+1);
			return maps;
		}catch(Exception e){
			throw new ServiceException("根据条件分页获取投诉集合服务失败!",e);
		}
	}
	
	@Override
	@Transactional(propagation = Propagation.NOT_SUPPORTED,rollbackFor = Exception.class)
	public ComplaintVo getBean(Long id, UserRmiVo user) throws ServiceException {
		try {
			return transfer.transferEntityToBaseVo(complaintRepository.findById(id).orElse(null));
		}catch(Exception e){
			throw new ServiceException("根据投诉编号获取实体失败!",e);
		}
	}

}
