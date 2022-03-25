package com.edu.lambda.consumer;

import java.util.function.IntBinaryOperator;

public class OperatorExample {
	public static void main(String[] args) {

		IntBinaryOperator intBin = (left, right) -> left + right;
		intBin.applyAsInt(10, 20);

	    intBin = (num1, num2) -> num1 > num2 ? num1 : num2;
		int result = maxOrMin(intBin);
		System.out.println(result);
	}

	public static int maxOrMin(IntBinaryOperator intBin) {
		int[] intAry = { 85, 47, 92 };
		int result = intAry[0];
		for (int num : intAry) {
			result = intBin.applyAsInt(result, num);
		}
		return result;
	}
}
