package com.oracle.service.impl;

import java.sql.SQLException;

import com.oracle.dao.studentInfo;
import com.oracle.dao.impl.studentInfoImpl;
import com.oracle.daomain.student;
import com.oracle.service.studentService;

public class studentServiceImpl implements studentService {

	@Override
	public student findstudent(String StudentID) throws SQLException {
		studentInfo dao=new studentInfoImpl();
		student student=  dao.findstudent(StudentID);
		return student;
	}

}
