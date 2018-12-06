package com.rest.smoothchange.poti.blueprint.dao;

import java.util.List;

import com.rest.framework.dao.DAO;
import com.rest.smoothchange.poti.blueprint.entity.PotiBlueprint;
import com.rest.smoothchange.util.PotiComponentType;


public interface PotiBlueprintDao extends DAO<PotiBlueprint>{

	 List<PotiBlueprint> getPotiBluePrientComponentsByProjectIdAndComponentType(long projectId, PotiComponentType potiComponentType);
}
