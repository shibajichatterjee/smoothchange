package com.rest.smoothchange.support.plan.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rest.smoothchange.support.plan.service.SupportPlanService;



@RestController
@RequestMapping(value = "/supportplan")
@Transactional
public class SupportPlanController {

	@Autowired
	private SupportPlanService supportPlan; 


	
	
	

}
