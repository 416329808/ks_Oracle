package com.oracle.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.oracle.dao.StudentDao;
import com.oracle.daomain.Teacher;
import com.oracle.daomain.student;
import com.oracle.util.DButil02;

public class StudentDaoImpl implements StudentDao {

	@Override
	public List<student> QueryAllStudent() {
		ResultSet rs=null;
		String sql="select * from Student";
		String params[]=null;
		List<student> students=new ArrayList<>();
		try {
			rs=DButil02.executeQuery(sql, params);
			while(rs.next()) {
				String studentID=rs.getString("STUDENTID");
				String ClassesID=rs.getString("CLASSESID");
				String ClassesName=rs.getString("CLASSESNAME");
				String studentName=rs.getString("STUDENTNAME");				
				String Sex =rs.getString("SEX");
				String ProfessionID =rs.getString("PROFESSIONID");
				String InstituteID =rs.getString("INSTITUTEID");
				String ProfessionName =rs.getString("PROFESSIONNAME");
				String InstituteName=rs.getString("INSTITUTENAME");
				student s=new student(studentID,ClassesID,ClassesName,studentName,Sex,ProfessionID,InstituteID,ProfessionName,InstituteName);
				students.add(s);
			}
			return students;
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
	public student QueryStudentByID(String studentID) {
		ResultSet rs=null;
		String sql="select * from Student where StudentID=?";
		String params[]= {studentID};
		student s=null;
		try {
			rs=DButil02.executeQuery(sql, params);
			if(rs.next()) {
				String studentID01=rs.getString("STUDENTID");
				String ClassesID=rs.getString("CLASSESID");
				String ClassesName=rs.getString("CLASSESNAME");
				String studentName=rs.getString("STUDENTNAME");				
				String Sex =rs.getString("SEX");
				String ProfessionID =rs.getString("PROFESSIONID");
				String InstituteID =rs.getString("INSTITUTEID");
				String ProfessionName =rs.getString("PROFESSIONNAME");
				String InstituteName=rs.getString("INSTITUTENAME");
				s=new student(studentID01,ClassesID,ClassesName,studentName,Sex,ProfessionID,InstituteID,ProfessionName,InstituteName); 
			}
			return s;
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
	public boolean Add(student s) {
		
		//System.out.println(t.getTeacherID());
		String sql="insert into Student(STUDENTID,CLASSESID,CLASSESNAME,STUDENTNAME,SEX,PROFESSIONID,INSTITUTEID,PROFESSIONNAME,INSTITUTENAME) values(?,?,?,?,?,?,?,?,?)";
		String params[]= {s.getStudentID(),s.getClassesID(),s.getClassesName(),s.getStudentName(),s.getSex(),s.getProfessionID(),s.getInstituteID(),s.getProfessionName(),s.getInstituteName()};
		//System.out.println("------------------");
		//System.out.println(t.getTeacherID()+s.getTeacherName()+s.getSex()+s.getBelongsInstituteID()+s.getBelongsInstituteName());
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
	public boolean DeleteStudentByID(String studentID) {
		String sql="delete from Student where StudentID=?";
		String params[]= {studentID};
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
	public boolean UpdateStudent(String studentID, student s) {
		String sql="update  Student set STUDENTID=?,CLASSESID=?,CLASSESNAME=?,STUDENTNAME=?,SEX=?,PROFESSIONID=?,INSTITUTEID=?,PROFESSIONNAME=?,INSTITUTENAME=? where StudentID=?";
		String params[]= {s.getStudentID(),s.getClassesID(),s.getClassesName(),s.getStudentName(),s.getSex(),s.getProfessionID(),s.getInstituteID(),s.getProfessionName(),s.getInstituteName(),s.getStudentID()};
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
	public List<student> QueryStudentBytext(String text) {
		ResultSet rs=null;
		String sql="select* from Student where StudentID like '%"+text+"%' or StudentName like '%"+text+"%' or Sex like '%"+text+"%' or ClassesName like '%"+text+"%' or ProfessionName  like '%"+text+"%' or InstituteName  like '%"+text+"%'";
		String params[]= {};
		
		//System.out.println("函数被执行----》"+text);
		System.out.println("sql----->"+sql);
		List<student> students=new ArrayList<student>();
		;
		try {
			rs=DButil02.executeQuery(sql,params);
			while(rs.next()) {
				
				
				String studentID=rs.getString("STUDENTID");
				String ClassesID=rs.getString("CLASSESID");
				String ClassesName=rs.getString("CLASSESNAME");
				String studentName=rs.getString("STUDENTNAME");				
				String Sex =rs.getString("SEX");
				String ProfessionID =rs.getString("PROFESSIONID");
				String InstituteID =rs.getString("INSTITUTEID");
				String ProfessionName =rs.getString("PROFESSIONNAME");
				String InstituteName=rs.getString("INSTITUTENAME");
				student s=new student(studentID,ClassesID,ClassesName,studentName,Sex,ProfessionID,InstituteID,ProfessionName,InstituteName);
				students.add(s);
			}
			
			
			
			return students;
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
