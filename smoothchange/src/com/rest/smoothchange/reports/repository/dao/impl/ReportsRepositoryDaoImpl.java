package com.rest.smoothchange.reports.repository.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.hibernate.sql.JoinType;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.rest.framework.dao.impl.AbstractDAO;
import com.rest.smoothchange.reports.repository.dao.ReportsRepositoryDao;
import com.rest.smoothchange.reports.repository.entity.ReportsRepository;
import com.rest.smoothchange.util.ReportType;

@Repository
@Transactional
public class ReportsRepositoryDaoImpl extends AbstractDAO<ReportsRepository> implements ReportsRepositoryDao{

	public List<ReportsRepository>  getReportReposetoryDetailByTypeAndProjectId(ReportType reportType , long projectId){
        Criteria criteria = getSession().createCriteria(ReportsRepository.class);
        criteria.createAlias("projectBackground", "projectBackground", JoinType.LEFT_OUTER_JOIN);
        criteria.add(Restrictions.eq("projectBackground.id", projectId));
        criteria.add(Restrictions.eq("reportType", reportType));
        return criteria.list();
	}
	
}
