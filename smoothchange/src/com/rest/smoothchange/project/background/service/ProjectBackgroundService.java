package com.rest.smoothchange.project.background.service;

import java.util.List;

import com.rest.framework.service.Service;
import com.rest.smoothchange.project.background.dto.ProjectBackgroundDto;


public interface ProjectBackgroundService extends Service<ProjectBackgroundDto>{
	
	public void DeleteAllTransactionProjectBackgroundById(long projectBackgroundId, List<String> listOfQuery);
}
