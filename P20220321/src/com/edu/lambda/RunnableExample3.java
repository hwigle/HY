package com.edu.lambda;

interface Runnable3 {
	public int run(String str);
}

public class RunnableExample3 {
	public static void main(String[] args) {
		Runnable3 runnable = (String str) ->{
			return str.length();
		};
		int inth = runnable.run("Hello, World");
		System.out.println(inth);
	}
}
