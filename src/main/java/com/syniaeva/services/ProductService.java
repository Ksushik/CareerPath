package com.syniaeva.services;


import com.syniaeva.model.Product;

import java.util.List;

public interface ProductService {
    void add(Product product);

    void delete(Product product);

    List<Product> getByCategory(String category);

    List<Product> getByManufacturer(String manufacturer);

    List<Product> getAll();

}
