package com.dev;

import java.util.Scanner;

import com.edu.Student;

public class StudenEx {
	public static void main(String[] args) {
		// Scanner, 배열선언5개, 입력, 리스트출력.
		Scanner scn = new Scanner(System.in);
		Student[] students = new Student[5];

		while (true) {
			System.out.println("1.입력 2.리스트 3.종료");
			System.out.println("선택> ");
			int menu = scn.nextInt();
			if (menu == 1) {
				// 입력기능 구현.. 학번, 이름, 영어, 수학, 국어 => Student instance =>
				System.out.println("사용자 입력 기능입니다.");
				System.out.println("학번을 입력하세요>");
				int sno = scn.nextInt();
				System.out.println("이름을 입력하세요>");
				String sname = scn.next();
				System.out.println("영어 성적을 입력하세요>");
				int escore = scn.nextInt();
				System.out.println("수학 성적을 입력하세요>");
				int mscore = scn.nextInt();
				System.out.println("국어 성적을 입력하세요>");
				int kscore = scn.nextInt();

				Student s1 = new Student(sno, sname, kscore, mscore, escore);

				for (int i = 0; i < students.length; i++) {
					if (students[i] == null) {
						students[i] = s1;
						break;
					}
				}
				System.out.println("저장이 완료되었습니다.");
			} else if (menu == 2) {
//				System.out.println("리스트기능구현");
				for (int i = 0; i < students.length; i++) {
					if (students[i] != null) {

						System.out.println(students[i].getStudInfo());

					}
				}
				System.out.println("조회가 완료되었습니다.");
			} else if (menu == 3) {
				System.out.println("프로그램을 종료합니다.");
				break;
			} else {
				System.out.println("메뉴를 잘못 선택했습니다.");
			}

		}

		System.out.println("end of program");
	}
}
