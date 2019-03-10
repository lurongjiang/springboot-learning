package com.springboot.blog.domain;

import java.io.Serializable;

/**
 * 留言
 */
public class Message implements Serializable {

    private static final long serialVersionUID = -2537641099945505589L;
    private Integer id;
    private String comment;
    private Integer userId;
    private String articleId;

    public Message() {
    }

    public Message(Integer id, String comment) {
        this.id = id;
        this.comment = comment;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getArticleId() {
        return articleId;
    }

    public void setArticleId(String articleId) {
        this.articleId = articleId;
    }

    @Override
    public String toString() {
        return "Message{" +
                "id=" + id +
                ", comment='" + comment + '\'' +
                ", userId=" + userId +
                ", articleId='" + articleId + '\'' +
                '}';
    }
}
