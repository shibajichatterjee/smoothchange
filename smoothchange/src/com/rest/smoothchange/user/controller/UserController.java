package com.rest.smoothchange.user.controller;

import java.io.IOException;
import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.rest.framework.bean.ResponseBean;
import com.rest.framework.constant.MessageEnum;
import com.rest.framework.exception.NoRecordsFoundException;
import com.rest.framework.exception.UnauthorizedException;
import com.rest.smoothchange.user.dto.UserDto;
import com.rest.smoothchange.user.dto.UserRequestDto;
import com.rest.smoothchange.user.service.UserService;
import com.rest.smoothchange.util.DateUtil;
import com.rest.smoothchange.util.ImageUtil;

@RestController
@RequestMapping(value = "/userAPI")
@Transactional
public class UserController {

	@Autowired
	private UserService userService;

	@RequestMapping(value = "/createUser", method = RequestMethod.POST)
	public ResponseEntity createUser(@RequestHeader("API-KEY") String apiKey, @RequestParam("file") MultipartFile file,
			@RequestParam("password") String password, @RequestParam("emailAddress") String emailAddress,
			@RequestParam("firstName") String firstName, @RequestParam("middleName") String middleName,
			@RequestParam("lastName") String lastName, @RequestParam("adminId") String adminId,
			@RequestParam("createdOn") String createdOn) throws UnauthorizedException, ParseException, IOException {

		if (!apiKey.equals(MessageEnum.API_KEY)) {
			throw new UnauthorizedException(MessageEnum.unathorized);
		}
		ResponseBean responseBean = new ResponseBean();
		UserDto userDto = new UserDto();
		userDto = mapUserRequestDtoToUserDto(userDto, file, password, emailAddress, firstName, middleName, lastName,
				adminId, createdOn);
		userService.create(userDto);
		responseBean.setBody(MessageEnum.enumMessage.SUCESS.getMessage());
		return new ResponseEntity(responseBean, org.springframework.http.HttpStatus.OK);

	}

	@RequestMapping(value = "/getUserById", method = RequestMethod.GET)
	public ResponseEntity createUser(@RequestHeader("API-KEY") String apiKey, @RequestParam("Id") long id)
			throws UnauthorizedException, ParseException, IOException, NoRecordsFoundException {

		if (!apiKey.equals(MessageEnum.API_KEY)) {
			throw new UnauthorizedException(MessageEnum.unathorized);
		}
		ResponseBean responseBean = new ResponseBean();
		UserDto userDto = userService.getById(id);
		if (userDto != null) {
			UserRequestDto userRequestDto = mapUserRequestDtoToUserDto(userDto);
			responseBean.setBody(userRequestDto);
		} else {
			throw new NoRecordsFoundException("User Not Found!");
		}
		return new ResponseEntity(responseBean, org.springframework.http.HttpStatus.OK);
	}

	@RequestMapping(value = "/updateUser", method = RequestMethod.POST)
	public ResponseEntity updateUser(@RequestHeader("API-KEY") String apiKey, @RequestParam("file") MultipartFile file,
			@RequestParam("password") String password, @RequestParam("emailAddress") String emailAddress,
			@RequestParam("firstName") String firstName, @RequestParam("middleName") String middleName,
			@RequestParam("lastName") String lastName, @RequestParam("adminId") String adminId,
			@RequestParam("createdOn") String createdOn, @RequestParam("Id") long id

	) throws UnauthorizedException, ParseException, IOException, NoRecordsFoundException {

		if (!apiKey.equals(MessageEnum.API_KEY)) {
			throw new UnauthorizedException(MessageEnum.unathorized);
		}

		ResponseBean responseBean = new ResponseBean();
		UserDto userDto = userService.getById(id);
		if (userDto != null && userDto.getId() > 0) {
			userDto = mapUserRequestDtoToUserDto(userDto, file, password, emailAddress, firstName, middleName, lastName,
					adminId, createdOn);
			userService.update(userDto);
		} else {
			throw new NoRecordsFoundException("User No Found");
		}
		responseBean.setBody(MessageEnum.enumMessage.SUCESS.getMessage());
		return new ResponseEntity(responseBean, org.springframework.http.HttpStatus.OK);
	}

	
	//===================== Private Method =======================
	private UserDto mapUserRequestDtoToUserDto(UserDto userDto, MultipartFile file, String password,
			String emailAddress, String firstName, String middleName, String lastName, String adminId, String createdOn)
			throws ParseException, IOException {
		userDto.setAdminId(adminId);
		if(createdOn!=null && createdOn.length()>0) {
		 userDto.setCreatedOn(DateUtil.getFormattedDate(createdOn, "yyyy-MM-dd"));
		}
		userDto.setEmailAddress(emailAddress);
		userDto.setFirstName(firstName);
		userDto.setLastName(lastName);
		userDto.setMiddleName(middleName);
		userDto.setPassword(password);
		if (file != null) {
			userDto.setPhoto(ImageUtil.getByteArrayFromMaltipartFormData(file));
		}
		return userDto;
	}

	private UserRequestDto mapUserRequestDtoToUserDto(UserDto userDto) throws ParseException {
		UserRequestDto userRequestDto = null;
		if (userDto != null) {
			userRequestDto = new UserRequestDto();
			userRequestDto.setAdminId(userDto.getAdminId());
			if (userDto.getCreatedOn() != null) {
				userRequestDto
						.setCreatedOn(DateUtil.getFormattedDateStringFromDate(userDto.getCreatedOn(), "yyyy-mm-dd"));
			}
			userRequestDto.setEmailAddress(userDto.getEmailAddress());
			userRequestDto.setFirstName(userDto.getFirstName());
			userRequestDto.setId(userDto.getId());
			userRequestDto.setLastName(userDto.getLastName());
			userRequestDto.setMiddleName(userDto.getMiddleName());
			userRequestDto.setPassword(userDto.getPassword());
			if (userDto.getPhoto() != null && userDto.getPhoto().length > 0) {
				userRequestDto.setPhoto(ImageUtil.getBase64FromByteArray(userDto.getPhoto()));
			}
		}
		return userRequestDto;
	}

}
