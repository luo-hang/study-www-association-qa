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
import com.shiant.study.core.legal.service.ComplaintService;
import com.shiant.study.core.legal.vo.ComplaintVo;
import com.shiant.study.web.util.IWebUtils;
import com.shiant.study.web.util.SSOUtils;
import com.shiant.common.exception.ServiceException;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@Api(value = "维权控制器", description = "维权控制器", tags = { "shiant-study-management" })
@Controller
@RequestMapping("/complaint")
public class ComplaintRESTService {

	@Autowired
	private ComplaintService complaintService;
	
	@Autowired
	private UserRmiService userRmiService;

	@ApiOperation(value = "获取维权列表", httpMethod = "GET", notes = "获取维权列表", produces = "application/json", tags = {"shiant-study-management" })
	@ApiImplicitParams({
		@ApiImplicitParam(paramType = "query", name = "page", value = "当前页", dataType = "int", required = false),
		@ApiImplicitParam(paramType = "query", name = "limit", value = "每页数", dataType = "int", required = false),
		@ApiImplicitParam(paramType = "query", name = "creater", value = "用户账号", dataType = "String", required = false),
		@ApiImplicitParam(paramType = "query", name = "orgName", value = "投诉机构", dataType = "String", required = false),
		@ApiImplicitParam(paramType = "query", name = "title", value = "维权名称", dataType = "String", required = false),
		@ApiImplicitParam(paramType = "query", name = "status", value = "维权状态", dataType = "Integer", required = false) 
	})
	@ResponseBody
	@RequestMapping(value = "/getBeans", method = RequestMethod.GET)
	public View getBeans(
			@RequestParam(required = false, defaultValue = "0") int page,
			@RequestParam(required = false, defaultValue = "0") int limit, 
			String creater, String orgName, String title, Integer status,
			HttpServletRequest req, HttpServletResponse resp, Model model) {
		try {
			UserRmiVo user = SSOUtils.getUserData(req, resp, userRmiService);
			Map<String, Object> lists = complaintService.getBeans(page, limit, creater, title, orgName, status, user);
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
	
	@ApiOperation(value = "添加维权",httpMethod = "POST",notes = "添加维权",produces="application/json",tags = {"shiant-study-management"})
	@ApiImplicitParams({
		@ApiImplicitParam(paramType = "body",name = "bean",value = "维权对象",dataType = "ComplaintRmiVo",required = true)
	})
	@ResponseBody
	@RequestMapping(value="/addBean",method = RequestMethod.POST)
	public View addBean(ComplaintVo bean,HttpServletRequest req,
			HttpServletResponse resp, Model model) {
		try {
			UserRmiVo user =  SSOUtils.getUserData(req, resp, userRmiService);
			complaintService.addBean(bean, user);
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
	
	@ApiOperation(value = "修改维权",httpMethod = "PUT",notes = "修改维权",produces="application/json",tags = {"shiant-study-management"})
	@ApiImplicitParams({
		@ApiImplicitParam(paramType = "body",name = "bean",value = "维权对象",dataType = "ComplaintRmiVo",required = true)
	})
	@ResponseBody
	@RequestMapping(value="/updateBean",method=RequestMethod.POST)
	public View updateBean(ComplaintVo bean,HttpServletRequest req, 
			HttpServletResponse resp, Model model) {
		try {
			UserRmiVo user =  SSOUtils.getUserData(req, resp, userRmiService);
			complaintService.updateBean(bean, user);
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
	
	@ApiOperation(value = "获取维权详细",httpMethod = "GET",notes = "获取维权详细",produces="application/json",tags = {"shiant-study-management"})
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

	@ApiOperation(value = "获取维权详细",httpMethod = "GET",notes = "获取维权详细",produces="application/json",tags = {"shiant-study-management"})
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
			ComplaintVo bean = complaintService.getBean(id, user);
			
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
	
	@ApiOperation(value = "删除维权信息",httpMethod = "GET",notes = "删除维权信息",produces="application/json",tags = {"shiant-study-management"})
	@ApiImplicitParams({
		@ApiImplicitParam(paramType = "query",name = "ids",value = "维权编号",dataType = "String",required = true,allowMultiple=true)
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
						complaintService.deleteBean(Long.parseLong(id),user);
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
	
	@ApiOperation(value = "修改维权状态",httpMethod = "GET",notes = "修改维权状态",produces="application/json",tags = {"shiant-study-management"})
	@ApiImplicitParams({
	})
	@ResponseBody
	@RequestMapping(value="/updateStatus",method = RequestMethod.POST)
	public View updateStatus(
			@RequestBody String bean,
			HttpServletRequest req, HttpServletResponse resp, Model model) {
		try {
			UserRmiVo user =  SSOUtils.getUserData(req, resp, userRmiService);
			complaintService.updateStatus(bean, user);
			
			model.addAttribute("status", IWebUtils.SERVER_STATUS_SUCCESS);
			model.addAttribute("msg", "更新成功");
		} catch (ServiceException e) {
			model.addAttribute("status", IWebUtils.SERVER_STATUS_FAILED);
			model.addAttribute("msg", "更新失败");
			model.addAttribute("error", e.getErrorMsg());
			e.printStackTrace();
		} catch (Exception e) {
			model.addAttribute("status", IWebUtils.SERVER_STATUS_FAILED);
			model.addAttribute("msg", "系统错误");
			e.printStackTrace();
		}
		return JSON;
	}

}
