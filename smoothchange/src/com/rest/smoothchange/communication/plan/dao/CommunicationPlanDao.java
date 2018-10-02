package com.rest.smoothchange.communication.plan.dao;

import java.util.List;

import com.rest.framework.dao.DAO;
import com.rest.smoothchange.communication.plan.dto.CommunicationPlanDto;
import com.rest.smoothchange.communication.plan.entity.CommunicationPlan;


public interface CommunicationPlanDao extends DAO<CommunicationPlan>{

	public CommunicationPlan getCommunicationPlanByIdProjectId(CommunicationPlanDto communicationPlanDto) ;

	public List<CommunicationPlan> getCommunicationPlanListByProjectId(long projectId);

	
}
