package com.rest.smoothchange.communication.plan.service;

import java.util.List;

import com.rest.framework.service.Service;
import com.rest.smoothchange.communication.plan.dto.CommunicationPlanDto;


public interface CommunicationPlanService extends Service<CommunicationPlanDto>{
	
	public List<CommunicationPlanDto> getCommunicationPlanListByProjectId(long projectId);
	public CommunicationPlanDto getCommunicationPlanByIdProjectId(CommunicationPlanDto communicationPlanDto) ;


}
