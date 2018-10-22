package com.rest.smoothchange.training.plan.curriculum.lesson.plan.dto;

public class TrainingPlanCurriculumLessonPlanRequestDto {

	private long trainingPlanCurriculumLessonPlanId;
	
    private long projectBackgroundId;
	
	private String  curriculumUnitNo;
	
	private String  curriculumUnitName;
	
	private String  lessonUnitNo;
	
	private String  lessonUnitName;
		
	private String  duration;

	
	public long getTrainingPlanCurriculumLessonPlanId() {
		return trainingPlanCurriculumLessonPlanId;
	}

	public void setTrainingPlanCurriculumLessonPlanId(long trainingPlanCurriculumLessonPlanId) {
		this.trainingPlanCurriculumLessonPlanId = trainingPlanCurriculumLessonPlanId;
	}

	public long getProjectBackgroundId() {
		return projectBackgroundId;
	}

	public void setProjectBackgroundId(long projectBackgroundId) {
		this.projectBackgroundId = projectBackgroundId;
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
