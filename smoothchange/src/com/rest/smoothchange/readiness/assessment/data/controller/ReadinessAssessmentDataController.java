package com.rest.smoothchange.readiness.assessment.data.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rest.smoothchange.readiness.assessment.data.service.ReadinessAssessmentDataService;



@RestController
@RequestMapping(value = "/readinessassessmentdata")
@Transactional
public class ReadinessAssessmentDataController {

	@Autowired
	private ReadinessAssessmentDataService readinessAssessmentDataService; 


	
	
	

}
