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

    private static final String DB_DRIVER = "org.h2.Driver";
    private static final String DB_CONNECTION = "jdbc:h2:mem:test;DB_CLOSE_DELAY=-1";
    private static final String DB_USER = "";
    private static final String DB_PASSWORD = "";

    private static Connection getDBConnection() {
        Connection dbConnection = null;
        try {
            Class.forName(DB_DRIVER);
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
        try {
            dbConnection = DriverManager.getConnection(DB_CONNECTION, DB_USER, DB_PASSWORD);
            return dbConnection;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return dbConnection;
    }


    @Override
    public List<Category> findAll() {
        Connection connection = getDBConnection();
        List<Category> categories = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM categories");
            while (resultSet.next()) {
                categories.add(new Category(resultSet.getLong("CATEGORY_ID"),
                        resultSet.getString("name")));
            }
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return categories;
    }

    @Override
    public Category findById(Long id) {
        Connection connection = getDBConnection();
        Category result = new Category(id,"unknown");
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM categories WHERE " +
                    "CATEGORY_ID=?");
            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                result = new Category(resultSet.getLong("CATEGORY_ID"),
                        resultSet.getString("name"));
            }
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public Category findByName(String name) {
        Connection connection = getDBConnection();
        Category result = null;
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM categories WHERE " +
                    "NAME=?");
            statement.setString(1, name);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                result = new Category(resultSet.getLong("CATEGORY_ID"),
                        resultSet.getString("name"));
            }
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
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
        em.remove(category);
    }
}
