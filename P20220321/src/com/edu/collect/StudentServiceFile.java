package com.edu.collect;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class StudentServiceFile implements StudentService {
	List<Student> list = new ArrayList<Student>();
	File file;

	@Override
	public void insertStudent(Student student) {
		list.add(student);
	}

	@Override
	public Student getStudent(int sno) {
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getsNumber() == sno) {
				return list.get(i);
			}
		}
		return null;
	}

	@Override
	public List<Student> studentList() {
		return list;

	}

	@Override
	public void modifyStudent(Student student) {
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getsNumber() == student.getsNumber()) {
				list.get(i).setEng(student.getEng()); // 영어 점수 수정
				list.get(i).setKor(student.getKor()); // 국어 점수 수정
			}
		}
	}

	@Override
	public void removeStudent(int sno) {
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getsNumber() == sno) {
				list.remove(i);
			}
		}

	}

	@Override
	public List<Student> searchStudent(String sName) {
		List<Student> searchList = new ArrayList<Student>();
		// 찾았다고 종료X
		for (int i = 0; i < list.size(); i++) {
			// 같은 이름이 있는지 찾아보고 있으면 searchList.add();
			if (list.get(i).getsName().equals(sName)) {
				searchList.add(list.get(i));

			}
		}
		return searchList;
	}

	@Override
	public void saveToFile() {
		// 작성했던 ArrayList<Student> list => 파일저장
		try {
			FileWriter fw = new FileWriter("studentList.data");
			BufferedWriter bw = new BufferedWriter(fw);
			for (Student stud : list) {
				bw.write(stud.getsNumber() + ", " + stud.getsName() + ", " + stud.getEng() + ", " + stud.getKor());
			}
			bw.close();
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
