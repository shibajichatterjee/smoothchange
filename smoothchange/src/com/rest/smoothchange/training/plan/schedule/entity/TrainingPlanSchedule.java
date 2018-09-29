/**
 * 
 */
package com.rest.smoothchange.training.plan.schedule.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.rest.framework.entity.AbstractIdentifierObject;
import com.rest.smoothchange.project.background.entity.ProjectBackground;

@Entity
@Table(name = "TRAINING_PLAN_SCHEDULE")
public class TrainingPlanSchedule extends AbstractIdentifierObject{
	
	private static final long serialVersionUID = 1L;

	
	@ManyToOne
	@JoinColumn(name="project_id")
	private ProjectBackground projectBackground;
	
	@Column(name="session")
	private String  session;
	
	@Column(name="curriculum_covered")
	private String  curriculumCovered;
	
	@Column(name="instructor")
	private String  instructor;
	
	@Column(name="location")
	private String  location;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="date_time")
	private Date dateTime;
  
	
	@Column(name="duration")
	private String duration;


	public ProjectBackground getProjectBackground() {
		return projectBackground;
	}


	public void setProjectBackground(ProjectBackground projectBackground) {
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


	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
