package com.edu.collect;

public class Student {
	// 학생번호(1,2,3), 이름(홍길동), 영어(80), 국어(85)
	// 생성자: 기본생성자, 매개값이 4개인 생성자.
	// Getter, Setter 생성.

	private String sName;
	private int sNumber;
	private int eng;
	private int kor;

	public Student() {

	}

	public Student(int sNumber, String sName, int eng, int kor) {
		super();
		this.sName = sName;
		this.sNumber = sNumber;
		this.eng = eng;
		this.kor = kor;
	}

	public String getsName() {
		return sName;
	}

	public void setsName(String sName) {
		this.sName = sName;
	}

	public int getsNumber() {
		return sNumber;
	}

	public void setsNumber(int sNumber) {
		this.sNumber = sNumber;
	}

	public int getEng() {
		return eng;
	}

	public void setEng(int eng) {
		this.eng = eng;
	}

	public int getKor() {
		return kor;
	}

	public void setKor(int kor) {
		this.kor = kor;
	}

	// tostring > 재정의
	@Override
	public String toString() {
		return "학생정보: 학생번호: " + sNumber + ", 이름: " + sName + ", 영어 점수: " + eng + ", 국어 점수:" + kor;
	}

}
