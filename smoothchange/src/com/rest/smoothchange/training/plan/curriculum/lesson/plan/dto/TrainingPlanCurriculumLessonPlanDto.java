/**
 * 
 */
package com.rest.smoothchange.training.plan.curriculum.lesson.plan.dto;

import com.rest.framework.dto.AbstractIdentifierDTO;
import com.rest.smoothchange.project.background.dto.ProjectBackgroundDto;

public class TrainingPlanCurriculumLessonPlanDto extends AbstractIdentifierDTO{
	

	private ProjectBackgroundDto projectBackground;
	
	private String  curriculumUnitNo;
	
	private String  curriculumUnitName;
	
	private String  lessonUnitNo;
	
	private String  lessonUnitName;
		
	private String  duration;
	
	
	//============ Report Generation =============
	
	private String serialNumber;
	
	private String UnitNumber;
	
	private String UnitName;
	
	private String LessonUnitlNumber;

	
	//============ End Report Generation =============

	public ProjectBackgroundDto getProjectBackground() {
		return projectBackground;
	}

	public void setProjectBackground(ProjectBackgroundDto projectBackground) {
		this.projectBackground = projectBackground;
	}

	public String getCurriculumUnitNo() {
		return curriculumUnitNo;
	}

	public void setCurriculumUnitNo(String curriculumUnitNo) {
		this.curriculumUnitNo = curriculumUnitNo;
	}

	public String getCurriculumUnitName() {
		return curriculumUnitName;
	}

	public void setCurriculumUnitName(String curriculumUnitName) {
		this.curriculumUnitName = curriculumUnitName;
	}

	public String getLessonUnitNo() {
		return lessonUnitNo;
	}

	public void setLessonUnitNo(String lessonUnitNo) {
		this.lessonUnitNo = lessonUnitNo;
	}

	public String getLessonUnitName() {
		return lessonUnitName;
	}

	public void setLessonUnitName(String lessonUnitName) {
		this.lessonUnitName = lessonUnitName;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	//============= Report ===========
	
	public String getUnitNumber() {
		return UnitNumber;
	}

	public String getSerialNumber() {
		return serialNumber;
	}

	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}

	public void setUnitNumber(String unitNumber) {
		UnitNumber = unitNumber;
	}

	public String getUnitName() {
		return UnitName;
	}

	public void setUnitName(String unitName) {
		UnitName = unitName;
	}

	public String getLessonUnitlNumber() {
		return LessonUnitlNumber;
	}

	public void setLessonUnitlNumber(String lessonUnitlNumber) {
		LessonUnitlNumber = lessonUnitlNumber;
	}
	
	//============= End Report ===========
	
}
