package com.syniaeva.dao.impl;

import com.syniaeva.dao.ManufacturerDao;
import com.syniaeva.entity.Manufacturer;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by stoxa on 02.04.17.
 */

@Repository("manufacturerDao")
public class ManufacturerDaoImpl implements ManufacturerDao {

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Manufacturer> findAll() {
        return em.createQuery("SELECT manufacturer FROM Manufacturer manufacturer").getResultList();
    }

}
