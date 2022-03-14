package com.edu;

import java.util.Scanner;

public class MathExample {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int num1, num2, n1, n2, n3, n4, n5;
		
		System.out.println("첫 번째 숫자");
		num1 = scn.nextInt();
		System.out.println("두 번째 숫자");
		num2 = scn.nextInt();
		n1 = (int)(num1 + num2);
		n2 = (int)(num1 - num2);
		n3 = (int)(num1 * num2);
		n4 = (int)(num1 / num2);
		n5 = (int)(num1 % num2);
		
		System.out.println("두 수의 합: " + n1);
		System.out.println("두 수의 차: " + n2);
		System.out.println("두 수의 곱: " + n3);
		System.out.println("두 수의 몫: " + n4);
		System.out.println("두 수의 나머지: " + n5);
		scn.close();
	}

}
