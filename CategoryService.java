package com.springboot.blog.service;

import com.springboot.blog.domain.Category;

import java.util.List;

public interface CategoryService {
    int save(Category category);

    int delete(Integer id);

    List<Category> list();

    Category findById(Integer id);
}
