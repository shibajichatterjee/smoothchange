/**
 * 
 */
package com.rest.smoothchange.user.mapper;

import org.springframework.stereotype.Component;

import com.rest.framework.mapper.AbstractMapper;
import com.rest.smoothchange.user.dto.UserDto;
import com.rest.smoothchange.user.entity.User;

@Component
public class UserMapper extends AbstractMapper<UserDto , User>{

	@Override
	public User mapDtoToEntity(UserDto dto) {
		User user = null;
		   if(dto!=null) { 
			   user = new User();
			   user.setId(dto.getId());
			   user.setEmailAddress(dto.getEmailAddress());
			   user.setPassword(dto.getPassword());
			   user.setAdminId(dto.getAdminId());
			   user.setEmailAddress(dto.getEmailAddress());
			   user.setFirstName(dto.getFirstName());
			   user.setMiddleName(dto.getMiddleName());
			   user.setLastName(dto.getLastName());
			   user.setPhoto(dto.getPhoto());
			   user.setCreatedOn(dto.getCreatedOn());
		   }		
		   return user;
	}

	@Override
	public UserDto mapEntityToDto(User bo) {
		UserDto userDto = null;
		   if(bo!=null) {
			   userDto = new UserDto();
			   userDto.setId(bo.getId());
			   userDto.setEmailAddress(bo.getEmailAddress());
			   userDto.setPassword(bo.getPassword());
			   userDto.setAdminId(bo.getAdminId());
			   userDto.setEmailAddress(bo.getEmailAddress());
			   userDto.setFirstName(bo.getFirstName());
			   userDto.setMiddleName(bo.getMiddleName());
			   userDto.setLastName(bo.getLastName());
			   userDto.setPhoto(bo.getPhoto());
			   userDto.setCreatedOn(bo.getCreatedOn());
		   }		
		   return userDto;
	}	
}
