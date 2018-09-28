package com.rest.smoothchange.impact.analysis.dao;

import java.util.List;

import com.rest.framework.dao.DAO;
import com.rest.smoothchange.impact.analysis.dto.ImpactAnalysisDto;
import com.rest.smoothchange.impact.analysis.entity.ImpactAnalysis;

public interface ImpactAnalysisDao extends DAO<ImpactAnalysis> {

	public ImpactAnalysis getImpactAnalysisByIdProjectId(ImpactAnalysisDto impactAnalysisDto);
	public List<ImpactAnalysis> getImpactAnalysisListByProjectId(long projectId);

}
