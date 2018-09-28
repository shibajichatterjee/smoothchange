package com.rest.smoothchange.action.plan.training.items.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rest.smoothchange.action.plan.training.items.service.ActionPlanTrainingItemsService;



@RestController
@RequestMapping(value = "/actionplantrainingitems")
@Transactional
public class ActionPlanTrainingItemsController {

	@Autowired
	private ActionPlanTrainingItemsService actionPlanTrainingItemsService; 


	
	
	

}
