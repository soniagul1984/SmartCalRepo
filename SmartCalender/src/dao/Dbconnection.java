package dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class Dbconnection 
{
	public static Connection getOraConn() 
	{
		Connection conn = null;
//error
		try
		{
			Class.forName("sun.jdbc.odbc.jdbcodbcDriver");
			conn = DriverManager.getConnection("jdbc:mysql:localhost:3306/test"," root "," ");
			System.out.print("driver found");
		}
		catch (Exception e) 
		{
		}
		return conn;
	}

		public static Connection getSqlConn() 
	{
		Connection conn = null;
		//String url ="jdbc:mysql://localhost:3306/test"," "," ";
		
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("getSqlConn called");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/reginfo","root","");
			System.out.println("Driver Loaded");
		}
		catch (Exception e) 
		{
		}
		
		return conn;
	}
}
