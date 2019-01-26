package com.rest.smoothchange.project.background.controller;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

import javax.transaction.SystemException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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
import com.rest.smoothchange.util.TypeOfChange;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/projectAPI")
@Api(value = "Project Background", description = "Operations For Project Background")

@Transactional
public class ProjectBckController {

	@Autowired
	private ProjectBackgroundService projectService;

	@RequestMapping(value = "/welcome", method = RequestMethod.GET)
	public String welcome() {

		String message = "WELCOME TO SMOOTHCHANGE";
		return message;
	}
	
	@Value("${DELETED_TABLE}")
	String deletedTable;

	@ApiOperation(value = "Add a project background")
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/AddProjectBackground", method = RequestMethod.POST)
	public ResponseEntity create(@RequestHeader("API-KEY") String apiKey,@RequestBody ProjectBackgroundDto projDto) throws NoEnumRecordsFoundException, UnauthorizedException {
		if(!apiKey.equals(MessageEnum.API_KEY))
		{
			throw new UnauthorizedException(MessageEnum.unathorized);
		}
		TypeOfChange type = TypeOfChange.getValue(projDto.getTypeOfChange());
		if (type == null) {

			throw new NoEnumRecordsFoundException("Type of Change not matched");
		}
		projectService.create(projDto);
		ResponseBean responseBean = new ResponseBean();
		responseBean.setBody(MessageEnum.enumMessage.SUCESS.getMessage());
		return new ResponseEntity(responseBean, org.springframework.http.HttpStatus.OK);

	}

	@ApiOperation(value = "Get project back ground by Id")
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/GetProjectBackgroundById", method = RequestMethod.GET)
	public ResponseEntity getProjectBackgroundById(@RequestHeader("API-KEY") String apiKey,@RequestParam("id") String id) throws NoRecordsFoundException, UnauthorizedException {
		if(!apiKey.equals(MessageEnum.API_KEY))
		{
			throw new UnauthorizedException(MessageEnum.unathorized);
		}
		ProjectBackgroundDto dto = projectService.getById(Long.parseLong(id));
		if (dto == null) {
			throw new NoRecordsFoundException(MessageEnum.enumMessage.NO_RECORDS.getMessage());
		}
		ResponseBean responseBean = new ResponseBean();
		responseBean.setBody(dto);
		return new ResponseEntity(responseBean, org.springframework.http.HttpStatus.OK);

	}

	@ApiOperation(value = "Get All Project")
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/GetProjectBackground", method = RequestMethod.GET)
	public ResponseEntity getProjectBackground(@RequestHeader("API-KEY") String apiKey) throws NoRecordsFoundException, UnauthorizedException {
		if(!apiKey.equals(MessageEnum.API_KEY))
		{
			throw new UnauthorizedException(MessageEnum.unathorized);
		}
		List<ProjectBackgroundDto> dtoList = projectService.getAll();
		if (dtoList == null || dtoList.size() == 0) {
			throw new NoRecordsFoundException(MessageEnum.enumMessage.NO_RECORDS.getMessage());
		}
		ResponseBean responseBean = new ResponseBean();
		responseBean.setBody(dtoList);
		return new ResponseEntity(responseBean, org.springframework.http.HttpStatus.OK);

	}

	@ApiOperation(value = "Modify a project background")
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/ModifyProjectBackground", method = RequestMethod.POST)
	public ResponseEntity modify(@RequestHeader("API-KEY") String apiKey,@RequestBody ProjectBackgroundDto projDto) throws NoEnumRecordsFoundException, UnauthorizedException {
		if(!apiKey.equals(MessageEnum.API_KEY))
		{
			throw new UnauthorizedException(MessageEnum.unathorized);
		}
		TypeOfChange type = TypeOfChange.getValue(projDto.getTypeOfChange());
		if (type == null) {

			throw new NoEnumRecordsFoundException("Type of Change not matched");
		}
		projectService.createOrUpdate(projDto);
		ResponseBean responseBean = new ResponseBean();
		responseBean.setBody(MessageEnum.enumMessage.SUCESS.getMessage());
		return new ResponseEntity(responseBean, org.springframework.http.HttpStatus.OK);

	}

	@ApiOperation(value = "Delete project back ground by Id")
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/DeleteProjectBackgroundById", method = RequestMethod.DELETE)
	public ResponseEntity deleteProjectBackground(@RequestHeader("API-KEY") String apiKey,@RequestParam("id") String id) throws UnauthorizedException, SystemException {
		if(!apiKey.equals(MessageEnum.API_KEY))
		{
			throw new UnauthorizedException(MessageEnum.unathorized);
		}
		try
		{
		projectService.deleteById(Long.parseLong(id));
		}catch(Exception e)
		{
			throw new SystemException("please delete all associated table data");
		}
		ResponseBean responseBean = new ResponseBean();
		responseBean.setBody(MessageEnum.enumMessage.SUCESS.getMessage());
		return new ResponseEntity(responseBean, org.springframework.http.HttpStatus.OK);

	}
	
	
	
	@ApiOperation(value = "Delete All Trancaction By Project Id")
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/DeleteAllTransactionProjectBackgroundById", method = RequestMethod.DELETE)
	public ResponseEntity deleteAllTransactionProjectBackgroundById(@RequestHeader("API-KEY") String apiKey, @RequestParam("id") String projectId)
			throws UnauthorizedException, SystemException, NoRecordsFoundException {
		 if(!apiKey.equals(MessageEnum.API_KEY))
		{
		 throw new UnauthorizedException(MessageEnum.unathorized);
		 }
		getProjectBackGround(projectId);
		if (deletedTable != null && !deletedTable.equals("")) {
			List<String> tableList = Arrays.asList(deletedTable.split(","));
			projectService.DeleteAllTransactionProjectBackgroundById(Long.parseLong(projectId), tableList);
		}
		ResponseBean responseBean = new ResponseBean();
		responseBean.setBody(MessageEnum.enumMessage.SUCESS.getMessage());
		return new ResponseEntity(responseBean, org.springframework.http.HttpStatus.OK);
	}
	
	
	private void getProjectBackGround(String id) throws NoRecordsFoundException {
		ProjectBackgroundDto dto = projectService.getById(Long.parseLong(id));
		if (dto == null) {
			throw new NoRecordsFoundException(MessageEnum.enumMessage.NO_RECORDS_BY_PROJECT_ID.getMessage());
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
