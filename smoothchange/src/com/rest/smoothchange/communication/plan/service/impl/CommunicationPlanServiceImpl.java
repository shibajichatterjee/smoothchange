package com.rest.smoothchange.communication.plan.service.impl;


import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rest.framework.service.impl.AbstractService;
import com.rest.smoothchange.communication.plan.dao.CommunicationPlanDao;
import com.rest.smoothchange.communication.plan.dto.CommunicationPlanDto;
import com.rest.smoothchange.communication.plan.entity.CommunicationPlan;
import com.rest.smoothchange.communication.plan.mapper.CommunicationPlanMapper;
import com.rest.smoothchange.communication.plan.service.CommunicationPlanService;
import com.rest.smoothchange.impact.analysis.dto.ImpactAnalysisDto;
import com.rest.smoothchange.impact.analysis.entity.ImpactAnalysis;


@Service
@Transactional
public class CommunicationPlanServiceImpl extends AbstractService<CommunicationPlanDao, CommunicationPlanDto, CommunicationPlanMapper, CommunicationPlan>  implements CommunicationPlanService{
	public CommunicationPlanDto getCommunicationPlanByIdProjectId(CommunicationPlanDto communicationPlanDto) {
		return mapper.mapEntityToDto(dao.getCommunicationPlanByIdProjectId(communicationPlanDto));
	}
	
	public List<CommunicationPlanDto> getCommunicationPlanListByProjectId(long projectId){
		List<CommunicationPlanDto> communicationPlanDtoList = new ArrayList<>();
		try
		{
		List<CommunicationPlan> communicationPlanList = dao.getCommunicationPlanListByProjectId(projectId);
		for(CommunicationPlan communicationPlan : communicationPlanList ) {
			communicationPlanDtoList.add(mapper.mapEntityToDto(communicationPlan));
		}
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return communicationPlanDtoList;
	}
	
}
