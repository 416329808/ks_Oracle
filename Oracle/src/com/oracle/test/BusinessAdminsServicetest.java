package com.oracle.test;

import java.sql.SQLException;

import org.junit.Test;

import com.oracle.daomain.businessadmins;
import com.oracle.service.BusinessAdminsService;
import com.oracle.service.impl.BusinessAdminServiceimpl;

public class BusinessAdminsServicetest {
	private  BusinessAdminsService businessAdminsService = new BusinessAdminServiceimpl();
	public BusinessAdminsServicetest() {
		// TODO Auto-generated constructor stub
	}
	@Test
	public void BusinessAdminsinfoServicetest() throws SQLException{
		String BusinessAdminsID="10000";
		businessadmins businessadmins=businessAdminsService.findBusinessadmins(BusinessAdminsID);
		System.out.println(businessadmins);
		
	}
	

}
