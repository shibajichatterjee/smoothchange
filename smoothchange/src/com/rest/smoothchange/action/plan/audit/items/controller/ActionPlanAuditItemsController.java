package com.rest.smoothchange.action.plan.audit.items.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rest.smoothchange.action.plan.audit.items.service.ActionPlanAuditItemsService;



@RestController
@RequestMapping(value = "/actionplanaudititemsservice")
@Transactional
public class ActionPlanAuditItemsController {

	@Autowired
	private ActionPlanAuditItemsService actionPlanAuditItemsService; 


	
	
	

}
