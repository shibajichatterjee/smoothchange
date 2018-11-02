package com.rest.smoothchange.report.template.service.impl;


import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rest.framework.service.impl.AbstractService;
import com.rest.smoothchange.report.template.dao.ReportTemplateDao;
import com.rest.smoothchange.report.template.dto.ReportTemplateDto;
import com.rest.smoothchange.report.template.entity.ReportTemplate;
import com.rest.smoothchange.report.template.mapper.ReportTemplateMapper;
import com.rest.smoothchange.report.template.service.ReportTemplateService;
import com.rest.smoothchange.util.ReportType;


@Service
@Transactional
public class ReportTemplateServiceImpl extends AbstractService<ReportTemplateDao, ReportTemplateDto, ReportTemplateMapper, ReportTemplate>  implements ReportTemplateService{

	public List<ReportTemplateDto>  getReportTemplateDetailByTypeAndProjectId(ReportType reportType , long projectId){
		List<ReportTemplateDto> reportTemplateDtoList = new ArrayList<>();
		List<ReportTemplate> reportTemplateList = dao.getReportTemplateDetailByTypeAndProjectId(reportType, projectId);
		for(ReportTemplate reportTemplate : reportTemplateList) {
			reportTemplateDtoList.add(mapper.mapEntityToDto(reportTemplate));
		}
		return reportTemplateDtoList;
	}

	
}
