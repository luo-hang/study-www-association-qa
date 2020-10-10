package com.shiant.study.core.demo.service.impl;

import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Arrays;
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
import com.shiant.study.core.demo.dao.CaseRepository;
import com.shiant.study.core.demo.model.Case;
import com.shiant.study.core.demo.model.CaseToAdviser;
import com.shiant.study.core.demo.service.CaseService;
import com.shiant.study.core.demo.service.CaseToAdviserService;
import com.shiant.study.core.demo.transfer.CaseTransfer;
import com.shiant.study.core.demo.vo.CaseVo;


@Service(value = "/caseService")
public class CaseServiceImpl implements CaseService {

	@Autowired
	private CaseRepository caseRepository;
	
	@Autowired
	private CaseToAdviserService caseToAdviserService;

	private static CaseTransfer transfer = new CaseTransfer();
	
	public static Map<Long,Long> cid2Time = new HashMap<>();
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public Long addBean(CaseVo bean, UserRmiVo user) throws ServiceException {
		try {
			Case entity = transfer.transferVoToEntity(bean);
			entity.setCid(null);
			entity.setCreateDate(new Date());
			entity.setCreater(user.getUserRealName());
			entity.setUpdateDate(new Date());
			entity.setUpdater(user.getUserRealName());
			entity.setOrgid(user.getOrgid());
			entity.setOrgName(user.getOrgName());
			entity.setPublic(true);
			caseRepository.save(entity);
			
			String[] aids = bean.getAids().split(",");
			for(String aid:aids) {
				CaseToAdviser cta = new CaseToAdviser();
				cta.setAid(Long.parseLong(aid));
				cta.setCid(entity.getCid());
				caseToAdviserService.addBean(cta, user);
			}
			
			return entity.getCid();
		} catch (ServiceException e) {
			if (e.getErrorMsg() ==  null) {
				e.setErrorMsg("添加案例失败");
			}
			throw e;
		} catch (Exception e) {
			throw new ServiceException("添加案例失败!", e);
		}
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
	public void updateBean(CaseVo vo, UserRmiVo user) throws ServiceException {
		try {
			Case bean = caseRepository.findById(vo.getCid()).orElse(null);
			if(bean != null) {
				bean.setUpdateDate(new Date());
				bean.setUpdater(user.getUserRealName());
				bean.setContent(vo.getContent());
				bean.setOrder(vo.getOrder());
				bean.setTitle(vo.getTitle());
				bean.setCoverFile(vo.getCoverFile());
				bean.setOrgid(user.getOrgid());
				bean.setOrgName(user.getOrgName());
				bean.setPublic(vo.isPublic());
				bean.setShowTime(vo.getShowTime());
				bean.setSchool(vo.getSchool());
				bean.setMajor(vo.getMajor());
				bean.setGrade(vo.getGrade());
				bean.setStudentName(vo.getStudentName());
				
				String[] aids = vo.getAids().split(",");
				List<Long> ids= new ArrayList<>();
				for(String aid:aids) {
					ids.add(Long.parseLong(aid));
				}
				caseToAdviserService.updateBean(Arrays.asList(bean.getCid()), ids, user);
				cid2Time.remove(vo.getCid());
			}else {
				throw new ServiceException("未找到相关案例信息!");
			}
		}catch(ServiceException e){
			if(e.getErrorMsg() == null){
				e.setErrorMsg("更新案例");
			}
			throw new ServiceException(e.getErrorMsg(),e);
		}catch(Exception e){
			throw new ServiceException("更新案例失败!",e);
		}
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
	public void deleteBean(Long id,UserRmiVo user) throws ServiceException {
		try {
//			Case bean = caseRepository.findById(id).orElse(null);
//			bean.setDelete(true);
//			bean.setUpdater(user.getUserRealName());
//			bean.setUpdateDate(new Date());
			caseRepository.deleteById(id);
//		} catch (ServiceException e) {
//			if (e.getErrorMsg() == null) {
//				e.setErrorMsg("删除案例数据操作失败!");
//			}
//			throw new ServiceException(e.getErrorMsg(),e);
		} catch (Exception e) {
			throw new ServiceException("删除案例失败!",e);
		}
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
	public void stop(Long id, UserRmiVo user) throws ServiceException {
		try {
			Case bean = caseRepository.findById(id).orElse(null);
			bean.setPublic(false);
			bean.setUpdater(user.getUserRealName());
			bean.setUpdateDate(new Date());
		} catch (Exception e) {
			throw new ServiceException("下架案例失败!",e);
		}
	}

	@Override
	@Transactional(propagation = Propagation.NOT_SUPPORTED)
	public Map<String, Object> getBeans(int from,int size,String keyWord, Boolean isPublic, UserRmiVo user) throws ServiceException {
		try {
			Map<String, Object> maps = new HashMap<String, Object>();
			Sort sort = Sort.by(Direction.DESC, "updateDate");
			Pageable pageable = PageRequest.of(from-1, size, sort);
			if(isPublic == null && StringUtil.isBlank(keyWord)) {
				Page<Case> beans = caseRepository.findByOrgid(user.getOrgid(),pageable);
				if(beans.getSize()>0) {
					Collection<CaseVo> vos = transfer.transferCollectionEntityToBaseVos(beans.getContent());
					for(CaseVo vo : vos) {
						if(cid2Time.containsKey(vo.getCid())) {
							vo.setShowTime(cid2Time.get(vo.getCid()));
						}
					}
					maps.put("beans", vos);
				}else {
					maps.put("beans",new ArrayList<>());
				}
				maps.put("total", beans.getTotalElements());
				maps.put("totalPages", beans.getTotalPages());
			}else if(isPublic == null && StringUtil.isNotBlank(keyWord)) {
				keyWord = URLDecoder.decode(URLDecoder.decode(keyWord, "utf8"),"utf8");
				Page<Case> beans = caseRepository.findByOrgidAndTitleLike(user.getOrgid(),"%"+keyWord+"%",pageable);
				if(beans.getSize()>0) {
					Collection<CaseVo> vos = transfer.transferCollectionEntityToBaseVos(beans.getContent());
					for(CaseVo vo : vos) {
						if(cid2Time.containsKey(vo.getCid())) {
							vo.setShowTime(cid2Time.get(vo.getCid()));
						}
					}
					maps.put("beans", vos);
				}else {
					maps.put("beans",new ArrayList<>());
				}
				maps.put("total", beans.getTotalElements());
				maps.put("totalPages", beans.getTotalPages());
			}else if(isPublic != null && StringUtil.isBlank(keyWord)) {
				Page<Case> beans = caseRepository.findByOrgidAndIsPublic(user.getOrgid(), isPublic, pageable);
				if(beans.getSize()>0) {
					Collection<CaseVo> vos = transfer.transferCollectionEntityToBaseVos(beans.getContent());
					for(CaseVo vo : vos) {
						if(cid2Time.containsKey(vo.getCid())) {
							vo.setShowTime(cid2Time.get(vo.getCid()));
						}
					}
					maps.put("beans", vos);
				}else {
					maps.put("beans",new ArrayList<>());
				}
				maps.put("total", beans.getTotalElements());
				maps.put("totalPages", beans.getTotalPages());
			}else if(isPublic != null && StringUtil.isNotBlank(keyWord)) {
				Page<Case> beans = caseRepository.findByOrgidAndTitleLikeAndIsPublic(user.getOrgid(), "%"+keyWord+"%", isPublic, pageable);
				if(beans.getSize()>0) {
					Collection<CaseVo> vos = transfer.transferCollectionEntityToBaseVos(beans.getContent());
					for(CaseVo vo : vos) {
						if(cid2Time.containsKey(vo.getCid())) {
							vo.setShowTime(cid2Time.get(vo.getCid()));
						}
					}
					maps.put("beans", vos);
				}else {
					maps.put("beans",new ArrayList<>());
				}
				maps.put("total", beans.getTotalElements());
				maps.put("totalPages", beans.getTotalPages());
			}
			return maps;
		}catch(Exception e){
			throw new ServiceException("根据条件分页获取案例集合服务失败!",e);
		}
	}
	
	@Override
	@Transactional(propagation = Propagation.NOT_SUPPORTED)
	public Map<String, Object> getBeansByOrgid(int from, int size, Long orgid) throws ServiceException {
		try {
			Map<String, Object> maps = new HashMap<String, Object>();
			Sort sort = Sort.by(Direction.DESC, "updateDate");
			Pageable pageable = PageRequest.of(from-1, size, sort);
			
			Page<Case> beans = caseRepository.findByOrgid(orgid,pageable);
			if(beans.getSize()>0) {
				Collection<CaseVo> vos = transfer.transferCollectionEntityToBaseVos(beans.getContent());
				for(CaseVo vo : vos) {
					if(cid2Time.containsKey(vo.getCid())) {
						vo.setShowTime(cid2Time.get(vo.getCid()));
					}
				}
				maps.put("beans", vos);
			}else {
				maps.put("beans",new ArrayList<>());
			}
			maps.put("total", beans.getTotalElements());
			maps.put("totalPages", beans.getTotalPages());
			return maps;
		}catch(Exception e){
			throw new ServiceException("根据机构获取案例失败",e);
		}
	}
	
	@Override
	@Transactional(propagation = Propagation.NOT_SUPPORTED)
	public Map<String, Object> getBeansByAdviser(int from, int size, Long aid) throws ServiceException {
		try {
			Map<String, Object> maps = new HashMap<String, Object>();
			List<Case> beans = caseToAdviserService.getCasesByAid(aid);
			
			if(!beans.isEmpty()) {
				Collection<CaseVo> vos = transfer.transferCollectionEntityToBaseVos(beans);
				for(CaseVo vo : vos) {
					if(cid2Time.containsKey(vo.getCid())) {
						vo.setShowTime(cid2Time.get(vo.getCid()));
					}
				}
				maps.put("beans", vos);
			}else {
				maps.put("beans",new ArrayList<>());
			}
			return maps;
		}catch(Exception e){
			throw new ServiceException("根据机构获取案例失败",e);
		}
	}
	
	@Override
	@Transactional(propagation = Propagation.NOT_SUPPORTED)
	public Map<String, Object> getBeansByHot(int from, int size) throws ServiceException {
		try {
			Map<String, Object> maps = new HashMap<String, Object>();
			Sort sort = Sort.by(Direction.DESC, "createDate");
			Pageable pageable = PageRequest.of(from-1, size, sort);
			Page<Case> beans = caseRepository.findAll(pageable);
			if(beans.getSize()>0) {
				Collection<CaseVo> vos = transfer.transferCollectionEntityToBaseVos(beans.getContent());
				for(CaseVo vo : vos) {
					if(cid2Time.containsKey(vo.getCid())) {
						vo.setShowTime(cid2Time.get(vo.getCid()));
					}
				}
				maps.put("beans", vos);
			}else {
				maps.put("beans",new ArrayList<>());
			}
			maps.put("total", beans.getTotalElements());
			maps.put("totalPages", beans.getTotalPages());
			return maps;
		}catch(Exception e){
			throw new ServiceException("获取热门案例失败",e);
		}
	}
	
	@Override
	@Transactional(propagation = Propagation.NOT_SUPPORTED,rollbackFor = Exception.class)
	public CaseVo getBean(Long id, UserRmiVo user) throws ServiceException {
		try {
			return transfer.transferEntityToBaseVo(caseRepository.findById(id).orElse(null));
		}catch(Exception e){
			throw new ServiceException("根据案例编号获取实体失败!",e);
		}
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
	public void addShowTime(Long cid, UserRmiVo user) throws ServiceException {
		try {
			if(!cid2Time.containsKey(cid)) {
				Case bean = caseRepository.findById(cid).orElse(null);
				Long num = 0L;
				if(!StringUtil.isBlank(bean.getShowTime())) {
					num = bean.getShowTime();
				}
				cid2Time.put(cid, num);
			}
			
			cid2Time.put(cid, cid2Time.get(cid)+1);
			if(cid2Time.get(cid)%10 == 0) {
				Case bean = caseRepository.findById(cid).orElse(null);
				bean.setShowTime(cid2Time.get(cid));
			}
		}catch(Exception e){
			throw new ServiceException("增加浏览次数失败!",e);
		}
	}

}
