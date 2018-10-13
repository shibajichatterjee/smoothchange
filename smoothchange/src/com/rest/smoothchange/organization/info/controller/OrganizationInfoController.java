package com.rest.smoothchange.organization.info.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.MatchAlwaysTransactionAttributeSource;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.rest.framework.bean.ResponseBean;
import com.rest.framework.constant.MessageEnum;
import com.rest.framework.exception.NoEnumRecordsFoundException;
import com.rest.framework.exception.NoRecordsFoundException;
import com.rest.smoothchange.organization.info.dto.OrganizationInfoDto;
import com.rest.smoothchange.organization.info.dto.OrganizationInfoRequestDto;
import com.rest.smoothchange.organization.info.service.OrganizationInfoService;
import com.rest.smoothchange.util.ImageUtil;



@RestController
@RequestMapping(value = "/organisationInfoAPI")
@Transactional
public class OrganizationInfoController {

	@Autowired
	private OrganizationInfoService organizationInfoService;


	@RequestMapping(value="/saveOrganizationInfo" ,method = RequestMethod.POST)
	public ResponseEntity saveOrganizationInfo(@RequestParam("file") MultipartFile file, @RequestParam("organisationName") String organisationName ,@RequestParam("address") String address) throws IOException {
		
		ResponseBean responseBean = new ResponseBean();
		byte [] byteArray = ImageUtil.getByteArrayFromMaltipartFormData(file);
		OrganizationInfoDto organizationInfoDto = new OrganizationInfoDto();
		organizationInfoDto.setAddress(address);
		organizationInfoDto.setOrganisationName(organisationName);
		organizationInfoDto.setLogo(byteArray);	
		organizationInfoService.create(organizationInfoDto);
		responseBean.setBody(MessageEnum.enumMessage.SUCESS.getMessage());
		return new ResponseEntity(responseBean, org.springframework.http.HttpStatus.OK);
		
	}
	
	
	@RequestMapping(value="/getOrganizationInfoById" ,method = RequestMethod.GET)
	public ResponseEntity getOrganizationInfoById(@RequestParam("organizationId") long organizationId) throws IOException, NoRecordsFoundException {
		
		ResponseBean responseBean = new ResponseBean();
		OrganizationInfoDto organizationInfoDto = organizationInfoService.getById(organizationId);
		if(organizationInfoDto!=null && organizationInfoDto.getId()!=null) {
			OrganizationInfoRequestDto organizationInfoRequestDto = mapDtoToRequestDto(organizationInfoDto);
			responseBean.setBody(organizationInfoRequestDto);
		}else {
			throw new NoRecordsFoundException("Organization Info No Found");
		}
		return new ResponseEntity(responseBean, org.springframework.http.HttpStatus.OK);	
	}
	
	
	@RequestMapping(value="/updateOrganizationInfo" ,method = RequestMethod.POST)
	public ResponseEntity updateOrganizationInfo(@RequestParam("file") MultipartFile file,@RequestParam("organizationId")long organizationId ,@RequestParam("organisationName") String organisationName ,@RequestParam("address") String address) throws IOException, NoRecordsFoundException {
		
		ResponseBean responseBean = new ResponseBean();
		OrganizationInfoDto organizationInfoDto = organizationInfoService.getById(organizationId);
		if(organizationInfoDto!=null && organizationInfoDto.getId()!=null) {
			byte [] byteArray = ImageUtil.getByteArrayFromMaltipartFormData(file);
			organizationInfoDto.setAddress(address);
			organizationInfoDto.setOrganisationName(organisationName);
			organizationInfoDto.setLogo(byteArray);	
			organizationInfoService.update(organizationInfoDto);
			responseBean.setBody(MessageEnum.enumMessage.SUCESS.getMessage());		
		}else {
			throw new NoRecordsFoundException("Organization Info No Found");
		}
		return new ResponseEntity(responseBean, org.springframework.http.HttpStatus.OK);		
	}
	
	
	
	private OrganizationInfoRequestDto mapDtoToRequestDto(OrganizationInfoDto organizationInfoDto) {
		OrganizationInfoRequestDto organizationInfoRequestDto = null;
		if(organizationInfoDto!=null) {
			organizationInfoRequestDto = new OrganizationInfoRequestDto();
			organizationInfoRequestDto.setAddress(organizationInfoDto.getAddress());
			organizationInfoRequestDto.setOrganisationName(organizationInfoDto.getOrganisationName());	
			organizationInfoRequestDto.setLogo(ImageUtil.getByteArrayToBase64(organizationInfoDto.getLogo()));
		}
		return organizationInfoRequestDto;
	}

	
}
