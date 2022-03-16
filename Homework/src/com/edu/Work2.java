package com.edu;

import java.util.Scanner;

public class Work2 {
	public static void main(String[] args) {
		int num1, num2, num3;
		Scanner scn = new Scanner(System.in);
		System.out.println("첫번째 숫자를 입력하세요.");
		num1 = scn.nextInt();
		System.out.println("두번째 숫자를 입력하세요.");
		num2 = scn.nextInt();
		System.out.println("세번째 숫자를 입력하세요.");
		num3 = scn.nextInt();
		if (num1 > num2) {
			int tmp = num1;
			num1 = num2;
			num2 = tmp;
		}
		if (num1 > num3) {
			int tmp = num1;
			num1 = num3;
			num3 = tmp;
		}
		if (num2 > num3) {
			int tmp = num2;
			num2 = num3;
			num3 = tmp;
		}
		System.out.println("각 수의 순서는" + num1 + num2 + num3);
		scn.close();
	}
	
}
