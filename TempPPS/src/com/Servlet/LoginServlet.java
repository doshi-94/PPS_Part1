
package com.Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSet.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mysql.cj.xdevapi.Statement;


public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	String emailid, password;
	private static Connection connect = null;
	private static Statement statement = null;
	private static PreparedStatement preparedStatement = null;
	private static ResultSet resultSet = null;
	
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException {
		
		res.setContentType("text/html");
		
		
		emailid = req.getParameter("emailid");
		password = req.getParameter("password");
		
		HttpSession session = req.getSession();
		
		try {

			// This will load the MySQL driver, each DB has its own driver
			Class.forName("com.mysql.jdbc.Driver");
			// Setup the connection with the DB
			String url = "jdbc:mysql://localhost/pps";
			Connection connect = DriverManager.getConnection(url, "john", "john1234");
			
			if (emailid.equals("root") && password.equals("pass1234"))
			{
				String selectRoot = "select * from root where rootid='" + emailid
						+ "' and password='" + password + "'";
				java.sql.Statement statement = connect.createStatement();
				ResultSet rs = statement.executeQuery(selectRoot);

				

				if (rs.next()) {
					String firstname = rs.getString("rootid");
										
					 req.getSession().setAttribute("firstname", firstname);
					 req.getSession().setAttribute("emailid", emailid);
					// RequestDispatcher dispatcher = req.getRequestDispatcher("Homepage.jsp"); 
					 //dispatcher.forward(req, res);
					 res.sendRedirect("Initialize.jsp");
					}
			}
			else {
			String select = "select * from users where emailid='" + emailid
					+ "' and password='" + password + "'";
			
			
			java.sql.Statement statement = connect.createStatement();
			ResultSet rs = statement.executeQuery(select);

			

			if (rs.next()) {

				String firstname = rs.getString("firstname");
				
				
				 req.getSession().setAttribute("firstname", firstname); 
				 req.getSession().setAttribute("emailid", emailid);
				// RequestDispatcher dispatcher = req.getRequestDispatcher("Homepage.jsp"); 
				 //dispatcher.forward(req, res);
				 res.sendRedirect("Homepage.jsp");
				
				

			} else {
				
				/*
				 * RequestDispatcher dispatcher = req.getRequestDispatcher("login.jsp");
				 * dispatcher.forward(req, res);
				 */
				res.sendRedirect("login.jsp");
			}
			}
		} catch (Exception e) {
			System.out.println(e);

		} finally {
			
		}
	}

	private static void close() {
		try {
			if (resultSet != null) {
				resultSet.close();
			}

			if (statement != null) {
				// statement.close();
			}

			if (connect != null) {
				connect.close();
			}
		} catch (Exception e) {

		}

	}
}
