package com.oracle.dao;

import java.sql.SQLException;

import com.oracle.daomain.student;

public interface studentInfo {
	
	/**
	 * 通过学生ID查找学生
	 * @param StudentID
	 * @return
	 */
  public student findstudent (String StudentID)throws SQLException;
}
