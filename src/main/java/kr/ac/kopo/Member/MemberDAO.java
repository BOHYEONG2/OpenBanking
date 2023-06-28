package kr.ac.kopo.Member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import util.ConnectionFactory;

public class MemberDAO {

	public MemberVO login(MemberVO login) throws Exception {
		
		MemberVO loginUser = null;
		StringBuilder sql = new StringBuilder();
		sql.append("select * from user_info where id = ? and password = ? ");
		// SQL 쿼리를 작성하기 위한 StringBuilder 객체입니다.
		// 해당 쿼리는 t_member2 테이블에서 id와 password가 일치하는 회원 정보를 조회합니다.
		
		try(
			Connection conn = new ConnectionFactory().getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql.toString());
		) {
			
			pstmt.setString(1, login.getId());
			pstmt.setString(2, login.getPassword());
			
			ResultSet rs = pstmt.executeQuery();
			System.out.println(loginUser);
			if(rs.next()) {
				
				loginUser = new MemberVO();
				loginUser.setId(rs.getString("id"));
				loginUser.setPassword(rs.getString("password"));
				loginUser.setName(rs.getString("name"));
				loginUser.setEmail(rs.getString("email"));
				loginUser.setUsercode(rs.getString("usercode"));
				loginUser.setPhone(rs.getString("phone"));
				loginUser.setPostcode(rs.getString("postcode"));
				loginUser.setAddress(rs.getString("address"));
				System.out.println(loginUser);
			}
		}
		return loginUser;
	}
	
	public void insertUser(MemberVO vo) {
        StringBuilder sql = new StringBuilder();
        sql.append("INSERT INTO USER_INFO(ID, PASSWORD, EMAIL, NAME, USERCODE, PHONE, ADDRESS, POSTCODE, USER_TYPE) ");
        sql.append("VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)");

        try (Connection conn = new ConnectionFactory().getConnection();
    			PreparedStatement pstmt = conn.prepareStatement(sql.toString()); 
        		) {
            pstmt.setString(1, vo.getId());
            pstmt.setString(2, vo.getPassword());
            pstmt.setString(3, vo.getEmail());
            pstmt.setString(4, vo.getName());
            pstmt.setString(5, vo.getUsercode());
            pstmt.setString(6, vo.getPhone());
            pstmt.setString(7, vo.getAddress());
            pstmt.setString(8, vo.getPostcode());
            pstmt.setString(9, vo.getUser_type());

            pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
	
	
}
