package com.syniaeva.dao.impl;


import com.syniaeva.dao.SkillDao;
import com.syniaeva.entity.Skill;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository("skillDao")
public class SkillDaoImpl implements SkillDao {

    @PersistenceContext
    private EntityManager em;


    public void save(Skill product) {
        em.persist(product);
    }

    @Override
    public void update(Skill product) {
        // TODO Finish implementation
    }

    @Override
    public void delete(Skill product) {
        em.remove(product);
    }

    public List<Skill> findAll() {
        return em.createQuery("SELECT skill FROM Skill skill").getResultList();
    }
}
