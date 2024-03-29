package co.dev.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import co.dev.DAO;
import co.dev.vo.MemberVO;

public class MemberDAO extends DAO {

	public void updateMember(MemberVO vo) {
		conn = getConnect();
		String sql = "update member1 set name=?, email=?, passwd=? where id=?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getName());
			psmt.setString(2, vo.getEmail());
			psmt.setString(3, vo.getPasswd());
			psmt.setString(4, vo.getId());
			psmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
	}

	public void deleteMember(String id) {
		conn = getConnect();
		String sql = "delete from member1 where id=?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);
			psmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
	}

	public MemberVO searchMember(String id) {
		conn = getConnect();
		String sql = "select * from member1 where id=?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);
			rs = psmt.executeQuery();
			if (rs.next()) {
				MemberVO vo = new MemberVO();
				vo.setId(rs.getString("id"));
				vo.setName(rs.getString("name"));
				vo.setEmail(rs.getString("email"));
				vo.setPasswd(rs.getString("passwd"));
				return vo;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return null;
	}

	public List<MemberVO> listMember() {
		conn = getConnect();
		List<MemberVO> list = new ArrayList<MemberVO>();
		try {
			psmt = conn.prepareStatement("select * from member1 order by id");
			rs = psmt.executeQuery();
			while (rs.next()) {
				MemberVO vo = new MemberVO();
				vo.setEmail(rs.getString("email"));
				vo.setId(rs.getString("id"));
				vo.setName(rs.getString("name"));
				vo.setPasswd(rs.getString("passwd"));
				vo.setProfile(rs.getString("profile"));
				list.add(vo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return list;
	}

	public void insertMember(MemberVO member) {
		conn = getConnect();
		String sql = "insert into member1(id,name,passwd,email,profile) values(?,?,?,?,?)";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, member.getId());
			psmt.setString(2, member.getName());
			psmt.setString(3, member.getPasswd());
			psmt.setString(4, member.getEmail());
			psmt.setString(5, member.getProfile());

			int r = psmt.executeUpdate();
			System.out.println(r + "건 입력됨.");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
	}

}
