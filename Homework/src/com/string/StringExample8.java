package com.string;

public class StringExample8 {
	public static void main(String[] args) {
		String ssn = "9407041234567";
		int length = ssn.length();
		if (length == 13) {
			System.out.println("주민번호 자리수가 맞습니다.");

		} else {
			System.out.println("주민번호 자리수가 틀립니다.");
		}

	}
}
