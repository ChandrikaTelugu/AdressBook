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


public class ECEView extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	String phone;
	String headName;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request,response);
	}
	
    protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
    	PrintWriter out = response.getWriter();
		//get HTTP session reference
				HttpSession hs = request.getSession();
				//get user name from session
				String user = (String)hs.getAttribute("sunm");
		out.print("<h1>Welcome"+user+" to ECE</h1>");
		out.print("<HR size=4 color=green");
		out.print("<h2>Subjec List</h2>");
		out.print("<UL>");
		out.print("<L1> STLD<br>");
		out.print("<L1> SS<br>");
		out.print("<L1> PEE<br>");
		out.print("<L1> ES<br>");
		out.print("</UL>");
		
		RequestDispatcher rd = request.getRequestDispatcher("link.html");
		rd.include(request, response);
		out.print("<hr size=4 color=blue>");
		out.print("<h2>for more information dial us:"+phone+"</h2>");
		out.print("<h3>Head of dept:"+headName+"</h3>");


	}

	@Override
	public void init(ServletConfig config) throws ServletException {
		headName = config.getInitParameter("Ecehead");
		ServletContext ctx = config.getServletContext();
		phone = (String)ctx.getInitParameter("phone");
		//super.init(config);
	}

}
