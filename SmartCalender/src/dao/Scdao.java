package dao;

import java.sql.Connection;

import userbean.Admin;
import userbean.Query;
import userbean.Useralert;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.http.HttpServletRequest;

import userbean.Usermaster;

public class Scdao extends Scsdao
{
	String insertStatus = null;
	ResultSet rs = null;
	//DBConnSingle connObj = null;
	Connection conn = null;
	int success = 0;
	

	public int validatelogin( Usermaster user) 
	{

		String query = "select count(username) from user_master where username ='"+ user.getUsername() + "' and password ='" + user.getPassword() + "'";

		// connObj = DBConn.getSqlConn();
		Connection conn = Dbconnection.getSqlConn();
		System.out.println("found connection--->");

		try {
			Statement st = conn.createStatement();
			System.out.println("Statement created ");
			System.out.println("Query  : " + query);
			rs = st.executeQuery(query);
			System.out.println("Query Executed : ");
			System.out.println("success before rs.next: " + success);
			if (rs != null) {
				rs.next();
				success = rs.getInt(1);
				
				//String id  = rs.getString(2);
				//int pId  = rs.getInt(3);
				//System.out.println("id :  " + id + " pId : " + pId);
				// System.out.println("Student name : " + rs.getString(1));
				System.out.println("password :"+rs.getString(2));
				System.out.println("count : " + success);
				System.out.println("success after rs.next: " + success);
			}
			conn.close();
			conn = null ;
		} catch (Exception e) {
			System.out.print("exception " + e);
			// success = 0 ;
			if (conn != null) {
				conn = null;
			}
		}

		return success;
	}

	public int adduserInfo(Usermaster user) throws SQLException
	{
		
			
		String	query1 = "INSERT INTO user_master VALUES(?,?,?,?)";
		PreparedStatement p = null;
		int updatequery = 0;
		
		Connection conn = Dbconnection.getSqlConn();
		try
		{
			PreparedStatement pstatement = conn.prepareStatement(query1);
				pstatement.setString(1,user.getUsername());
				pstatement.setString(2,user.getPassword());
				pstatement.setString(3,user.getName());
				pstatement.setString(4,user.getEmailid());
				
				updatequery = pstatement.executeUpdate();
				System.out.println("rows updated="+updatequery);
				 
				if(updatequery!=0)
				{
					System.out.println("values inserted ="+updatequery);
				}
				else
					System.out.print("values not inserted ="+updatequery);
			
		
		}
			catch (SQLException e) 
			{
				System.out.print(e);
				e.printStackTrace();
	
			}
			return updatequery;
			
			
		
		

	
	}


	
	public int setyouralert(Useralert user1)
	{
		String query = "INSERT INTO user_alert VALUES(?,?,?,?,?)";
		PreparedStatement p = null;
		int updatequery = 0;
		
		Connection conn = Dbconnection.getSqlConn();
		try
		{
			PreparedStatement pstatement = null;
			pstatement = conn.prepareStatement(query);
			
				pstatement.setString(1,user1.getUsername());
				pstatement.setString(2,user1.getAlertdate());
				pstatement.setString(3,user1.getAlertevent());
				pstatement.setString(4,user1.getAlertsubject());
				pstatement.setString(5,user1.getAlertbody());
				
				updatequery = pstatement.executeUpdate();
				System.out.println("rows updated="+updatequery);
				 
				if(updatequery!=0)
				{
					System.out.println("values inserted ="+updatequery);
				}
				else
					System.out.print("values not inserted ="+updatequery);
			
		
		}
			catch (SQLException e) 
			{
				System.out.print(e);
				e.printStackTrace();
	}
		return updatequery;

	}

	
	public int validateuser(Useralert user1) 
	{

		String query = "select count(username) from user_alert where username ='"+ user1.getUsername() + "'";

		// connObj = DBConn.getSqlConn();
		Connection conn = Dbconnection.getSqlConn();
		System.out.println("found connection--->");

		try {
			Statement st = conn.createStatement();
			System.out.println("Statement created ");
			System.out.println("Query  : " + query);
			rs = st.executeQuery(query);
			System.out.println("Query Executed : ");
			System.out.println("success before rs.next: " + success);
			if (rs != null) {
				rs.next();
				success = rs.getInt(1);
				
				//String id  = rs.getString(2);
				//int pId  = rs.getInt(3);
				//System.out.println("id :  " + id + " pId : " + pId);
				// System.out.println("Student name : " + rs.getString(1));
				System.out.println("username :"+rs.getString(1));
				System.out.println("count : " + success);
				System.out.println("success after rs.next: " + success);
			}
			conn.close();
			conn = null ;
		} catch (Exception e) {
			System.out.print("exception " + e);
			// success = 0 ;
			if (conn != null) {
				conn = null;
			}
		}

		return success;
	}
	public int viewquery(Query que1)
	{
		String query = "INSERT INTO yourquery VALUES(?,?,?)";
		PreparedStatement p = null;
		int updatequery = 0;
		
		Connection conn = Dbconnection.getSqlConn();
		try
		{
			PreparedStatement pstatement = null;
			pstatement = conn.prepareStatement(query);
			
				pstatement.setString(1,que1.getName());
				pstatement.setString(2,que1.getEmailaddress());
				pstatement.setString(3,que1.getYourquery());
				
				
				updatequery = pstatement.executeUpdate();
				System.out.println("rows updated="+updatequery);
				 
				if(updatequery!=0)
				{
					System.out.println("values inserted ="+updatequery);
				}
				else
					System.out.print("values not inserted ="+updatequery);
			
		
		}
			catch (SQLException e) 
			{
				System.out.print(e);
				e.printStackTrace();
	}
		return updatequery;

	}

	

	

	public int validateAdmin( Admin user2) 
	{

		String query = "select count(adminName) from admin where adminName ='"+ user2.getAdminName() + "' and password ='" + user2.getPassword() + "'";
		// connObj = DBConn.getSqlConn();
		Connection conn = Dbconnection.getSqlConn();
		System.out.println("found connection--->");

		try {
			Statement st = conn.createStatement();
			System.out.println("Statement created ");
			System.out.println("Query  : " + query);
			rs = st.executeQuery(query);
			System.out.println("Query Executed : ");
			System.out.println("success before rs.next: " + success);
			if (rs != null) {
				rs.next();
				success = rs.getInt(1);
				
				//String id  = rs.getString(2);
				//int pId  = rs.getInt(3);
				//System.out.println("id :  " + id + " pId : " + pId);
				System.out.println("Admin Name : " + rs.getString(1));
				System.out.println("password :"+rs.getString(2));
				System.out.println("count : " + success);
				System.out.println("success after rs.next: " + success);
			}
			conn.close();
			conn = null ;
		} catch (Exception e) {
			System.out.print("exception " + e);
			// success = 0 ;
			if (conn != null) {
				conn = null;
			}
		}

		return success;
	}

	
}

	
	

