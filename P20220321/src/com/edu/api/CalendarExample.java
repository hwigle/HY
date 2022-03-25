package com.edu.api;

import java.util.Calendar;

public class CalendarExample {
	public static void main(String[] args) {

		int year = 1994;
		int month = 7; // 

		creatCalendar(year, month);
	}

	public static void creatCalendar(int year, int month) {

		Calendar today = Calendar.getInstance();
		today.set(year, month - 1, 1);
		System.out.println("올해 : " + today.get(Calendar.YEAR));
		System.out.println("이번달 : " + today.get(Calendar.MONTH)); // MONTH = 0부터 시작

		System.out.println("오늘 : " + today.get(Calendar.DATE));
		System.out.println("요일정보 : " + today.get(Calendar.DAY_OF_WEEK)); // 0 = 일요일

		System.out.println("마지막날의 정보:" + today.getActualMaximum(Calendar.DATE));
		int gapDay = today.get(Calendar.DAY_OF_WEEK);
		int lastDate = today.getActualMaximum(Calendar.DATE);

		// 요일정보출력.
		String[] days = { "Sun", "Mon", "Tue", "Wed", "Thr", "Fri", "Sat" };
		for (int i = 0; i < days.length; i++) {
			System.out.printf("%4s", days[i]);
		}
		System.out.println();

		// 1일의 위치선정
		for (int i = 1; i < gapDay; i++) {
			System.out.printf("%4s", "");
		}
		// 날짜 출력
		for (int i = 1; i <= lastDate; i++) {
			System.out.printf("%4d", i);
			if ((i + gapDay - 1) % 7 == 0) {
				System.out.println();
			}
		}
		System.out.println("\nend of prog");

	}

}