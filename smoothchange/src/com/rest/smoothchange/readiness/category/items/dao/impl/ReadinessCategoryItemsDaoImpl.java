package com.rest.smoothchange.readiness.category.items.dao.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.persistence.Column;

import org.hibernate.Criteria;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.sql.JoinType;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.rest.framework.dao.impl.AbstractDAO;
import com.rest.smoothchange.readiness.assessment.data.item.entity.ReadinessAssessmentDataItem;
import com.rest.smoothchange.readiness.category.items.dao.ReadinessCategoryItemsDao;
import com.rest.smoothchange.readiness.category.items.dto.ReadinessCategoryItemsDto;
import com.rest.smoothchange.readiness.category.items.dto.ReadinessCategoryItemsRequestDto;
import com.rest.smoothchange.readiness.category.items.entity.ReadinessCategoryItems;

@Repository
@Transactional
public class ReadinessCategoryItemsDaoImpl extends AbstractDAO<ReadinessCategoryItems> implements ReadinessCategoryItemsDao{

	 
	public List<ReadinessCategoryItems> getReadinessCategoryItemsListByCategoryIdProjectId(long categoryId , long projectId){
		Criteria criteria = getSession().createCriteria(ReadinessCategoryItems.class);
		criteria.createAlias("changeReadinessCategories", "changeReadinessCategories", JoinType.LEFT_OUTER_JOIN);
		criteria.createAlias("changeReadinessCategories.projectBackground", "projectBackground", JoinType.LEFT_OUTER_JOIN);
		if(categoryId>0) {
		  criteria.add(Restrictions.eq("changeReadinessCategories.id",categoryId));
		} 
		if(projectId>0) {
		 criteria.add(Restrictions.eq("projectBackground.id", projectId));
		}
		return criteria.list();
	}
	
	public ReadinessCategoryItems getReadinessCategoryItemsByItemCodeAndCategoryId(long categoryId , String itemCode) {
		Criteria criteria = getSession().createCriteria(ReadinessCategoryItems.class);
		criteria.createAlias("changeReadinessCategories", "changeReadinessCategories", JoinType.LEFT_OUTER_JOIN);		
		criteria.add(Restrictions.eq("changeReadinessCategories.id",categoryId));
		criteria.add(Restrictions.eq("changeReadinessCategoryItemCode", itemCode));
		return (ReadinessCategoryItems)criteria.uniqueResult();
	}
	
	public ReadinessCategoryItemsRequestDto getRedinessCategoryItemDetailById(long categoryItemId) {
		List<ReadinessCategoryItemsRequestDto> readinessCategoryItemsRequestDtoList = new ArrayList<ReadinessCategoryItemsRequestDto>();
		Criteria criteria = getSession().createCriteria(ReadinessAssessmentDataItem.class);
		criteria.createAlias("readinessAssessmentData", "readinessAssessmentData", JoinType.LEFT_OUTER_JOIN);
		criteria.createAlias("readinessAssessmentData.readinessCategoryItems", "readinessCategoryItems", JoinType.LEFT_OUTER_JOIN);
		ProjectionList pl = Projections.projectionList();	
		pl.add(Projections.property("changeReadinessApprover"));
		pl.add(Projections.property("readinessCategoryItems.changeReadinessCategoryItemCode"));
		pl.add(Projections.property("readinessCategoryItems.changeReadinessCategoryItemDescription"));
		pl.add(Projections.property("changeReadinessDate1"));
		pl.add(Projections.property("changeReadinessDate2"));
		pl.add(Projections.property("changeReadinessResponsible"));
			
	    criteria.setProjection(pl);
		criteria.add(Restrictions.eq("readinessCategoryItems.id", categoryItemId));		
		Object[] result = (Object[]) criteria.uniqueResult();
		ReadinessCategoryItemsRequestDto readinessCategoryItemsRequestDto = null;
		if (result!=null) {
			readinessCategoryItemsRequestDto = new ReadinessCategoryItemsRequestDto();
			readinessCategoryItemsRequestDto.setChangeReadinessApprover(String.valueOf(result[0]));
			readinessCategoryItemsRequestDto.setChangeReadinessCategoryItemCode(String.valueOf(result[1]));
			readinessCategoryItemsRequestDto.setChangeReadinessCategoryItemDescription(String.valueOf(result[2]));
			readinessCategoryItemsRequestDto.setChangeReadinessDate1(String.valueOf(result[3]));
			readinessCategoryItemsRequestDto.setChangeReadinessDate2(String.valueOf(result[4]));
			readinessCategoryItemsRequestDto.setChangeReadinessResponsible(String.valueOf(result[5]));
		}	
		return readinessCategoryItemsRequestDto;
	}
	
	
	public List<ReadinessCategoryItemsRequestDto> getRedinessCategoryItemDetailByCategoryIdProjectId(long categoryId , long projectId ) {
		List<ReadinessCategoryItemsRequestDto> readinessCategoryItemsRequestDtoList = new ArrayList<ReadinessCategoryItemsRequestDto>();
		Criteria criteria = getSession().createCriteria(ReadinessAssessmentDataItem.class);
		criteria.createAlias("readinessAssessmentData", "readinessAssessmentData", JoinType.LEFT_OUTER_JOIN);
		criteria.createAlias("readinessAssessmentData.readinessCategoryItems", "readinessCategoryItems", JoinType.LEFT_OUTER_JOIN);
		criteria.createAlias("readinessCategoryItems.changeReadinessCategories", "changeReadinessCategories",
					JoinType.LEFT_OUTER_JOIN);		
        criteria.createAlias("changeReadinessCategories.projectBackground", "projectBackground",
					JoinType.LEFT_OUTER_JOIN);	
		if (projectId > 0) {
			criteria.add(Restrictions.eq("projectBackground.id", projectId));
		}
		if (categoryId > 0) {
			criteria.add(Restrictions.eq("changeReadinessCategories.id", categoryId));
		}
		ProjectionList pl = Projections.projectionList();	
		pl.add(Projections.property("changeReadinessApprover"));
		pl.add(Projections.property("readinessCategoryItems.changeReadinessCategoryItemCode"));
		pl.add(Projections.property("readinessCategoryItems.changeReadinessCategoryItemDescription"));
		pl.add(Projections.property("changeReadinessDate1"));
		pl.add(Projections.property("changeReadinessDate2"));
		pl.add(Projections.property("changeReadinessResponsible"));	
	    criteria.setProjection(pl);
	    
		List<Object[]> result =  (List<Object[]>) criteria.list();
		Iterator<Object[]> iterator = result.iterator();
		ReadinessCategoryItemsRequestDto readinessCategoryItemsRequestDto = null;
		while (iterator.hasNext()) {
			Object[] objects = (Object[]) iterator.next();
			readinessCategoryItemsRequestDto = new ReadinessCategoryItemsRequestDto();
			readinessCategoryItemsRequestDto.setChangeReadinessApprover(String.valueOf(objects[0]));
			readinessCategoryItemsRequestDto.setChangeReadinessCategoryItemCode(String.valueOf(objects[1]));
			readinessCategoryItemsRequestDto.setChangeReadinessCategoryItemDescription(String.valueOf(objects[2]));
			readinessCategoryItemsRequestDto.setChangeReadinessDate1(String.valueOf(objects[3]));
			readinessCategoryItemsRequestDto.setChangeReadinessDate2(String.valueOf(objects[4]));
			readinessCategoryItemsRequestDto.setChangeReadinessResponsible(String.valueOf(objects[5]));
			readinessCategoryItemsRequestDtoList.add(readinessCategoryItemsRequestDto);
		} 	
		return readinessCategoryItemsRequestDtoList;
	}
	

}
