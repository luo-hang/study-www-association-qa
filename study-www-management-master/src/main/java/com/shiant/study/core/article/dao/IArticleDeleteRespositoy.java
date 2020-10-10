package com.shiant.study.core.article.dao;

import com.shiant.study.core.article.model.Article;
import com.shiant.study.core.school.model.School;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @program: study-www-association
 * @description
 * @author: z p、
 * @create: 2020-09-22 14:32
 **/
public interface IArticleDeleteRespositoy extends CrudRepository<Article, Long> {
    void deleteByTitle(String title);
}
