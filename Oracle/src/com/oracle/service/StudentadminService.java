package com.oracle.service;

import java.util.List;

import com.oracle.daomain.student;

public interface StudentadminService {
	 public List<student> QueryAllStudent();
	    
	    public student QueryStudentByID(String studentID);
	    
	   public boolean Add(student s);
	   
	   public boolean DeleteStudentByID(String studentID);
	   
	   public boolean UpdateStudent(String studentID,student s);
	   
	   public List<student> QueryStudentBytext(String text);
}
