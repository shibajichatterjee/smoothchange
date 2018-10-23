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

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "trainingPlanCurriculumLessonPlanAPI")
@Api(value = "Training Plan Curriculum Lesson Plan", description = "Operation For Training Plan Curriculum Lesson Plan")
@Transactional
public class TrainingPlanCurriculumLessonPlanController {

	@Autowired
	private TrainingPlanCurriculumLessonPlanService trainingPlanCurriculumLessonPlanService;

	@Autowired
	private ProjectBackgroundService projectBackgroundService;

	@ApiOperation(value = "Add Training Plan Curriculum Lesson Plan")
	@RequestMapping(value = "addTrainingPlanCurriculumLessonPlan", method = RequestMethod.POST)
	public ResponseEntity createTrainingPlanCurriculumLessonPlan(@RequestHeader("API-KEY") String apiKey,
			@RequestParam("projectId") long projectId,
			@RequestBody TrainingPlanCurriculumLessonPlanRequestDto trainingPlanCurriculumLessonPlanRequestDto)
			throws NoRecordsFoundException, ParseException, UnauthorizedException {

		if (!apiKey.equals(MessageEnum.API_KEY)) {
			throw new UnauthorizedException(MessageEnum.unathorized);
		}

		ResponseBean responseBean = new ResponseBean();
		ProjectBackgroundDto projectBackgroundDto = projectBackgroundService.getById(projectId);
		if (projectBackgroundDto != null && projectBackgroundDto.getId() != null) {
			TrainingPlanCurriculumLessonPlanDto trainingPlanCurriculumLessonPlanDto = new TrainingPlanCurriculumLessonPlanDto();
			trainingPlanCurriculumLessonPlanDto.setProjectBackground(projectBackgroundDto);
			trainingPlanCurriculumLessonPlanDto = mapTrainingPlanCurriculumLessonPlanRequestDtoRequestDtoToDto(
					trainingPlanCurriculumLessonPlanDto, trainingPlanCurriculumLessonPlanRequestDto);
			Long trainingPlanEquipmentId = (Long) trainingPlanCurriculumLessonPlanService
					.create(trainingPlanCurriculumLessonPlanDto);
			responseBean.setBody(trainingPlanEquipmentId);
		} else {
			throw new NoRecordsFoundException(MessageEnum.enumMessage.NO_RECORDS.getMessage());
		}
		return new ResponseEntity(responseBean, HttpStatus.OK);
	}

	@ApiOperation(value = "Modify Training Plan Curriculum Lesson Plan")
	@RequestMapping(value = "modifyTrainingPlanCurriculumLessonPlan", method = RequestMethod.POST)
	public ResponseEntity modifyTrainingPlanCurriculumLessonPlan(@RequestHeader("API-KEY") String apiKey,
			@RequestParam("projectId") long projectId,
			@RequestBody TrainingPlanCurriculumLessonPlanRequestDto trainingPlanCurriculumLessonPlanRequestDto)
			throws NoRecordsFoundException, ParseException, UnauthorizedException {

		if (!apiKey.equals(MessageEnum.API_KEY)) {
			throw new UnauthorizedException(MessageEnum.unathorized);
		}

		ResponseBean responseBean = new ResponseBean();
		ProjectBackgroundDto projectBackgroundDto = projectBackgroundService.getById(projectId);
		if (projectBackgroundDto != null && projectBackgroundDto.getId() != null) {
			TrainingPlanCurriculumLessonPlanDto trainingPlanCurriculumLessonPlanDto = trainingPlanCurriculumLessonPlanService
					.getById(trainingPlanCurriculumLessonPlanRequestDto.getTrainingPlanCurriculumLessonPlanId());
			if (trainingPlanCurriculumLessonPlanDto != null && trainingPlanCurriculumLessonPlanDto.getId() != null) {
				trainingPlanCurriculumLessonPlanDto.setProjectBackground(projectBackgroundDto);
				trainingPlanCurriculumLessonPlanDto = mapTrainingPlanCurriculumLessonPlanRequestDtoRequestDtoToDto(
						trainingPlanCurriculumLessonPlanDto, trainingPlanCurriculumLessonPlanRequestDto);
				trainingPlanCurriculumLessonPlanService.update(trainingPlanCurriculumLessonPlanDto);
				responseBean.setBody(MessageEnum.enumMessage.SUCESS.getMessage());
			} else {
				throw new NoRecordsFoundException(MessageEnum.enumMessage.NO_RECORDS.getMessage());
			}
		} else {
			throw new NoRecordsFoundException(MessageEnum.enumMessage.NO_RECORDS.getMessage());
		}
		return new ResponseEntity(responseBean, HttpStatus.OK);
	}

	@ApiOperation(value = "Get Training Plan Curriculum Lesson Plan By Id")
	@RequestMapping(value = "getTrainingPlanCurriculumLessonPlanById", method = RequestMethod.GET)
	public ResponseEntity updateTrainingPlanCurriculumLessonPlanById(@RequestHeader("API-KEY") String apiKey,
			@RequestParam("id") long trainingPlanCurriculumLessonPlanRequestId)
			throws NoRecordsFoundException, ParseException, UnauthorizedException {

		if (!apiKey.equals(MessageEnum.API_KEY)) {
			throw new UnauthorizedException(MessageEnum.unathorized);
		}

		ResponseBean responseBean = new ResponseBean();
		TrainingPlanCurriculumLessonPlanDto trainingPlanCurriculumLessonPlanDto = trainingPlanCurriculumLessonPlanService
				.getById(trainingPlanCurriculumLessonPlanRequestId);
		if (trainingPlanCurriculumLessonPlanDto != null && trainingPlanCurriculumLessonPlanDto.getId() != null) {
			TrainingPlanCurriculumLessonPlanRequestDto trainingPlanCurriculumLessonPlanRequestDto = maptrainingPlanCurriculumLessonPlanDtoToRequestDto(
					trainingPlanCurriculumLessonPlanDto);
			responseBean.setBody(trainingPlanCurriculumLessonPlanRequestDto);
		} else {
			throw new NoRecordsFoundException(MessageEnum.enumMessage.NO_RECORDS.getMessage());
		}
		return new ResponseEntity(responseBean, HttpStatus.OK);
	}

	@ApiOperation(value = "Get Training Plan Curriculum Lesson Plan By Project Id")
	@RequestMapping(value = "getTrainingPlanCurriculumLessonPlanByProjectId", method = RequestMethod.GET)
	public ResponseEntity updateTrainingPlanCurriculumLessonPlanByProjectId(@RequestHeader("API-KEY") String apiKey,
			@RequestParam("projecId") long projecId)
			throws NoRecordsFoundException, ParseException, UnauthorizedException {

		if (!apiKey.equals(MessageEnum.API_KEY)) {
			throw new UnauthorizedException(MessageEnum.unathorized);
		}

		ResponseBean responseBean = new ResponseBean();
		List<TrainingPlanCurriculumLessonPlanDto> trainingPlanCurriculumLessonPlanList = trainingPlanCurriculumLessonPlanService
				.getTrainingPlanCurriculumLessonPlanListByProjectId(projecId);
		if (trainingPlanCurriculumLessonPlanList != null && !trainingPlanCurriculumLessonPlanList.isEmpty()) {
			List<TrainingPlanCurriculumLessonPlanRequestDto> trainingPlanCurriculumLessonPlanRequestDtoList = new ArrayList<>();
			for (TrainingPlanCurriculumLessonPlanDto trainingPlanCurriculumLessonPlanDto : trainingPlanCurriculumLessonPlanList) {
				trainingPlanCurriculumLessonPlanRequestDtoList
						.add(maptrainingPlanCurriculumLessonPlanDtoToRequestDto(trainingPlanCurriculumLessonPlanDto));
			}
			responseBean.setBody(trainingPlanCurriculumLessonPlanRequestDtoList);
		} else {
			throw new NoRecordsFoundException(MessageEnum.enumMessage.NO_RECORDS.getMessage());
		}
		return new ResponseEntity(responseBean, HttpStatus.OK);
	}

	@ApiOperation(value = "Delete Training Plan Curriculum Lesson Plan By Id")
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/deleteTrainingPlanRolesResponsibilities", method = RequestMethod.DELETE)
	public ResponseEntity deleteStakeHolderById(@RequestHeader("API-KEY") String apiKey,
			@RequestParam("id") long trainingPlanCurriculumLessonPlanId)
			throws UnauthorizedException, NoRecordsFoundException {
		if (!apiKey.equals(MessageEnum.API_KEY)) {
			throw new UnauthorizedException(MessageEnum.unathorized);
		}
		TrainingPlanCurriculumLessonPlanDto trainingPlanCurriculumLessonPlanDto = trainingPlanCurriculumLessonPlanService
				.getById(trainingPlanCurriculumLessonPlanId);

		if (trainingPlanCurriculumLessonPlanDto != null && trainingPlanCurriculumLessonPlanDto.getId() != null) {
			trainingPlanCurriculumLessonPlanService.delete(trainingPlanCurriculumLessonPlanDto);
		} else {
			throw new NoRecordsFoundException(MessageEnum.enumMessage.NO_RECORDS.getMessage());
		}
		ResponseBean responseBean = new ResponseBean();
		responseBean.setBody(MessageEnum.enumMessage.SUCESS.getMessage());
		return new ResponseEntity(responseBean, org.springframework.http.HttpStatus.OK);
	}

	// ================= Privete Method ==============

	private TrainingPlanCurriculumLessonPlanDto mapTrainingPlanCurriculumLessonPlanRequestDtoRequestDtoToDto(
			TrainingPlanCurriculumLessonPlanDto trainingPlanCurriculumLessonPlanDto,
			TrainingPlanCurriculumLessonPlanRequestDto trainingPlanCurriculumLessonPlanRequestDto)
			throws ParseException {
		if (trainingPlanCurriculumLessonPlanDto != null && trainingPlanCurriculumLessonPlanRequestDto != null) {
			trainingPlanCurriculumLessonPlanDto
					.setCurriculumUnitName(trainingPlanCurriculumLessonPlanRequestDto.getCurriculumUnitName());
			trainingPlanCurriculumLessonPlanDto
					.setCurriculumUnitNo(trainingPlanCurriculumLessonPlanRequestDto.getCurriculumUnitNo());
			trainingPlanCurriculumLessonPlanDto.setDuration(trainingPlanCurriculumLessonPlanRequestDto.getDuration());
			trainingPlanCurriculumLessonPlanDto
					.setLessonUnitName(trainingPlanCurriculumLessonPlanRequestDto.getLessonUnitName());
			trainingPlanCurriculumLessonPlanDto
					.setLessonUnitNo(trainingPlanCurriculumLessonPlanRequestDto.getLessonUnitNo());
		}
		return trainingPlanCurriculumLessonPlanDto;
	}

	private TrainingPlanCurriculumLessonPlanRequestDto maptrainingPlanCurriculumLessonPlanDtoToRequestDto(
			TrainingPlanCurriculumLessonPlanDto trainingPlanCurriculumLessonPlanDto) throws ParseException {
		TrainingPlanCurriculumLessonPlanRequestDto trainingPlanCurriculumLessonPlanRequestDto = null;
		if (trainingPlanCurriculumLessonPlanDto != null && trainingPlanCurriculumLessonPlanDto.getId() != null) {
			trainingPlanCurriculumLessonPlanRequestDto = new TrainingPlanCurriculumLessonPlanRequestDto();
			trainingPlanCurriculumLessonPlanRequestDto
					.setCurriculumUnitName(trainingPlanCurriculumLessonPlanDto.getCurriculumUnitName());
			trainingPlanCurriculumLessonPlanRequestDto
					.setCurriculumUnitNo(trainingPlanCurriculumLessonPlanDto.getCurriculumUnitNo());
			trainingPlanCurriculumLessonPlanRequestDto.setDuration(trainingPlanCurriculumLessonPlanDto.getDuration());
			trainingPlanCurriculumLessonPlanRequestDto
					.setLessonUnitName(trainingPlanCurriculumLessonPlanDto.getLessonUnitName());
			trainingPlanCurriculumLessonPlanRequestDto
					.setLessonUnitNo(trainingPlanCurriculumLessonPlanDto.getLessonUnitNo());
			trainingPlanCurriculumLessonPlanRequestDto
					.setTrainingPlanCurriculumLessonPlanId(trainingPlanCurriculumLessonPlanDto.getId());
		}
		return trainingPlanCurriculumLessonPlanRequestDto;
	}

}
