package com.shiant.study.web.controller;

import com.alibaba.fastjson.JSONArray;
import com.shiant.common.exception.ServiceException;
import com.shiant.common.util.StringUtil;
import com.shiant.rmi.user.vo.UserRmiVo;
import com.shiant.study.core.school.model.School;
import com.shiant.study.core.school.service.ISchoolService;
import com.shiant.study.core.school.vo.SchoolVo;
import com.shiant.study.web.util.IWebUtils;
import com.shiant.study.web.util.SSOUtils;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

import static com.shiant.study.web.util.IWebUtils.JSON;

import java.net.URLDecoder;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.View;

/**
 * @program: study-www-association
 * @description
 * @author: z p、
 * @create: 2020-09-17 15:15
 **/
@Api(value = "国际教育展", description = "国际教育展", tags = { "shiant-School" })
@RestController
@RequestMapping("/school")
public class SchoolController {

    @Autowired
    private ISchoolService schoolService;

    @ApiOperation(value = "根据院校中文名称、院校英文名称查询")
    @ResponseBody
    @RequestMapping(value = "/findData/", method = RequestMethod.POST)
    public JSONArray findByNameCAndNameE(@RequestBody School school, Model model) {
        JSONArray array = new JSONArray();
        try {
            array = schoolService.getAll(school);
            model.addAttribute("status", IWebUtils.SERVER_STATUS_SUCCESS);
            model.addAttribute("msg", "查询成功！");
            model.addAttribute("code", 0);
        } catch (Exception e) {
            model.addAttribute("status", IWebUtils.SERVER_STATUS_FAILED);
            model.addAttribute("msg", "查询失败！");
            model.addAttribute("code", -1);
            e.printStackTrace();
        }
        return array;
    }
    
    @ApiOperation(value = "获取院校详细",httpMethod = "GET",notes = "获取院校详细",produces="application/json")
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
			SchoolVo bean = schoolService.getBeanBySid(id);
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
    
    @ApiOperation(value = "查询院校列表", httpMethod = "GET", notes = "查询院校列表", produces = "application/json", tags = {"shiant-study-management" })
	@ApiImplicitParams({
		@ApiImplicitParam(paramType = "query", name = "page", value = "当前页", dataType = "int", required = true),
		@ApiImplicitParam(paramType = "query", name = "limit", value = "每页数", dataType = "int", required = true),
		@ApiImplicitParam(paramType = "query", name = "country", value = "国家", dataType = "String", required = false),
		@ApiImplicitParam(paramType = "query", name = "schoolProperty", value = "学校性质", dataType = "String", required = false),
		@ApiImplicitParam(paramType = "query", name = "degree", value = "学位", dataType = "String", required = false),
	})
    @RequestMapping(value = "/getBeans", method = RequestMethod.GET)
    public View getBeans(
    		@RequestParam(required = true) int page,
			@RequestParam(required = true) int limit, 
			@RequestParam(required = false) String country, 
			@RequestParam(required = false) String schoolProperty, 
			@RequestParam(required = false) String degree, 
    		Model model) {
    	try {
    		if(StringUtil.isNotBlank(country)) {
    			country = URLDecoder.decode(country, "UTF-8");
    		}
    		if(StringUtil.isNotBlank(schoolProperty)) {
    			schoolProperty = URLDecoder.decode(schoolProperty, "UTF-8");
    		}
    		if(StringUtil.isNotBlank(degree)) {
    			degree = URLDecoder.decode(degree, "UTF-8");
    		}
    		Map<String, Object> lists = schoolService.getBeans(page, limit, country, schoolProperty, degree);
    		model.addAttribute("code", 0);
			model.addAttribute("count", lists.get("count"));
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

    @ApiOperation(value = "Add Data")
    @ResponseBody
    @RequestMapping(value = "/putData/", method = RequestMethod.POST)
    public View putData(@RequestBody School school, Model model) throws ServiceException {
        try {
            schoolService.addData1(school);
            model.addAttribute("status", IWebUtils.SERVER_STATUS_SUCCESS);
            model.addAttribute("msg", "添加成功！");
            model.addAttribute("code", 0);
        } catch (Exception e) {
            model.addAttribute("status", IWebUtils.SERVER_STATUS_FAILED);
            model.addAttribute("msg", "添加失败！");
            model.addAttribute("code", -1);
            e.printStackTrace();
        }
        return IWebUtils.JSON;
    }

    @ApiOperation(value = "根据院校中文名称删除")
    @ResponseBody
    @DeleteMapping("deleteData/")
    public View deleteBySchoolNameC(@RequestParam("name") String name, Model model) throws ServiceException {
        try {
            schoolService.deleteData(name);
            model.addAttribute("status", IWebUtils.SERVER_STATUS_SUCCESS);
            model.addAttribute("msg", "删除成功！");
            model.addAttribute("code", 0);
        } catch (Exception e) {
            model.addAttribute("status", IWebUtils.SERVER_STATUS_FAILED);
            model.addAttribute("msg", "删除失败！");
            model.addAttribute("code", -1);
            e.printStackTrace();
        }
        return IWebUtils.JSON;
    }

    // @ResponseBody
    // @RequestMapping(value = "updateMethod/{id},{nameC},{nameE},{about}", method = RequestMethod.GET)
    // public void updateData(@ApiParam(value = "必选参数", required = true)
    //                        @PathVariable("id") Long id,
    //                        @PathVariable("nameC") String nameC,
    //                        @PathVariable("nameE") String nameE,
    //                        @ApiParam(value = "可选参数", required = false)
    //                        @PathVariable("about") String about
    // ) throws ServiceException {
    //     schoolService.updateData(id, nameC, nameE, about);
    // }
    @ApiOperation(value = "根据院校中文名称、院校英文名称和ID更新")
    @ResponseBody
    @RequestMapping(value = "/updateData/", method = RequestMethod.POST)
    public View updateData(@RequestBody School sc, Model model) throws ServiceException {
        try {
            schoolService.updateDataBySchoolNameCAndSchoolNameEAndId(sc);
            model.addAttribute("status", IWebUtils.SERVER_STATUS_SUCCESS);
            model.addAttribute("msg", "更新成功！");
            model.addAttribute("code", 0);
        } catch (Exception e) {
            model.addAttribute("status", IWebUtils.SERVER_STATUS_FAILED);
            model.addAttribute("msg", "更新失败！");
            model.addAttribute("code", -1);
            e.printStackTrace();
        }
        return IWebUtils.JSON;
    }

    @ApiOperation(value = "根据院校中文名称、院校英文名称分页查询")
    @ResponseBody
    @RequestMapping(value = "/pageQuery", method = RequestMethod.GET)
    public JSONArray pageQuery(Model model, School school) {
        JSONArray array = null;
        try {
            array = schoolService.queryXxxs(school);
            model.addAttribute("status", IWebUtils.SERVER_STATUS_SUCCESS);
            model.addAttribute("msg", "查询成功！");
            model.addAttribute("code", 0);
        } catch (Exception e) {
            model.addAttribute("status", IWebUtils.SERVER_STATUS_FAILED);
            model.addAttribute("msg", "查询失败！");
            model.addAttribute("code", -1);
            e.printStackTrace();
        }
        return array;
    }
}
