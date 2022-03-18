package com.dev;

public class AccExample {
	public static void main(String[] args) {
		Account[] accounts;

		accounts = new Account[] { new Account("1-111", "Hong"), new Account("2-222", "Kong") };

		Account a1 = new Account(); // 실제(인스턴스)를 생성
		System.out.println(Account.bankName);
		Account.showBankName();
		
		// 쉐어하우스...주방,거실 vs 방,방..
		Calculator.sum(10,20);
		Calculator c1 = new Calculator();
		c1.sum(10, 20);
		
		Calculator.getArea(10);
		
		// static 활용.
	}

}
