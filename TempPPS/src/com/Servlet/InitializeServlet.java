package com.Servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class InitializeServlet
 */
@WebServlet("/InitializeServlet")
public class InitializeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static Connection connect = null;
	  private static Statement statement = null;
	  private static PreparedStatement preparedStatement = null;
	  private static ResultSet resultSet = null;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InitializeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			
		      // This will load the MySQL driver, each DB has its own driver
		      Class.forName("com.mysql.jdbc.Driver");
		      // Setup the connection with the DB
			String url = "jdbc:mysql://localhost/pps";
			Connection connect = DriverManager.getConnection(url, "john","john1234");

		      System.out.println("establised");
		      String sql1 = "DROP TABLE IF EXISTS temp";
		      String sql2 = "CREATE TABLE IF NOT EXISTS temp " +
		                     "(id INTEGER not NULL AUTO_INCREMENT, " +
		                     " Name VARCHAR(20), " + 
		                     " Address VARCHAR(50), " + 
		                     " Status VARCHAR(10), " + 
		                     " PRIMARY KEY ( id ))"; 
		      statement = connect.createStatement();

		      statement.executeUpdate(sql1);
		      statement.executeUpdate(sql2);
		      
		      resultSet = statement.executeQuery("select * from temp");
		      
		    	RequestDispatcher dispatcher = request.getRequestDispatcher("Initialize.jsp"); 
				dispatcher.forward(request, response);
		      
		      while(resultSet.next())
		      {
		    	  System.out.println(resultSet.getInt(1));
		    	  System.out.println(resultSet.getString(2));
		    	  System.out.println(resultSet.getString(3));
		    	  System.out.println(resultSet.getString(4));
		      }
		      

		}
		catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
		finally {
			
		}
		
		//doGet(request, response);
	}

}
