package com.hs.s1.bankbook;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class BankbookDAO {

	//getList method
	//bankbook table의 모든 데이터 조회 후 리턴
	public void getList() throws Exception {
		String user="user01";
		String password="user01";
		String url="jdbc:oracle:thine:@127.0.0.1:1521:xe";
		String driver="oracle.jdbc.driver.OracleDriver";
		Class.forName(driver);
		Connection con = DriverManager.getConnection(url, user, password);
		String sql="select * from BANKBOOK";
		PreparedStatement ps = con.prepareStatement(sql);
		//?
		ResultSet rs = ps.executeQuery();
		ArrayList<BankbookDTO> ar = new ArrayList<>();
		while(rs.next()) {
			BankbookDTO bankbookDTO = new BankbookDTO();
			bankbookDTO.setBookNumber(rs.getInt("BOOKNUMBER"));
			bankbook
		}
	}
}
