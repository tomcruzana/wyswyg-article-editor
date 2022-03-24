package com.wyswyg.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
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
@WebServlet("/all")
public class IndexController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		CourseDaoImpl cdi = new CourseDaoImpl();

		List<Course> allCourses = new ArrayList<Course>();

		try {
			allCourses = cdi.getAll();
			req.setAttribute("courseList", allCourses);
			RequestDispatcher rd = req.getRequestDispatcher("index.jsp");
			rd.forward(req, res);
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
