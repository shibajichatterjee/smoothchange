package com.rest.smoothchange.project.stakeholders.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.hibernate.sql.JoinType;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.rest.framework.dao.impl.AbstractDAO;
import com.rest.smoothchange.business.benefit.mapping.entity.BusinessBenefitMapping;
import com.rest.smoothchange.project.stakeholders.dao.ProjectStakeholdersDao;
import com.rest.smoothchange.project.stakeholders.dto.ProjectStakeholdersDto;
import com.rest.smoothchange.project.stakeholders.entity.ProjectStakeholders;

@Repository
@Transactional
public class ProjectStakeholdersDaoImpl extends AbstractDAO<ProjectStakeholders> implements ProjectStakeholdersDao{

	public ProjectStakeholders getStakeHolderByIdProjectId(ProjectStakeholdersDto projectStakeholdersDto) {
		Criteria criteria = getSession().createCriteria(ProjectStakeholders.class);
		criteria.createAlias("projectBackground", "projectBackground", JoinType.LEFT_OUTER_JOIN);
		criteria.add(Restrictions.and(Restrictions.eq("projectBackground.id", projectStakeholdersDto.getProjectBackground().getId()),Restrictions.eq("id", projectStakeholdersDto.getId())));
		return (ProjectStakeholders)criteria.uniqueResult();
	}
	public List<ProjectStakeholders> getStakeHolderListByProjectId(long projectId){
		Criteria criteria = getSession().createCriteria(ProjectStakeholders.class);
		criteria.createAlias("projectBackground", "projectBackground", JoinType.LEFT_OUTER_JOIN);
		criteria.add(Restrictions.eq("projectBackground.id", projectId));
		return criteria.list();
	}
}
