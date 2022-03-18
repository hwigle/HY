package com.edu;

public class Star {
	public static void printStar(int runCnt, String shape) {
		for (int i = 0; i < runCnt; i++) {
			System.out.print(shape);
		}
		System.out.println();
	}

	public static void main(String[] args) {
		for (int i = 1; i <= 5; i++) {
			printStar(i, "*");
		}
	}
}
