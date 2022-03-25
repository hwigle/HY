package com.edu.api;

public class IDCheck {
//	 주민번호 입력 -> 남자인지 여자인지 확인
//	 ex) 950304-1234567, 950304 1234567, 9503041234567
//	 String getGender() -> 남자, 여자
	public String getGender(String ssn) {
		ssn = ssn.replace("-", "");
		ssn = ssn.replace(" ", "");
		char sex = ssn.charAt(6);
		switch (sex) {
		case '1':
		case '3':
			System.out.println("남자 입니다.");
			break;

		case '2':
		case '4':
			System.out.println("여자 입니다.");
			break;
		}
		return "";

	}

}
