package kr.hkit.mybatis_dev.dto;

import java.util.Date;

public class Course {
	private int courseId;
	private String name, description;
	private Date startDate, endDate;
	private int tutorId;

	public int getCourseId() {
		return courseId;
	}

	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDAte() {
		return endDate;
	}

	public void setEndDAte(Date endDAte) {
		this.endDate = endDAte;
	}

	public int getTutorId() {
		return tutorId;
	}

	public void setTutorId(int tutorId) {
		this.tutorId = tutorId;
	}

	@Override
	public String toString() {
		return String.format("Course [%s, %s, %s, %s, %s, %s]", courseId, name, description, startDate, endDate,
				tutorId);
	}

}
