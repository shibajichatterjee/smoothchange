package com.rest.smoothchange.readiness.assessment.data.service.impl;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rest.framework.service.impl.AbstractService;
import com.rest.smoothchange.readiness.assessment.data.dao.ReadinessAssessmentDataDao;
import com.rest.smoothchange.readiness.assessment.data.dto.ReadinessAssessmentDataDto;
import com.rest.smoothchange.readiness.assessment.data.entity.ReadinessAssessmentData;
import com.rest.smoothchange.readiness.assessment.data.mapper.ReadinessAssessmentDataMapper;
import com.rest.smoothchange.readiness.assessment.data.service.ReadinessAssessmentDataService;


@Service
@Transactional
public class ReadinessAssessmentDataServiceImpl extends AbstractService<ReadinessAssessmentDataDao, ReadinessAssessmentDataDto, ReadinessAssessmentDataMapper, ReadinessAssessmentData>  implements ReadinessAssessmentDataService{

	
}
