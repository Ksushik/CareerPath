package com.syniaeva.dao.impl;

import com.syniaeva.dao.CategoryDao;
import com.syniaeva.entity.Category;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by stoxa on 02.04.17.
 */
@Repository("categoryDao")
public class CategoryDaoImpl implements CategoryDao {

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Category> findAll() {
        return em.createQuery("SELECT category FROM Category category").getResultList();
    }


    @Override
    public void update(Category category) {
        Category old = em.find(Category.class, category.getId());
        old.setName(category.getName());

    }

    @Override
    public void save(Category category) {
        em.persist(category);
    }

    @Override
    public void delete(Category category) {
        em.remove(em.contains(category) ? category : em.merge(category));
    }
}
