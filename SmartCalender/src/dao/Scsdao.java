package dao;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import userbean.Admin;
import userbean.Query;
import userbean.Useralert;
import userbean.Usermaster;

abstract public class Scsdao 
{

	public static Scsdao getDao(String dbType) 
	{
		Scsdao Dao = null;   // creating instance variable 
		if (dbType.equals("oracle"))
		{
			Dao = new OracleDAO();
		} 
		else 
		{
			if (dbType.equals("sql"))
				Dao = new Scdao();
		}
		return Dao;
	}

	abstract public int adduserInfo(Usermaster user) throws SQLException ;
	abstract public int validatelogin(Usermaster user);
	abstract public int setyouralert(Useralert user1);
    abstract public int validateuser(Useralert user1);
    abstract public int viewquery(Query que1);

	 abstract public int validateAdmin(Admin user2);
    
	


		
	}

	
	
	


