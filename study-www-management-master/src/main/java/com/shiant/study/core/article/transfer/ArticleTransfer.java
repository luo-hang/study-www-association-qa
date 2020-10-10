package com.shiant.study.core.article.transfer;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.shiant.common.exception.ServiceException;
import com.shiant.common.transfer.BaseTransfer;
import com.shiant.study.core.article.model.Article;
import com.shiant.study.core.article.vo.ArticleVo;

public class ArticleTransfer implements BaseTransfer<Article,ArticleVo>{

	@Override
	public ArticleVo transferEntityToBaseVo(Article entity) throws ServiceException {
		try {
			if (entity == null) {
				return null;
			}
			ArticleVo vo = new ArticleVo();
			vo.setTitle(entity.getTitle());
			vo.setCoverFile(entity.getCoverFile());
			vo.setContent(entity.getContent());
			vo.setShowTime(entity.getShowTime());
			vo.setCreateDate(entity.getCreateDate());
			vo.setCreater(entity.getCreater());
			vo.setUpdateDate(entity.getUpdateDate());
			vo.setUpdater(entity.getUpdater());
			vo.setAid(entity.getAid());
			vo.setType(entity.getType());
			return vo;
		} catch (Exception e) {
			throw new ServiceException("文章基本VO转换失败！", e);
		}
	}

	@Override
	public ArticleVo transferEntityToFullVo(Article entity) throws ServiceException {
		try {
			return transferEntityToBaseVo(entity);
		} catch (Exception e) {
			throw new ServiceException("文章完整VO转换失败!", e);
		}
	}

	@Override
	public Article transferVoToEntity(ArticleVo vo) throws ServiceException {
		try {
			if (vo == null) {
				return null;
			}
			Article entity = new Article();
			entity.setTitle(vo.getTitle());
			entity.setCoverFile(vo.getCoverFile());
			entity.setContent(vo.getContent());
			entity.setShowTime(vo.getShowTime());
			entity.setCreateDate(vo.getCreateDate());
			entity.setCreater(vo.getCreater());
			entity.setUpdateDate(vo.getUpdateDate());
			entity.setUpdater(vo.getUpdater());
			entity.setAid(vo.getAid());
			entity.setType(vo.getType());
			return entity;
		} catch (Exception e) {
			throw new ServiceException("文章转换失败",e);
		}
	}

	@Override
	public Collection<ArticleVo> transferCollectionEntityToBaseVos(Collection<Article> entitys) throws ServiceException {
		List<ArticleVo> vos = new ArrayList<ArticleVo>();
		if (entitys != null) {
			for (Article entity : entitys) {
				vos.add(transferEntityToBaseVo(entity));
			}
		}
		return vos;
	}

	@Override
	public Collection<ArticleVo> transferCollectionEntityToFullVos(Collection<Article> entitys) throws ServiceException {
		List<ArticleVo> vos = new ArrayList<ArticleVo>();
		if(entitys != null){
			for(Article entity : entitys){
				vos.add(transferEntityToFullVo(entity));
			}
		}
		return vos;
	}

	@Override
	public Collection<Article> transferCollectionVoToEntitys(Collection<ArticleVo> entitys) throws ServiceException {
		List<Article> vos = new ArrayList<>();
		if (entitys != null) {
			for (ArticleVo entity : entitys) {
				vos.add(transferVoToEntity(entity));
			}
		}
		return vos;
	}

}
