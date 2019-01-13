package com.oracle.dao;

import java.util.List;


import com.oracle.daomain.student;

public interface StudentDao {
	
	/**
	 * 查询所有学生的信息
	 * @return
	 */
	 public List<student> QueryAllStudent();
	    
	 /**
	  * 通过学生ID查看学生的信息
	  * @param studentID
	  * @return
	  */
	    public student QueryStudentByID(String studentID);
	    
	    
	    /**
	     * 添加学生
	     * @param s
	     * @return
	     */
	   public boolean Add(student s);
	   
	   
	   /**
	    * 通过ID来删除学生
	    * @param studentID
	    * @return
	    */
	   public boolean DeleteStudentByID(String studentID);
	   
	   
	   /**
	    * 更新学生的相关信息
	    * @param studentID
	    * @param s
	    * @return
	    */
	   public boolean UpdateStudent(String studentID,student s);
	   
	   
	   
	   /**
	    * 学生信息的模糊查询实现
	    * @param text
	    * @return
	    */
	   public List<student> QueryStudentBytext(String text);
}
