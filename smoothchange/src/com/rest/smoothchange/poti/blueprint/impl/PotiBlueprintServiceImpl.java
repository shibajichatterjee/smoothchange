package com.rest.smoothchange.poti.blueprint.impl;


import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rest.framework.service.impl.AbstractService;
import com.rest.smoothchange.poti.blueprint.dao.PotiBlueprintDao;
import com.rest.smoothchange.poti.blueprint.dto.PotiBlueprintDto;
import com.rest.smoothchange.poti.blueprint.entity.PotiBlueprint;
import com.rest.smoothchange.poti.blueprint.mapper.PotiBlueprintMapper;
import com.rest.smoothchange.poti.blueprint.service.PotiBlueprintService;
import com.rest.smoothchange.util.PotiComponentType;


@Service
@Transactional
public class PotiBlueprintServiceImpl extends AbstractService<PotiBlueprintDao, PotiBlueprintDto, PotiBlueprintMapper, PotiBlueprint>  implements PotiBlueprintService{

	public List<PotiBlueprintDto> getPotiBluePrientComponentsByProjectIdAndComponentType(long projectId, PotiComponentType potiComponentType){
		List<PotiBlueprintDto> potiBlueprintDtoList = new ArrayList<>();
		List<PotiBlueprint> potiBlueprintList = dao.getPotiBluePrientComponentsByProjectIdAndComponentType(projectId, potiComponentType);
		 for(PotiBlueprint potiBlueprint : potiBlueprintList ) {
			 potiBlueprintDtoList.add(mapper.mapEntityToDto(potiBlueprint));
		 }
		 return potiBlueprintDtoList;
	 }
}
