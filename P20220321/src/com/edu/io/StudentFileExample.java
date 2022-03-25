package com.edu.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StudentFileExample {
	static Scanner scn = new Scanner(System.in);
	static List<Student> list = new ArrayList<Student>();

	public static void main(String[] args) {
//		writeStudent();
		readStudent(); // 텍스트 101 홍길동 30 50 => new Student(101, 홍길동, 30, 50)

		for (Student student : list) {
			System.out.println(student.toString());
		}
		System.out.println("end of prog");
	} // end of main

	// student.txt 읽어들이는 메소드.
	public static void readStudent() {
		try {
			FileReader fr = new FileReader("student.txt");
			BufferedReader br = new BufferedReader(fr);
			String readStr = null;
			while ((readStr = br.readLine()) != null) {
				String[] contents = readStr.split(" "); // 101 Hong 20 30 불러온 파일 중 공란을 기준으로 split
				list.add(new Student(Integer.parseInt(contents[0]), contents[1], Integer.parseInt(contents[2]),
						Integer.parseInt(contents[3])));

				System.out.println(readStr);
			}

			br.close();
			fr.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void writeStudent() {
		try {
			FileWriter fw = new FileWriter("student.txt");
			BufferedWriter bw = new BufferedWriter(fw);

			while (true) {
				System.out.println("이름을 입력하세요. 101 Hong 20 30");
				String name = scn.nextLine();
				if (name.equals("stop")) {
					break;
				}
				bw.write(name + "\n");

			}

			bw.close();
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
