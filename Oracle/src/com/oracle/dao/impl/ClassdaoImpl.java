package com.oracle.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.oracle.dao.Classdao;
import com.oracle.daomain.Classe;
import com.oracle.daomain.Profession;
import com.oracle.util.DButil02;

public class ClassdaoImpl implements Classdao {

	@Override
	public Classe FindClasseByname(String ClasseName) {
		ResultSet rs=null;
		String sql="select* from ClassesPronoun where ClassesName=?";
		String params[]= {ClasseName};
		
		try {
			rs=DButil02.executeQuery(sql, params);
			Classe Classe=null;
			
			if(rs.next()) {	
				String CLASSESID= rs.getString("CLASSESID");
				String CLASSESNAME=rs.getString("CLASSESNAME");
				String BELONGSPROFESSIONPRONOUN=rs.getString("BELONGSPROFESSIONPRONOUN");
				String BELONGSINSTITUTEPRONOUN=rs.getString("BELONGSINSTITUTEPRONOUN");
				int SEQUENCES=rs.getInt("SEQUENCES");
				String ENABLES=rs.getString("ENABLES");
				String REMARKS=rs.getString("REMARKS");
				
				System.out.println("dao执行拉------>"+CLASSESID);
				
				Classe=new Classe(CLASSESID, CLASSESNAME, BELONGSPROFESSIONPRONOUN, BELONGSINSTITUTEPRONOUN, SEQUENCES,ENABLES,REMARKS);
				
			}
			return Classe;
		} catch (ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
			return null;
		}finally {
			try {
				DButil02.CloseAll(rs, DButil02.createprepareStatement(sql, params), DButil02.getConn());
			} catch (ClassNotFoundException | SQLException e) {
				
				e.printStackTrace();
			}
		}
	}

}
