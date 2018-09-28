package com.rest.smoothchange.action.plan.it.hardware.items.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rest.smoothchange.action.plan.it.hardware.items.service.ActionPlanItHardwareItemsService;



@RestController
@RequestMapping(value = "/actionplanithardwareitems")
@Transactional
public class ActionPlanItHardwareItemsController {

	@Autowired
	private ActionPlanItHardwareItemsService actionPlanItHardwareItemsService; 


	
	
	

}
