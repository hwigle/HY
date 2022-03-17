package com.edu;

public class User {
	// 사용자 아이디, 사용자등급(A,B,C), 사용자연락처, 사용자 포인트
	private String ID;
	private String Grade;
	private String phone;
	private int point;

	public void setId(String id) {
		this.ID = id;
	}

	public void setGrade(String grade) {
		this.Grade = grade;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public void setPoint(int point) {
		this.point = point;
	}

	public String getId() {
		return ID;
	}

	public String getGrade() {
		return Grade;
	}

	public String getPhone() {
		return phone;
	}

	public int getPoint() {
		return point;
	}
	public String getUserInfo() {
		String result = "ID " + this.ID + "의 등급은 " + this.Grade + "이고 " + "연락처는 " + this.phone + "이고 " + "포인트는 " + this.point + "입니다.";
		return result;
	}

}
