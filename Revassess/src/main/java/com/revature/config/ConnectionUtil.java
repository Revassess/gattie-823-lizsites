package com.revature.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * 
 * @author Revature
 *
 *         This is a paceholder class to hold the configurations of your db
 *         connection. You should change the url, username, and password. DO NOT
 *         CHANGE THE MODIFIERS OR THE NAMES OF THE VARIABLES. These are used to
 *         test your db schema.
 */
public class ConnectionUtil {
	//for singleton instance
	private static ConnectionUtil cu;
	private static Connection conn;
	// add your jdbc url
	public static final String URL = "jdbc:postgresql://javafs200803.cg0rpxexvjxn.us-east-2.rds.amazonaws.com/tier3";
	// add your jdbc username
	public static final String USERNAME = "postgres";
	// add your jdbc password
	public static final String PASSWORD = "password";
	// name of the created stored procedure in tier 3
	public static final String TIER_3_PROCEDURE_NAME = "";
	// name of the created sequence in tier 3
	public static final String TIER_3_SEQUENCE_NAME = "incrementby3";

	// implement this method to connect to the db and return the connection object
	public static Connection connect() throws SQLException {
		if (conn == null) {
			try {
				Class.forName("org.postgresql.Driver");
			} catch (ClassNotFoundException e) {
				System.out.println("Could not register driver!");
				e.printStackTrace();
			} 
			conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
		}
		
		//If connection was closed then retrieve a new connection
		if (conn.isClosed()){
			System.out.println("Opening new connection...");
			conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
		}
		if (conn == null) {
			  System.out.println("not connected");
			} else {
				System.out.println("connected");
			}
		return conn;
	}


	//implement this method with a callable statement that calls the absolute value sql function
	public long callAbsoluteValueFunction(long value){
		return value;
	}
	

	//make the class into a singleton
	private ConnectionUtil(){
		super();
	}

	public static ConnectionUtil getInstance(){
		if(cu == null){
			cu = new ConnectionUtil();
		}
		return cu;
	}
	
	public static void main (String[] args) {
		try {
			ConnectionUtil.connect();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
