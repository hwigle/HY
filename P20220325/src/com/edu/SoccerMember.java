package com.edu;

public class SoccerMember extends Member{
	// 축구반의 코치이름.
	// 락커룸의 이름.(A, B, C, D)
	
	private String coachNm;
	private String rockerNm;
	
	
	public SoccerMember(int memberId, String memberName, String phone, String coachNm, String rockerNm) {
		super(memberId, memberName, phone);
		this.coachNm = coachNm;
		this.rockerNm = rockerNm;
	}
	
	public String getCoachNm() {
		return coachNm;
	}

	public void setCoachNm(String coachNm) {
		this.coachNm = coachNm;
	}

	public String getRockerNm() {
		return rockerNm;
	}

	public void setRockerNm(String rockerNm) {
		this.rockerNm = rockerNm;
	}

	@Override
	public String toString() {
		String info = super.toString(); //부모클래스(Member)
		info += "\n[추가정보] 코치이름=" + coachNm + ", 라커룸=" + rockerNm + "\n";
		return info;
	}
	
	
	
	// 정보출력시 => 코치이름: 홍길동, 락커룸: A 
}
