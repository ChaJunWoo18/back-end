package com.libraryhelper.web;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.libraryhelper.funtion.DB;
import com.libraryhelper.funtion.bookDTO;


@WebServlet("/find")
public class find extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String driver = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/library_db?serverTimezone=UTC";
		String uid = "root";
		String upw = "wkdgus9712";

		try {
				Class.forName(driver);
				conn = DriverManager.getConnection(url, uid, upw);
				System.out.println("connect"); // 单捞磐海捞胶 立加 己傍
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
		String SQL = "SELECT * FROM Book";
		bookDTO bookDto = new bookDTO();
		
		try {
			pstmt = conn.prepareStatement(SQL);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				bookDto.setId(rs.getInt(1));
				bookDto.setBook_name(rs.getString(2));
				bookDto.setWriter(rs.getString(3));
				bookDto.setMisalign(rs.getBoolean(4));
				System.out.print(bookDto.getId()+" ");
				System.out.print(bookDto.getBook_name()+" ");
				System.out.print(bookDto.getWriter()+" ");
				System.out.println(bookDto.isMisalign());
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
