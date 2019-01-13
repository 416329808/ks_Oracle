package com.oracle.service;

import java.sql.SQLException;

import com.oracle.daomain.checkperson;

public interface LoginService {

	public checkperson Login(String name,String pwd)throws SQLException;
	
}
