package com.springboot.blog.controller;

import com.springboot.blog.common.Constant;
import com.springboot.blog.domain.UserInfo;
import com.springboot.blog.service.UserInfoService;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

@Controller
public class UserController {
    @GetMapping(value = {"/login", "/login.html"})
    public String loginPage() {
        return "login";
    }
    @GetMapping(value = "/logout")
    public String logout(HttpSession session){
        session.invalidate();
        return "redirect:/login";
    }
    @PostMapping(value = "/login")
    public String login(String account, String password, HttpSession session) {
        if (StringUtils.isNotBlank(account) && StringUtils.isNotBlank(password)) {
            session.setAttribute(Constant.CURRENT_USER, new UserInfo(account, password));
            return "redirect:/dashboard";
        }
        return "login";
    }
    private final Logger logger = LoggerFactory.getLogger(UserController.class);
    @Resource
    private UserInfoService userInfoService;

    /**
     * 显示用户列表
     *
     * @param model 数据回显model
     * @return 用户列表页
     */
    @GetMapping(value = "/users")
    public String listPage(Model model) {
        model.addAttribute("list", userInfoService.list());
        return "userinfo/list";
    }

    /**
     * 跳转到修改页面
     *
     * @param id 用户id
     * @param model 数据回显model
     * @return 用户列表页面
     */
    @GetMapping(value = "user/{id}")
    public String updatePage(@PathVariable Integer id, Model model) {
        UserInfo userInfo = userInfoService.findById(id);
        model.addAttribute("user", userInfo);
        return "userinfo/add";
    }

    /**
     * 修改用户
     *
     * @param userInfo 用户
     * @return 用户列表页面
     */
    @PutMapping(value = "/user")
    public String update(UserInfo userInfo) {
        int save = userInfoService.save(userInfo);
        logger.info("update:{}", save);
        return "redirect:/users";
    }

    /**
     * 删除用户
     *
     * @param id 用户id
     * @return 用户列表页面
     */
    @DeleteMapping(value = "user/{id}")
    public String delete(@PathVariable Integer id) {
        int delete = userInfoService.delete(id);
        logger.info("delete:{}", delete);
        return "redirect:/users";
    }

    /**
     * 添加用户
     *
     * @param userInfo  用户信息
     * @return 用户列表页面
     */
    @PostMapping(value = "/user")
    public String add(UserInfo userInfo) {
        int save = userInfoService.save(userInfo);
        logger.info("save:{}", save);
        return "redirect:/users";
    }

    /**
     * 跳转到添加页面
     *
     * @return 添加用户页面
     */
    @GetMapping(value = "/user")
    public String addPage() {
        return "userinfo/add";
    }
}
