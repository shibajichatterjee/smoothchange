package com.rest.smoothchange.support.plan.items.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rest.smoothchange.support.plan.items.service.SupportPlanItemsService;



@RestController
@RequestMapping(value = "/supportPlanItemAPI")
@Transactional
public class SupportPlanItemsController {

	@Autowired
	private SupportPlanItemsService supportPlanItemService; 


	
	
	

}
