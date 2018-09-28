package com.rest.smoothchange.action.plan.project.team.items.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rest.smoothchange.action.plan.project.team.items.service.ActionPlanProjectTeamItemsService;



@RestController
@RequestMapping(value = "/actionplanprojectteamItems")
@Transactional
public class ActionPlanProjectTeamItemsController {

	@Autowired
	private ActionPlanProjectTeamItemsService actionPlanProjectTeamItemsService; 


	
	
	

}
