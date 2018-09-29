package com.rest.smoothchange.training.plan.schedule.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rest.smoothchange.training.plan.schedule.service.TrainingPlanScheduleService;



@RestController
@RequestMapping(value = "/trainingplanschedule")
@Transactional
public class TrainingPlanScheduleController {

	@Autowired
	private TrainingPlanScheduleService trainingPlanScheduleService; 
	

}
