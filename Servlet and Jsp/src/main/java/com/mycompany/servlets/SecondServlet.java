package com.mycompany.servlets;

import java.io.*;

import javax.servlet.*;

public class SecondServlet extends GenericServlet{

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("this is servlet using generic servlet. ");
		res.setContentType("text/html");
		PrintWriter out = res.getWriter();
		out.println("<h1>this is my second servlet</h1>");
		
	}

}
