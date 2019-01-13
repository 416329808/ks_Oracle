package com.oracle.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.oracle.dao.questiondao;
import com.oracle.dao.impl.questiondaoimpl;
import com.oracle.daomain.question;
import com.oracle.service.passwordService;
import com.oracle.service.questionService;

public class questionServiceImpl implements questionService{

	@Override
	public List<question> getpassword(String CourseID, String Chapter, String Type, String name) throws SQLException {
		// TODO Auto-generated method stub
		questiondao dao=new questiondaoimpl();
		System.out.println("service查询题目");
		List<question> Qlist=dao.allQuestion(CourseID, Chapter, Type, name);
		return Qlist;
	}


}
