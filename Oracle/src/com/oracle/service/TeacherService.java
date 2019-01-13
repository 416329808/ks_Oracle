package com.oracle.service;

import java.util.List;

import com.oracle.daomain.Teacher;

public interface TeacherService {
    public List<Teacher> QueryAllTeacher();
    
    public Teacher QueryTeacherByID(String teacherID);
    
   public boolean Add(Teacher t);
   
   public boolean DeleteTeacherByID(String teacherID);
   
   public boolean UpdateTeacher(String teacherID,Teacher t);

   public List<Teacher> QueryTeacherBytext(String text);
   
}
