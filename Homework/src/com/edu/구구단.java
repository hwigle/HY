package com.edu;

public class 구구단 {
	public static void main(String[] args) {
		for (int i = 2; i < 10; i++) {
			System.out.println("\n" + "[" + i + "단" + "]");
			for (int j = 1; j < 10; j++) {
				System.out.println(i + "x" + j + "=" + i * j);
			}
		}
		System.out.println();
		for (int i = 2; i < 10; i++) {
			System.out.println("\n" + "[" + i + "단" + "]");
			for (int j = 1; j < 10; j++) {
				System.out.print(i + "x" + j + "=" + i * j + "\t"); // print로 줄바꿈이 안 된채로 출력
			}
			System.out.println(); // 각 숫자의 단이 끝나고 줄바꿈 역할
		}		
		System.out.println();
		for(int i=2;i<10;i++) {
			System.out.print("[" + i + "단" + "]\t");
		}
		System.out.println();
		for (int i = 1; i < 10; i++) {
			for (int j = 2; j < 10; j++) {
				System.out.print(j + "x" + i + "=" + j * i + "\t");
			}
			System.out.println();
		}
	}
}
