package com.rest.smoothchange.action.plan.items.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rest.smoothchange.action.plan.items.service.ActionPlanItemsService;

import io.swagger.annotations.Api;

@RestController
@RequestMapping(value = "/actionPlanItemsAPI")
@Api(value = "Action Plan Items", description = "Operations For Action Plan Items")
@Transactional
public class ActionPlanItemsController {

	@Autowired
	private ActionPlanItemsService actionPlanItemsService;
	
	
}
