package scservelets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import userbean.Usermaster;

import dao.Scsdao;

/**
 * Servlet implementation class Createnewuser_controller
 */
public class Createnewuser_controller extends HttpServlet 
{
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String dbtype = "sql";
		
		Usermaster user = new Usermaster();
		 user.setUsername(request.getParameter("username"));
		user.setPassword(request.getParameter("password"));
		user.setName(request.getParameter("name"));
		user.setEmailid(request.getParameter("emailid"));
		user.setaddress(request.getParameter("address"));
		
		Scsdao dao = Scsdao.getDao(dbtype);
		int status=0;
		try {
			status = dao.adduserInfo(user);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String fwdPath = null ;
		String msg = null ;
		
		if(status == 0)
		{
			fwdPath = "error.jsp" ;
			System.out.println("you entered wrong information");
			msg="Invalid Login";
			
		}
		else
		{
			fwdPath ="login.jsp";
			
		}
		
		request.setAttribute("msg", msg);
		RequestDispatcher rd = request.getRequestDispatcher(fwdPath);
		rd.forward(request, response);
}
}
