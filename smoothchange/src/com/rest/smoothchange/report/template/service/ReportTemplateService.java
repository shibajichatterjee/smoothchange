package com.rest.smoothchange.report.template.service;

import java.util.List;

import com.rest.framework.service.Service;
import com.rest.smoothchange.report.template.dto.ReportTemplateDto;
import com.rest.smoothchange.util.ReportType;


public interface ReportTemplateService extends Service<ReportTemplateDto>{
	
	public List<ReportTemplateDto>  getReportTemplateDetailByTypeAndProjectId(ReportType reportType2);

}
