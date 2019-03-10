package com.springboot.blog.domain;

import java.io.Serializable;

/**
 * 栏目
 */
public class Category implements Serializable {

    private static final long serialVersionUID = 5940523007404936574L;
    private Integer id;
    private String name;
    private String desc;
    private String alias;


    private int total;

    public Category(Integer id, String name, String desc, String alias) {
        this.id = id;
        this.name = name;
        this.desc = desc;
        this.alias = alias;
    }

    public Category() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", desc='" + desc + '\'' +
                ", alias='" + alias + '\'' +
                ", total=" + total +
                '}';
    }
}
