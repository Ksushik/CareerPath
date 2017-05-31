package com.syniaeva.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.syniaeva.dao.PositionDao;
import com.syniaeva.entity.Position;
import com.syniaeva.services.PositionService;

/**
 * Created by osyniaeva on 5/31/17.
 */

@Service
public class PositionServiseImpl implements PositionService{

	@Autowired
	private PositionDao positionDao;

	@Override
	public List<Position> getAll() {
		return positionDao.findAll();
	}
}
