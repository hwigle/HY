package com.project;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BoardServiceOracle extends DAO implements BoardService {

	@Override // 등록
	public void insertBoard(Board board) {
		conn = getConnect();
		String sql = "insert into board_info(b_no, b_title, b_contents, " + "b_writer, b_date, b_password) "
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

	@Override // 댓글 작성
	public void insertReply(Reply reply) {
		conn = getConnect();
		String sql = "insert into reply_info(r_no, r_contents, r_writer, r_date, b_no) " + "values(?,?,?,?,?) ";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, reply.getR_no());
			psmt.setString(2, reply.getR_contents());
			psmt.setString(3, reply.getR_writer());
			psmt.setString(4, reply.getR_date());
			psmt.setInt(5, reply.getB_no());
			int r = psmt.executeUpdate();
			System.out.println(r + "건 작성됨.");
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override // 게시글 수정
	public void modifyBoard(Board board) {
		conn = getConnect();
		String sql = "update board_info set b_title = ?, b_contents = ?, b_password = ? where b_no = ?";
//		String sql = "update board_info set b_title = ?, " 
//		+ "b_contents = ? " + "b_password = ? " + "where b_no = ? ";

		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, board.getBtitle());
			psmt.setString(2, board.getBcontents());
			psmt.setInt(3, board.getBpassword());
			psmt.setInt(4, board.getBno());

			int r = psmt.executeUpdate();
			System.out.println(r + "건 수정됨.");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override // 댓글 수정
	public void modifyReply(Reply reply) {
		conn = getConnect();
		String sql = "update reply_info set r_contents = ?, r_date = ? " + "where b_no = ? and r_no = ? ";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, reply.getR_contents());
			psmt.setString(2, reply.getR_date());
			psmt.setInt(3, reply.getB_no());
			psmt.setInt(4, reply.getR_no());

			int r = psmt.executeUpdate();
			System.out.println(r + "건 수정됨.");
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override // 게시글 삭제
	public void deleteBoard(Board board) {
		conn = getConnect();
		String sql = "delete from board_info where b_no = ? and b_password = ? ";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, board.getBno());
			psmt.setInt(2, board.getBpassword());
			int r = psmt.executeUpdate();
			System.out.println(r + "건 삭제됨.");
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override // 댓글 삭제
	public void deleteReply(Reply reply) {
		conn = getConnect();
		String sql = "delete from reply_info where r_no = ? and b_no = ? ";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, reply.getR_no());
			psmt.setInt(2, reply.getB_no());
			int r = psmt.executeUpdate();
			System.out.println(r + "건 삭제됨.");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override // 전체조회
	public List<Board> boardList() {
		List<Board> list = new ArrayList<Board>();
		conn = getConnect();
		String sql = "select*from board_info order by b_no" + " DESC";
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
				list.add(board);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return list;

	}

	@Override // 한건 조회
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

	@Override // 댓글조회
	public List<Reply> replyList(int bno) {
		List<Reply> list = new ArrayList<Reply>();
		conn = getConnect();
		try {
			psmt = conn.prepareStatement("select* from reply_info where b_no = ?");
			psmt.setInt(1, bno);
			rs = psmt.executeQuery();

			while (rs.next()) {
				Reply reply = new Reply();
				reply.setR_no(rs.getInt("r_no"));
				reply.setR_contents(rs.getString("r_contents"));
				reply.setR_writer(rs.getString("r_writer"));
				reply.setR_date(rs.getString("r_date"));
				reply.setB_no(rs.getInt("b_no"));
				list.add(reply);
			}
//			

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return list;
	}

	@Override // 게시글 번호
	public int getMaxnum() {
		conn = getConnect();
		int b_no = 0;
		try {
			psmt = conn.prepareStatement("select max(b_no) from board_info");
			rs = psmt.executeQuery();
			if (rs.next()) {
				b_no = rs.getInt("max(b_no)");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return b_no;
	}

	@Override // 댓글 번호
	public int getMaxnum2() {
		conn = getConnect();
		int r_no = 0;
		try {
			psmt = conn.prepareStatement("select max(r_no) from reply_info");
			rs = psmt.executeQuery();
			if (rs.next()) {
				r_no = rs.getInt("max(r_no)");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return r_no;
	}

}
