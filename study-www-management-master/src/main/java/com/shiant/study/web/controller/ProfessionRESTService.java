package com.shiant.study.web.controller;

import static com.shiant.study.web.util.IWebUtils.JSON;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.View;

import com.shiant.rmi.user.UserRmiService;
import com.shiant.rmi.user.vo.UserRmiVo;
import com.shiant.study.core.school.service.ProfessionService;
import com.shiant.study.core.school.vo.ProfessionVo;
import com.shiant.study.web.util.IWebUtils;
import com.shiant.study.web.util.SSOUtils;
import com.shiant.common.exception.ServiceException;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@Api(value = "专业控制器", description = "专业控制器", tags = { "shiant-study-management" })
@Controller
@RequestMapping("/profession")
public class ProfessionRESTService {

	@Autowired
	private ProfessionService professionService;
	
	@Autowired
	private UserRmiService userRmiService;

	@ApiOperation(value = "获取专业列表", httpMethod = "GET", notes = "获取专业列表", produces = "application/json")
	@ApiImplicitParams({
		@ApiImplicitParam(paramType = "query", name = "page", value = "当前页", dataType = "int", required = true),
		@ApiImplicitParam(paramType = "query", name = "limit", value = "每页数", dataType = "int", required = true),
		@ApiImplicitParam(paramType = "query", name = "sid", value = "用户账号", dataType = "Long", required = false),
	})
	@ResponseBody
	@RequestMapping(value = "/getBeans", method = RequestMethod.GET)
	public View getBeans(
			@RequestParam(required = true, defaultValue = "0") int page,
			@RequestParam(required = true, defaultValue = "0") int limit, 
			Long sid,
			HttpServletRequest req, HttpServletResponse resp, Model model) {
		try {
			UserRmiVo user = SSOUtils.getUserData(req, resp, userRmiService);
			Map<String, Object> lists = professionService.getBeans(page, limit, sid, user);
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
	
	@ApiOperation(value = "添加专业",httpMethod = "POST",notes = "添加专业",produces="application/json")
	@ApiImplicitParams({
		@ApiImplicitParam(paramType = "body",name = "bean",value = "专业对象",dataType = "ProfessionRmiVo",required = true)
	})
	@ResponseBody
	@RequestMapping(value="/addBean",method = RequestMethod.POST)
	public View addBean(ProfessionVo bean,HttpServletRequest req,
			HttpServletResponse resp, Model model) {
		try {
			UserRmiVo user =  SSOUtils.getUserData(req, resp, userRmiService);
			professionService.addBean(bean, user);
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
	
	@ApiOperation(value = "修改专业",httpMethod = "PUT",notes = "修改专业",produces="application/json")
	@ApiImplicitParams({
		@ApiImplicitParam(paramType = "body",name = "bean",value = "专业对象",dataType = "ProfessionRmiVo",required = true)
	})
	@ResponseBody
	@RequestMapping(value="/updateBean",method=RequestMethod.POST)
	public View updateBean(ProfessionVo bean,HttpServletRequest req, 
			HttpServletResponse resp, Model model) {
		try {
			UserRmiVo user =  SSOUtils.getUserData(req, resp, userRmiService);
			professionService.updateBean(bean, user);
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
	
	@ApiOperation(value = "获取专业详细",httpMethod = "GET",notes = "获取专业详细",produces="application/json")
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
			UserRmiVo user =  SSOUtils.getUserData(req, resp, userRmiService);
//			  Question bean = questionRmiService.getBean(id, user);
//			  QuestionRmiVo vo = transfer.transferEntityToBaseVo(bean);
			
//			  if(bean.getType().equals("实训")) {
//				  model.addAttribute("stepTitle",   bean.getCourseStep().getTitle());
//				  model.addAttribute("stepOrder",   bean.getCourseStep().getOrder());
//				  model.addAttribute("courseTitle", bean.getCourseStep().getParentCourse().getTitle());
//			  }
//			  model.addAttribute("bean",  vo);
			model.addAttribute("status", IWebUtils.SERVER_STATUS_SUCCESS);
			model.addAttribute("msg", "查询成功");
		} catch (Exception e) {
			model.addAttribute("status", IWebUtils.SERVER_STATUS_FAILED);
			model.addAttribute("msg", "查询失败");
			e.printStackTrace();
		}
		return JSON;
	}

	@ApiOperation(value = "获取专业详细",httpMethod = "GET",notes = "获取专业详细",produces="application/json")
	@ApiImplicitParams({
		@ApiImplicitParam(paramType = "query",name = "id",value = "编号",dataType = "Long",required = false),
	})
	@ResponseBody
	@RequestMapping(value="/getBeanWithUser",method = RequestMethod.GET)
	public View getBeanWithUser(
			@RequestParam(required=true)Long id, 
			HttpServletRequest req, HttpServletResponse resp, Model model) {
		try {
			UserRmiVo user =  SSOUtils.getUserData(req, resp, userRmiService);
			ProfessionVo bean = professionService.getBean(id, user);
			
			model.addAttribute("bean",  bean);
			model.addAttribute("user",  user);
			model.addAttribute("status", IWebUtils.SERVER_STATUS_SUCCESS);
			model.addAttribute("msg", "查询成功");
		} catch (Exception e) {
			model.addAttribute("status", IWebUtils.SERVER_STATUS_FAILED);
			model.addAttribute("msg", "查询失败");
			e.printStackTrace();
		}
		return JSON;
	}
	
	@ApiOperation(value = "删除专业信息",httpMethod = "GET",notes = "删除专业信息",produces="application/json")
	@ApiImplicitParams({
		@ApiImplicitParam(paramType = "query",name = "ids",value = "专业编号",dataType = "String",required = true,allowMultiple=true)
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
						professionService.deleteBean(Long.parseLong(id),user);
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
