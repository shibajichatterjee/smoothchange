package com.rest.smoothchange.project.background.dao.impl;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.rest.framework.dao.impl.AbstractDAO;
import com.rest.smoothchange.project.background.dao.ProjectBackgroundDao;
import com.rest.smoothchange.project.background.entity.ProjectBackground;

@Repository
@Transactional
public class ProjectBackgroundImpl extends AbstractDAO<ProjectBackground> implements ProjectBackgroundDao{

	 
}
