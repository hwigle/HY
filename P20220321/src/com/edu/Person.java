package com.edu;

public class Person extends Object {
	// field. Person 클래스에 값을 담아놓기 위한 용도
	private String name;
	private int age;
	private double height;
	private double weight;

	// constructor. 클래스 이름가 똑같은 메소드 생성
	// overloading.(중복 선언)
	public Person() {

	}

	public Person(String name, int age, double height, double weight) {
		super();
		this.name = name;
		this.age = age;
		this.height = height;
		this.weight = weight;
	}

	// method 기능들을 담아놓는 필드의 값을 지정하거나 읽어올 떄 필드에게 직접 값을 지정하지 못하고 메소드를 통해 불러오는 용도
	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return this.name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

}
