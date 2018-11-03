package com.rest.smoothchange.readiness.category.items.controller;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collections;
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
import com.rest.framework.exception.NoRecordsFoundException;
import com.rest.framework.exception.UnauthorizedException;
import com.rest.smoothchange.action.plan.items.dto.ActionPlanItemsDto;
import com.rest.smoothchange.action.plan.items.dto.ActionPlanItemsRequestDto;
import com.rest.smoothchange.change.readiness.categories.dto.ChangeReadinessCategoriesDto;
import com.rest.smoothchange.change.readiness.categories.dto.ChangeReadinessCategoryrequestDTO;
import com.rest.smoothchange.change.readiness.categories.service.ChangeReadinessCategoriesService;
import com.rest.smoothchange.project.background.dto.ProjectBackgroundDto;
import com.rest.smoothchange.readiness.category.items.dto.ReadinessCategoryItemsDto;
import com.rest.smoothchange.readiness.category.items.dto.ReadinessCategoryItemsRequestDto;
import com.rest.smoothchange.readiness.category.items.service.ReadinessCategoryItemsService;
import com.rest.smoothchange.util.ActionType;
import com.rest.smoothchange.util.CommonUtil;
import com.rest.smoothchange.util.DateUtil;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/readinessCategoryAPI")
@Api(value = "Readiness Category", description = "Operations For Readiness Category")
@Transactional
public class ReadinessCategoryController {
	@Autowired
	private CommonUtil commonUtil;

	@Autowired
	private ReadinessCategoryItemsService readinessCategoryItemService;

	@Autowired
	private ChangeReadinessCategoriesService changeReadinessCategoriesService;

	private static final String dateFormate = "yyyy-MM-dd";

	@ApiOperation(value = "Add Readiness Category")
	@RequestMapping(value = "createReadinessCategory", method = RequestMethod.POST)
	public ResponseEntity createReadinessCategory(@RequestHeader("API-KEY") String apiKey,
			@RequestParam("projectId") long projectId,
			@RequestBody ChangeReadinessCategoryrequestDTO changeReadinessCategoryrequestDTO)
			throws UnauthorizedException, ParseException, NoRecordsFoundException {

		if (!apiKey.equals(MessageEnum.API_KEY)) {
			throw new UnauthorizedException(MessageEnum.unathorized);
		}

		ResponseBean responseBean = new ResponseBean();
		commonUtil.getProjectBackGround(Long.toString(projectId));
		ChangeReadinessCategoriesDto dto = mapRequestToDto(changeReadinessCategoryrequestDTO);
		dto.getProjectBackgroundDto().setId(projectId);
		changeReadinessCategoriesService.create(dto);
		responseBean.setBody(MessageEnum.enumMessage.SUCESS.getMessage());
		return new ResponseEntity(responseBean, org.springframework.http.HttpStatus.OK);
	}

	@ApiOperation(value = "Modify Readiness Category")
	@RequestMapping(value = "modifyReadinessCategory", method = RequestMethod.POST)
	public ResponseEntity modifyReadinessCategory(@RequestHeader("API-KEY") String apiKey,
			@RequestBody ChangeReadinessCategoryrequestDTO changeReadinessCategoryrequestDTO)
			throws UnauthorizedException, ParseException, NoRecordsFoundException {

		if (!apiKey.equals(MessageEnum.API_KEY)) {
			throw new UnauthorizedException(MessageEnum.unathorized);
		}

		ResponseBean responseBean = new ResponseBean();
		ChangeReadinessCategoriesDto dto = changeReadinessCategoriesService.getById(
				changeReadinessCategoryrequestDTO.getId() == null ? 0 : changeReadinessCategoryrequestDTO.getId());
		if (dto == null) {
			throw new NoRecordsFoundException(MessageEnum.enumMessage.NO_RECORDS.getMessage());

		}
		dto.setChangeReadinessCategoryName(changeReadinessCategoryrequestDTO.getChangeReadinessCategoryName());
		changeReadinessCategoriesService.update(dto);
		responseBean.setBody(MessageEnum.enumMessage.SUCESS.getMessage());
		return new ResponseEntity(responseBean, org.springframework.http.HttpStatus.OK);
	}

	@ApiOperation(value = "Get Readiness Category")
	@RequestMapping(value = "getReadinessCategoryByID", method = RequestMethod.GET)
	public ResponseEntity getReadinessCategoryByID(@RequestHeader("API-KEY") String apiKey, @RequestParam("Id") long id)
			throws UnauthorizedException, ParseException, NoRecordsFoundException {

		if (!apiKey.equals(MessageEnum.API_KEY)) {
			throw new UnauthorizedException(MessageEnum.unathorized);
		}

		ResponseBean responseBean = new ResponseBean();
		ChangeReadinessCategoriesDto dto = changeReadinessCategoriesService.getById(id);
		if (dto == null) {
			throw new NoRecordsFoundException(MessageEnum.enumMessage.NO_RECORDS.getMessage());

		}

		responseBean.setBody(mapDtoToRequestDTO(dto));
		return new ResponseEntity(responseBean, org.springframework.http.HttpStatus.OK);
	}

	@ApiOperation(value = "Get Readiness Category By Project")
	@RequestMapping(value = "getReadinessCategoryByProjectID", method = RequestMethod.GET)
	public ResponseEntity getReadinessCategoryByProjectID(@RequestHeader("API-KEY") String apiKey,
			@RequestParam("projectId") long projectId)
			throws UnauthorizedException, ParseException, NoRecordsFoundException {

		if (!apiKey.equals(MessageEnum.API_KEY)) {
			throw new UnauthorizedException(MessageEnum.unathorized);
		}

		ResponseBean responseBean = new ResponseBean();
		List<ChangeReadinessCategoriesDto> dtoList = changeReadinessCategoriesService
				.getChangeReadinessCategoriesListByProjectId(projectId);
		if (dtoList.size() == 0) {
			throw new NoRecordsFoundException(MessageEnum.enumMessage.NO_RECORDS.getMessage());

		}
		List<ChangeReadinessCategoryrequestDTO> requestDtoList = new ArrayList<>();
		for (ChangeReadinessCategoriesDto dto : dtoList) {
			requestDtoList.add(mapDtoToRequestDTO(dto));
		}

		responseBean.setBody(requestDtoList);
		return new ResponseEntity(responseBean, org.springframework.http.HttpStatus.OK);
	}

	@ApiOperation(value = "Delete Readiness Category")
	@RequestMapping(value = "deleteReadinessCategoryByID", method = RequestMethod.DELETE)
	public ResponseEntity deleteReadinessCategoryByID(@RequestHeader("API-KEY") String apiKey,
			@RequestParam("Id") long id) throws UnauthorizedException, ParseException, NoRecordsFoundException {

		if (!apiKey.equals(MessageEnum.API_KEY)) {
			throw new UnauthorizedException(MessageEnum.unathorized);
		}

		ResponseBean responseBean = new ResponseBean();
		ChangeReadinessCategoriesDto dto = changeReadinessCategoriesService.getById(id);
		if (dto == null) {
			throw new NoRecordsFoundException(MessageEnum.enumMessage.NO_RECORDS.getMessage());

		}

		List<ReadinessCategoryItemsDto> dtoList = readinessCategoryItemService
				.getReadinessCategoryItemsListByCategoryIdProjectId(dto.getId(), dto.getProjectBackgroundDto().getId());
		if (dtoList == null || dtoList.size() == 0) {
			changeReadinessCategoriesService.delete(dto);
			responseBean.setBody(MessageEnum.enumMessage.SUCESS.getMessage());
		}
		else
		{
			responseBean.setBody(MessageEnum.enumMessage.NO_DELETE.getMessage());
		}
		
		return new ResponseEntity(responseBean, org.springframework.http.HttpStatus.OK);
	}

	private ChangeReadinessCategoriesDto mapRequestToDto(
			ChangeReadinessCategoryrequestDTO changeReadinessCategoryrequestDTO) {
		ChangeReadinessCategoriesDto dto = new ChangeReadinessCategoriesDto();

		dto.setId(changeReadinessCategoryrequestDTO.getId());
		dto.setChangeReadinessCategoryName(changeReadinessCategoryrequestDTO.getChangeReadinessCategoryName());
		dto.setProjectBackgroundDto(new ProjectBackgroundDto());

		return dto;
	}

	private ChangeReadinessCategoryrequestDTO mapDtoToRequestDTO(
			ChangeReadinessCategoriesDto changeReadinessCategoryDTO) {
		ChangeReadinessCategoryrequestDTO dto = new ChangeReadinessCategoryrequestDTO();

		dto.setId(changeReadinessCategoryDTO.getId());
		dto.setChangeReadinessCategoryName(changeReadinessCategoryDTO.getChangeReadinessCategoryName());

		return dto;
	}

}
