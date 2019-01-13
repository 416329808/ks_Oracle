package com.oracle.dao;

import com.oracle.daomain.Classe;

/*
 * 通过班级名称来查找班级的信息
 */
public interface Classdao {
	public Classe FindClasseByname(String ClasseName);
}
