package com.edu;

public class 별 {
	public static void main(String[] args) {
		// 별 1개씩 왼쪽에서 증가
		for (int line = 1; line <= 5; line++) {
			for (int star = 1; star <= line; star++) {
				System.out.print("*");
			}
			System.out.println("");
		}
		// 별 1개씩 오른쪽에서 증가
		System.out.println();
		for (int line = 1; line <= 5; line++) {
			for (int i = 5; i > 0; i--) {
				if (line < i) {
					System.out.print(" ");
				} else {
					System.out.print("*");
				}
			}
			System.out.println("");
		}
		// 별 1개씩 오른쪽에서 감소
		System.out.println();
		for (int line = 1; line <= 5; line++) {
			for (int i = 5; i >= line; i--) {
				System.out.print("*");
			}
			System.out.println(" ");
		}
		// 별 1개씩 왼쪽에서 감소
		System.out.println();
		for(int line = 1; line <=5; line++) {			
			for(int i =1; i<line; i++) {
				System.out.print(" ");
			}
			for(int j = 5; j>=line; j--) {
				System.out.print("*");
			}
			System.out.println("");
		}
	}
	
}
