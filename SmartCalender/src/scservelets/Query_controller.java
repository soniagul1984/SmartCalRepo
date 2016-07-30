package scservelets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Scsdao;

import userbean.Query;


/**
 * Servlet implementation class Query_controller
 */
public class Query_controller extends HttpServlet 
{
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String dbtype = "sql";
		Query que1 = new Query();
		que1.setName(request.getParameter("name"));
		que1.setEmailaddress(request.getParameter("emailaddress"));
		que1.setYourquery(request.getParameter("yourquery"));
		
		
		Scsdao dao = Scsdao.getDao(dbtype);
		int status = dao.viewquery(que1);
		String fwdPath = null ;
		String msg = null ;
		if(status == 0)
		{
			fwdPath = "login.jsp" ;
			System.out.println("Validation Failed in ");
			msg="Invalid Login";
			
		}
		else
		{
			fwdPath = "successful.jsp" ;
			msg = "Welcome to Home page" ;
		}
		
		request.setAttribute("msg", msg);
		RequestDispatcher rd = request.getRequestDispatcher(fwdPath);
		rd.forward(request, response);
}
		
	}


