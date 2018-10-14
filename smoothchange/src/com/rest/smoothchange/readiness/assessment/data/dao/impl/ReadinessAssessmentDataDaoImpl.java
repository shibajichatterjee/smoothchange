package com.rest.smoothchange.readiness.assessment.data.dao.impl;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.hibernate.sql.JoinType;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.rest.framework.dao.impl.AbstractDAO;
import com.rest.smoothchange.readiness.assessment.data.dao.ReadinessAssessmentDataDao;
import com.rest.smoothchange.readiness.assessment.data.entity.ReadinessAssessmentData;

@Repository
@Transactional
public class ReadinessAssessmentDataDaoImpl extends AbstractDAO<ReadinessAssessmentData> implements ReadinessAssessmentDataDao{

	public  ReadinessAssessmentData getReadinessAssessmentDataByItemId(long readinessCategoryItemsItem) {
		Criteria criteria = getSession().createCriteria(ReadinessAssessmentData.class);
		criteria.createAlias("readinessCategoryItems", "readinessCategoryItems" , JoinType.LEFT_OUTER_JOIN);
		criteria.add(Restrictions.eq("readinessCategoryItems.id", readinessCategoryItemsItem));
		return  (ReadinessAssessmentData)criteria.uniqueResult();
	}
}
