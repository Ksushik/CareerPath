package com.syniaeva.services.impl;

import com.syniaeva.dao.CategoryDao;
import com.syniaeva.entity.Category;
import com.syniaeva.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryDao categoryDao;

    @Override
    public void add(Category category) {
        categoryDao.save(category);
    }

    @Override
    public void delete(Category category) {
        categoryDao.delete(category);
    }

    @Override
    public void update(Category category) {
        categoryDao.update(category);
    }

    @Override
    public List<Category> getAll() {
        return categoryDao.findAll();
    }
}
