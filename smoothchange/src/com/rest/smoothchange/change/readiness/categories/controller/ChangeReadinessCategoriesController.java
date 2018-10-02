package com.rest.smoothchange.change.readiness.categories.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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

import io.swagger.annotations.Api;



@RestController
@RequestMapping(value = "/CopyChangeReadinessCategoriesFromMasterAPI")
@Api(value = "Copy Change Readiness Categories From Master", description = "Operations For Copy Change Readiness Categories From Master with Project Id")

@Transactional
public class ChangeReadinessCategoriesController {

	@Autowired
	private ChangeReadinessCategoriesService changeReadinessCategoriesService; 

	@Autowired
	private ReadinessCategoryItemsService readinessCategoryItemsService;
	
	@Autowired
	private ReadinessCategoryMasterService readinessCategoryMasterService; 
	
	@Autowired
	private ReadinessCategoryItemsMasterService readinessCategoryItemsMasterService;
	
	public String populateMasterDateForRedinessCategory(@RequestParam("projectId")long projectId) {
		try {
			ProjectBackgroundDto projectBackgroundDto = new ProjectBackgroundDto();
			projectBackgroundDto.setId(projectId);
			List<ReadinessCategoryMasterDto>  readinessCategoryMasterDtolist =  readinessCategoryMasterService.getAll();
			ChangeReadinessCategoriesDto changeReadinessCategoriesDto = null;
			 ReadinessCategoryItemsDto readinessCategoryItemsDto = null;
			for(ReadinessCategoryMasterDto readinessCategoryMasterDto : readinessCategoryMasterDtolist) {
				changeReadinessCategoriesDto = new ChangeReadinessCategoriesDto();
				changeReadinessCategoriesDto.setChangeReadinessCategoryName(readinessCategoryMasterDto.getChangeReadinessMasterCategoryName());
				changeReadinessCategoriesDto.setProjectBackgroundDto(projectBackgroundDto);
				Long changeReadinessCategoriesId = (Long)changeReadinessCategoriesService.create(changeReadinessCategoriesDto);
				changeReadinessCategoriesDto.setId(changeReadinessCategoriesId);				
				 List<ReadinessCategoryItemsMasterDto> readinessCategoryItemsMasterDtoList =	readinessCategoryItemsMasterService.getReadinessCategoryItemsMasterByCategoryMasterId(readinessCategoryMasterDto.getId());
		  
			   for(ReadinessCategoryItemsMasterDto readinessCategoryItemsMasterDto : readinessCategoryItemsMasterDtoList ) {
				   readinessCategoryItemsDto = new ReadinessCategoryItemsDto();
				   readinessCategoryItemsDto.setChangeReadinessCategories(changeReadinessCategoriesDto);
				   readinessCategoryItemsDto.setChangeReadinessCategoryItemCode(readinessCategoryItemsMasterDto.getChangeReadinessMasterCategoryItemCode());
				   readinessCategoryItemsDto.setChangeReadinessCategoryItemDescription(readinessCategoryItemsMasterDto.getChangeReadinessMasterCategoryItemDescription());
				   readinessCategoryItemsService.create(readinessCategoryItemsDto);
			   }			 
			}
			return "success";
		}catch(Exception e) {
			System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx"+e.getMessage());
			return "error";
		}
		
	}
	

}
