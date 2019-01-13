package com.oracle.service.impl;

import java.util.List;

import com.oracle.dao.impl.StudentDaoImpl;
import com.oracle.daomain.student;
import com.oracle.service.StudentadminService;

public class StudentadminServiceImpl implements StudentadminService {

	@Override
	public List<student> QueryAllStudent() {
		
		return new StudentDaoImpl().QueryAllStudent();
	}

	@Override
	public student QueryStudentByID(String studentID) {
		// TODO Auto-generated method stub
		return new StudentDaoImpl().QueryStudentByID(studentID);
	}

	@Override
	public boolean Add(student s) {
		// TODO Auto-generated method stub
		return new StudentDaoImpl().Add(s);
	}

	@Override
	public boolean DeleteStudentByID(String studentID) {
		// TODO Auto-generated method stub
		return new StudentDaoImpl().DeleteStudentByID(studentID);
	}

	@Override
	public boolean UpdateStudent(String studentID, student s) {
		// TODO Auto-generated method stub
		return new StudentDaoImpl().UpdateStudent(studentID, s);
	}

	@Override
	public List<student> QueryStudentBytext(String text) {
		// TODO Auto-generated method stub
		return new StudentDaoImpl().QueryStudentBytext(text);
	}

}
