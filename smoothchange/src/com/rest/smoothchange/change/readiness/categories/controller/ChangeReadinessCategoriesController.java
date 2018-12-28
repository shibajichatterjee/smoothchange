package com.rest.smoothchange.change.readiness.categories.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rest.framework.bean.ResponseBean;
import com.rest.framework.constant.MessageEnum;
import com.rest.framework.exception.NoRecordsFoundException;
import com.rest.framework.exception.UnauthorizedException;
import com.rest.smoothchange.change.readiness.categories.dto.ChangeReadinessCategoriesDto;
import com.rest.smoothchange.change.readiness.categories.service.ChangeReadinessCategoriesService;
import com.rest.smoothchange.project.background.dto.ProjectBackgroundDto;
import com.rest.smoothchange.readiness.category.items.dto.ReadinessCategoryItemsDto;
import com.rest.smoothchange.readiness.category.items.master.dto.ReadinessCategoryItemsMasterDto;
import com.rest.smoothchange.readiness.category.items.master.service.ReadinessCategoryItemsMasterService;
import com.rest.smoothchange.readiness.category.items.service.ReadinessCategoryItemsService;
import com.rest.smoothchange.readiness.category.master.dto.ReadinessCategoryMasterDto;
import com.rest.smoothchange.readiness.category.master.service.ReadinessCategoryMasterService;
import com.rest.smoothchange.util.CommonUtil;

import io.swagger.annotations.Api;



@RestController
@RequestMapping(value = "/CopyChangeReadinessCategoriesFromMasterAPI")
@Api(value = "Copy Change Readiness Categories From Master", description = "Operations For Copy Change Readiness Categories From Master to Transaction  with Project Id")

@Transactional
public class ChangeReadinessCategoriesController {

	@Autowired
	private ChangeReadinessCategoriesService changeReadinessCategoriesService; 
	
	@Autowired
	private ReadinessCategoryMasterService readinessCategoryMasterService; 
	
	@Autowired
	private ReadinessCategoryItemsMasterService readinessCategoryItemsMasterService;
	
	@Autowired
	private ReadinessCategoryItemsService readinessCategoryItemsService;
	
	@Autowired 
	private CommonUtil commonUtil;
	
	@RequestMapping(value = "/copyChangeReadinessCategoriesFromMaster" ,method = RequestMethod.POST)
	public ResponseEntity copyChangeReadinessCategoriesFromMaster(@RequestHeader("API-KEY") String apiKey, @RequestParam("projectId")String projectId)throws NoRecordsFoundException, UnauthorizedException{
		
		if (!apiKey.equals(MessageEnum.API_KEY)) {
			throw new UnauthorizedException(MessageEnum.unathorized);
		}
		
		ResponseBean responseBean = new ResponseBean();
		try {
			ProjectBackgroundDto projectBackgroundDto = commonUtil.getProjectBackGround(projectId);
			List<ReadinessCategoryMasterDto>  readinessCategoryMasterDtolist =  readinessCategoryMasterService.getAll();
			ChangeReadinessCategoriesDto changeReadinessCategoriesDto = null;
			for(ReadinessCategoryMasterDto readinessCategoryMasterDto : readinessCategoryMasterDtolist) {			
				changeReadinessCategoriesDto = changeReadinessCategoriesService.getChangeReadinessCategoriesByCodeNameAndProjectId(readinessCategoryMasterDto.getChangeReadinessMasterCategoryName(),projectBackgroundDto.getId());				
				
				if(changeReadinessCategoriesDto!=null && changeReadinessCategoriesDto.getId()!=null) {
					saveReadinessCategoryItems(changeReadinessCategoriesDto,readinessCategoryMasterDto);
					
				}else {
				  changeReadinessCategoriesDto = new ChangeReadinessCategoriesDto();			  
				  changeReadinessCategoriesDto.setChangeReadinessCategoryName(readinessCategoryMasterDto.getChangeReadinessMasterCategoryName());
				  changeReadinessCategoriesDto.setProjectBackgroundDto(projectBackgroundDto);
				  Long changeReadinessCategoriesId = (Long)changeReadinessCategoriesService.create(changeReadinessCategoriesDto);
				  changeReadinessCategoriesDto.setId(changeReadinessCategoriesId);
				  saveReadinessCategoryItems(changeReadinessCategoriesDto,readinessCategoryMasterDto);
				}
			}
			responseBean.setBody(MessageEnum.enumMessage.SUCESS.getMessage());
			return new ResponseEntity(responseBean, org.springframework.http.HttpStatus.OK);
		}catch(Exception e) {
			responseBean.setBody(MessageEnum.enumMessage.NO_RECORDS.getMessage());
			return new ResponseEntity(responseBean, org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR);
		}		
	}
	
	
	public void saveReadinessCategoryItems(ChangeReadinessCategoriesDto changeReadinessCategoriesDto , ReadinessCategoryMasterDto readinessCategoryMasterDto) throws Exception{
		ReadinessCategoryItemsDto readinessCategoryItemsDto = null;
		List<ReadinessCategoryItemsMasterDto> readinessCategoryItemsMasterDtoList =	readinessCategoryItemsMasterService.getReadinessCategoryItemsMasterByCategoryMasterId(readinessCategoryMasterDto.getId());
		for(ReadinessCategoryItemsMasterDto readinessCategoryItemsMasterDto : readinessCategoryItemsMasterDtoList ) {
			readinessCategoryItemsDto =	readinessCategoryItemsService.getReadinessCategoryItemsByItemCodeAndCategoryId(changeReadinessCategoriesDto.getId(), readinessCategoryItemsMasterDto.getChangeReadinessMasterCategoryItemCode());
			  if(readinessCategoryItemsDto==null) {
				  readinessCategoryItemsDto = new ReadinessCategoryItemsDto();
				  readinessCategoryItemsDto.setChangeReadinessCategories(changeReadinessCategoriesDto);
				  readinessCategoryItemsDto.setChangeReadinessCategoryItemCode(readinessCategoryItemsMasterDto.getChangeReadinessMasterCategoryItemCode());
				  readinessCategoryItemsDto.setChangeReadinessCategoryItemDescription(readinessCategoryItemsMasterDto.getChangeReadinessMasterCategoryItemDescription());
				  readinessCategoryItemsService.create(readinessCategoryItemsDto);
			  }
		   }
	}

}
