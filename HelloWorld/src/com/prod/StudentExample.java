package com.prod;

public class StudentExample {
	public static void main(String[] args) {
		Student s1 = new Student();
		//    필드.(field)
		s1.studentName = "홍길동";
		s1.korScore = 80;
		s1.engScore = 85;
		s1.stduy("국어");
		s1.eat("급식");
		s1.eat("간식");
		s1.eat("초콜렛");

		int v1 = s1.getkorScore();
		int v2 = s1.getengScore();
		System.out.println("국어 점수 : " + v1 + " 영어 점수 : " + v2);

	}

}
