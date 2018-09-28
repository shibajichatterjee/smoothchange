package com.rest.smoothchange.organization.info.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rest.smoothchange.organization.info.service.OrganizationInfoService;



@RestController
@RequestMapping(value = "/organisationinfo")
@Transactional
public class OrganizationInfoController {

	@Autowired
	private OrganizationInfoService organizationInfoService;


	
	


}
