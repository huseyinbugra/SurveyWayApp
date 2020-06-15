package com.hsynbra.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.hsynbra.model.Survey;
import com.hsynbra.repository.SurveyRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SurveyService {
	
	private final SurveyRepository surveyRepository;
	private final TopicService topicService;
	
	public List<Survey> getSurveys(){
		List <Survey> surveys = new ArrayList<Survey>();
		surveyRepository.findAll().forEach(surveys::add);
		return surveys;
	}

	public void createSurvey(Survey survey) {
		surveyRepository.save(survey);
		updatenPM(survey.getTopic().getTopicId());
	}
	
	public void updateSurvey(Survey survey, Long id) {
		surveyRepository.save(survey);
	}

	public void deleteSurvey(Long id) {
		surveyRepository.deleteById(id);
	}

	public List<Survey> getSurveysByTopicId(Long id){
		List <Survey> surveys = new ArrayList<Survey>();
		List <Survey> surveysById = new ArrayList<Survey>();
		surveyRepository.findAll().forEach(surveys::add);
		for (Survey survey : surveys) {
			if(survey.getTopic().getTopicId()==id) {
				surveysById.add(survey);
			}
		}
		return surveysById;
	}	
	
	public Optional<Survey> getSurveyById(Long id) {
		return surveyRepository.findById(id);
	}
	
	private void updatenPM(Long id) {
		List <Survey> surveys = new ArrayList<Survey>();
		surveyRepository.findAll().forEach(surveys::add);
		
		Double promoters = 0d;
		Double dectators = 0d;
		Double all = 0d;
		
		for (Survey survey : surveys) {
			
			if(survey.getTopic().getTopicId()==id && survey.getSurveyScore()>8) {
				promoters++;
				all++;
			}
			else if(survey.getTopic().getTopicId()==id && survey.getSurveyScore()<7) {
				dectators++;
				all++;
			}
		}
		Double nPM =(promoters-dectators)/all*100;	
		for (Survey survey : surveys) {
			if(survey.getTopic().getTopicId()==id) {
				survey.getTopic().setNPM(nPM);
				topicService.updateTopic(survey.getTopic(), id);
				return;
			}
		}
	}
}
