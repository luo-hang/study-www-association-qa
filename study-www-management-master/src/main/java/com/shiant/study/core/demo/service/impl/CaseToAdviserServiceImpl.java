package com.shiant.study.core.demo.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.shiant.common.exception.DaoException;
import com.shiant.common.exception.ServiceException;
import com.shiant.rmi.user.vo.UserRmiVo;
import com.shiant.study.core.adviser.model.Adviser;
import com.shiant.study.core.adviser.transfer.AdviserTransfer;
import com.shiant.study.core.adviser.vo.AdviserVo;
import com.shiant.study.core.demo.dao.CaseToAdviserDao;
import com.shiant.study.core.demo.dao.CaseToAdviserRepository;
import com.shiant.study.core.demo.model.Case;
import com.shiant.study.core.demo.model.CaseToAdviser;
import com.shiant.study.core.demo.service.CaseToAdviserService;


@Service(value = "/caseToAdviserService")
public class CaseToAdviserServiceImpl implements CaseToAdviserService {

	@Autowired
	private CaseToAdviserRepository caseToAdviserRepository;

	@Autowired
	private CaseToAdviserDao caseToAdviserDao;

	@Autowired
	private static AdviserTransfer transfer = new AdviserTransfer();

	@Override
	@Transactional(propagation = Propagation.NOT_SUPPORTED)
	public Map<Long, Long> getCountByAid(List<Long> aids) throws ServiceException {
		try {
			return caseToAdviserDao.getCountByAid(aids);
		} catch (DaoException e) {
			throw new ServiceException("根据顾问编号获取案例数量失败", e);
		} catch (Exception e) {
			throw new ServiceException("根据顾问编号获取案例数量失败", e);
		}
	}

	@Override
	@Transactional(propagation = Propagation.NOT_SUPPORTED)
	public List<AdviserVo> getAdvisersByCid(Long cid, UserRmiVo user) throws ServiceException {
		try {
			List<Adviser> beans = caseToAdviserDao.getAdvisersByCid(cid);
			return (List<AdviserVo>) transfer.transferCollectionEntityToBaseVos(beans);
		} catch (DaoException e) {
			throw new ServiceException("根据案例获取顾问失败", e);
		} catch (Exception e) {
			throw new ServiceException("根据案例获取顾问失败", e);
		}
	}
	
	@Override
	@Transactional(propagation = Propagation.NOT_SUPPORTED)
	public List<Case> getCasesByAid(Long aid) throws ServiceException {
		try {
			return  caseToAdviserDao.getCasesByAid(aid);
		} catch (DaoException e) {
			throw new ServiceException("根据顾问获取案例失败", e);
		} catch (Exception e) {
			throw new ServiceException("根据顾问获取案例失败", e);
		}
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public Long addBean(CaseToAdviser entity, UserRmiVo user) throws ServiceException {
		try {
			entity.setC2aid(null);
			caseToAdviserRepository.save(entity);
			return entity.getC2aid();
		} catch (Exception e) {
			throw new ServiceException("添加案例对应顾问失败!", e);
		}
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void updateBean(List<Long> cids, List<Long> aids, UserRmiVo user) throws ServiceException {
		try {
			for(Long cid : cids) {
				caseToAdviserRepository.deleteByCid(cid);
				for(Long aid : aids) {
					CaseToAdviser bean = new CaseToAdviser();
					bean.setAid(aid);
					bean.setCid(cid);
					addBean(bean, user);
				}
			}
		} catch (Exception e) {
			throw new ServiceException("更新案例对应顾问失败!", e);
		}
	}

}
