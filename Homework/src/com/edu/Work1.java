package com.edu;

import java.util.Scanner;

public class Work1 {

	public static void main(String[] args) {
		int num1, num2;
		Scanner scn = new Scanner(System.in);
		System.out.println("첫번째 숫자를 입력하세요.");
		num1 = scn.nextInt();
		System.out.println("두번째 숫자를 입력하세요.");
		num2 = scn.nextInt();
		if (num1 > num2) {
			System.out.println("두 숫자의 차는 " + (num1 - num2) + "입니다.");
		} else {
			System.out.println("두 숫자의 차는 " + (num2 - num1) + "입니다.");
		}
	}

}
