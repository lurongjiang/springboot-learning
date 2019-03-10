package com.springboot.blog.controller;

import com.springboot.blog.domain.Category;
import com.springboot.blog.service.CategoryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@Controller
public class CategoryController {
    private final Logger logger = LoggerFactory.getLogger(CategoryController.class);
    @Resource
    private CategoryService categoryService;

    /**
     * 显示栏目列表
     *
     * @param model 数据回显model
     * @return 栏目列表页
     */
    @GetMapping(value = "/categories")
    public String listPage(Model model) {
        model.addAttribute("list", categoryService.list());
        return "category/list";
    }

    /**
     * 跳转到修改页面
     *
     * @param id 栏目id
     * @param model 数据回显model
     * @return 栏目列表页面
     */
    @GetMapping(value = "category/{id}")
    public String updatePage(@PathVariable Integer id, Model model) {
        Category category = categoryService.findById(id);
        model.addAttribute("category", category);
        return "category/add";
    }

    /**
     * 修改栏目
     *
     * @param category 栏目
     * @return 栏目列表页面
     */
    @PutMapping(value = "/category")
    public String update(Category category) {
        int save = categoryService.save(category);
        logger.info("update:{}", save);
        return "redirect:/categories";
    }

    /**
     * 删除栏目
     *
     * @param id 栏目id
     * @return 栏目列表页面
     */
    @DeleteMapping(value = "category/{id}")
    public String delete(@PathVariable Integer id) {
        int delete = categoryService.delete(id);
        logger.info("delete:{}", delete);
        return "redirect:/categories";
    }

    /**
     * 添加栏目
     *
     * @param category
     * @return 栏目列表页面
     */
    @PostMapping(value = "/category")
    public String add(Category category) {
        int save = categoryService.save(category);
        logger.info("save:{}", save);
        return "redirect:/categories";
    }

    /**
     * 跳转到添加页面
     *
     * @return 添加页面
     */
    @GetMapping(value = "/category")
    public String addPage() {
        return "category/add";
    }
}
