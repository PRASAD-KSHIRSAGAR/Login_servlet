package com.servAPP;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Validate")
public class loginModule extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String Username=request.getParameter("userName");
		String Password=request.getParameter("passWord");
		try
		{
			com.mysql.cj.jdbc.Driver n=new com.mysql.cj.jdbc.Driver();
			DriverManager.registerDriver(n);
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc","root","manager");
			PreparedStatement stmt=con.prepareStatement("Select *from register where Uname=? and UPassword=?");
			stmt.setString(1,Username);
			stmt.setString(2, Password);
			ResultSet rs=stmt.executeQuery();
			if(rs.next())
			{
				RequestDispatcher r=request.getRequestDispatcher("welcome.html");
				r.forward(request, response);
			}
			else
			{
				RequestDispatcher r=request.getRequestDispatcher("Login.html");
				r.include(request, response);
				out.println("<h1>Invaild Username and Password</h1>");
			}
			
		}
		catch(Exception ex)
		{
			out.println("Error is:"+ex);
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
    doGet(request, response);
	}

}
