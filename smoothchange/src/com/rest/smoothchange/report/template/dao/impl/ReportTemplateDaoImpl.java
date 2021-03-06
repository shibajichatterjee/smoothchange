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

	public List<ReportTemplate>  getReportTemplateDetailByTypeAndProjectId(ReportType reportType){
        Criteria criteria = getSession().createCriteria(ReportTemplate.class);
       
        if(reportType!=null) {
        	criteria.add(Restrictions.eq("reportType", reportType));
        }
       
        return criteria.list();
	}
	
}
