package com.rest.smoothchange.readiness.assessment.data.item.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rest.smoothchange.readiness.assessment.data.item.service.ReadinessAssessmentDataItemService;
import com.rest.smoothchange.readiness.assessment.data.service.ReadinessAssessmentDataService;



@RestController
@RequestMapping(value = "/readinessAssessmentDataItemServiceAPI")
@Transactional
public class ReadinessAssessmentDataItemController {

	@Autowired
	private ReadinessAssessmentDataItemService readinessAssessmentDataItemService; 


}
