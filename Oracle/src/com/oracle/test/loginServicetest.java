package com.oracle.test;

import java.sql.SQLException;

import org.junit.Test;

import com.oracle.daomain.checkperson;
import com.oracle.service.LoginService;
import com.oracle.service.impl.LoginServiceImpl;

public class loginServicetest {
	
	private static LoginService loginService = new LoginServiceImpl();
	public loginServicetest() {
		// TODO Auto-generated constructor stub
	}
	@Test
	public void test() throws SQLException{
		checkperson checkperson1 = loginService.Login("10000","123456");
		System.out.println(checkperson1.toString());
	}

}
