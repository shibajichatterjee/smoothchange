package com.rest.smoothchange.readiness.category.items.controller;

import java.text.ParseException;
import java.util.Collections;
import java.util.List;

import org.hibernate.criterion.Projections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import com.rest.smoothchange.readiness.category.items.service.ReadinessCategoryItemsService;
import com.rest.smoothchange.util.DateUtil;
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
	
	
	private static final String dateFormate = "dd/mm/yyyy";
	
	@ApiOperation(value = "Add Readiness Category Items")
	@RequestMapping(value="createReadinessCategoryItems" ,method = RequestMethod.POST)
	public ResponseEntity createReadinessCategoryItems(@RequestHeader("API-KEY") String apiKey,@RequestParam("categoryId") long categoryId, @RequestBody ReadinessCategoryItemsRequestDto readinessCategoryItemsRequestDto ) throws UnauthorizedException, ParseException {
		
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
			readinessCategoryItems.setId(readinessCategoryItemId);
			readinessAssessmentDataDto = new ReadinessAssessmentDataDto();
			readinessAssessmentDataDto.setReadinessCategoryItems(readinessCategoryItems);
			Long readinessAssessmentDataId  = (Long) readinessAssessmentDataService.create(readinessAssessmentDataDto);
			readinessAssessmentDataDto.setId(readinessAssessmentDataId);
			readinessAssessmentDataItemDto = new ReadinessAssessmentDataItemDto();
			readinessAssessmentDataItemDto.setChangeReadinessApprover(readinessCategoryItemsRequestDto.getChangeReadinessApprover());

			if(readinessCategoryItemsRequestDto.getChangeReadinessDate1()!=null && !readinessCategoryItemsRequestDto.getChangeReadinessDate1().trim().equals("")) {
			 readinessAssessmentDataItemDto.setChangeReadinessDate1(DateUtil.getFormattedDate(readinessCategoryItemsRequestDto.getChangeReadinessDate1(), dateFormate));
			}
			if(readinessCategoryItemsRequestDto.getChangeReadinessDate1()!=null && !readinessCategoryItemsRequestDto.getChangeReadinessDate2().trim().equals("")) {
			 readinessAssessmentDataItemDto.setChangeReadinessDate2(DateUtil.getFormattedDate(readinessCategoryItemsRequestDto.getChangeReadinessDate2(),dateFormate));
			}
			readinessAssessmentDataItemDto.setChangeReadinessResponsible(readinessCategoryItemsRequestDto.getChangeReadinessResponsible());
			readinessAssessmentDataItemDto.setReadinessAssessmentDataDto(readinessAssessmentDataDto);
			readinessAssessmentDataItemService.create(readinessAssessmentDataItemDto);		
		}else {
			responseBean.setBody(MessageEnum.enumMessage.NO_RECORDS.getMessage());
		}	
		responseBean.setBody(MessageEnum.enumMessage.SUCESS.getMessage());
		return new ResponseEntity(responseBean, org.springframework.http.HttpStatus.OK);
	}
	

	
	
	
	@ApiOperation(value = "Get Item Code , Item Description , Change Readiness Approver ,Readiness Date-1  , Readiness Date-2 , Readiness Responsible by Category_Item_Id")
	@RequestMapping(value="getRedinessCategoryItemDetailById",method = RequestMethod.GET)
	public   ResponseEntity getRedinessCategoryItemDetailById(@RequestHeader("API-KEY") String apiKey, @RequestParam("categoryItemId") long categoryItemId) throws UnauthorizedException {
		
		if (!apiKey.equals(MessageEnum.API_KEY)) {
			throw new UnauthorizedException(MessageEnum.unathorized);
		}
		
		ResponseBean responseBean = new ResponseBean();			
		ReadinessCategoryItemsRequestDto readinessCategoryItemsRequestDto =  readinessCategoryItemService.getRedinessCategoryItemDetailById(categoryItemId);
		if(readinessCategoryItemsRequestDto!=null) {
		  responseBean.setBody(readinessCategoryItemsRequestDto);
		  return new ResponseEntity(responseBean, org.springframework.http.HttpStatus.OK);
		}else {
			responseBean.setBody(MessageEnum.enumMessage.NO_RECORDS.getMessage());
			return new ResponseEntity(responseBean, org.springframework.http.HttpStatus.OK);
		}
	}
	
	
	@ApiOperation(value = "Get Item Code , Item Description , Change Readiness Approver ,Readiness Date-1  , Readiness Date-2 , Readiness Responsible by Category_Id and Project_Id")
	@RequestMapping(value="getRedinessCategoryItemDetailByCategoryIdProjectId",method = RequestMethod.GET)
	public   ResponseEntity getRedinessCategoryItemDetailByCategoryIdProjectId(@RequestHeader("API-KEY") String apiKey, @RequestParam("categoryId") long categoryId ,  @RequestParam("projectId") long projectId) throws UnauthorizedException {
		
		if (!apiKey.equals(MessageEnum.API_KEY)) {
			throw new UnauthorizedException(MessageEnum.unathorized);
		}
		
		ResponseBean responseBean = new ResponseBean();
		List<ReadinessCategoryItemsRequestDto> readinessCategoryItemsRequestDtoList = Collections.emptyList();
		readinessCategoryItemsRequestDtoList =  readinessCategoryItemService.getRedinessCategoryItemDetailByCategoryIdProjectId(categoryId, projectId);
		if(readinessCategoryItemsRequestDtoList!=null && readinessCategoryItemsRequestDtoList.size()>0) {
		  responseBean.setBody(readinessCategoryItemsRequestDtoList);
		  return new ResponseEntity(responseBean, org.springframework.http.HttpStatus.OK);
		}else {
			responseBean.setBody(MessageEnum.enumMessage.NO_RECORDS.getMessage());
			return new ResponseEntity(responseBean, org.springframework.http.HttpStatus.OK);
		}
	}
	
	
	
	@ApiOperation(value = "Update ReadinessCategoryItem and ReadinessAssessmentDataItem")
	@RequestMapping(value = "UpdateReadinessCategoryItemWithAssessmentDataItem",method = RequestMethod.POST)
	public ResponseEntity updateRedinessCategoryItem(@RequestHeader("API-KEY") String apiKey,
			@RequestBody ReadinessCategoryItemsRequestDto readinessCategoryItemsRequestDto,
			@RequestParam("categoryItemId") long categoryItemId,
			@RequestParam("assesmentDataItemId") long assesmentDataItemId)
			throws UnauthorizedException, ParseException {

		if (!apiKey.equals(MessageEnum.API_KEY)) {
			throw new UnauthorizedException(MessageEnum.unathorized);
		}
		ResponseBean responseBean = new ResponseBean();
		ReadinessCategoryItemsDto readinessCategoryItemsDto = readinessCategoryItemService.getById(categoryItemId);
		if (readinessCategoryItemsDto != null && readinessCategoryItemsDto.getId() != null) {
			ReadinessAssessmentDataItemDto assessmentDataItemDto = readinessAssessmentDataItemService
					.getById(assesmentDataItemId);
			if (assessmentDataItemDto != null && assessmentDataItemDto.getId() != null) {
				readinessCategoryItemsDto.setChangeReadinessCategoryItemCode(
						readinessCategoryItemsRequestDto.getChangeReadinessCategoryItemCode());
				readinessCategoryItemsDto.setChangeReadinessCategoryItemDescription(
						readinessCategoryItemsRequestDto.getChangeReadinessCategoryItemDescription());

				assessmentDataItemDto
						.setChangeReadinessApprover(readinessCategoryItemsRequestDto.getChangeReadinessApprover());
				if (readinessCategoryItemsRequestDto.getChangeReadinessDate1() != null
						&& !readinessCategoryItemsRequestDto.getChangeReadinessDate1().trim().equals("")) {
					assessmentDataItemDto.setChangeReadinessDate1(DateUtil
							.getFormattedDate(readinessCategoryItemsRequestDto.getChangeReadinessDate1(), dateFormate));
				}
				if (readinessCategoryItemsRequestDto.getChangeReadinessDate1() != null
						&& !readinessCategoryItemsRequestDto.getChangeReadinessDate2().trim().equals("")) {
					assessmentDataItemDto.setChangeReadinessDate2(DateUtil
							.getFormattedDate(readinessCategoryItemsRequestDto.getChangeReadinessDate2(), dateFormate));
				}
				assessmentDataItemDto.setChangeReadinessResponsible(readinessCategoryItemsRequestDto.getChangeReadinessResponsible());
				
				readinessCategoryItemService.update(readinessCategoryItemsDto);
				readinessAssessmentDataItemService.update(assessmentDataItemDto);						
			} else {
				responseBean.setBody(MessageEnum.enumMessage.NO_RECORDS.getMessage());
				return new ResponseEntity(responseBean, org.springframework.http.HttpStatus.OK);
			}
		} else {
			responseBean.setBody(MessageEnum.enumMessage.NO_RECORDS.getMessage());
			return new ResponseEntity(responseBean, org.springframework.http.HttpStatus.OK);
		}
		
		responseBean.setBody(MessageEnum.enumMessage.SUCESS.getMessage());
		return new ResponseEntity(responseBean, org.springframework.http.HttpStatus.OK);
		
	}
	
	
	
}
