package com.edu.collect;

import java.util.ArrayList;

public class ListExample {
	public static void main(String[] args) {
		String[] strings = new String[10];
		for (int i = 0; i < strings.length; i++) {
			if (strings[i] == null) {
				strings[i] = "hello";
				break;
			}
		}

		ArrayList<String> strAry = new ArrayList<String>();
		strAry.add("hello");
		strAry.add("world");
		
		strAry.get(1);
		strAry.set(1, "월드"); // 인덱스 1의 위치값을 월드로 수정
		strAry.remove("world");
		strAry.clear();
		System.out.println("strArty.size() => " + strAry.size());

		for (int i = 0; i < strAry.size(); i++) {
			String result = strAry.get(i);
			System.out.println(result);
		}

//		ArrayList<Integer> numAry = new ArrayList<Integer>();
//		for (int i = 0; i < numAry.size(); i++) {
//			int result = numAry.get(i);
//		}
	}
}
