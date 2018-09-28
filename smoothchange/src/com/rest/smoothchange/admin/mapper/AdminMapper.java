/**
 * 
 */
package com.rest.smoothchange.admin.mapper;

import org.springframework.stereotype.Component;

import com.rest.framework.mapper.AbstractMapper;
import com.rest.smoothchange.admin.dto.AdminDto;
import com.rest.smoothchange.admin.entity.Admin;

@Component
public class AdminMapper extends AbstractMapper<AdminDto , Admin>{

	@Override
	public Admin mapDtoToEntity(AdminDto dto) {
	   Admin admin = null;
	   if(dto!=null) {
		   admin = new Admin();
		   admin.setId(dto.getId());
		   admin.setEmailAddress(dto.getEmailAddress());
		   admin.setPassword(dto.getPassword());
	   }
			
	   return admin;
	}

	@Override
	public AdminDto mapEntityToDto(Admin bo) {
		AdminDto admin = null;
		   if(bo!=null) {
			   admin = new AdminDto();
			   admin.setId(admin.getId());
			   admin.setEmailAddress(admin.getEmailAddress());
			   admin.setPassword(admin.getPassword());
		   }		
		   return admin;
	}	
}
