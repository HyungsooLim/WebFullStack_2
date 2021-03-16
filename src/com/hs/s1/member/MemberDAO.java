package com.hs.s1.member;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class MemberDAO {
	//memberJoin - 데이터를 받아서 DB에 insert 하는 메서드
	public int memberJoin(MemberDTO memberDTO) throws Exception{
		String user="user01";
		String password="user01";
		String url="jdbc:oracle:thin:@127.0.0.1:1521:xe";
		String driver="oracle.jdbc.driver.OracleDriver";
		Class.forName(driver);
		Connection con = DriverManager.getConnection(url, user, password);
		String sql="insert into MEMBER\n"
				+ "values(?, ?, ?, ?, ?)";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, memberDTO.getId());
		ps.setString(2, memberDTO.getPw());
		ps.setString(3, memberDTO.getName());
		ps.setString(4, memberDTO.getPhone());
		ps.setString(5, memberDTO.getEmail());
		int result = 0;
		result = ps.executeUpdate();
		
		ps.close();
		con.close();
		
		return result;
	}

	// login - id pw 받아 조회
	public MemberDTO memberlogin(MemberDTO memberDTO) throws Exception {
		String user = "user01";
		String password = "user01";
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		String driver = "oracle.jdbc.driver.OracleDriver";

		Class.forName(driver);

		Connection con = DriverManager.getConnection(url, user, password);

		String sql = "select * from MEMBER\n" + "where id=? and pw=?";

		PreparedStatement ps = con.prepareStatement(sql);

		ps.setString(1, memberDTO.getId());
		ps.setString(2, memberDTO.getPw());

		ResultSet rs = ps.executeQuery();

		if (rs.next()) {
			memberDTO.setName(rs.getString("NAME"));
			memberDTO.setPhone(rs.getString("PHONE"));
			memberDTO.setEmail(rs.getString("EMAIL"));
		} else {
			memberDTO = null;
		}

		rs.close();
		ps.close();
		con.close();

		return memberDTO;
	}

}
