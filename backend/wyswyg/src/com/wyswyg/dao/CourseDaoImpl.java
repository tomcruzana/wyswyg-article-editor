package com.wyswyg.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.wyswyg.controller.Temp;
import com.wyswyg.domain.Chapter;
import com.wyswyg.domain.Course;
import com.wyswyg.domain.Page;
import com.wyswyg.utils.DbConnector;

public class CourseDaoImpl implements Dao<Course> {
	private static Logger log = Logger.getLogger(CourseDaoImpl.class);

	@Override
	public int add(Course obj) {
		// convert obj to a course object
		Course theCourse = obj;
		log.info("Conversion successful");
		log.info(theCourse.toString());

		// setup and create a prepared statement
		PreparedStatement ps;
		int rowsAffected = 0;
		try {
			Connection dbCon = DbConnector.getConnection();
			log.info("Connection success");

			ps = dbCon.prepareStatement("INSERT INTO course VALUES(?, ?, ?)");
			ps.setString(1, theCourse.getId());
			ps.setString(2, theCourse.getTitle());
			ps.setDate(3, theCourse.getDateCreated());
			rowsAffected = ps.executeUpdate();

			log.info("SQL update executed");

		} catch (SQLException e) {
			log.error("An error occured. ", e);
		} catch (Exception e) {
			log.error("An error occured. ", e);
		}

		return rowsAffected;
	}

	@Override
	public void delete(String id) throws SQLException {
		PreparedStatement ps;

		// setup and create a prepared statement
		try {
			Connection dbCon = DbConnector.getConnection();
			log.info("Connection success! " + this.getClass());

			ps = dbCon.prepareStatement("DELETE FROM course WHERE id = ?");
			ps.setString(1, id);
			int rowCount = ps.executeUpdate();

			if (rowCount > 0) {
				log.info(rowCount + " row deleted!");
				log.info("SQL update executed");
			} else {
				log.info("No records found!");
			}
		} catch (SQLException e) {
			log.error("An error occured. ", e);
		} catch (Exception e) {
			log.error("An error occured. ", e);
		}
	}

	@Override
	public Course get(String id) throws SQLException {
		Course theCourse = null;
		PreparedStatement ps;

		// setup and create a prepared statement
		try {
			Connection dbCon = DbConnector.getConnection();
			log.info("Connection success!");
			ps = dbCon.prepareStatement("SELECT * FROM course WHERE id = ?");
			ps.setString(1, id);

			// get the result set and move cursor to the first row
			ResultSet resultSet = ps.executeQuery();

			if (resultSet.next()) {
				// initialize and return course object
				theCourse = new Course();
				theCourse.setId(resultSet.getString("id"));
				theCourse.setTitle(resultSet.getString("title"));
				theCourse.setDateCreated(resultSet.getDate("date_created"));
				log.info("SQL query executed");
			} else {
				log.info("No courses found!");
			}

		} catch (SQLException e) {
			log.error("An error occured. ", e);
		} catch (Exception e) {
			log.error("An error occured. ", e);
		}

		return theCourse;
	}

	public Course getAllChapterAndPage(String id) throws SQLException {
		Course course = null;
		Chapter chapter = null;
		Page page = null;

		List<Chapter> allChapters = new ArrayList<>();
		List<Page> allPages = new ArrayList<>();

		PreparedStatement ps;

		// setup and create a prepared statement
		try {
			Connection dbCon = DbConnector.getConnection();
			log.info("Connection success!");
			ps = dbCon.prepareStatement(
					"SELECT course.ID AS \"C_ID\", course.TITLE AS \"C_TITLE\", course.DATE_CREATED AS \"C_DATECREATED\", chapter.ID AS \"CH_ID\", chapter.TITLE AS \"CH_TITLE\", chapter.CHAPTER_NUMBER AS \"CH_NUMBER\", page.ID AS \"P_ID\", page.COMPONENTS AS \"P_COMPONENTS\", page.TITLE AS \"P_TITLE\", page.PAGE_NUMBER AS \"P_NUMBER\" FROM ((course INNER JOIN chapter ON course.id = chapter.course_id) INNER JOIN page ON chapter.id = page.chapter_id) WHERE course.id= ? ");
			ps.setString(1, id);

			// get the result set and move cursor to the first row
			ResultSet resultSet = ps.executeQuery();

			if (resultSet.next()) {
				// initialize and return all the objects
				course = new Course();
				course.setId(resultSet.getString("C_ID"));
				course.setTitle(resultSet.getString("C_TITLE"));
				course.setDateCreated(resultSet.getDate("C_DATECREATED"));

				chapter = new Chapter();
				chapter.setId(resultSet.getString("CH_ID"));
				chapter.setTitle(resultSet.getString("CH_TITLE"));
				chapter.setNumber(resultSet.getInt("CH_NUMBER"));

				page = new Page();
				page.setId(resultSet.getString("P_ID"));
				page.setComponents(resultSet.getString("P_COMPONENTS"));
				page.setTitle(resultSet.getString("P_TITLE"));
				page.setNumber(resultSet.getInt("P_NUMBER"));

				allPages.add(page);
				allChapters.add(chapter);

				log.info("SQL query executed");
			} else {
				log.info("No courses found!");
			}

		} catch (SQLException e) {
			log.error("An error occured. ", e);
		} catch (Exception e) {
			log.error("An error occured. ", e);
		}

		return course;
	}

	public List<Course> getCoursesByTitle(String title) throws SQLException {
		PreparedStatement ps;
		List<Course> courseList = new ArrayList<>();

		// setup and create a prepared statement
		try {
			Connection dbCon = DbConnector.getConnection();
			log.info("Connection success!");

			ps = dbCon.prepareStatement("SELECT * FROM course WHERE title LIKE ? ORDER BY id ASC");
			ps.setString(1, "%" + title + "%");
			ResultSet resultSet = ps.executeQuery();

			while (resultSet.next()) {
				courseList.add(new Course(resultSet.getString("id"), null, resultSet.getString("title"),
						resultSet.getDate("date_created")));
			}
			log.info("SQL query executed");
		} catch (SQLException e) {
			log.error("An error occured. ", e);
		} catch (Exception e) {
			log.error("An error occured. ", e);
		}
		return courseList;
	}

	@Override
	public List<Course> getAll() throws SQLException {
		PreparedStatement ps;
		List<Course> courseList = new ArrayList<>();

		// setup and create a prepared statement
		try {
			Connection dbCon = DbConnector.getConnection();
			log.info("Connection success!");

			ps = dbCon.prepareStatement("SELECT * FROM course ORDER BY id ASC");
			ResultSet resultSet = ps.executeQuery();

			while (resultSet.next()) {
				courseList.add(new Course(resultSet.getString("id"), null, resultSet.getString("title"),
						resultSet.getDate("date_created")));
			}
			log.info("SQL query executed");
		} catch (SQLException e) {
			log.error("An error occured. ", e);
		} catch (Exception e) {
			log.error("An error occured. ", e);
		}
		return courseList;
	}

	@Override
	public void update(Course course) throws SQLException {
		PreparedStatement ps;

		// setup and create a prepared statement
		try {
			Connection dbCon = DbConnector.getConnection();
			log.info("Connection success!");

			ps = dbCon.prepareStatement("UPDATE course SET title = ?, date_created = ?  WHERE id = ?");
			ps.setString(1, course.getTitle());
			ps.setDate(2, course.getDateCreated());
			ps.setString(3, course.getId());

			int rowCount = ps.executeUpdate();
			log.info(rowCount + " row updated!");
			log.info("SQL update executed");
		} catch (SQLException e) {
			log.error("An error occured. ", e);
		} catch (Exception e) {
			log.error("An error occured. ", e);
		}
	}

}
