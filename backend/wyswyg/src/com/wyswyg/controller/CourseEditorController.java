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

import com.wyswyg.dao.ChapterDaoImpl;
import com.wyswyg.dao.CourseDaoImpl;
import com.wyswyg.dao.PageDaoImpl;
import com.wyswyg.domain.Chapter;
import com.wyswyg.domain.Course;
import com.wyswyg.domain.Page;

@SuppressWarnings("serial")
@WebServlet("/courseeditor")
public class CourseEditorController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		String courseId = req.getParameter("cid");
		String chapterId = req.getParameter("chid");
		String pageId = req.getParameter("pid");

		try {
			// get current session of the user
			HttpSession hs = req.getSession(false);

			// fetch the selected course data for editing
			CourseDaoImpl cdi = new CourseDaoImpl();
			Course course = cdi.getAllChapterAndPage(courseId); // TODO: INNER JOIN ALL RELATED CHAPS & PAGES

			if (course != null) {
				hs.setAttribute("course", course);
			} else {
				hs.setAttribute("course", "Course Read Error");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		req.getRequestDispatcher("courseeditor.jsp").forward(req, res);

	}

}
