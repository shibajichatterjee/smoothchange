/**
 * 
 */
package com.rest.smoothchange.poti.blueprint.mapper;

import org.springframework.stereotype.Component;

import com.rest.framework.mapper.AbstractMapper;
import com.rest.smoothchange.poti.blueprint.dto.PotiBlueprintDto;
import com.rest.smoothchange.poti.blueprint.entity.PotiBlueprint;
import com.rest.smoothchange.project.background.dto.ProjectBackgroundDto;
import com.rest.smoothchange.project.background.entity.ProjectBackground;
import com.rest.smoothchange.util.PotiComponentType;
import com.rest.smoothchange.util.TypeOfChange;

@Component
public class PotiBlueprintMapper extends AbstractMapper<PotiBlueprintDto , PotiBlueprint>{

	@Override
	public PotiBlueprint mapDtoToEntity(PotiBlueprintDto dto) {
		PotiBlueprint potiBlueprint = null;
		ProjectBackground projectBackground = null;
		if (dto != null) {
			potiBlueprint = new PotiBlueprint();
			potiBlueprint.setId(dto.getId());
			potiBlueprint.setAsIsState(dto.getAsIsState());
			potiBlueprint.setAsIsToInterimEndDate(dto.getAsIsToInterimStartDate());
			potiBlueprint.setAsIsToInterimStartDate(dto.getAsIsToInterimEndDate());
			potiBlueprint.setHowToAchieve(dto.getHowToAchieve());
			potiBlueprint.setId(dto.getId());
			potiBlueprint.setInterimState(dto.getInterimState());
			potiBlueprint.setInterimToTobeEndDate(dto.getInterimToToBeEndDate());
			potiBlueprint.setInterimToTobeStartDate(dto.getInterimToToBeStartDate());
			potiBlueprint.setToBeState(dto.getToBeState());
			if (dto.getPotiComponent() != null) {
				potiBlueprint.setPotiComponent(PotiComponentType.getValue(dto.getPotiComponent()));
			}
			if (dto.getProjectBackground() != null) {
				projectBackground = new ProjectBackground();
				projectBackground.setId(dto.getProjectBackground().getId());
				projectBackground.setOtherTypeOfChange(dto.getProjectBackground().getOtherTypeOfChange());
				projectBackground.setOwnerOfChange(dto.getProjectBackground().getOwnerOfChange());
				projectBackground.setProjectDescription(dto.getProjectBackground().getProjectDescription());
				projectBackground.setProjectName(dto.getProjectBackground().getProjectName());
				if (dto.getProjectBackground().getTypeOfChange() != null) {
					TypeOfChange type = TypeOfChange.getValue(dto.getProjectBackground().getTypeOfChange());
					projectBackground.setTypeOfChange(type);
				}
				projectBackground.setContactPerson(dto.getProjectBackground().getContactPerson());
				potiBlueprint.setProjectBackground(projectBackground);
			}
		}
		return potiBlueprint;
	}

	@Override
	public PotiBlueprintDto mapEntityToDto(PotiBlueprint bo) {
		PotiBlueprintDto potiBlueprint = null;
		ProjectBackgroundDto projectBackground = null;
		if (bo != null) {
			potiBlueprint = new PotiBlueprintDto();
			potiBlueprint.setId(bo.getId());
			potiBlueprint.setAsIsState(bo.getAsIsState());
			potiBlueprint.setAsIsToInterimEndDate(bo.getAsIsToInterimStartDate());
			potiBlueprint.setAsIsToInterimStartDate(bo.getAsIsToInterimEndDate());
			potiBlueprint.setHowToAchieve(bo.getHowToAchieve());
			potiBlueprint.setId(bo.getId());
			potiBlueprint.setInterimState(bo.getInterimState());
			potiBlueprint.setInterimToToBeEndDate(bo.getInterimToTobeEndDate());
			potiBlueprint.setInterimToToBeStartDate(bo.getInterimToTobeStartDate());
			potiBlueprint.setToBeState(bo.getToBeState());
			if (bo.getPotiComponent() != null) {
				potiBlueprint.setPotiComponent(bo.getPotiComponent().getNumValue());
			}
			if (bo.getProjectBackground() != null) {
				projectBackground = new ProjectBackgroundDto();
				projectBackground.setId(bo.getProjectBackground().getId());
				projectBackground.setOtherTypeOfChange(bo.getProjectBackground().getOtherTypeOfChange());
				projectBackground.setOwnerOfChange(bo.getProjectBackground().getOwnerOfChange());
				projectBackground.setProjectDescription(bo.getProjectBackground().getProjectDescription());
				projectBackground.setProjectName(bo.getProjectBackground().getProjectName());
				if (bo.getProjectBackground().getTypeOfChange() != null) {
					projectBackground.setTypeOfChange(bo.getProjectBackground().getTypeOfChange().getMessage());
				}
				projectBackground.setContactPerson(bo.getProjectBackground().getContactPerson());
				potiBlueprint.setProjectBackground(projectBackground);
			}
		}
		return potiBlueprint;
	}	
}
