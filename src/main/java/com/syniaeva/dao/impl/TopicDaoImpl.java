package com.syniaeva.dao.impl;

import com.syniaeva.dao.TopicDao;
import com.syniaeva.entity.Topic;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by stoxa on 02.04.17.
 */

@Repository("topicDao")
public class TopicDaoImpl implements TopicDao {

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Topic> findAll() {
        return em.createQuery("SELECT topic FROM Topic topic").getResultList();
    }

}
