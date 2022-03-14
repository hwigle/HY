package com.edu;

import java.util.Scanner;

public class ScannerExample { // com.edu.ScannerExample
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		
		System.out.println("첫번째 숫자를 입력하세요.");
		int val = scn.nextInt();
		System.out.println("두번째 숫자를 입력하세요.");
		int val2 = scn.nextInt();
		// val, val2의 값을 합한 결과를 변수 선언하고 결과를 저장.
		int sum = val + val2;
		
		System.out.println("두 수의합은 " + sum + "입니다.");
		if(sum % 2 == 0) {
			System.out.println("짝수입니다.");
		}
		if(sum % 2 == 1) {
			System.out.println("홀수입니다.");
		}
		scn.close();
	}

}
