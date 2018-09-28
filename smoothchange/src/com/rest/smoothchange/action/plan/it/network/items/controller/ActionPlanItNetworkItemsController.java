package com.rest.smoothchange.action.plan.it.network.items.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rest.smoothchange.action.plan.it.network.items.service.ActionPlanItNetworkItemsService;



@RestController
@RequestMapping(value = "/actionplanptnetworkitems")
@Transactional
public class ActionPlanItNetworkItemsController {

	@Autowired
	private ActionPlanItNetworkItemsService actionPlanItNetworkItemsService; 


	
	
	

}
