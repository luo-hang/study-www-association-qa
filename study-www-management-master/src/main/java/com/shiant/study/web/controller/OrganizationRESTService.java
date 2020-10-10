package com.shiant.study.web.controller;

import static com.shiant.study.web.util.IWebUtils.JSON;

import java.net.URLDecoder;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.View;

import com.shiant.rmi.user.OrganizationRmiService;
import com.shiant.rmi.user.UserRmiService;
import com.shiant.rmi.user.vo.OrganizationRmiVo;
import com.shiant.rmi.user.vo.UserRmiVo;
import com.shiant.study.core.system.service.OrganizationService;
import com.shiant.study.core.system.vo.OrganizationVo;
import com.shiant.study.core.whiteList.service.WhiteListService;
import com.shiant.study.core.whiteList.vo.WhiteListVo;
import com.shiant.study.web.util.IWebUtils;
import com.shiant.study.web.util.SSOUtils;
import com.shiant.common.exception.ServiceException;
import com.shiant.common.util.StringUtil;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@Api(value = "组织机构控制器", description = "组织机构控制器", tags = { "shiant-study-management" })
@Controller
@RequestMapping("/organization")
public class OrganizationRESTService {

	@Autowired
	private OrganizationRmiService organizationRmiService;
	
	@Autowired
	private OrganizationService organizationService;
	
	@Autowired
	private WhiteListService whiteListService;
	
	@Autowired
	private UserRmiService userRmiService;

	@ApiOperation(value = "获取组织机构列表", httpMethod = "GET", notes = "获取组织机构列表", produces = "application/json", tags = {"shiant-study-management" })
	@ApiImplicitParams({
		@ApiImplicitParam(paramType = "query", name = "page", value = "当前页", dataType = "int", required = false),
		@ApiImplicitParam(paramType = "query", name = "limit", value = "每页数", dataType = "int", required = false),
		@ApiImplicitParam(paramType = "query", name = "orgName", value = "企业名称", dataType = "String", required = false),
		@ApiImplicitParam(paramType = "query", name = "status", value = "账号状态", dataType = "Integer", required = false) 
	})
	@ResponseBody
	@RequestMapping(value = "/getBeans", method = RequestMethod.GET)
	public View getBeans(
			@RequestParam(required = false, defaultValue = "0") int page,
			@RequestParam(required = false, defaultValue = "0") int limit, 
			String orgName, Integer status,
			HttpServletRequest req, HttpServletResponse resp, Model model) {
		try {
			UserRmiVo user = SSOUtils.getUserData(req, resp, userRmiService);
			Map<String, Object> lists = organizationRmiService.getBeans(page, limit, orgName, status, user);
			
			model.addAttribute("code", 0);
			model.addAttribute("data", lists.get("beans"));
			model.addAttribute("count", lists.get("total"));
			model.addAttribute("status", IWebUtils.SERVER_STATUS_SUCCESS);
			model.addAttribute("msg", "查询成功");
		} catch (Exception e) {
			model.addAttribute("code", -1);
			model.addAttribute("status", IWebUtils.SERVER_STATUS_FAILED);
			model.addAttribute("msg", "查询失败");
			e.printStackTrace();
		}
		return JSON;
	}
	
	@ApiOperation(value = "获取组织机构详细",httpMethod = "GET",notes = "获取组织机构详细",produces="application/json")
	@ApiImplicitParams({
		@ApiImplicitParam(paramType = "query",name = "id",value = "编号",dataType = "Long",required = true)
	})
	@ResponseBody
	@RequestMapping(value="/getBean",method = RequestMethod.GET)
	public View getBean(
			@RequestParam(required=true)Long id, 
			HttpServletRequest req, HttpServletResponse resp, Model model) {
		try {
//			UserRmiVo user =  SSOUtils.getUserData(req, resp, userRmiService);
			OrganizationRmiVo bean = organizationRmiService.getBean(id, null);
			OrganizationVo org = new OrganizationVo(bean);
			WhiteListVo wl = whiteListService.getBeanByOrgid(bean.getOrgid(), null);
			if(wl!=null&&wl.getWlid()!=null) {
				org.setWl(true);
			}
			model.addAttribute("bean",  org);
			model.addAttribute("status", IWebUtils.SERVER_STATUS_SUCCESS);
			model.addAttribute("msg", "查询成功");
		} catch (Exception e) {
			model.addAttribute("status", IWebUtils.SERVER_STATUS_FAILED);
			model.addAttribute("msg", "查询失败");
			e.printStackTrace();
		}
		return JSON;
	}
	
	@ApiOperation(value = "修改组织机构",httpMethod = "POST",notes = "修改组织机构",produces="application/json")
	@ApiImplicitParams({
		@ApiImplicitParam(paramType = "body",name = "bean",value = "组织机构对象",dataType = "OrganizationRmiVo",required = true)
	})
	@ResponseBody
	@RequestMapping(value="/updateBean",method=RequestMethod.POST)
	public View updateBean(
			OrganizationRmiVo bean,
			HttpServletRequest req, HttpServletResponse resp, Model model) {
		try {
			UserRmiVo user =  SSOUtils.getUserData(req, resp, userRmiService);
			organizationRmiService.updateBean(bean, user);
			model.addAttribute("msg", "更新成功");
			model.addAttribute("status", IWebUtils.SERVER_STATUS_SUCCESS);
		}catch(ServiceException e){
			model.addAttribute("msg",e.getErrorMsg());
			model.addAttribute("status", IWebUtils.SERVER_STATUS_FAILED);
		}catch(Exception e){
			model.addAttribute("msg","系统错误");
			model.addAttribute("status", IWebUtils.SERVER_STATUS_FAILED);
			e.printStackTrace();
		}
		
		return JSON;
	}
	
	@ApiOperation(value = "获取当前用户组织机构详细",httpMethod = "GET",notes = "获取当前用户组织机构详细",produces="application/json")
	@ApiImplicitParams({
	})
	@ResponseBody
	@RequestMapping(value="/curOrganization",method = RequestMethod.GET)
	public View curOrganization(HttpServletRequest req, HttpServletResponse resp, Model model) {
		try {
			UserRmiVo user =  SSOUtils.getUserData(req, resp, userRmiService);
			OrganizationRmiVo result = organizationRmiService.curOrganization(user);
			model.addAttribute("bean", result);
			model.addAttribute("status", IWebUtils.SERVER_STATUS_SUCCESS);
			model.addAttribute("msg", "查询成功");
		} catch (ServiceException e) {
			model.addAttribute("status", IWebUtils.SERVER_STATUS_FAILED);
			model.addAttribute("msg", "查询失败");
			model.addAttribute("error", e.getErrorMsg());
		} catch (Exception e) {
			model.addAttribute("status", IWebUtils.SERVER_STATUS_FAILED);
			model.addAttribute("msg", "系统错误");
			e.printStackTrace();
		}
		return JSON;
	}
	
	@ApiOperation(value = "获取组织机构列表", httpMethod = "GET", notes = "获取组织机构列表", produces = "application/json")
	@ApiImplicitParams({
		@ApiImplicitParam(paramType = "query", name = "page", value = "当前页", dataType = "int", required = true),
		@ApiImplicitParam(paramType = "query", name = "limit", value = "每页数", dataType = "int", required = true),
		@ApiImplicitParam(paramType = "query", name = "ability", value = "能力", dataType = "String", required = false),
	})
	@ResponseBody
	@RequestMapping(value = "/getBeansByAbility", method = RequestMethod.GET)
	public View getBeansByAbility(
			@RequestParam(required = true, defaultValue = "0") int page,
			@RequestParam(required = true, defaultValue = "0") int limit, 
			String ability,
			HttpServletRequest req, HttpServletResponse resp, Model model) {
		try {
			Map<String, Object> lists = organizationService.getBeansByAbility(page, limit, ability);
			
			model.addAttribute("code", 0);
			model.addAttribute("beans", lists.get("beans"));
			model.addAttribute("status", IWebUtils.SERVER_STATUS_SUCCESS);
			model.addAttribute("msg", "查询成功");
		} catch (Exception e) {
			model.addAttribute("code", -1);
			model.addAttribute("status", IWebUtils.SERVER_STATUS_FAILED);
			model.addAttribute("msg", "查询失败");
			e.printStackTrace();
		}
		return JSON;
	}

	@ApiOperation(value = "获取组织机构列表", httpMethod = "GET", notes = "获取组织机构列表", produces = "application/json")
	@ApiImplicitParams({
		@ApiImplicitParam(paramType = "query", name = "page", value = "当前页", dataType = "int", required = true),
		@ApiImplicitParam(paramType = "query", name = "limit", value = "每页数", dataType = "int", required = true),
		@ApiImplicitParam(paramType = "query", name = "province", value = "机构位置", dataType = "String", required = false),
		@ApiImplicitParam(paramType = "query", name = "country", value = "覆盖国家", dataType = "String", required = false),
		@ApiImplicitParam(paramType = "query", name = "ability", value = "服务领域", dataType = "String", required = false),
		@ApiImplicitParam(paramType = "query", name = "year", value = "机构年限", dataType = "String", required = false),
	})
	@ResponseBody
	@RequestMapping(value = "/getBeansByQuery", method = RequestMethod.GET)
	public View getBeansByQuery(
			@RequestParam(required = true, defaultValue = "0") int page,
			@RequestParam(required = true, defaultValue = "0") int limit, 
			String province,
			String country,
			String ability,
			String year,
			HttpServletRequest req, HttpServletResponse resp, Model model) {
		try {
			if(StringUtil.isNotBlank(year)) {
				year = URLDecoder.decode(year, "UTF-8");
    		}
			if(StringUtil.isNotBlank(ability)) {
				ability = URLDecoder.decode(ability, "UTF-8");
    		}
			if(StringUtil.isNotBlank(country)) {
				country = URLDecoder.decode(country, "UTF-8");
			}
			if(StringUtil.isNotBlank(province)) {
				province = URLDecoder.decode(province, "UTF-8");
			}
			Map<String, Object> lists = organizationService.getBeansByQuery(page, limit, province, country, ability, year);
			
			model.addAttribute("code", 0);
			model.addAttribute("beans", lists.get("beans"));
			model.addAttribute("count", lists.get("count"));
			model.addAttribute("status", IWebUtils.SERVER_STATUS_SUCCESS);
			model.addAttribute("msg", "查询成功");
		} catch (Exception e) {
			model.addAttribute("code", -1);
			model.addAttribute("status", IWebUtils.SERVER_STATUS_FAILED);
			model.addAttribute("msg", "查询失败");
			e.printStackTrace();
		}
		return JSON;
	}

	@ApiOperation(value = "获取热门组织机构列表", httpMethod = "GET", notes = "获取热门组织机构列表", produces = "application/json")
	@ApiImplicitParams({
		@ApiImplicitParam(paramType = "query", name = "page", value = "当前页", dataType = "int", required = true),
		@ApiImplicitParam(paramType = "query", name = "limit", value = "每页数", dataType = "int", required = true),
	})
	@ResponseBody
	@RequestMapping(value = "/getBeansByHot", method = RequestMethod.GET)
	public View getBeansByHot(
			@RequestParam(required = true, defaultValue = "0") int page,
			@RequestParam(required = true, defaultValue = "0") int limit, 
			HttpServletRequest req, HttpServletResponse resp, Model model) {
		try {
			Map<String, Object> lists = organizationRmiService.getBeans(page, limit, null, null, null);
			
			model.addAttribute("code", 0);
			model.addAttribute("data", lists.get("beans"));
			model.addAttribute("count", lists.get("total"));
			model.addAttribute("status", IWebUtils.SERVER_STATUS_SUCCESS);
			model.addAttribute("msg", "查询成功");
		} catch (Exception e) {
			model.addAttribute("code", -1);
			model.addAttribute("status", IWebUtils.SERVER_STATUS_FAILED);
			model.addAttribute("msg", "查询失败");
			e.printStackTrace();
		}
		return JSON;
	}

}
