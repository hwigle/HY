package com.string;

public class StringExample12 {
	public static void main(String[] args) {
		String tel1 = "  053";
		String tel2 = "815  ";
		String tel3 = "    7041    ";

		String tel = tel1.trim() + "-" + tel2.trim() + "-" + tel3.trim();
		System.out.println(tel);
	}

}
