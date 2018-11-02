package com.rest.smoothchange.report.template.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.hibernate.sql.JoinType;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.rest.framework.dao.impl.AbstractDAO;
import com.rest.smoothchange.report.template.dao.ReportTemplateDao;
import com.rest.smoothchange.report.template.entity.ReportTemplate;
import com.rest.smoothchange.reports.repository.entity.ReportsRepository;
import com.rest.smoothchange.util.ReportType;

@Repository
@Transactional
public class ReportTemplateDaoImpl extends AbstractDAO<ReportTemplate> implements ReportTemplateDao{

	public List<ReportTemplate>  getReportTemplateDetailByTypeAndProjectId(ReportType reportType , long projectId){
        Criteria criteria = getSession().createCriteria(ReportsRepository.class);
        
        if(projectId>0) {
        	criteria.createAlias("projectBackground", "projectBackground", JoinType.LEFT_OUTER_JOIN);
        	criteria.add(Restrictions.eq("projectBackground.id", projectId));
        }
        if(reportType!=null) {
        	criteria.add(Restrictions.eq("reportType", reportType));
        }
       
        return criteria.list();
	}
	
}
