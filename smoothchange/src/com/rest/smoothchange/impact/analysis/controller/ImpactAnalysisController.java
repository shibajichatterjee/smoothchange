package com.rest.smoothchange.impact.analysis.controller;

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
import com.rest.smoothchange.impact.analysis.dto.ImpactAnalysisDto;
import com.rest.smoothchange.impact.analysis.dto.ImpactAnalysisRequestDto;
import com.rest.smoothchange.impact.analysis.service.ImpactAnalysisService;
import com.rest.smoothchange.project.background.dto.ProjectBackgroundDto;
import com.rest.smoothchange.project.background.service.ProjectBackgroundService;
import com.rest.smoothchange.project.stakeholders.dto.ProjectStakeholdersDto;
import com.rest.smoothchange.util.CommonUtil;
import com.rest.smoothchange.util.ImpactType;
import com.rest.smoothchange.util.LevelOfImpact;
import com.rest.smoothchange.util.PlannedActivity;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/impactAnalysisAPI")
@Api(value = "Impact Analysis", description = "Operations For Impact Analysis")
@Transactional
public class ImpactAnalysisController {

	@Autowired
	private ImpactAnalysisService impactAnalysisService;
	@Autowired
	private ProjectBackgroundService projectService;
	
	@Autowired
	private CommonUtil commonUtil;

	@ApiOperation(value = "Add Impact Analysis")
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/AddImpactAnalysis", method = RequestMethod.POST)
	public ResponseEntity create(@RequestHeader("API-KEY") String apiKey, @RequestParam("projectId") String id,
			@RequestBody ImpactAnalysisRequestDto impactAnalysisRequestDto)
			throws NoEnumRecordsFoundException, UnauthorizedException, NoRecordsFoundException {
		if (!apiKey.equals(MessageEnum.API_KEY)) {
			throw new UnauthorizedException(MessageEnum.unathorized);
		}
		ImpactType type = ImpactType.getValue(impactAnalysisRequestDto.getImpactType());
		if (type == null) {

			throw new NoEnumRecordsFoundException("Impact Type not matched");
		}
		LevelOfImpact levelOfImpact = LevelOfImpact.getValue(impactAnalysisRequestDto.getLevelOfImpact());
		if (levelOfImpact == null) {

			throw new NoEnumRecordsFoundException("Level Of Impact not matched");
		}
		PlannedActivity plannedActivity = PlannedActivity.getValue(impactAnalysisRequestDto.getPlannedActivity());
		if (plannedActivity == null) {

			throw new NoEnumRecordsFoundException("Planned Activity not matched");
		}

		commonUtil.getProjectBackGround(id);
		ImpactAnalysisDto dto =new ImpactAnalysisDto();
		dto = mapRequestToDto(dto,impactAnalysisRequestDto);
		dto.setProjectBackground(new ProjectBackgroundDto());
		dto.setProjectStakeholders(new ProjectStakeholdersDto());
		dto.getProjectStakeholders().setId(impactAnalysisRequestDto.getProjectStakeholdersId());
		dto.getProjectBackground().setId(Long.parseLong(id));
		impactAnalysisService.create(dto);
		ResponseBean responseBean = new ResponseBean();
		responseBean.setBody(MessageEnum.enumMessage.SUCESS.getMessage());
		return new ResponseEntity(responseBean, org.springframework.http.HttpStatus.OK);

	}

	@ApiOperation(value = "Modify Impact Analysis")
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/ModifyImpactAnalysis", method = RequestMethod.POST)
	public ResponseEntity Modify(@RequestHeader("API-KEY") String apiKey, 
			@RequestBody ImpactAnalysisRequestDto impactAnalysisRequestDto)
			throws NoEnumRecordsFoundException, UnauthorizedException, NoRecordsFoundException {
		if (!apiKey.equals(MessageEnum.API_KEY)) {
			throw new UnauthorizedException(MessageEnum.unathorized);
		}
		ImpactType type = ImpactType.getValue(impactAnalysisRequestDto.getImpactType());
		if (type == null) {

			throw new NoEnumRecordsFoundException("Impact Type not matched");
		}
		LevelOfImpact levelOfImpact = LevelOfImpact.getValue(impactAnalysisRequestDto.getLevelOfImpact());
		if (levelOfImpact == null) {

			throw new NoEnumRecordsFoundException("Level Of Impact not matched");
		}
		PlannedActivity plannedActivity = PlannedActivity.getValue(impactAnalysisRequestDto.getPlannedActivity());
		if (plannedActivity == null) {

			throw new NoEnumRecordsFoundException("Planned Activity not matched");
		}

		//commonUtil.getProjectBackGround(id);
		ImpactAnalysisDto dto=impactAnalysisService.getById(impactAnalysisRequestDto.getId()==null?0:impactAnalysisRequestDto.getId());
		if (dto == null) {
			throw new NoRecordsFoundException(MessageEnum.enumMessage.NO_RECORDS.getMessage()+"For this Impact Analysis ID");

		}
		dto = mapRequestToDto(dto,impactAnalysisRequestDto);
		//dto.getProjectBackground().setId(Long.parseLong(id));
		dto.setProjectStakeholders(new ProjectStakeholdersDto());
		dto.getProjectStakeholders().setId(impactAnalysisRequestDto.getProjectStakeholdersId());
		impactAnalysisService.update(dto);
		ResponseBean responseBean = new ResponseBean();
		responseBean.setBody(MessageEnum.enumMessage.SUCESS.getMessage());
		return new ResponseEntity(responseBean, org.springframework.http.HttpStatus.OK);

	}

	@ApiOperation(value = "Get Impact Analysis by Project Id")
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/GetImpactAnalysisByProjectId", method = RequestMethod.GET)
	public ResponseEntity getImpactAnalysisByProjectId(@RequestHeader("API-KEY") String apiKey,
			@RequestParam("projectId") String projectId) throws NoRecordsFoundException, UnauthorizedException {
		if (!apiKey.equals(MessageEnum.API_KEY)) {
			throw new UnauthorizedException(MessageEnum.unathorized);
		}
		List<ImpactAnalysisRequestDto> requestDtoList = new ArrayList<>();
		commonUtil.getProjectBackGround(projectId);
		List<ImpactAnalysisDto> dto = impactAnalysisService.getImpactAnalysisListByProjectId(Long.parseLong(projectId));
		if (dto == null || dto.size() == 0) {
			throw new NoRecordsFoundException(MessageEnum.enumMessage.NO_RECORDS.getMessage());
		}
		for (ImpactAnalysisDto impactAnalysisDto : dto) {
			requestDtoList.add(mapDtoToRequestDto(impactAnalysisDto));
		}
		ResponseBean responseBean = new ResponseBean();
		responseBean.setBody(requestDtoList);
		return new ResponseEntity(responseBean, org.springframework.http.HttpStatus.OK);

	}

	@ApiOperation(value = "Get Impact Analysis by Id")
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/GetImpactAnalysisById", method = RequestMethod.GET)
	public ResponseEntity getImpactAnalysisById(@RequestHeader("API-KEY") String apiKey,
			 @RequestParam("id") String id)
			throws NoRecordsFoundException, UnauthorizedException {
		if (!apiKey.equals(MessageEnum.API_KEY)) {
			throw new UnauthorizedException(MessageEnum.unathorized);
		}
		//commonUtil.getProjectBackGround(projectId);
		ImpactAnalysisDto dto = new ImpactAnalysisDto();
		/*dto.setId(Long.parseLong(id));
		dto.setProjectBackground(new ProjectBackgroundDto());
		dto.getProjectBackground().setId(Long.parseLong(projectId));*/
		dto = impactAnalysisService.getById(Long.parseLong(id));
		if (dto == null) {
			throw new NoRecordsFoundException(MessageEnum.enumMessage.NO_RECORDS.getMessage());
		}
		ResponseBean responseBean = new ResponseBean();
		responseBean.setBody(mapDtoToRequestDto(dto));
		return new ResponseEntity(responseBean, org.springframework.http.HttpStatus.OK);

	}
	
	@ApiOperation(value = "Delete Impact Analysis by Id")
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/DeleteImpactAnalysisById", method = RequestMethod.DELETE)
	public ResponseEntity deleteImpactAnalysisById(@RequestHeader("API-KEY") String apiKey,@RequestParam("id") String id) throws UnauthorizedException, NoRecordsFoundException {
		if(!apiKey.equals(MessageEnum.API_KEY))
		{
			throw new UnauthorizedException(MessageEnum.unathorized);
		}
		ImpactAnalysisDto dto=impactAnalysisService.getById(Long.parseLong(id));
		if(dto==null)
		{
			throw new NoRecordsFoundException(MessageEnum.enumMessage.ID_NOT_VALID.getMessage());

		}
		impactAnalysisService.deleteById(Long.parseLong(id));
		ResponseBean responseBean = new ResponseBean();
		responseBean.setBody(MessageEnum.enumMessage.SUCESS.getMessage());
		return new ResponseEntity(responseBean, org.springframework.http.HttpStatus.OK);

	}

	private ImpactAnalysisDto mapRequestToDto(ImpactAnalysisDto impactAnalysisDto,ImpactAnalysisRequestDto impactAnalysisRequestDto) {
		impactAnalysisDto.setOtherImpactType(impactAnalysisRequestDto.getOtherImpactType());
		impactAnalysisDto.setImpactType(ImpactType.getValue(impactAnalysisRequestDto.getImpactType()));
		impactAnalysisDto.setLevelOfImpact(LevelOfImpact.getValue(impactAnalysisRequestDto.getLevelOfImpact()));
		impactAnalysisDto.setPlannedActivity(PlannedActivity.getValue(impactAnalysisRequestDto.getPlannedActivity()));
		impactAnalysisDto.setId(impactAnalysisRequestDto.getId());
		
		return impactAnalysisDto;
	}

	private ImpactAnalysisRequestDto mapDtoToRequestDto(ImpactAnalysisDto impactAnalysisDto) {
		ImpactAnalysisRequestDto impactAnalysisRequestDto = new ImpactAnalysisRequestDto();
		impactAnalysisRequestDto.setImpactType(impactAnalysisDto.getImpactType().getNumVal());
		impactAnalysisRequestDto.setLevelOfImpact(impactAnalysisDto.getLevelOfImpact().getNumVal());
		impactAnalysisRequestDto.setPlannedActivity(impactAnalysisDto.getPlannedActivity().getNumVal());
		impactAnalysisRequestDto.setOtherImpactType(impactAnalysisDto.getOtherImpactType());
		impactAnalysisRequestDto.setId(impactAnalysisDto.getId());
		impactAnalysisRequestDto.setProjectStakeholdersId(impactAnalysisDto.getProjectStakeholders().getId());
		impactAnalysisDto.getProjectStakeholders().setId(impactAnalysisRequestDto.getProjectStakeholdersId());
		return impactAnalysisRequestDto;
	}

	/*private void getProjectBackGround(String id) throws NoRecordsFoundException {
		ProjectBackgroundDto dto = projectService.getById(Long.parseLong(id));
		if (dto == null) {
			throw new NoRecordsFoundException(MessageEnum.enumMessage.NO_RECORDS_BY_PROJECT_ID.getMessage());
		}
	}*/

}
