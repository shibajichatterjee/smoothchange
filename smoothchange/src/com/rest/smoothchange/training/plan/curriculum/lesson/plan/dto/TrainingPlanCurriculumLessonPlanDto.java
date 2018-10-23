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
	
	
}
