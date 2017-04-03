package com.syniaeva.services.impl;

import com.syniaeva.dao.CategoryDao;
import com.syniaeva.dao.ProductDao;
import com.syniaeva.entity.Category;
import com.syniaeva.entity.MappedProduct;
import com.syniaeva.model.Product;
import com.syniaeva.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductDao productDao;

    @Autowired
    private CategoryDao categoryDao;

    @Transactional
    public void add(Product product) {
        MappedProduct mappedProduct = new MappedProduct();
        mappedProduct.setName(product.getName());

        productDao.save(mappedProduct);
    }

    public void delete(Product product) {
//TODO finish implementation
    }

    public void clearAll() {
//TODO finish implementation
    }


    // this variant of implementation was used to show how findByName() of CategoryDao is working
    @Override
    public List<Product> getByCategory(String categoryName) {
        Category category = categoryDao.findByName(categoryName);
        return productDao.findAll().stream().filter(product -> product.getCategory()
                .equals(category)).map(product -> new Product(product)).collect(Collectors.toList());
    }

    @Override
    public List<Product> getByManufacturer(String manufacturerName) {
        return productDao.findAll().stream().filter(product -> product.getManufacturer().getName()
                .equalsIgnoreCase(manufacturerName)).map(product -> new Product(product)).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public List<Product> getAll() {
        List<MappedProduct> mappedProducts = productDao.findAll();
        List<Product> products = new ArrayList<Product>(mappedProducts.size());
        for (MappedProduct mappedProduct : mappedProducts) {
            Product product = new Product(mappedProduct);
            products.add(product);
        }
        return products;
    }
}
