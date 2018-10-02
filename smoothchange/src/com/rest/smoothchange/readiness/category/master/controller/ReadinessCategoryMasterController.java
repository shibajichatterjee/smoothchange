package com.rest.smoothchange.readiness.category.master.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rest.smoothchange.readiness.category.items.master.dto.ReadinessCategoryItemsMasterDto;
import com.rest.smoothchange.readiness.category.items.master.service.ReadinessCategoryItemsMasterService;
import com.rest.smoothchange.readiness.category.master.dto.ReadinessCategoryMasterDto;
import com.rest.smoothchange.readiness.category.master.service.ReadinessCategoryMasterService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;



@RestController
@RequestMapping(value = "/readinessMasterAPI")
@Api(value = "Readiness Master", description = "Operations For Readiness Master Data")
@Transactional
public class ReadinessCategoryMasterController {

	@Autowired
	private ReadinessCategoryMasterService readinessCategoryMasterService; 
	
	
	@Autowired
	private ReadinessCategoryItemsMasterService readinessCategoryItemsMasterService; 

	@Value("${CHANGE_READINESS_CATEGORY_MASTER}")
	private String CHANGE_READINESS_CATEGORY_MASTER;
	
	@Value("${CHANGE_READINESS_CATEGORY_ITEMS_MASTER}")
	private String CHANGE_READINESS_CATEGORY_ITEMS_MASTER;
	
	@ApiOperation(value = "Add Data Readiness category and Item Master")
	@RequestMapping(value="AddMasterDateRediness")
	public String populateDateIntable() {
		try {		
		List<ReadinessCategoryMasterDto> readinessCategoryMasterDtoList = getReadinessCategoryMasteList();
		for(ReadinessCategoryMasterDto readinessCategoryMasterDto : readinessCategoryMasterDtoList) {
			Long readinessCategoryMasterDtoId = (Long)readinessCategoryMasterService.create(readinessCategoryMasterDto);
			readinessCategoryMasterDto.setId(readinessCategoryMasterDtoId);
			List<ReadinessCategoryItemsMasterDto> readinessCategoryItemsMasterDtolist = getReadinessCategoryItemMasteList(readinessCategoryMasterDto.getChangeReadinessMasterCategoryName());
		    for(ReadinessCategoryItemsMasterDto readinessCategoryItemsMasterDto :readinessCategoryItemsMasterDtolist) {
		    	readinessCategoryItemsMasterDto.setReadinessCategoryMaster(readinessCategoryMasterDto);
		    	readinessCategoryItemsMasterService.create(readinessCategoryItemsMasterDto);
		    }
		}	
		return "success"; 
		}catch(Exception e) {
			return "error";
		}
	}
	
	
	public List<ReadinessCategoryMasterDto> getReadinessCategoryMasteList(){
		List<ReadinessCategoryMasterDto> readinessCategoryMasterDtoList = new ArrayList<>();		
		List<String> changeRedinessCategoryMasterValue =  Arrays.asList(CHANGE_READINESS_CATEGORY_MASTER.split(","));
		ReadinessCategoryMasterDto readinessCategoryMasterDto = null;
		for(String changeRedinessCategoryMaster: changeRedinessCategoryMasterValue) {
			readinessCategoryMasterDto = new ReadinessCategoryMasterDto();
			readinessCategoryMasterDto.setChangeReadinessMasterCategoryName(changeRedinessCategoryMaster);
			readinessCategoryMasterDtoList.add(readinessCategoryMasterDto);
		}
		return readinessCategoryMasterDtoList;
	}
	
	
	public List<ReadinessCategoryItemsMasterDto> getReadinessCategoryItemMasteList(String key){
		List<ReadinessCategoryItemsMasterDto> readinessCategoryItemsMasterDtolist = new ArrayList<>();
		 List<String> readinessCategoryItemMasteList =  Arrays.asList(CHANGE_READINESS_CATEGORY_ITEMS_MASTER.split("#"));
		
		 for(String readinessCategoryItemMaserKeyValue : readinessCategoryItemMasteList) {
			 String [] values = readinessCategoryItemMaserKeyValue.split("~");
			 if(values[0].equals(key)) {		 
				 ReadinessCategoryItemsMasterDto readinessCategoryItemsMasterDto = null;
				   for(int j =1; j<=(values.length-1);j++) {
					   if(j%2!=0) {
						   readinessCategoryItemsMasterDto = new ReadinessCategoryItemsMasterDto();
						   readinessCategoryItemsMasterDto.setChangeReadinessMasterCategoryItemCode(values[j]);
					   }else {
						   readinessCategoryItemsMasterDto.setChangeReadinessMasterCategoryItemDescription(values[j]);
						   readinessCategoryItemsMasterDtolist.add(readinessCategoryItemsMasterDto);
					   }									   				  					  					   
				   }
				 break; 
			 }
		 }
		 System.out.println(readinessCategoryItemsMasterDtolist);
		return readinessCategoryItemsMasterDtolist;
	}

}
