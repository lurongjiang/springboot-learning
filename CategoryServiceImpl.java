package com.springboot.blog.service.impl;

import com.springboot.blog.domain.Category;
import com.springboot.blog.service.CategoryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
    private final Logger logger = LoggerFactory.getLogger(CategoryServiceImpl.class);
    private static final List<Category> LIST;
    private static int currentId = 1006;

    static {
        LIST = new ArrayList<>();
        LIST.add(new Category(1001, "web", "前端", "web前端"));
        LIST.add(new Category(1002, "java", "后端", "web后端"));
        LIST.add(new Category(1003, "python", "数据挖掘", "python大数据挖掘"));
        LIST.add(new Category(1004, "php", "后端", "php学习"));
        LIST.add(new Category(1005, "mysql", "数据库技术", "mysql技术"));
    }

    @Override
    public int save(Category category) {
        if (category.getId() == null) {
            category.setId(currentId++);
            LIST.add(category);
            logger.info("save!!");
        } else {
            for (Category item : LIST) {
                if (item.getId().equals(category.getId())) {
                    LIST.remove(item);
                    LIST.add(category);
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
        for (Category item : LIST) {
            if (id.equals(item.getId())) {
                LIST.remove(item);
                logger.info("delete!!");
                return 1;
            }
        }
        return 0;
    }

    @Override
    public List<Category> list() {
        return LIST;
    }

    @Override
    public Category findById(Integer id) {
        if (id == null) return null;
        for (Category category : LIST) {
            if (id.equals(category.getId()))
                return category;
        }
        return null;
    }
}
