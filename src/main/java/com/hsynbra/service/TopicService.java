package com.hsynbra.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.hsynbra.model.Topic;
import com.hsynbra.repository.TopicRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TopicService {
	
	private final TopicRepository topicRepository;
	
	public List<Topic> getTopics(){
		List <Topic> topics = new ArrayList<Topic>();
		topicRepository.findAll().forEach(topics::add);
		return topics;
	}
	
	public Optional<Topic> getTopicById(Long id) {
		return topicRepository.findById(id);
	}

	public void createTopic(Topic topic) {
		topicRepository.save(topic);
	}

	public void updateTopic(Topic topic, Long id) {
		topicRepository.save(topic);
	}

	public void deleteTopic(Long id) {
		topicRepository.deleteById(id);
	}
}
