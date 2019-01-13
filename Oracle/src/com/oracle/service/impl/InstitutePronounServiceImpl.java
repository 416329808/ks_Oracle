package com.oracle.service.impl;

import com.oracle.dao.InstitutePronounDao;
import com.oracle.dao.impl.InstitutePronounDaoImpl;
import com.oracle.daomain.InstitutePronoun;
import com.oracle.service.InstitutePronounService;

public class InstitutePronounServiceImpl implements InstitutePronounService {

	@Override
	public InstitutePronoun FindinstitutepronounByname(String InstituteName) {
		InstitutePronounDao institutePronounDao =new InstitutePronounDaoImpl();
		return institutePronounDao.FindinstitutepronounByname(InstituteName);
	}

}
