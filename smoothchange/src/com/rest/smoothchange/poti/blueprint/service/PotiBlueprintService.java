package com.rest.smoothchange.poti.blueprint.service;

import java.util.List;

import com.rest.framework.service.Service;
import com.rest.smoothchange.poti.blueprint.dto.PotiBlueprintDto;
import com.rest.smoothchange.util.PotiComponentType;


public interface PotiBlueprintService extends Service<PotiBlueprintDto>{
	
 List<PotiBlueprintDto> getPotiBluePrientComponentsByProjectIdAndComponentType(long projectId, PotiComponentType potiComponentType);
	

}
