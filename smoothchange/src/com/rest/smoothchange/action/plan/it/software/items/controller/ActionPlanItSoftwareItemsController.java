package com.rest.smoothchange.action.plan.it.software.items.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rest.smoothchange.action.plan.it.software.items.service.ActionPlanItSoftwareItemsService;



@RestController
@RequestMapping(value = "/actionplanptsoftwareitems")
@Transactional
public class ActionPlanItSoftwareItemsController {

	@Autowired
	private ActionPlanItSoftwareItemsService actionPlanItSoftwareItemsService; 


	
	
	

}
