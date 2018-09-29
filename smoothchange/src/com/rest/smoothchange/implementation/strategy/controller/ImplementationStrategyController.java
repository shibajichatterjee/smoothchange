package com.rest.smoothchange.implementation.strategy.controller;

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
import com.rest.smoothchange.implementation.strategy.dto.ImplementationStrategyDto;
import com.rest.smoothchange.implementation.strategy.dto.ImplementationStrategyRequestDto;
import com.rest.smoothchange.implementation.strategy.service.ImplementationStrategyService;
import com.rest.smoothchange.project.background.dto.ProjectBackgroundDto;
import com.rest.smoothchange.project.background.service.ProjectBackgroundService;
import com.rest.smoothchange.project.stakeholders.service.ProjectStakeholdersService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/implementationStrategyAPI")
@Api(value = "Implementation Strategy", description = "Operations For Implementation Strategy")

@Transactional
public class ImplementationStrategyController {

	@Autowired
	private ImplementationStrategyService implementationStrategyService;
	@Autowired
	private ProjectBackgroundService projectService;

	@ApiOperation(value = "Add Implementation Strategy")
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/AddImplementationStrategy", method = RequestMethod.POST)
	public ResponseEntity create(@RequestHeader("API-KEY") String apiKey, @RequestParam("projectId") String id,
			@RequestBody ImplementationStrategyRequestDto implementationStrategyRequestDto)
			throws NoEnumRecordsFoundException, UnauthorizedException, NoRecordsFoundException {
		if (!apiKey.equals(MessageEnum.API_KEY)) {
			throw new UnauthorizedException(MessageEnum.unathorized);
		}

		getProjectBackGround(id);
		ImplementationStrategyDto dto = mapRequestToDto(implementationStrategyRequestDto);
		dto.getProjectBackground().setId(Long.parseLong(id));
		implementationStrategyService.create(dto);
		ResponseBean responseBean = new ResponseBean();
		responseBean.setBody(MessageEnum.enumMessage.SUCESS.getMessage());
		return new ResponseEntity(responseBean, org.springframework.http.HttpStatus.OK);

	}
	@ApiOperation(value = "Modify Implementation Strategy")
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/ModifyImplementationStrategy", method = RequestMethod.POST)
	public ResponseEntity Modify(@RequestHeader("API-KEY") String apiKey, @RequestParam("projectId") String id,
			@RequestBody ImplementationStrategyRequestDto implementationStrategyRequestDto)
			throws NoEnumRecordsFoundException, UnauthorizedException, NoRecordsFoundException {
		if (!apiKey.equals(MessageEnum.API_KEY)) {
			throw new UnauthorizedException(MessageEnum.unathorized);
		}

		getProjectBackGround(id);
		ImplementationStrategyDto dto = mapRequestToDto(implementationStrategyRequestDto);
		dto.getProjectBackground().setId(Long.parseLong(id));
		implementationStrategyService.update(dto);
		ResponseBean responseBean = new ResponseBean();
		responseBean.setBody(MessageEnum.enumMessage.SUCESS.getMessage());
		return new ResponseEntity(responseBean, org.springframework.http.HttpStatus.OK);

	}

	private ImplementationStrategyDto mapRequestToDto(
			ImplementationStrategyRequestDto implementationStrategyRequestDto) {
		ImplementationStrategyDto implementationStrategyDto = new ImplementationStrategyDto();
		implementationStrategyDto.setId(implementationStrategyRequestDto.getId());
		implementationStrategyDto.setActivity(implementationStrategyRequestDto.getActivity());
		implementationStrategyDto.setExpectedResult(implementationStrategyRequestDto.getExpectedResult());
		implementationStrategyDto.setLeadContactAddress(implementationStrategyRequestDto.getLeadContactAddress());
		implementationStrategyDto.setLeadContactName(implementationStrategyRequestDto.getLeadContactName());
		implementationStrategyDto.setProjectBackground(new ProjectBackgroundDto());
		implementationStrategyDto.setEndDate(implementationStrategyRequestDto.getEndDate());
		implementationStrategyDto.setStartDate(implementationStrategyRequestDto.getStartDate());
		implementationStrategyDto.setStrategicObjective(implementationStrategyRequestDto.getStrategicObjective());

		return implementationStrategyDto;
	}
	private ImplementationStrategyRequestDto mapDtoToRequestDto(ImplementationStrategyDto implementationStrategyDto) {
		ImplementationStrategyRequestDto implementationStrategyRequestDto = new ImplementationStrategyRequestDto();
		implementationStrategyRequestDto.setId(implementationStrategyDto.getId());
		implementationStrategyRequestDto.setActivity(implementationStrategyDto.getActivity());
		implementationStrategyRequestDto.setExpectedResult(implementationStrategyDto.getExpectedResult());
		implementationStrategyRequestDto.setLeadContactAddress(implementationStrategyDto.getLeadContactAddress());
		implementationStrategyRequestDto.setLeadContactName(implementationStrategyDto.getLeadContactName());
		implementationStrategyRequestDto.setEndDate(implementationStrategyDto.getEndDate());
		implementationStrategyRequestDto.setStartDate(implementationStrategyDto.getStartDate());
		implementationStrategyRequestDto.setStrategicObjective(implementationStrategyDto.getStrategicObjective());

		return implementationStrategyRequestDto;
	}

	private void getProjectBackGround(String id) throws NoRecordsFoundException {
		ProjectBackgroundDto dto = projectService.getById(Long.parseLong(id));
		if (dto == null) {
			throw new NoRecordsFoundException(MessageEnum.enumMessage.NO_RECORDS_BY_PROJECT_ID.getMessage());
		}
	}

}
