package com.oracle.service.impl;

import com.oracle.dao.impl.AccountdaoImpl;
import com.oracle.daomain.checkperson;
import com.oracle.service.AccountService;

public class AccountServiceImpl implements AccountService {
@Override
	public checkperson FindaccountByid(String id) {
		
		return new AccountdaoImpl().FindaccountByid(id);
	}

}
