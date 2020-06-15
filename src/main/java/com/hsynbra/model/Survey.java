package com.hsynbra.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@ApiModel(description="Anket Detayları")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Survey {

	@Id
	@GeneratedValue
	@ApiModelProperty(notes="id boş geçilemez")
	private Long surveyId;

	private int surveyScore;
	
	private String feedback;
	
	@ManyToOne
	@JoinColumn(name="topicId")
	private Topic topic;
	
}
