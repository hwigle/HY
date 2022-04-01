package com.edu.collect;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentServiceOracle extends DAO implements StudentService {

	@Override
	public void insertStudent(Student student) {
		conn = getConnect();
		String sql = "insert into student_info(student_no, "
				+ "student_name, eng_score, kor_score)\r\n"
				+ "values (?, ?, ?, ?)";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, student.getsNumber());
			psmt.setString(2, student.getsName());
			psmt.setInt(3, student.getEng());
			psmt.setInt(4, student.getKor());

			int r = psmt.executeUpdate();
			System.out.println(r + "건 추가됨.");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Student getStudent(int sno) {
		conn = getConnect();
		Student std = null;
		try {
			psmt = conn.prepareStatement("select*from student_info "
					+ "where student_no = ?");
			psmt.setInt(1, sno);
			rs = psmt.executeQuery();
			if (rs.next()) {
				std = new Student();
				std.setsNumber(rs.getInt("student_no"));
				std.setsName(rs.getString("student_name"));
				std.setEng(rs.getInt("eng_score"));
				std.setKor(rs.getInt("kor_score"));

			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return std;
	}

	@Override
	public List<Student> studentList() {
		List<Student> list = new ArrayList<Student>();
		conn = getConnect();
		String sql = "select * from student_info order by student_no";
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery(); // 실행이 건수만큼 반복
			while (rs.next()) { // 반복자를 통해 요소를 가지고 올 수 있는지 체크, 있으면 하나
				Student student = new Student();
				student.setsNumber(rs.getInt("student_no"));
				student.setsName(rs.getString("student_name"));
				student.setEng(rs.getInt("eng_score"));
				student.setKor(rs.getInt("kor_score"));

				list.add(student);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return list;
	}

	@Override
	public void modifyStudent(Student student) {
		conn = getConnect();
		String sql = "update student_info set eng_score = ?, " 
		+ "kor_score = ?" + "where student_no = ?";

		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, student.getEng());
			psmt.setInt(2, student.getKor());
			psmt.setInt(3, student.getsNumber());

			int r = psmt.executeUpdate();
			System.out.println(r + "건 수정됨.");
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void removeStudent(int sno) {
		conn = getConnect();
		String sql = "delete from student_info where student_no = ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, sno);

			int r = psmt.executeUpdate();
			System.out.println(r + "건 삭제됨.");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<Student> searchStudent(String sName) {
		List<Student> list = new ArrayList<Student>();
		conn = getConnect();
		Student std = null;
		try {
			psmt = conn.prepareStatement("select*from student_info where student_name = ?");
			psmt.setString(1, sName);
			rs = psmt.executeQuery();
			if (rs.next()) {
				std = new Student();
				std.setsNumber(rs.getInt("student_no"));
				std.setsName(rs.getString("student_name"));
				std.setEng(rs.getInt("eng_score"));
				std.setKor(rs.getInt("kor_score"));
				list.add(std);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return list;
	}

	@Override
	public void saveToFile() {

	}

}
