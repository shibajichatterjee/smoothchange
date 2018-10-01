package com.rest.smoothchange.communication.plan.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rest.smoothchange.communication.plan.service.CommunicationPlanService;



@RestController
@RequestMapping(value = "/communicationplan")
@Transactional
public class CommunicationPlanController {

	@Autowired
	private CommunicationPlanService communicationPlanService; 


	
	


}
