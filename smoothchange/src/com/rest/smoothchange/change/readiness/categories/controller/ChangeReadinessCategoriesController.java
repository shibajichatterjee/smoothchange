package com.rest.smoothchange.change.readiness.categories.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rest.smoothchange.admin.service.AdminService;



@RestController
@RequestMapping(value = "/admin")
@Transactional
public class ChangeReadinessCategoriesController {

	@Autowired
	private AdminService adminService; 


	
	
	

}
