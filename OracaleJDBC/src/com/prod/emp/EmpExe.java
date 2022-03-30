package com.prod.emp;

import java.util.Scanner;
import java.util.List;

public class EmpExe {
	public static void main(String[] args) {
		EmpDAO dao = new EmpDAO();
		Scanner scn = new Scanner(System.in);
		while (true) {
			System.out.println("1.사원리스트 2.입력 3.수정 4.삭제 5.한건조회 9.종료");
			System.out.println("메뉴선택>> ");

			int menu = scn.nextInt(); // 사원리스트
			if (menu == 1) {
				List<Employee> list = dao.empList(); // 전체조회기능.

				System.out.println("사원리스트");
				for (Employee emp : list) {
					System.out.println(emp.toString());
				}
			} else if (menu == 2) { // 입력
				// 사원번호, lastName, email, hireDate, jobId
				Employee emp = new Employee();
				System.out.println("사원번호를 입력하세요.");
				int employeeId = scn.nextInt();
				emp.setEmployeeId(employeeId);
				System.out.println("성을 입력하세요");
				emp.setLastName(scn.next());
				System.out.println("이메일을 입력하세요.");
				emp.setEmail(scn.next());
				System.out.println("입사일을 입력하세요.");
				emp.setHireDate(scn.next());
				System.out.println("직무를 입력하세요.");
				emp.setJobId(scn.next());

				boolean tOrF = dao.insertEmp(emp);
				if (tOrF) {
					System.out.println("정상");
				} else
					System.out.println("오류");

			} else if (menu == 3) {// 수정
				// 사원번호, 전화번호, firstName, salary
				Employee emp = new Employee();
				System.out.println("수정할 사원의 번호를 입력하세요.");
				emp.setEmployeeId(scn.nextInt());
				System.out.println("수정할 연락처를 입력하세요.");
				emp.setPhoneNumber(scn.next());
				System.out.println("수정할 이름을 입력하세요.");
				emp.setFirstName(scn.next());
				System.out.println("수정할 월급을 입력하세요.");
				emp.setSalary(scn.nextInt());

				String result = dao.updateEmp(emp);
				if (result.equals("OK")) {
					System.out.println("정상");
				} else
					System.out.println("에러");

			} else if (menu == 4) {// 삭제
				Employee emp = new Employee();
				System.out.println("삭제할 사원의 번호를 입력하세요.");
				emp.setEmployeeId(scn.nextInt());

				dao.deleteEmp(emp);

			} else if (menu == 5) {// 한건조회
				System.out.println("조회할 사원의 번호를 입력하세요.");
				int eid = scn.nextInt();
				Employee emp = dao.selectEmp(eid);
				if (emp == null)
					System.out.println("조회된 번호가 없습니다.");
				else
					System.out.println(emp.toString());

			} else if (menu == 9) { // 종료
				System.out.println("시스템을 종료합니다.");
				break;
			}
		}
	}
}
