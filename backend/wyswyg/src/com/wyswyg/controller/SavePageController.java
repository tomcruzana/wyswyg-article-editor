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
import com.wyswyg.dao.PageDaoImpl;
import com.wyswyg.domain.Course;
import com.wyswyg.domain.Page;
import com.wyswyg.utils.CourseBuilder;
import com.wyswyg.utils.CurrentCourseDto;

@SuppressWarnings("serial")
@WebServlet("/savepage")
public class SavePageController extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String pageComponents = req.getParameter("pagecomponents");
		String pageTitle = req.getParameter("pagetitle");
		String pageNumber = req.getParameter("pagenumber");

		// get current session of the user & course page
		HttpSession hs = req.getSession(false);
		CurrentCourseDto course = new CurrentCourseDto();
		course = (CurrentCourseDto) hs.getAttribute("course");

		// update page based on the current page id
		PageDaoImpl pdi = new PageDaoImpl();
		Page page = new Page();
		page.setId(course.getPageId());
		page.setComponents(pageComponents);
		page.setTitle(pageTitle);
		page.setNumber(Integer.valueOf(pageNumber));
		try {
			pdi.update(page);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
