package com.rest.smoothchange.training.plan.version.history.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rest.smoothchange.training.plan.service.TrainingPlanService;



@RestController
@RequestMapping(value = "/trainingplanservice")
@Transactional
public class TrainingPlanVersionHistoryController {

	@Autowired
	private TrainingPlanService trainingPlanService; 


	
	
	

}
