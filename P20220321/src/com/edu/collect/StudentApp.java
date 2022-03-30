package com.edu.collect;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StudentApp {

	List<Student> list = new ArrayList<Student>();
	Scanner scn = new Scanner(System.in);

	// 생성자
	public StudentApp() {
		list.add(new Student(101, "권가희", 50, 60));
		list.add(new Student(102, "유해정", 70, 80));
		list.add(new Student(103, "이유빈", 90, 70));
		list.add(new Student(104, "권가희", 50, 60));
	}

	// 멤버클래스.
	class StudentsServiceFile implements StudentService {

		@Override
		public void insertStudent(Student student) {
			list.add(student); // 추가.
		}

		@Override
		public Student getStudent(int sno) { // 학생번호로 한건 조회
			for (int i = 0; i < list.size(); i++) {
				if (list.get(i).getsNumber() == sno) {
					return list.get(i);
				}
			}
			return null;
		}

		@Override
		public List<Student> studentList() { // 전체 리스트
			return list;
		}

		@Override
		public void modifyStudent(Student student) { // 수정
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
			System.exit(0);
		}
	} // end of StudentServiceImpl

	public void execute() {
		StudentService service = null;
//				       service = new StudentServiceFile();
//					   service = new StudentServiceImpl();
					   service = new StudentServiceOracle();
		// 메뉴 : 1.추가 2.리스트 3.한건조회 4.수정 5.삭제 6.이름조회 9.종료
		while (true) {
			System.out.println("1.추가 2.리스트 3.한건조회 4.수정 5.삭제 6.이름조회 9.종료");
			System.out.println("선택>> ");

			int menu = scn.nextInt();
			if (menu == 1) {
				// 학생정보 추가입력 : 학생번호, 이름, 영어점수, 국어점수
				System.out.println("학생번호를 입력하세요.");
				int sNumber = scn.nextInt();
				System.out.println("학생의 이름을 입력하세요.");
				String sName = scn.next();
				System.out.println("영어 점수를 입력하세요.");
				int eng = scn.nextInt();
				System.out.println("국어 점수를 입력하세요.");
				int kor = scn.nextInt();

				Student s1 = new Student(sNumber, sName, eng, kor);
				service.insertStudent(s1);

			} else if (menu == 2) {
				List<Student> list = service.studentList();
				for (Student s : list) {
					System.out.println(s.toString());
				}
			} else if (menu == 3) { // 한건 조회.
				System.out.println("조회할 학생번호를 입력하세요.");
				int sNumber = scn.nextInt();
				Student student = service.getStudent(sNumber);
				if (student == null) {
					System.out.println("없는 학생번호 입니다.");
				} else {
					System.out.println(student.toString());
				}
			} else if (menu == 4) { // 수정
				
				System.out.println("수정할 학생번호를 입력하세요.");
//				s1.setsNumber(scn.nextInt());
				int sNumber = scn.nextInt();
				System.out.println("영어 점수를 입력하세요.");
//				s1.setEng(scn.nextInt());
				int eng = scn.nextInt();
				System.out.println("국어 점수를 입력하세요.");
//				s1.setKor(scn.nextInt());
				int kor = scn.nextInt();
				Student s1 = new Student(sNumber, null, eng, kor);
				service.modifyStudent(s1);
				System.out.println("처리가 완료되었습니다.");

			} else if (menu == 5) {
				System.out.println("삭제할 학생번호를 입력하세요.");
				int sNumber = scn.nextInt();

				service.removeStudent(sNumber);
				System.out.println("처리가 완료되었습니다.");
			} else if (menu == 6) {
				System.out.println("조회할 학생의 이름을 입력하세요.");
				String serachName = scn.next();

				List<Student> list = service.searchStudent(serachName);
				for (Student s : list) {
					System.out.println(s.toString());
				}
			} else if (menu == 9) {
				System.out.println("프로그램을 종료합니다.");
				service.saveToFile();
				break;
			}
		}
		System.out.println("end of prog");

	}
}
