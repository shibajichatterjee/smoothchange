package com.rest.smoothchange.action.plan.business.unit.items.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rest.smoothchange.action.plan.business.unit.items.service.ActionPlanBusinessUnitItemsService;



@RestController
@RequestMapping(value = "/actionplanbusinessunititems")
@Transactional
public class ActionPlanBusinessUnitItemsController {

	@Autowired
	private ActionPlanBusinessUnitItemsService actionPlanBusinessUnitItemsService; 


	
	
	

}
