package com.rest.smoothchange.readiness.category.master.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.rest.framework.bean.ResponseBean;
import com.rest.framework.constant.MessageEnum;
import com.rest.framework.exception.NoEnumRecordsFoundException;
import com.rest.framework.exception.NoRecordsFoundException;
import com.rest.framework.exception.UnauthorizedException;
import com.rest.smoothchange.readiness.category.items.master.dto.ReadinessCategoryItemsMasterDto;
import com.rest.smoothchange.readiness.category.items.master.service.ReadinessCategoryItemsMasterService;
import com.rest.smoothchange.readiness.category.master.dto.ReadinessCategoryMasterDto;
import com.rest.smoothchange.readiness.category.master.service.ReadinessCategoryMasterService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;



@RestController
@RequestMapping(value = "/generateReadinessMasterDataAPI")
@Api(value = "Readiness Master", description = "Operations For Populate All Readiness Master Data")
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
	@RequestMapping(value="AddMasterDateRediness",method = RequestMethod.POST)
	public ResponseEntity addMasterDateRediness(@RequestHeader("API-KEY") String apiKey)throws UnauthorizedException {
		
		if (!apiKey.equals(MessageEnum.API_KEY)) {
			throw new UnauthorizedException(MessageEnum.unathorized);
		}
		
		ResponseBean responseBean = new ResponseBean();	
		Long readinessCategoryMasterDtoId = null;
		try {		
		List<ReadinessCategoryMasterDto> readinessCategoryMasterDtoList = getReadinessCategoryMasteList();
		for(ReadinessCategoryMasterDto readinessCategoryMasterDto : readinessCategoryMasterDtoList) {
			ReadinessCategoryMasterDto readinessCategoryMasterDtoTemp = readinessCategoryMasterService.getReadinessCategoryMasterDtoByCategoryName(readinessCategoryMasterDto.getChangeReadinessMasterCategoryName());
			if(readinessCategoryMasterDtoTemp!=null && readinessCategoryMasterDtoTemp.getId()!=null) {
				readinessCategoryMasterDtoId = readinessCategoryMasterDtoTemp.getId();
			}else {
				readinessCategoryMasterDtoId = (Long)readinessCategoryMasterService.create(readinessCategoryMasterDto);	
			}			
			readinessCategoryMasterDto.setId(readinessCategoryMasterDtoId);
			List<ReadinessCategoryItemsMasterDto> readinessCategoryItemsMasterDtolist = getReadinessCategoryItemMasteList(readinessCategoryMasterDto.getChangeReadinessMasterCategoryName());
		    for(ReadinessCategoryItemsMasterDto readinessCategoryItemsMasterDto :readinessCategoryItemsMasterDtolist) {
		    	ReadinessCategoryItemsMasterDto readinessCategoryItemsMasterDtoTemp = readinessCategoryItemsMasterService.getReadinessCategoryItemsMasterByCategoryItemCode(readinessCategoryItemsMasterDto.getChangeReadinessMasterCategoryItemCode());
		    	if(readinessCategoryItemsMasterDtoTemp==null) {
			    	readinessCategoryItemsMasterDto.setReadinessCategoryMaster(readinessCategoryMasterDto);
			    	readinessCategoryItemsMasterService.create(readinessCategoryItemsMasterDto);
		    	}
		    }		    
		}	
		responseBean.setBody(MessageEnum.enumMessage.SUCESS.getMessage());
		return new ResponseEntity(responseBean, org.springframework.http.HttpStatus.OK);
		}catch(Exception e) {
			responseBean.setBody(MessageEnum.enumMessage.NO_RECORDS.getMessage());
			return new ResponseEntity(responseBean, org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR);
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
