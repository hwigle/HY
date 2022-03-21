package com.edu;

public class FriendListApp {
	public static void main(String[] args) {
		Friend[] friends = new Friend[10];

		Friend f1 = new Friend();
		f1.setName("진휘용");
		f1.setAge(25);
		f1.setHeight(178.3);
		f1.setWeight(68.9);
		f1.setPhone("010-2323-9845");

		UniFriend f2 = new UniFriend("서현일", 29, 178.3, 69.2, "010-1111-2222");
		f2.setUniversity("대구대");
		f2.setMajor("컴퓨터공학과");

		ComFriend f3 = new ComFriend("최규완", 29, 178.3, 69.2, "010-1111-2222", "네이버", "지도app개발연구원");

		Friend f4 = new Friend();
		f4.setName("진휘용");
		f4.setAge(25);
		f4.setHeight(178.3);
		f4.setWeight(68.9);
		f4.setPhone("010-2323-9845");

		UniFriend f5 = new UniFriend("권경완", 29, 178.3, 69.2, "010-1111-2222");
		f5.setUniversity("대구대");
		f5.setMajor("컴퓨터공학과");

		ComFriend f6 = new ComFriend("조준희", 29, 178.3, 69.2, "010-1111-2222", "네이버", "지도app개발연구원");

		friends[0] = f1;
		friends[1] = f2;
		friends[2] = f3;
		friends[3] = f4;
		friends[4] = f5;
		friends[5] = f6;

		for (int i = 0; i < friends.length; i++) {
			if (friends[i] != null && friends[i] instanceof UniFriend) {
				System.out.println(friends[i].toString()); // 동일한 기능이지만 인스턴스종류에 따라 다른 결과 실행 => 다형성
			}
		}

//		for (int i = 0; i < friends.length; i++) {
//			if (friends[i] != null) {
//				System.out.println(friends[i].toString());
//			}
//		}
//
//		Friend friend = (Friend) f2; // UniFriend; Class 값의 instance getUniversity, getMajor
//		friend = f1;
//		UniFriend uni = null; // (UniFriend) friend;
//		if (friend instanceof UniFriend) { // friend변수값이 UniFriend의 인스턴스인지 확인하는 작업
//			uni = (UniFriend) friend; // Castring 강제형변환 해야함.
//			uni.getUniversity(); // 부모클래스의 참조변수 => 자식클래스의 참조변수에 할당이 가능.
//		}
	}

}
