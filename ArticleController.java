package com.springboot.blog.controller;

import com.springboot.blog.domain.Article;
import com.springboot.blog.service.ArticleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@Controller
public class ArticleController {
    private final Logger logger = LoggerFactory.getLogger(ArticleController.class);
    @Resource
    private ArticleService articleService;

    /**
     * 显示栏目列表
     *
     * @param model 数据回显model
     * @return 栏目列表页
     */
    @GetMapping(value = "/articles")
    public String listPage(Model model) {
        model.addAttribute("list", articleService.list());
        return "article/list";
    }

    /**
     * 跳转到修改页面
     *
     * @param id 栏目id
     * @param model 数据回显model
     * @return 栏目列表页面
     */
    @GetMapping(value = "article/{id}")
    public String updatePage(@PathVariable Integer id, Model model) {
        Article article = articleService.findById(id);
        model.addAttribute("article", article);
        return "article/add";
    }

    /**
     * 修改栏目
     *
     * @param article 栏目
     * @return 栏目列表页面
     */
    @PutMapping(value = "/article")
    public String update(Article article) {
        int save = articleService.save(article);
        logger.info("update:{}", save);
        return "redirect:/articles";
    }

    /**
     * 删除栏目
     *
     * @param id 栏目id
     * @return 栏目列表页面
     */
    @DeleteMapping(value = "article/{id}")
    public String delete(@PathVariable Integer id) {
        int delete = articleService.delete(id);
        logger.info("delete:{}", delete);
        return "redirect:/articles";
    }

    /**
     * 添加栏目
     *
     * @param article
     * @return 栏目列表页面
     */
    @PostMapping(value = "/article")
    public String add(Article article) {
        int save = articleService.save(article);
        logger.info("save:{}", save);
        return "redirect:/articles";
    }

    /**
     * 跳转到添加页面
     *
     * @return 添加页面
     */
    @GetMapping(value = "/article")
    public String addPage() {
        return "article/add";
    }
}
