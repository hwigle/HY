package com.dev;

import com.edu.Student;

public class GugudanEx {
	public static void printStar(int runCnt, String shape) {
		for (int i = 0; i < runCnt; i++) {
			System.out.print(shape);
		}
		System.out.println();
	}

	public static void main(String[] args) {
		for (int i = 1; i <= 5; i++) {
			printStar(i, "★"); // ○★
		}
		
//		int result = sum(sum(10, 20), sum(5, 7));
//		int[] newAry = { 10, 20, 30 };
//		result = sum(newAry);
//		System.out.println("결과는 " + result + "입니다.");
//		double result = divide(20, 100);
//		System.out.println("결과는 " + result + "입니다.");

	}

	public static int sum(int[] ary) {
		// 배열매개변수의 각 요소의 합을 구하는 메소드.
		int sum = 0;
		for (int i = 0; i < ary.length; i++) {
			sum += ary[i];
		}
		return sum;
	}

	// 나누기 메소드 ( int, int)
	public static double divide(int n1, int n2) {
		if (n2 == 0) {
			return 0;
		}
		return n1 / (double) n2;
	}

	public static int sum(int n1, int n2) {
		return n1 + n2;

	}

	public static void gugudan(int dan) {
		for (int j = 2; j <= 9; j++) {
			if (j == dan) {
				int cnt = j;
				System.out.println(j + "단");
				for (int i = 1; i <= 9; i++)
					System.out.println(j + " * " + i + " = " + (i * j));
			}
		}

	}

	public static void printGugudan() {
		for (int j = 1; j <= 9; j++) {

			int cnt = j;
			System.out.println();
			for (int i = 2; i <= 9; i++)

				System.out.printf(i + " * " + j + " = " + (j * i) + " ");
		}
	}

}
