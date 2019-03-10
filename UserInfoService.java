package com.springboot.blog.service;

import com.springboot.blog.domain.UserInfo;

import java.util.List;

public interface UserInfoService {
    int save(UserInfo userInfo);

    int delete(Integer id);

    List<UserInfo> list();

    UserInfo findById(Integer id);
}
