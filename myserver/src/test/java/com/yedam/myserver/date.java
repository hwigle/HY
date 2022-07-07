package com.yedam.myserver;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class date {
	public static void main(String args[]) {
		Calendar cal = Calendar.getInstance(); // cal 변수 선언에서 Calendar에서 인스턴스 가져오기
		cal.setTime(new Date()); // setTime는 Date 객체를 1970.01.01 부터 밀리 초 단위로 나타내는 시간으로 설정 
		DateFormat df = new SimpleDateFormat("yyyy년 MM월 dd일"); // DateFormat 클래스(추상 클래스)로 Date객체 받아옴(직접 생성자 호출x) -> getInstance 메소드로 객체화 
		System.out.println("시작날짜: " + df.format(cal.getTime()));		
		cal.add(Calendar.DATE, 30);
		System.out.println("종료날짜: " + df.format(cal.getTime()));
	}
}
