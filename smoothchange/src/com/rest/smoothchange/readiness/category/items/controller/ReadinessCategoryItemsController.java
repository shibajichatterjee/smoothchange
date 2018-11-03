package com.rest.smoothchange.readiness.category.items.controller;

import java.text.ParseException;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rest.framework.bean.ResponseBean;
import com.rest.framework.constant.MessageEnum;
import com.rest.framework.exception.UnauthorizedException;
import com.rest.smoothchange.change.readiness.categories.dto.ChangeReadinessCategoriesDto;
import com.rest.smoothchange.change.readiness.categories.service.ChangeReadinessCategoriesService;
import com.rest.smoothchange.readiness.category.items.dto.ReadinessCategoryItemsDto;
import com.rest.smoothchange.readiness.category.items.dto.ReadinessCategoryItemsRequestDto;
import com.rest.smoothchange.readiness.category.items.service.ReadinessCategoryItemsService;
import com.rest.smoothchange.util.DateUtil;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/readinessCategoryItemsAPI")
@Api(value = "Readiness Category Items", description = "Operations For Readiness Category Items")
@Transactional
public class ReadinessCategoryItemsController {

	@Autowired
	private ReadinessCategoryItemsService readinessCategoryItemService;

	@Autowired
	private ChangeReadinessCategoriesService changeReadinessCategoriesService;

	private static final String dateFormate = "yyyy-MM-dd";

	@ApiOperation(value = "Add Readiness Category Items")
	@RequestMapping(value = "createReadinessCategoryItems", method = RequestMethod.POST)
	public ResponseEntity createReadinessCategoryItems(@RequestHeader("API-KEY") String apiKey,@RequestParam("categoryId") long categoryId,
			@RequestBody ReadinessCategoryItemsRequestDto readinessCategoryItemsRequestDto)
			throws UnauthorizedException, ParseException {
		
		 if (!apiKey.equals(MessageEnum.API_KEY)) {
			 throw new UnauthorizedException(MessageEnum.unathorized); 
		  }

		ResponseBean responseBean = new ResponseBean();
		ChangeReadinessCategoriesDto changeReadinessCategories = changeReadinessCategoriesService.getById(categoryId);
		ReadinessCategoryItemsDto readinessCategoryItems = null;
		if (changeReadinessCategories != null && changeReadinessCategories.getId() != null) {
			readinessCategoryItems = createReadinessCategoryItems(changeReadinessCategories,
					readinessCategoryItemsRequestDto);
		} else {
			responseBean.setBody(MessageEnum.enumMessage.NO_RECORDS.getMessage());
		}
		responseBean.setBody(MessageEnum.enumMessage.SUCESS.getMessage());
		return new ResponseEntity(responseBean, org.springframework.http.HttpStatus.OK);
	}

	@ApiOperation(value = "Get Item by Category_Item_Id")
	@RequestMapping(value = "getRedinessCategoryItemDetailById", method = RequestMethod.GET)
	public ResponseEntity getRedinessCategoryItemDetailById(@RequestHeader("API-KEY") String apiKey, @RequestParam("categoryItemId") long categoryItemId)
			throws UnauthorizedException, ParseException {

		if (!apiKey.equals(MessageEnum.API_KEY)) {
		   throw new UnauthorizedException(MessageEnum.unathorized);
		}

		ResponseBean responseBean = new ResponseBean();
		ReadinessCategoryItemsRequestDto readinessCategoryItemsRequestDto = readinessCategoryItemService
				.getRedinessCategoryItemDetailById(categoryItemId);
		if (readinessCategoryItemsRequestDto != null) {
			responseBean.setBody(readinessCategoryItemsRequestDto);
			return new ResponseEntity(responseBean, org.springframework.http.HttpStatus.OK);
		} else {
			responseBean.setBody(MessageEnum.enumMessage.NO_RECORDS.getMessage());
			return new ResponseEntity(responseBean, org.springframework.http.HttpStatus.OK);
		}
	}

	@ApiOperation(value = "Get Category Item by Category_Id and Project_Id")
	@RequestMapping(value = "getRedinessCategoryItemDetailByCategoryIdProjectId", method = RequestMethod.GET)
	public ResponseEntity getRedinessCategoryItemDetailByCategoryIdProjectId(
			@RequestHeader("API-KEY") String apiKey,
			@RequestParam("categoryId") long categoryId, @RequestParam("projectId") long projectId)
			throws UnauthorizedException, ParseException {

		
		if (!apiKey.equals(MessageEnum.API_KEY)) {
			throw new UnauthorizedException(MessageEnum.unathorized);
		}
		
		ResponseBean responseBean = new ResponseBean();
		List<ReadinessCategoryItemsRequestDto> readinessCategoryItemsRequestDtoList = Collections.emptyList();
		readinessCategoryItemsRequestDtoList = readinessCategoryItemService
				.getRedinessCategoryItemDetailByCategoryIdProjectId(categoryId, projectId);
		if (readinessCategoryItemsRequestDtoList != null && readinessCategoryItemsRequestDtoList.size() > 0) {
			responseBean.setBody(readinessCategoryItemsRequestDtoList);
			return new ResponseEntity(responseBean, org.springframework.http.HttpStatus.OK);
		} else {
			responseBean.setBody(MessageEnum.enumMessage.NO_RECORDS.getMessage());
			return new ResponseEntity(responseBean, org.springframework.http.HttpStatus.OK);
		}
	}
	
	
	@ApiOperation(value = "Update ReadinessCategoryItem")
	@RequestMapping(value = "updateReadinessCategoryItem",method = RequestMethod.POST)
	public ResponseEntity updateRedinessCategoryItem(@RequestHeader("API-KEY") String apiKey,
			@RequestBody ReadinessCategoryItemsRequestDto readinessCategoryItemsRequestDto,
			@RequestParam("categoryItemId") long categoryItemId)
			throws UnauthorizedException, ParseException {

		if (!apiKey.equals(MessageEnum.API_KEY)) {
			throw new UnauthorizedException(MessageEnum.unathorized);
		}
		
		ResponseBean responseBean = new ResponseBean();
		ReadinessCategoryItemsDto readinessCategoryItemsDto = readinessCategoryItemService.getById(categoryItemId);
		if (readinessCategoryItemsDto != null && readinessCategoryItemsDto.getId() != null) {
				
			readinessCategoryItemsDto.setChangeReadinessCategoryItemCode(
						readinessCategoryItemsRequestDto.getChangeReadinessCategoryItemCode());
			
			readinessCategoryItemsDto.setChangeReadinessCategoryItemDescription(
						readinessCategoryItemsRequestDto.getChangeReadinessCategoryItemDescription());
				
			readinessCategoryItemsDto.setChangeReadinessApprover(readinessCategoryItemsRequestDto.getChangeReadinessApprover());
						
			if(readinessCategoryItemsRequestDto.getChangeReadinessDate1()!=null && !readinessCategoryItemsRequestDto.getChangeReadinessDate1().trim().equals(""))
				readinessCategoryItemsDto.setChangeReadinessDate1(DateUtil.getFormattedDate(readinessCategoryItemsRequestDto.getChangeReadinessDate1(), dateFormate));
		
			if(readinessCategoryItemsRequestDto.getChangeReadinessDate2()!=null && !readinessCategoryItemsRequestDto.getChangeReadinessDate2().trim().equals(""))
				readinessCategoryItemsDto.setChangeReadinessDate2(DateUtil.getFormattedDate(readinessCategoryItemsRequestDto.getChangeReadinessDate2(), dateFormate));
			
			readinessCategoryItemsDto.setChangeReadinessResponsible(readinessCategoryItemsRequestDto.getChangeReadinessResponsible());
			
				readinessCategoryItemService.update(readinessCategoryItemsDto);
												
		} else {
			responseBean.setBody(MessageEnum.enumMessage.NO_RECORDS.getMessage());
			return new ResponseEntity(responseBean, org.springframework.http.HttpStatus.OK);
		}
		
		responseBean.setBody(MessageEnum.enumMessage.SUCESS.getMessage());
		return new ResponseEntity(responseBean, org.springframework.http.HttpStatus.OK);		
	}
	
	@ApiOperation(value = "Delete Category Item By Id")
	@RequestMapping(value = "deleteRedinessCategoryItemDetailById", method = RequestMethod.DELETE)
	public ResponseEntity deleteRedinessCategoryItemDetailById(@RequestHeader("API-KEY") String apiKey, @RequestParam("categoryItemId") long categoryItemId)
			throws UnauthorizedException, ParseException {

		if (!apiKey.equals(MessageEnum.API_KEY)) {
		   throw new UnauthorizedException(MessageEnum.unathorized);
		}

		ResponseBean responseBean = new ResponseBean();
		ReadinessCategoryItemsRequestDto readinessCategoryItemsRequestDto = readinessCategoryItemService
				.getRedinessCategoryItemDetailById(categoryItemId);
		if (readinessCategoryItemsRequestDto != null) {
			readinessCategoryItemService.deleteById(categoryItemId);
			responseBean.setBody(MessageEnum.enumMessage.SUCESS.getMessage());			
			return new ResponseEntity(responseBean, org.springframework.http.HttpStatus.OK);
		} else {
			responseBean.setBody(MessageEnum.enumMessage.NO_RECORDS.getMessage());
			return new ResponseEntity(responseBean, org.springframework.http.HttpStatus.OK);
		}
	}

	
	
	//===================== Private Method ======================== 

	private ReadinessCategoryItemsDto createReadinessCategoryItems(
			ChangeReadinessCategoriesDto changeReadinessCategories,
			ReadinessCategoryItemsRequestDto readinessCategoryItemsRequestDto) throws ParseException {
		ReadinessCategoryItemsDto readinessCategoryItems = mapReadinessCategoryItemsRequestDtoToReadinessCategoryItemsDto(
				changeReadinessCategories, readinessCategoryItemsRequestDto);
		if (readinessCategoryItems != null && readinessCategoryItems.getId() != null) {
			readinessCategoryItemService.update(readinessCategoryItems);
			return readinessCategoryItems;
		} else {
			long readinessCategoryId = (long) readinessCategoryItemService.create(readinessCategoryItems);
			readinessCategoryItems.setId(readinessCategoryId);
			return readinessCategoryItems;
		}
	}


	private ReadinessCategoryItemsDto mapReadinessCategoryItemsRequestDtoToReadinessCategoryItemsDto(
			ChangeReadinessCategoriesDto changeReadinessCategories,
			ReadinessCategoryItemsRequestDto readinessCategoryItemsRequestDto) throws ParseException {
		ReadinessCategoryItemsDto readinessCategoryItemsDto = null;
		if (readinessCategoryItemsRequestDto != null) {
			readinessCategoryItemsDto = readinessCategoryItemService.getReadinessCategoryItemsByItemCodeAndCategoryId(
					changeReadinessCategories.getId(),
					readinessCategoryItemsRequestDto.getChangeReadinessCategoryItemCode());
			if (readinessCategoryItemsDto != null && readinessCategoryItemsDto.getId() != null) {
				readinessCategoryItemsDto.setChangeReadinessCategoryItemDescription(
						readinessCategoryItemsRequestDto.getChangeReadinessCategoryItemDescription());
				
				readinessCategoryItemsDto.setChangeReadinessApprover(readinessCategoryItemsRequestDto.getChangeReadinessApprover());
				
				if(readinessCategoryItemsRequestDto.getChangeReadinessDate1()!=null && !readinessCategoryItemsRequestDto.getChangeReadinessDate1().trim().equals(""))
				readinessCategoryItemsDto.setChangeReadinessDate1(DateUtil.getFormattedDate(readinessCategoryItemsRequestDto.getChangeReadinessDate1(), dateFormate));
				
				if(readinessCategoryItemsRequestDto.getChangeReadinessDate2()!=null && !readinessCategoryItemsRequestDto.getChangeReadinessDate2().trim().equals(""))
					readinessCategoryItemsDto.setChangeReadinessDate2(DateUtil.getFormattedDate(readinessCategoryItemsRequestDto.getChangeReadinessDate2(), dateFormate));		
				
				readinessCategoryItemsDto.setChangeReadinessResponsible(readinessCategoryItemsRequestDto.getChangeReadinessResponsible());
				
			} else {
				readinessCategoryItemsDto = new ReadinessCategoryItemsDto();
				readinessCategoryItemsDto.setChangeReadinessCategories(changeReadinessCategories);
				readinessCategoryItemsDto.setChangeReadinessCategoryItemCode(
						readinessCategoryItemsRequestDto.getChangeReadinessCategoryItemCode());
				readinessCategoryItemsDto.setChangeReadinessCategoryItemDescription(
						readinessCategoryItemsRequestDto.getChangeReadinessCategoryItemDescription());
				readinessCategoryItemsDto.setChangeReadinessApprover(readinessCategoryItemsRequestDto.getChangeReadinessApprover());
			if(readinessCategoryItemsRequestDto.getChangeReadinessDate1()!=null && !readinessCategoryItemsRequestDto.getChangeReadinessDate1().trim().equals(""))
				readinessCategoryItemsDto.setChangeReadinessDate1(DateUtil.getFormattedDate(readinessCategoryItemsRequestDto.getChangeReadinessDate1(), dateFormate));
			
			if(readinessCategoryItemsRequestDto.getChangeReadinessDate2()!=null && !readinessCategoryItemsRequestDto.getChangeReadinessDate2().trim().equals(""))
				readinessCategoryItemsDto.setChangeReadinessDate2(DateUtil.getFormattedDate(readinessCategoryItemsRequestDto.getChangeReadinessDate2(), dateFormate));
			
			readinessCategoryItemsDto.setChangeReadinessResponsible(readinessCategoryItemsRequestDto.getChangeReadinessResponsible());
			
			}
		}
		return readinessCategoryItemsDto;
	}

}
