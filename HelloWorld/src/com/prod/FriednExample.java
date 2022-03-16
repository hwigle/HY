package com.prod;

public class FriednExample {
	public static void main(String[] args) {
		// 친구의 정보 ( 이름, 전화번호, 이메일, 키, 몸무게)
		Friend f1 = new Friend();
		f1.friendName = "권가희";
		f1.friendPhone = "010-1234-5678";
		f1.email = "a@a.com";
		f1.height = 167.5;
		f1.weight = 55.7;

		Friend f2 = new Friend();
		f2.friendName = "이유빈";
		f2.friendPhone = "010-1333-1245";
		f2.email = "a@b.com";
		f2.height = 156.5;
		f2.weight = 45.7;

		Friend f3 = new Friend();
		f3.friendName = "나현주";
		f3.friendPhone = "010-1125-1214";
		f3.email = "a@ㅊ.com";
		f3.height = 176.5;
		f3.weight = 65.7;

//		System.out.println(f1);

		Friend[] friends = { f1, f2, f3 };

		for (int i = 0; i < friends.length; i++) {
			if (friends[i].height < 170) {

				System.out.println("이름 : " + friends[i].friendName);
				System.out.println("전화번호 : " + friends[i].friendPhone);
				System.out.println("키 : " + friends[i].height);
				System.out.println("==============================");
			}
		}
	}

}
