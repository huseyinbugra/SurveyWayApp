package com.hsynbra.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hsynbra.model.Topic;
import com.hsynbra.service.TopicService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class TopicController {
	
	private final TopicService topicService;
	
	@GetMapping("/topics")
	public List<Topic> getAllTopics() {
		return topicService.getTopics();
	}

	@GetMapping("/topics/{id}")
	public Optional<Topic> getTopicById(@PathVariable Long id) {
		return topicService.getTopicById(id);
	}
	
	@PostMapping("/topics")
	public void createTopic(@RequestBody Topic topic) {
		topicService.createTopic(topic);
	}
	
	@PutMapping("/topics/{id}")
	public void updateItem(@RequestBody Topic topic, @PathVariable Long id ) {
		topicService.updateTopic(topic, id);
	}
	
	@DeleteMapping(value="/topics/{id}")
	public void deleteItem(@PathVariable Long id ) {
		topicService.deleteTopic(id);
	}
	
	
	
}