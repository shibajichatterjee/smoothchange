package com.rest.smoothchange.training.plan.schedule.controller;

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
import com.rest.framework.exception.NoRecordsFoundException;
import com.rest.framework.exception.UnauthorizedException;
import com.rest.smoothchange.project.background.dto.ProjectBackgroundDto;
import com.rest.smoothchange.project.background.service.ProjectBackgroundService;
import com.rest.smoothchange.training.plan.schedule.dto.TrainingPlanScheduleDto;
import com.rest.smoothchange.training.plan.schedule.dto.TrainingPlanScheduleRequestDto;
import com.rest.smoothchange.training.plan.schedule.service.TrainingPlanScheduleService;
import com.rest.smoothchange.util.DateUtil;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;



@RestController
@RequestMapping(value = "/trainingPlanScheduleAPI")
@Api(value = "Training Plan Schedule", description = "Operations For Training Plan Schedule")

@Transactional
public class TrainingPlanScheduleController {
	
	private final String dateFormate = "yyyy-MM-dd";

	@Autowired
	private TrainingPlanScheduleService trainingPlanScheduleService; 
	
	@Autowired
	private ProjectBackgroundService projectBackgroundService;
	
	@ApiOperation(value = "Add Training Plan Schedule")
	@RequestMapping(value="trainingPlanScheduleCreate" , method = RequestMethod.POST)	
	public ResponseEntity trainingPlanScheduleCreate(@RequestHeader("API-KEY") String apiKey,@RequestParam("projectId") String id, @RequestBody TrainingPlanScheduleRequestDto trainingPlanScheduleRequestDto ) throws NoRecordsFoundException, ParseException, UnauthorizedException {
		
		if (!apiKey.equals(MessageEnum.API_KEY)) {
			throw new UnauthorizedException(MessageEnum.unathorized);
		}
		
		ResponseBean responseBean = new ResponseBean();		
		ProjectBackgroundDto projectBackgroundDto = projectBackgroundService.getById(Long.parseLong(id));
		if(projectBackgroundDto!=null && projectBackgroundDto.getId()!=null) {
			TrainingPlanScheduleDto trainingPlanScheduleDto = new TrainingPlanScheduleDto();
			trainingPlanScheduleDto.setProjectBackground(projectBackgroundDto);
		    trainingPlanScheduleDto = 	mapTrainingPlanScheduleRequestDtoToDto(trainingPlanScheduleDto,trainingPlanScheduleRequestDto);
		    long trainingPlanScheduleId = (Long)trainingPlanScheduleService.create(trainingPlanScheduleDto);
		    responseBean.setBody(trainingPlanScheduleId);
		}else{
			throw new NoRecordsFoundException(MessageEnum.enumMessage.NO_RECORDS_BY_PROJECT_ID.getMessage());
		}	
		return new ResponseEntity(responseBean, HttpStatus.OK);		
	}
	
	@ApiOperation(value = "Modify Training Plan Schedule")
	@RequestMapping(value="trainingPlanScheduleUpdate" , method = RequestMethod.POST)
	public ResponseEntity trainingPlanScheduleModify(@RequestHeader("API-KEY") String apiKey,@RequestParam("projectId") String id, @RequestBody TrainingPlanScheduleRequestDto trainingPlanScheduleRequestDto ) throws NoRecordsFoundException, ParseException, UnauthorizedException {
		
		if (!apiKey.equals(MessageEnum.API_KEY)) {
			throw new UnauthorizedException(MessageEnum.unathorized);
		}
		
		ResponseBean responseBean = new ResponseBean();		
		TrainingPlanScheduleDto trainingPlanScheduleDto = trainingPlanScheduleService.getById(trainingPlanScheduleRequestDto.getTrainingPlanScheduleId());
		if(trainingPlanScheduleDto!=null && trainingPlanScheduleDto.getId()!=null) {
			ProjectBackgroundDto projectBackgroundDto = projectBackgroundService.getById(Long.parseLong(id));
			if(projectBackgroundDto!=null && projectBackgroundDto.getId()!=null) {
				trainingPlanScheduleDto = mapTrainingPlanScheduleRequestDtoToDto(trainingPlanScheduleDto,trainingPlanScheduleRequestDto);
				trainingPlanScheduleDto.setProjectBackground(projectBackgroundDto);
				trainingPlanScheduleService.update(trainingPlanScheduleDto);
			}else {
				throw new NoRecordsFoundException(MessageEnum.enumMessage.NO_RECORDS_BY_PROJECT_ID.getMessage());

			}
		}else{
			throw new NoRecordsFoundException("Training Plan Schedule Not");
		}	
		responseBean.setBody(MessageEnum.enumMessage.SUCESS.getMessage());
		return new ResponseEntity(responseBean, HttpStatus.OK);		
	}
	
	@ApiOperation(value = "Get Training Plan Schedule By ID")
	@RequestMapping(value="getTrainingPlanScheduleById",method = RequestMethod.GET)
	public ResponseEntity getTrainingPlanScheduleById(@RequestHeader("API-KEY") String apiKey, @RequestParam("trainingPlanScheduleById")long trainingPlanScheduleById) throws NoRecordsFoundException, ParseException, UnauthorizedException {
		
		if (!apiKey.equals(MessageEnum.API_KEY)) {
			throw new UnauthorizedException(MessageEnum.unathorized);
		}
		
		TrainingPlanScheduleDto trainingPlanScheduleDto = trainingPlanScheduleService.getById(trainingPlanScheduleById);
		ResponseBean responseBean = new ResponseBean();
		if(trainingPlanScheduleDto!=null && trainingPlanScheduleDto.getId()!=null) {
			TrainingPlanScheduleRequestDto trainingPlanScheduleRequestDto =	mapTrainingPlanScheduleDtoToRequestDto(trainingPlanScheduleDto);
			responseBean.setBody(trainingPlanScheduleRequestDto);
		}else {
			throw new NoRecordsFoundException("Training Plan Schedule Not Found");
		}
		return new ResponseEntity(responseBean, HttpStatus.OK);
	}
	
	@ApiOperation(value = "Get Training Plan Schedule By ProjectID")
	@RequestMapping(value="getTrainingPlanScheduleByProjectId",method = RequestMethod.GET)
	public ResponseEntity getTrainingPlanScheduleByProjectId(@RequestHeader("API-KEY") String apiKey, @RequestParam("projectId")long projectId) throws NoRecordsFoundException, ParseException, UnauthorizedException {	
		
		if (!apiKey.equals(MessageEnum.API_KEY)) {
			throw new UnauthorizedException(MessageEnum.unathorized);
		}
		
		List<TrainingPlanScheduleDto> trainingPlanScheduleList = trainingPlanScheduleService.getTrainingPlanScheduleListByProjectId(projectId);
		ResponseBean responseBean = new ResponseBean();
		if(trainingPlanScheduleList!=null && trainingPlanScheduleList.size()>0) {
		    List<TrainingPlanScheduleRequestDto>	trainingPlanScheduleRequestDtoList = new ArrayList<>();
			for(TrainingPlanScheduleDto trainingPlanScheduleDto : trainingPlanScheduleList) {
				trainingPlanScheduleRequestDtoList.add(mapTrainingPlanScheduleDtoToRequestDto(trainingPlanScheduleDto));
			}
			responseBean.setBody(trainingPlanScheduleRequestDtoList);
		}else {
			throw new NoRecordsFoundException("Training Plan Schedule List Not Found");
		}
		return new ResponseEntity(responseBean, HttpStatus.OK);
	}
	
	//====================== Private method ===============
	
	private TrainingPlanScheduleDto mapTrainingPlanScheduleRequestDtoToDto(TrainingPlanScheduleDto trainingPlanScheduleDto , TrainingPlanScheduleRequestDto trainingPlanScheduleRequestDto ) throws ParseException {
		if(trainingPlanScheduleRequestDto!=null) {
			trainingPlanScheduleDto.setCurriculumCovered(trainingPlanScheduleRequestDto.getCurriculumCovered());
			if(trainingPlanScheduleRequestDto.getDateTime()!=null && !trainingPlanScheduleRequestDto.getDateTime().trim().equals("")) {
			trainingPlanScheduleDto.setDateTime(DateUtil.getFormattedDate(trainingPlanScheduleRequestDto.getDateTime(), dateFormate));
			}
			trainingPlanScheduleDto.setDuration(trainingPlanScheduleRequestDto.getDuration());
			trainingPlanScheduleDto.setInstructor(trainingPlanScheduleRequestDto.getInstructor());
			trainingPlanScheduleDto.setLocation(trainingPlanScheduleRequestDto.getLocation());
			trainingPlanScheduleDto.setSession(trainingPlanScheduleRequestDto.getSession());
			trainingPlanScheduleDto.setId(trainingPlanScheduleRequestDto.getTrainingPlanScheduleId());
		}
		return trainingPlanScheduleDto;
	}
	
	private TrainingPlanScheduleRequestDto mapTrainingPlanScheduleDtoToRequestDto(TrainingPlanScheduleDto trainingPlanScheduleDto) throws ParseException {
		TrainingPlanScheduleRequestDto trainingPlanScheduleRequestDto = new TrainingPlanScheduleRequestDto();
		if(trainingPlanScheduleDto!=null) {
			trainingPlanScheduleRequestDto.setCurriculumCovered(trainingPlanScheduleDto.getCurriculumCovered());
			if(trainingPlanScheduleDto.getDateTime()!=null) {
				trainingPlanScheduleRequestDto.setDateTime(DateUtil.getFormattedDateStringFromDate(trainingPlanScheduleDto.getDateTime(), dateFormate));
			}
			
			trainingPlanScheduleRequestDto.setTrainingPlanScheduleId(trainingPlanScheduleDto.getId());
			trainingPlanScheduleRequestDto.setDuration(trainingPlanScheduleDto.getDuration());
			trainingPlanScheduleRequestDto.setInstructor(trainingPlanScheduleDto.getInstructor());
			trainingPlanScheduleRequestDto.setLocation(trainingPlanScheduleDto.getLocation());
			trainingPlanScheduleRequestDto.setSession(trainingPlanScheduleDto.getSession());
		}
		return trainingPlanScheduleRequestDto;
	}
	
}
