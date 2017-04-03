package com.syniaeva.dao;


import com.syniaeva.entity.MappedProduct;

import java.util.List;

public interface ProductDao {

    void save(MappedProduct product);

    void update (MappedProduct product);

    void delete (MappedProduct product);

    List<MappedProduct> findAll();


}
