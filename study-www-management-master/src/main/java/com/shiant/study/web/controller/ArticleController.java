//package com.shiant.study.web.controller;
//
//import com.alibaba.fastjson.JSONArray;
//import com.shiant.common.exception.ServiceException;
//import com.shiant.study.core.system.model.Article;
//import com.shiant.study.core.system.service.IArticleService;
//import com.shiant.study.web.util.IWebUtils;
//import io.swagger.annotations.Api;
//import io.swagger.annotations.ApiOperation;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.*;
//import org.springframework.web.servlet.View;
//
///**
// * @program: study-www-association
// * @description
// * @author: z p、
// * @create: 2020-09-22 14:09
// **/
//@RestController
//@Api(value = "新闻动态", description = "新闻动态", tags = {"shiant-Article"})
//@RequestMapping("/Article")
//public class ArticleController {
//
//    @Autowired
//    private IArticleService articleService;
//
//    @ApiOperation(value = "获取新闻信息")
//    @ResponseBody
//    @RequestMapping(value = "/findAll/", method = RequestMethod.GET)
//    public JSONArray findAll(Model model) {
//        JSONArray array = new JSONArray();
//        try {
//            array = articleService.getAll();
//            model.addAttribute("status", IWebUtils.SERVER_STATUS_SUCCESS);
//            model.addAttribute("msg", "查询成功！");
//            model.addAttribute("code", 0);
//        } catch (Exception e) {
//            model.addAttribute("status", IWebUtils.SERVER_STATUS_FAILED);
//            model.addAttribute("msg", "查询失败！");
//            model.addAttribute("code", -1);
//            e.printStackTrace();
//        }
//        return array;
//    }
//
//    @ApiOperation(value = "Add Data")
//    @ResponseBody
//    @RequestMapping(value = "/putData/", method = RequestMethod.POST)
//    public View putData(@RequestBody Article article, Model model) throws ServiceException {
//        try {
//            articleService.addData(article);
//            model.addAttribute("status", IWebUtils.SERVER_STATUS_SUCCESS);
//            model.addAttribute("msg", "添加成功！");
//            model.addAttribute("code", 0);
//        } catch (Exception e) {
//            model.addAttribute("status", IWebUtils.SERVER_STATUS_FAILED);
//            model.addAttribute("msg", "添加失败！");
//            model.addAttribute("code", -1);
//            e.printStackTrace();
//        }
//        return IWebUtils.JSON;
//    }
//
//    @ApiOperation(value = "根据新闻标题删除")
//    @ResponseBody
//    @DeleteMapping("deleteData/")
//    public View deleteData(@RequestParam("title") String title, Model model) throws ServiceException {
//        try {
//            articleService.deleteData(title);
//            model.addAttribute("status", IWebUtils.SERVER_STATUS_SUCCESS);
//            model.addAttribute("msg", "删除成功！");
//            model.addAttribute("code", 0);
//        } catch (Exception e) {
//            model.addAttribute("status", IWebUtils.SERVER_STATUS_FAILED);
//            model.addAttribute("msg", "删除失败！");
//            model.addAttribute("code", -1);
//            e.printStackTrace();
//        }
//        return IWebUtils.JSON;
//    }
//
//    @ApiOperation(value = "根据新闻标题和id更新")
//    @ResponseBody
//    @RequestMapping(value = "/updateData/", method = RequestMethod.POST)
//    public View updateData(@RequestBody Article article, Model model) throws ServiceException {
//        try {
//            articleService.updateData(article);
//            model.addAttribute("status", IWebUtils.SERVER_STATUS_SUCCESS);
//            model.addAttribute("msg", "更新成功！");
//            model.addAttribute("code", 0);
//        } catch (Exception e) {
//            model.addAttribute("status", IWebUtils.SERVER_STATUS_FAILED);
//            model.addAttribute("msg", "更新失败！");
//            model.addAttribute("code", -1);
//            e.printStackTrace();
//        }
//        return IWebUtils.JSON;
//    }
//
//    @ApiOperation(value = "根据新闻类型和标题分页查询")
//    @ResponseBody
//    @RequestMapping(value = "/pageQuery", method = RequestMethod.GET)
//    public JSONArray pageQuery(Model model, Article article) {
//        JSONArray array = null;
//        try {
//            array = articleService.queryXxxs(article);
//            model.addAttribute("status", IWebUtils.SERVER_STATUS_SUCCESS);
//            model.addAttribute("msg", "查询成功！");
//            model.addAttribute("code", 0);
//        } catch (Exception e) {
//            model.addAttribute("status", IWebUtils.SERVER_STATUS_FAILED);
//            model.addAttribute("msg", "查询失败！");
//            model.addAttribute("code", -1);
//            e.printStackTrace();
//        }
//        return array;
//    }
//}
