package com.shiant.study.core.article.service.impl;

import com.shiant.common.exception.ServiceException;
import com.shiant.common.util.StringUtil;
import com.shiant.rmi.user.vo.UserRmiVo;
import com.shiant.study.core.article.dao.ArticleRepository;
import com.shiant.study.core.article.model.Article;
import com.shiant.study.core.article.service.ArticleService;
import com.shiant.study.core.article.transfer.ArticleTransfer;
import com.shiant.study.core.article.vo.ArticleVo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class ArticleServiceImpl implements ArticleService {

	@Autowired
	private ArticleRepository articleRepository;

	private static ArticleTransfer transfer = new ArticleTransfer();
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public Long addBean(ArticleVo bean, UserRmiVo user) throws ServiceException {
		try {
			Article entity = transfer.transferVoToEntity(bean);
			entity.setAid(null);
			entity.setCreateDate(new Date());
			entity.setCreater(user.getUserRealName());
			entity.setUpdateDate(new Date());
			entity.setUpdater(user.getUserRealName());
			entity.setShowTime(0L);
			
			articleRepository.save(entity);
			return entity.getAid();
		} catch (ServiceException e) {
			if (e.getErrorMsg() ==  null) {
				e.setErrorMsg("添加文章失败");
			}
			throw e;
		} catch (Exception e) {
			throw new ServiceException("添加文章失败!", e);
		}
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
	public void updateBean(ArticleVo vo, UserRmiVo user) throws ServiceException {
		try {
			Article bean = articleRepository.findById(vo.getAid()).orElse(null);
			if(bean != null) {
				bean.setUpdateDate(new Date());
				bean.setUpdater(user.getUserRealName());
			}else {
				throw new ServiceException("未找到相关文章信息!");
			}
		}catch(ServiceException e){
			if(e.getErrorMsg() == null){
				e.setErrorMsg("更新文章");
			}
			throw new ServiceException(e.getErrorMsg(),e);
		}catch(Exception e){
			throw new ServiceException("更新文章失败!",e);
		}
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
	public void deleteBean(Long id,UserRmiVo user) throws ServiceException {
		try {
			articleRepository.deleteById(id);
		} catch (Exception e) {
			throw new ServiceException("删除文章失败!",e);
		}
	}
	
	@Override
	@Transactional(propagation = Propagation.NOT_SUPPORTED)
	public Map<String, Object> getBeans(int from, int size, String type) throws ServiceException {
		try {
			Map<String, Object> maps = new HashMap<String, Object>();
			Sort sort = Sort.by(Direction.DESC, "updateDate");
			Pageable pageable = PageRequest.of(from-1, size, sort);
			Page<Article> beans = null;
			if(StringUtil.isNotBlank(type)) {
				Map<String,Collection<ArticleVo>> beanMap = new HashMap<>();
				String[] ts = type.split(";");
				for(String t : ts) {
					beans = articleRepository.findByType(t,pageable);
					if(beans.getSize()>0) {
						Collection<ArticleVo> vos = transfer.transferCollectionEntityToBaseVos(beans.getContent());
						beanMap.put(t, vos);
					}
				}
				maps.put("beans", beanMap);
			}else {
				beans = articleRepository.findAll(pageable);
				if(beans.getSize()>0) {
					Collection<ArticleVo> vos = transfer.transferCollectionEntityToBaseVos(beans.getContent());
					maps.put("beans", vos);
				}else {
					maps.put("beans",new ArrayList<>());
				}
				maps.put("total", beans.getTotalElements());
				maps.put("totalPages", beans.getTotalPages());
			}
			return maps;
		}catch(Exception e){
			throw new ServiceException("根据条件分页获取文章集合服务失败!",e);
		}
	}
	
	@Override
	@Transactional(propagation = Propagation.NOT_SUPPORTED,rollbackFor = Exception.class)
	public ArticleVo getBean(Long id, UserRmiVo user) throws ServiceException {
		try {
			return transfer.transferEntityToBaseVo(articleRepository.findById(id).orElse(null));
		}catch(Exception e){
			throw new ServiceException("根据文章编号获取实体失败!",e);
		}
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
	public void addShowTime(Long cid, UserRmiVo user) throws ServiceException {
//		try {
//			if(!cid2Time.containsKey(cid)) {
//				Article bean = articleRepository.findById(cid).orElse(null);
//				Long num = 0L;
//				if(!StringUtil.isBlank(bean.getShowTime())) {
//					num = bean.getShowTime();
//				}
//				cid2Time.put(cid, num);
//			}
//			
//			cid2Time.put(cid, cid2Time.get(cid)+1);
//			if(cid2Time.get(cid)%10 == 0) {
//				Article bean = articleRepository.findById(cid).orElse(null);
//				bean.setShowTime(cid2Time.get(cid));
//			}
//		}catch(Exception e){
//			throw new ServiceException("增加浏览次数失败!",e);
//		}
	}

}
