package com.springboot.blog.service;

import com.springboot.blog.domain.Article;

import java.util.List;

public interface ArticleService {
    int save(Article article);

    int delete(Integer id);

    List<Article> list();

    Article findById(Integer id);
}
