package com.wyswyg.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

@SuppressWarnings("serial")
@WebServlet("/search")
public class IndexController extends GenericServlet {

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		System.out.println("Request Handling process....");

		String q = req.getParameter("q");
		if (q.isEmpty()) {
			PrintWriter pw = res.getWriter();
			res.setContentType("text/html");
			pw.println("<p>No courses found.</p>");
		}

		else {
			RequestDispatcher rd = req.getRequestDispatcher("donate");
			rd.include(req, res);
			PrintWriter pw = res.getWriter();
			res.setContentType("text/html");
			pw.println("<p>Course found!</p>");
		}
	}

}
