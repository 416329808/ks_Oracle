package com.oracle.service.impl;

import com.oracle.dao.impl.AdminInfodaoImpl;
import com.oracle.daomain.Admin;
import com.oracle.service.AdmininfoService;

public class AdmininfoServiceImpl implements AdmininfoService {

	@Override
	public Admin findAdminByid(String Adminid) {
		
		return new AdminInfodaoImpl().findAdminByid(Adminid);
	}

}
