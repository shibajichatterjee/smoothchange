package com.rest.smoothchange.communication.plan.controller;

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
import com.rest.smoothchange.communication.plan.dto.CommunicationPlanDto;
import com.rest.smoothchange.communication.plan.dto.CommunicationPlanRequestDto;
import com.rest.smoothchange.communication.plan.service.CommunicationPlanService;
import com.rest.smoothchange.impact.analysis.dto.ImpactAnalysisDto;
import com.rest.smoothchange.project.background.dto.ProjectBackgroundDto;
import com.rest.smoothchange.project.stakeholders.dto.ProjectStakeholdersDto;
import com.rest.smoothchange.util.CommonUtil;
import com.rest.smoothchange.util.CommunicationChannel;
import com.rest.smoothchange.util.Frequency;
import com.rest.smoothchange.util.PurposeOfCommunication;
import com.rest.smoothchange.util.Status;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/communicationPlanAPI")
@Transactional
public class CommunicationPlanController {

	@Autowired
	private CommunicationPlanService communicationPlanService;
	@Autowired
	private CommonUtil commonUtil;

	@ApiOperation(value = "Add Communication Plans")
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/AddCommunicationPlans", method = RequestMethod.POST)
	public ResponseEntity create(@RequestHeader("API-KEY") String apiKey, @RequestParam("projectId") String id,
			@RequestBody CommunicationPlanRequestDto communicationPlanRequestDto)
			throws NoEnumRecordsFoundException, UnauthorizedException, NoRecordsFoundException {
		if (!apiKey.equals(MessageEnum.API_KEY)) {
			throw new UnauthorizedException(MessageEnum.unathorized);
		}
		Frequency type = Frequency.getValue(communicationPlanRequestDto.getFrequency());
		if (type == null) {

			throw new NoEnumRecordsFoundException("Frequency not matched");
		}
		CommunicationChannel communicationChannel = CommunicationChannel
				.getValue(communicationPlanRequestDto.getCommunicationChannel());
		if (communicationChannel == null) {

			throw new NoEnumRecordsFoundException("Communication Channel not matched");
		}
		Status status = Status.getValue(communicationPlanRequestDto.getStatus());
		if (status == null) {

			throw new NoEnumRecordsFoundException("Status not matched");
		}
		PurposeOfCommunication purpose = PurposeOfCommunication
				.getValue(communicationPlanRequestDto.getPurposeOfCommunication());
		if (purpose == null) {

			throw new NoEnumRecordsFoundException("Purpose Of Communication not matched");
		}
		commonUtil.getProjectBackGround(id);
		CommunicationPlanDto dto=new CommunicationPlanDto();
		dto = mapRequestToDto(dto,communicationPlanRequestDto);
		dto.setProjectBackground(new ProjectBackgroundDto());
		dto.setProjectStakeholders(new ProjectStakeholdersDto());
		dto.getProjectStakeholders().setId(communicationPlanRequestDto.getProjectstakeHolderId());
		dto.getProjectBackground().setId(Long.parseLong(id));
		communicationPlanService.create(dto);
		ResponseBean responseBean = new ResponseBean();
		responseBean.setBody(MessageEnum.enumMessage.SUCESS.getMessage());
		return new ResponseEntity(responseBean, org.springframework.http.HttpStatus.OK);

	}

	@ApiOperation(value = "Modify Communication Plans")
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/ModifyCommunicationPlans", method = RequestMethod.POST)
	public ResponseEntity update(@RequestHeader("API-KEY") String apiKey, 
			@RequestBody CommunicationPlanRequestDto communicationPlanRequestDto)
			throws NoEnumRecordsFoundException, UnauthorizedException, NoRecordsFoundException {
		if (!apiKey.equals(MessageEnum.API_KEY)) {
			throw new UnauthorizedException(MessageEnum.unathorized);
		}
		Frequency type = Frequency.getValue(communicationPlanRequestDto.getFrequency());
		if (type == null) {

			throw new NoEnumRecordsFoundException("Frequency not matched");
		}
		CommunicationChannel communicationChannel = CommunicationChannel
				.getValue(communicationPlanRequestDto.getCommunicationChannel());
		if (communicationChannel == null) {

			throw new NoEnumRecordsFoundException("Communication Channel not matched");
		}
		Status status = Status.getValue(communicationPlanRequestDto.getStatus());
		if (status == null) {

			throw new NoEnumRecordsFoundException("Status not matched");
		}
		PurposeOfCommunication purpose = PurposeOfCommunication
				.getValue(communicationPlanRequestDto.getPurposeOfCommunication());
		if (purpose == null) {

			throw new NoEnumRecordsFoundException("Purpose Of Communication not matched");
		}
		//commonUtil.getProjectBackGround(id);
		CommunicationPlanDto dto=communicationPlanService.getById(communicationPlanRequestDto.getId()==null?0:communicationPlanRequestDto.getId());
		if (dto == null) {
			throw new NoRecordsFoundException(MessageEnum.enumMessage.NO_RECORDS.getMessage()+"For this Communication Plan ID");

		}
		dto = mapRequestToDto(dto,communicationPlanRequestDto);
		//dto.getProjectBackground().setId(Long.parseLong(id));
		dto.setProjectStakeholders(new ProjectStakeholdersDto());
		dto.getProjectStakeholders().setId(communicationPlanRequestDto.getProjectstakeHolderId());
		communicationPlanService.update(dto);
		ResponseBean responseBean = new ResponseBean();
		responseBean.setBody(MessageEnum.enumMessage.SUCESS.getMessage());
		return new ResponseEntity(responseBean, org.springframework.http.HttpStatus.OK);

	}

	@ApiOperation(value = "Get Communication Plans by Project Id")
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/GetCommunicationPlansByProjectId", method = RequestMethod.GET)
	public ResponseEntity getCommunicationPlansByProjectId(@RequestHeader("API-KEY") String apiKey,
			@RequestParam("projectId") String projectId) throws NoRecordsFoundException, UnauthorizedException {
		if (!apiKey.equals(MessageEnum.API_KEY)) {
			throw new UnauthorizedException(MessageEnum.unathorized);
		}
		List<CommunicationPlanRequestDto> requestDtoList = new ArrayList<>();
		commonUtil.getProjectBackGround(projectId);
		List<CommunicationPlanDto> dto = communicationPlanService
				.getCommunicationPlanListByProjectId(Long.parseLong(projectId));
		if (dto == null || dto.size() == 0) {
			throw new NoRecordsFoundException(MessageEnum.enumMessage.NO_RECORDS.getMessage());
		}
		for (CommunicationPlanDto communicationPlanDto : dto) {
			requestDtoList.add(mapDtotoRequestDto(communicationPlanDto));
		}
		ResponseBean responseBean = new ResponseBean();
		responseBean.setBody(requestDtoList);
		return new ResponseEntity(responseBean, org.springframework.http.HttpStatus.OK);

	}

	@ApiOperation(value = "Get Communication Plans by Id")
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/GetCommunicationPlansById", method = RequestMethod.GET)
	public ResponseEntity getCommunicationPlansById(@RequestHeader("API-KEY") String apiKey,
			 @RequestParam("id") String id)
			throws NoRecordsFoundException, UnauthorizedException {
		if (!apiKey.equals(MessageEnum.API_KEY)) {
			throw new UnauthorizedException(MessageEnum.unathorized);
		}
		//commonUtil.getProjectBackGround(projectId);
		CommunicationPlanDto dto = new CommunicationPlanDto();
		/*dto.setId(Long.parseLong(id));
		dto.setProjectBackground(new ProjectBackgroundDto());
		dto.getProjectBackground().setId(Long.parseLong(projectId));*/
		dto = communicationPlanService.getById(Long.parseLong(id));
		if (dto == null) {
			throw new NoRecordsFoundException(MessageEnum.enumMessage.NO_RECORDS.getMessage());
		}
		ResponseBean responseBean = new ResponseBean();
		responseBean.setBody(mapDtotoRequestDto(dto));
		return new ResponseEntity(responseBean, org.springframework.http.HttpStatus.OK);

	}
	
	@ApiOperation(value = "Delete Communication Plans by Id")
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/DeleteCommunicationPlansById", method = RequestMethod.DELETE)
	public ResponseEntity deleteCommunicationPlansById(@RequestHeader("API-KEY") String apiKey,@RequestParam("id") String id) throws UnauthorizedException, NoRecordsFoundException {
		if(!apiKey.equals(MessageEnum.API_KEY))
		{
			throw new UnauthorizedException(MessageEnum.unathorized);
		}
		CommunicationPlanDto dto=communicationPlanService.getById(Long.parseLong(id));
		if(dto==null)
		{
			throw new NoRecordsFoundException(MessageEnum.enumMessage.ID_NOT_VALID.getMessage());

		}
		communicationPlanService.deleteById(Long.parseLong(id));
		ResponseBean responseBean = new ResponseBean();
		responseBean.setBody(MessageEnum.enumMessage.SUCESS.getMessage());
		return new ResponseEntity(responseBean, org.springframework.http.HttpStatus.OK);

	}

	private CommunicationPlanDto mapRequestToDto(CommunicationPlanDto communicationPlanDto,CommunicationPlanRequestDto communicationPlanRequestDto) {
		communicationPlanDto.setId(communicationPlanRequestDto.getId());
		
		communicationPlanDto.setSentBy(communicationPlanRequestDto.getSentBy());
		communicationPlanDto.setPurposeOfCommunication(
				PurposeOfCommunication.getValue(communicationPlanRequestDto.getPurposeOfCommunication()));
		communicationPlanDto.setMessage(communicationPlanRequestDto.getMessage());
		communicationPlanDto.setCommunicationChannel(
				CommunicationChannel.getValue(communicationPlanRequestDto.getCommunicationChannel()));
		communicationPlanDto.setTimingOrDate(communicationPlanRequestDto.getTimingOrDate());
		communicationPlanDto.setFrequency(Frequency.getValue(communicationPlanRequestDto.getFrequency()));
		communicationPlanDto.setPreparedBy(communicationPlanRequestDto.getPreparedBy());
		communicationPlanDto.setSentBy(communicationPlanRequestDto.getSentBy());
		communicationPlanDto.setStatus(Status.getValue(communicationPlanRequestDto.getStatus()));
		return communicationPlanDto;
	}

	private CommunicationPlanRequestDto mapDtotoRequestDto(CommunicationPlanDto communicationPlanDto) {
		CommunicationPlanRequestDto communicationPlanRequestDto = new CommunicationPlanRequestDto();
		communicationPlanRequestDto.setId(communicationPlanDto.getId());
		communicationPlanRequestDto.setProjectstakeHolderId(communicationPlanDto.getProjectStakeholders().getId());
		communicationPlanRequestDto.setSentBy(communicationPlanDto.getSentBy());
		communicationPlanRequestDto
				.setPurposeOfCommunication(communicationPlanDto.getPurposeOfCommunication().getNumVal());
		communicationPlanRequestDto.setMessage(communicationPlanDto.getMessage());
		communicationPlanRequestDto.setCommunicationChannel(communicationPlanDto.getCommunicationChannel().getNumVal());
		communicationPlanRequestDto.setTimingOrDate(communicationPlanDto.getTimingOrDate());
		communicationPlanRequestDto.setFrequency(communicationPlanDto.getFrequency().getNumVal());
		communicationPlanRequestDto.setPreparedBy(communicationPlanDto.getPreparedBy());
		communicationPlanRequestDto.setSentBy(communicationPlanDto.getSentBy());
		communicationPlanRequestDto.setStatus(communicationPlanDto.getStatus().getNumVal());
		return communicationPlanRequestDto;
	}

}
