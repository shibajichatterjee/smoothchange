package com.rest.smoothchange.change.readiness.categories.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rest.framework.bean.ResponseBean;
import com.rest.framework.constant.MessageEnum;
import com.rest.smoothchange.admin.service.AdminService;
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
@Api(value = "Copy Change Readiness Categories From Master", description = "Operations For Copy Change Readiness Categories From Master with Project Id")

@Transactional
public class ChangeReadinessCategoriesController {

	@Autowired
	private ChangeReadinessCategoriesService changeReadinessCategoriesService; 

	
	@Autowired
	private ReadinessCategoryMasterService readinessCategoryMasterService; 
	
	@Autowired
	private ReadinessCategoryItemsMasterService readinessCategoryItemsMasterService;
	
	@Autowired 
	private CommonUtil commonUtil;
	
	@RequestMapping(value = "/CopyChangeReadinessCategoriesFromMaster" ,method = RequestMethod.POST)
	public ResponseEntity copyChangeReadinessCategoriesFromMaster(@RequestParam("projectId")String projectId) {
		ResponseBean responseBean = new ResponseBean();
		try {
			ProjectBackgroundDto projectBackgroundDto = commonUtil.getProjectBackGround(projectId);
			List<ReadinessCategoryMasterDto>  readinessCategoryMasterDtolist =  readinessCategoryMasterService.getAll();
			ChangeReadinessCategoriesDto changeReadinessCategoriesDto = null;
			 ReadinessCategoryItemsDto readinessCategoryItemsDto = null;
			 List<ReadinessCategoryItemsDto> readinessCategoryItemsDtoList = null;
			for(ReadinessCategoryMasterDto readinessCategoryMasterDto : readinessCategoryMasterDtolist) {
				changeReadinessCategoriesDto = new ChangeReadinessCategoriesDto();
				changeReadinessCategoriesDto.setChangeReadinessCategoryName(readinessCategoryMasterDto.getChangeReadinessMasterCategoryName());
				changeReadinessCategoriesDto.setProjectBackgroundDto(projectBackgroundDto);				
				readinessCategoryItemsDtoList = new ArrayList<>();
				List<ReadinessCategoryItemsMasterDto> readinessCategoryItemsMasterDtoList =	readinessCategoryItemsMasterService.getReadinessCategoryItemsMasterByCategoryMasterId(readinessCategoryMasterDto.getId());		  
				for(ReadinessCategoryItemsMasterDto readinessCategoryItemsMasterDto : readinessCategoryItemsMasterDtoList ) {
				   readinessCategoryItemsDto = new ReadinessCategoryItemsDto();
				   readinessCategoryItemsDto.setChangeReadinessCategories(changeReadinessCategoriesDto);
				   readinessCategoryItemsDto.setChangeReadinessCategoryItemCode(readinessCategoryItemsMasterDto.getChangeReadinessMasterCategoryItemCode());
				   readinessCategoryItemsDto.setChangeReadinessCategoryItemDescription(readinessCategoryItemsMasterDto.getChangeReadinessMasterCategoryItemDescription());
				   readinessCategoryItemsDtoList.add(readinessCategoryItemsDto);
			   }
				changeReadinessCategoriesDto.setReadinessCategoryItemList(readinessCategoryItemsDtoList);
				changeReadinessCategoriesService.create(changeReadinessCategoriesDto);
			}
			responseBean.setBody(MessageEnum.enumMessage.SUCESS.getMessage());
			return new ResponseEntity(responseBean, org.springframework.http.HttpStatus.OK);
		}catch(Exception e) {
			responseBean.setBody(MessageEnum.enumMessage.NO_RECORDS.getMessage());
			return new ResponseEntity(responseBean, org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR);
		}		
	}
	

}
