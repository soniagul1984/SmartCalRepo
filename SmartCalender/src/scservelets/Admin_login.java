package scservelets;

import java.io.IOException;
import java.sql.Date;

import userbean.Admin;
import userbean.Usermaster;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dao.Scsdao;
import dao.Scdao;

/**
 * Servlet implementation class Admin_login
 */
public class Admin_login extends HttpServlet 
{
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
		{
			
			String dbType = "Oracle" ;

			Admin user2 = new Admin();
		    user2.setAdminName(request.getParameter("adminName"));
			user2.setPassword(request.getParameter("password")); 
			
			//System.out.println("starting logging time ; "  + new Date());
			Scsdao dao = Scsdao.getDao(dbType);
			int status = dao.validateAdmin(user2);
			String fwdPath = null ;
			String msg = null ;
			if(status == 0)
			{
				//fwdPath = ".jsp" ;
				System.out.println("Validation Failed in LoginAction");
				msg="Invalid Login";
				
			}
			else
			{
				fwdPath = "administrator.jsp" ;
				msg = "Welcome to Calender" ;
			}
			
			request.setAttribute("msg", msg);
			RequestDispatcher rd = request.getRequestDispatcher(fwdPath);
			rd.forward(request, response);
	}

}
