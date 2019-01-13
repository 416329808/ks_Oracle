package com.oracle.dao;

import java.util.List;

import com.oracle.daomain.Teacher;

public interface TeacherDao {
	/**
	 * 查询所有老师的信息
	 * @return
	 */
    public List<Teacher> QueryAllTeacher();
    
    
    /**
     * 通过ID来查询老师的相关信息
     * @param teacherID
     * @return
     */
    public Teacher QueryTeacherByID(String teacherID);
    
    
    /**
     * 添加老师 
     * @param t
     * @return
     */
   public boolean Add(Teacher t);
   
   
   /**
    * 删除老师
    * @param teacherID
    * @return
    */
   public boolean DeleteTeacherByID(String teacherID);
   
   
   /**
    * 更新老师的有关信息
    * @param teacherID
    * @param t
    * @return
    */
   public boolean UpdateTeacher(String teacherID,Teacher t);
   
   
   
   /**
    * 判断是否存在这个老师
    * @param teacherID
    * @return
    */
   public boolean IsExist(String teacherID);
   
   /**
    * 老师的模糊查询
    * @param text
    * @return
    */
   public List<Teacher> QueryTeacherBytext(String text);
}
