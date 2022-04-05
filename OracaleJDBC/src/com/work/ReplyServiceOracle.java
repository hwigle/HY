package com.work;


import java.sql.SQLException;
import java.util.List;


public class ReplyServiceOracle extends DAO implements ReplyService {

	@Override
	public void insertReply(Reply reply) {
		conn = getConnect();
		String sql = "insert into reply_info(r_no, r_contents, " 
					+ "r_writer)" + "values(?,?,?)";
		try {
			psmt =conn.prepareStatement(sql);
			psmt.setInt(1, reply.getRno());
			psmt.setString(2, reply.getRcontents());
			psmt.setString(3, reply.getRwriter());
						
			int r = psmt.executeUpdate();
			System.out.println(r + "건 작성됨.");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void modifyReply(Reply reply) {

		
	}

	@Override
	public void deleteReply(Reply reply) {

		
	}

	
		


	@Override
	public Reply getReply(String rwriter) {
		conn = getConnect();
		Reply rp = null;
		try {
			psmt = conn.prepareStatement("select*from reply_info where r_writer = ?");
			psmt.setString(1, rwriter);
			rs= psmt.executeQuery();
			if(rs.next()) {
				rp = new Reply();
				rp.setRcontents(rs.getString("r_contents"));
				rp.setRwriter(rs.getString("r_writer"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		
	}finally {
		disconnect();
	}
		return rp;
	}

	@Override
	public List<Reply> replyList() {
		return null;
	}

	
}
