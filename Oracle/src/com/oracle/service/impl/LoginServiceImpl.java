package com.oracle.service.impl;

import java.sql.SQLException;

import com.oracle.dao.logindao;
import com.oracle.dao.impl.logindaoImpl;
import com.oracle.daomain.checkperson;
import com.oracle.service.LoginService;

public class LoginServiceImpl implements LoginService {


	@Override
	public checkperson Login(String name, String pwd) throws SQLException {
		// TODO Auto-generated method stub
	    logindao dao  =new logindaoImpl();
	    checkperson list=dao.Login(name,pwd);
		
		return list;
	}

}
