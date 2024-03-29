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
import javax.servlet.http.HttpSession;

import com.wyswyg.dao.CourseDaoImpl;
import com.wyswyg.domain.Course;

@SuppressWarnings("serial")
@WebServlet("/courseselector")
public class LoginController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		try {
			// create session for the user
			HttpSession hs = req.getSession();
			hs.setAttribute("admin", "Thomas");

			// fetch available courses for editing
			CourseDaoImpl cdi = new CourseDaoImpl();
			List<Course> adminCourses = cdi.getAll();
			if (adminCourses != null) {
				hs.setAttribute("adminCourses", adminCourses);
			}else {
				hs.setAttribute("adminCourses", "No course available. Please create one!");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		req.getRequestDispatcher("courseselector.jsp").forward(req, res);

	}

}
