package com.oracle.dao;

import java.util.List;

import com.oracle.daomain.Course;

public interface CourseDao {
     public List<Course> QueryAllCourse();
     
     public Course QueryById(String id);
     
     public boolean Add(Course c);
     
     public boolean DeleteById(String id);
     
     public boolean UpdateById(String id,Course c);
     
     public boolean IsExist(String id);
}
