package com.rest.smoothchange.poti.blueprint.impl;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rest.framework.service.impl.AbstractService;
import com.rest.smoothchange.poti.blueprint.dao.PotiBlueprintDao;
import com.rest.smoothchange.poti.blueprint.dto.PotiBlueprintDto;
import com.rest.smoothchange.poti.blueprint.entity.PotiBlueprint;
import com.rest.smoothchange.poti.blueprint.mapper.PotiBlueprintMapper;
import com.rest.smoothchange.poti.blueprint.service.PotiBlueprintService;


@Service
@Transactional
public class PotiBlueprintServiceImpl extends AbstractService<PotiBlueprintDao, PotiBlueprintDto, PotiBlueprintMapper, PotiBlueprint>  implements PotiBlueprintService{

	
}
