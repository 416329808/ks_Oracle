package com.oracle.service.impl;

import com.oracle.dao.impl.ClassdaoImpl;
import com.oracle.daomain.Classe;
import com.oracle.service.ClassService;

public class ClassServiceImpl implements ClassService {

	@Override
	public Classe FindClasseByname(String ClasseName) {
		
		return new ClassdaoImpl().FindClasseByname(ClasseName);
	}

}
