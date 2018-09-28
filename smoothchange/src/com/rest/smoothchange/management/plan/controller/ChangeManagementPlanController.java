package com.rest.smoothchange.management.plan.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rest.smoothchange.management.plan.service.ChangeManagementPlanService;



@RestController
@RequestMapping(value = "/changemanagementplan")
@Transactional
public class ChangeManagementPlanController {

	@Autowired
	private ChangeManagementPlanService changeManagementPlanService; 


	
	
	

}
