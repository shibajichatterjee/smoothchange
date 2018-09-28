package com.rest.smoothchange.project.background.service.impl;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rest.framework.service.impl.AbstractService;
import com.rest.smoothchange.project.background.dao.ProjectBackgroundDao;
import com.rest.smoothchange.project.background.dto.ProjectBackgroundDto;
import com.rest.smoothchange.project.background.entity.ProjectBackground;
import com.rest.smoothchange.project.background.mapper.ProjectBackgroundMapper;
import com.rest.smoothchange.project.background.service.ProjectBackgroundService;


@Service
@Transactional
public class ProjectBackgroundServiceImpl extends AbstractService<ProjectBackgroundDao, ProjectBackgroundDto, ProjectBackgroundMapper, ProjectBackground>  implements ProjectBackgroundService{

	
}
