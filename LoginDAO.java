package com.servletPractice;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

@WebServlet("/LoginDAO")
public class LoginDAO extends HttpServlet {
	
	public static boolean validate(String name,String password) {
		boolean status = false;
		try {
			Connection con = DBConnection.getConnection();
			PreparedStatement ps = con.prepareStatement("select * from registeruser where name=? and password=?");
			ps.setString(1, name);
			ps.setString(2, password);
			
			ResultSet rs = ps.executeQuery();
			status = rs.next();
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}
}
