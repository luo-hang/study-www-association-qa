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

import com.shiant.rmi.user.UserRmiService;
import com.shiant.rmi.user.vo.UserRmiVo;
import com.shiant.study.core.article.service.ArticleService;
import com.shiant.study.core.article.vo.ArticleVo;
import com.shiant.study.web.util.IWebUtils;
import com.shiant.study.web.util.SSOUtils;
import com.shiant.common.exception.ServiceException;
import com.shiant.common.util.StringUtil;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@Api(value = "文章控制器", description = "文章控制器", tags = { "shiant-study-management" })
@Controller
@RequestMapping("/article")
public class ArticleRESTService {

	@Autowired
	private ArticleService articleService;
	
	@Autowired
	private UserRmiService userRmiService;

	@ApiOperation(value = "获取文章列表", httpMethod = "GET", notes = "获取文章列表", produces = "application/json")
	@ApiImplicitParams({
		@ApiImplicitParam(paramType = "query", name = "page", value = "当前页", dataType = "int", required = true),
		@ApiImplicitParam(paramType = "query", name = "limit", value = "每页数", dataType = "int", required = true),
		@ApiImplicitParam(paramType = "query", name = "type", value = "文章类型", dataType = "String", required = false) 
	})
	@ResponseBody
	@RequestMapping(value = "/getBeans", method = RequestMethod.GET)
	public View getBeans(
			@RequestParam(required = true, defaultValue = "0") int page,
			@RequestParam(required = true, defaultValue = "0") int limit, 
			String type,
			HttpServletRequest req, HttpServletResponse resp, Model model) {
		try {
			if(StringUtil.isNotBlank(type)) {
				type = URLDecoder.decode(type, "UTF-8");
    		}
			Map<String, Object> lists = articleService.getBeans(page, limit, type);
			model.addAttribute("code", 0);
			model.addAttribute("count", lists.get("total"));
			model.addAttribute("totalPages", lists.get("totalPages"));
			model.addAttribute("bean", lists.get("beans"));
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

	@ApiOperation(value = "添加文章",httpMethod = "POST",notes = "添加文章",produces="application/json")
	@ApiImplicitParams({
		@ApiImplicitParam(paramType = "body",name = "bean",value = "文章对象",dataType = "ArticleVo",required = true)
	})
	@ResponseBody
	@RequestMapping(value="/addBean",method = RequestMethod.POST)
	public View addBean(ArticleVo bean,HttpServletRequest req,
			HttpServletResponse resp, Model model) {
		try {
			UserRmiVo user =  SSOUtils.getUserData(req, resp, userRmiService);
			articleService.addBean(bean, user);
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
	
	@ApiOperation(value = "修改文章",httpMethod = "PUT",notes = "修改文章",produces="application/json")
	@ApiImplicitParams({
		@ApiImplicitParam(paramType = "body",name = "bean",value = "文章对象",dataType = "ArticleVo",required = true)
	})
	@ResponseBody
	@RequestMapping(value="/updateBean",method=RequestMethod.POST)
	public View updateBean(ArticleVo bean,HttpServletRequest req, 
			HttpServletResponse resp, Model model) {
		try {
			UserRmiVo user =  SSOUtils.getUserData(req, resp, userRmiService);
			articleService.updateBean(bean, user);
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
	
	@ApiOperation(value = "获取文章详细",httpMethod = "GET",notes = "获取文章详细",produces="application/json")
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
			ArticleVo bean = articleService.getBean(id, null);
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
	
	@ApiOperation(value = "删除文章信息",httpMethod = "GET",notes = "删除文章信息",produces="application/json")
	@ApiImplicitParams({
		@ApiImplicitParam(paramType = "query",name = "ids",value = "文章编号",dataType = "String",required = true,allowMultiple=true)
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
						articleService.deleteBean(Long.parseLong(id),user);
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
