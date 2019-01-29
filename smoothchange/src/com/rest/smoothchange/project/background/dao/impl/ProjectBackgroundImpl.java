package com.rest.smoothchange.project.background.dao.impl;

import java.util.List;

import org.hibernate.SQLQuery;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.rest.framework.dao.impl.AbstractDAO;
import com.rest.smoothchange.project.background.dao.ProjectBackgroundDao;
import com.rest.smoothchange.project.background.entity.ProjectBackground;

@Repository
@Transactional
public class ProjectBackgroundImpl extends AbstractDAO<ProjectBackground> implements ProjectBackgroundDao{

	public void DeleteAllTransactionProjectBackgroundById(long projectBackGroundId, List<String> listOfQuery) {

		listOfQuery.stream().forEach(query->{
				SQLQuery sqlQuery = getSession().createSQLQuery(query);
				sqlQuery.setLong(0, projectBackGroundId);
				sqlQuery.executeUpdate();
		});	
	}
	
//	private SQLQuery getSqlQuery(String sqlQuery) {
//		return getSession().createSQLQuery("delete from "+sqlQuery+" where project_id = ?");
//	}
	
}
