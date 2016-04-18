package kr.hkit.dto;

import java.util.Date;

public class Student {
	private int studId;
	private String name, email;
	private Date dob;

	public int getStudId() {
		return studId;
	}

	public void setStudId(int studId) {
		this.studId = studId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	@Override
	public String toString() {
		return String.format("Student [studId=%s, name=%s, email=%s, dob=%s]", studId, name, email, dob);
	}

}
