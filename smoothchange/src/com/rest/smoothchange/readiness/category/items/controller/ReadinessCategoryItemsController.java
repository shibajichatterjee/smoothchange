package com.rest.smoothchange.readiness.category.items.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import com.rest.smoothchange.readiness.category.items.service.ReadinessCategoryItemsService;
import com.rest.framework.bean.ResponseBean;
import com.rest.framework.constant.MessageEnum;
import com.rest.framework.exception.UnauthorizedException;
import com.rest.smoothchange.change.readiness.categories.dto.ChangeReadinessCategoriesDto;
import com.rest.smoothchange.change.readiness.categories.entity.ChangeReadinessCategories;
import com.rest.smoothchange.change.readiness.categories.service.ChangeReadinessCategoriesService;
import com.rest.smoothchange.readiness.assessment.data.dto.ReadinessAssessmentDataDto;
import com.rest.smoothchange.readiness.assessment.data.item.dto.ReadinessAssessmentDataItemDto;
import com.rest.smoothchange.readiness.assessment.data.item.entity.ReadinessAssessmentDataItem;
import com.rest.smoothchange.readiness.assessment.data.item.service.ReadinessAssessmentDataItemService;
import com.rest.smoothchange.readiness.assessment.data.service.ReadinessAssessmentDataService;
import com.rest.smoothchange.readiness.category.items.dto.ReadinessCategoryItemsDto;
import com.rest.smoothchange.readiness.category.items.dto.ReadinessCategoryItemsRequestDto;
import com.rest.smoothchange.readiness.category.items.entity.ReadinessCategoryItems;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;



@RestController
@RequestMapping(value = "/readinesscategoryitemsAPI")
@Api(value = "Readiness Category Items" , description = "Operations For Readiness Category Items")
@Transactional
public class ReadinessCategoryItemsController {

	@Autowired
	private ReadinessCategoryItemsService readinessCategoryItemService; 
	
	@Autowired
	private ChangeReadinessCategoriesService changeReadinessCategoriesService;
	
	@Autowired
	private ReadinessAssessmentDataService readinessAssessmentDataService;
	
	@Autowired
    private ReadinessAssessmentDataItemService readinessAssessmentDataItemService;
	
	
	@ApiOperation(value = "Add Readiness Category Items")
	@RequestMapping(value="createReadinessCategoryItems" ,method = RequestMethod.POST)
	public ResponseEntity createReadinessCategoryItems(@RequestHeader("API-KEY") String apiKey,@RequestHeader("categoryId") long categoryId,@RequestBody ReadinessCategoryItemsRequestDto readinessCategoryItemsRequestDto ) throws UnauthorizedException {
		
		if (!apiKey.equals(MessageEnum.API_KEY)) {
			throw new UnauthorizedException(MessageEnum.unathorized);
		}
		
		
		ResponseBean responseBean = new ResponseBean();
		ChangeReadinessCategoriesDto changeReadinessCategories = changeReadinessCategoriesService.getById(categoryId);
		ReadinessCategoryItemsDto readinessCategoryItems = null;
	    ReadinessAssessmentDataDto readinessAssessmentDataDto = null;
	    ReadinessAssessmentDataItemDto readinessAssessmentDataItemDto = null;
		if(changeReadinessCategories!=null && changeReadinessCategories.getId()!=null) {
			readinessCategoryItems = new ReadinessCategoryItemsDto();
			readinessCategoryItems.setChangeReadinessCategories(changeReadinessCategories);
			readinessCategoryItems.setChangeReadinessCategoryItemCode(readinessCategoryItemsRequestDto.getChangeReadinessCategoryItemCode());
			readinessCategoryItems.setChangeReadinessCategoryItemDescription(readinessCategoryItemsRequestDto.getChangeReadinessCategoryItemDescription());
			Long readinessCategoryItemId= (Long)readinessCategoryItemService.create(readinessCategoryItems);
			readinessCategoryItems.setId(readinessCategoryItemId);;
			readinessAssessmentDataDto = new ReadinessAssessmentDataDto();
			readinessAssessmentDataDto.setReadinessCategoryItems(readinessCategoryItems);
			Long readinessAssessmentDataId  = (Long) readinessAssessmentDataService.create(readinessAssessmentDataDto);
			readinessAssessmentDataDto.setId(readinessAssessmentDataId);
			readinessAssessmentDataItemDto = new ReadinessAssessmentDataItemDto();
			readinessAssessmentDataItemDto.setChangeReadinessApprover(readinessCategoryItemsRequestDto.getChangeReadinessApprover());
			readinessAssessmentDataItemDto.setChangeReadinessDate1(readinessCategoryItemsRequestDto.getChangeReadinessDate1());
			readinessAssessmentDataItemDto.setChangeReadinessDate2(readinessCategoryItemsRequestDto.getChangeReadinessDate2());
			readinessAssessmentDataItemDto.setChangeReadinessResponsible(readinessCategoryItemsRequestDto.getChangeReadinessResponsible());
			readinessAssessmentDataItemDto.setReadinessAssessmentDataDto(readinessAssessmentDataDto);
			readinessAssessmentDataItemService.create(readinessAssessmentDataItemDto);		
		}else {
			responseBean.setBody(MessageEnum.enumMessage.NO_RECORDS.getMessage());
		}	
		responseBean.setBody(MessageEnum.enumMessage.SUCESS.getMessage());
		return new ResponseEntity(responseBean, org.springframework.http.HttpStatus.OK);
	}
	
	
	
	
	 
	
	

}
