package com.rest.smoothchange.impact.analysis.service;

import java.util.List;

import com.rest.framework.service.Service;
import com.rest.smoothchange.impact.analysis.dto.ImpactAnalysisDto;


public interface ImpactAnalysisService extends Service<ImpactAnalysisDto>{
	
	ImpactAnalysisDto getImpactAnalysisByIdProjectId(ImpactAnalysisDto impactAnalysisDto);
	
	List<ImpactAnalysisDto> getImpactAnalysisListByProjectId(long projectId);

}
