package com.edu.except;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ExceptionExample {
	public static void main(String[] args) {
		// 예외란 프로그램의 오류 : Error, Exception
		// compile error. 실제 시험해봐야 아는 에러 = runtime error
		try {
			double result = 13 / 0;
			System.out.println("결과 : " + result);
		} catch (ArithmeticException e) {
//				e.printStackTrace();
			System.out.println("0으로 나눌 수 없습니다.");
		}

		Scanner scn = new Scanner(System.in);
		System.out.println("숫자를 입력하세요.");
		try {
			int menu = scn.nextInt();
		} catch (InputMismatchException e) {
			System.out.println("숫자를 입력 안하셨네요.");
		}
		scn.close();
		System.out.println("end of program");
	}
}
