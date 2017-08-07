package com.demo;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.demo.controller.TopicController;
import com.demo.model.Topic;
import com.demo.repository.TopicRepository;

public class TopicControllerTest {
	@InjectMocks
	private TopicController tc;

	@Mock
	private TopicRepository tcrepo;

	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testTopicGet() {

		Topic t = new Topic();
		t.setId("spring");

		List<Topic> topics1 = new ArrayList<>(
				Arrays.asList(new Topic("spring", "spring mvc", "spring mvc description")));

		when(tcrepo.findAll()).thenReturn(topics1);

		List<Topic> topics = tc.getAllTopics();
		Topic t1 = topics.get(0);
		assertEquals("spring", t1.getId());
	}

}
