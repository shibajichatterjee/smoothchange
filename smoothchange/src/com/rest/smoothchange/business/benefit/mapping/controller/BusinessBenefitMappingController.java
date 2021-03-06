package com.rest.smoothchange.business.benefit.mapping.controller;

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
import com.rest.smoothchange.business.benefit.mapping.dto.BusinessBenefitMappingDto;
import com.rest.smoothchange.business.benefit.mapping.dto.BusinessBenefitMappingRequestDto;
import com.rest.smoothchange.business.benefit.mapping.service.BusinessBenefitMappingService;
import com.rest.smoothchange.project.background.dto.ProjectBackgroundDto;
import com.rest.smoothchange.project.background.service.ProjectBackgroundService;
import com.rest.smoothchange.project.stakeholders.dto.ProjectStakeholdersDto;
import com.rest.smoothchange.project.stakeholders.service.ProjectStakeholdersService;
import com.rest.smoothchange.util.BusinessBenefit;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/businessBenefitMappingAPI")
@Api(value = "Business Benefit Mapping", description = "Operations For Business Benefit Mapping")

@Transactional
public class BusinessBenefitMappingController {

	@Autowired
	private BusinessBenefitMappingService businessBenefitMappingService;

	@Autowired
	private ProjectBackgroundService projectService;

	@Autowired
	private ProjectStakeholdersService projectStakeholdersService;

	@ApiOperation(value = "Add a Business Benefit Mapping")
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/AddBusinessBenefitMapping", method = RequestMethod.POST)
	public ResponseEntity create(@RequestHeader("API-KEY") String apiKey, @RequestParam("projectId") String id,
			@RequestParam("stackHolderId") long stackHolderId,
			@RequestBody BusinessBenefitMappingRequestDto businessBenefitMappingRequestDto)
			throws NoEnumRecordsFoundException, UnauthorizedException, NoRecordsFoundException {
		if (!apiKey.equals(MessageEnum.API_KEY)) {
			throw new UnauthorizedException(MessageEnum.unathorized);
		}
		BusinessBenefit type = BusinessBenefit.getValue(businessBenefitMappingRequestDto.getBusinessBenefit());
		if (type == null) {
			throw new NoEnumRecordsFoundException("Business Benefit not matched");
		}

		ProjectStakeholdersDto projectStakeholdersDto = projectStakeholdersService.getById(stackHolderId);
		if (projectStakeholdersDto == null) {
			throw new NoRecordsFoundException(MessageEnum.enumMessage.NO_RECORDS.getMessage());
		}

		getProjectBackGround(id);
		BusinessBenefitMappingDto dto =new BusinessBenefitMappingDto();
		dto = mapRequestToDto(dto,businessBenefitMappingRequestDto);
		dto.setProjectBackground(new ProjectBackgroundDto());

		dto.setProjectStakeholders(projectStakeholdersDto);
		dto.getProjectBackground().setId(Long.parseLong(id));
		businessBenefitMappingService.create(dto);
		ResponseBean responseBean = new ResponseBean();
		responseBean.setBody(MessageEnum.enumMessage.SUCESS.getMessage());
		return new ResponseEntity(responseBean, org.springframework.http.HttpStatus.OK);

	}

	@ApiOperation(value = "Modify a Business Benefit Mapping")
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/ModifyBusinessBenefitMapping", method = RequestMethod.POST)
	public ResponseEntity modify(@RequestHeader("API-KEY") String apiKey, 
			@RequestParam("stackHolderId") long stackHolderId,
			@RequestBody BusinessBenefitMappingRequestDto businessBenefitMappingRequestDto)
			throws NoEnumRecordsFoundException, UnauthorizedException, NoRecordsFoundException {
		if (!apiKey.equals(MessageEnum.API_KEY)) {
			throw new UnauthorizedException(MessageEnum.unathorized);
		}

		BusinessBenefit type = BusinessBenefit.getValue(businessBenefitMappingRequestDto.getBusinessBenefit());
		if (type == null) {
			throw new NoEnumRecordsFoundException("Business Benefit not matched");
		}

		ProjectStakeholdersDto projectStakeholdersDto = projectStakeholdersService.getById(stackHolderId);
		if (projectStakeholdersDto == null) {
			throw new NoRecordsFoundException(MessageEnum.enumMessage.NO_RECORDS.getMessage()+"For this Stakeholder ID");
		}

		//getProjectBackGround(id);
		BusinessBenefitMappingDto dto=businessBenefitMappingService.getById(businessBenefitMappingRequestDto.getId()==null?0:businessBenefitMappingRequestDto.getId());
		if (dto == null) {
			throw new NoRecordsFoundException(MessageEnum.enumMessage.NO_RECORDS.getMessage()+"For this Business BenefitMapping ID");

		}
		dto = mapRequestToDto(dto,businessBenefitMappingRequestDto);
		dto.setProjectStakeholders(projectStakeholdersDto);
		businessBenefitMappingService.update(dto);
		ResponseBean responseBean = new ResponseBean();
		responseBean.setBody(MessageEnum.enumMessage.SUCESS.getMessage());
		return new ResponseEntity(responseBean, org.springframework.http.HttpStatus.OK);
	}

	@ApiOperation(value = "Get Business Benefit Mapping by Id")
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/GetBusinessBenefitMappingById", method = RequestMethod.GET)
	public ResponseEntity getBusinessBenefitMappingById(@RequestHeader("API-KEY") String apiKey,
			 @RequestParam("id") String id)
			throws NoRecordsFoundException, UnauthorizedException {
		if (!apiKey.equals(MessageEnum.API_KEY)) {
			throw new UnauthorizedException(MessageEnum.unathorized);
		}

		//getProjectBackGround(projectId);
		BusinessBenefitMappingDto dto = new BusinessBenefitMappingDto();
		/*dto.setId(Long.parseLong(id));
		dto.setProjectBackground(new ProjectBackgroundDto());
		dto.getProjectBackground().setId(Long.parseLong(projectId));*/
		dto = businessBenefitMappingService.getById(Long.parseLong(id));
		if (dto == null) {
			throw new NoRecordsFoundException(MessageEnum.enumMessage.NO_RECORDS.getMessage());
		}
		ResponseBean responseBean = new ResponseBean();
		responseBean.setBody(mapDtoToRequestDto(dto));
		return new ResponseEntity(responseBean, org.springframework.http.HttpStatus.OK);

	}

	@ApiOperation(value = "Get Business Benefit Mapping by Project Id")
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/GetBusinessBenefitMappingByProjectId", method = RequestMethod.GET)
	public ResponseEntity getBusinessBenefitMappingByProjectId(@RequestHeader("API-KEY") String apiKey,
			@RequestParam("projectId") String projectId) throws NoRecordsFoundException, UnauthorizedException {
		if (!apiKey.equals(MessageEnum.API_KEY)) {
			throw new UnauthorizedException(MessageEnum.unathorized);
		}
		List<BusinessBenefitMappingRequestDto> requestDtoList = new ArrayList<>();
		getProjectBackGround(projectId);

		List<BusinessBenefitMappingDto> dto = businessBenefitMappingService
				.getBusinessBenefitMappingListByProjectId(Long.parseLong(projectId));
		if (dto == null || dto.size() == 0) {
			throw new NoRecordsFoundException(MessageEnum.enumMessage.NO_RECORDS.getMessage());
		}
		for (BusinessBenefitMappingDto businessBenefitMappingDto : dto) {
			requestDtoList.add(mapDtoToRequestDto(businessBenefitMappingDto));
		}
		ResponseBean responseBean = new ResponseBean();
		responseBean.setBody(requestDtoList);
		return new ResponseEntity(responseBean, org.springframework.http.HttpStatus.OK);

	}

	@ApiOperation(value = "Delete Business Benefit Mapping by Id")
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/DeleteBusinessBenefitMappingById", method = RequestMethod.DELETE)
	public ResponseEntity deleteBusinessBenefitMappingById(@RequestHeader("API-KEY") String apiKey,
			@RequestParam("id") String id) throws UnauthorizedException, NoRecordsFoundException {
		if (!apiKey.equals(MessageEnum.API_KEY)) {
			throw new UnauthorizedException(MessageEnum.unathorized);
		}
		BusinessBenefitMappingDto businessBenefitMappingDto = businessBenefitMappingService.getById(Long.parseLong(id));
		if (businessBenefitMappingDto == null) {
			throw new NoRecordsFoundException(MessageEnum.enumMessage.ID_NOT_VALID.getMessage());
		}
		businessBenefitMappingService.deleteById(Long.parseLong(id));
		ResponseBean responseBean = new ResponseBean();
		responseBean.setBody(MessageEnum.enumMessage.SUCESS.getMessage());
		return new ResponseEntity(responseBean, org.springframework.http.HttpStatus.OK);

	}

	private BusinessBenefitMappingDto mapRequestToDto(BusinessBenefitMappingDto businessBenefitMappingDto,
			BusinessBenefitMappingRequestDto businessBenefitMappingRequestDto) {
		businessBenefitMappingDto.setId(businessBenefitMappingRequestDto.getId());
		businessBenefitMappingDto
				.setBusiness_benefit_other(businessBenefitMappingRequestDto.getBusiness_benefit_other());
		businessBenefitMappingDto.setBusinessBenefit(businessBenefitMappingRequestDto.getBusinessBenefit());
		return businessBenefitMappingDto;
	}

	private BusinessBenefitMappingRequestDto mapDtoToRequestDto(BusinessBenefitMappingDto rdto) {
		BusinessBenefitMappingRequestDto businessBenefitMappingRequestDto = new BusinessBenefitMappingRequestDto();
		businessBenefitMappingRequestDto.setId(rdto.getId());
		businessBenefitMappingRequestDto.setBusiness_benefit_other(rdto.getBusiness_benefit_other());
		businessBenefitMappingRequestDto.setBusinessBenefit(rdto.getBusinessBenefit());
		if (rdto.getProjectStakeholders() != null) {
			businessBenefitMappingRequestDto.setStake_holder_id(rdto.getProjectStakeholders().getId());
			/*
			businessBenefitMappingRequestDto.setStakeholderName(rdto.getProjectStakeholders().getStakeholderName());
			businessBenefitMappingRequestDto.setStakeholderType(rdto.getProjectStakeholders().getStakeholderType());
			businessBenefitMappingRequestDto.setRole(rdto.getProjectStakeholders().getRole());
			businessBenefitMappingRequestDto.setLocation(rdto.getProjectStakeholders().getLocation());
			businessBenefitMappingRequestDto.setNumberImpacted(rdto.getProjectStakeholders().getNumberImpacted());
			businessBenefitMappingRequestDto.setLevelOfInfluence(rdto.getProjectStakeholders().getLevelOfInfluence());
			businessBenefitMappingRequestDto
					.setEngagementStrategy(rdto.getProjectStakeholders().getEngagementStrategy());
			businessBenefitMappingRequestDto
					.setEngagementStrategyOther(rdto.getProjectStakeholders().getEngagementStrategyOther());*/
		}
		return businessBenefitMappingRequestDto;
	}

	private void getProjectBackGround(String id) throws NoRecordsFoundException {
		ProjectBackgroundDto dto = projectService.getById(Long.parseLong(id));
		if (dto == null) {
			throw new NoRecordsFoundException(MessageEnum.enumMessage.NO_RECORDS_BY_PROJECT_ID.getMessage());
		}
	}

}
