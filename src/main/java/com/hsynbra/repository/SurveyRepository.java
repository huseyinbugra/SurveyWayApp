package com.hsynbra.repository;

import org.springframework.data.repository.CrudRepository;

import com.hsynbra.model.Survey;

public interface SurveyRepository extends CrudRepository<Survey, Long> //buraya string yazmamızdaki sebep id'nin string olması
{


}
