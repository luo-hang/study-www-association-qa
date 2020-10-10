package com.shiant.study.core.adviser.service.impl;

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
import com.shiant.study.core.adviser.dao.AdviserDao;
import com.shiant.study.core.adviser.dao.AdviserRepository;
import com.shiant.study.core.adviser.model.Adviser;
import com.shiant.study.core.adviser.service.AdviserService;
import com.shiant.study.core.adviser.transfer.AdviserTransfer;
import com.shiant.study.core.adviser.vo.AdviserVo;
import com.shiant.study.core.demo.service.CaseToAdviserService;


@Service(value = "/adviserService")
public class AdviserServiceImpl implements AdviserService {

	@Autowired
	private AdviserRepository adviserRepository;

	@Autowired
	private AdviserDao adviserDao;

	@Autowired
	private CaseToAdviserService caseToAdviserService;

	private static AdviserTransfer transfer = new AdviserTransfer();
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public Long addBean(AdviserVo bean, UserRmiVo user) throws ServiceException {
		try {
			Adviser entity = transfer.transferVoToEntity(bean);
			entity.setAid(null);
			entity.setCreateDate(new Date());
			entity.setCreater(user.getUserRealName());
			entity.setUpdateDate(new Date());
			entity.setUpdater(user.getUserRealName());
			entity.setOrgid(user.getOrgid());
			entity.setOrgName(user.getOrgName());
			entity.setPublic(true);
			entity.setOrder(1);
			entity.setShowTime(0L);
			
			adviserRepository.save(entity);
			return entity.getAid();
		} catch (ServiceException e) {
			if (e.getErrorMsg() ==  null) {
				e.setErrorMsg("添加顾问失败");
			}
			throw e;
		} catch (Exception e) {
			throw new ServiceException("添加顾问失败!", e);
		}
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
	public void updateBean(AdviserVo vo, UserRmiVo user) throws ServiceException {
		try {
			Adviser bean = adviserRepository.findById(vo.getAid()).orElse(null);
			if(bean != null) {
				bean.setUpdateDate(new Date());
				bean.setUpdater(user.getUserRealName());
				if(StringUtil.isNotBlank(vo.getName())) {
					bean.setName(vo.getName());
				}
				if(StringUtil.isNotBlank(vo.getCoverFile())) {
					bean.setCoverFile(vo.getCoverFile());
				}
				if(StringUtil.isNotBlank(vo.getTitle())) {
					bean.setTitle(vo.getTitle());
				}
				if(StringUtil.isNotBlank(vo.getBackground())) {
					bean.setBackground(vo.getBackground());
				}
				if(StringUtil.isNotBlank(vo.getWorkingTime())) {
					bean.setWorkingTime(vo.getWorkingTime());
				}
				if(StringUtil.isNotBlank(vo.getItems())) {
					bean.setItems(vo.getItems());
				}
				if(StringUtil.isNotBlank(vo.getCity())) {
					bean.setItems(vo.getItems());
				}
				if(StringUtil.isNotBlank(vo.getContent())) {
					bean.setContent(vo.getContent());
				}
				if(StringUtil.isNotBlank(vo.getAbility1())) {
					bean.setAbility1(vo.getAbility1());
				}
				if(StringUtil.isNotBlank(vo.getAbility2())) {
					bean.setAbility2(vo.getAbility2());
				}
				if(StringUtil.isNotBlank(vo.getAbility3())) {
					bean.setAbility3(vo.getAbility3());
				}
				if(StringUtil.isNotBlank(vo.getAbility4())) {
					bean.setAbility4(vo.getAbility4());
				}
				if(StringUtil.isNotBlank(vo.getAbility5())) {
					bean.setAbility5(vo.getAbility5());
				}
				if(StringUtil.isNotBlank(vo.getAbility6())) {
					bean.setAbility6(vo.getAbility6());
				}
				if(StringUtil.isNotBlank(vo.getAbility7())) {
					bean.setAbility7(vo.getAbility7());
				}
				if(StringUtil.isNotBlank(vo.getAbility8())) {
					bean.setAbility8(vo.getAbility8());
				}
				if(StringUtil.isNotBlank(vo.getAbility9())) {
					bean.setAbility9(vo.getAbility9());
				}
				if(StringUtil.isNotBlank(vo.getAbility10())) {
					bean.setAbility10(vo.getAbility10());
				}
				if(StringUtil.isNotBlank(vo.getAbility11())) {
					bean.setAbility11(vo.getAbility11());
				}
				if(StringUtil.isNotBlank(vo.getAbility12())) {
					bean.setAbility12(vo.getAbility12());
				}
				if(StringUtil.isNotBlank(vo.getAbility13())) {
					bean.setAbility13(vo.getAbility13());
				}
				if(StringUtil.isNotBlank(vo.getAbility14())) {
					bean.setAbility14(vo.getAbility14());
				}
				if(StringUtil.isNotBlank(vo.getAbility15())) {
					bean.setAbility15(vo.getAbility15());
				}
				if(StringUtil.isNotBlank(vo.getAbility16())) {
					bean.setAbility16(vo.getAbility16());
				}
				if(StringUtil.isNotBlank(vo.getAbility17())) {
					bean.setAbility17(vo.getAbility17());
				}
				if(StringUtil.isNotBlank(vo.getAbility18())) {
					bean.setAbility18(vo.getAbility18());
				}
				if(StringUtil.isNotBlank(vo.getAbility19())) {
					bean.setAbility19(vo.getAbility19());
				}
				if(StringUtil.isNotBlank(vo.getAbility20())) {
					bean.setAbility20(vo.getAbility20());
				}
			}else {
				throw new ServiceException("未找到相关顾问信息!");
			}
		}catch(ServiceException e){
			if(e.getErrorMsg() == null){
				e.setErrorMsg("更新顾问");
			}
			throw new ServiceException(e.getErrorMsg(),e);
		}catch(Exception e){
			throw new ServiceException("更新顾问失败!",e);
		}
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
	public void deleteBean(Long id,UserRmiVo user) throws ServiceException {
		try {
//			Adviser bean = adviserRepository.findById(id).orElse(null);
//			bean.setDelete(true);
//			bean.setUpdater(user.getUserRealName());
//			bean.setUpdateDate(new Date());
			adviserRepository.deleteById(id);
//		} catch (ServiceException e) {
//			if (e.getErrorMsg() == null) {
//				e.setErrorMsg("删除顾问数据操作失败!");
//			}
//			throw new ServiceException(e.getErrorMsg(),e);
		} catch (Exception e) {
			throw new ServiceException("删除顾问失败!",e);
		}
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
	public void stop(Long id, UserRmiVo user) throws ServiceException {
		try {
			Adviser bean = adviserRepository.findById(id).orElse(null);
			bean.setPublic(false);
			bean.setUpdater(user.getUserRealName());
			bean.setUpdateDate(new Date());
		} catch (Exception e) {
			throw new ServiceException("下架顾问失败!",e);
		}
	}

	@Override
	@Transactional(propagation = Propagation.NOT_SUPPORTED)
	public Map<String, Object> getBeans(int from, int size, String name, Long orgid) throws ServiceException {
		try {
			Map<String, Object> maps = new HashMap<String, Object>();
			Sort sort = Sort.by(Direction.DESC, "updateDate");
			Pageable pageable = PageRequest.of(from-1, size, sort);
			Page<Adviser> beans = null;
			if(StringUtil.isBlank(orgid)&&StringUtil.isBlank(name)) {
				beans = adviserRepository.findAll(pageable);
			}else if(StringUtil.isBlank(orgid)&&StringUtil.isNotBlank(name)) {
				name = URLDecoder.decode(URLDecoder.decode(name, "utf8"),"utf8");
				beans = adviserRepository.findByNameLike("%"+name+"%",pageable);
			}else if(StringUtil.isNotBlank(orgid)&&StringUtil.isBlank(name)) {
				beans = adviserRepository.findByOrgid(orgid,pageable);
			}else if(StringUtil.isNotBlank(orgid)&&StringUtil.isNotBlank(name)) {
				name = URLDecoder.decode(URLDecoder.decode(name, "utf8"),"utf8");
				beans = adviserRepository.findByOrgidAndNameLike(orgid,"%"+name+"%",pageable);
			}
			if(beans.getSize()>0) {
				Collection<AdviserVo> vos = transfer.transferCollectionEntityToBaseVos(beans.getContent());
				List<Long> aids = new ArrayList<>();
				for(AdviserVo vo : vos) {
					aids.add(vo.getAid());
				}
				if(!aids.isEmpty()) {
					Map<Long, Long> map = caseToAdviserService.getCountByAid(aids);
					for(AdviserVo vo : vos) {
						if(map.containsKey(vo.getAid())) {
							vo.setCaseNum(map.get(vo.getAid()));
						}else {
							vo.setCaseNum(0L);
						}
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
			throw new ServiceException("根据条件分页获取顾问集合服务失败!",e);
		}
	}
	
	@Override
	@Transactional(propagation = Propagation.NOT_SUPPORTED,rollbackFor = Exception.class)
	public AdviserVo getBean(Long id, UserRmiVo user) throws ServiceException {
		try {
			return transfer.transferEntityToBaseVo(adviserRepository.findById(id).orElse(null));
		}catch(Exception e){
			throw new ServiceException("根据顾问编号获取实体失败!",e);
		}
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
	public void addShowTime(Long cid, UserRmiVo user) throws ServiceException {
//		try {
//			if(!cid2Time.containsKey(cid)) {
//				Adviser bean = adviserRepository.findById(cid).orElse(null);
//				Long num = 0L;
//				if(!StringUtil.isBlank(bean.getShowTime())) {
//					num = bean.getShowTime();
//				}
//				cid2Time.put(cid, num);
//			}
//			
//			cid2Time.put(cid, cid2Time.get(cid)+1);
//			if(cid2Time.get(cid)%10 == 0) {
//				Adviser bean = adviserRepository.findById(cid).orElse(null);
//				bean.setShowTime(cid2Time.get(cid));
//			}
//		}catch(Exception e){
//			throw new ServiceException("增加浏览次数失败!",e);
//		}
	}

	@Override
	@Transactional(propagation = Propagation.NOT_SUPPORTED,rollbackFor = Exception.class)
	public List<AdviserVo> getBeansByCid(Long cid, UserRmiVo user) throws ServiceException {
		try {
			return caseToAdviserService.getAdvisersByCid(cid, user);
		}catch(Exception e){
			throw new ServiceException("根据案例编号获取顾问失败",e);
		}
	}

	@Override
	@Transactional(propagation = Propagation.NOT_SUPPORTED,rollbackFor = Exception.class)
	public List<Adviser> getBeansByAbility(int from,int size,String ability) throws ServiceException {
		try {
			return adviserDao.getAdvisersByAbility(from, size, ability);
		}catch(Exception e){
			throw new ServiceException("根据能力获取顾问对应机构失败",e);
		}
	}

}
