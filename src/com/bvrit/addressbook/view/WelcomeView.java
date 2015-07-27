package com.bvrit.addressbook.view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class WelcomeView
 */
public class WelcomeView extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	String phone;
	String headName;
   
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}
	
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//create printwriter object
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		        //get HTTP session reference
				HttpSession hs = request.getSession();
				//get user name from session
				String user = (String)hs.getAttribute("sunm");
				//String nm = request.getParameter("user");
				//print welcome message
		//		if(user != null) {
				   out.print("<h1>Welcome "+user+" to address book application</h1>");
				   RequestDispatcher rd = request.getRequestDispatcher("link.html");
				   rd.include(request, response);
				   out.print("<hr size=4 color=blue>");
				   out.print("<h2>for more information dial us:"+phone+"</h2>");
		//		}
		//		else {
		//			response.sendRedirect("login.jsp");
		//		}
			
	
	}
	
	//@Override
	public void init(ServletConfig config) throws ServletException {
		ServletContext ctx = config.getServletContext();
		phone = (String)ctx.getInitParameter("phone");
		//super.init(config);
	}
}
