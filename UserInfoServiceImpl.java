package com.springboot.blog.service.impl;

import com.springboot.blog.domain.UserInfo;
import com.springboot.blog.service.UserInfoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserInfoServiceImpl implements UserInfoService {
    private final Logger logger = LoggerFactory.getLogger(UserInfoServiceImpl.class);
    private static final List<UserInfo> LIST;
    private static int currentId = 1006;
    //Integer id, String name, String password, String account, String sex
    static {
        LIST = new ArrayList<>();
        LIST.add(new UserInfo(1001, "张三", "zhangsan", "zhangsan","男"));
        LIST.add(new UserInfo(1002, "李四", "lisi", "lisi","女"));
        LIST.add(new UserInfo(1003, "王五", "wangwu", "wangwu","男"));
        LIST.add(new UserInfo(1004, "赵柳", "zhaoliu", "zhaoliu","男"));
        LIST.add(new UserInfo(1005, "胡巴", "huba", "huba","女"));
    }

    @Override
    public int save(UserInfo userInfo) {
        if (userInfo.getId() == null) {
            userInfo.setId(currentId++);
            LIST.add(userInfo);
            logger.info("save!!");
        } else {
            for (UserInfo item : LIST) {
                if (item.getId().equals(userInfo.getId())) {
                    LIST.remove(item);
                    LIST.add(userInfo);
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
        for (UserInfo item : LIST) {
            if (id.equals(item.getId())) {
                LIST.remove(item);
                logger.info("delete!!");
                return 1;
            }
        }
        return 0;
    }

    @Override
    public List<UserInfo> list() {
        return LIST;
    }

    @Override
    public UserInfo findById(Integer id) {
        if (id == null) return null;
        for (UserInfo userInfo : LIST) {
            if (id.equals(userInfo.getId()))
                return userInfo;
        }
        return null;
    }
}
