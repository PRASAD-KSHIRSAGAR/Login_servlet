package com.servAPP;

import java.io.*;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/register1")
public class RegisterDemo extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String Name=request.getParameter("name");
		String Email=request.getParameter("Email");
		String Contact=request.getParameter("Contact");
		String UserName=request.getParameter("UserName");
		String PassWord=request.getParameter("PassWord");
		try
		{
			com.mysql.cj.jdbc.Driver c =new com.mysql.cj.jdbc.Driver();
			DriverManager.registerDriver(c);
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc","root","manager");
			PreparedStatement smt=con.prepareStatement("insert into register values('0',?,?,?,?,?)");
			smt.setString(1, Name);
			smt.setString(2, Email);
			smt.setString(3, Contact);
			smt.setString(4,UserName);
			smt.setString(5, PassWord);
			int value=smt.executeUpdate();
			if(value>0)
			{
				out.println("Registeration Sucessfully");
			}
			else
			{
				out.println("Some Problem is there........");
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
