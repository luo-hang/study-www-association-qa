package com.shiant.study.web.controller;

import static com.shiant.study.web.util.IWebUtils.JSON;

import java.util.List;
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
import com.shiant.study.core.adviser.service.AdviserService;
import com.shiant.study.core.adviser.vo.AdviserVo;
import com.shiant.study.core.demo.service.CaseToAdviserService;
import com.shiant.study.web.util.IWebUtils;
import com.shiant.study.web.util.SSOUtils;
import com.shiant.common.exception.ServiceException;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@Api(value = "顾问控制器", description = "顾问控制器", tags = { "shiant-study-management" })
@Controller
@RequestMapping("/adviser")
public class AdviserRESTService {

	@Autowired
	private AdviserService adviserService;
	
	@Autowired
	private CaseToAdviserService caseToAdviserService;
	
	@Autowired
	private UserRmiService userRmiService;

	@ApiOperation(value = "获取顾问列表", httpMethod = "GET", notes = "获取顾问列表", produces = "application/json", tags = {"shiant-study-management" })
	@ApiImplicitParams({
		@ApiImplicitParam(paramType = "query", name = "page", value = "当前页", dataType = "int", required = true),
		@ApiImplicitParam(paramType = "query", name = "limit", value = "每页数", dataType = "int", required = true),
		@ApiImplicitParam(paramType = "query", name = "name", value = "顾问名称", dataType = "String", required = false),
		@ApiImplicitParam(paramType = "query", name = "orgid", value = "机构编号", dataType = "Long", required = false) 
	})
	@ResponseBody
	@RequestMapping(value = "/getBeans", method = RequestMethod.GET)
	public View getBeans(
			@RequestParam(required = true, defaultValue = "0") int page,
			@RequestParam(required = true, defaultValue = "0") int limit, 
			String name, Long orgid,
			HttpServletRequest req, HttpServletResponse resp, Model model) {
		try {
			if(orgid!=null && orgid.longValue() == -1) {
				UserRmiVo user = SSOUtils.getUserData(req, resp, userRmiService);
				orgid = user.getOrgid();
			}
			Map<String, Object> lists = adviserService.getBeans(page, limit, name, orgid);
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

	@ApiOperation(value = "获取顾问列表(当前机构)", httpMethod = "GET", notes = "获取顾问列表(当前机构)", produces = "application/json", tags = {"shiant-study-management" })
	@ApiImplicitParams({
		@ApiImplicitParam(paramType = "query", name = "page", value = "当前页", dataType = "int", required = false),
		@ApiImplicitParam(paramType = "query", name = "limit", value = "每页数", dataType = "int", required = false),
		@ApiImplicitParam(paramType = "query", name = "name", value = "顾问名称", dataType = "String", required = false)
	})
	@ResponseBody
	@RequestMapping(value = "/getCurBeans", method = RequestMethod.GET)
	public View getCurBeans(
			@RequestParam(required = false, defaultValue = "0") int page,
			@RequestParam(required = false, defaultValue = "0") int limit, 
			String name,
			HttpServletRequest req, HttpServletResponse resp, Model model) {
		try {
			UserRmiVo user = SSOUtils.getUserData(req, resp, userRmiService);
			Map<String, Object> lists = adviserService.getBeans(page, limit, name, user.getOrgid());
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
	
	@ApiOperation(value = "添加顾问",httpMethod = "POST",notes = "添加顾问",produces="application/json",tags = {"shiant-study-management"})
	@ApiImplicitParams({
		@ApiImplicitParam(paramType = "body",name = "bean",value = "顾问对象",dataType = "AdviserVo",required = true)
	})
	@ResponseBody
	@RequestMapping(value="/addBean",method = RequestMethod.POST)
	public View addBean(AdviserVo bean,HttpServletRequest req,
			HttpServletResponse resp, Model model) {
		try {
			UserRmiVo user =  SSOUtils.getUserData(req, resp, userRmiService);
			adviserService.addBean(bean, user);
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
	
	@ApiOperation(value = "修改顾问",httpMethod = "PUT",notes = "修改顾问",produces="application/json",tags = {"shiant-study-management"})
	@ApiImplicitParams({
		@ApiImplicitParam(paramType = "body",name = "bean",value = "顾问对象",dataType = "AdviserVo",required = true)
	})
	@ResponseBody
	@RequestMapping(value="/updateBean",method=RequestMethod.POST)
	public View updateBean(AdviserVo bean,HttpServletRequest req, 
			HttpServletResponse resp, Model model) {
		try {
			UserRmiVo user =  SSOUtils.getUserData(req, resp, userRmiService);
			adviserService.updateBean(bean, user);
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
	
	@ApiOperation(value = "获取顾问详细",httpMethod = "GET",notes = "获取顾问详细",produces="application/json",tags = {"shiant-study-management"})
	@ApiImplicitParams({
		@ApiImplicitParam(paramType = "query",name = "id",value = "编号",dataType = "Long",required = false),
		@ApiImplicitParam(paramType = "query",name = "condition",value = "查询条件",dataType = "String",required = false)
	})
	@ResponseBody
	@RequestMapping(value="/getBean",method = RequestMethod.GET)
	public View getBean(
			@RequestParam(required=true)Long id, 
			String condition, HttpServletRequest req, 
			HttpServletResponse resp, Model model) {
		try {
			AdviserVo bean = adviserService.getBean(id, null);
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
	
	@ApiOperation(value = "根据案例获取顾问",httpMethod = "GET",notes = "根据案例获取顾问",produces="application/json",tags = {"shiant-study-management"})
	@ApiImplicitParams({
		@ApiImplicitParam(paramType = "query",name = "cid",value = "案例编号",dataType = "Long",required = true),
	})
	@ResponseBody
	@RequestMapping(value="/getBeansByCid",method = RequestMethod.GET)
	public View getBeansByCid(
			@RequestParam(required=true)Long cid, 
		    HttpServletRequest req, HttpServletResponse resp, Model model) {
		try {
			UserRmiVo user =  SSOUtils.getUserData(req, resp, userRmiService);
			List<AdviserVo> beans = adviserService.getBeansByCid(cid,user);
			model.addAttribute("bean",  beans);
			model.addAttribute("status", IWebUtils.SERVER_STATUS_SUCCESS);
			model.addAttribute("msg", "查询成功");
		} catch (Exception e) {
			model.addAttribute("status", IWebUtils.SERVER_STATUS_FAILED);
			model.addAttribute("msg", "查询失败");
			e.printStackTrace();
		}
		return JSON;
	}
	
	@ApiOperation(value = "删除顾问信息",httpMethod = "GET",notes = "删除顾问信息",produces="application/json",tags = {"shiant-study-management"})
	@ApiImplicitParams({
		@ApiImplicitParam(paramType = "query",name = "ids",value = "顾问编号",dataType = "String",required = true,allowMultiple=true)
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
						adviserService.deleteBean(Long.parseLong(id),user);
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

}
