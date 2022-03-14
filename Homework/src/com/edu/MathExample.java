package com.edu;

import java.util.Scanner;

public class MathExample {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int num1, num2, sum, 합, 차, 곱, 몫, 나머지 ;
		System.out.println("첫 번째 숫자");
		num1 = scn.nextInt();
		System.out.println("두 번째 숫자");
		num2 = scn.nextInt();
		합 = num1 + num2;
		차 = num1 - num2;
		곱 = num1 * num2;
		몫 = num1 / num2;
		나머지 = num1 % num2;
		
		System.out.println("두 수의 합: " + 합);
		System.out.println("두 수의 차: " + 차);
		System.out.println("두 수의 곱: " + 곱);
		System.out.println("두 수의 몫: " + 몫);
		System.out.println("두 수의 나머지: " + 나머지);
		
	}

}
