package com.oracle.dao;

import java.sql.SQLException;

import com.oracle.daomain.checkperson;

public interface passworddao {

	public checkperson getperson(String ID)throws SQLException;
}
