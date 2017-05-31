package com.syniaeva.dao;


import com.syniaeva.entity.Skill;

import java.util.List;

public interface SkillDao {

    void save(Skill product);

    void update (Skill product);

    void delete (Skill product);

    List<Skill> findAll();


}
