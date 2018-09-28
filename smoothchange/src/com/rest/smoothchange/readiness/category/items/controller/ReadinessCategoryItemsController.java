package com.rest.smoothchange.readiness.category.items.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rest.smoothchange.readiness.category.items.service.ReadinessCategoryItemsService;



@RestController
@RequestMapping(value = "/readinesscategoryitems")
@Transactional
public class ReadinessCategoryItemsController {

	@Autowired
	private ReadinessCategoryItemsService readinessCategoryItems; 


	
	
	

}
