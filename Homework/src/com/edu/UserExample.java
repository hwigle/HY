package com.edu;

public class UserExample {
	public static void main(String[] args) {
		User u1 = new User();
		u1.setId("S73");
		u1.setGrade("A");
		u1.setPhone("010-1234-4567");
		u1.setPoint(1200);

		User u2 = new User();
		u2.setId("Y42");
		u2.setGrade("B");
		u2.setPhone("010-3456-1278");
		u2.setPoint(900);

		User u3 = new User();
		u3.setId("K15");
		u3.setGrade("C");
		u3.setPhone("010-1111-4444");
		u3.setPoint(200);
		
		User u4 = new User();
		u3.setId("H90");
		u3.setGrade("A");
		u3.setPhone("010-1111-4444");
		u3.setPoint(1800);

		System.out.println(u3.getUserInfo());
		
		User[] users = { u1, u2, u3};
		
		for(int i = 0; i < users.length; i++) {
			if(users[i].getGrade().equals("A") && users[i].getPoint() >= 1000) {
								System.out.println("등급이 A이고 포인트가 1000이상인 유저는 " + users[i].getId() + "입니다.");
			}
		}

	}
}
