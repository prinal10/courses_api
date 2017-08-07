package com.demo.service;

import java.util.List;

import com.demo.model.Topic;

public interface TopicService {

	List<Topic> getAllTopics();

	Topic getTopic(String id);

	String addTopic(Topic topic);

	Topic updateTopic(String id, Topic topic);

	Topic deleteTopic(String id);

}
