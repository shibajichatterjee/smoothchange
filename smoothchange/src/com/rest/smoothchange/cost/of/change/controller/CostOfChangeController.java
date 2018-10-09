package com.rest.smoothchange.cost.of.change.controller;

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
import com.rest.smoothchange.util.LevelOfInfluence;

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
		ApprovalStatus approvalStatus = ApprovalStatus.getValue(costOfChangeItemsRequestDto.getApprovalStatus());
		if (approvalStatus == null) {

			throw new NoEnumRecordsFoundException("ApprovalStatus not matched");
		}

		commonUtil.getProjectBackGround(id);
		double cost = 0.0;
		CostOfChangeDto mdto = new CostOfChangeDto();
		mdto.setProjectBackground(new ProjectBackgroundDto());
		mdto.getProjectBackground().setId(Long.parseLong(id));
		mdto.setTotalCost(cost + costOfChangeItemsRequestDto.getCost());
		List<CostOfChangeDto> costOfChangeDtoList = costOfChangeService
				.getCostOfChangeListByProjectId(Long.parseLong(id));
		Long cost_id;
		if (costOfChangeDtoList.size() == 0) {
			cost_id = (Long) costOfChangeService.create(mdto);
		} else {
			cost_id = costOfChangeDtoList.get(0).getId();
			costOfChangeDtoList.get(0)
					.setTotalCost(costOfChangeDtoList.get(0).getTotalCost() + costOfChangeItemsRequestDto.getCost());
			costOfChangeService.update(costOfChangeDtoList.get(0));
		}

		CostOfChangeItemsDto dto = mapRequestToDto(costOfChangeItemsRequestDto);
		dto.getCostOfChange().setId(cost_id);
		costOfChangeItemsService.create(dto);

		ResponseBean responseBean = new ResponseBean();
		responseBean.setBody(MessageEnum.enumMessage.SUCESS.getMessage());
		return new ResponseEntity(responseBean, org.springframework.http.HttpStatus.OK);

	}

	@ApiOperation(value = "Modify Cost of Change")
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/ModifyCostofChange", method = RequestMethod.POST)
	public ResponseEntity Modify(@RequestHeader("API-KEY") String apiKey,
			@RequestBody CostOfChangeItemsRequestDto costOfChangeItemsRequestDto)
			throws NoEnumRecordsFoundException, UnauthorizedException, NoRecordsFoundException {
		if (!apiKey.equals(MessageEnum.API_KEY)) {
			throw new UnauthorizedException(MessageEnum.unathorized);
		}
		ApprovalStatus approvalStatus = ApprovalStatus.getValue(costOfChangeItemsRequestDto.getApprovalStatus());
		if (approvalStatus == null) {

			throw new NoEnumRecordsFoundException("ApprovalStatus not matched");
		}
		CostOfChangeItemsDto costOfChangeItemsDto = costOfChangeItemsService
				.getById(costOfChangeItemsRequestDto.getId());
		if (costOfChangeItemsDto == null) {
			throw new NoRecordsFoundException(MessageEnum.enumMessage.ID_NOT_VALID.getMessage());
		}

		double cost = 0.0;
		CostOfChangeDto costOfChangeDto = costOfChangeItemsService.getById(costOfChangeItemsRequestDto.getId())
				.getCostOfChange();

		CostOfChangeItemsDto dto = mapRequestToDto(costOfChangeItemsRequestDto);
		dto.getCostOfChange().setId(costOfChangeDto.getId());
		costOfChangeItemsService.update(dto);
		List<CostOfChangeItemsDto> costOfChangeItemsDtoList = costOfChangeItemsService
				.getCostOfChangeItemListByProjectIdCostOfChageId(costOfChangeDto.getProjectBackground().getId(),
						costOfChangeDto.getId());
		for (CostOfChangeItemsDto costOfChangeItemsDtoDB : costOfChangeItemsDtoList) {
			cost = cost + costOfChangeItemsDtoDB.getCost();
		}
		costOfChangeDto.setTotalCost(cost);
		costOfChangeService.update(costOfChangeDto);

		ResponseBean responseBean = new ResponseBean();
		responseBean.setBody(MessageEnum.enumMessage.SUCESS.getMessage());
		return new ResponseEntity(responseBean, org.springframework.http.HttpStatus.OK);

	}

	private CostOfChangeItemsDto mapRequestToDto(CostOfChangeItemsRequestDto costOfChangeItemsRequestDto) {
		CostOfChangeItemsDto dto = new CostOfChangeItemsDto();
		dto.setApprovalStatus(ApprovalStatus.getValue(costOfChangeItemsRequestDto.getApprovalStatus()));
		dto.setApprover(costOfChangeItemsRequestDto.getApprover());
		dto.setChangeActivity(costOfChangeItemsRequestDto.getChangeActivity());
		dto.setCost(costOfChangeItemsRequestDto.getCost());
		dto.setId(costOfChangeItemsRequestDto.getId());
		dto.setCostOfChange(new CostOfChangeDto());

		return dto;
	}

	private CostOfChangeItemsRequestDto mapDtoToRequestDto(CostOfChangeItemsDto costOfChangeItemsDto) {
		CostOfChangeItemsRequestDto dto = new CostOfChangeItemsRequestDto();
		dto.setApprovalStatus(costOfChangeItemsDto.getApprovalStatus().getNumVal());
		dto.setApprover(costOfChangeItemsDto.getApprover());
		dto.setChangeActivity(costOfChangeItemsDto.getChangeActivity());
		dto.setCost(costOfChangeItemsDto.getCost());
		dto.setId(costOfChangeItemsDto.getId());

		return dto;
	}

}
