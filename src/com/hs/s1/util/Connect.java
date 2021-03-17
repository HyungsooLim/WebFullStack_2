package com.hs.s1.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class Connect {

	public Connection getConnection() throws Exception{
		String user="user01";
		String password="user01";
		String url="jdbc:oracle:thin:@127.0.0.1:1521:xe";
		String driver="oracle.jdbc.driver.OracleDriver";
		Class.forName(driver);
		Connection con = DriverManager.getConnection(url, user, password);
		
		return con;
	}
}
