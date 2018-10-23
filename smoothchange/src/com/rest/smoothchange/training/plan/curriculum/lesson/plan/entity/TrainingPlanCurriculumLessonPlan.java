/**
 * 
 */
package com.rest.smoothchange.training.plan.curriculum.lesson.plan.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.rest.framework.entity.AbstractIdentifierObject;
import com.rest.smoothchange.project.background.entity.ProjectBackground;

@Entity
@Table(name = "TRAINING_PLAN_CURRICULUM_LESSON_PLAN")
public class TrainingPlanCurriculumLessonPlan extends AbstractIdentifierObject{
	
	private static final long serialVersionUID = 1L;
	
	
	@ManyToOne
	@JoinColumn(name="project_id")
	private ProjectBackground projectBackground;
	
	@Column(name="curriculum_unit_no")
	private String  curriculumUnitNo;
	
	@Column(name="curriculum_unit_name")
	private String  curriculumUnitName;
	
	@Column(name="lesson_unit_no")
	private String  lessonUnitNo;
	
	@Column(name="lesson_unit_name")
	private String  lessonUnitName;
		
	@Column(name="duration")
	private String  duration;

	public ProjectBackground getProjectBackground() {
		return projectBackground;
	}

	public void setProjectBackground(ProjectBackground projectBackground) {
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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
