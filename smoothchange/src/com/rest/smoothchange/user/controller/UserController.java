package com.rest.smoothchange.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rest.smoothchange.user.service.UserService;



@RestController
@RequestMapping(value = "/user")
@Transactional
public class UserController {

	@Autowired
	private UserService userService; 


	
	
	

}
