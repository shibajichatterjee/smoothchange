package com.rest.smoothchange.training.plan.schedule.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class TrainingPlanScheduleRequestDto {

	private long trainingPlanScheduleId;


	private String session;

	private String curriculumCovered;

	private String instructor;

	private String location;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private String dateTime;

	private String duration;


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

	public String getDateTime() {
		return dateTime;
	}

	public void setDateTime(String dateTime) {
		this.dateTime = dateTime;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	public long getTrainingPlanScheduleId() {
		return trainingPlanScheduleId;
	}

	public void setTrainingPlanScheduleId(long trainingPlanScheduleId) {
		this.trainingPlanScheduleId = trainingPlanScheduleId;
	}

}
