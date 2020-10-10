package com.shiant.study.core.system.service.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.shiant.common.exception.ServiceException;
import com.shiant.common.util.StringUtil;
import com.shiant.rmi.user.OrganizationRmiService;
import com.shiant.rmi.user.vo.OrganizationRmiVo;
import com.shiant.study.core.adviser.model.Adviser;
import com.shiant.study.core.adviser.service.AdviserService;
import com.shiant.study.core.demo.service.CaseService;
import com.shiant.study.core.demo.vo.CaseVo;
import com.shiant.study.core.system.service.OrganizationService;
import com.shiant.study.core.system.vo.OrganizationVo;
import com.shiant.study.core.whiteList.service.WhiteListService;
import com.shiant.study.core.whiteList.vo.WhiteListVo;


@Service(value = "/organizationService")
public class OrganizationServiceImpl implements OrganizationService {
	
	@Autowired
	private AdviserService adviserService;
	
	@Autowired
	private WhiteListService whiteListService;
	
	@Autowired
	private CaseService caseService;

	@Autowired
	private OrganizationRmiService organizationRmiService;

	@Override
	@Transactional(propagation = Propagation.NOT_SUPPORTED,rollbackFor = Exception.class)
	public Map<String, Object> getBeansByAbility(int page, int limit, String ability) throws ServiceException {
		try {
			List<Adviser> advisers = adviserService.getBeansByAbility(page, limit, ability);
			List<Long> orgids = new ArrayList<Long>();
			for(Adviser adviser : advisers) {
				orgids.add(adviser.getOrgid());
			}
			List<OrganizationRmiVo> orgs = organizationRmiService.getBeans(orgids);
			List<WhiteListVo> wls = new ArrayList<WhiteListVo>();
			if(!orgids.isEmpty()) {
				wls = whiteListService.getBeansByOrgid(orgids);
			}
			
			List<OrganizationVo> os = new ArrayList<>();
			for(OrganizationRmiVo org : orgs) {
				boolean isWl = false;
				for(WhiteListVo wl : wls) {
					if(wl.getOrgid().intValue() == org.getOrgid().intValue()) {
						isWl = true;
						break;
					}
				}
				if(isWl) {
					OrganizationVo o = new OrganizationVo(org);
					o.setWl(true);
					os.add(o);
				}else {
					OrganizationVo o = new OrganizationVo(org);
					o.setWl(false);
					os.add(o);
				}
			}
			Map<String,Object> map = new HashMap<>();
			map.put("beans", os);
			return map;
		} catch (ServiceException e) {
			if (e.getErrorMsg() ==  null) {
				e.setErrorMsg("根据能力获取机构失败");
			}
			throw e;
		} catch (Exception e) {
			throw new ServiceException("根据能力获取机构失败", e);
		}
	}

	@Override
	@Transactional(propagation = Propagation.NOT_SUPPORTED,rollbackFor = Exception.class)
	public Map<String, Object> getBeansByQuery(int page, int limit, String province, String country,
			String ability, String year) throws ServiceException {
		try {
			List<Long> orgids = null;
			if(StringUtil.isNotBlank(ability)) {
				List<Adviser> advisers = adviserService.getBeansByAbility(page, limit, ability);
				orgids = new ArrayList<Long>();
				for(Adviser adviser : advisers) {
					orgids.add(adviser.getOrgid());
				}
			}
			Date startYear = null;
			Date endYear = null;
			if(StringUtil.isNotBlank(year)) {
				if("1-5年".equals(year)) {
					startYear = new Date(new Date().getTime()-60*60*24*365);
					endYear = new Date(new Date().getTime()-60*60*24*365*5);
				}else if("5-10年".equals(year)) {
					startYear = new Date(new Date().getTime()-60*60*24*365*5);
					endYear = new Date(new Date().getTime()-60*60*24*365*10);
				}else if("10年以上".equals(year)) {
					startYear = new Date(new Date().getTime()-60*60*24*365*10);
				}
			}
			
			Map<String, Object> maps = organizationRmiService.getBeansByQuery(page, limit, orgids, province, startYear, endYear);
			@SuppressWarnings("unchecked")
			List<OrganizationRmiVo> orgs = (List<OrganizationRmiVo>) maps.get("beans");
			orgids = new ArrayList<Long>();
			for(OrganizationRmiVo org : orgs) {
				orgids.add(org.getOrgid());
			}
			List<WhiteListVo> wls = new ArrayList<WhiteListVo>();
			if(!orgids.isEmpty()) {
				wls = whiteListService.getBeansByOrgid(orgids);
			}
			
			List<OrganizationVo> os = new ArrayList<>();
			for(OrganizationRmiVo org : orgs) {
				boolean isWl = false;
				for(WhiteListVo wl : wls) {
					if(wl.getOrgid().intValue() == org.getOrgid().intValue()) {
						isWl = true;
						break;
					}
				}
				OrganizationVo o = new OrganizationVo(org);
				if(isWl) {
					o.setWl(true);
				}else {
					o.setWl(false);
				}
				Map<String, Object> cases = caseService.getBeansByOrgid(1, 1, org.getOrgid());
				@SuppressWarnings("unchecked")
				Collection<CaseVo> cs = (Collection<CaseVo>) cases.get("beans");
				if(!cs.isEmpty()) {
					o.setCaseVo(cs.iterator().next());	
				}
				os.add(o);
			}
			Map<String,Object> map = new HashMap<>();
			map.put("beans", os);
			map.put("count", maps.get("total"));
			return map;
		} catch (ServiceException e) {
			if (e.getErrorMsg() ==  null) {
				e.setErrorMsg("根据能力获取机构失败");
			}
			throw e;
		} catch (Exception e) {
			throw new ServiceException("根据能力获取机构失败", e);
		}
	}

}
