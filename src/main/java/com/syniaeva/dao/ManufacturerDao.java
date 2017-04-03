package com.syniaeva.dao;

import com.syniaeva.entity.Manufacturer;

import java.util.List;

/**
 * Created by stoxa on 02.04.17.
 */
public interface ManufacturerDao {

    List<Manufacturer> findAll();

}
