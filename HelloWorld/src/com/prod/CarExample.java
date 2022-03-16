package com.prod;

public class CarExample {
	public static void main(String[] args) {
		Car sonata = new Car();
		sonata.setModel("sonata DN8");
		sonata.setSpeed(0);
		sonata.setMaxSpeed(180);
		
		sonata.addSpeed();
		sonata.addSpeed();
		sonata.addSpeed();
		sonata.addSpeed();
		sonata.addSpeed();
		sonata.addSpeed();
		sonata.addSpeed();
		sonata.addSpeed();
		sonata.addSpeed();
		sonata.addSpeed();
		sonata.addSpeed();
		sonata.addSpeed();
		sonata.addSpeed();
		sonata.addSpeed();
		sonata.addSpeed();
		sonata.addSpeed(); sonata.addSpeed();sonata.addSpeed();sonata.addSpeed();sonata.addSpeed();sonata.addSpeed();sonata.addSpeed();
		System.out.println("현재 속도 : " + sonata.getSpeed() + "km입니다.");
		sonata.breakSpeed();
		System.out.println("현재 속도 : " + sonata.getSpeed() + "km입니다.");
		
		
	}

}
