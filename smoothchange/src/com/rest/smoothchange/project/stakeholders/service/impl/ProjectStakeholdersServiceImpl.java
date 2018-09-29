package com.rest.smoothchange.project.stakeholders.service.impl;


import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rest.framework.service.impl.AbstractService;
import com.rest.smoothchange.project.stakeholders.dao.ProjectStakeholdersDao;
import com.rest.smoothchange.project.stakeholders.dto.ProjectStakeholdersDto;
import com.rest.smoothchange.project.stakeholders.entity.ProjectStakeholders;
import com.rest.smoothchange.project.stakeholders.mapper.ProjectStakeholdersMapper;
import com.rest.smoothchange.project.stakeholders.service.ProjectStakeholdersService;


@Service
@Transactional
public class ProjectStakeholdersServiceImpl extends AbstractService<ProjectStakeholdersDao, ProjectStakeholdersDto, ProjectStakeholdersMapper, ProjectStakeholders>  implements ProjectStakeholdersService{

	public ProjectStakeholdersDto getStakeHolderByIdProjectId(ProjectStakeholdersDto ProjectStakeholdersDto) {
		return mapper.mapEntityToDto(dao.getStakeHolderByIdProjectId(ProjectStakeholdersDto));
	}
	
	public List<ProjectStakeholdersDto> getStakeHolderListByProjectId(long projectId){
		   List<ProjectStakeholdersDto> projectStakeholderDtoList = new ArrayList<>();
		   List<ProjectStakeholders> projectStakeholdersList = dao.getStakeHolderListByProjectId(projectId);
		   for(ProjectStakeholders projectStakeholders : projectStakeholdersList) {
			   projectStakeholderDtoList.add(mapper.mapEntityToDto(projectStakeholders));
		   }
		   return projectStakeholderDtoList;
		}
}
