package com.servletPractice;

import java.sql.*;

public class DBConnection 
{
	private static Connection con = null;
	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/servlets", "root", "root");
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static Connection getConnection(){
		return con;
	}
	
}
	
//	@SuppressWarnings("deprecation")
//	public static void main(String args[]){  
//		try {
//			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
//			java.sql.Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/servlets", "root", "root");
//			if(con!=null)
//			{
//				System.out.println("Connection successful");
//			}
//			else
//			{
//				System.out.println("Failed");
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
//
//}

//to execute a query

//Statement st = con.createStatement();
//ResultSet rs = st.executeQuery("select username from users1 where userid = 1");
//
//rs.next();
//String name = rs.getString("username");
//System.out.println(name);
//
//st.close();
//con.close();