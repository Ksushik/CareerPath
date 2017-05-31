package com.syniaeva.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.syniaeva.dao.TopicDao;
import com.syniaeva.entity.Topic;
import com.syniaeva.services.TopicService;

@Service
public class TopicServiceImpl implements TopicService {

	@Autowired
	private TopicDao topicDao;

	@Override
	public List<Topic> getll() {
		return topicDao.findAll();
	}
}
