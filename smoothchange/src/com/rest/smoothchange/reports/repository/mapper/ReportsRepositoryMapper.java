/**
 * 
 */
package com.rest.smoothchange.reports.repository.mapper;

import org.springframework.stereotype.Component;

import com.rest.framework.mapper.AbstractMapper;
import com.rest.smoothchange.project.background.dto.ProjectBackgroundDto;
import com.rest.smoothchange.project.background.entity.ProjectBackground;
import com.rest.smoothchange.reports.repository.dto.ReportsRepositoryDto;
import com.rest.smoothchange.reports.repository.entity.ReportsRepository;
import com.rest.smoothchange.user.dto.UserDto;
import com.rest.smoothchange.user.entity.User;
import com.rest.smoothchange.util.GeneratedOrUploaded;
import com.rest.smoothchange.util.ReportType;
import com.rest.smoothchange.util.TypeOfChange;

@Component
public class ReportsRepositoryMapper extends AbstractMapper<ReportsRepositoryDto , ReportsRepository>{

	@Override
	public ReportsRepository mapDtoToEntity(ReportsRepositoryDto dto) {
		ReportsRepository reportsRepository = null;
		ProjectBackground projectBackground = null;
		   if(dto!=null) { 
			   reportsRepository = new ReportsRepository();
			   reportsRepository.setComment(dto.getComment());
			   reportsRepository.setDateTime(dto.getDateTime());
			   GeneratedOrUploaded generatedOrUploaded = GeneratedOrUploaded.getValue(dto.getGeneratedOrUploaded());
			   reportsRepository.setGeneratedOrUploaded(generatedOrUploaded);
			   reportsRepository.setId(dto.getId());
			   reportsRepository.setReportFile(dto.getReportFile());
			   reportsRepository.setReportFileSize(dto.getReportFileSize());			   
			   ReportType reportType = ReportType.getValue(dto.getReportType());
			   reportsRepository.setReportType(reportType);
			   if(dto.getProjectBackground()!=null) {
				   projectBackground = new ProjectBackground();
				   projectBackground.setContactPerson(dto.getProjectBackground().getContactPerson());
				   projectBackground.setId(dto.getProjectBackground().getId());
				   projectBackground.setOtherTypeOfChange(dto.getProjectBackground().getOtherTypeOfChange());
				   projectBackground.setOwnerOfChange(dto.getProjectBackground().getOtherTypeOfChange());
				   projectBackground.setProjectDescription(dto.getProjectBackground().getProjectDescription());
				   projectBackground.setProjectName(dto.getProjectBackground().getProjectName());
				   TypeOfChange typeOfChange = TypeOfChange.getValue(dto.getProjectBackground().getTypeOfChange());
                   projectBackground.setTypeOfChange(typeOfChange); 
                   reportsRepository.setProjectBackground(projectBackground);
			   }			   		   
		   }		
		   return reportsRepository;
	}

	@Override
	public ReportsRepositoryDto mapEntityToDto(ReportsRepository bo) {
		ReportsRepositoryDto reportsRepository = null;
		ProjectBackgroundDto projectBackground = null;
		   if(bo!=null) {
			   reportsRepository = new ReportsRepositoryDto();
			   reportsRepository.setComment(bo.getComment());
			   reportsRepository.setDateTime(bo.getDateTime());		   
			   if(bo.getGeneratedOrUploaded()!=null) {
				   reportsRepository.setGeneratedOrUploaded(bo.getGeneratedOrUploaded().getGeneratedUpload());
			   }
			   reportsRepository.setId(bo.getId());
			   reportsRepository.setReportFile(bo.getReportFile());
			   reportsRepository.setReportFileSize(bo.getReportFileSize());	
			   if(bo.getReportType()!=null) {
				   reportsRepository.setReportType(bo.getReportType().getReportType());
			   }
			   if(bo.getProjectBackground()!=null) {
				   projectBackground = new ProjectBackgroundDto();
				   projectBackground.setContactPerson(bo.getProjectBackground().getContactPerson());
				   projectBackground.setId(bo.getProjectBackground().getId());
				   projectBackground.setOtherTypeOfChange(bo.getProjectBackground().getOtherTypeOfChange());
				   projectBackground.setOwnerOfChange(bo.getProjectBackground().getOtherTypeOfChange());
				   projectBackground.setProjectDescription(bo.getProjectBackground().getProjectDescription());
				   projectBackground.setProjectName(bo.getProjectBackground().getProjectName());
				   if(bo.getProjectBackground().getTypeOfChange()!=null) {
					   projectBackground.setTypeOfChange(bo.getProjectBackground().getTypeOfChange().getMessage()); 
				   }
				   reportsRepository.setProjectBackground(projectBackground);
			   }		   
		   }		
		   return reportsRepository;
	}	
}
