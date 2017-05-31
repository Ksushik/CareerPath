package com.syniaeva.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.syniaeva.entity.Category;
import com.syniaeva.entity.Skill;
import com.syniaeva.entity.Topic;
import com.syniaeva.services.CategoryService;
import com.syniaeva.services.PositionService;
import com.syniaeva.services.TopicService;
import com.syniaeva.services.SkillService;

@RestController
@EnableWebMvc
@RequestMapping(value = "/skills", headers = "Accept=*/*")
public class SkillsController {

	@Autowired
	private SkillService skillService;

	@Autowired
	private CategoryService categoryService;

	@Autowired
	private TopicService topicService;

	@Autowired
	private PositionService positionService;

	@RequestMapping(method = RequestMethod.POST,
			consumes = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
	public void add(@RequestBody Skill skill) {
		skillService.add(skill);
	}

	@RequestMapping(method = RequestMethod.GET,
			produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE},
			consumes = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
	public
	@ResponseBody
	List<Skill> getAllSkills() {
		return skillService.getAll();
	}

	@RequestMapping(value = "/categories", method = RequestMethod.GET,
			produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE},
			consumes = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
	public
	@ResponseBody
	List<Category> getAllCategories() {
		return categoryService.getAll();
	}


	@RequestMapping(value = "/topics", method = RequestMethod.GET,
			produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE},
			consumes = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
	public @ResponseBody List<Topic> getAllTopics() {
		return topicService.getll();
	}


}
