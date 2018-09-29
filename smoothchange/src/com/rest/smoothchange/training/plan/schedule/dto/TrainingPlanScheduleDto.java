/**
 * 
 */
package com.rest.smoothchange.training.plan.schedule.dto;

import java.util.Date;

import com.rest.framework.dto.AbstractIdentifierDTO;
import com.rest.smoothchange.project.background.dto.ProjectBackgroundDto;


public class TrainingPlanScheduleDto extends AbstractIdentifierDTO{
	

	private ProjectBackgroundDto projectBackground;

	private String  session;

	private String  curriculumCovered;

	private String  instructor;

	private String  location;

	private Date dateTime;

	private String duration;

	public ProjectBackgroundDto getProjectBackground() {
		return projectBackground;
	}

	public void setProjectBackground(ProjectBackgroundDto projectBackground) {
		this.projectBackground = projectBackground;
	}

	public String getSession() {
		return session;
	}

	public void setSession(String session) {
		this.session = session;
	}

	public String getCurriculumCovered() {
		return curriculumCovered;
	}

	public void setCurriculumCovered(String curriculumCovered) {
		this.curriculumCovered = curriculumCovered;
	}

	public String getInstructor() {
		return instructor;
	}

	public void setInstructor(String instructor) {
		this.instructor = instructor;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Date getDateTime() {
		return dateTime;
	}

	public void setDateTime(Date dateTime) {
		this.dateTime = dateTime;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}
	
}
