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

import com.hsynbra.model.Survey;
import com.hsynbra.service.SurveyService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class SurveyController {
	
	private final SurveyService surveyService;
	
	@GetMapping("/surveys")
	@ApiOperation(value = "Retrieve All Surveys", notes = "Just Click")
	public List<Survey> getAllSurvey() {
		return surveyService.getSurveys();
	}
	
	@GetMapping("/surveys/topics/{id}")
	@ApiResponses(value = {@ApiResponse(code = 200, message = "Başarıyla Eklendi"), @ApiResponse(code = 404, message = "Şema bulunamadı")})
	public List<Survey> getSurveyByTopicId(@PathVariable Long id) {
		return surveyService.getSurveysByTopicId(id);
	}

	@GetMapping("/surveys/{id}")
	public Optional<Survey> getSurveyById(@PathVariable Long id) {
		return surveyService.getSurveyById(id);
	}
	
	@PostMapping("/surveys")
	public void createSurvey(@RequestBody Survey survey) {
		surveyService.createSurvey(survey);
	}
	
	@PutMapping("/surveys/{id}")
	public void updateItem(@RequestBody Survey survey, @PathVariable Long id ) {
		surveyService.updateSurvey(survey, id);
	}
	
	@DeleteMapping("/surveys/{id}")
	public void deleteItem(@PathVariable Long id ) {
		surveyService.deleteSurvey(id);
	}

}