package com.prod;

public class Calculator {

	double PI = 3.14;

// 반환값     매개변수,  매개변수
	int add(int n1, int n2) {
		return n1 + n2;
	}

	// 반환: int, minus, v1, v2
	int minus(int v1, int v2) {
		return v1 - v2;
	}

	// 사각형의 넓이 계산
	double getRectArea(double x, double y) {
		return x * y;
	}

	// 원의 넓이 계산
	double getCircleArea(double radius) {
		return PI * radius * radius;
	}
}
