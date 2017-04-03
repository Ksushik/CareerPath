package com.syniaeva.services.impl;

import com.syniaeva.dao.ManufacturerDao;
import com.syniaeva.entity.Manufacturer;
import com.syniaeva.services.ManufacturerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ManufacturerServiceImol implements ManufacturerService {

    @Autowired
    private ManufacturerDao manufacturerDao;
    @Override
    public List<Manufacturer> getll() {
        return manufacturerDao.findAll();
    }
}
