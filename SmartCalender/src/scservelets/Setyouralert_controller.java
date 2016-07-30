package scservelets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Scsdao;

import userbean.Useralert;

/**
 * Servlet implementation class Setyouralert_controller
 */
public class Setyouralert_controller extends HttpServlet 
{
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String dbtype = "sql";
		Useralert user1 = new Useralert();
		user1.setUsername(request.getParameter("username"));
		user1.setAlertdate(request.getParameter("setDate"));
		user1.setAlertevent(request.getParameter("setEvent"));
		user1.setAlertsubject(request.getParameter("mailSub"));
		user1.setAlertbody(request.getParameter("mailMsg"));
		
		Scsdao dao = Scsdao.getDao(dbtype);
		int status = dao.setyouralert(user1);
		String fwdPath = null ;
		String msg = null ;
		if(status == 0)
		{
			fwdPath = "setyouralert.jsp" ;
			System.out.println("Validation Failed in ");
			msg="Invalid Alert";
			
		}
		else
		{
			fwdPath = "successful.jsp" ;
		
		}
		
		request.setAttribute("msg", msg);
		RequestDispatcher rd = request.getRequestDispatcher(fwdPath);
		rd.forward(request, response);
}
		
	}


