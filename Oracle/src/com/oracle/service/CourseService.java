package com.oracle.service;


import java.sql.SQLException;

import com.oracle.daomain.Course;
import com.oracle.daomain.checkperson;
import java.util.List;
public interface CourseService {
	public List<Course> GetCourse()throws SQLException;
	
    public Course QueryById(String id);
    
    public boolean Add(Course c);
    
    public boolean DeleteById(String id);
    
    public boolean UpdateById(String id,Course c);

	public  List<Course> QueryAllCourse();
}

