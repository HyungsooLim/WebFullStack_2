package com.hs.s1.bankbook;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.hs.s1.util.Connect;

public class BankbookDAO {
	Connect connect;

	public BankbookDAO() {
		// TODO Auto-generated constructor stub
		connect = new Connect();
	}

	// getList method
	// bankbook table의 모든 데이터 조회 후 리턴
	public List<BankbookDTO> getList() throws Exception {
		String user = "user01";
		String password = "user01";
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		String driver = "oracle.jdbc.driver.OracleDriver";
		Class.forName(driver);
		Connection con = DriverManager.getConnection(url, user, password);
		String sql = "select * from BANKBOOK";
		PreparedStatement ps = con.prepareStatement(sql);
		// ?
		ResultSet rs = ps.executeQuery();
		ArrayList<BankbookDTO> ar = new ArrayList<>();
		while (rs.next()) {
			BankbookDTO bankbookDTO = new BankbookDTO();
			bankbookDTO.setBookNumber(rs.getLong("BOOKNUMBER"));
			bankbookDTO.setBookName(rs.getString("BOOKNAME"));
			bankbookDTO.setBookRate(rs.getDouble("BOOKRATE"));
			bankbookDTO.setBookSale(rs.getString("BOOKSALE"));
			ar.add(bankbookDTO);
		}
		rs.close();
		ps.close();
		con.close();

		return ar;
	} // === getList method END ===

	public BankbookDTO getSelect(BankbookDTO bankbookDTO) throws Exception {
		Connection con = connect.getConnection();
		String sql = "select * from BANKBOOK where booknumber=?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setLong(1, bankbookDTO.getBookNumber());
		ResultSet rs = ps.executeQuery();
		
		if (rs.next()) {
			bankbookDTO.setBookName(rs.getString("BOOKNAME"));
			bankbookDTO.setBookRate(rs.getDouble("BOOKRATE"));
			bankbookDTO.setBookSale(rs.getString("BOOKSALE"));
		}else {
			bankbookDTO = null;
		}

		rs.close();
		ps.close();
		con.close();

		return bankbookDTO;
	}// === getSelect method END ===
}
