package com.oracle.dao.impl;

import java.sql.*;
import java.util.*;

import com.oracle.dao.TeacherDao;
import com.oracle.daomain.Teacher;
import com.oracle.util.DButil02;
import com.oracle.util.JDBCUtil02;

public class TeacherDaoImpl implements TeacherDao{

	@Override
	public List<Teacher> QueryAllTeacher() {
		// TODO 自动生成的方法存根
		ResultSet rs=null;
		String sql="select * from Teacher";
		String params[]=null;
		List<Teacher> teachers=new ArrayList<>();
		try {
			rs=DButil02.executeQuery(sql, params);
			while(rs.next()) {
				String TeacherID=rs.getString("TeacherID");
				String TeacherName=rs.getString("TeacherName");
				String Sex =rs.getString("Sex");
				String BelongsInstituteID =rs.getString("BelongsInstituteID");
				String BelongsInstituteName=rs.getString("BelongsInstituteName");
				Teacher te=new Teacher(TeacherID,TeacherName,Sex,BelongsInstituteID,BelongsInstituteName);
				teachers.add(te);
			}
			return teachers;
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

	@Override
	public Teacher QueryTeacherByID(String teacherID) {
		// TODO 自动生成的方法存根
		ResultSet rs=null;
		String sql="select * from Teacher where TeacherID=?";
		String params[]= {teacherID};
		Teacher te=null;
		try {
			rs=DButil02.executeQuery(sql, params);
			if(rs.next()) {
				String TeacherID=rs.getString("TeacherID");
				String TeacherName=rs.getString("TeacherName");
				String Sex =rs.getString("Sex");
				String BelongsInstituteID =rs.getString("BelongsInstituteID");
				String BelongsInstituteName=rs.getString("BelongsInstituteName");
				te=new Teacher(TeacherID,TeacherName,Sex,BelongsInstituteID,BelongsInstituteName); 
			}
			return te;
		} catch (ClassNotFoundException | SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
			return null;
		}finally {
			try {
				DButil02.CloseAll(rs, DButil02.createprepareStatement(sql, params), DButil02.getConn());
			} catch (ClassNotFoundException | SQLException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
		}
		
	}

	@Override
	public boolean Add(Teacher t) {
		// TODO 自动生成的方法存根
		System.out.println(t.getTeacherID());
		String sql="insert into Teacher(TeacherID,TeacherName,Sex,BelongsInstituteID,BelongsInstituteName) values(?,?,?,?,?)";
		String params[]= {t.getTeacherID(),t.getTeacherName(),t.getSex(),t.getBelongsInstituteID(),t.getBelongsInstituteName()};
		System.out.println("------------------");
		System.out.println(t.getTeacherID()+t.getTeacherName()+t.getSex()+t.getBelongsInstituteID()+t.getBelongsInstituteName());
		try {
			int count=DButil02.executeUpdate(sql, params);
			if(count>0) return true;
			else return false;
		} catch (ClassNotFoundException | SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean DeleteTeacherByID(String teacherID) {
		// TODO 自动生成的方法存根
		String sql="delete from Teacher where TeacherID=?";
		String params[]= {teacherID};
		try {
			int count=DButil02.executeUpdate(sql, params);
			if(count>0) return true;
			else return false;
		} catch (ClassNotFoundException | SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean UpdateTeacher(String teacherID, Teacher t) {
		// TODO 自动生成的方法存根
		String sql="update Teacher set TeacherID=?,TeacherName=?,Sex=?,BelongsInstituteID=?,BelongsInstituteName=? where TeacherID=?";
		String params[]= {t.getTeacherID(),t.getTeacherName(),t.getSex(),t.getBelongsInstituteID(),t.getBelongsInstituteName(),teacherID};
		try {
			int count=DButil02.executeUpdate(sql, params);
			if(count>0) return true;
			else return false;
		} catch (ClassNotFoundException | SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean IsExist(String teacherID) {
		// TODO 自动生成的方法存根
		if(QueryTeacherByID(teacherID)!=null) return true;
		else return false;
	}

	
	@Override
	public List<Teacher> QueryTeacherBytext(String text){
		ResultSet rs=null;
		String sql="select * from Teacher where TeacherID like '%"+text+"%' or TeacherName like '%"+text+"%' or Sex like '%"+text+"%' or BelongsInstituteName  like '%"+text+"%'";
		String params[]= {};
		
		
		
		System.out.println("函数被执行----》"+text);
		System.out.println("sql----->"+sql);
		List<Teacher> listTeacher=new ArrayList<Teacher>();
		
		try {
			rs=DButil02.executeQuery(sql,params);
			while(rs.next()) {
				
			  System.out.println("查到了结果----》id是"+rs.getString("TeacherID"));
				String TeacherID=rs.getString("TeacherID");
				String TeacherName=rs.getString("TeacherName");
				String Sex =rs.getString("Sex");
				String BelongsInstituteID =rs.getString("BelongsInstituteID");
				String BelongsInstituteName=rs.getString("BelongsInstituteName");
				Teacher te=null;
				te=new Teacher(TeacherID,TeacherName,Sex,BelongsInstituteID,BelongsInstituteName); 
				listTeacher.add(te);
			}
			return listTeacher;
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
