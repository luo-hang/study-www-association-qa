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

import com.biot.fsnip.sso.client.util.SSOClientUtil;
import com.biot.fsnip.sso.client.vo.AuthenticateInfo;
import com.shiant.study.core.demo.vo.CaseVo;
import com.shiant.study.core.system.vo.UserVo;
import com.shiant.study.web.util.IWebUtils;
import com.shiant.study.web.util.SSOUtils;
import com.shiant.common.exception.ServiceException;
import com.shiant.common.util.HttpUtil;
import com.shiant.common.util.StringUtil;
import com.shiant.rmi.user.OrganizationRmiService;
import com.shiant.rmi.user.UserRmiService;
import com.shiant.rmi.user.vo.OrganizationRmiVo;
import com.shiant.rmi.user.vo.UserRmiVo;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@Api(value = "用户信息管理", description = "用户信息管理", tags = {"shiant-service-user"})
@Controller
@RequestMapping("/user")
public class UserRESTService {
	
	@Autowired 
	private UserRmiService userRmiService;
	
	@Autowired
	private OrganizationRmiService organizationRmiService;
	
	@ApiOperation(value = "查询用户信息",httpMethod = "GET",notes = "查询用户信息",produces="application/json",tags = {"shiant-center-management"})
	@ApiImplicitParams({
	})
	@ResponseBody
	@RequestMapping(value="/getUserInfo",method=RequestMethod.GET)
	public View getUserInfo(HttpServletRequest req, HttpServletResponse resp,
			Model model) {
		try {
			UserRmiVo user =  SSOUtils.getUserData(req, resp, userRmiService);
			JSONObject json = new JSONObject();
			String userRealName = user.getUserRealName();
			if(StringUtil.isBlank(user.getUserRealName())) {
				userRealName = user.getUserName();	
			}
			OrganizationRmiVo result = organizationRmiService.curOrganization(user);
			json.put("userid", user.getUserid());
			json.put("realName", userRealName);
			json.put("orgStatus", result.getStatus());
			
			model.addAttribute("code", 0);
			model.addAttribute("data", json);
			model.addAttribute("msg", "用户信息查询成功！");
			model.addAttribute("status", IWebUtils.SERVER_STATUS_SUCCESS);
		}catch(Exception e){
			model.addAttribute("code", -1);
			model.addAttribute("msg","系统错误！");
			model.addAttribute("status", IWebUtils.SERVER_STATUS_FAILED);
			e.printStackTrace();
		}
		
		return JSON;
	}
	
	@ApiOperation(value = "注册账号",httpMethod = "POST",notes = "注册账号",produces="application/json",tags = {"shiant-study-management"})
	@ApiImplicitParams({
		@ApiImplicitParam(paramType = "body",name = "bean",value = "用户对象",dataType = "UserVo",required = true)
	})
	@ResponseBody
	@RequestMapping(value="/register",method = RequestMethod.POST)
	public View register(
			@RequestBody UserVo bean,
			HttpServletRequest req, HttpServletResponse resp, Model model) {
		try {
			if(StringUtil.isNotBlank(bean.getCode())&&bean.getCode().equals("8888")) {
				UserRmiVo user = new UserRmiVo();
				user.setUserRealName("留学超管");
				
				UserRmiVo newUser = new UserRmiVo();
				newUser.setPhone(bean.getPhone());
				newUser.setOrgName(bean.getOrgName());
				newUser.setUserName(bean.getUserName());
				newUser.setUserPwd(bean.getUserPwd());
				
				userRmiService.addBean(newUser, user);
			}else {
				model.addAttribute("msg","验证码错误");
				model.addAttribute("status", IWebUtils.SERVER_STATUS_FAILED);
				return JSON;
			}
			model.addAttribute("msg", "注册成功");
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
	
	@ApiOperation(value = "重置密码",httpMethod = "POST",notes = "重置密码",produces="application/json",tags = {"shiant-study-management"})
	/*
	 * @ApiImplicitParams({
	 * 
	 * @ApiImplicitParam(paramType = "body",name = "bean",value = "用户对象",dataType =
	 * "UserVo",required = true) })
	 */
	@ResponseBody
	@RequestMapping(value="/reset",method = RequestMethod.POST)
	public View reset(
			@RequestBody UserRmiVo bean,
			HttpServletRequest req, HttpServletResponse resp, Model model) {
		try {
			userRmiService.resetPassword(bean);
			model.addAttribute("msg", "重置成功");
			model.addAttribute("status", IWebUtils.SERVER_STATUS_SUCCESS);
		}catch(ServiceException e){
			model.addAttribute("msg","重置失败");
			model.addAttribute("info",e.getErrorMsg());
			model.addAttribute("status", IWebUtils.SERVER_STATUS_FAILED);
		}catch(Exception e){
			model.addAttribute("msg","系统错误");
			model.addAttribute("status", IWebUtils.SERVER_STATUS_FAILED);
			e.printStackTrace();
		}
		return JSON;
	}
	
	@ApiOperation(value = "验证验证码",httpMethod = "POST",notes = "验证验证码",produces="application/json",tags = {"shiant-study-management"})
	/*
	 * @ApiImplicitParams({
	 * 
	 * @ApiImplicitParam(paramType = "body",name = "bean",value = "用户对象",dataType =
	 * "UserVo",required = true) })
	 */
	@ResponseBody
	@RequestMapping(value="/verifyCode",method = RequestMethod.POST)
	public View verifyCode(@RequestBody UserVo bean,
			HttpServletRequest req, HttpServletResponse resp, Model model) {
		try {
			if(StringUtil.isNotBlank(bean.getCode())&&bean.getCode().equals("8888")) {
			
			}else {
				model.addAttribute("msg","验证码错误");
				model.addAttribute("status", IWebUtils.SERVER_STATUS_FAILED);
			}
			model.addAttribute("msg", "验证成功");
			model.addAttribute("status", IWebUtils.SERVER_STATUS_SUCCESS);
		}catch(Exception e){
			model.addAttribute("msg","系统错误");
			model.addAttribute("status", IWebUtils.SERVER_STATUS_FAILED);
			e.printStackTrace();
		}
		return JSON;
	}
	
	@ApiOperation(value = "查询用户菜单信息",httpMethod = "GET",notes = "查询用户菜单信息",produces="application/json",tags = {"shiant-center-management"})
	@ApiImplicitParams({
	})
	@ResponseBody
	@RequestMapping(value="/getUserMenu",method=RequestMethod.GET)
	public View getUserMenu(HttpServletRequest req, HttpServletResponse resp,
			Model model) {
		try {
			JSONArray jsons = new JSONArray();
			AuthenticateInfo info = SSOClientUtil.validUser(req, resp);
			JSONObject home = new JSONObject();
			home.put("name", "home");
			home.put("title", "主页");
			home.put("icon", "layui-icon-home");
			home.put("jump", "/");
			jsons.add(home);
			JSONObject set = new JSONObject();
			if(info != null&&info.getUserId().intValue() == 1) {
				set.put("name", "set");
				set.put("title", "用户管理");
				set.put("icon", "layui-icon-user");
				JSONArray sets = new JSONArray();
				JSONObject set_1 = new JSONObject();
				set_1.put("name", "admin-list");
				set_1.put("title", "账号管理");
				set_1.put("jump", "user/user-list");
				sets.add(set_1);
//				JSONObject set_2 = new JSONObject();
//				set_2.put("name", "carousel");
//				set_2.put("title", "角色管理");
//				set_2.put("jump", "set/carousel");
//				sets.add(set_2);
				JSONObject set_3 = new JSONObject();
				set_3.put("name", "type");
				set_3.put("title", "角色权限管理");
				set_3.put("jump", "set/type");
				sets.add(set_3);
//				JSONObject set_4 = new JSONObject();
//				set_4.put("name", "type-list");
//				set_4.put("title", "操作日志");
//				set_4.put("jump", "set/type-list");
//				sets.add(set_4);
//				set.put("list", sets);
//				jsons.add(set);
			
				set.put("name", "verify");
				set.put("title", "机构审核");
				set.put("icon", "layui-icon-survey");
				JSONArray sets_5 = new JSONArray();
				JSONObject set_5_0 = new JSONObject();
				set_5_0.put("name", "organization-management");
				set_5_0.put("title", "机构管理");
				set_5_0.put("jump", "organization/organization-list");
				sets_5.add(set_5_0);
//				JSONObject set_5_0 = new JSONObject();
//				set_5_0.put("name", "organization-verify");
//				set_5_0.put("title", "审核入驻资质");
//				set_5_0.put("jump", "organization/organization-verify");
//				sets_5.add(set_5_0);
				JSONObject set_5_1 = new JSONObject();
				set_5_1.put("name", "white-list-list");
				set_5_1.put("title", "白名单列表");
				set_5_1.put("jump", "white-list/white-list-list");
				sets_5.add(set_5_1);
//				JSONObject set_5_1 = new JSONObject();
//				set_5_1.put("name", "white-list");
//				set_5_1.put("title", "白名单审核");
//				set_5_1.put("jump", "white-list/white-list-verify");
//				sets_5.add(set_5_1);
				JSONObject set_5_2 = new JSONObject();
				set_5_2.put("name", "complaint-list");
				set_5_2.put("title", "维权列表");
				set_5_2.put("jump", "complaint/complaint-list");
				sets_5.add(set_5_2);
				set.put("list", sets_5);
				jsons.add(set);

			}else {
				set.put("name", "set");
				set.put("title", "机构设置");
				set.put("icon", "layui-icon-component");
				JSONArray sets0 = new JSONArray();
				JSONObject set_0_1 = new JSONObject();
				set_0_1.put("name", "organization-detail");
				set_0_1.put("title", "企业信息");
				set_0_1.put("jump", "organization/organization-detail");
				sets0.add(set_0_1);
				JSONObject set_0_2 = new JSONObject();
				set_0_2.put("name", "organization-qualification");
				set_0_2.put("title", "入驻资质");
				set_0_2.put("jump", "organization/organization-qualification");
				sets0.add(set_0_2);
				set.put("list", sets0);
//				JSONObject set_0_3 = new JSONObject();
//				set_0_3.put("name", "organization-list");
//				set_0_3.put("title", "添加入驻资质");
//				set_0_3.put("jump", "organization/organization-improve");
//				sets0.add(set_0_3);
				jsons.add(set);
				
				set.put("name", "page");
				set.put("title", "白名单认证");
				set.put("icon", "layui-icon-file");
				JSONArray sets_4 = new JSONArray();
				JSONObject set_4_0 = new JSONObject();
				set_4_0.put("name", "white-list");
				set_4_0.put("title", "条目认证");
				set_4_0.put("jump", "white-list/white-list");
				sets_4.add(set_4_0);
				set.put("list", sets_4);
				jsons.add(set);
				
				set.put("name", "set");
				set.put("title", "用户管理");
				set.put("icon", "layui-icon-user");
				JSONArray sets = new JSONArray();
				JSONObject set_5 = new JSONObject();
				set_5.put("name", "adviser-list");
				set_5.put("title", "金牌顾问");
				set_5.put("jump", "adviser/adviser-list");
				sets.add(set_5);
				set.put("list", sets);
				jsons.add(set);
			
				set.put("name", "case");
				set.put("title", "服务资源");
				set.put("icon", "layui-icon-diamond");
				JSONArray sets_1 = new JSONArray();
				JSONObject set_1_0 = new JSONObject();
				set_1_0.put("name", "case-list");
				set_1_0.put("title", "服务管理");
				set_1_0.put("jump", "case/case-list");
				sets_1.add(set_1_0);
				set.put("list", sets_1);
				jsons.add(set);
				
				
				set.put("name", "complaint");
				set.put("title", "维权管理");
				set.put("icon", "layui-icon-vercode");
				JSONArray sets_2 = new JSONArray();
				JSONObject set_2_0 = new JSONObject();
				set_2_0.put("name", "complaint-org-list");
				set_2_0.put("title", "申请维权列表");
				set_2_0.put("jump", "complaint-org/complaint-list");
				sets_2.add(set_2_0);
				set.put("list", sets_2);
				jsons.add(set);
			}
			model.addAttribute("code", 0);
			model.addAttribute("data", jsons);
			model.addAttribute("msg", "菜单信息查询成功！");
			model.addAttribute("status", IWebUtils.SERVER_STATUS_SUCCESS);
		}catch(Exception e){
			model.addAttribute("code", -1);
			model.addAttribute("msg","系统错误！");
			model.addAttribute("status", IWebUtils.SERVER_STATUS_FAILED);
			e.printStackTrace();
		}
		return JSON;
	}
	

}
