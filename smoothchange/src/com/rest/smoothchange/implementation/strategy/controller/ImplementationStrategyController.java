package com.rest.smoothchange.implementation.strategy.controller;

import java.util.ArrayList;
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
import com.rest.smoothchange.implementation.strategy.dto.ImplementationStrategyDto;
import com.rest.smoothchange.implementation.strategy.dto.ImplementationStrategyRequestDto;
import com.rest.smoothchange.implementation.strategy.service.ImplementationStrategyService;
import com.rest.smoothchange.project.background.dto.ProjectBackgroundDto;
import com.rest.smoothchange.project.background.service.ProjectBackgroundService;
import com.rest.smoothchange.util.ImplementationActivity;

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
		ImplementationActivity type=ImplementationActivity.getValue(implementationStrategyRequestDto.getActivity());
		if (type == null) {

			throw new NoEnumRecordsFoundException("Implementation Activity not matched");
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
		ImplementationActivity type=ImplementationActivity.getValue(implementationStrategyRequestDto.getActivity());
		if (type == null) {

			throw new NoEnumRecordsFoundException("Implementation Activity not matched");
		}


		getProjectBackGround(id);
		ImplementationStrategyDto dto = mapRequestToDto(implementationStrategyRequestDto);
		dto.getProjectBackground().setId(Long.parseLong(id));
		implementationStrategyService.update(dto);
		ResponseBean responseBean = new ResponseBean();
		responseBean.setBody(MessageEnum.enumMessage.SUCESS.getMessage());
		return new ResponseEntity(responseBean, org.springframework.http.HttpStatus.OK);

	}

	@ApiOperation(value = "Get Implementation Strategy by Project Id")
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/GetImplementationStrategyByProjectId", method = RequestMethod.GET)
	public ResponseEntity getImplementationStrategyByProjectId(@RequestHeader("API-KEY") String apiKey,
			@RequestParam("projectId") String projectId) throws NoRecordsFoundException, UnauthorizedException {
		if (!apiKey.equals(MessageEnum.API_KEY)) {
			throw new UnauthorizedException(MessageEnum.unathorized);
		}
		List<ImplementationStrategyRequestDto> requestDtoList = new ArrayList<>();
		getProjectBackGround(projectId);

		List<ImplementationStrategyDto> dto = implementationStrategyService
				.getImplementationStrategyListByProjectId(Long.parseLong(projectId));
		if (dto == null || dto.size() == 0) {
			throw new NoRecordsFoundException(MessageEnum.enumMessage.NO_RECORDS.getMessage());
		}
		for (ImplementationStrategyDto implementationStrategyDto : dto) {
			requestDtoList.add(mapDtoToRequestDto(implementationStrategyDto));
		}
		ResponseBean responseBean = new ResponseBean();
		responseBean.setBody(requestDtoList);
		return new ResponseEntity(responseBean, org.springframework.http.HttpStatus.OK);

	}

	@ApiOperation(value = "Get Implementation Strategy by Id and Project Id")
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/GetImplementationStrategyByIdandProjectId", method = RequestMethod.GET)
	public ResponseEntity getBusinessBenefitMappingByIdandProjectId(@RequestHeader("API-KEY") String apiKey,
			@RequestParam("projectId") String projectId, @RequestParam("id") String id)
			throws NoRecordsFoundException, UnauthorizedException {
		if (!apiKey.equals(MessageEnum.API_KEY)) {
			throw new UnauthorizedException(MessageEnum.unathorized);
		}
		getProjectBackGround(projectId);
		ImplementationStrategyDto dto = new ImplementationStrategyDto();
		dto.setId(Long.parseLong(id));
		dto.setProjectBackground(new ProjectBackgroundDto());
		dto.getProjectBackground().setId(Long.parseLong(projectId));
		dto = implementationStrategyService.getImplementationStrategyByIdProjectId(dto);
		if (dto == null) {
			throw new NoRecordsFoundException(MessageEnum.enumMessage.NO_RECORDS.getMessage());
		}
		ResponseBean responseBean = new ResponseBean();
		responseBean.setBody(mapDtoToRequestDto(dto));
		return new ResponseEntity(responseBean, org.springframework.http.HttpStatus.OK);

	}
	
	@ApiOperation(value = "Delete Implementation Strategy by Id")
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/DeleteImplementationStrategyById", method = RequestMethod.DELETE)
	public ResponseEntity deleteImplementationStrategyById(@RequestHeader("API-KEY") String apiKey,@RequestParam("id") String id) throws UnauthorizedException, NoRecordsFoundException {
		if(!apiKey.equals(MessageEnum.API_KEY))
		{
			throw new UnauthorizedException(MessageEnum.unathorized);
		}
		ImplementationStrategyDto dto=implementationStrategyService.getById(Long.parseLong(id));
		if(dto==null)
		{
			throw new NoRecordsFoundException(MessageEnum.enumMessage.ID_NOT_VALID.getMessage());

		}
		implementationStrategyService.deleteById(Long.parseLong(id));
		ResponseBean responseBean = new ResponseBean();
		responseBean.setBody(MessageEnum.enumMessage.SUCESS.getMessage());
		return new ResponseEntity(responseBean, org.springframework.http.HttpStatus.OK);

	}

	private ImplementationStrategyDto mapRequestToDto(
			ImplementationStrategyRequestDto implementationStrategyRequestDto) {
		ImplementationStrategyDto implementationStrategyDto = new ImplementationStrategyDto();
		implementationStrategyDto.setId(implementationStrategyRequestDto.getId());
		implementationStrategyDto.setActivityEnum(ImplementationActivity.getValue(implementationStrategyRequestDto.getActivity()));
		implementationStrategyDto.setExpectedResult(implementationStrategyRequestDto.getExpectedResult());
		implementationStrategyDto.setLeadContactDesignation(implementationStrategyRequestDto.getLeadContactDesignation());
		implementationStrategyDto.setLeadContactName(implementationStrategyRequestDto.getLeadContactName());
		implementationStrategyDto.setProjectBackground(new ProjectBackgroundDto());
		implementationStrategyDto.setEndDate(implementationStrategyRequestDto.getEndDate());
		implementationStrategyDto.setStartDate(implementationStrategyRequestDto.getStartDate());
		implementationStrategyDto.setStrategicObjective(implementationStrategyRequestDto.getStrategicObjective());
implementationStrategyDto.setNoOfRequiredResources(implementationStrategyRequestDto.getNoOfRequiredResources());
		return implementationStrategyDto;
	}

	private ImplementationStrategyRequestDto mapDtoToRequestDto(ImplementationStrategyDto implementationStrategyDto) {
		ImplementationStrategyRequestDto implementationStrategyRequestDto = new ImplementationStrategyRequestDto();
		implementationStrategyRequestDto.setId(implementationStrategyDto.getId());
		implementationStrategyRequestDto.setActivity(implementationStrategyDto.getActivityEnum().getNumVal());
		implementationStrategyRequestDto.setExpectedResult(implementationStrategyDto.getExpectedResult());
		implementationStrategyRequestDto.setLeadContactDesignation(implementationStrategyDto.getLeadContactDesignation());
		implementationStrategyRequestDto.setLeadContactName(implementationStrategyDto.getLeadContactName());
		implementationStrategyRequestDto.setEndDate(implementationStrategyDto.getEndDate());
		implementationStrategyRequestDto.setStartDate(implementationStrategyDto.getStartDate());
		implementationStrategyRequestDto.setStrategicObjective(implementationStrategyDto.getStrategicObjective());
		implementationStrategyRequestDto.setNoOfRequiredResources(implementationStrategyDto.getNoOfRequiredResources());

		return implementationStrategyRequestDto;
	}

	private void getProjectBackGround(String id) throws NoRecordsFoundException {
		ProjectBackgroundDto dto = projectService.getById(Long.parseLong(id));
		if (dto == null) {
			throw new NoRecordsFoundException(MessageEnum.enumMessage.NO_RECORDS_BY_PROJECT_ID.getMessage());
		}
	}

}
