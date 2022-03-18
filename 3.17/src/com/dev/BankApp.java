package com.dev;

import java.util.Scanner;

// BankApp(main method), Account(계좌번호, 예금주, 잔액)
public class BankApp {
	static Account[] banks = new Account[100];
	static Scanner scn = new Scanner(System.in);

	// 메뉴 1. 계좌 생성(계좌번호, 예금주, 예금액)
	// 2. 예금(계좌번호, 예금액) -> 최고에금액 100,000원
	// 3. 출금(번호, 출금액) -> 잔액보다 큰 금액 출금 못하도록.
	// 4. 잔액조회(계좌번호)
	// 5. 종료

	public static void main(String[] args) {
		while (true) {
			printMenu();
			int menu = scn.nextInt();

			if (menu == 1) {
				creatAccount();
			} else if (menu == 2) {
				deposit();
			} else if (menu == 3) {
				withdraw();
			} else if (menu == 4) {
				findAccountMoney();
			} else if (menu == 5) {
				transferAmount();
			} else if (menu == 6) {
				System.out.println("프로그램을 종료합니다.");
				break;
			} else if (menu == 9) {
				showList();
			}
		}
		System.out.println("===End of Prog===");
	} // end of main()

	// 메뉴 출력 기능
	public static void printMenu() {
		String menu = "=====================================================\r\n" + "1. 계좌 생성(계좌번호, 예금주, 예금액)\r\n"
				+ "2. 예금(계좌번호, 예금액) -> 최고예금액 100,000원\r\n" + "3. 출금(번호, 출금액) -> 잔액보다 큰 금액 출금 못하도록\r\n"
				+ "4. 잔액조회(계좌번호)\r\n" + "5. 송금(송금번호, 금액, 입금번호)\r\n" + "6. 종료\r\n"
				+ "=====================================================\r\n " + "선택> ";

		System.out.println(menu);
	}

	// 계좌생성 메소드
	public static void creatAccount() {
		System.out.println("계좌생성 기능");
		String accNo;
		while (true) {
			System.out.println("계좌번호 입력>> ");
			accNo = scn.next();
			if (searchAccountNo(accNo) != null) {
				System.out.println("이미 있는 계좌번호입니다. ");
				continue;
			}
			break;
		}
//		if (searchAccountNo(accNo) != null) {
//			System.out.println("이미 있는 계좌번호입니다. ");
//			return;
//		}

		System.out.println("예금주 입력 >>");
		String accName = scn.next();
		System.out.println("예금액 입력 >>");
		int money = scn.nextInt();

		// 계좌번호 있는지 체크
		if (searchAccountNo(accNo) != null) {
			System.out.println("이미 있는 계좌번호입니다. ");
			return;
		}

		Account accnt = new Account(accNo, accName, money);

		for (int i = 0; i < banks.length; i++) {
			if (banks[i] == null) {
				banks[i] = accnt;
				break;
			}
		}
		System.out.println("계좌가 정상적으로 생성되었습니다.");
	}

	// 예금 메소드
	public static void deposit() {
		System.out.println("예금 기능");
		System.out.println("계좌번호 입력>> ");
		String accNo = scn.next();
		for (int i = 0; i < banks.length; i++) {
			if (searchAccountNo(accNo) == null) {
				System.out.println("없는 계좌번호입니다.");
				return;
			}
		}
		System.out.println("예금액 입력>> ");
		int amt = scn.nextInt();
		int checkCnt = 0;
		for (int i = 0; i < banks.length; i++) {
			if (searchAccountNo(accNo) != null) {
				checkCnt = 1;
				int currAmt = banks[i].getMoney();
				if (currAmt + amt > 100000) { // 예금액이 10만원을 초과하지 않도록
					checkCnt = 2;
					break;
				}
				banks[i].setMoney(currAmt + amt); // 잔액 + 입금액
				break;
			} else {
				checkCnt = 0;
			}
		}
		if (checkCnt == 1) {
			System.out.println("정상적으로 처리되었습니다.");
		} else if (checkCnt == 2) {
			System.out.println("한도금액을 초과했습니다.");
		} else if (checkCnt == 0) {
			System.out.println("계좌번호가 없습니다.");
		}
	}

	// 출금 메소드
	public static void withdraw() {
		System.out.println("출금 기능");
		System.out.println("계좌번호>> ");
		String accNo = scn.next();
		for (int i = 0; i < banks.length; i++) {
			if (searchAccountNo(accNo) != null) {
				System.out.println("없는 게좌번호입니다.");
				return;
			}
		}
		System.out.println("출금액 입력>>");
		int amt = scn.nextInt();
		int checkCnt = 0;
		for (int i = 0; i < banks.length; i++) {
			if (searchAccountNo(accNo) != null) {
				checkCnt = 1;
				int currAmt = banks[i].getMoney();
				if (currAmt < amt) {
					checkCnt = 2;
					break;
				}
				banks[i].setMoney(currAmt - amt);
				break;
			}
		}
		if (checkCnt == 1) {
			System.out.println("정상적으로 처리되었습니다.");
		} else if (checkCnt == 2) {
			System.out.println("잔액이 부족합니다.");
		} else if (checkCnt == 0) {
			System.out.println("계좌번호가 없습니다.");
		}
	}

	// 잔액조회 메소드
	public static void findAccountMoney() {
		System.out.println("잔액조회 기능");
		System.out.println("계좌번호>> ");
		String accNo = scn.next();
		Account findAccount = searchAccountNo(accNo);
		if (findAccount == null) {
			System.out.println("계좌가 존재하지 않습니다.");
			return;
		}
		System.out.println("잔액: " + findAccount.getMoney());
	}

	// 송금 메소드
	public static void transferAmount() {
		System.out.println("송금할 계좌정보>> ");
		String sendAccntNo = scn.next();
		System.out.println("송금할 금액>>");
		int amt = scn.nextInt();
		System.out.println("입금받을 계좌정보");
		String receiveAccntNo = scn.next();
		
		Account sendAccnt = searchAccountNo(sendAccntNo);
		Account receiveAccnt = searchAccountNo(receiveAccntNo);
		
		if(sendAccntNo.equals(receiveAccnt)) {
			System.out.println("송금계좌와 입금계좌가 동일합니다.");
			return;			
		} else if(sendAccnt == null) {
			System.out.println("송금계좌정보가 정확하지 않습니다.");
			return;
		} else if(receiveAccnt == null) {
			System.out.println("입금계좌정보가 정확하지 않습니다.");
			return;
		}else if() {
			
		}
	}
//	
//		System.out.println("송금 기능");
//		System.out.println("계좌번호 입력>> ");
//		String accNo = scn.next();
//		for (int i = 0; i < banks.length; i++) {
//			if (searchAccountNo(accNo) == null) {
//				System.out.println("없는 계좌번호입니다.");
//				return;
//			}
//		}
//		System.out.println("송금액 입력>> ");
//		int trs = scn.nextInt();
//		int checkCnt = 0;
//		for (int i = 0; i < banks.length; i++) {
//			if (searchAccountNo(accNo) != null) {
//				checkCnt = 1;
//				int currAmt = banks[i].getMoney();
//				if (currAmt < trs) {
//					checkCnt = 2;
//					break;
//				}
//				banks[i].setMoney(currAmt - trs);
//
//				break;
//			} else {
//				checkCnt = 0;
//			}
//		}
//		if (checkCnt == 1) {
//			System.out.println("받는사람 계좌번호>>");
//			String accNo1 = scn.next();
//			for (int i = 0; i < banks.length; i++) {
//				if (searchAccountNo(accNo1) == null) {
//					System.out.println("없는 계좌번호입니다.");
//					return;
//				}
//
//			}
//			if (checkCnt == 1) {
//				System.out.println("송금이 완료되었습니다.");
//
//			}
//
//		} else if (checkCnt == 2) {
//			System.out.println("잔액이 부족합니다.");
//		} else if (checkCnt == 0) {
//			System.out.println("계좌번호가 없습니다.");
//		}
//	}

//		int checkCnt = 0;
//		for (int i = 0; i < banks.length; i++) {
//			if (searchAccountNo(accNo) != null) {
//				int cruuAmt = banks[i].getMoney();
//				System.out.println("현재 금액은 " + banks[i].getMoney() + "입니다.");
//			} else {
//				System.out.println("계좌번호가 없습니다.");
//			}
//			break;
//			if(banks[i] != null && banks[i].getAccNo().equals(accNo)) {
//				checkCnt =1 ;
//				int cruuAmt = banks[i].getMoney();
//				System.out.println("현재 금액은 "+banks[i].getMoney()+"입니다.");
//			}
//	}

//	}

	// 전체리스트 출력.
	public static void showList() {
		for (int i = 0; i < banks.length; i++) {
			if (banks[i] != null) {
				System.out.println(banks[i].toString());
			}
		}
	}

	// 계좌번호를 입력하면 배열(banks)에서 그 계좌번호를 반환하고 없으면 null을 반환하는 메소드
	public static Account searchAccountNo(String accNo) {
		for (int i = 0; i < banks.length; i++) {
			if (banks[i] != null && banks[i].getAccNo().equals(accNo)) {
				return banks[i];
			}
		}
		return null;
	}

}
