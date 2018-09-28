package com.rest.smoothchange.project.stakeholders.dao;

import java.util.List;

import com.rest.framework.dao.DAO;
import com.rest.smoothchange.project.stakeholders.dto.ProjectStakeholdersDto;
import com.rest.smoothchange.project.stakeholders.entity.ProjectStakeholders;


public interface ProjectStakeholdersDao extends DAO<ProjectStakeholders>{

	ProjectStakeholders getStakeHolderByIdProjectId(ProjectStakeholdersDto projectStakeholdersDto);

	List<ProjectStakeholders> getStakeHolderListByProjectId(long projectId);

	
	
	
}
