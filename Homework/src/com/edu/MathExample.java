package com.edu;

import java.util.Scanner;

public class MathExample {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int num1 = 10;
		int num2 = 5;
		System.out.println("두 수의 합을 출력 : " + (num1 + num2));
		System.out.println("두 수의 차를 출력 : " + (num1 - num2));
		System.out.println("두 수의 곱을 출력 : " + (num1 * num2));
		System.out.println("두 수의 몫을 출력 : " + (num1 / num2));
		System.out.println("나눈 나머지를 출력하도록 기능 구현 : " + (num1 & num2));
		
	}

}
