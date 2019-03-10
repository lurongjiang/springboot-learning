package com.springboot.blog.domain;

public class UserInfo {
    private Integer id;
    private String name;
    private String password;
    private String account;
    private String sex;

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public UserInfo() {
    }

    public UserInfo(Integer id, String name, String password) {
        this.id = id;
        this.name = name;
        this.password = password;
    }

    public UserInfo(String name, String psw) {
        this.name = name;
        this.password = psw;
    }

    public UserInfo(Integer id, String name, String password, String account, String sex) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.account = account;
        this.sex = sex;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "UserInfo{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
