package com.rest.smoothchange.reports.repository.dao;

import java.util.List;

import com.rest.framework.dao.DAO;
import com.rest.smoothchange.reports.repository.entity.ReportsRepository;
import com.rest.smoothchange.util.ReportType;


public interface ReportsRepositoryDao extends DAO<ReportsRepository>{

	public List<ReportsRepository>  getReportReposetoryDetailByTypeAndProjectId(ReportType reportType , long projectId);
}
