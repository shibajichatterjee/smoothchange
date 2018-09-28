package com.rest.smoothchange.action.plan.communication.items.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rest.smoothchange.action.plan.communication.items.service.ActionPlanCommunicationItemsService;



@RestController
@RequestMapping(value = "/actionplancommunicationitems")
@Transactional
public class ActionPlanCommunicationItemsController {

	@Autowired
	private ActionPlanCommunicationItemsService actionPlanCommunicationItemsServicese; 


	
	
	

}
