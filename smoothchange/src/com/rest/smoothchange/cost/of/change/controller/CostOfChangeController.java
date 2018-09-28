package com.rest.smoothchange.cost.of.change.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rest.smoothchange.cost.of.change.service.CostOfChangeService;



@RestController
@RequestMapping(value = "/costofchange")
@Transactional
public class CostOfChangeController {

	@Autowired
	private CostOfChangeService costOfChangeService; 


	
	
	

}
