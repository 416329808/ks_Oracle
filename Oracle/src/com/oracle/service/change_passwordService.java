package com.oracle.service;

import java.sql.SQLException;

import com.oracle.daomain.checkperson;

public interface change_passwordService {

	public String change(String ID,String NewPassword,String OldPassword)throws SQLException;
	
	public checkperson findByID(String ID) throws SQLException;
}
