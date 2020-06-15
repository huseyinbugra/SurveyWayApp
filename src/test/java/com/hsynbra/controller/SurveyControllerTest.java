package com.hsynbra.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.hsynbra.model.Survey;
import com.hsynbra.model.Topic;
import com.hsynbra.service.SurveyService;
import com.hsynbra.service.TopicService;

@SpringBootTest
class SurveyControllerTest {
	
	@Autowired
	SurveyService surveyService;
	
	@Autowired
	TopicService topicService;
	
	@Test
	void testCreateSurvey() {
		
		Topic topic = new Topic();
		topic.setTopicId(1L);
		topic.setTopicName("dsfads");
		topic.setTopicQuestion("ok");
		
		topicService.createTopic(topic);
		
		Survey survey = new Survey();
		survey.setSurveyId(5L);
		survey.setFeedback("evet");
		survey.setSurveyScore(1);	
		survey.setTopic(topic);
		
		surveyService.createSurvey(survey);
		List<Survey> allSurveys = surveyService.getSurveys();
		
		assertTrue(allSurveys.get(0).getSurveyId()>0L);
		assertEquals(allSurveys.size(),1);
		
	}

}