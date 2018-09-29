package com.rest.smoothchange.training.plan.equipment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rest.smoothchange.training.plan.equipment.service.TrainingPlanEquipmentService;



@RestController
@RequestMapping(value = "/trainingPlanEquipment")
@Transactional
public class TrainingPlanEquipmentController {

	@Autowired
	private TrainingPlanEquipmentService trainingPlanEquipmentService; 
	
	

}
