package com.syniaeva.dao;

import com.syniaeva.entity.Category;

import java.util.List;

/**
 * Created by stoxa on 02.04.17.
 */
public interface CategoryDao {

    List<Category> findAll();

    void update(Category category);

    void save (Category category);

    void delete (Category category);
}
