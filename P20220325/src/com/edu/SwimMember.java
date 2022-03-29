package com.edu;

public class SwimMember extends Member {
	// 강습반의 강사이름.
	// 수영등급(A,B,C,D)

	private String teacherNm;
	private String score;

	public SwimMember(int memberId, String memberName, String phone, String teacherNm, String score) {
		super(memberId, memberName, phone);
		this.teacherNm = teacherNm;
		this.score = score;
	}

	public String getTeacherNm() {
		return teacherNm;
	}

	public void setTeacherNm(String teacherNm) {
		this.teacherNm = teacherNm;
	}

	public String getScore() {
		return score;
	}

	public void setScore(String score) {
		this.score = score;
	}

	@Override
	public String toString() {
		String info = super.toString(); //부모클래스(Member)
		info += "\n[추가정보] 강사이름=" + teacherNm + ", 수영등급=" + score + "\n";
		return info;
	}
	
	// 정보출력시 => 강사이름: 홍길동, 등급: A
}
