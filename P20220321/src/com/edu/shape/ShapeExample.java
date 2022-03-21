package com.edu.shape;

public class ShapeExample {
	public static void main(String[] args) {
		Shape s1 = new Ractangle();
		Shape s2 = new Circle();
		Shape s3 = new Triangle();

		if (s1 instanceof Ractangle) {
			Ractangle r1 = (Ractangle) s1;
			r1.setWidth(12.3);
			r1.setHeight(7.8);
			System.out.println(r1.getArea());

		if (s2 instanceof Circle) {
			Circle c1 = (Circle) s2;
			c1.setRadius(4);
			System.out.println(c1.getArea());
			}

		}
	}
}
