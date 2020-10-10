package com.shiant.study.core.whiteList.service.impl;

import java.net.URLDecoder;
import java.util.ArrayList;
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
import com.shiant.study.core.whiteList.dao.WhiteListRepository;
import com.shiant.study.core.whiteList.model.WhiteList;
import com.shiant.study.core.whiteList.service.WhiteListService;
import com.shiant.study.core.whiteList.transfer.WhiteListTransfer;
import com.shiant.study.core.whiteList.vo.WhiteListVo;

@Service(value = "/whiteListService")
public class WhiteListServiceImpl implements WhiteListService {

	@Autowired
	private WhiteListRepository whiteListRepository;

	private static WhiteListTransfer transfer = new WhiteListTransfer();

	@Override
	@Transactional(propagation = Propagation.NOT_SUPPORTED)
	public Map<String, Object> getBeans(int from,int size, String wlNo, String orgName,
			Integer status, UserRmiVo user) throws ServiceException {
		try {
			Map<String,Object> maps = new HashMap<>();
			if(StringUtil.isNotBlank(orgName)) {
				orgName = URLDecoder.decode(URLDecoder.decode(orgName, "utf8"), "utf8");
			}
			if(StringUtil.isNotBlank(wlNo)) {
				wlNo = URLDecoder.decode(URLDecoder.decode(wlNo, "utf8"), "utf8");
			}
			Sort sort = Sort.by(Direction.DESC, "createDate");
			Pageable pageable = PageRequest.of(from-1, size, sort);
			Page<WhiteList> beans = null;
			
			if(StringUtil.isNotBlank(orgName)&&StringUtil.isNotBlank(status)&&StringUtil.isNotBlank(wlNo)) {
				beans = whiteListRepository.findByOrgNameLikeAndStatusAndWlNo("%"+orgName+"%", status, wlNo, pageable);
			}else if(StringUtil.isBlank(orgName)&&StringUtil.isNotBlank(status)&&StringUtil.isNotBlank(wlNo)) {
				beans = whiteListRepository.findByStatusAndWlNo(status, wlNo, pageable);
			}else if(StringUtil.isNotBlank(orgName)&&StringUtil.isBlank(status)&&StringUtil.isNotBlank(wlNo)) {
				beans = whiteListRepository.findByOrgNameLikeAndWlNo("%"+orgName+"%", wlNo, pageable);
			}else if(StringUtil.isNotBlank(orgName)&&StringUtil.isNotBlank(status)&&StringUtil.isBlank(wlNo)) {
				beans = whiteListRepository.findByOrgNameLikeAndStatus("%"+orgName+"%", status, pageable);
			}else if(StringUtil.isBlank(orgName)&&StringUtil.isBlank(status)&&StringUtil.isNotBlank(wlNo)) {
				beans = whiteListRepository.findByWlNo(wlNo, pageable);
			}else if(StringUtil.isBlank(orgName)&&StringUtil.isNotBlank(status)&&StringUtil.isBlank(wlNo)) {
				beans = whiteListRepository.findByStatus(status, pageable);
			}else if(StringUtil.isNotBlank(orgName)&&StringUtil.isBlank(status)&&StringUtil.isBlank(wlNo)) {
				beans = whiteListRepository.findByOrgNameLike("%"+orgName+"%", pageable);
			}else if(StringUtil.isBlank(orgName)&&StringUtil.isBlank(status)&&StringUtil.isBlank(wlNo)) {
				beans = whiteListRepository.findAll(pageable);
			}
			
			if(beans.getSize()>0) {
				maps.put("beans", transfer.transferCollectionEntityToBaseVos(beans.getContent()));
			}else {
				maps.put("beans",new ArrayList<>());
			}
			maps.put("total", beans.getTotalElements());
			maps.put("totalPages", beans.getTotalPages());
			return maps;
		}catch(ServiceException e){
			if(e.getErrorMsg() == null){
				e.setErrorMsg("根据条件分页获取组织机构集合");
			}
			throw new ServiceException(e.getErrorMsg(),e);
		}catch(Exception e){
			throw new ServiceException("根据条件分页获取组织机构集合失败!",e);
		}
	}
	
	
	@Override
	@Transactional(propagation = Propagation.NOT_SUPPORTED,rollbackFor = Exception.class)
	public WhiteListVo getCurWhiteList(UserRmiVo user) throws ServiceException {
		try {
			WhiteList bean = whiteListRepository.findByOrgid(user.getOrgid());
			if(bean == null) {
				return new WhiteListVo();
			}else {
				return transfer.transferEntityToBaseVo(bean);
			}
		} catch (ServiceException e) {
			if (e.getErrorMsg() ==  null) {
				e.setErrorMsg("获取当前用户白名单条目数据失败");
			}
			throw e;
		} catch (Exception e) {
			throw new ServiceException("获取当前用户白名单条目数据失败", e);
		}
	}
	
	@Override
	@Transactional(propagation = Propagation.NOT_SUPPORTED,rollbackFor = Exception.class)
	public WhiteListVo getBean(Long id, UserRmiVo user) throws ServiceException {
		try {
			return transfer.transferEntityToBaseVo(whiteListRepository.findById(id).orElse(null));
		}catch(Exception e){
			throw new ServiceException("根据编号获取实体失败!",e);
		}
	}
	
	@Override
	public WhiteListVo getBeanByOrgid(Long orgid, UserRmiVo user) throws ServiceException {
		try {
			return transfer.transferEntityToBaseVo(whiteListRepository.findByOrgid(orgid));
		}catch(Exception e){
			throw new ServiceException("根据组织机构编号获取实体失败!",e);
		}
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
	public Long updateBean(WhiteListVo vo, UserRmiVo user) throws ServiceException {
		try {
			WhiteList bean = whiteListRepository.findByOrgid(user.getOrgid());
			if(bean == null) {
				bean = transfer.transferVoToEntity(vo);
				bean.setWlid(null);
				bean.setCreater(user.getUserRealName());
				bean.setUpdater(user.getUserRealName());
				bean.setCreateDate(new Date());
				bean.setUpdateDate(new Date());
				bean.setOrgid(user.getOrgid());
				bean.setOrgName(user.getOrgName());
				whiteListRepository.save(bean);
			}else {
				if(StringUtil.isNotBlank(vo.getCommitmentFile())) {
					bean.setCommitmentStatus(vo.getCommitmentStatus());
					bean.setCommitmentFile(vo.getCommitmentFile());
				}
				if(StringUtil.isNotBlank(vo.getApplyFile())) {
					bean.setApplyFile(vo.getApplyFile());
					bean.setApplyStatus(vo.getApplyStatus());
				}
				if(StringUtil.isNotBlank(vo.getInformationFile())) {
					bean.setInformationStatus(vo.getInformationStatus());
					bean.setInformationFile(vo.getInformationFile());
				}
				if(StringUtil.isNotBlank(vo.getCopyFile())) {
					bean.setCopyStatus(vo.getCopyStatus());
					bean.setCopyFile(vo.getCopyFile());
				}
				if(StringUtil.isNotBlank(vo.getConventionFile())) {
					bean.setConventionStatus(vo.getConventionStatus());
					bean.setConventionFile(vo.getConventionFile());
				}
				if(StringUtil.isNotBlank(vo.getVerificationFile())) {
					bean.setVerificationStatus(vo.getVerificationStatus());
					bean.setVerificationFile(vo.getVerificationFile());
				}
				if(StringUtil.isNotBlank(vo.getWlNo())) {
					bean.setWlNo(vo.getWlNo());
					bean.setValidDate(vo.getValidDate());
					bean.setStatus(vo.getStatus());
				}
			}
			return bean.getWlid();
		} catch (ServiceException e) {
			if (e.getErrorMsg() ==  null) {
				e.setErrorMsg("修改白名单条目失败");
			}
			throw e;
		} catch (Exception e) {
			throw new ServiceException("修改白名单条目失败", e);
		}
	}


	@Override
	@Transactional(propagation = Propagation.NOT_SUPPORTED,rollbackFor = Exception.class)
	public List<WhiteListVo> getBeansByOrgid(List<Long> orgid) throws ServiceException {
		try {
			return (List<WhiteListVo>) transfer.transferCollectionEntityToBaseVos(
						whiteListRepository.findByOrgidIn(orgid));
		}catch(Exception e){
			throw new ServiceException("获取白名单详细信息失败!",e);
		}
	}

}
