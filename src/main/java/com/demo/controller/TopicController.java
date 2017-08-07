package com.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.demo.model.Topic;
import com.demo.service.TopicService;

@RestController
public class TopicController {

	@Autowired
	private TopicService topicService;

	@RequestMapping("/topics")
	public List<Topic> getAllTopics() {

		return topicService.getAllTopics();
	}

	@RequestMapping("/topics/{topicId}")
	public Topic getTopic(@PathVariable("topicId") String id) {
		return topicService.getTopic(id);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/topics")
	public String addTopic(@RequestBody Topic topic) {

		return topicService.addTopic(topic);
	}

	@RequestMapping(method = RequestMethod.PUT, value = "/topics/{topicId}")
	public Topic updateTopic(@RequestBody Topic topic, @PathVariable("topicId") String id) {
		return topicService.updateTopic(id, topic);
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/topics/{topicId}")
	public Topic deleteTopic(@PathVariable("topicId") String id) {
		return topicService.deleteTopic(id);
	}
}
