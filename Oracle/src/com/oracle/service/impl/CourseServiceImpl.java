package com.oracle.service.impl;
import java.util.List;

import java.sql.SQLException;

import com.oracle.dao.CourseDao;
import com.oracle.dao.questiondao;
import com.oracle.dao.impl.CourseDaoImpl;
import com.oracle.dao.impl.questiondaoimpl;
import com.oracle.daomain.Course;
import com.oracle.service.CourseService;

public class CourseServiceImpl implements CourseService{

	
	//定义dao实例
	CourseDao cd=new CourseDaoImpl();
	@Override
	public List<Course> GetCourse() throws SQLException {
		// TODO Auto-generated method stub
		questiondao dao=new questiondaoimpl();
		List<Course> CourseList=dao.course();
		return CourseList;
	}
	
	@Override
	public List<Course> QueryAllCourse() {
		// TODO 自动生成的方法存根
		return cd.QueryAllCourse();
	}
	
	@Override
	public Course QueryById(String id) {
		// TODO 自动生成的方法存根
		if(cd.IsExist(id)) return cd.QueryById(id);
		else return null;
	}

	@Override
	public boolean Add(Course c) {
		// TODO 自动生成的方法存根
		if(!cd.IsExist(c.getCourseID())) {
			return cd.Add(c);
		}
		else return false;
	}

	@Override
	public boolean DeleteById(String id) {
		// TODO 自动生成的方法存根
		if(cd.IsExist(id)) return cd.DeleteById(id);
		else return false;
	}

	@Override
	public boolean UpdateById(String id, Course c) {
		// TODO 自动生成的方法存根
		if(cd.IsExist(id)) return cd.UpdateById(id, c);
		else return false;
	}
}
