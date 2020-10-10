package com.shiant.study.core.article.dao.impl;

import com.shiant.common.dao.impl.AbstractModelDAOImpl;
import com.shiant.study.core.article.dao.IArticleDao;
import com.shiant.study.core.article.model.Article;
import com.shiant.study.core.school.model.School;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * @program: study-www-association
 * @description
 * @author: z p、
 * @create: 2020-09-22 14:01
 **/
@Repository(value = "articleDao")
public class ArticleDaoImpl extends AbstractModelDAOImpl<Article> implements IArticleDao {
    @PersistenceContext
    private EntityManager entityManager;
}
