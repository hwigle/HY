package com.edu.collect;

import java.util.List;

public interface StudentService {
	// 기능에 대한 정의만 해놓음
	public void insertStudent(Student student); // 입력 용도
	public Student getStudent(int sno); // 한건 조회 용도
	public List<Student> studentList(); // 전체 목록
	public void modifyStudent(Student student); // 한건 수정
	public void removeStudent(int sno); // 삭제
	public List<Student> searchStudent(String sName); // 이름 조회
	public void saveToFile();
}
