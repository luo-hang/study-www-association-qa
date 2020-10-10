package com.shiant.study.core.article.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.shiant.study.core.article.model.Article;

public interface IArticleRepository extends JpaRepository<Article, Long>, JpaSpecificationExecutor<Article> {

}
