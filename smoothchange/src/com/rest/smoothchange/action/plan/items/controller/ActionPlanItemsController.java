package com.rest.smoothchange.action.plan.items.controller;

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
import com.rest.smoothchange.action.plan.items.dto.ActionPlanItemsDto;
import com.rest.smoothchange.action.plan.items.dto.ActionPlanItemsRequestDto;
import com.rest.smoothchange.action.plan.items.service.ActionPlanItemsService;
import com.rest.smoothchange.project.background.dto.ProjectBackgroundDto;
import com.rest.smoothchange.util.ActionType;
import com.rest.smoothchange.util.CommonUtil;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/actionPlanItemsAPI")
@Api(value = "Action Plan Items", description = "Operations For Action Plan Items")
@Transactional
public class ActionPlanItemsController {

	@Autowired
	private ActionPlanItemsService actionPlanItemsService;
	@Autowired
	private CommonUtil commonUtil;

	@ApiOperation(value = "Add Action Plan Item")
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/AddActionPlanItem", method = RequestMethod.POST)
	public ResponseEntity create(@RequestHeader("API-KEY") String apiKey, @RequestParam("projectId") String id,
			@RequestBody ActionPlanItemsRequestDto actionPlanItemsRequestDto)
			throws NoEnumRecordsFoundException, UnauthorizedException, NoRecordsFoundException {
		if (!apiKey.equals(MessageEnum.API_KEY)) {
			throw new UnauthorizedException(MessageEnum.unathorized);
		}
		ActionType actionType = ActionType.getValue(actionPlanItemsRequestDto.getActionType());
		if (actionType == null) {

			throw new NoEnumRecordsFoundException("ActionType not matched");
		}
		commonUtil.getProjectBackGround(id);
		ActionPlanItemsDto dto=new ActionPlanItemsDto();
		dto = mapRequestToDto(dto,actionPlanItemsRequestDto);
		dto.getProjectBackground().setId(Long.parseLong(id));
		actionPlanItemsService.create(dto);

		ResponseBean responseBean = new ResponseBean();
		responseBean.setBody(MessageEnum.enumMessage.SUCESS.getMessage());
		return new ResponseEntity(responseBean, org.springframework.http.HttpStatus.OK);

	}

	@ApiOperation(value = "Modify Action Plan Item")
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/ModifyActionPlanItem", method = RequestMethod.POST)
	public ResponseEntity update(@RequestHeader("API-KEY") String apiKey,
			@RequestBody ActionPlanItemsRequestDto actionPlanItemsRequestDto)
			throws NoEnumRecordsFoundException, UnauthorizedException, NoRecordsFoundException {
		if (!apiKey.equals(MessageEnum.API_KEY)) {
			throw new UnauthorizedException(MessageEnum.unathorized);
		}
		ActionType actionType = ActionType.getValue(actionPlanItemsRequestDto.getActionType());
		if (actionType == null) {

			throw new NoEnumRecordsFoundException("ActionType not matched");
		}
		//commonUtil.getProjectBackGround(id);
		ActionPlanItemsDto dto=actionPlanItemsService.getById(actionPlanItemsRequestDto.getId()==null?0:actionPlanItemsRequestDto.getId());
		if (dto == null) {
			throw new NoRecordsFoundException(MessageEnum.enumMessage.NO_RECORDS.getMessage()+"For this Action Plan ID");

		}
		 mapRequestToDto(dto,actionPlanItemsRequestDto);
		//dto.getProjectBackground().setId(Long.parseLong(id));
		actionPlanItemsService.update(dto);

		ResponseBean responseBean = new ResponseBean();
		responseBean.setBody(MessageEnum.enumMessage.SUCESS.getMessage());
		return new ResponseEntity(responseBean, org.springframework.http.HttpStatus.OK);

	}

	@ApiOperation(value = "Get Action Plan Item by Id")
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/GetActionPlanItemById", method = RequestMethod.GET)
	public ResponseEntity getActionPlanItemById(@RequestHeader("API-KEY") String apiKey,
			 @RequestParam("id") String id)
			throws NoRecordsFoundException, UnauthorizedException {
		if (!apiKey.equals(MessageEnum.API_KEY)) {
			throw new UnauthorizedException(MessageEnum.unathorized);
		}
		//commonUtil.getProjectBackGround(projectId);
		ActionPlanItemsDto dto = new ActionPlanItemsDto();
		dto.setId(Long.parseLong(id));
		//dto.setProjectBackground(new ProjectBackgroundDto());
		//dto.getProjectBackground().setId(Long.parseLong(projectId));
		dto = actionPlanItemsService.getById(dto.getId());
		if (dto == null) {
			throw new NoRecordsFoundException(MessageEnum.enumMessage.NO_RECORDS.getMessage());
		}
		ResponseBean responseBean = new ResponseBean();
		responseBean.setBody(mapDtoToRequestDto(dto));
		return new ResponseEntity(responseBean, org.springframework.http.HttpStatus.OK);

	}

	@ApiOperation(value = "Get Action Plan Item by Project Id")
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/GetActionPlanItemByProjectId", method = RequestMethod.GET)
	public ResponseEntity GetActionPlanItemByProjectId(@RequestHeader("API-KEY") String apiKey,
			@RequestParam("projectId") String projectId) throws NoRecordsFoundException, UnauthorizedException {
		if (!apiKey.equals(MessageEnum.API_KEY)) {
			throw new UnauthorizedException(MessageEnum.unathorized);
		}
		commonUtil.getProjectBackGround(projectId);
		List<ActionPlanItemsRequestDto> dtoRequestList = new ArrayList<>();
		// dto.setProjectBackground(new ProjectBackgroundDto());
		// dto.getProjectBackground().setId(Long.parseLong(projectId));
		List<ActionPlanItemsDto> dtoList = actionPlanItemsService
				.getActionPlanItemsListByProjectId(Long.parseLong(projectId));
		if (dtoList == null || dtoList.size() == 0) {
			throw new NoRecordsFoundException(MessageEnum.enumMessage.NO_RECORDS.getMessage());
		}
		for (ActionPlanItemsDto to : dtoList) {
			dtoRequestList.add(mapDtoToRequestDto(to));
		}

		ResponseBean responseBean = new ResponseBean();
		responseBean.setBody(dtoRequestList);
		return new ResponseEntity(responseBean, org.springframework.http.HttpStatus.OK);

	}

	@ApiOperation(value = "Delete Action Plan Item by Id")
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/DeleteActionPlanItemById", method = RequestMethod.DELETE)
	public ResponseEntity deleteActionPlanItemById(@RequestHeader("API-KEY") String apiKey,
			@RequestParam("id") String id) throws UnauthorizedException, NoRecordsFoundException {
		if (!apiKey.equals(MessageEnum.API_KEY)) {
			throw new UnauthorizedException(MessageEnum.unathorized);
		}
		ActionPlanItemsDto dto = actionPlanItemsService.getById(Long.parseLong(id));
		if (dto == null) {
			throw new NoRecordsFoundException(MessageEnum.enumMessage.NO_RECORDS.getMessage());
		}
		actionPlanItemsService.deleteById(Long.parseLong(id));
		ResponseBean responseBean = new ResponseBean();
		responseBean.setBody(MessageEnum.enumMessage.SUCESS.getMessage());
		return new ResponseEntity(responseBean, org.springframework.http.HttpStatus.OK);

	}

	private ActionPlanItemsDto mapRequestToDto(ActionPlanItemsDto dto,ActionPlanItemsRequestDto actionPlanItemsRequestDto) {
		if(dto==null)
		{
			dto=new ActionPlanItemsDto();
		}
		
		dto.setAction(actionPlanItemsRequestDto.getAction());
		dto.setActionType(ActionType.getValue(actionPlanItemsRequestDto.getActionType()));
		dto.setId(actionPlanItemsRequestDto.getId());
		dto.setProjectBackground(new ProjectBackgroundDto());
		dto.setResponsible(actionPlanItemsRequestDto.getResponsible());
		dto.setTimeFrame(actionPlanItemsRequestDto.getTimeframe());

		return dto;
	}

	private ActionPlanItemsRequestDto mapDtoToRequestDto(ActionPlanItemsDto actionPlanItemsDto) {
		ActionPlanItemsRequestDto dto = new ActionPlanItemsRequestDto();
		dto.setAction(actionPlanItemsDto.getAction());
		dto.setActionType(actionPlanItemsDto.getActionType().getNumVal());
		dto.setId(actionPlanItemsDto.getId());
		dto.setResponsible(actionPlanItemsDto.getResponsible());
		dto.setTimeframe(actionPlanItemsDto.getTimeFrame());

		return dto;
	}

}
