package com.rest.smoothchange.poti.blueprint.dao.impl;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.rest.framework.dao.impl.AbstractDAO;
import com.rest.smoothchange.poti.blueprint.dao.PotiBlueprintDao;
import com.rest.smoothchange.poti.blueprint.entity.PotiBlueprint;

@Repository
@Transactional
public class PotiBlueprintDaoImpl extends AbstractDAO<PotiBlueprint> implements PotiBlueprintDao{

	 
}
