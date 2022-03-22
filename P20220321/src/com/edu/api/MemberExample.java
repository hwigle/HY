package com.edu.api;

import java.util.ArrayList;
import java.util.HashSet;

public class MemberExample {
	public static void main(String[] args) {
		Member obj1 = new Member("blue", "홍길동"); // 새로운 인스턴스 생성
		Member obj2 = new Member("blue", "홍길");
		Member obj3 = new Member("red", "홍길순");

		if (obj1.equals(obj2)) {
			System.out.println("obj1과 obj2는 동일합니다.");
		} else {
			System.out.println("obj1과 obj2는 동일하지 않습니다.");
		}
		if (obj1.equals(obj3)) {
			System.out.println("obj1과 obj3은 동일합니다.");
		} else {
			System.out.println("obj1과 obj3은 동일하지 않습니다.");
		}

		// 배열 -> 컬렉션(ArrayList, HashSet, HashMap) : 여러개의 값을 저장.
		Member[] memberAry = new Member[5]; // Member의 인스턴트 최대 5개 지정
											// 크기가 초과하면 새로운 배열을 선언하고 원래있던 배열을 복사해서 담아둬야함.
		ArrayList<Member> memList = new ArrayList<Member>();
		memList.add(new Member("obj1", "홍길동"));
		memList.add(new Member("obj1", "홍길동"));
		for (int i = 0; i < memList.size(); i++) {
			System.out.println(memList.get(i));
		}

		HashSet<Member> memSet = new HashSet<Member>(); //
		memSet.add(new Member("obj1", "홍길동")); // hashCode(), equls()
		memSet.add(new Member("obj1", "홍길동"));

		System.out.println(memSet.size());
	}

}