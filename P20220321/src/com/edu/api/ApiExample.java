package com.edu.api;

public class ApiExample {
	public static void main(String[] args) {

		Math.random(); // new math();
		long result = Math.round(3.5); // 반올림
		System.out.println("3.5의 반올림 값: " + result);

		double r1 = Math.ceil(3.1); // 올림
		System.out.println("3.1의 올림 값: " + r1);

		r1 = Math.floor(3.9); // 내림
		System.out.println("3.9의 내림 값: " + r1);

		r1 = Math.abs(-30); // 젇대값
		System.out.println("-30의 절대값: " + r1);

		System.out.println("end of prog");
	}
}
