package com.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.model.Topic;
import com.demo.repository.TopicRepository;

@Service("topicService")
public class TopicServiceImpl implements TopicService {

	@Autowired
	private TopicRepository topicRepository;

	/*
	 * private List<Topic> topics = new ArrayList<>(Arrays.asList(new
	 * Topic("spring", "spring mvc", "mvs decription"), new Topic("java",
	 * "core java", "core java description"), new Topic("html", "html5",
	 * "html 5 description")));
	 */

	@Override
	public List<Topic> getAllTopics() {

		// return topics;

		List<Topic> topics = new ArrayList<>();
		topicRepository.findAll().forEach(topics::add);
		return topics;
	}

	@Override
	public Topic getTopic(String id) {
		// return topics.stream().filter(t ->
		// t.getId().equals(id)).findFirst().get();

		return topicRepository.findOne(id);

	}

	@Override
	public String addTopic(Topic topic) {

		// topics.add(topic);

		topicRepository.save(topic);

		return topic.getId();
	}

	@Override
	public Topic updateTopic(String id, Topic topic) {
		/*
		 * for (Topic t : topics) {
		 * 
		 * if (t.getId().equals(id)) { topics.set(topics.indexOf(t), topic);
		 * return topic; }
		 * 
		 * } return null;
		 */

		topicRepository.delete(id);

		return topicRepository.save(topic);

	}

	@Override
	public Topic deleteTopic(String id) {
		/*
		 * for (Topic t : topics) {
		 * 
		 * if (t.getId().equals(id)) { Topic deletedTopic =
		 * topics.remove(topics.indexOf(t)); return deletedTopic; }
		 * 
		 * } return null;
		 */
		Topic topic = topicRepository.findOne(id);
		topicRepository.delete(id);
		return topic;
	}

}
