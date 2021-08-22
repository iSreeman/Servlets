package com.servletPractice;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Login")
public class Login extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter pw = resp.getWriter();
		
		String name = req.getParameter("Username");
		String password = req.getParameter("Password");
		
		if(LoginDAO.validate(name, password)) {
			RequestDispatcher rd = req.getRequestDispatcher("WelcomeServlet");
			rd.forward(req, resp);
		}
		else {
			pw.print("Please enter valid credentials");
			RequestDispatcher rd = req.getRequestDispatcher("login.jsp");
			rd.include(req, resp);
		}
		
		pw.close();
	}
}
