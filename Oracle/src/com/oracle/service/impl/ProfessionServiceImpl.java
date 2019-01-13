package com.oracle.service.impl;

import com.oracle.dao.impl.ProfessiondaoImpl;
import com.oracle.daomain.Profession;
import com.oracle.service.ProfessionService;

public class ProfessionServiceImpl implements ProfessionService {

	@Override
	public Profession FindProfessionByname(String ProfessionName) {
		return new ProfessiondaoImpl().FindProfessionByname(ProfessionName);
	}

}
