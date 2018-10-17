package com.rest.smoothchange.training.plan.version.history.controller;

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
import com.rest.framework.exception.NoEnumRecordsFoundException;
import com.rest.framework.exception.NoRecordsFoundException;
import com.rest.framework.exception.UnauthorizedException;
import com.rest.smoothchange.project.background.dto.ProjectBackgroundDto;
import com.rest.smoothchange.project.background.service.ProjectBackgroundService;
import com.rest.smoothchange.training.plan.version.history.dto.TrainingPlanVersionHistoryDto;
import com.rest.smoothchange.training.plan.version.history.dto.TrainingPlanVersionHistoryRequestDto;
import com.rest.smoothchange.training.plan.version.history.service.TrainingPlanVersionHistoryService;
import com.rest.smoothchange.util.DateUtil;



@RestController
@RequestMapping(value = "/trainingPlanVersionHistoryServiceAPI")
@Transactional
public class TrainingPlanVersionHistoryController {

	private static final String dateFormate = "yyyy-MM-dd";
	
	@Autowired
	private TrainingPlanVersionHistoryService trainingPlanVersionHistoryService; 


	@Autowired
	private ProjectBackgroundService projectBackgroundService;
	
	
	@RequestMapping(value="createTrainingPlanVersionHistory", method = RequestMethod.POST)
	public ResponseEntity createTrainingPlanVersionHistory(@RequestHeader("API-KEY") String apiKey, @RequestBody TrainingPlanVersionHistoryRequestDto trainingPlanVersionHistoryRequestDto) throws ParseException, UnauthorizedException, NoRecordsFoundException {	
		
		if (!apiKey.equals(MessageEnum.API_KEY)) {
			throw new UnauthorizedException(MessageEnum.unathorized);
		}
		
		ResponseBean responseBean = new ResponseBean();
		ProjectBackgroundDto projectBackgroundDto = projectBackgroundService.getById(trainingPlanVersionHistoryRequestDto.getProjectBackgroundId());
		if(projectBackgroundDto!=null && projectBackgroundDto.getId()!=null) {	
			TrainingPlanVersionHistoryDto trainingPlanVersionHistoryDto = new TrainingPlanVersionHistoryDto();
			 trainingPlanVersionHistoryDto =	mapTrainingPlanVersionHistoryRequestDtoToDto(trainingPlanVersionHistoryDto,trainingPlanVersionHistoryRequestDto);
			trainingPlanVersionHistoryDto.setProjectBackground(projectBackgroundDto);
			long trainingPlanVersionHistoryId =  (Long)trainingPlanVersionHistoryService.create(trainingPlanVersionHistoryDto);
			responseBean.setBody(trainingPlanVersionHistoryId);
		}else {
			throw new NoRecordsFoundException("Project Not Found");
		}	
		return new ResponseEntity(responseBean, org.springframework.http.HttpStatus.OK);	
	}
	
	
	@RequestMapping(value="updateTrainingPlanVersionHistory", method = RequestMethod.POST)
	public ResponseEntity updateTrainingPlanVersionHistory(@RequestHeader("API-KEY") String apiKey, @RequestParam("trainingPlanVersionHistoryId")long trainingPlanVersionHistoryId ,@RequestBody TrainingPlanVersionHistoryRequestDto trainingPlanVersionHistoryRequestDto) throws ParseException, UnauthorizedException, NoRecordsFoundException {	
		
		if (!apiKey.equals(MessageEnum.API_KEY)) {
			throw new UnauthorizedException(MessageEnum.unathorized);
		}
		
		ResponseBean responseBean = new ResponseBean();
		TrainingPlanVersionHistoryDto trainingPlanVersionHistoryDto = trainingPlanVersionHistoryService.getById(trainingPlanVersionHistoryId);
		if(trainingPlanVersionHistoryDto!=null && trainingPlanVersionHistoryDto.getId()!=null) {				
			ProjectBackgroundDto projectBackgroundDto = projectBackgroundService.getById(trainingPlanVersionHistoryRequestDto.getProjectBackgroundId());
			if(projectBackgroundDto!=null && projectBackgroundDto.getId()!=null) {
				trainingPlanVersionHistoryDto.setProjectBackground(projectBackgroundDto);
				trainingPlanVersionHistoryDto =	mapTrainingPlanVersionHistoryRequestDtoToDto(trainingPlanVersionHistoryDto,trainingPlanVersionHistoryRequestDto);				
				trainingPlanVersionHistoryService.update(trainingPlanVersionHistoryDto);
			}else {
				throw new NoRecordsFoundException("Project Not Found");
			}
			
		}else {
			throw new NoRecordsFoundException("Training Plan Version History Not Found");
		}
		responseBean.setBody(MessageEnum.enumMessage.SUCESS.getMessage());
		return new ResponseEntity(responseBean, org.springframework.http.HttpStatus.OK);	
	}

	
	@RequestMapping(value="getTrainingPlanVersionHistoryById" , method= RequestMethod.GET)
	public ResponseEntity getTrainingPlanVersionHistoryById(@RequestHeader("API-KEY") String apiKey, @RequestParam("trainingPlanVersionHistoryId") long trainingPlanVersionHistoryId) throws NoRecordsFoundException, ParseException, UnauthorizedException{
		
		if (!apiKey.equals(MessageEnum.API_KEY)) {
			throw new UnauthorizedException(MessageEnum.unathorized);
		}		
		ResponseBean responseBean = new ResponseBean();
		TrainingPlanVersionHistoryDto trainingPlanVersionHistoryDto = trainingPlanVersionHistoryService
				.getById(trainingPlanVersionHistoryId);
		if (trainingPlanVersionHistoryDto != null && trainingPlanVersionHistoryDto.getId() != null) {
			TrainingPlanVersionHistoryRequestDto trainingPlanVersionHistoryRequestDto = mapTrainingPlanVersionHistoryDtoToRequestDto(
					trainingPlanVersionHistoryDto);
			responseBean.setBody(trainingPlanVersionHistoryRequestDto);
		} else {
			throw new NoRecordsFoundException("Training Plan Version History Not Found");
		}
		return new ResponseEntity(responseBean, org.springframework.http.HttpStatus.OK);
	}
	
	
	@RequestMapping(value="getTrainingPlanVersionHistoryByProjectId" , method= RequestMethod.GET)
	public ResponseEntity getTrainingPlanVersionHistoryByProjectId(@RequestHeader("API-KEY") String apiKey, @RequestParam("projectId") long projectId) throws NoRecordsFoundException, ParseException, UnauthorizedException{
		
		if (!apiKey.equals(MessageEnum.API_KEY)) {
			throw new UnauthorizedException(MessageEnum.unathorized);
		}
		
		ResponseBean responseBean = new ResponseBean();
		List<TrainingPlanVersionHistoryRequestDto> trainingPlanVersionHistoryRequestDtoList = new ArrayList<>();
		List<TrainingPlanVersionHistoryDto> trainingPlanVersionHistoryDtoList = trainingPlanVersionHistoryService.getTrainingPlanVersionHistoryListByProjectId(projectId);
		if (trainingPlanVersionHistoryDtoList!=null && trainingPlanVersionHistoryDtoList.size()>0) {
			for(TrainingPlanVersionHistoryDto trainingPlanVersionHistoryDto : trainingPlanVersionHistoryDtoList) {
				trainingPlanVersionHistoryRequestDtoList.add(mapTrainingPlanVersionHistoryDtoToRequestDto(trainingPlanVersionHistoryDto));
			}
			responseBean.setBody(trainingPlanVersionHistoryRequestDtoList);			
		} else {
			throw new NoRecordsFoundException("Training Plan Version History Not Found");
		}
		return new ResponseEntity(responseBean, org.springframework.http.HttpStatus.OK);
	}
	
	
	//========================= Private Methods  ===================
	
	private TrainingPlanVersionHistoryDto mapTrainingPlanVersionHistoryRequestDtoToDto(TrainingPlanVersionHistoryDto trainingPlanVersionHistoryDto,TrainingPlanVersionHistoryRequestDto trainingPlanVersionHistoryRequestDto) throws ParseException {
		if(trainingPlanVersionHistoryRequestDto!=null) {
			if(trainingPlanVersionHistoryRequestDto.getApprovalDate()!=null && !trainingPlanVersionHistoryRequestDto.getApprovalDate().trim().equals("")) {
			  trainingPlanVersionHistoryDto.setApprovalDate(DateUtil.getFormattedDate(trainingPlanVersionHistoryRequestDto.getApprovalDate(), dateFormate));
			}
			trainingPlanVersionHistoryDto.setApprovedBy(trainingPlanVersionHistoryRequestDto.getApprovedBy());
			trainingPlanVersionHistoryDto.setAuthor(trainingPlanVersionHistoryRequestDto.getAuthor());
			trainingPlanVersionHistoryDto.setReason(trainingPlanVersionHistoryRequestDto.getReason());
			if(trainingPlanVersionHistoryRequestDto.getRevisionDate()!=null && !trainingPlanVersionHistoryRequestDto.getRevisionDate().trim().equals("")) {
				  trainingPlanVersionHistoryDto.setRevisionDate(DateUtil.getFormattedDate(trainingPlanVersionHistoryRequestDto.getRevisionDate(), dateFormate));
			}
			trainingPlanVersionHistoryDto.setVersionNo(trainingPlanVersionHistoryRequestDto.getVersionNo());
		}
		return trainingPlanVersionHistoryDto;
	}
	
	private TrainingPlanVersionHistoryRequestDto mapTrainingPlanVersionHistoryDtoToRequestDto(TrainingPlanVersionHistoryDto trainingPlanVersionHistoryDto) throws ParseException {
		TrainingPlanVersionHistoryRequestDto trainingPlanVersionHistoryRequestDto = null;
		if(trainingPlanVersionHistoryDto!=null) {
			trainingPlanVersionHistoryRequestDto = new TrainingPlanVersionHistoryRequestDto();
			if(trainingPlanVersionHistoryDto.getApprovalDate()!=null) {
				trainingPlanVersionHistoryRequestDto.setApprovalDate(DateUtil.getFormattedDateStringFromDate(trainingPlanVersionHistoryDto.getApprovalDate(), dateFormate));
			}
			if(trainingPlanVersionHistoryDto.getRevisionDate()!=null) {
				trainingPlanVersionHistoryRequestDto.setRevisionDate(DateUtil.getFormattedDateStringFromDate(trainingPlanVersionHistoryDto.getRevisionDate(), dateFormate));
			}
			trainingPlanVersionHistoryRequestDto.setApprovedBy(trainingPlanVersionHistoryDto.getApprovedBy());
			trainingPlanVersionHistoryRequestDto.setAuthor(trainingPlanVersionHistoryDto.getAuthor());
			if(trainingPlanVersionHistoryDto.getProjectBackground()!=null && trainingPlanVersionHistoryDto.getProjectBackground().getId()!=null) {
				trainingPlanVersionHistoryRequestDto.setProjectBackgroundId(trainingPlanVersionHistoryDto.getProjectBackground().getId());
			}
			
			trainingPlanVersionHistoryRequestDto.setReason(trainingPlanVersionHistoryDto.getReason());
			trainingPlanVersionHistoryRequestDto.setVersionNo(trainingPlanVersionHistoryDto.getVersionNo());
			trainingPlanVersionHistoryRequestDto.setTrainingPlanVersionHistoryId(trainingPlanVersionHistoryDto.getId());
		}
		return trainingPlanVersionHistoryRequestDto;
	}

}
