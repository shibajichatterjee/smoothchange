package com.rest.smoothchange.cost.of.change.controller;

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
import com.rest.framework.exception.NoEnumRecordsFoundException;
import com.rest.framework.exception.NoRecordsFoundException;
import com.rest.framework.exception.UnauthorizedException;
import com.rest.smoothchange.business.benefit.mapping.dto.BusinessBenefitMappingDto;
import com.rest.smoothchange.business.benefit.mapping.dto.BusinessBenefitMappingRequestDto;
import com.rest.smoothchange.cost.of.change.dto.CostOfChangeDto;
import com.rest.smoothchange.cost.of.change.items.dto.CostOfChangeItemsDto;
import com.rest.smoothchange.cost.of.change.items.dto.CostOfChangeItemsRequestDto;
import com.rest.smoothchange.cost.of.change.items.service.CostOfChangeItemsService;
import com.rest.smoothchange.cost.of.change.service.CostOfChangeService;
import com.rest.smoothchange.project.background.dto.ProjectBackgroundDto;
import com.rest.smoothchange.util.ApprovalStatus;
import com.rest.smoothchange.util.CommonUtil;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;



@RestController
@RequestMapping(value = "/costofChangeAPI")
@Api(value = "Cost Of Change", description = "Operations For Cost Of Change")

@Transactional
public class CostOfChangeController {

	@Autowired
	private CostOfChangeService costOfChangeService; 
	@Autowired
	private CostOfChangeItemsService costOfChangeItemsService; 
	@Autowired
	private CommonUtil commonUtil;


	@ApiOperation(value = "Add Cost of Change")
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/AddCostofChange", method = RequestMethod.POST)
	public ResponseEntity create(@RequestHeader("API-KEY") String apiKey, @RequestParam("projectId") String id,
			@RequestBody CostOfChangeItemsRequestDto costOfChangeItemsRequestDto)
			throws NoEnumRecordsFoundException, UnauthorizedException, NoRecordsFoundException {
		if (!apiKey.equals(MessageEnum.API_KEY)) {
			throw new UnauthorizedException(MessageEnum.unathorized);
		}

		commonUtil.getProjectBackGround(id);
		double cost = 0.0;
		CostOfChangeDto mdto=new CostOfChangeDto();
		mdto.setProjectBackground(new ProjectBackgroundDto());
		mdto.getProjectBackground().setId(Long.parseLong(id));
		mdto.setTotalCost(cost);
		Long cost_id=(Long)costOfChangeService.create(mdto);
		CostOfChangeItemsDto dto = mapRequestToDto(costOfChangeItemsRequestDto);
		dto.getCostOfChange().setId(cost_id);
		costOfChangeItemsService.create(dto);

	ResponseBean responseBean = new ResponseBean();
		responseBean.setBody(MessageEnum.enumMessage.SUCESS.getMessage());
		return new ResponseEntity(responseBean, org.springframework.http.HttpStatus.OK);

	}
	
	private CostOfChangeItemsDto mapRequestToDto(CostOfChangeItemsRequestDto costOfChangeItemsRequestDto)
	{
		CostOfChangeItemsDto dto=new CostOfChangeItemsDto();
		dto.setApprovalStatus(ApprovalStatus.getValue(costOfChangeItemsRequestDto.getApprovalStatus()));
		dto.setApprover(costOfChangeItemsRequestDto.getApprover());
		dto.setChangeActivity(costOfChangeItemsRequestDto.getChangeActivity());
		dto.setCost(costOfChangeItemsRequestDto.getCost());
		dto.setId(costOfChangeItemsRequestDto.getId());
		dto.setCostOfChange(new CostOfChangeDto());
		
		return dto;
	}
	
	

}
