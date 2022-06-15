package com.edu;

public class BitExample {
	public static void main(String[] args) {
		int num = 10;
		int result = num << 2;
		System.out.println(result);
		
		int val = 100;
		val =val + 10;
		System.out.println(val);
		val += 20;
		System.out.println(val);
		
		val = val - 5;
		val -= 10;
		System.out.println(val);
		
		val = val * 2;
		val *= 2;
		System.out.println(val);
		
		String message = "반갑습니다";
		System.out.println(message);
		
		message = message + " 진휘용입니다";
		System.out.println(message);
		
		message += " 좋은 하루 되세요";
		System.out.println(message);
		
		int cnt = 0;
		cnt = cnt + 1;
		cnt += 1;
		cnt++;
		System.out.println(cnt);
	}

}
