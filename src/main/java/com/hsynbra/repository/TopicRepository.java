package com.hsynbra.repository;

import org.springframework.data.repository.CrudRepository;

import com.hsynbra.model.Topic;

public interface TopicRepository extends CrudRepository<Topic, Long> //buraya string yazmamızdaki sebep id'nin string olması
{

}
