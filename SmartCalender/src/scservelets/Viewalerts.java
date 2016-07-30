package scservelets;

import java.io.IOException;
import java.sql.Date;

import userbean.Useralert;
import userbean.Usermaster;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dao.Scsdao;
import dao.Scdao;

/**
 * Servlet implementation class Viewalerts
 */
public class Viewalerts extends HttpServlet 
{
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
		{
			
			String dbType = "sql" ;

			Useralert user1 = new Useralert();
		    user1.setUsername(request.getParameter("username"));
			
			
			//System.out.println("starting logging time ; "  + new Date());
			Scsdao dao = Scsdao.getDao(dbType);
			int status = dao.validateuser(user1);
			String fwdPath = null ;
			String msg = null ;
			if(status == 0)
			{
				//fwdPath = ".jsp" ;
				System.out.println("LoginAction failed Try again");
				msg="Invalid Login";
				
			}
			else
			{
				fwdPath = "viewalert.jsp" ;
			
			}
			//create setattribute
			request.setAttribute("msg", msg);
			RequestDispatcher rd = request.getRequestDispatcher(fwdPath);
			rd.forward(request, response);
	}

}
