package com.rest.smoothchange.impact.analysis.service.impl;


import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rest.framework.service.impl.AbstractService;
import com.rest.smoothchange.impact.analysis.dao.ImpactAnalysisDao;
import com.rest.smoothchange.impact.analysis.dto.ImpactAnalysisDto;
import com.rest.smoothchange.impact.analysis.entity.ImpactAnalysis;
import com.rest.smoothchange.impact.analysis.mapper.ImpactAnalysisMapper;
import com.rest.smoothchange.impact.analysis.service.ImpactAnalysisService;


@Service
@Transactional
public class ImpactAnalysisServiceImpl extends AbstractService<ImpactAnalysisDao, ImpactAnalysisDto, ImpactAnalysisMapper, ImpactAnalysis>  implements ImpactAnalysisService{

	public ImpactAnalysisDto getImpactAnalysisByIdProjectId(ImpactAnalysisDto impactAnalysisDto) {
		return mapper.mapEntityToDto(dao.getImpactAnalysisByIdProjectId(impactAnalysisDto));
	}
	
	public List<ImpactAnalysisDto> getImpactAnalysisListByProjectId(long projectId){
		List<ImpactAnalysisDto> impactAnalysisDtoList = new ArrayList<>();
		try
		{
		List<ImpactAnalysis> impactAnalysisList = dao.getImpactAnalysisListByProjectId(projectId);
		for(ImpactAnalysis impactAnalysis : impactAnalysisList ) {
			impactAnalysisDtoList.add(mapper.mapEntityToDto(impactAnalysis));
		}
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return impactAnalysisDtoList;
	}
}
