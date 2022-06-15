package com.edu;

public class VariableExample {
	public static void main(String[] args) {
		// 변수의 타입.
		int num1 = 100; // int 정수
		double num2 = 100.5; // doulbe 소수점까지 표현.
		double result = num1 * num2; // 10050;
		System.out.println(result);
		// 자동형변환: 작은범위 -> 큰범위
		System.out.println("결과: " + num1);
		// 강제형변환: 큰범위 -> 작은범위
		int val1 = 100;
		double val2 = 20.5; //20
		int sum =val1 + (int) val2;
		System.out.println("결과: " + sum);
		
		int n1 = 11;
		int n2 = 4;
		
		double n3 = (double)n1 / n2; // 10/4 = 2.5
		System.out.println("나눈 결과: " + n3);
		
		// 나머지 10을 3으로 나눈 나머지 => 1
		int n4 = n1 % n2;
		System.out.println("나머지: " + n4);
		
		//짝수, 홀수
		if(n1 % 2 == 1) {
			System.out.println(n1 + "의 값은 홀수입니다.");
		}
	}
	

}
