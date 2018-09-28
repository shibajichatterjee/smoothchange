/**
 * 
 */
package com.rest.smoothchange.project.background.mapper;

import org.springframework.stereotype.Component;

import com.rest.framework.exception.NoEnumRecordsFoundException;
import com.rest.framework.mapper.AbstractMapper;
import com.rest.smoothchange.project.background.dto.ProjectBackgroundDto;
import com.rest.smoothchange.project.background.entity.ProjectBackground;
import com.rest.smoothchange.util.TypeOfChange;

@Component
public class ProjectBackgroundMapper extends AbstractMapper<ProjectBackgroundDto, ProjectBackground> {

	@Override
	public ProjectBackground mapDtoToEntity(ProjectBackgroundDto dto){
		ProjectBackground projectBackground = null;
		if (dto != null) {
			projectBackground = new ProjectBackground();

			projectBackground.setId(dto.getId());

			projectBackground.setOtherTypeOfChange(dto.getOtherTypeOfChange());
			projectBackground.setOwnerOfChange(dto.getOwnerOfChange());
			projectBackground.setProjectDescription(dto.getProjectDescription());
			projectBackground.setProjectName(dto.getProjectName());
			TypeOfChange type=TypeOfChange.getValue(dto.getTypeOfChange());
			projectBackground.setTypeOfChange(type);
			projectBackground.setContactPerson(dto.getContactPerson());
			
		}
		return projectBackground;
	}

	@Override
	public ProjectBackgroundDto mapEntityToDto(ProjectBackground bo) {
		ProjectBackgroundDto projectBackgroundDto = null;
		if (bo != null) {
			projectBackgroundDto = new ProjectBackgroundDto();

			projectBackgroundDto.setId(bo.getId());

			projectBackgroundDto.setOtherTypeOfChange(bo.getOtherTypeOfChange());
			projectBackgroundDto.setOwnerOfChange(bo.getOwnerOfChange());
			projectBackgroundDto.setProjectDescription(bo.getProjectDescription());
			projectBackgroundDto.setProjectName(bo.getProjectName());
			projectBackgroundDto.setTypeOfChange(bo.getTypeOfChange().getMessage());
			projectBackgroundDto.setContactPerson(bo.getContactPerson());
		}
		return projectBackgroundDto;
	}

}
