package com.rest.smoothchange.training.plan.curriculum.lesson.plan.controller;

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
import com.rest.smoothchange.training.plan.curriculum.lesson.plan.dto.TrainingPlanCurriculumLessonPlanDto;
import com.rest.smoothchange.training.plan.curriculum.lesson.plan.dto.TrainingPlanCurriculumLessonPlanRequestDto;
import com.rest.smoothchange.training.plan.curriculum.lesson.plan.service.TrainingPlanCurriculumLessonPlanService;
import com.rest.smoothchange.training.plan.equipment.dto.TrainingPlanEquipmentDto;
import com.rest.smoothchange.training.plan.equipment.dto.TrainingPlanEquipmentRequestDto;
import com.rest.smoothchange.training.plan.equipment.service.TrainingPlanEquipmentService;
import com.rest.smoothchange.util.DateUtil;



@RestController
@RequestMapping(value = "trainingPlanCurriculumLessonPlanAPI")
@Transactional
public class TrainingPlanCurriculumLessonPlanController {

	private final static String dateFormate= "yyyy-MM-dd";
	
	@Autowired
	private TrainingPlanCurriculumLessonPlanService trainingPlanCurriculumLessonPlanService; 
	
	@Autowired
	private ProjectBackgroundService projectBackgroundService;
	
	
	@RequestMapping(value="createTrainingPlanCurriculumLessonPlan" , method = RequestMethod.POST)
	public ResponseEntity createTrainingPlanCurriculumLessonPlan(@RequestHeader("API-KEY") String apiKey, @RequestBody TrainingPlanCurriculumLessonPlanRequestDto trainingPlanCurriculumLessonPlanRequestDto) throws NoRecordsFoundException, ParseException, UnauthorizedException {
		
		if (!apiKey.equals(MessageEnum.API_KEY)) {
			  throw new UnauthorizedException(MessageEnum.unathorized);
		}

		ResponseBean responseBean = new ResponseBean();
		ProjectBackgroundDto projectBackgroundDto = projectBackgroundService.getById(trainingPlanCurriculumLessonPlanRequestDto.getProjectBackgroundId());
		if(projectBackgroundDto!=null && projectBackgroundDto.getId()!=null) {
			TrainingPlanCurriculumLessonPlanDto trainingPlanCurriculumLessonPlanDto = new TrainingPlanCurriculumLessonPlanDto();
			trainingPlanCurriculumLessonPlanDto.setProjectBackground(projectBackgroundDto);
			trainingPlanCurriculumLessonPlanDto =	mapTrainingPlanCurriculumLessonPlanRequestDtoRequestDtoToDto(trainingPlanCurriculumLessonPlanDto,trainingPlanCurriculumLessonPlanRequestDto);
			Long trainingPlanEquipmentId = (Long)trainingPlanCurriculumLessonPlanService.create(trainingPlanCurriculumLessonPlanDto);
			responseBean.setBody(trainingPlanEquipmentId);
		}else {
			throw new NoRecordsFoundException("Project Not Found");
		}
		return new ResponseEntity(responseBean, HttpStatus.OK);
	}

	
	
	@RequestMapping(value="updateTrainingPlanCurriculumLessonPlan" , method = RequestMethod.POST)
	public ResponseEntity updateTrainingPlanCurriculumLessonPlan(@RequestHeader("API-KEY") String apiKey, @RequestBody TrainingPlanCurriculumLessonPlanRequestDto trainingPlanCurriculumLessonPlanRequestDto, @RequestParam("trainingPlanCurriculumLessonPlanRequestId") long trainingPlanCurriculumLessonPlanRequestId) throws NoRecordsFoundException, ParseException, UnauthorizedException {
		
		if (!apiKey.equals(MessageEnum.API_KEY)) {
			  throw new UnauthorizedException(MessageEnum.unathorized);
		}

		ResponseBean responseBean = new ResponseBean();
		ProjectBackgroundDto projectBackgroundDto = projectBackgroundService.getById(trainingPlanCurriculumLessonPlanRequestDto.getProjectBackgroundId());
		if(projectBackgroundDto!=null && projectBackgroundDto.getId()!=null) {
			TrainingPlanCurriculumLessonPlanDto trainingPlanCurriculumLessonPlanDto = trainingPlanCurriculumLessonPlanService
					.getById(trainingPlanCurriculumLessonPlanRequestId);
			if (trainingPlanCurriculumLessonPlanDto != null && trainingPlanCurriculumLessonPlanDto.getId() != null) {
				trainingPlanCurriculumLessonPlanDto.setProjectBackground(projectBackgroundDto);
				trainingPlanCurriculumLessonPlanDto = mapTrainingPlanCurriculumLessonPlanRequestDtoRequestDtoToDto(trainingPlanCurriculumLessonPlanDto,
						trainingPlanCurriculumLessonPlanRequestDto);
				trainingPlanCurriculumLessonPlanService.update(trainingPlanCurriculumLessonPlanDto);
				responseBean.setBody(MessageEnum.enumMessage.SUCESS.getMessage());
			}else {
				throw new NoRecordsFoundException("Training Plan Curriculum Lesson Plan Not Found");	
			}
		}else {
			throw new NoRecordsFoundException("Project Not Found");
		}
		return new ResponseEntity(responseBean, HttpStatus.OK);
	}

	
	@RequestMapping(value="getTrainingPlanCurriculumLessonPlanById" , method = RequestMethod.GET)
	public ResponseEntity updateTrainingPlanCurriculumLessonPlanById(@RequestHeader("API-KEY") String apiKey, @RequestParam("trainingPlanCurriculumLessonPlanRequestId") long trainingPlanCurriculumLessonPlanRequestId) throws NoRecordsFoundException, ParseException, UnauthorizedException {
		
		if (!apiKey.equals(MessageEnum.API_KEY)) {
			  throw new UnauthorizedException(MessageEnum.unathorized);
		}

		ResponseBean responseBean = new ResponseBean();
		TrainingPlanCurriculumLessonPlanDto trainingPlanCurriculumLessonPlanDto = trainingPlanCurriculumLessonPlanService.getById(trainingPlanCurriculumLessonPlanRequestId);
		if(trainingPlanCurriculumLessonPlanDto!=null && trainingPlanCurriculumLessonPlanDto.getId()!=null) {
			TrainingPlanCurriculumLessonPlanRequestDto trainingPlanCurriculumLessonPlanRequestDto = maptrainingPlanCurriculumLessonPlanDtoToRequestDto(trainingPlanCurriculumLessonPlanDto);
			responseBean.setBody(trainingPlanCurriculumLessonPlanRequestDto);
		}else {
			throw new NoRecordsFoundException("Training Plan Curriculum Lesson Plan Not Found");
		}	
		return new ResponseEntity(responseBean, HttpStatus.OK);
	}
	
	
	@RequestMapping(value="getTrainingPlanCurriculumLessonPlanByProjectId" , method = RequestMethod.GET)
	public ResponseEntity updateTrainingPlanCurriculumLessonPlanByProjectId(@RequestHeader("API-KEY") String apiKey, @RequestParam("projecId") long projecId) throws NoRecordsFoundException, ParseException, UnauthorizedException {
		
		if (!apiKey.equals(MessageEnum.API_KEY)) {
			  throw new UnauthorizedException(MessageEnum.unathorized);
		}
		
		ResponseBean responseBean = new ResponseBean();		
		List<TrainingPlanCurriculumLessonPlanDto> trainingPlanCurriculumLessonPlanList = trainingPlanCurriculumLessonPlanService.getTrainingPlanCurriculumLessonPlanListByProjectId(projecId);
		if(trainingPlanCurriculumLessonPlanList!=null && !trainingPlanCurriculumLessonPlanList.isEmpty()) {
			List<TrainingPlanCurriculumLessonPlanRequestDto> trainingPlanCurriculumLessonPlanRequestDtoList = new ArrayList<>();
			for(TrainingPlanCurriculumLessonPlanDto trainingPlanCurriculumLessonPlanDto : trainingPlanCurriculumLessonPlanList ) {
				trainingPlanCurriculumLessonPlanRequestDtoList.add(maptrainingPlanCurriculumLessonPlanDtoToRequestDto(trainingPlanCurriculumLessonPlanDto));
			}
			responseBean.setBody(trainingPlanCurriculumLessonPlanRequestDtoList);	
		}else {
			throw new NoRecordsFoundException("Training Plan Curriculum Lesson Plan Not Found Not Found");
		}
		return new ResponseEntity(responseBean, HttpStatus.OK);
	}
	
	
	//================= Privete Method ==============
	
	private TrainingPlanCurriculumLessonPlanDto mapTrainingPlanCurriculumLessonPlanRequestDtoRequestDtoToDto(TrainingPlanCurriculumLessonPlanDto trainingPlanCurriculumLessonPlanDto , TrainingPlanCurriculumLessonPlanRequestDto trainingPlanCurriculumLessonPlanRequestDto) throws ParseException {
		if(trainingPlanCurriculumLessonPlanDto!=null && trainingPlanCurriculumLessonPlanRequestDto!=null) {
			trainingPlanCurriculumLessonPlanDto.setCurriculumUnitName(trainingPlanCurriculumLessonPlanRequestDto.getCurriculumUnitName());
			trainingPlanCurriculumLessonPlanDto.setCurriculumUnitNo(trainingPlanCurriculumLessonPlanRequestDto.getCurriculumUnitNo());
			trainingPlanCurriculumLessonPlanDto.setDuration(trainingPlanCurriculumLessonPlanRequestDto.getDuration());
			trainingPlanCurriculumLessonPlanDto.setLessonUnitName(trainingPlanCurriculumLessonPlanRequestDto.getLessonUnitName());
			trainingPlanCurriculumLessonPlanDto.setLessonUnitNo(trainingPlanCurriculumLessonPlanRequestDto.getLessonUnitNo());
		}		
		return trainingPlanCurriculumLessonPlanDto;
	}
	
	private TrainingPlanCurriculumLessonPlanRequestDto maptrainingPlanCurriculumLessonPlanDtoToRequestDto(TrainingPlanCurriculumLessonPlanDto trainingPlanCurriculumLessonPlanDto) throws ParseException {
		TrainingPlanCurriculumLessonPlanRequestDto trainingPlanCurriculumLessonPlanRequestDto = null;
		if (trainingPlanCurriculumLessonPlanDto != null && trainingPlanCurriculumLessonPlanDto.getId() != null) {
			trainingPlanCurriculumLessonPlanRequestDto = new TrainingPlanCurriculumLessonPlanRequestDto();
			if(trainingPlanCurriculumLessonPlanDto.getProjectBackground()!=null && trainingPlanCurriculumLessonPlanDto.getProjectBackground().getId()!=null) {
				trainingPlanCurriculumLessonPlanRequestDto.setProjectBackgroundId(trainingPlanCurriculumLessonPlanDto.getProjectBackground().getId());
			}
			trainingPlanCurriculumLessonPlanRequestDto.setCurriculumUnitName(trainingPlanCurriculumLessonPlanDto.getCurriculumUnitName());
			trainingPlanCurriculumLessonPlanRequestDto.setCurriculumUnitNo(trainingPlanCurriculumLessonPlanDto.getCurriculumUnitNo());
			trainingPlanCurriculumLessonPlanRequestDto.setDuration(trainingPlanCurriculumLessonPlanDto.getDuration());
			trainingPlanCurriculumLessonPlanRequestDto.setLessonUnitName(trainingPlanCurriculumLessonPlanDto.getLessonUnitName());
			trainingPlanCurriculumLessonPlanRequestDto.setLessonUnitNo(trainingPlanCurriculumLessonPlanDto.getLessonUnitNo());
			trainingPlanCurriculumLessonPlanRequestDto.setTrainingPlanCurriculumLessonPlanId(trainingPlanCurriculumLessonPlanDto.getId());						
		}
		return trainingPlanCurriculumLessonPlanRequestDto;
	}
	

}
