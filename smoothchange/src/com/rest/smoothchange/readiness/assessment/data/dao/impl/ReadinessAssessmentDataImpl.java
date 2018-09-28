package com.rest.smoothchange.readiness.assessment.data.dao.impl;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.rest.framework.dao.impl.AbstractDAO;
import com.rest.smoothchange.readiness.assessment.data.dao.ReadinessAssessmentDataDao;
import com.rest.smoothchange.readiness.assessment.data.entity.ReadinessAssessmentData;

@Repository
@Transactional
public class ReadinessAssessmentDataImpl extends AbstractDAO<ReadinessAssessmentData> implements ReadinessAssessmentDataDao{

	 
}
