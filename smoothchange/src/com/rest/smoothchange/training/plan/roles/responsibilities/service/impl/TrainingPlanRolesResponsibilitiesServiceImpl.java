package com.rest.smoothchange.training.plan.roles.responsibilities.service.impl;


import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rest.framework.service.impl.AbstractService;
import com.rest.smoothchange.training.plan.roles.responsibilities.dao.TrainingPlanRolesResponsibilitiesDao;
import com.rest.smoothchange.training.plan.roles.responsibilities.dto.TrainingPlanRolesResponsibilitiesDto;
import com.rest.smoothchange.training.plan.roles.responsibilities.entity.TrainingPlanRolesResponsibilities;
import com.rest.smoothchange.training.plan.roles.responsibilities.mapper.TrainingPlanRolesResponsibilitiesMapper;
import com.rest.smoothchange.training.plan.roles.responsibilities.service.TrainingPlanRolesResponsibilitiesService;


@Service
@Transactional
public class TrainingPlanRolesResponsibilitiesServiceImpl extends AbstractService<TrainingPlanRolesResponsibilitiesDao, TrainingPlanRolesResponsibilitiesDto, TrainingPlanRolesResponsibilitiesMapper, TrainingPlanRolesResponsibilities>  implements TrainingPlanRolesResponsibilitiesService{
	
	public List<TrainingPlanRolesResponsibilitiesDto>  getTrainingPlanRolesResponsibilitiesListByProjectId(long projectId){
		 List<TrainingPlanRolesResponsibilitiesDto> trainingPlanRolesResponsibilitiesDtoList = new ArrayList<>();
		 List<TrainingPlanRolesResponsibilities> trainingPlanRolesResponsibilitieList = dao.getTrainingPlanRolesResponsibilitiesListByProjectId(projectId);
		 for(TrainingPlanRolesResponsibilities trainingPlanRolesResponsibilities : trainingPlanRolesResponsibilitieList) {
			 trainingPlanRolesResponsibilitiesDtoList.add(mapper.mapEntityToDto(trainingPlanRolesResponsibilities));
		 }
		 return trainingPlanRolesResponsibilitiesDtoList;
	 }

}
