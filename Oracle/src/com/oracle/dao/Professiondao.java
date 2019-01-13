package com.oracle.dao;


import com.oracle.daomain.Profession;
/**
 * 根据专业名称查看相应的专业名称
 * @author MWY
 *
 */
public interface Professiondao {
	public Profession FindProfessionByname(String ProfessionName);
}
