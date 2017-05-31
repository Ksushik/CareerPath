package com.syniaeva.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.syniaeva.dao.CategoryDao;
import com.syniaeva.dao.SkillDao;
import com.syniaeva.entity.Skill;
import com.syniaeva.services.SkillService;

@Service
public class SkillServiceImpl implements SkillService {

	@Autowired
	private SkillDao skillDao;

	@Autowired
	private CategoryDao positionDao;

	@Transactional
	public void add(Skill skill) {
		skillDao.save(skill);
	}

	public void delete(Skill skill) {
		skillDao.delete(skill);
	}

	public void update(Skill skill) {
		skillDao.update(skill);
	}

	@Transactional(readOnly = true)
	public List<Skill> getAll() {
		return skillDao.findAll();
	}

	private Skill getByNameAndTopic(String skillName, String topicName) {
		return skillDao.findAll().stream().filter(skill -> skill.getTopic().getName()
				.equalsIgnoreCase(topicName)).filter(skill -> skill.getName()
				.equalsIgnoreCase(skillName)).findFirst().get();
	}
}
