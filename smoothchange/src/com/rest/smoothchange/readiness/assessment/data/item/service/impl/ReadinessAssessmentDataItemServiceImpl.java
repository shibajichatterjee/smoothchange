package com.rest.smoothchange.readiness.assessment.data.item.service.impl;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rest.framework.service.impl.AbstractService;
import com.rest.smoothchange.readiness.assessment.data.item.dao.ReadinessAssessmentDataItemDao;
import com.rest.smoothchange.readiness.assessment.data.item.dto.ReadinessAssessmentDataItemDto;
import com.rest.smoothchange.readiness.assessment.data.item.entity.ReadinessAssessmentDataItem;
import com.rest.smoothchange.readiness.assessment.data.item.mapper.ReadinessAssessmentDataItemMapper;
import com.rest.smoothchange.readiness.assessment.data.item.service.ReadinessAssessmentDataItemService;


@Service
@Transactional
public class ReadinessAssessmentDataItemServiceImpl extends AbstractService<ReadinessAssessmentDataItemDao, ReadinessAssessmentDataItemDto, ReadinessAssessmentDataItemMapper, ReadinessAssessmentDataItem>  implements ReadinessAssessmentDataItemService{

	
}
