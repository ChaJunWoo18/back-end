package com.libraryhelper.funtion;

import java.sql.*;

public class DB {
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	String driver = "com.mysql.jdbc.Driver";
	String url = "jdbc:mysql://localhost:3306/library_db?serverTimezone=UTC";
	String uid = "root";
	String upw = "wkdgus9712";
	
	public boolean connection() {
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, uid, upw);
			System.out.println("connect");
			return true; // 데이터베이스 접속 성공
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return false; // 데이터베이스 오류
	}
}