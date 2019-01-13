package com.oracle.service;

import java.sql.SQLException;

import com.oracle.daomain.businessadmins;

public interface BusinessAdminsService {

	public businessadmins findBusinessadmins (String BusinessPersonID)throws SQLException;
}
