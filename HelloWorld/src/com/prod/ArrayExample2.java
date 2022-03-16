package com.prod;

public class ArrayExample2 {
	public static void main(String[] args) {
		// ages -> int 크기는 3개 20, 23, 27
		// sumAge, avgAge
		int[] ages = new int[3];

		ages[0] = 20;
		ages[1] = 23;
		ages[2] = 27;
		int sumAge = 0;
		double avgAge = sumAge / (double) 3;
		for (int i = 0; i < 3; i++) {

			System.out.println(ages[i] + "살 입니다.");
			sumAge = sumAge + ages[i];
			
		}
		System.out.println("합계는 " + sumAge + "입니다.");
		avgAge = sumAge / (double) 3;
		System.out.printf("%.2f", avgAge);
	}
}
