package com.rest.smoothchange.project.stakeholders.service;

import java.util.List;

import com.rest.framework.service.Service;
import com.rest.smoothchange.project.stakeholders.dto.ProjectStakeholdersDto;


public interface ProjectStakeholdersService extends Service<ProjectStakeholdersDto>{
	
	public ProjectStakeholdersDto getStakeHolderByIdProjectId(ProjectStakeholdersDto ProjectStakeholdersDto);
	public List<ProjectStakeholdersDto> getStakeHolderListByProjectId(long projectId);

}
