package com.rest.smoothchange.training.plan.roles.responsibilities.controller;

import java.text.ParseException;
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
import com.rest.framework.exception.NoRecordsFoundException;
import com.rest.framework.exception.UnauthorizedException;
import com.rest.smoothchange.project.background.dto.ProjectBackgroundDto;
import com.rest.smoothchange.project.background.service.ProjectBackgroundService;
import com.rest.smoothchange.training.plan.roles.responsibilities.dto.TrainingPlanRolesResponsibilitiesDto;
import com.rest.smoothchange.training.plan.roles.responsibilities.dto.TrainingPlanRolesResponsibilitiesRequestDto;
import com.rest.smoothchange.training.plan.roles.responsibilities.service.TrainingPlanRolesResponsibilitiesService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;



@RestController
@RequestMapping(value = "/trainingPlanRolesResponsibilitiesAPI")
@Api(value = "Rraining Plan Roles Responsibilities", description = "Rraining Plan Roles Responsibilities")
@Transactional
public class TrainingPlanRolesResponsibilitiesController {
	
	@Autowired
	private TrainingPlanRolesResponsibilitiesService trainingPlanRolesResponsibilitiesService;

	@Autowired
	private ProjectBackgroundService projectBackgroundService;
	
	@ApiOperation(value = "Add a Training Plan Roles Responsibilities")
	@RequestMapping(value="addTrainingPlanRolesResponsibilities", method = RequestMethod.POST)
	public ResponseEntity addTrainingPlanRolesResponsibilities(@RequestHeader("API-KEY") String apiKey,@RequestParam("projectId") long projectId , @RequestBody TrainingPlanRolesResponsibilitiesRequestDto trainingPlanRolesResponsibilitiesRequestDto) throws ParseException, UnauthorizedException, NoRecordsFoundException {	
		
		if (!apiKey.equals(MessageEnum.API_KEY)) {
			throw new UnauthorizedException(MessageEnum.unathorized);
		}
		
		ResponseBean responseBean = new ResponseBean();
		ProjectBackgroundDto projectBackgroundDto = projectBackgroundService.getById(projectId);
		if(projectBackgroundDto!=null && projectBackgroundDto.getId()!=null) {	
			TrainingPlanRolesResponsibilitiesDto trainingPlanRolesResponsibilitiesDto = new TrainingPlanRolesResponsibilitiesDto();
			trainingPlanRolesResponsibilitiesDto =	mapTrainingPlanRolesResponsibilitiesRequestDtoToDto(trainingPlanRolesResponsibilitiesDto,trainingPlanRolesResponsibilitiesRequestDto);
			trainingPlanRolesResponsibilitiesDto.setProjectBackground(projectBackgroundDto);
			long trainingPlanVersionHistoryId =  (Long)trainingPlanRolesResponsibilitiesService.create(trainingPlanRolesResponsibilitiesDto);
			responseBean.setBody(trainingPlanVersionHistoryId);
		}else {
			throw new NoRecordsFoundException(MessageEnum.enumMessage.NO_RECORDS.getMessage());
		}	
		return new ResponseEntity(responseBean, org.springframework.http.HttpStatus.OK);	
	}
	
	
	@ApiOperation(value = "Modify a Training Plan Roles Responsibilities")
	@RequestMapping(value="modifyTrainingPlanRolesResponsibilities", method = RequestMethod.POST)
	public ResponseEntity modifyTrainingPlanRolesResponsibilities(@RequestHeader("API-KEY") String apiKey, @RequestParam("projectId") long projectId ,@RequestBody TrainingPlanRolesResponsibilitiesRequestDto trainingPlanRolesResponsibilitiesRequestDto) throws ParseException, UnauthorizedException, NoRecordsFoundException {	
		
		if (!apiKey.equals(MessageEnum.API_KEY)) {
			throw new UnauthorizedException(MessageEnum.unathorized);
		}
		
		ResponseBean responseBean = new ResponseBean();
		TrainingPlanRolesResponsibilitiesDto trainingPlanRolesResponsibilitiesDto = trainingPlanRolesResponsibilitiesService.getById(trainingPlanRolesResponsibilitiesRequestDto.getTrainingPlanRolesResponsibilitiesId());
		if(trainingPlanRolesResponsibilitiesDto!=null && trainingPlanRolesResponsibilitiesDto.getId()!=null) {				
			ProjectBackgroundDto projectBackgroundDto = projectBackgroundService.getById(projectId);
			if(projectBackgroundDto!=null && projectBackgroundDto.getId()!=null) {
				trainingPlanRolesResponsibilitiesDto.setProjectBackground(projectBackgroundDto);
				trainingPlanRolesResponsibilitiesDto =	mapTrainingPlanRolesResponsibilitiesRequestDtoToDto(trainingPlanRolesResponsibilitiesDto,trainingPlanRolesResponsibilitiesRequestDto);				
				trainingPlanRolesResponsibilitiesService.update(trainingPlanRolesResponsibilitiesDto);
			}else {
				throw new NoRecordsFoundException(MessageEnum.enumMessage.NO_RECORDS_BY_PROJECT_ID.getMessage());
			}
			
		}else {
			throw new NoRecordsFoundException(MessageEnum.enumMessage.NO_RECORDS.getMessage());
		}
		responseBean.setBody(MessageEnum.enumMessage.SUCESS.getMessage());
		return new ResponseEntity(responseBean, org.springframework.http.HttpStatus.OK);	
	}

	@ApiOperation(value = "Get Training Plan Roles Responsibilities By Id")
	@RequestMapping(value="getTrainingPlanRolesResponsibilitiesById" , method= RequestMethod.GET)
	public ResponseEntity getTrainingPlanRolesResponsibilitiesById(@RequestHeader("API-KEY") String apiKey, @RequestParam("id") long trainingPlanRolesResponsibilitiesId) throws NoRecordsFoundException, ParseException, UnauthorizedException{
		
		if (!apiKey.equals(MessageEnum.API_KEY)) {
			throw new UnauthorizedException(MessageEnum.unathorized);
		}		
		ResponseBean responseBean = new ResponseBean();
		TrainingPlanRolesResponsibilitiesDto trainingPlanRolesResponsibilitiesDto = trainingPlanRolesResponsibilitiesService
				.getById(trainingPlanRolesResponsibilitiesId);
		if (trainingPlanRolesResponsibilitiesDto != null && trainingPlanRolesResponsibilitiesDto.getId() != null) {
			TrainingPlanRolesResponsibilitiesRequestDto trainingPlanRolesResponsibilitiesRequestDto = mapTrainingPlanRolesResponsibilitiesDtoToRequestDto(trainingPlanRolesResponsibilitiesDto);
			responseBean.setBody(trainingPlanRolesResponsibilitiesRequestDto);
		} else {
			throw new NoRecordsFoundException(MessageEnum.enumMessage.NO_RECORDS.getMessage());
		}
		return new ResponseEntity(responseBean, org.springframework.http.HttpStatus.OK);
	}
	
	@ApiOperation(value = "Get Training Plan Roles Responsibilities By Project Id")
	@RequestMapping(value="getTrainingPlanRolesResponsibilitiesByProjectId" , method= RequestMethod.GET)
	public ResponseEntity getTrainingPlanVersionHistoryByProjectId(@RequestHeader("API-KEY") String apiKey, @RequestParam("projectId") long projectId) throws NoRecordsFoundException, ParseException, UnauthorizedException{
		
		if (!apiKey.equals(MessageEnum.API_KEY)) {
			throw new UnauthorizedException(MessageEnum.unathorized);
		}
		
		ResponseBean responseBean = new ResponseBean();
		List<TrainingPlanRolesResponsibilitiesRequestDto> trainingPlanRolesResponsibilitiesRequestDtoList = new ArrayList<>();
		List<TrainingPlanRolesResponsibilitiesDto> trainingPlanRolesResponsibilitiesDtoList = trainingPlanRolesResponsibilitiesService.getTrainingPlanRolesResponsibilitiesListByProjectId(projectId);
		if (trainingPlanRolesResponsibilitiesDtoList!=null && trainingPlanRolesResponsibilitiesDtoList.size()>0) {
			for(TrainingPlanRolesResponsibilitiesDto trainingPlanRolesResponsibilitiesDto : trainingPlanRolesResponsibilitiesDtoList) {
				trainingPlanRolesResponsibilitiesRequestDtoList.add(mapTrainingPlanRolesResponsibilitiesDtoToRequestDto(trainingPlanRolesResponsibilitiesDto));
			}
			responseBean.setBody(trainingPlanRolesResponsibilitiesRequestDtoList);			
		} else {
			throw new NoRecordsFoundException(MessageEnum.enumMessage.NO_RECORDS_BY_PROJECT_ID.getMessage());
		}
		return new ResponseEntity(responseBean, org.springframework.http.HttpStatus.OK);
	}
	
	@ApiOperation(value = "Delete Training Plan Roles Responsibilities by Id")
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/deleteTrainingPlanRolesResponsibilities", method = RequestMethod.DELETE)
	public ResponseEntity deleteStakeHolderById(@RequestHeader("API-KEY") String apiKey, @RequestParam("id") long id) throws UnauthorizedException, NoRecordsFoundException {

		if (!apiKey.equals(MessageEnum.API_KEY)) {
			throw new UnauthorizedException(MessageEnum.unathorized);
		}

		TrainingPlanRolesResponsibilitiesDto trainingPlanRolesResponsibilitiesDto = trainingPlanRolesResponsibilitiesService
				.getById(id);

		if (trainingPlanRolesResponsibilitiesDto != null && trainingPlanRolesResponsibilitiesDto.getId() != null) {
			trainingPlanRolesResponsibilitiesService.delete(trainingPlanRolesResponsibilitiesDto);
		} else {
			throw new NoRecordsFoundException(MessageEnum.enumMessage.NO_RECORDS.getMessage());
		}

		ResponseBean responseBean = new ResponseBean();
		responseBean.setBody(MessageEnum.enumMessage.SUCESS.getMessage());
		return new ResponseEntity(responseBean, org.springframework.http.HttpStatus.OK);
	}
	
	
	//========================= Private Methods  ===================
	
	private TrainingPlanRolesResponsibilitiesDto mapTrainingPlanRolesResponsibilitiesRequestDtoToDto(TrainingPlanRolesResponsibilitiesDto trainingPlanRolesResponsibilitiesDto,TrainingPlanRolesResponsibilitiesRequestDto trainingPlanRolesResponsibilitiesRequestDto) throws ParseException {
		if(trainingPlanRolesResponsibilitiesRequestDto!=null) {
			trainingPlanRolesResponsibilitiesDto.setName(trainingPlanRolesResponsibilitiesRequestDto.getName());
			trainingPlanRolesResponsibilitiesDto.setResponsibility(trainingPlanRolesResponsibilitiesRequestDto.getResponsibility());
			trainingPlanRolesResponsibilitiesDto.setRole(trainingPlanRolesResponsibilitiesRequestDto.getName());
		}		
		return trainingPlanRolesResponsibilitiesDto;
	}
	
	private TrainingPlanRolesResponsibilitiesRequestDto mapTrainingPlanRolesResponsibilitiesDtoToRequestDto(TrainingPlanRolesResponsibilitiesDto trainingPlanRolesResponsibilitiesDto) throws ParseException {
		TrainingPlanRolesResponsibilitiesRequestDto trainingPlanRolesResponsibilitiesRequestDto = null;
		if(trainingPlanRolesResponsibilitiesDto!=null) {
			trainingPlanRolesResponsibilitiesRequestDto = new TrainingPlanRolesResponsibilitiesRequestDto();
			trainingPlanRolesResponsibilitiesRequestDto.setTrainingPlanRolesResponsibilitiesId(trainingPlanRolesResponsibilitiesDto.getId());
			trainingPlanRolesResponsibilitiesRequestDto.setResponsibility(trainingPlanRolesResponsibilitiesDto.getResponsibility());
			trainingPlanRolesResponsibilitiesRequestDto.setRole(trainingPlanRolesResponsibilitiesDto.getRole());
			trainingPlanRolesResponsibilitiesRequestDto.setName(trainingPlanRolesResponsibilitiesDto.getName());		
		}
		return trainingPlanRolesResponsibilitiesRequestDto;
	}

}
