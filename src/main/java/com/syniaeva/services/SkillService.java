package com.syniaeva.services;

import java.util.List;

import com.syniaeva.entity.Skill;

public interface SkillService {
	void add(Skill skill);

	void delete(Skill skill);

	List<Skill> getAll();

}
