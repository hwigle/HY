package com.prod.emp;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmpDAO extends DAO {
	// 전체조회
	public List<Employee> empList() {
		List<Employee> employees = new ArrayList<Employee>();

		conn = getConnect();
		try {
			psmt = conn.prepareStatement("select*from emp_java");
			rs = psmt.executeQuery();
			while (rs.next()) {
				Employee emp = new Employee();
				emp.setEmployeeId(rs.getInt("employee_id"));// employees라는 테이블에 employee_id 칼럼에 들어가 있는 값을 읽어오겠습니다.
				emp.setFirstName(rs.getString("first_name"));
				emp.setLastName(rs.getString("last_name"));
				emp.setSalary(rs.getInt("salary"));
				emp.setHireDate(rs.getString("hire_date").substring(0, 10));
				emp.setJobId(rs.getString("job_id"));

				employees.add(emp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return employees;

	}

	// 한건조회
	public Employee selectEmp(int eid) {
		conn = getConnect();
		Employee emp = null;
		try {
			psmt = conn.prepareStatement("select*from emp_java where employee_id= ?");
			psmt.setInt(1, eid);
			rs = psmt.executeQuery();
			if (rs.next()) {
				emp = new Employee();
				emp.setEmployeeId(rs.getInt("employee_id"));// employees라는 테이블에 employee_id 칼럼에 들어가 있는 값을 읽어오겠습니다.
				emp.setFirstName(rs.getString("first_name"));
				emp.setLastName(rs.getString("last_name"));
				emp.setSalary(rs.getInt("salary"));
				emp.setHireDate(rs.getString("hire_date").substring(0, 10));
				emp.setJobId(rs.getString("job_id"));
				emp.setPhoneNumber(rs.getString("phone_number"));
			
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return emp;
	}

	// 입력처리 executeUpdate()
	public boolean insertEmp(Employee emp) {
		conn = getConnect();
		String 	sql = "insert into emp_java(employee_id, last_name, email, hire_date, job_id)\r\n"
				+ "values (?, ?, ?, ?, ?)";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, emp.getEmployeeId());
			psmt.setString(2, emp.getLastName());
			psmt.setString(3, emp.getEmail());
			psmt.setString(4, emp.getHireDate());
			psmt.setString(5, emp.getJobId());

			int r = psmt.executeUpdate();
			System.out.println(r + "건 추가됨.");
			if(r>0) {
				return true;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// 정상적으로 실행이 됐던 예외가 발생했던 반드시 실행할 코드를 입력
			disconnect();
		}
		return false;
	}

	// 수정처리
	public String updateEmp(Employee emp) {
		conn = getConnect();
		String sql = "update emp_java set first_name =? , phone_number = ?, " + "salary = ? " + "where employee_id = ?";
		try {
			psmt = conn.prepareStatement(sql);
			// 파라메타 값 지정
			psmt.setString(1, emp.getFirstName());
			psmt.setString(2, emp.getPhoneNumber());
			psmt.setInt(3, emp.getSalary());
			psmt.setInt(4, emp.getEmployeeId());

			int r = psmt.executeUpdate();
			System.out.println(r + "건 수정됨.");
			if(r>0) {
				return "OK";
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return "NG";
	}

	// 삭제처리
	public void deleteEmp(Employee emp) {
		conn = getConnect();
		String sql = "delete from emp_java where employee_id = ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, emp.getEmployeeId());
			int r = psmt.executeUpdate();
			System.out.println(r + "건 삭제됨.");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}

	}
}
