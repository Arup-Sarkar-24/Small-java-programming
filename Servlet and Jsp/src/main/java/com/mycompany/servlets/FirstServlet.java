package com.mycompany.servlets;

import java.io.*;
import java.util.Date;

import javax.servlet.*;

public class FirstServlet implements Servlet {
	//Life cycle methods
	ServletConfig conf;
	public void init(ServletConfig conf) {
		this.conf=conf;
		System.out.println("Creating objects...");		
	}
	
	public void service(ServletRequest req, ServletResponse resp) throws IOException {
		System.out.println("Servicing.....");
		
		//set the content type of the response
		resp.setContentType("text/html");
		PrintWriter out=resp.getWriter();
		out.println("<h1>This is my output from servlet method : </h1>");
		out.println("<h1>Todats date and time : "+ new Date().toString()+"</h1>");
		
	}
	public void destory() {
		System.out.println("Going to destroy servlet object.");
	}
	//non life cycle methods
	public ServletConfig getServletConfig() {
		return this.conf;
		
	}
	public String getServletInfo() {
		return "This servlet created by Arup Sarkar";
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

}
