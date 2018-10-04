package com.rest.smoothchange.project.stakeholders.controller;

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
import com.rest.smoothchange.project.background.service.ProjectBackgroundService;
import com.rest.smoothchange.project.stakeholders.dto.ProjectStackeHolderRequestDto;
import com.rest.smoothchange.project.stakeholders.dto.ProjectStakeholdersDto;
import com.rest.smoothchange.project.stakeholders.service.ProjectStakeholdersService;
import com.rest.smoothchange.util.EngagementStrategy;
import com.rest.smoothchange.util.LevelOfInfluence;
import com.rest.smoothchange.util.StakeholderType;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/stakeHolderAPI")
@Api(value = "Project Stake Holder", description = "Operations For Project Stakeholder")
@Transactional
public class ProjectStakeholdersController {

	@Autowired
	private ProjectStakeholdersService projectStakeholdersService;
	@Autowired
	private ProjectBackgroundService projectService;

	@ApiOperation(value = "Add a project stakeholder")
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/AddProjectStakeHolder", method = RequestMethod.POST)
	public ResponseEntity create(@RequestHeader("API-KEY") String apiKey, @RequestParam("projectId") String id,
			@RequestBody ProjectStackeHolderRequestDto projDto)
			throws NoEnumRecordsFoundException, UnauthorizedException, NoRecordsFoundException {
		if (!apiKey.equals(MessageEnum.API_KEY)) {
			throw new UnauthorizedException(MessageEnum.unathorized);
		}
		StakeholderType type = StakeholderType.getValue(projDto.getStakeholderType());
		if (type == null) {

			throw new NoEnumRecordsFoundException(MessageEnum.stakeHolderType);
		}
		LevelOfInfluence levelOfInfluence = LevelOfInfluence.getValue(projDto.getLevelOfInfluence());
		if (levelOfInfluence == null) {

			throw new NoEnumRecordsFoundException(MessageEnum.levelOfInfluence);
		}
		EngagementStrategy engagementStrategy = EngagementStrategy.getValue(projDto.getEngagementStrategy());
		if (engagementStrategy == null) {

			throw new NoEnumRecordsFoundException("Engagement strategy not matched");
		}
		getProjectBackGround(id);
		ProjectStakeholdersDto dto = mapRequestToDto(projDto);
		dto.getProjectBackground().setId(Long.parseLong(id));
		projectStakeholdersService.create(dto);
		ResponseBean responseBean = new ResponseBean();
		responseBean.setBody(MessageEnum.enumMessage.SUCESS.getMessage());
		return new ResponseEntity(responseBean, org.springframework.http.HttpStatus.OK);

	}

	@ApiOperation(value = "Modify a project stakeholder")
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/ModifyProjectStakeHolder", method = RequestMethod.POST)
	public ResponseEntity modify(@RequestHeader("API-KEY") String apiKey, @RequestParam("projectId") String id,
			@RequestBody ProjectStackeHolderRequestDto projDto)
			throws NoEnumRecordsFoundException, UnauthorizedException, NoRecordsFoundException {
		if (!apiKey.equals(MessageEnum.API_KEY)) {
			throw new UnauthorizedException(MessageEnum.unathorized);
		}
		StakeholderType type = StakeholderType.getValue(projDto.getStakeholderType());
		if (type == null) {

			throw new NoEnumRecordsFoundException(MessageEnum.stakeHolderType);
		}
		LevelOfInfluence levelOfInfluence = LevelOfInfluence.getValue(projDto.getLevelOfInfluence());
		if (levelOfInfluence == null) {

			throw new NoEnumRecordsFoundException(MessageEnum.levelOfInfluence);
		}
		EngagementStrategy engagementStrategy = EngagementStrategy.getValue(projDto.getEngagementStrategy());
		if (engagementStrategy == null) {

			throw new NoEnumRecordsFoundException("Engagement strategy not matched");
		}
		getProjectBackGround(id);
		ProjectStakeholdersDto dto = mapRequestToDto(projDto);
		dto.getProjectBackground().setId(Long.parseLong(id));
		projectStakeholdersService.update(dto);
		ResponseBean responseBean = new ResponseBean();
		responseBean.setBody(MessageEnum.enumMessage.SUCESS.getMessage());
		return new ResponseEntity(responseBean, org.springframework.http.HttpStatus.OK);

	}

	@ApiOperation(value = "Get project stake holder by Id and Project Id")
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/GetStakeHolderByIdandProjectId", method = RequestMethod.GET)
	public ResponseEntity getStakeHolderByIdandProjectId(@RequestHeader("API-KEY") String apiKey,
			@RequestParam("projectId") String projectId, @RequestParam("id") String id)
			throws NoRecordsFoundException, UnauthorizedException {
		if (!apiKey.equals(MessageEnum.API_KEY)) {
			throw new UnauthorizedException(MessageEnum.unathorized);
		}
		getProjectBackGround(projectId);
		ProjectStakeholdersDto dto = new ProjectStakeholdersDto();
		dto.setId(Long.parseLong(id));
		dto.setProjectBackground(new ProjectBackgroundDto());
		dto.getProjectBackground().setId(Long.parseLong(projectId));
		dto = projectStakeholdersService.getStakeHolderByIdProjectId(dto);
		if (dto == null) {
			throw new NoRecordsFoundException(MessageEnum.enumMessage.NO_RECORDS.getMessage());
		}
		ResponseBean responseBean = new ResponseBean();
		responseBean.setBody(mapDtoToRequestDto(dto));
		return new ResponseEntity(responseBean, org.springframework.http.HttpStatus.OK);

	}

	@ApiOperation(value = "Get project stake holder by Project Id")
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/GetStakeHolderByProjectId", method = RequestMethod.GET)
	public ResponseEntity getStakeHolderByProjectId(@RequestHeader("API-KEY") String apiKey,
			@RequestParam("projectId") String projectId) throws NoRecordsFoundException, UnauthorizedException {
		if (!apiKey.equals(MessageEnum.API_KEY)) {
			throw new UnauthorizedException(MessageEnum.unathorized);
		}
		List<ProjectStackeHolderRequestDto> requestDtoList = new ArrayList<>();
		getProjectBackGround(projectId);

		List<ProjectStakeholdersDto> dto = projectStakeholdersService
				.getStakeHolderListByProjectId(Long.parseLong(projectId));
		if (dto == null || dto.size() == 0) {
			throw new NoRecordsFoundException(MessageEnum.enumMessage.NO_RECORDS.getMessage());
		}
		for (ProjectStakeholdersDto projectStakeholdersDto : dto) {
			requestDtoList.add(mapDtoToRequestDto(projectStakeholdersDto));
		}
		ResponseBean responseBean = new ResponseBean();
		responseBean.setBody(requestDtoList);
		return new ResponseEntity(responseBean, org.springframework.http.HttpStatus.OK);

	}
	
	@ApiOperation(value = "Delete project stake holder by Id")
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/DeleteStakeHolderById", method = RequestMethod.DELETE)
	public ResponseEntity deleteStakeHolderById(@RequestHeader("API-KEY") String apiKey,@RequestParam("id") String id) throws UnauthorizedException {
		if(!apiKey.equals(MessageEnum.API_KEY))
		{
			throw new UnauthorizedException(MessageEnum.unathorized);
		}
		projectStakeholdersService.deleteById(Long.parseLong(id));
		ResponseBean responseBean = new ResponseBean();
		responseBean.setBody(MessageEnum.enumMessage.SUCESS.getMessage());
		return new ResponseEntity(responseBean, org.springframework.http.HttpStatus.OK);

	}

	private ProjectStakeholdersDto mapRequestToDto(ProjectStackeHolderRequestDto rdto) {
		ProjectStakeholdersDto projectStakeholdersDto = new ProjectStakeholdersDto();
		projectStakeholdersDto.setEngagementStrategy(rdto.getEngagementStrategy());
		projectStakeholdersDto.setId(rdto.getId());
		projectStakeholdersDto.setLevelOfInfluence(rdto.getLevelOfInfluence());
		projectStakeholdersDto.setLocation(rdto.getLocation());
		projectStakeholdersDto.setNumberImpacted(rdto.getNumberImpacted());
		projectStakeholdersDto.setRole(rdto.getRole());
		projectStakeholdersDto.setStakeholderName(rdto.getStakeholderName());
		projectStakeholdersDto.setStakeholderType(rdto.getStakeholderType());
		projectStakeholdersDto.setProjectBackground(new ProjectBackgroundDto());
		return projectStakeholdersDto;
	}

	private ProjectStackeHolderRequestDto mapDtoToRequestDto(ProjectStakeholdersDto rdto) {
		ProjectStackeHolderRequestDto projectStakeholdersDto = new ProjectStackeHolderRequestDto();
		projectStakeholdersDto.setEngagementStrategy(rdto.getEngagementStrategy());
		projectStakeholdersDto.setId(rdto.getId());
		projectStakeholdersDto.setLevelOfInfluence(rdto.getLevelOfInfluence());
		projectStakeholdersDto.setLocation(rdto.getLocation());
		projectStakeholdersDto.setNumberImpacted(rdto.getNumberImpacted());
		projectStakeholdersDto.setRole(rdto.getRole());
		projectStakeholdersDto.setStakeholderName(rdto.getStakeholderName());
		projectStakeholdersDto.setStakeholderType(rdto.getStakeholderType());
		return projectStakeholdersDto;
	}

	private void getProjectBackGround(String id) throws NoRecordsFoundException {
		ProjectBackgroundDto dto = projectService.getById(Long.parseLong(id));
		if (dto == null) {
			throw new NoRecordsFoundException(MessageEnum.enumMessage.NO_RECORDS_BY_PROJECT_ID.getMessage());
		}
	}

}
