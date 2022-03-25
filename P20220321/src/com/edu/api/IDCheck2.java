package com.edu.api;

public class IDCheck2 {

	public String getGender(String sno) {
		String result = null; // 초기화
		if (sno.length() == 14) { // 8번째
			char no = sno.charAt(7); // 1 => ??
			if (no == '1' || no == '3') {
				result = "남자";
			} else if (no == '2' || no == '4') {
				result = "여자";
			} else {
				result = "잘못된 번호입니다.";
			}
		} else if (sno.length() == 13) { // 7번째
			char no = sno.charAt(6); // 1 => ??
			if (no == '1' || no == '3') {
				result = "남자";
			} else if (no == '2' || no == '3') {
				result = "여자";
			} else {
				result = "잘못된 번호입니다.";

			}
		} else {
			result = "잘못된 번호입니다.";
		}
		return result;
	}
}