package com.rest.smoothchange.implementation.strategy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rest.smoothchange.project.stakeholders.service.ProjectStakeholdersService;



@RestController
@RequestMapping(value = "/projectstackholder")
@Transactional
public class ImplementationStrategyController {

	@Autowired
	private ProjectStakeholdersService projectStakeholdersService; 


	
	


}
