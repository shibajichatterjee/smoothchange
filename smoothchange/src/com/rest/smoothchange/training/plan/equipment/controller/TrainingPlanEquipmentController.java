package com.rest.smoothchange.training.plan.equipment.controller;

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
import com.rest.smoothchange.training.plan.equipment.dto.TrainingPlanEquipmentDto;
import com.rest.smoothchange.training.plan.equipment.dto.TrainingPlanEquipmentRequestDto;
import com.rest.smoothchange.training.plan.equipment.service.TrainingPlanEquipmentService;
import com.rest.smoothchange.util.DateUtil;



@RestController
@RequestMapping(value = "/trainingPlanEquipmentAPI")
@Transactional
public class TrainingPlanEquipmentController {

	private final static String dateFormate= "yyyy-MM-dd";
	
	@Autowired
	private TrainingPlanEquipmentService trainingPlanEquipmentService; 
	
	@Autowired
	private ProjectBackgroundService projectBackgroundService;
	
	
	@RequestMapping(value="createTrainingPlanEquipment" , method = RequestMethod.POST)
	public ResponseEntity createTrainingPlanEquipment(@RequestHeader("API-KEY") String apiKey, @RequestBody TrainingPlanEquipmentRequestDto trainingPlanEquipmentRequestDto) throws NoRecordsFoundException, ParseException, UnauthorizedException {
		
		if (!apiKey.equals(MessageEnum.API_KEY)) {
			  throw new UnauthorizedException(MessageEnum.unathorized);
		}

		ResponseBean responseBean = new ResponseBean();
		ProjectBackgroundDto projectBackgroundDto = projectBackgroundService.getById(trainingPlanEquipmentRequestDto.getProjectBackgroundId());
		if(projectBackgroundDto!=null && projectBackgroundDto.getId()!=null) {
			TrainingPlanEquipmentDto trainingPlanEquipmentDto = new TrainingPlanEquipmentDto();
			trainingPlanEquipmentDto.setProjectBackground(projectBackgroundDto);
			trainingPlanEquipmentDto =	mapTrainingPlanEquipmentRequestDtoToDto(trainingPlanEquipmentDto,trainingPlanEquipmentRequestDto);
			Long trainingPlanEquipmentId = (Long)trainingPlanEquipmentService.create(trainingPlanEquipmentDto);
			responseBean.setBody(trainingPlanEquipmentId);
		}else {
			throw new NoRecordsFoundException("Project Not Found");
		}
		return new ResponseEntity(responseBean, HttpStatus.OK);
	}

	
	
	@RequestMapping(value="updateTrainingPlanEquipment" , method = RequestMethod.POST)
	public ResponseEntity updateTrainingPlanEquipment(@RequestHeader("API-KEY") String apiKey, @RequestBody TrainingPlanEquipmentRequestDto trainingPlanEquipmentRequestDto, @RequestParam("trainingPlanEquipmentById") long trainingPlanEquipmentById) throws NoRecordsFoundException, ParseException, UnauthorizedException {
		
		if (!apiKey.equals(MessageEnum.API_KEY)) {
			  throw new UnauthorizedException(MessageEnum.unathorized);
		}

		ResponseBean responseBean = new ResponseBean();
		ProjectBackgroundDto projectBackgroundDto = projectBackgroundService.getById(trainingPlanEquipmentRequestDto.getProjectBackgroundId());
		if(projectBackgroundDto!=null && projectBackgroundDto.getId()!=null) {
			TrainingPlanEquipmentDto trainingPlanEquipmentDto = trainingPlanEquipmentService
					.getById(trainingPlanEquipmentById);
			if (trainingPlanEquipmentDto != null && trainingPlanEquipmentDto.getId() != null) {
				trainingPlanEquipmentDto.setProjectBackground(projectBackgroundDto);
				trainingPlanEquipmentDto = mapTrainingPlanEquipmentRequestDtoToDto(trainingPlanEquipmentDto,
						trainingPlanEquipmentRequestDto);
				trainingPlanEquipmentService.update(trainingPlanEquipmentDto);
				responseBean.setBody(MessageEnum.enumMessage.SUCESS.getMessage());
			}else {
				throw new NoRecordsFoundException("Training Plan Equipment Not Found");	
			}
		}else {
			throw new NoRecordsFoundException("Project Not Found");
		}
		return new ResponseEntity(responseBean, HttpStatus.OK);
	}

	
	@RequestMapping(value="getTrainingPlanEquipmentById" , method = RequestMethod.GET)
	public ResponseEntity getTrainingPlanEquipmentById(@RequestHeader("API-KEY") String apiKey, @RequestParam("trainingPlanEquipmentById") long trainingPlanEquipmentById) throws NoRecordsFoundException, ParseException, UnauthorizedException {
		
		if (!apiKey.equals(MessageEnum.API_KEY)) {
			  throw new UnauthorizedException(MessageEnum.unathorized);
		}

		ResponseBean responseBean = new ResponseBean();
		TrainingPlanEquipmentDto trainingPlanEquipmentDto = trainingPlanEquipmentService.getById(trainingPlanEquipmentById);
		if(trainingPlanEquipmentDto!=null && trainingPlanEquipmentDto.getId()!=null) {
			TrainingPlanEquipmentRequestDto trainingPlanEquipmentRequestDto = mapTrainingPlanEquipmentDtoToRequestDto(trainingPlanEquipmentDto);
			responseBean.setBody(trainingPlanEquipmentRequestDto);
		}else {
			throw new NoRecordsFoundException("Training Plan Equipment Not Found");
		}	
		return new ResponseEntity(responseBean, HttpStatus.OK);
	}
	
	
	@RequestMapping(value="getTrainingPlanEquipmentByProjectId" , method = RequestMethod.GET)
	public ResponseEntity getTrainingPlanEquipmentByProjectId(@RequestHeader("API-KEY") String apiKey, @RequestParam("projecId") long projecId) throws NoRecordsFoundException, ParseException, UnauthorizedException {
		
		if (!apiKey.equals(MessageEnum.API_KEY)) {
			  throw new UnauthorizedException(MessageEnum.unathorized);
			}

		ResponseBean responseBean = new ResponseBean();		
		List<TrainingPlanEquipmentDto> trainingPlanEquipmentDtoList = trainingPlanEquipmentService.getTrainingPlanEquipmentListByProjectId(projecId);
		if(trainingPlanEquipmentDtoList!=null && !trainingPlanEquipmentDtoList.isEmpty()) {
			List<TrainingPlanEquipmentRequestDto> trainingPlanEquipmentRequestDtoList = new ArrayList<>();
			for(TrainingPlanEquipmentDto trainingPlanEquipmentDto : trainingPlanEquipmentDtoList ) {
				trainingPlanEquipmentRequestDtoList.add(mapTrainingPlanEquipmentDtoToRequestDto(trainingPlanEquipmentDto));
			}
			responseBean.setBody(trainingPlanEquipmentRequestDtoList);	
		}else {
			throw new NoRecordsFoundException("Training Plan Equipment List Not Found");
		}
		return new ResponseEntity(responseBean, HttpStatus.OK);
	}
	
	
	//================= Privete Method ==============
	
	private TrainingPlanEquipmentDto mapTrainingPlanEquipmentRequestDtoToDto(TrainingPlanEquipmentDto trainingPlanEquipmentDto , TrainingPlanEquipmentRequestDto trainingPlanEquipmentRequestDto) throws ParseException {
		if(trainingPlanEquipmentDto!=null && trainingPlanEquipmentRequestDto!=null) {
			if(trainingPlanEquipmentRequestDto.getDateRequired()!=null && !trainingPlanEquipmentRequestDto.getDateRequired().trim().equals("")) {
			  trainingPlanEquipmentDto.setDateRequired(DateUtil.getFormattedDate(trainingPlanEquipmentRequestDto.getDateRequired().trim(), dateFormate));
			}
			trainingPlanEquipmentDto.setEquipmentType(trainingPlanEquipmentRequestDto.getEquipmentType());
			trainingPlanEquipmentDto.setNumberRequired(trainingPlanEquipmentRequestDto.getNumberRequired());
			trainingPlanEquipmentRequestDto.setTrainingPlanEquipmentId(trainingPlanEquipmentRequestDto.getTrainingPlanEquipmentId());			
		}
		return trainingPlanEquipmentDto;
	}
	
	private TrainingPlanEquipmentRequestDto mapTrainingPlanEquipmentDtoToRequestDto(TrainingPlanEquipmentDto trainingPlanEquipmentDto) throws ParseException {
		TrainingPlanEquipmentRequestDto trainingPlanEquipmentRequestDto = null;
		if (trainingPlanEquipmentDto != null && trainingPlanEquipmentDto.getId() != null) {
			trainingPlanEquipmentRequestDto = new TrainingPlanEquipmentRequestDto();

			if (trainingPlanEquipmentDto.getDateRequired() != null) {
				trainingPlanEquipmentRequestDto.setDateRequired(DateUtil
						.getFormattedDateStringFromDate(trainingPlanEquipmentDto.getDateRequired(), dateFormate));
			}
			trainingPlanEquipmentRequestDto.setEquipmentType(trainingPlanEquipmentDto.getEquipmentType());
			trainingPlanEquipmentRequestDto.setNumberRequired(trainingPlanEquipmentDto.getNumberRequired());
			trainingPlanEquipmentRequestDto.setTrainingPlanEquipmentId(trainingPlanEquipmentDto.getId());
			if (trainingPlanEquipmentDto.getProjectBackground() != null
					&& trainingPlanEquipmentDto.getProjectBackground().getId() != null) {
				trainingPlanEquipmentRequestDto
						.setProjectBackgroundId(trainingPlanEquipmentDto.getProjectBackground().getId());
			}
		}
		return trainingPlanEquipmentRequestDto;
	}

}
