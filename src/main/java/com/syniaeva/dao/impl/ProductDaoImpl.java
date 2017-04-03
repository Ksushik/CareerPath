package com.syniaeva.dao.impl;


import com.syniaeva.dao.ProductDao;
import com.syniaeva.entity.MappedProduct;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository("productDao")
public class ProductDaoImpl implements ProductDao {

    @PersistenceContext
    private EntityManager em;


    public void save(MappedProduct product) {
        em.persist(product);
    }

    @Override
    public void update(MappedProduct product) {
        // TODO Finish implementation
    }

    @Override
    public void delete(MappedProduct product) {
        em.remove(product);
    }

    public List<MappedProduct> findAll() {
        return em.createQuery("SELECT mappedProduct FROM MappedProduct mappedProduct").getResultList();
    }
}
