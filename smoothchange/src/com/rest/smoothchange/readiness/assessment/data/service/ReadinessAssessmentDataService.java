package com.rest.smoothchange.readiness.assessment.data.service;

import com.rest.framework.service.Service;
import com.rest.smoothchange.readiness.assessment.data.dto.ReadinessAssessmentDataDto;


public interface ReadinessAssessmentDataService extends Service<ReadinessAssessmentDataDto>{
	
	ReadinessAssessmentDataDto getReadinessAssessmentDataByItemId(long readinessCategoryItemItem);

}
