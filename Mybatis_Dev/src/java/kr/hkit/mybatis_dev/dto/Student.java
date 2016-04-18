package kr.hkit.mybatis_dev.dto;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Student {
	private int StudId;
	private String name, email;
	private PhoneNumber phone;
	private Date dob;
	private Address address;

	public int getStudId() {
		return StudId;
	}

	public void setStudId(int studId) {
		StudId = studId;
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

	public PhoneNumber getPhone() {
		return phone;
	}

	public void setPhone(PhoneNumber phone) {
		this.phone = phone;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	@Override
	public String toString() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		return String.format("Student [%s, %s, %s, %s, %s, %s]", StudId, name, email, phone, sdf.format(dob), address);
	}

}
