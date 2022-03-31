package com.work;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BoardServiceOracle extends DAO implements BoardService {

	@Override
	public void insertBoard(Board board) {
		conn = getConnect();
		String sql = "insert into board_info(b_no, b_title, b_contents,"
				+ " b_writer, b_date, b_password) "
				+ " values (?, ?, ?, ?, ?, ?)";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, board.getBno());
			psmt.setString(2, board.getBtitle());
			psmt.setString(3, board.getBcontents());
			psmt.setString(4, board.getBwriter());
			psmt.setString(5, board.getBdate());
			psmt.setInt(6, board.getBpassword());

			int r = psmt.executeUpdate();
			System.out.println(r + "건 추가됨.");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void modifyBoard(Board board) {
		conn = getConnect();
		String sql = "update board_info set b_title = ?," + "b_contents = ?" + "where b_no =?";

		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, board.getBtitle());
			psmt.setString(2, board.getBcontents());
			psmt.setInt(3, board.getBno());

			int r = psmt.executeUpdate();
			System.out.println(r + "건 수정됨.");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void deleteBoard(Board board) {
		conn = getConnect();
		String sql = "delete from board_info where b_no =?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, board.getBno());
			int r = psmt.executeUpdate();
			System.out.println(r + "건 삭제됨.");
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public List<Board> boardList() {
		List<Board> list = new ArrayList<Board>();
		conn = getConnect();
		String sql = "select*from board_info order by b_date DESC";

		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while (rs.next()) {
				Board board = new Board();
				board.setBno(rs.getInt("b_no"));
				board.setBtitle(rs.getString("b_title"));
				board.setBcontents(rs.getString("b_contents"));
				board.setBwriter(rs.getString("b_writer"));
				board.setBdate(rs.getString("b_date"));
				board.setBpassword(rs.getInt("b_password"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return list;

	}

	@Override
	public Board getBoard(int bno) {
		conn = getConnect();
		Board bod = null;
		try {
			psmt = conn.prepareStatement("select*from board_info where b_no = ?");
			psmt.setInt(1, bno);
			rs = psmt.executeQuery();
			if (rs.next()) {
				bod = new Board();
				bod.setBno(rs.getInt("b_no"));
				bod.setBtitle(rs.getString("b_title"));
				bod.setBcontents(rs.getString("b_contents"));
				bod.setBwriter(rs.getString("b_writer"));
				bod.setBdate(rs.getString("b_date"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return bod;
	}

	@Override
	public void deleteBoard(int bno) {

	}

}
