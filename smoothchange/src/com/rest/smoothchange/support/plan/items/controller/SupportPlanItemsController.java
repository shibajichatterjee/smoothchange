package com.rest.smoothchange.support.plan.items.controller;

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
import com.rest.smoothchange.project.background.dto.ProjectBackgroundDto;
import com.rest.smoothchange.support.plan.items.dto.SupportPlanItemsDto;
import com.rest.smoothchange.support.plan.items.dto.SupportPlanItemsRequestDto;
import com.rest.smoothchange.support.plan.items.service.SupportPlanItemsService;
import com.rest.smoothchange.util.CommonUtil;
import com.rest.smoothchange.util.SupportedStackHolderStatus;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/supportPlanItemAPI")
@Api(value = "Support Plan", description = "Operations For Support Plan")

@Transactional
public class SupportPlanItemsController {

	@Autowired
	private SupportPlanItemsService supportPlanItemService;
	@Autowired
	private CommonUtil commonUtil;

	@ApiOperation(value = "Add Support Plan")
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/AddSupportPlan", method = RequestMethod.POST)
	public ResponseEntity create(@RequestHeader("API-KEY") String apiKey, @RequestParam("projectId") String id,
			@RequestBody SupportPlanItemsRequestDto supportPlanItemsRequestDto)
			throws NoEnumRecordsFoundException, UnauthorizedException, NoRecordsFoundException {
		if (!apiKey.equals(MessageEnum.API_KEY)) {
			throw new UnauthorizedException(MessageEnum.unathorized);
		}
		SupportedStackHolderStatus supportedStackHolderStatus = SupportedStackHolderStatus
				.getValue(supportPlanItemsRequestDto.getSupportedStackHolderStatus());
		if (supportedStackHolderStatus == null) {

			throw new NoEnumRecordsFoundException("Supported StackHolder Status not matched");
		}
		SupportPlanItemsDto dto=new SupportPlanItemsDto();
		commonUtil.getProjectBackGround(id);
		dto = mapRequestToDto(dto,supportPlanItemsRequestDto);
		dto.setProjectBackgroundDto(new ProjectBackgroundDto());

		dto.getProjectBackgroundDto().setId(Long.parseLong(id));
		supportPlanItemService.create(dto);
		ResponseBean responseBean = new ResponseBean();
		responseBean.setBody(MessageEnum.enumMessage.SUCESS.getMessage());
		return new ResponseEntity(responseBean, org.springframework.http.HttpStatus.OK);

	}

	@ApiOperation(value = "Modify Support Plan")
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/ModifySupportPlan", method = RequestMethod.POST)
	public ResponseEntity modify(@RequestHeader("API-KEY") String apiKey, @RequestBody SupportPlanItemsRequestDto supportPlanItemsRequestDto)
			throws NoEnumRecordsFoundException, UnauthorizedException, NoRecordsFoundException {
		if (!apiKey.equals(MessageEnum.API_KEY)) {
			throw new UnauthorizedException(MessageEnum.unathorized);
		}
		SupportedStackHolderStatus supportedStackHolderStatus = SupportedStackHolderStatus
				.getValue(supportPlanItemsRequestDto.getSupportedStackHolderStatus());
		if (supportedStackHolderStatus == null) {

			throw new NoEnumRecordsFoundException("Supported StackHolder Status not matched");
		}

		//commonUtil.getProjectBackGround(id);
		SupportPlanItemsDto dto =supportPlanItemService.getById(supportPlanItemsRequestDto.getId()==null?0:supportPlanItemsRequestDto.getId());
		if (dto == null) {
			throw new NoRecordsFoundException(MessageEnum.enumMessage.NO_RECORDS.getMessage()+"For this Support Plan ID");

		}
		dto = mapRequestToDto(dto,supportPlanItemsRequestDto);
		//dto.getProjectBackgroundDto().setId(Long.parseLong(id));
		supportPlanItemService.update(dto);
		ResponseBean responseBean = new ResponseBean();
		responseBean.setBody(MessageEnum.enumMessage.SUCESS.getMessage());
		return new ResponseEntity(responseBean, org.springframework.http.HttpStatus.OK);

	}

	@ApiOperation(value = "Get Support Plan by Id and Project Id")
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/GetSupportPlanById", method = RequestMethod.GET)
	public ResponseEntity getSupportPlanById(@RequestHeader("API-KEY") String apiKey,
			 @RequestParam("id") String id)
			throws NoRecordsFoundException, UnauthorizedException {
		if (!apiKey.equals(MessageEnum.API_KEY)) {
			throw new UnauthorizedException(MessageEnum.unathorized);
		}
		//commonUtil.getProjectBackGround(projectId);
		SupportPlanItemsDto dto = new SupportPlanItemsDto();
		dto.setId(Long.parseLong(id));
		//dto.setProjectBackgroundDto(new ProjectBackgroundDto());
		//dto.getProjectBackgroundDto().setId(Long.parseLong(projectId));
		dto = supportPlanItemService.getById(dto.getId());
		if (dto == null) {
			throw new NoRecordsFoundException(MessageEnum.enumMessage.NO_RECORDS.getMessage());
		}
		ResponseBean responseBean = new ResponseBean();
		responseBean.setBody(mapDtoToRequestDto(dto));
		return new ResponseEntity(responseBean, org.springframework.http.HttpStatus.OK);

	}

	@ApiOperation(value = "Get Support Plan by Project Id")
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/GetSupportPlanByProjectId", method = RequestMethod.GET)
	public ResponseEntity getSupportPlanByProjectId(@RequestHeader("API-KEY") String apiKey,
			@RequestParam("projectId") String projectId) throws NoRecordsFoundException, UnauthorizedException {
		if (!apiKey.equals(MessageEnum.API_KEY)) {
			throw new UnauthorizedException(MessageEnum.unathorized);
		}
		List<SupportPlanItemsRequestDto> requestDtoList = new ArrayList<>();
		commonUtil.getProjectBackGround(projectId);
		List<SupportPlanItemsDto> dto = supportPlanItemService
				.getSupportPlanItemsListByProjectId(Long.parseLong(projectId));
		if (dto == null || dto.size() == 0) {
			throw new NoRecordsFoundException(MessageEnum.enumMessage.NO_RECORDS.getMessage());
		}
		for (SupportPlanItemsDto supportPlanItemsDto : dto) {
			requestDtoList.add(mapDtoToRequestDto(supportPlanItemsDto));
		}
		ResponseBean responseBean = new ResponseBean();
		responseBean.setBody(requestDtoList);
		return new ResponseEntity(responseBean, org.springframework.http.HttpStatus.OK);

	}
	
	@ApiOperation(value = "Delete Support Plan by Id")
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/DeleteSupportPlanById", method = RequestMethod.DELETE)
	public ResponseEntity deleteSupportPlanById(@RequestHeader("API-KEY") String apiKey,@RequestParam("id") String id) throws UnauthorizedException, NoRecordsFoundException {
		if(!apiKey.equals(MessageEnum.API_KEY))
		{
			throw new UnauthorizedException(MessageEnum.unathorized);
		}
		SupportPlanItemsDto dto=supportPlanItemService.getById(Long.parseLong(id));
		if(dto==null)
		{
			throw new NoRecordsFoundException(MessageEnum.enumMessage.ID_NOT_VALID.getMessage());

		}
		supportPlanItemService.deleteById(Long.parseLong(id));

		ResponseBean responseBean = new ResponseBean();
		responseBean.setBody(MessageEnum.enumMessage.SUCESS.getMessage());
		return new ResponseEntity(responseBean, org.springframework.http.HttpStatus.OK);

	}

	private SupportPlanItemsDto mapRequestToDto(SupportPlanItemsDto supportPlanItemsDto,SupportPlanItemsRequestDto supportPlanItemsRequestDto) {
		supportPlanItemsDto.setSupportActivity(supportPlanItemsRequestDto.getSupportActivity());
		supportPlanItemsDto.setDuration(supportPlanItemsRequestDto.getDuration());
		supportPlanItemsDto.setSupportedStackHolderStatusObj(
				SupportedStackHolderStatus.getValue(supportPlanItemsRequestDto.getSupportedStackHolderStatus()));
		supportPlanItemsDto.setPersonResponsible(supportPlanItemsRequestDto.getPersonResponsible());
		supportPlanItemsDto.setComments(supportPlanItemsRequestDto.getComments());
		supportPlanItemsDto.setId(supportPlanItemsRequestDto.getId());
		return supportPlanItemsDto;
	}

	private SupportPlanItemsRequestDto mapDtoToRequestDto(SupportPlanItemsDto supportPlanItemsDto) {
		SupportPlanItemsRequestDto supportPlanItemsRequestDto = new SupportPlanItemsRequestDto();
		supportPlanItemsRequestDto.setComments(supportPlanItemsDto.getComments());
		supportPlanItemsRequestDto.setDuration(supportPlanItemsDto.getDuration());
		supportPlanItemsRequestDto
				.setSupportedStackHolderStatus(supportPlanItemsDto.getSupportedStackHolderStatusObj().getNumVal());
		supportPlanItemsRequestDto.setSupportActivity(supportPlanItemsDto.getSupportActivity());
		supportPlanItemsRequestDto.setPersonResponsible(supportPlanItemsDto.getPersonResponsible());
		supportPlanItemsRequestDto.setId(supportPlanItemsDto.getId());
		return supportPlanItemsRequestDto;
	}

}
