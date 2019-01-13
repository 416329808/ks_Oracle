package com.oracle.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.oracle.dao.organize_paperdao;
import com.oracle.dao.paperdao;
import com.oracle.dao.impl.organize_paperdaoImpl;
import com.oracle.dao.impl.paperdaoImpl;
import com.oracle.daomain.question;
import com.oracle.service.paperService;

public class paperServiceImpl implements paperService{

	@Override
	public List<List<question>> Login(String paperNum) throws SQLException {
		// TODO Auto-generated method stub
		System.out.println("组卷Service开始");
		paperdao dao  =new paperdaoImpl();
		List<List<question>> List=dao.getpaper(paperNum);
		return List;
	}

}
