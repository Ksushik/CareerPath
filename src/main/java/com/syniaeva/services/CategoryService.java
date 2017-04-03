package com.syniaeva.services;

import com.syniaeva.entity.Category;

import java.util.List;


public interface CategoryService {

    void add(Category category);

    void delete(Category category);

    void delete(String categoryName);

    void update(Category category);

    List<Category> getAll();
}
