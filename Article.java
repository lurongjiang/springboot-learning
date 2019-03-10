package com.springboot.blog.domain;


import java.io.Serializable;

/**
 * 文章
 */
public class Article implements Serializable {

    private static final long serialVersionUID = -1786877819085761316L;
    private Integer id;
    private String title;
    private String context;
    private Integer categoryId;
    private String categoryName;


    public Article() {
    }

    public Article(Integer id, String title, String context, Integer categoryId) {
        this.id = id;
        this.title = title;
        this.context = context;
        this.categoryId = categoryId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    @Override
    public String toString() {
        return "Article{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", context='" + context + '\'' +
                ", categoryId=" + categoryId +
                '}';
    }
}
