package com.wyswyg.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wyswyg.dao.CourseDaoImpl;
import com.wyswyg.domain.Course;

@SuppressWarnings("serial")
@WebServlet("/search")
public class SearchController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		String courseTitle = req.getParameter("q");
		CourseDaoImpl cdi = new CourseDaoImpl();
		System.out.println(courseTitle);
		List<Course> allCourses;

		try {
			allCourses = cdi.getCoursesByTitle(courseTitle);
			System.out.println(allCourses);
			req.setAttribute("courseList", allCourses);
			RequestDispatcher rd = req.getRequestDispatcher("index.jsp");
			rd.forward(req, res);
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
