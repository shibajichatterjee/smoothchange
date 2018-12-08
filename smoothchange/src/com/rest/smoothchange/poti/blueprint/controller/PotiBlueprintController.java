package com.rest.smoothchange.poti.blueprint.controller;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
import com.rest.framework.exception.NoEnumRecordsFoundException;
import com.rest.framework.exception.NoRecordsFoundException;
import com.rest.framework.exception.UnauthorizedException;
import com.rest.smoothchange.action.plan.items.dto.ActionPlanItemsDto;
import com.rest.smoothchange.action.plan.items.dto.ActionPlanItemsRequestDto;
import com.rest.smoothchange.poti.blueprint.dto.PotiBlueprintDto;
import com.rest.smoothchange.poti.blueprint.dto.PotiBlueprintRequestDto;
import com.rest.smoothchange.poti.blueprint.service.PotiBlueprintService;
import com.rest.smoothchange.project.background.dto.ProjectBackgroundDto;
import com.rest.smoothchange.util.ActionType;
import com.rest.smoothchange.util.CommonUtil;
import com.rest.smoothchange.util.DateUtil;
import com.rest.smoothchange.util.PotiComponentType;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/potiBlueprintAPI")
@Transactional
@Api(value = "POTI Blue print API", description = "Operations For Poti Blue print")
public class PotiBlueprintController {

	@Autowired
	private PotiBlueprintService potiBlueprintService;
	
	@Autowired
	private CommonUtil commonUtil;
	
	private static String dateFormate = "yyyy-MM-dd";
	
	@ApiOperation(value = "Add POTI Blueprint")
	@RequestMapping(value = "/AddPotiBlueprintAPI", method = RequestMethod.POST)
	public ResponseEntity create(@RequestHeader("API-KEY") String apiKey, @RequestParam("projectId") String projectId,
			@RequestBody PotiBlueprintRequestDto potiBlueprintRequestDto)
			throws NoEnumRecordsFoundException, UnauthorizedException, NoRecordsFoundException, ParseException {
		if (!apiKey.equals(MessageEnum.API_KEY)) {
			throw new UnauthorizedException(MessageEnum.unathorized);
		}
		PotiComponentType potiComponentType = PotiComponentType.getValue(potiBlueprintRequestDto.getPotiComponent());
		if (potiComponentType == null) {
			throw new NoEnumRecordsFoundException("PotiComponentType not matched");
		}
		commonUtil.getProjectBackGround(projectId);
		PotiBlueprintDto dto = mapRequestToDto(potiBlueprintRequestDto);
		if(dto!=null){
			dto.getProjectBackground().setId(Long.parseLong(projectId));
			potiBlueprintService.create(dto);
		}
		ResponseBean responseBean = new ResponseBean();
		responseBean.setBody(MessageEnum.enumMessage.SUCESS.getMessage());
		return new ResponseEntity(responseBean, HttpStatus.OK);
	}
	
	@ApiOperation(value = "Modify POTI Blueprint")
	@RequestMapping(value = "/ModifyPotiBlueprintAPI", method = RequestMethod.POST)
	public ResponseEntity modify(@RequestHeader("API-KEY") String apiKey, @RequestParam("projectId") String projectId,
			@RequestBody PotiBlueprintRequestDto potiBlueprintRequestDto)
			throws NoEnumRecordsFoundException, UnauthorizedException, NoRecordsFoundException, ParseException {
		if (!apiKey.equals(MessageEnum.API_KEY)) {
			throw new UnauthorizedException(MessageEnum.unathorized);
		}
		PotiComponentType potiComponentType = PotiComponentType.getValue(potiBlueprintRequestDto.getPotiComponent());
		if (potiComponentType == null) {
			throw new NoEnumRecordsFoundException("PotiComponentType not matched");
		}
		commonUtil.getProjectBackGround(projectId);
		PotiBlueprintDto dto = mapRequestToDto(potiBlueprintRequestDto);
		if(dto!=null){
			dto.getProjectBackground().setId(Long.parseLong(projectId));
			potiBlueprintService.update(dto);
		}
		ResponseBean responseBean = new ResponseBean();
		responseBean.setBody(MessageEnum.enumMessage.SUCESS.getMessage());
		return new ResponseEntity(responseBean, HttpStatus.OK);
	}
	
	
	@ApiOperation(value = "Get POTI Detail by Project Id and Poti Component Type")
	@RequestMapping(value = "/getPotiBluePrientComponents", method = RequestMethod.GET)
	public  ResponseEntity getPotiBluePrientComponentsByProjectIdAndComponentType(@RequestHeader("API-KEY") String apiKey,@RequestParam("projectId") String projectId, @RequestParam("potiComponentType") String  potiComponentType) throws UnauthorizedException, NoEnumRecordsFoundException, NoRecordsFoundException, ParseException{
		
		ResponseBean responseBean = new ResponseBean();
		
		if (!apiKey.equals(MessageEnum.API_KEY)) {
			throw new UnauthorizedException(MessageEnum.unathorized);
		}
		PotiComponentType potiComponentTypeEnum = PotiComponentType.getValue(potiComponentType);
		if (potiComponentType == null) {
			throw new NoEnumRecordsFoundException("ActionType not matched");
		}
		List<PotiBlueprintRequestDto> potiBlueprintRequestDtos = new ArrayList<>();
		List<PotiBlueprintDto> potiBlueprintDtos = potiBlueprintService.getPotiBluePrientComponentsByProjectIdAndComponentType(Long.parseLong(projectId), potiComponentTypeEnum);
		if(potiBlueprintDtos!=null && potiBlueprintDtos.size()>0) {
			for(PotiBlueprintDto potiBlueprintDto : potiBlueprintDtos) {
				potiBlueprintRequestDtos.add(mapDtoToRequest(potiBlueprintDto));
			}			
			responseBean.setBody(potiBlueprintRequestDtos);
		}else {
			throw new NoRecordsFoundException(MessageEnum.enumMessage.NO_RECORDS.getMessage());
		}
		 return  new ResponseEntity(responseBean , HttpStatus.OK);	
	}
	
	
	@ApiOperation(value = "Get POTI Component Detail Id")
	@RequestMapping(value = "/getPotiBluePrientById", method = RequestMethod.GET)
	public  ResponseEntity getPotiBluePrientById(@RequestHeader("API-KEY") String apiKey,@RequestParam("id") long id) throws UnauthorizedException, NoEnumRecordsFoundException, NoRecordsFoundException, ParseException{	
		ResponseBean responseBean = new ResponseBean();		
		if (!apiKey.equals(MessageEnum.API_KEY)) {
			throw new UnauthorizedException(MessageEnum.unathorized);
		}
        PotiBlueprintDto potiBlueprintDto = potiBlueprintService.getById(id);
		if(potiBlueprintDto!=null && potiBlueprintDto.getId()!=null) {
			responseBean.setBody(potiBlueprintDto);
		}else {
			throw new NoRecordsFoundException(MessageEnum.enumMessage.NO_RECORDS.getMessage());
		}
		 return  new ResponseEntity(responseBean , HttpStatus.OK);	
	}
	
	@ApiOperation(value = "Delete POTI Component Detail Id")
	@RequestMapping(value = "/deletePotiBluePrientById", method = RequestMethod.GET)
	public  ResponseEntity deletePotiComponent(@RequestHeader("API-KEY") String apiKey,@RequestParam("id") long id) throws UnauthorizedException, NoEnumRecordsFoundException, NoRecordsFoundException, ParseException{	
		ResponseBean responseBean = new ResponseBean();		
		if (!apiKey.equals(MessageEnum.API_KEY)) {
			throw new UnauthorizedException(MessageEnum.unathorized);
		}
        PotiBlueprintDto potiBlueprintDto = potiBlueprintService.getById(id);
		if(potiBlueprintDto!=null && potiBlueprintDto.getId()!=null) {
			potiBlueprintService.delete(potiBlueprintDto);
			responseBean.setBody(MessageEnum.enumMessage.SUCESS.getMessage());
		}else {
			throw new NoRecordsFoundException(MessageEnum.enumMessage.NO_RECORDS.getMessage());
		}
		 return  new ResponseEntity(responseBean , HttpStatus.OK);	
	}
	
	private PotiBlueprintDto mapRequestToDto(PotiBlueprintRequestDto potiBlueprintRequestDto) throws ParseException {
	   PotiBlueprintDto potiBlueprintDto = null;
	   if(potiBlueprintRequestDto !=null) {
		   potiBlueprintDto = new PotiBlueprintDto();
		   potiBlueprintDto.setProjectBackground(new ProjectBackgroundDto());
		   potiBlueprintDto.setId(potiBlueprintRequestDto.getId());
		   potiBlueprintDto.setAsIsState(potiBlueprintRequestDto.getAsIsState());
		   if(potiBlueprintRequestDto.getAsIsToInterimEndDate()!=null && !potiBlueprintRequestDto.getAsIsToInterimEndDate().equals("")) {
			   potiBlueprintDto.setAsIsToInterimEndDate(DateUtil.getFormattedDate(potiBlueprintRequestDto.getAsIsToInterimEndDate(), dateFormate));	  
		   }
		   potiBlueprintDto.setHowToAchieve(potiBlueprintRequestDto.getHowToAchieve());
		   potiBlueprintDto.setInterimState(potiBlueprintRequestDto.getInterimState());
		   
		   if(potiBlueprintRequestDto.getAsIsToInterimStartDate()!=null && !potiBlueprintRequestDto.getAsIsToInterimStartDate().equals("")) {
		    potiBlueprintDto.setAsIsToInterimStartDate(DateUtil.getFormattedDate(potiBlueprintRequestDto.getAsIsToInterimStartDate(), dateFormate));
		   }
		   if(potiBlueprintRequestDto.getInterimToTobeEndDate()!=null && !potiBlueprintRequestDto.getInterimToTobeEndDate().equals("")) {
		    potiBlueprintDto.setInterimToTobeEndDate(DateUtil.getFormattedDate(potiBlueprintRequestDto.getInterimToTobeEndDate(), dateFormate));
		   }
		   if(potiBlueprintRequestDto.getInterimToTobeStartDate()!=null && !potiBlueprintRequestDto.getInterimToTobeStartDate().equals("")) {
			   potiBlueprintDto.setInterimToTobeStartDate(DateUtil.getFormattedDate(potiBlueprintRequestDto.getInterimToTobeStartDate(), dateFormate));
		   }
		   potiBlueprintDto.setPotiComponent(potiBlueprintRequestDto.getPotiComponent());
		   potiBlueprintDto.setToBeState(potiBlueprintRequestDto.getToBeState());		   
	   }
	   return potiBlueprintDto;	   
	}
	
	
	private PotiBlueprintRequestDto mapDtoToRequest(PotiBlueprintDto potiBlueprintDto) throws ParseException {
		PotiBlueprintRequestDto potiBlueprintRequestDto = null;
		   if(potiBlueprintDto !=null) {
			   potiBlueprintRequestDto = new PotiBlueprintRequestDto();
			   potiBlueprintRequestDto.setAsIsState(potiBlueprintDto.getAsIsState());
			   if(potiBlueprintDto.getAsIsToInterimEndDate()!=null && !potiBlueprintDto.getAsIsToInterimEndDate().equals("")) {
				   potiBlueprintRequestDto.setAsIsToInterimEndDate(DateUtil.getFormattedDateStringFromDate(potiBlueprintDto.getAsIsToInterimEndDate(), dateFormate));	  
			   }
			   potiBlueprintRequestDto.setHowToAchieve(potiBlueprintDto.getHowToAchieve());
			   potiBlueprintRequestDto.setInterimState(potiBlueprintDto.getInterimState());
			   
			   if(potiBlueprintDto.getAsIsToInterimStartDate()!=null && !potiBlueprintDto.getAsIsToInterimStartDate().equals("")) {
				   potiBlueprintRequestDto.setAsIsToInterimStartDate(DateUtil.getFormattedDateStringFromDate(potiBlueprintDto.getAsIsToInterimStartDate(), dateFormate));
			   }
			   if(potiBlueprintDto.getInterimToTobeEndDate()!=null && !potiBlueprintDto.getInterimToTobeEndDate().equals("")) {
				   potiBlueprintRequestDto.setInterimToTobeEndDate(DateUtil.getFormattedDateStringFromDate(potiBlueprintDto.getInterimToTobeEndDate(), dateFormate));
			   }
			   if(potiBlueprintDto.getInterimToTobeStartDate()!=null && !potiBlueprintDto.getInterimToTobeStartDate().equals("")) {
				   potiBlueprintRequestDto.setInterimToTobeStartDate(DateUtil.getFormattedDateStringFromDate(potiBlueprintDto.getInterimToTobeStartDate(), dateFormate));
			   }
			   potiBlueprintRequestDto.setPotiComponent(potiBlueprintDto.getPotiComponent());
			   potiBlueprintRequestDto.setToBeState(potiBlueprintDto.getToBeState());	
			   potiBlueprintRequestDto.setId(potiBlueprintDto.getId());
		   }
		   return potiBlueprintRequestDto;	   
		}
}
