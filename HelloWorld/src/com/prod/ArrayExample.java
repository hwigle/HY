package com.prod;

public class ArrayExample {
	public static void main(String[] args) {
		long l1 = 123456734634545L;
		int i1 = 100; // 4byte
		byte b1 = 127; // 1byte ( -128 ~ -1 / 0 ~ 127)
		b1++;
		b1++;
		short s1 = 32767; // ( -32768 ~ -1 / 0 ~ 32767
		s1++;
		// System.out.println(s1);

		int sum = 0;
		int score1 = 80;
		int score2 = 90;
		int score3 = 85;
		int score4 = 95;
		int score5 = 88;

		sum += score1;
		sum += score2;
		sum += score3;
		sum += score4;
		sum += score5;

		double avg = sum / (double) 5;

		int[] scores = new int[5];

		scores[0] = 80;
		scores[1] = 90;
		scores[2] = 85;
		scores[3] = 95;
		scores[4] = 88;

		// 배열을 활용해서 sum => avg
		sum = 0;
		for (int i = 0; i < 5; i++) {
			sum += scores[i];
			System.out.println(scores[i]); // scores[0] = 80
//			System.out.println(scores[0] + scores[1]);

		}
		avg = sum / (double) 5;
		System.out.println("평균은 " + avg + "입니다.");
	}
}
