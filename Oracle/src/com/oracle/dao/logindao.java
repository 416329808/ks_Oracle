package com.oracle.dao;

import java.sql.SQLException;

import com.oracle.daomain.checkperson;

public interface logindao {

	
   public checkperson Login(String name, String pwd)throws SQLException;
}
