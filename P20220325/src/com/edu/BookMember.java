package com.edu;

public class BookMember extends Member{

	private String topName;
	private String libInfo;
	
	

	public BookMember(int memberId, String memberName, String phone, String topName, String libInfo) {
		super(memberId, memberName, phone);
		this.topName = topName;
		this.libInfo = libInfo;
	}



	public String getTopName() {
		return topName;
	}



	public void setTopName(String topName) {
		this.topName = topName;
	}



	public String getLibInfo() {
		return libInfo;
	}



	public void setLibInfo(String libInfo) {
		this.libInfo = libInfo;
	}



	@Override
	public String toString() {
		String info = super.toString(); //부모클래스(Member)
		info += "\n[추가정보] 반장이름=" + topName + ", 강의실=" + libInfo + "\n";
		return info;
	}
	
	
	// 도서반의 반장이름.
	// 도서반의 강의실정보.(지혜실, 지식실, 모험실)
	
	
	
	// 정보출력시 => 반장이름: 홍길동, 강의실: 모험실 
}
