package com.edu;

import java.util.Scanner;

public class CashExample {
	public static void main(String[] args) {
		// 2개 값을 입력.
		int price, cash;
		Scanner scn = new Scanner(System.in);		
		// 가격을 입력하세요...
		System.out.println("가격을 입력하세요.");
		price = scn.nextInt(); //5500원은 부가세 10% 포함된 금액.
		System.out.println("부가세: " + (price * 0.1));
		// 손님이 낸 금액
		System.out.println("손님이 낸 금액을 입력하세요.");
		cash = scn.nextInt(); // 10000원
		System.out.println("거스름돈: " + (cash-(price+(price*0.1))));
		scn.close();
		
		// 하나는 상품의 부가세, 하나는 거스름돈
		// 부가세 : 500원
		// 거스름돈 : 4500원
	}

}
