package com.edu;

public class adf {
	public static void main(String[] args) {
		double weight = 67.5; // 72.5 ~ 62.5 사이에 적정.
		
		double realweight = 70;
		
		if(weight+5>realweight && weight-5<realweight) {
			System.out.println("적정몸무게 입니다.");
		} else { 
			System.out.println("적정몸무게가 아닙니다.");
		}
	}
}



