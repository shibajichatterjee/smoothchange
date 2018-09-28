package com.rest.smoothchange.impact.analysis.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.hibernate.sql.JoinType;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.rest.framework.dao.impl.AbstractDAO;
import com.rest.smoothchange.impact.analysis.dao.ImpactAnalysisDao;
import com.rest.smoothchange.impact.analysis.dto.ImpactAnalysisDto;
import com.rest.smoothchange.impact.analysis.entity.ImpactAnalysis;

@Repository
@Transactional
public class ImpactAnalysisDaoImpl extends AbstractDAO<ImpactAnalysis> implements ImpactAnalysisDao{

	public ImpactAnalysis getImpactAnalysisByIdProjectId(ImpactAnalysisDto impactAnalysisDto) {
		Criteria criteria = getSession().createCriteria(ImpactAnalysis.class);
		criteria.createAlias("projectBackground", "projectBackground", JoinType.LEFT_OUTER_JOIN);
		criteria.add(Restrictions.and(Restrictions.eq("projectBackground.id", impactAnalysisDto.getProjectBackground().getId()),Restrictions.eq("id", impactAnalysisDto.getId())));
		return (ImpactAnalysis)criteria.uniqueResult();
	}
	
	public List<ImpactAnalysis> getImpactAnalysisListByProjectId(long projectId){
		Criteria criteria = getSession().createCriteria(ImpactAnalysis.class);
		criteria.createAlias("projectBackground", "projectBackground", JoinType.LEFT_OUTER_JOIN);
		criteria.add(Restrictions.eq("projectBackground.id", projectId));
		return criteria.list();
	}
}
