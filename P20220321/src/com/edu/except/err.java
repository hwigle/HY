package com.edu.except;

import java.util.InputMismatchException;
import java.util.Scanner;

// 클래스A~클래스Z
// 클래스main -> main 메소드 포함.

public class err {

//   public static/**/ void main(String[] args) {
	public void run() {
		// 챡제목, 저자, 가격 -> 저장
		// 리스트 보여주기
		Scanner scn = new Scanner(System.in);
		Book[] library = new Book[5];

		while (true) {
			int menu = 0;

			while (true) {
				try {
					showMessage("메뉴선택: 1.책정보입력, 2.리스트보기, 3.종료\n");
					menu = scn.nextInt();
					break;
				} catch (InputMismatchException e) {
					System.out.println("숫자를 입력하십시오.");
					scn.next();
				}
			}

			if (menu == 1) {
				System.out.println("책정보를 입력하시오");
				showMessage("책제목 입력>>");
				String title = scn.next();
				showMessage("저자입력>>");
				String author = scn.next();
				int price = 0;

				while (true) {
					try {
						showMessage("가격입력>>");
						price = scn.nextInt();
						break;
					} catch (InputMismatchException e) {
						System.out.println("숫자를 입력하십시오.");
						scn.next(); // 예외발생시 문자출력 무한루프 피하기 위해 삽입
					}
				}

				Book book = new Book(title, author, price);
				for (int i = 0; i < library.length; i++) {
					if (library[i] == null) {
						library[i] = book;
						break;
					}
				}
				showMessage("저장완료\n");

			} else if (menu == 2) {
				for (int i = 0; i < library.length; i++) {
					if (library[i] != null) {
						library[i].showInfo(); // 책에 대한 정보
					}
				}

			} else if (menu == 3) {
				showMessage("프로그램을 종료합니다.");
				break;
			}
		} // end of while
		showMessage("\n=== end of program ===");

		scn.close();
	}

	public void showMessage(String str) {
		for (int i = 0; i < str.length(); i++) {
			System.out.print(str.charAt(i));
			try {
				Thread.sleep(100); // 300 = 0.3초
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}