package com.Servlet;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



public class RegisterServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;

	String firstname, lastname, birthday, streetname, city, state, emailid, password, confirmpassword;

	int streetnumber,zipcode;
	private static Connection connect = null;
	  private static Statement statement = null;
	  private static PreparedStatement preparedStatement = null;
	  private static ResultSet resultSet = null;
		
		public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException
		{
			res.setContentType("text/html");
			firstname = req.getParameter("firstname");
			lastname = req.getParameter("lastname");
			birthday =  req.getParameter("birthday");
			
			streetnumber =  Integer.parseInt(req.getParameter("streetnumber"));
			streetname =  req.getParameter("streetname");
			city =  req.getParameter("city");
			state =  req.getParameter("state");
			zipcode =  Integer.parseInt(req.getParameter("zipcode"));
			
			emailid = req.getParameter("emailid");
			password = req.getParameter("password");
			
			confirmpassword = req.getParameter("confirmpassword");
			PrintWriter out = res.getWriter();
			
			
			try {
			
			      // This will load the MySQL driver, each DB has its own driver
			      Class.forName("com.mysql.jdbc.Driver");
			      // Setup the connection with the DB
				String url = "jdbc:mysql://localhost/pps";
				Connection connect = DriverManager
				          .getConnection(url, "john","john1234");

			      System.out.println("establised");
			      String insert = "insert into users(firstname, lastname,birthday, emailid, password, confirmpassword, ppsbal, dollarbal) values (?, ?, ?, ?, ?,?,?,?)";
			      float ppsbal = 0.0f;
			      float dollarbal = 0.0f;
			      	preparedStatement = connect.prepareStatement(insert);
			          preparedStatement.setString(1, firstname);
			          preparedStatement.setString(2, lastname);
			          preparedStatement.setString(3, birthday);
			          preparedStatement.setString(4, emailid);
			          preparedStatement.setString(5, password);
			          preparedStatement.setString(6, confirmpassword);
			          preparedStatement.setDouble(7, ppsbal);
			          preparedStatement.setDouble(8, dollarbal);
			          preparedStatement.executeUpdate();
			     
			          
			          String address = "insert into address(emailid, streetnumber, streetname, city, state, zipcode) values(?,?,?,?,?,?)";
			          preparedStatement = connect.prepareStatement(address);
			          preparedStatement.setString(1, emailid);
			          preparedStatement.setInt(2, streetnumber);
			          preparedStatement.setString(3, streetname);
			          preparedStatement.setString(4, city);
			          preparedStatement.setString(5, state);
			          preparedStatement.setInt(6, zipcode);
			          preparedStatement.executeUpdate();
			          RequestDispatcher dispatcher = req.getRequestDispatcher("login.jsp"); 
						dispatcher.forward(req, res);
			     
						/*
						 * out.println("<p align='center'>Registered successfully!</p>");
						 * out.println("<h3><a href = 'login.jsp'>Login here</a></h3>");
						 */
			    

			}
			catch (Exception e) {
				// TODO: handle exception
				System.out.println(e);
			}
			finally {
				close();
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
