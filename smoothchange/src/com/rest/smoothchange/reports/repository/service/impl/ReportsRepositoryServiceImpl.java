package com.rest.smoothchange.reports.repository.service.impl;


import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rest.framework.service.impl.AbstractService;
import com.rest.smoothchange.reports.repository.dao.ReportsRepositoryDao;
import com.rest.smoothchange.reports.repository.dto.ReportsRepositoryDto;
import com.rest.smoothchange.reports.repository.entity.ReportsRepository;
import com.rest.smoothchange.reports.repository.mapper.ReportsRepositoryMapper;
import com.rest.smoothchange.reports.repository.service.ReportsRepositoryService;
import com.rest.smoothchange.util.ReportType;


@Service
@Transactional
public class ReportsRepositoryServiceImpl extends AbstractService<ReportsRepositoryDao, ReportsRepositoryDto, ReportsRepositoryMapper, ReportsRepository>  implements ReportsRepositoryService{

	public List<ReportsRepositoryDto>  getReportReposetoryDetailByTypeAndProjectId(ReportType reportType , long projectId){
		List<ReportsRepositoryDto> reportsRepositoryDtoList = new ArrayList<>();
		List<ReportsRepository> reportsRepositorieList = dao.getReportReposetoryDetailByTypeAndProjectId(reportType, projectId);
		for(ReportsRepository reportsRepository : reportsRepositorieList) {
			reportsRepositoryDtoList.add(mapper.mapEntityToDto(reportsRepository));
		}
		return reportsRepositoryDtoList;
	}

	
}
