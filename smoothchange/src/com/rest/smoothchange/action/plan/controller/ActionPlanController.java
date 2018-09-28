package com.rest.smoothchange.action.plan.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rest.smoothchange.action.plan.service.ActionPlanService;



@RestController
@RequestMapping(value = "/actionplan")
@Transactional
public class ActionPlanController {

	@Autowired
	private ActionPlanService actionPlanService; 


	
	
	

}
