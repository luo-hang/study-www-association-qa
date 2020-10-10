package com.shiant.study.web.controller;

import static com.shiant.study.web.util.IWebUtils.JSON;

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

import com.shiant.rmi.user.UserRmiService;
import com.shiant.rmi.user.vo.UserRmiVo;
import com.shiant.study.core.whiteList.service.WhiteListService;
import com.shiant.study.core.whiteList.vo.WhiteListVo;
import com.shiant.study.web.util.IWebUtils;
import com.shiant.study.web.util.SSOUtils;
import com.shiant.common.exception.ServiceException;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@Api(value = "白名单控制器", description = "白名单控制器", tags = { "shiant-study-management" })
@Controller
@RequestMapping("/whiteList")
public class WhiteListRESTService {

	@Autowired
	private WhiteListService whiteListService;
	
	@Autowired
	private UserRmiService userRmiService;

	@ApiOperation(value = "获取白名单机构列表", httpMethod = "GET", notes = "获取白名单机构列表", produces = "application/json", tags = {"shiant-study-management" })
	@ApiImplicitParams({
		@ApiImplicitParam(paramType = "query", name = "page", value = "当前页", dataType = "int", required = false),
		@ApiImplicitParam(paramType = "query", name = "limit", value = "每页数", dataType = "int", required = false),
		@ApiImplicitParam(paramType = "query", name = "wlNo", value = "资质号", dataType = "String", required = false),
		@ApiImplicitParam(paramType = "query", name = "orgName", value = "企业名称", dataType = "String", required = false),
		@ApiImplicitParam(paramType = "query", name = "status", value = "账号状态", dataType = "Integer", required = false) 
	})
	@ResponseBody
	@RequestMapping(value = "/getBeans", method = RequestMethod.GET)
	public View getBeans(
			@RequestParam(required = false, defaultValue = "0") int page,
			@RequestParam(required = false, defaultValue = "0") int limit, 
			String wlNo, String orgName, Integer status,
			HttpServletRequest req, HttpServletResponse resp, Model model) {
		try {
			UserRmiVo user = SSOUtils.getUserData(req, resp, userRmiService);
			Map<String, Object> lists = whiteListService.getBeans(page, limit, wlNo, orgName, status, user);
			
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
	
	@ApiOperation(value = "获取白名单详细",httpMethod = "GET",notes = "获取白名单详细",produces="application/json",tags = {"shiant-study-management"})
	@ApiImplicitParams({
		@ApiImplicitParam(paramType = "query",name = "id",value = "编号",dataType = "Long",required = true)
	})
	@ResponseBody
	@RequestMapping(value="/getBean",method = RequestMethod.GET)
	public View getBean(
			@RequestParam(required=true)Long id, 
			HttpServletRequest req, HttpServletResponse resp, Model model) {
		try {
			UserRmiVo user =  SSOUtils.getUserData(req, resp, userRmiService);
			WhiteListVo bean = whiteListService.getBean(id, user);
			model.addAttribute("bean",  bean);
			model.addAttribute("status", IWebUtils.SERVER_STATUS_SUCCESS);
			model.addAttribute("msg", "查询成功");
		} catch (Exception e) {
			model.addAttribute("status", IWebUtils.SERVER_STATUS_FAILED);
			model.addAttribute("msg", "查询失败");
			e.printStackTrace();
		}
		return JSON;
	}
	
	@ApiOperation(value = "获取白名单详细",httpMethod = "GET",notes = "获取白名单详细",produces="application/json",tags = {"shiant-study-management"})
	@ApiImplicitParams({
		@ApiImplicitParam(paramType = "query",name = "orgid",value = "机构编号",dataType = "Long",required = true)
	})
	@ResponseBody
	@RequestMapping(value="/getBeanByOrgid",method = RequestMethod.GET)
	public View getBeanByOrgid(
			@RequestParam(required=true)Long orgid, 
			HttpServletRequest req, HttpServletResponse resp, Model model) {
		try {
			UserRmiVo user =  SSOUtils.getUserData(req, resp, userRmiService);
			WhiteListVo bean = whiteListService.getBeanByOrgid(orgid, user);
			if(bean == null) {
				bean = new WhiteListVo();
			}
			model.addAttribute("bean",  bean);
			model.addAttribute("status", IWebUtils.SERVER_STATUS_SUCCESS);
			model.addAttribute("msg", "查询成功");
		} catch (Exception e) {
			model.addAttribute("status", IWebUtils.SERVER_STATUS_FAILED);
			model.addAttribute("msg", "查询失败");
			e.printStackTrace();
		}
		return JSON;
	}
	
	@ApiOperation(value = "修改白名单条目",httpMethod = "POST",notes = "修改白名单条目",produces="application/json",tags = {"shiant-study-management"})
	@ApiImplicitParams({
		@ApiImplicitParam(paramType = "body",name = "bean",value = "白名单条目对象",dataType = "WhiteListVo",required = true)
	})
	@ResponseBody
	@RequestMapping(value="/updateBean",method=RequestMethod.POST)
	public View updateBean(
			WhiteListVo bean,
			HttpServletRequest req, HttpServletResponse resp, Model model) {
		try {
			UserRmiVo user =  SSOUtils.getUserData(req, resp, userRmiService);
			whiteListService.updateBean(bean, user);
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
	
	@ApiOperation(value = "获取当前用户组织白名单资质",httpMethod = "GET",notes = "获取当前用户组织白名单资质",produces="application/json",tags = {"shiant-study-management"})
	@ApiImplicitParams({
	})
	@ResponseBody
	@RequestMapping(value="/getCurWhiteList",method = RequestMethod.GET)
	public View getCurWhiteList(HttpServletRequest req, HttpServletResponse resp, Model model) {
		try {
			UserRmiVo user =  SSOUtils.getUserData(req, resp, userRmiService);
			WhiteListVo result = whiteListService.getCurWhiteList(user);
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
	

}
