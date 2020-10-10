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
import com.shiant.study.core.demo.service.CaseService;
import com.shiant.study.core.demo.vo.CaseVo;
import com.shiant.study.web.util.IWebUtils;
import com.shiant.study.web.util.SSOUtils;
import com.shiant.common.exception.ServiceException;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@Api(value = "案例控制器", description = "案例控制器", tags = { "shiant-study-management" })
@Controller
@RequestMapping("/case")
public class CaseRESTService {

	@Autowired
	private CaseService caseService;
	
	@Autowired
	private UserRmiService userRmiService;

	@ApiOperation(value = "获取案例列表", httpMethod = "GET", notes = "获取案例列表", produces = "application/json")
	@ApiImplicitParams({
		@ApiImplicitParam(paramType = "query", name = "page", value = "当前页", dataType = "int", required = false),
		@ApiImplicitParam(paramType = "query", name = "limit", value = "每页数", dataType = "int", required = false),
		@ApiImplicitParam(paramType = "query", name = "title", value = "案例名称", dataType = "String", required = false),
	@ApiImplicitParam(paramType = "query", name = "isPublic", value = "案例状态", dataType = "Boolean", required = false) })
	@ResponseBody
	@RequestMapping(value = "/getBeans", method = RequestMethod.GET)
	public View getBeans(
			@RequestParam(required = false, defaultValue = "0") int page,
			@RequestParam(required = false, defaultValue = "0") int limit, 
			String title, Boolean isPublic,
			HttpServletRequest req, HttpServletResponse resp, Model model) {
		try {
			UserRmiVo user = SSOUtils.getUserData(req, resp, userRmiService);
			Map<String, Object> lists = caseService.getBeans(page, limit, title, isPublic, user);
			model.addAttribute("code", 0);
			model.addAttribute("count", lists.get("total"));
			model.addAttribute("totalPages", lists.get("totalPages"));
			model.addAttribute("data", lists.get("beans"));
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
	
	@ApiOperation(value = "获取案例列表", httpMethod = "GET", notes = "获取案例列表", produces = "application/json")
	@ApiImplicitParams({
		@ApiImplicitParam(paramType = "query", name = "page", value = "当前页", dataType = "int", required = true),
		@ApiImplicitParam(paramType = "query", name = "limit", value = "每页数", dataType = "int", required = true),
		@ApiImplicitParam(paramType = "query", name = "orgid", value = "机构编号", dataType = "Long", required = true),
	})
	@ResponseBody
	@RequestMapping(value = "/getBeansByOrgid", method = RequestMethod.GET)
	public View getBeansByOrgid(
			@RequestParam(required = true) int page,
			@RequestParam(required = true) int limit, 
			@RequestParam(required = true) Long orgid, 
			HttpServletRequest req, HttpServletResponse resp, Model model) {
		try {
			Map<String, Object> lists = caseService.getBeansByOrgid(page, limit, orgid);
			model.addAttribute("code", 0);
			model.addAttribute("count", lists.get("total"));
			model.addAttribute("totalPages", lists.get("totalPages"));
			model.addAttribute("data", lists.get("beans"));
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
	
	@ApiOperation(value = "获取案例列表", httpMethod = "GET", notes = "获取案例列表", produces = "application/json")
	@ApiImplicitParams({
		@ApiImplicitParam(paramType = "query", name = "page", value = "当前页", dataType = "int", required = true),
		@ApiImplicitParam(paramType = "query", name = "limit", value = "每页数", dataType = "int", required = true),
		@ApiImplicitParam(paramType = "query", name = "aid", value = "顾问编号", dataType = "Long", required = true),
	})
	@ResponseBody
	@RequestMapping(value = "/getBeansByAdviser", method = RequestMethod.GET)
	public View getBeansByAdviser(
			@RequestParam(required = true) int page,
			@RequestParam(required = true) int limit, 
			@RequestParam(required = true) Long aid, 
			HttpServletRequest req, HttpServletResponse resp, Model model) {
		try {
			Map<String, Object> lists = caseService.getBeansByAdviser(page, limit, aid);
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
	
	@ApiOperation(value = "获取热门案例列表", httpMethod = "GET", notes = "获取热门案例列表", produces = "application/json")
	@ApiImplicitParams({
		@ApiImplicitParam(paramType = "query", name = "page", value = "当前页", dataType = "int", required = true),
		@ApiImplicitParam(paramType = "query", name = "limit", value = "每页数", dataType = "int", required = true),
	})
	@ResponseBody
	@RequestMapping(value = "/getBeansByHot", method = RequestMethod.GET)
	public View getBeansByHot(
			@RequestParam(required = true) int page,
			@RequestParam(required = true) int limit, 
			HttpServletRequest req, HttpServletResponse resp, Model model) {
		try {
			Map<String, Object> lists = caseService.getBeansByHot(page, limit);
			model.addAttribute("code", 0);
			model.addAttribute("count", lists.get("total"));
			model.addAttribute("totalPages", lists.get("totalPages"));
			model.addAttribute("data", lists.get("beans"));
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
	
	@ApiOperation(value = "添加案例",httpMethod = "POST",notes = "添加案例",produces="application/json")
	@ApiImplicitParams({
		@ApiImplicitParam(paramType = "body",name = "bean",value = "案例对象",dataType = "CaseRmiVo",required = true)
	})
	@ResponseBody
	@RequestMapping(value="/addBean",method = RequestMethod.POST)
	public View addBean(CaseVo bean,HttpServletRequest req,
			HttpServletResponse resp, Model model) {
		try {
			UserRmiVo user =  SSOUtils.getUserData(req, resp, userRmiService);
			caseService.addBean(bean, user);
			model.addAttribute("msg", "添加成功");
			model.addAttribute("status", IWebUtils.SERVER_STATUS_SUCCESS);
		}catch(ServiceException e){
			model.addAttribute("msg","添加失败");
			model.addAttribute("info",e.getErrorMsg());
			model.addAttribute("status", IWebUtils.SERVER_STATUS_FAILED);
		}catch(Exception e){
			model.addAttribute("msg","系统错误");
			model.addAttribute("status", IWebUtils.SERVER_STATUS_FAILED);
			e.printStackTrace();
		}
		return JSON;
	}
	
	@ApiOperation(value = "修改案例",httpMethod = "PUT",notes = "修改案例",produces="application/json")
	@ApiImplicitParams({
		@ApiImplicitParam(paramType = "body",name = "bean",value = "案例对象",dataType = "CaseRmiVo",required = true)
	})
	@ResponseBody
	@RequestMapping(value="/updateBean",method=RequestMethod.POST)
	public View updateBean(CaseVo bean,HttpServletRequest req, 
			HttpServletResponse resp, Model model) {
		try {
			UserRmiVo user =  SSOUtils.getUserData(req, resp, userRmiService);
			caseService.updateBean(bean, user);
			model.addAttribute("msg", "更新成功");
			model.addAttribute("status", IWebUtils.SERVER_STATUS_SUCCESS);
			
		}catch(ServiceException e){
			model.addAttribute("msg","更新失败");
			model.addAttribute("info",e.getErrorMsg());
			model.addAttribute("status", IWebUtils.SERVER_STATUS_FAILED);
		}catch(Exception e){
			model.addAttribute("msg","系统错误");
			model.addAttribute("status", IWebUtils.SERVER_STATUS_FAILED);
			e.printStackTrace();
		}
		
		return JSON;
	}
	
	@ApiOperation(value = "获取案例详细",httpMethod = "GET",notes = "获取案例详细",produces="application/json")
	@ApiImplicitParams({
		@ApiImplicitParam(paramType = "query",name = "id",value = "编号",dataType = "Long",required = true),
		@ApiImplicitParam(paramType = "query",name = "condition",value = "查询条件",dataType = "String",required = false)
	})
	@ResponseBody
	@RequestMapping(value="/getBean",method = RequestMethod.GET)
	public View getBean(
			@RequestParam(required=true)Long id, 
			String condition, HttpServletRequest req, 
			HttpServletResponse resp, Model model) {
		try {
			CaseVo bean = caseService.getBean(id, null);
			
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
	
	@ApiOperation(value = "删除案例信息",httpMethod = "GET",notes = "删除案例信息",produces="application/json")
	@ApiImplicitParams({
		@ApiImplicitParam(paramType = "query",name = "ids",value = "案例编号",dataType = "String",required = true,allowMultiple=true)
	})
	@ResponseBody
	@RequestMapping(value="/deleteBean",method=RequestMethod.GET)
	public View deleteBean(@RequestParam String ids,HttpServletRequest req, HttpServletResponse resp,
			Model model) {
		try {
			UserRmiVo user =  SSOUtils.getUserData(req, resp, userRmiService);
			if (ids!=null &&!ids.equals("")) {
				String[] ids_ = ids.split(",");
				for (String id : ids_) {
					if(id!=null &&!id.equals("")){
						caseService.deleteBean(Long.parseLong(id),user);
					}
				}
			}
			model.addAttribute("msg", "删除成功");
			model.addAttribute("status", IWebUtils.SERVER_STATUS_SUCCESS);
		}catch(ServiceException e){
			model.addAttribute("mes",e.getErrorMsg());
			model.addAttribute("status", IWebUtils.SERVER_STATUS_FAILED);
		}catch(Exception e){
			model.addAttribute("msg","系统错误！");
			model.addAttribute("status", IWebUtils.SERVER_STATUS_FAILED);
			e.printStackTrace();
		}
		
		return JSON;
	}

	@ApiOperation(value = "停用案例信息",httpMethod = "GET",notes = "停用案例信息",produces="application/json")
	@ApiImplicitParams({
		@ApiImplicitParam(paramType = "query",name = "ids",value = "案例编号",dataType = "String",required = true,allowMultiple=true)
	})
	@ResponseBody
	@RequestMapping(value="/stop",method=RequestMethod.GET)
	public View stop(@RequestParam String ids,HttpServletRequest req, HttpServletResponse resp,
			Model model) {
		try {
			UserRmiVo user =  SSOUtils.getUserData(req, resp, userRmiService);
			if (ids!=null &&!ids.equals("")) {
				String[] ids_ = ids.split(",");
				for (String id : ids_) {
					if(id!=null &&!id.equals("")){
						caseService.stop(Long.parseLong(id),user);
					}
				}
			}
			model.addAttribute("msg", "下架成功");
			model.addAttribute("status", IWebUtils.SERVER_STATUS_SUCCESS);
		}catch(ServiceException e){
			model.addAttribute("msg", "下架失败");
			model.addAttribute("error",e.getErrorMsg());
			model.addAttribute("status", IWebUtils.SERVER_STATUS_FAILED);
		}catch(Exception e){
			model.addAttribute("msg","系统错误！");
			model.addAttribute("status", IWebUtils.SERVER_STATUS_FAILED);
			e.printStackTrace();
		}
		
		return JSON;
	}
	
	@ApiOperation(value = "增加案例阅读量",httpMethod = "GET",notes = "增加案例阅读量",produces="application/json")
	@ApiImplicitParams({
		@ApiImplicitParam(paramType = "query",name = "cid",value = "编号",dataType = "Long",required = true),
	})
	@ResponseBody
	@RequestMapping(value="/addShowTime",method = RequestMethod.GET)
	public View addShowTime(
			@RequestParam(required=true)Long cid, 
			String condition, HttpServletRequest req, 
			HttpServletResponse resp, Model model) {
		try {
			UserRmiVo user =  SSOUtils.getUserData(req, resp, userRmiService);
			caseService.addShowTime(cid, user);
			model.addAttribute("status", IWebUtils.SERVER_STATUS_SUCCESS);
		} catch (Exception e) {
			model.addAttribute("status", IWebUtils.SERVER_STATUS_FAILED);
			e.printStackTrace();
		}
		return JSON;
	}
}
