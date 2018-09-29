package com.rest.smoothchange.util;

import com.rest.framework.exception.NoRecordsFoundException;
import com.rest.smoothchange.project.background.dto.ProjectBackgroundDto;
import com.rest.smoothchange.project.background.service.ProjectBackgroundService;
import com.rest.smoothchange.project.background.service.impl.ProjectBackgroundServiceImpl;

public class CommonUtil {
	public static ProjectBackgroundDto getProjectBackGround(String id) throws NoRecordsFoundException {
		ProjectBackgroundService projectService=new ProjectBackgroundServiceImpl();
		ProjectBackgroundDto dto = 
				projectService.getById(Long.parseLong(id));
		return dto;
	}

}
