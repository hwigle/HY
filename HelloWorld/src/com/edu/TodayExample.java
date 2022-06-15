package com.edu;

import java.util.Scanner;

//이름을 입력받도록 (String) > scn.nextline();
//연락처 입력 (String) > scn.nextline();
//나이 입력 (int) > scn.nextInt();
//키 입력 (double) > scn.nextdoulbe();
//몸무게 입력 (double) > scn.nextdouble();
//적정몸무게: (키 - 100) * 0.9 보다 크면 과체중 적으면 저체중. 
public class TodayExample {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String name, pnum;
		int age;
		double tall, weight;
		System.out.println("이름을 입력하세요.");
		name = scn.nextLine();
		System.out.println("연락처를 입력하세요.");
		pnum = scn.nextLine();
		System.out.println("나이를 입력하세요.");
		age = scn.nextInt();
		System.out.println("키를 입력하세요.");
		tall = scn.nextDouble();
		System.out.println("몸무게를 입력하세요");
		weight = scn.nextDouble();
				
		System.out.println("이름: " + name);
		System.out.println("연락처: " + pnum);
		System.out.println("나이: " + age);
		System.out.println("키: " + tall);
		System.out.println("몸무게: " + weight);
		System.out.println("적정몸무게:" +(tall-100)*0.9);
		if(((tall-100)*0.9) < weight) {
			System.out.println("과체중");
		} else {
			System.out.println("저체중");
		}
		scn.close();
	}
}
		
	