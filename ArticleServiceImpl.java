package com.springboot.blog.service.impl;

import com.springboot.blog.domain.Article;
import com.springboot.blog.service.ArticleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ArticleServiceImpl implements ArticleService {
    private final Logger logger = LoggerFactory.getLogger(ArticleServiceImpl.class);
    private static final List<Article> LIST;
    private static int currentId = 1006;

    static {
        LIST = new ArrayList<>();
        LIST.add(new Article(1001, "css3新特性", "css3很多新特性", 1001));
        LIST.add(new Article(1002, "java从零开始学", "java从入门到放弃", 1002));
        LIST.add(new Article(1003, "Html5新特性", "html入门案例", 1001));
        LIST.add(new Article(1004, "canvas绘图", "canvas让你的页面丰富起来", 1003));
        LIST.add(new Article(1005, "mysql索引原理解析", "由浅入深,带你学mysql索引", 1004));
    }

    @Override
    public int save(Article article) {
        if (article.getId() == null) {
            article.setId(currentId++);
            LIST.add(article);
            logger.info("save!!");
        } else {
            for (Article item : LIST) {
                if (item.getId().equals(article.getId())) {
                    LIST.remove(item);
                    LIST.add(article);
                    logger.info("update!!");
                    break;
                }
            }
        }
        return 1;
    }

    @Override
    public int delete(Integer id) {
        if (id == null) return 0;
        for (Article item : LIST) {
            if (id.equals(item.getId())) {
                LIST.remove(item);
                logger.info("delete!!");
                return 1;
            }
        }
        return 0;
    }

    @Override
    public List<Article> list() {
        return LIST;
    }

    @Override
    public Article findById(Integer id) {
        if (id == null) return null;
        for (Article article : LIST) {
            if (id.equals(article.getId()))
                return article;
        }
        return null;
    }
}
