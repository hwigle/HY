package com.string;

public class StringExample10 {
	public static void main(String[] args) {
		String ssn = "888832-2345563";
		
		String firstNum = ssn.substring(0,6);
		System.out.println(firstNum);
		
		String SecondNum = ssn.substring(7);
		System.out.println(SecondNum);
	}

}
