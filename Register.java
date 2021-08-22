package com.servletPractice;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Register")
public class Register extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter pw = resp.getWriter();
		
		String name = req.getParameter("Username");
		String password = req.getParameter("Password");
		String email = req.getParameter("UserEmail");
		String country = req.getParameter("UserCountry");
		
		Connection con = DBConnection.getConnection();
		try {
			PreparedStatement ps = con.prepareStatement("insert into registeruser values(?,?,?,?)");
			
			ps.setString(1, name);
			ps.setString(2, password);
			ps.setString(3, email);
			ps.setString(4, country);
			
			int i = ps.executeUpdate();
			if(i>0) {
				pw.print("Registered Successfully");
				resp.sendRedirect("login.jsp");
			}
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
				
	}
}
