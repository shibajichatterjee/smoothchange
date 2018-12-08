package com.rest.smoothchange.report.template.dao;

import java.util.List;

import com.rest.framework.dao.DAO;
import com.rest.smoothchange.report.template.entity.ReportTemplate;
import com.rest.smoothchange.util.ReportType;


public interface ReportTemplateDao extends DAO<ReportTemplate>{

	public List<ReportTemplate>  getReportTemplateDetailByTypeAndProjectId(ReportType reportType);
}
