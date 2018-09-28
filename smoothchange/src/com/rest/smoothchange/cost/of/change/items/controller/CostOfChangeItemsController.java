package com.rest.smoothchange.cost.of.change.items.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rest.smoothchange.cost.of.change.items.service.CostOfChangeItemsService;



@RestController
@RequestMapping(value = "/costofchangeitems")
@Transactional
public class CostOfChangeItemsController {

	@Autowired
	private CostOfChangeItemsService costOfChangeItemsService; 


	

}
