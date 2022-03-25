package com.edu.lambda.consumer;

import java.util.function.ToIntFunction;


import com.edu.collect.Student;

import com.edu.collect.Student;
// Function 인터페이스 : 매핑작업

public class FunctionExample {
	public static void main(String[] args) {
		ToIntFunction<Student> func = 		
			(student) -> student.getEng()+ student.getKor();
			
			int result = func.applyAsInt(new Student(101, "Hong", 80, 90));
			System.out.println("결과값:" + result);
		}
}


