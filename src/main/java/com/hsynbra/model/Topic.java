package com.hsynbra.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.sun.istack.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Topic {

	@Id
	@GeneratedValue
	private Long topicId;
	
	@NotNull
	private String topicName;
	
	@NotNull
	private String topicQuestion;
	
	private Double nPM;


	
}