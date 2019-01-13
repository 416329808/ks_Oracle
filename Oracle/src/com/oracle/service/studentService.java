package com.oracle.service;

import java.sql.SQLException;

import com.oracle.daomain.student;

public interface studentService {

	/**
	 * 通过学生ID查找学生
	 * @param StudentID
	 * @return
	 */
  public student findstudent(String StudentID)throws SQLException;
	
}
