package com.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public Login() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	
    private boolean validCredentials(String username, String password) {
    	
    	
    	Connection con;
    	Statement stmt;
    	
    	try {
    		Class.forName("com.mysql.jdbc.Driver");
    		
    		//Step 1: create a connection
    		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/myDb?useSSL=false", "root", "Hallolucas112");
    		//Step 2: create a statement
    		stmt = con.createStatement();
    		
    		String sqlStr = "Select * from users where id= "
    		+ "'" + username + "'" 
    		+ "and password ='" + password + "'";
    		ResultSet rset = stmt.executeQuery(sqlStr);
    		
    		//Step 4: Process the query result
    		if (rset.first()){
    			System.out.println();
    			return true;
    		} else {
    			System.out.println("User" + username + "not allowed!");
        		 return false;
    			}}
    		
    }
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		if(validCredentials(request.getParameter("userid"), request.getParameter("password"))) {
			response.sendRedirect("index.html");
		}else response.sendRedirect("http://google.de");
	}



}
