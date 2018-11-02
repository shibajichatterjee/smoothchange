package com.rest.smoothchange.reports.repository.service;

import java.util.List;

import com.rest.framework.service.Service;
import com.rest.smoothchange.reports.repository.dto.ReportsRepositoryDto;
import com.rest.smoothchange.util.ReportType;


public interface ReportsRepositoryService extends Service<ReportsRepositoryDto>{
	
	public List<ReportsRepositoryDto>  getReportReposetoryDetailByTypeAndProjectId(ReportType reportType2, long projectId);

}
