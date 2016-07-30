package scservelets;

import java.io.IOException;
import java.sql.Date;

import userbean.Usermaster;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dao.Scsdao;
import dao.Scdao;

/**
 * Servlet implementation class Registered_controller
 */
public class Registered_controller extends HttpServlet 
{
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
		{
			
			String dbType = "sql" ;

			Usermaster user = new Usermaster();
		    user.setUsername(request.getParameter("username"));
			user.setPassword(request.getParameter("password")); 
			
			//System.out.println("starting logging time ; "  + new Date());
			Scsdao dao = Scsdao.getDao(dbType);
			int status = dao.validatelogin(user);
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
				fwdPath = "SetYourAlert.jsp" ;
			
			}
			
			request.setAttribute("msg", msg);
			RequestDispatcher rd = request.getRequestDispatcher(fwdPath);
			rd.forward(request, response);
	}

}
