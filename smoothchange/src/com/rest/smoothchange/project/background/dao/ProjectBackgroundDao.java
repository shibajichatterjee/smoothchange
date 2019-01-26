package com.rest.smoothchange.project.background.dao;

import java.util.List;

import com.rest.framework.dao.DAO;
import com.rest.smoothchange.project.background.entity.ProjectBackground;


public interface ProjectBackgroundDao extends DAO<ProjectBackground>{

	public void DeleteAllTransactionProjectBackgroundById(long projectBackgroundId, List<String> listOfQuery);
	
	
}
