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
@WebServlet("/deletecourse")
public class deleteCourseController extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		String cid = req.getParameter("cid");
		CourseDaoImpl cdi = new CourseDaoImpl();

		try {
			if (cid != null) {
				cdi.delete(cid);
				// TODO send confirmation response here!
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		RequestDispatcher rd = req.getRequestDispatcher("courseselector");
		rd.include(req, res);

	}

}
