package com.rest.smoothchange.readiness.category.items.dao.impl;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.sql.JoinType;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.rest.framework.dao.impl.AbstractDAO;
import com.rest.smoothchange.readiness.category.items.dao.ReadinessCategoryItemsDao;
import com.rest.smoothchange.readiness.category.items.dto.ReadinessCategoryItemsRequestDto;
import com.rest.smoothchange.readiness.category.items.entity.ReadinessCategoryItems;
import com.rest.smoothchange.util.DateUtil;

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
	
	public ReadinessCategoryItemsRequestDto getRedinessCategoryItemDetailById(long categoryItemId) throws ParseException {
		 String dateFormate = "yyyy-MM-dd";
		ReadinessCategoryItemsRequestDto readinessCategoryItemsRequestDto = null;
		Criteria criteria = getSession().createCriteria(ReadinessCategoryItems.class);
		criteria.add(Restrictions.eq("id", categoryItemId));
		ReadinessCategoryItems readinessCategoryItems = (ReadinessCategoryItems)criteria.uniqueResult();
		if(readinessCategoryItems!=null && readinessCategoryItems.getId()!=null) {
			readinessCategoryItemsRequestDto = new ReadinessCategoryItemsRequestDto();
			readinessCategoryItemsRequestDto.setChangeReadinessCategoryItemId(readinessCategoryItems.getId());
			readinessCategoryItemsRequestDto.setChangeReadinessCategoryItemCode(readinessCategoryItems.getChangeReadinessCategoryItemCode());
			readinessCategoryItemsRequestDto.setChangeReadinessCategoryItemDescription(readinessCategoryItems.getChangeReadinessCategoryItemDescription());
			readinessCategoryItemsRequestDto.setChangeReadinessApprover(readinessCategoryItems.getChangeReadinessApprover());
			
			if(readinessCategoryItems.getChangeReadinessDate1()!=null) {
			 readinessCategoryItemsRequestDto.setChangeReadinessDate1(DateUtil.getFormattedDateStringFromDate(readinessCategoryItems.getChangeReadinessDate1(), dateFormate));
			}
			if(readinessCategoryItems.getChangeReadinessDate2()!=null) {
			readinessCategoryItemsRequestDto.setChangeReadinessDate2(DateUtil.getFormattedDateStringFromDate(readinessCategoryItems.getChangeReadinessDate2(), dateFormate));
			}
			readinessCategoryItemsRequestDto.setChangeReadinessResponsible(readinessCategoryItems.getChangeReadinessResponsible());
		}				
		return readinessCategoryItemsRequestDto;
		
	}
	
	
	public List<ReadinessCategoryItemsRequestDto> getRedinessCategoryItemDetailByCategoryIdProjectId(long categoryId , long projectId ){
		List<ReadinessCategoryItemsRequestDto> readinessCategoryItemsRequestDtoList = new ArrayList<ReadinessCategoryItemsRequestDto>();
		Criteria criteria = getSession().createCriteria(ReadinessCategoryItems.class);
		criteria.createAlias("changeReadinessCategories", "changeReadinessCategories" , JoinType.LEFT_OUTER_JOIN);
		criteria.createAlias("changeReadinessCategories.projectBackground", "projectBackground" , JoinType.LEFT_OUTER_JOIN);
		ProjectionList plList = Projections.projectionList();
		plList.add(Projections.property("id"));
		plList.add(Projections.property("changeReadinessCategoryItemDescription"));
		plList.add(Projections.property("changeReadinessCategoryItemCode"));
		plList.add(Projections.property("changeReadinessApprover"));		
		plList.add(Projections.property("changeReadinessDate1"));
		plList.add(Projections.property("changeReadinessDate2"));
		plList.add(Projections.property("changeReadinessResponsible"));
		
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
			readinessCategoryItemsRequestDto.setChangeReadinessApprover(String.valueOf(objects[3]));
			readinessCategoryItemsRequestDto.setChangeReadinessDate1(String.valueOf(objects[4]));		
            readinessCategoryItemsRequestDto.setChangeReadinessDate2(String.valueOf(objects[5]));		
			readinessCategoryItemsRequestDto.setChangeReadinessResponsible(String.valueOf(objects[6]));
			readinessCategoryItemsRequestDtoList.add(readinessCategoryItemsRequestDto);
		}
		return readinessCategoryItemsRequestDtoList;		
	}
		
}
