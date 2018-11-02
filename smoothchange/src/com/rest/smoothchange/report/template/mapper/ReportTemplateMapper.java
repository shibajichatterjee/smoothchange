/**
 * 
 */
package com.rest.smoothchange.report.template.mapper;

import org.springframework.stereotype.Component;

import com.rest.framework.mapper.AbstractMapper;
import com.rest.smoothchange.project.background.dto.ProjectBackgroundDto;
import com.rest.smoothchange.project.background.entity.ProjectBackground;
import com.rest.smoothchange.report.template.dto.ReportTemplateDto;
import com.rest.smoothchange.report.template.entity.ReportTemplate;
import com.rest.smoothchange.util.ReportType;
import com.rest.smoothchange.util.TypeOfChange;

@Component
public class ReportTemplateMapper extends AbstractMapper<ReportTemplateDto , ReportTemplate>{

	@Override
	public ReportTemplate mapDtoToEntity(ReportTemplateDto dto) {
		ReportTemplate reportTemplate = null;
		ProjectBackground projectBackground = null;
		   if(dto!=null) { 
			   reportTemplate = new ReportTemplate();
			   reportTemplate.setComment(dto.getComment());
			   reportTemplate.setUploadedOn(dto.getUploadedOn());
			   reportTemplate.setId(dto.getId());
			   reportTemplate.setTemplateFile(dto.getTemplateFile());
			   reportTemplate.setTemplateFileSize(dto.getTemplateFileSize());		   
			   ReportType reportType = ReportType.getValue(dto.getReportType());
			   reportTemplate.setReportType(reportType);
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
                   reportTemplate.setProjectBackground(projectBackground);
			   }			   		   
		   }		
		   return reportTemplate;
	}

	@Override
	public ReportTemplateDto mapEntityToDto(ReportTemplate bo) {
		ReportTemplateDto reportTemplateDto = null;
		ProjectBackgroundDto projectBackground = null;
		   if(bo!=null) {
			   reportTemplateDto = new ReportTemplateDto();
			   reportTemplateDto.setComment(bo.getComment());
			   reportTemplateDto.setUploadedOn(bo.getUploadedOn());   	  
			   reportTemplateDto.setId(bo.getId());
			   reportTemplateDto.setTemplateFile(bo.getTemplateFile());
			   reportTemplateDto.setTemplateFileSize(bo.getTemplateFileSize());
			   if(bo.getReportType()!=null) {
				   reportTemplateDto.setReportType(bo.getReportType().getReportType());
			   }
			   reportTemplateDto.setUserId(bo.getUserId());
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
				   reportTemplateDto.setProjectBackground(projectBackground);
			   }		   
		   }		
		   return reportTemplateDto;
	}	
}
