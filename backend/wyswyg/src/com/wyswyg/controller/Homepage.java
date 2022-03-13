package com.wyswyg.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

@SuppressWarnings("serial")
@WebServlet("/dis")
public class Homepage extends GenericServlet {

	@Override
	public void destroy() {
		System.out.println("LOG: servlet destroyed!");
	}

	@Override
	public ServletConfig getServletConfig() {
		return this.getServletConfig();
	}

	@Override
	public String getServletInfo() {
		return "index";
	}

	@Override
	public void init(ServletConfig arg0) throws ServletException {
		System.out.println("LOG: initialization process...");
	}

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		System.out.println("Request Handling process....");
		String username = req.getParameter("uname");
		
		// Output on Console
		PrintWriter pw = res.getWriter();
		res.setContentType("text/html");
		pw.println("Way to go, "+username+"! Welcome to Servlet Programming...");
		// response onto WebBrowser

	}

}
