package com.oracle.service;

import java.sql.SQLException;
import java.util.List;

import com.oracle.daomain.checkperson;
import com.oracle.daomain.question;

public interface questionService {
	public List<question> getpassword(String CourseID, String Chapter, String Type, String name)throws SQLException;
}
