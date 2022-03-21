package com.edu.except;

import java.util.InputMismatchException;
import java.util.Scanner;

public class LibraryExe {
	public static void main(String[] args) {
		// 책제목, 저자, 가격 -> 저장.
		// 리스트 보여주기.
		Scanner scn = new Scanner(System.in);
		Book[] library = new Book[5];

		while (true) {
			int menu = 0;

			while (true) {
				try {
					showMessage("메뉴선택: 1. 책정보입력 2. 리스트보기 3. 종료");
					menu = scn.nextInt();
					break;
				} catch (InputMismatchException e) {
					System.out.println("숫자를 입력해야합니다.");
					scn.next(); // a를 넣었으면 a의 값을 소진시켜야함
				}
			}

			if (menu == 1) {
				showMessage("책제목입력>>");
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
						System.out.println("숫자를 입력하세요.");
						scn.next();
					}

					Book book = new Book(title, author, price);
					for (int i = 0; i < library.length; i++) {
						if (library[i] == null) {
							library[i] = book;
							break;
						}
					}
//					showMessage("저장완료\n");
				}
			} else if (menu == 2) {
				for (int i = 0; i < library.length; i++) {
					if (library[i] != null) {
						library[i].showInfo();
					}
				}
					} else if (menu == 3) {
						showMessage("프로그램을 종료합니다.\n");
						break;
					}
				}
			

			showMessage("===end of prog===\n");

		}

	

	public static void showMessage(String str) {
		for (int i = 0; i < str.length(); i++) {
			System.out.print(str.charAt(i));
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
