package com.edu.lambda.consumer;

import java.util.function.*;

public class ConsumerExample {
	public static void main(String[] args) {
		// functional interface : 람다표현식 가능.

		Consumer<String> consumer = (String t) -> {
			System.out.println(t + " 출력합니다.");
		};
		consumer.accept("메세54456465465지");

		BiConsumer<Integer, Integer> biCon = (Integer t, Integer u) -> {
			System.out.println("result => " + (t + u));
		};
		biCon.accept(20, 40);
	}
}
