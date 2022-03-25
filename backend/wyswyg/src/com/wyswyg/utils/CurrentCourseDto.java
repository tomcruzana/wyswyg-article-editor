package com.wyswyg.utils;

import java.io.Serializable;
import java.sql.Date;

@SuppressWarnings("serial")
public class CurrentCourseDto implements Serializable {
	private String courseId;
	private String courseTitle;
	private Date courseDateCreated;
	private String chapterId;
	private String chapterTitle;
	private Integer chapterNumber;
	private String pageId;
	private String pageComponents;
	private String pageTitle;
	private Integer pageNumber;

	public String getCourseId() {
		return courseId;
	}

	public void setCourseId(String courseId) {
		this.courseId = courseId;
	}

	public String getCourseTitle() {
		return courseTitle;
	}

	public void setCourseTitle(String courseTitle) {
		this.courseTitle = courseTitle;
	}

	public Date getCourseDateCreated() {
		return courseDateCreated;
	}

	public void setCourseDateCreated(Date courseDateCreated) {
		this.courseDateCreated = courseDateCreated;
	}

	public String getChapterId() {
		return chapterId;
	}

	public void setChapterId(String chapterId) {
		this.chapterId = chapterId;
	}

	public String getChapterTitle() {
		return chapterTitle;
	}

	public void setChapterTitle(String chapterTitle) {
		this.chapterTitle = chapterTitle;
	}

	public Integer getChapterNumber() {
		return chapterNumber;
	}

	public void setChapterNumber(Integer chapterNumber) {
		this.chapterNumber = chapterNumber;
	}

	public String getPageId() {
		return pageId;
	}

	public void setPageId(String pageId) {
		this.pageId = pageId;
	}

	public String getPageComponents() {
		return pageComponents;
	}

	public void setPageComponents(String pageComponents) {
		this.pageComponents = pageComponents;
	}

	public String getPageTitle() {
		return pageTitle;
	}

	public void setPageTitle(String pageTitle) {
		this.pageTitle = pageTitle;
	}

	public Integer getPageNumber() {
		return pageNumber;
	}

	public void setPageNumber(Integer pageNumber) {
		this.pageNumber = pageNumber;
	}

}
