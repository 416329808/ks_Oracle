package com.oracle.dao;

import java.sql.SQLException;

import com.oracle.daomain.checkperson;

public interface change_passworddao {
	public String change(String ID,String NewPassword,String OldPassword) throws SQLException;
	public checkperson findByID(String ID) throws SQLException;
}
