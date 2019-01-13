package com.oracle.service.impl;

import java.sql.SQLException;

import com.oracle.dao.logindao;
import com.oracle.dao.passworddao;
import com.oracle.dao.impl.logindaoImpl;
import com.oracle.dao.impl.passworddaoImpl;
import com.oracle.daomain.checkperson;
import com.oracle.service.ChapterService;
import com.oracle.service.passwordService;

public class passwordServiceImpl implements passwordService{

	@Override
	public checkperson getpassword(String ID) throws SQLException {
		// TODO Auto-generated method stub
		//获取密码传到servlet
	    passworddao dao  =new passworddaoImpl();
	    checkperson list=dao.getperson(ID);
		return list;
	}

}
