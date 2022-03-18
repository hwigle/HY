package com.dev;

import java.util.Calendar;

public class WeekExample {
	public static void main(String[] args) {
		
		Week today = Week.MONDAY;
		
		Calendar day = Calendar.getInstance();
		System.out.println(day.get(Calendar.YEAR));
		System.out.println(day.get(Calendar.DAY_OF_WEEK));
		
		switch(day.get(Calendar.DAY_OF_WEEK)) {
		case 1:
			System.out.println(Week.SUNDAY);break;
		case 2:
			System.out.println(Week.MONDAY);break;
		case 3:
			System.out.println(Week.TUEDAY);break;
		case 4:
			System.out.println(Week.WEDDAY);break;
		case 5:
			System.out.println(Week.THUDAY);break;
		case 6:
			System.out.println(Week.FRIDAY);break;
		case 7:
			System.out.println(Week.SATDAY);break;
		}
	}

}
