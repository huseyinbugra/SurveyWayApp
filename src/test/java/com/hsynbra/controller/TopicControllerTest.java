package com.hsynbra.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.hsynbra.model.Topic;
import com.hsynbra.service.TopicService;

@SpringBootTest
class TopicControllerTest {
	
	@Autowired
	TopicService topicService;

	@Test
	void testCreateTopic() {
		
		Topic topic = new Topic();
		topic.setTopicId(1L);
		topic.setTopicName("groove");
		topic.setTopicQuestion("groove nasıldır?");
		
		topicService.createTopic(topic);
		Optional<Topic> topicOpt = topicService.getTopicById(topic.getTopicId());
		List<Topic> allTopics = topicService.getTopics();
		
		assertTrue(topicOpt.get().getTopicId()>0L);
		assertEquals(allTopics.size(),1);
		
	}

}