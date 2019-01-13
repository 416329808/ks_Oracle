package com.oracle.service.impl;

import java.util.List;

import com.oracle.dao.impl.TeacherDaoImpl;
import com.oracle.daomain.Teacher;
import com.oracle.service.TeacherService;

public class TeacherServiceImpl implements TeacherService{

	TeacherDaoImpl td=new TeacherDaoImpl();
	
	@Override
	public List<Teacher> QueryAllTeacher() {
		// TODO 自动生成的方法存根
		return td.QueryAllTeacher();
	}

	@Override
	public Teacher QueryTeacherByID(String teacherID) {
		// TODO 自动生成的方法存根
		return td.QueryTeacherByID(teacherID);
	}

	@Override
	public boolean Add(Teacher t) {
		// TODO 自动生成的方法存根
		System.out.println("add:"+t.getTeacherID()+t.getTeacherName()+t.getSex()+t.getBelongsInstituteID()+t.getBelongsInstituteName());
		if(td.IsExist(t.getTeacherID())) return false;
		else return td.Add(t);
	}

	@Override
	public boolean DeleteTeacherByID(String teacherID) {
		// TODO 自动生成的方法存根
		if(td.IsExist(teacherID)) return td.DeleteTeacherByID(teacherID);
		else return false;
	}

	@Override
	public boolean UpdateTeacher(String teacherID, Teacher t) {
		// TODO 自动生成的方法存根
		if(td.IsExist(teacherID)) return td.UpdateTeacher(teacherID, t);
		else return false;
	}
	
	@Override
	public List<Teacher> QueryTeacherBytext(String text){
		
		return td.QueryTeacherBytext(text);
		
	}

}
