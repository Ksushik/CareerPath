package com.syniaeva.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.syniaeva.dao.PositionDao;
import com.syniaeva.entity.Position;

@Repository("positionDao")
public class PositionDaoImpl implements PositionDao {

	@PersistenceContext
	private EntityManager em;

	@Override
	public List<Position> findAll() {
		return em.createQuery("SELECT position FROM Position position").getResultList();
	}
}
