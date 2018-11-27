package com.rest.smoothchange.organization.info.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.MatchAlwaysTransactionAttributeSource;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.rest.framework.bean.ResponseBean;
import com.rest.framework.constant.MessageEnum;
import com.rest.framework.exception.NoEnumRecordsFoundException;
import com.rest.framework.exception.NoRecordsFoundException;
import com.rest.framework.exception.UnauthorizedException;
import com.rest.smoothchange.organization.info.dto.OrganizationInfoDto;
import com.rest.smoothchange.organization.info.dto.OrganizationInfoRequestDto;
import com.rest.smoothchange.organization.info.service.OrganizationInfoService;
import com.rest.smoothchange.util.ImageUtil;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/organisationInfoAPI")
@Api(value = "Organisation Information", description = "Operations For Organisation Information")

@Transactional
public class OrganizationInfoController {

	@Autowired
	private OrganizationInfoService organizationInfoService;

	/*@ApiOperation(value = "Add Organisation Information")
	@RequestMapping(value = "/AddOrganizationInfo", method = RequestMethod.POST)
	public ResponseEntity saveOrganizationInfo(@RequestHeader("API-KEY") String apiKey,
			@RequestParam("file") MultipartFile file, @RequestParam("organisationName") String organisationName,
			@RequestParam("address") String address) throws IOException, UnauthorizedException {

		if (!apiKey.equals(MessageEnum.API_KEY)) {
			throw new UnauthorizedException(MessageEnum.unathorized);
		}

		ResponseBean responseBean = new ResponseBean();
		byte[] byteArray = ImageUtil.getByteArrayFromMaltipartFormData(file);
		OrganizationInfoDto organizationInfoDto = new OrganizationInfoDto();
		organizationInfoDto.setAddress(address);
		organizationInfoDto.setOrganisationName(organisationName);
		organizationInfoDto.setLogo(byteArray);
		organizationInfoService.create(organizationInfoDto);
		responseBean.setBody(MessageEnum.enumMessage.SUCESS.getMessage());
		return new ResponseEntity(responseBean, org.springframework.http.HttpStatus.OK);

	}*/

	@ApiOperation(value = "Get Organisation Information By ID")
	@RequestMapping(value = "/getOrganizationInfoById", method = RequestMethod.GET)
	public ResponseEntity getOrganizationInfoById(@RequestHeader("API-KEY") String apiKey,
			@RequestParam("organizationId") long organizationId)
			throws IOException, NoRecordsFoundException, UnauthorizedException {
		if (!apiKey.equals(MessageEnum.API_KEY)) {
			throw new UnauthorizedException(MessageEnum.unathorized);
		}

		ResponseBean responseBean = new ResponseBean();
		OrganizationInfoDto organizationInfoDto = organizationInfoService.getById(organizationId);
		if (organizationInfoDto != null && organizationInfoDto.getId() != null) {
			OrganizationInfoRequestDto organizationInfoRequestDto = mapDtoToRequestDto(organizationInfoDto);
			responseBean.setBody(organizationInfoRequestDto);
		} else {
			throw new NoRecordsFoundException("Organization Info No Found");
		}
		return new ResponseEntity(responseBean, org.springframework.http.HttpStatus.OK);
	}

	@ApiOperation(value = "Populate Organisation Information")
	@RequestMapping(value = "/createOrUpdateOrganizationInfo", method = RequestMethod.POST)
	public ResponseEntity updateOrganizationInfo(@RequestHeader("API-KEY") String apiKey,
			@RequestParam("file") MultipartFile file, @RequestParam("organisationName") String organisationName,
			@RequestParam("address") String address)
			throws IOException, NoRecordsFoundException, UnauthorizedException {
		if (!apiKey.equals(MessageEnum.API_KEY)) {
			throw new UnauthorizedException(MessageEnum.unathorized);
		}
		OrganizationInfoDto organizationInfoDto = new OrganizationInfoDto();
		List<OrganizationInfoDto> organizationInfoDtoList = organizationInfoService.getAll();
		if (organizationInfoDtoList != null && organizationInfoDtoList.size() > 0) {
			organizationInfoDto.setAddress(organizationInfoDtoList.get(0).getAddress());
			organizationInfoDto.setId(organizationInfoDtoList.get(0).getId());
			organizationInfoDto.setLogo(organizationInfoDtoList.get(0).getLogo());
			organizationInfoDto.setOrganisationName(organizationInfoDtoList.get(0).getOrganisationName());
		}

		if (file != null) {
			byte[] byteArray = ImageUtil.getByteArrayFromMaltipartFormData(file);
			organizationInfoDto.setLogo(byteArray);
		}
		organizationInfoDto.setAddress(address);
		organizationInfoDto.setOrganisationName(organisationName);

		if (organizationInfoDto.getId() != null) {
			organizationInfoService.update(organizationInfoDto);
		} else {
			organizationInfoService.create(organizationInfoDto);
		}
		ResponseBean responseBean = new ResponseBean();
		responseBean.setBody(MessageEnum.enumMessage.SUCESS.getMessage());
		return new ResponseEntity(responseBean, org.springframework.http.HttpStatus.OK);
	}
	@ApiOperation(value = "Get Organisation Logo By ID")
	@RequestMapping(value = "/getOrganizationLogoById", method = RequestMethod.GET)
	public ResponseEntity getOrganizationLogoById(@RequestHeader("API-KEY") String apiKey,
			@RequestParam("organizationId") long organizationId)
			throws IOException, NoRecordsFoundException, UnauthorizedException {
		if (!apiKey.equals(MessageEnum.API_KEY)) {
			throw new UnauthorizedException(MessageEnum.unathorized);
		}

		ResponseBean responseBean = new ResponseBean();
		OrganizationInfoDto organizationInfoDto = organizationInfoService.getById(organizationId);
		if (organizationInfoDto != null && organizationInfoDto.getId() != null) {
			// OrganizationInfoRequestDto organizationInfoRequestDto =
			// mapDtoToRequestDto(organizationInfoDto);
			return ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG).body(organizationInfoDto.getLogo());
		} else {
			throw new NoRecordsFoundException("Organization Info No Found");
		}
	}

	private OrganizationInfoRequestDto mapDtoToRequestDto(OrganizationInfoDto organizationInfoDto) {
		OrganizationInfoRequestDto organizationInfoRequestDto = null;
		if (organizationInfoDto != null) {
			organizationInfoRequestDto = new OrganizationInfoRequestDto();
			organizationInfoRequestDto.setAddress(organizationInfoDto.getAddress());
			organizationInfoRequestDto.setOrganisationName(organizationInfoDto.getOrganisationName());
			organizationInfoRequestDto.setLogo(ImageUtil.getBase64FromByteArray(organizationInfoDto.getLogo()));
		}
		return organizationInfoRequestDto;
	}

}
