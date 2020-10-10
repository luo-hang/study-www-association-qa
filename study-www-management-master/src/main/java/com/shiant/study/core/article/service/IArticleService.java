package com.shiant.study.core.article.service;

import com.alibaba.fastjson.JSONArray;
import com.shiant.common.exception.ServiceException;
import com.shiant.study.core.article.model.Article;

/**
 * @program: study-www-association
 * @description
 * @author: z p、
 * @create: 2020-09-22 14:04
 **/
public interface IArticleService {

    JSONArray getAll();

    void addData(Article article);

    void deleteData(String titleName) throws ServiceException;

    void updateData(Article article) throws ServiceException;

    JSONArray queryXxxs(Article article) throws ServiceException;

}
