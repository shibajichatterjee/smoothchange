package com.rest.smoothchange.readiness.category.items.dao.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.Criteria;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.sql.JoinType;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.rest.framework.dao.impl.AbstractDAO;
import com.rest.smoothchange.readiness.assessment.data.item.dto.ReadinessAssessmentDataItemRequestDto;
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
	    
		ReadinessCategoryItemsRequestDto readinessCategoryItemsRequestDto = null;
		List<ReadinessAssessmentDataItemRequestDto> readinessAssessmentDataItemRequestDtoList = new ArrayList<>();
		
		Criteria criteria = getSession().createCriteria(ReadinessCategoryItems.class);
		criteria.add(Restrictions.eq("id", categoryItemId));
		ReadinessCategoryItems readinessCategoryItems = (ReadinessCategoryItems)criteria.uniqueResult();
		if(readinessCategoryItems!=null && readinessCategoryItems.getId()!=null) {
			readinessCategoryItemsRequestDto = new ReadinessCategoryItemsRequestDto();
			readinessCategoryItemsRequestDto.setChangeReadinessCategoryItemId(readinessCategoryItems.getId());
			readinessCategoryItemsRequestDto.setChangeReadinessCategoryItemCode(readinessCategoryItems.getChangeReadinessCategoryItemCode());
			readinessCategoryItemsRequestDto.setChangeReadinessCategoryItemDescription(readinessCategoryItems.getChangeReadinessCategoryItemDescription());	
			Criteria criteria2 = getSession().createCriteria(ReadinessAssessmentDataItem.class);
			criteria2.createAlias("readinessAssessmentData", "readinessAssessmentData", JoinType.LEFT_OUTER_JOIN);
			criteria2.createAlias("readinessAssessmentData.readinessCategoryItems", "readinessCategoryItems", JoinType.LEFT_OUTER_JOIN);
			ProjectionList pl = Projections.projectionList();	
			pl.add(Projections.property("changeReadinessApprover"));
			pl.add(Projections.property("changeReadinessDate1"));
			pl.add(Projections.property("changeReadinessDate2"));
			pl.add(Projections.property("changeReadinessResponsible"));
			pl.add(Projections.property("id"));
			pl.add(Projections.property("readinessAssessmentData.id"));	
				
			criteria2.setProjection(pl);
			criteria2.add(Restrictions.eq("readinessCategoryItems.id", readinessCategoryItems.getId()));		
			List<Object[]> result2 =  (List<Object[]>) criteria2.list();
			ReadinessAssessmentDataItemRequestDto readinessAssessmentDataItemRequestDto = null;
			if (result2!=null && result2.size()>0) {
				Iterator<Object[]> iterator = result2.iterator();
				while (iterator.hasNext()) {
					Object[] objects = (Object[]) iterator.next();
					readinessAssessmentDataItemRequestDto = new ReadinessAssessmentDataItemRequestDto();
					readinessAssessmentDataItemRequestDto.setChangeReadinessApprover(String.valueOf(objects[0]));
					readinessAssessmentDataItemRequestDto.setChangeReadinessDate1(String.valueOf(objects[1]));
					readinessAssessmentDataItemRequestDto.setChangeReadinessDate2(String.valueOf(objects[2]));
					readinessAssessmentDataItemRequestDto.setChangeReadinessResponsible(String.valueOf(objects[3]));
					readinessAssessmentDataItemRequestDto.setReadinessAssessmentDataId((Long)objects[4]);
					readinessAssessmentDataItemRequestDto.setReadinessAssessmentDataItemId((Long)objects[5]);
					readinessAssessmentDataItemRequestDtoList.add(readinessAssessmentDataItemRequestDto);
				}
			}	
			readinessCategoryItemsRequestDto.setReadinessAssessmentDataItemRequestDtoList(readinessAssessmentDataItemRequestDtoList);
		}
		return readinessCategoryItemsRequestDto;
		
	}
	
	
	public List<ReadinessCategoryItemsRequestDto> getRedinessCategoryItemDetailByCategoryIdProjectId(long categoryId , long projectId ) {
		List<ReadinessCategoryItemsRequestDto> readinessCategoryItemsRequestDtoList = new ArrayList<ReadinessCategoryItemsRequestDto>();
		
		Criteria criteria = getSession().createCriteria(ReadinessCategoryItems.class);
		criteria.createAlias("changeReadinessCategories", "changeReadinessCategories" , JoinType.LEFT_OUTER_JOIN);
		criteria.createAlias("changeReadinessCategories.projectBackground", "projectBackground" , JoinType.LEFT_OUTER_JOIN);
		ProjectionList plList = Projections.projectionList();
		plList.add(Projections.property("id"));
		plList.add(Projections.property("changeReadinessCategoryItemDescription"));
		plList.add(Projections.property("changeReadinessCategoryItemCode"));
		criteria.setProjection(plList);
		if (projectId > 0) {
			criteria.add(Restrictions.eq("projectBackground.id", projectId));
		}
		if (categoryId > 0) {
			criteria.add(Restrictions.eq("changeReadinessCategories.id", categoryId));
		}
		List<Object[]> result =  (List<Object[]>) criteria.list();
		Iterator<Object[]> iterator = result.iterator();
		
		ReadinessCategoryItemsRequestDto readinessCategoryItemsRequestDto = null;
		while(iterator.hasNext()) {
			Object[] objects = (Object[]) iterator.next();
			readinessCategoryItemsRequestDto = new ReadinessCategoryItemsRequestDto();
			readinessCategoryItemsRequestDto.setChangeReadinessCategoryItemId((Long)(objects[0]));
			readinessCategoryItemsRequestDto.setChangeReadinessCategoryItemDescription(String.valueOf(objects[1]));
			readinessCategoryItemsRequestDto.setChangeReadinessCategoryItemCode(String.valueOf(objects[2]));
			readinessCategoryItemsRequestDtoList.add(readinessCategoryItemsRequestDto);
		}
	
		for(int i =0; i<readinessCategoryItemsRequestDtoList.size() ; i++) {
			List<ReadinessAssessmentDataItemRequestDto> readinessAssessmentDataItemRequestDtoList = getReadinessAssessmentDataItemByCategoryItemId(readinessCategoryItemsRequestDtoList.get(i).getChangeReadinessCategoryItemId());
			readinessCategoryItemsRequestDtoList.get(i).setReadinessAssessmentDataItemRequestDtoList(readinessAssessmentDataItemRequestDtoList);
		}
		return readinessCategoryItemsRequestDtoList;		
	}
	
	private List<ReadinessAssessmentDataItemRequestDto> getReadinessAssessmentDataItemByCategoryItemId(long changeReadinessCategoryItemId){
		List<ReadinessAssessmentDataItemRequestDto> readinessAssessmentDataItemRequestDtoList = new ArrayList<>();
		Criteria criteria2 = getSession().createCriteria(ReadinessAssessmentDataItem.class);
		criteria2.createAlias("readinessAssessmentData", "readinessAssessmentData" , JoinType.LEFT_OUTER_JOIN);
		criteria2.createAlias("readinessAssessmentData.readinessCategoryItems", "readinessCategoryItems" , JoinType.LEFT_OUTER_JOIN);
		ProjectionList plList2 =  Projections.projectionList();
		plList2.add(Projections.property("id"));
		plList2.add(Projections.property("readinessAssessmentData.id"));	
     	plList2.add(Projections.property("changeReadinessDate1"));
		plList2.add(Projections.property("changeReadinessResponsible"));
		plList2.add(Projections.property("changeReadinessDate2"));
		plList2.add(Projections.property("changeReadinessApprover"));
		criteria2.setProjection(plList2);
		ReadinessAssessmentDataItemRequestDto readinessAssessmentDataItemRequestDto = null;
			criteria2.add(Restrictions.eq("readinessCategoryItems.id", changeReadinessCategoryItemId));
		    List<Object[]> result2 =  (List<Object[]>) criteria2.list();
			Iterator<Object[]> iterator2 = result2.iterator();
		    while (iterator2.hasNext()) {
		    	readinessAssessmentDataItemRequestDto  = new ReadinessAssessmentDataItemRequestDto();
				Object[] objects = (Object[]) iterator2.next();
				readinessAssessmentDataItemRequestDto.setChangeReadinessApprover(String.valueOf(objects[5]));
				readinessAssessmentDataItemRequestDto.setChangeReadinessDate1(String.valueOf(objects[2]));
				readinessAssessmentDataItemRequestDto.setChangeReadinessDate2(String.valueOf(objects[4]));
				readinessAssessmentDataItemRequestDto.setChangeReadinessResponsible(String.valueOf(objects[3]));
				readinessAssessmentDataItemRequestDto.setReadinessAssessmentDataId((Long)objects[1]);
				readinessAssessmentDataItemRequestDto.setReadinessAssessmentDataItemId((Long)objects[0]);
				readinessAssessmentDataItemRequestDtoList.add(readinessAssessmentDataItemRequestDto);
			}
		 return readinessAssessmentDataItemRequestDtoList;	
	}
		
}
