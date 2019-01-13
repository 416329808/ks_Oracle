package com.oracle.service;

import java.sql.SQLException;

import com.oracle.daomain.Course;
import com.oracle.daomain.checkperson;
import java.util.List;
public interface ChapterService {
	public String GetChapter(String CourseID)throws SQLException;
}