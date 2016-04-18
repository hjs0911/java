package kr.hkit.android_activity.layouts;

import java.io.Serializable;

public class Student implements Serializable {
	private String name;
	private int age;
	private String imgPath;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getImgPath() {
		return imgPath;
	}

	public void setImgPath(String imgPath) {
		this.imgPath = imgPath;
	}



}
