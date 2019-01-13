package com.oracle.service.impl;

import java.sql.SQLException;

import com.oracle.dao.businessadminsinfo;
import com.oracle.dao.impl.businessadminsinfoimpl;
import com.oracle.daomain.businessadmins;
import com.oracle.service.BusinessAdminsService;

public class BusinessAdminServiceimpl implements BusinessAdminsService {

	private businessadminsinfo businessadminsinfo=new businessadminsinfoimpl();

	@Override
	public businessadmins findBusinessadmins(String BusinessPersonID) throws SQLException {
		return businessadminsinfo.findbusBusinessadmins(BusinessPersonID);
	}

}
