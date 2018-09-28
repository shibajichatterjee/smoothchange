package com.rest.smoothchange.readiness.category.master.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rest.smoothchange.readiness.category.items.master.service.ReadinessCategoryItemsMasterService;



@RestController
@RequestMapping(value = "/readinesscategoryitemsmaster")
@Transactional
public class ReadinessCategoryMasterController {

	@Autowired
	private ReadinessCategoryItemsMasterService readinessCategoryItemsMasterService; 


	
	
	

}
