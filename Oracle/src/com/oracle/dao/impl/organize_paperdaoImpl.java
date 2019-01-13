package com.oracle.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.dbutils.QueryRunner;

import com.oracle.dao.logindao;
import com.oracle.dao.organize_paperdao;
import com.oracle.daomain.checkperson;
import com.oracle.util.JDBCUtil02;

public class organize_paperdaoImpl implements organize_paperdao{

	@Override
	public int createpaper(int ChoiceQuestion, int TrueOrFalse, int FillInTheBlank, int ShortAnswerQuestion,
			int CalculationProblems) throws SQLException {
		// TODO Auto-generated method stub
		QueryRunner runner =new QueryRunner(JDBCUtil02.getDataSource());
		int paperNum=0;//预设试卷ID为零
		System.out.println("组卷dao");
		int sum=ChoiceQuestion+TrueOrFalse+FillInTheBlank+ShortAnswerQuestion+CalculationProblems;
		String sql="INSERT INTO EXAMINATION(QUESTIONSTOTALNUM) VALUES('"+sum+"')";
		System.out.println("新建试卷SQL语句就绪"+sql);
		List<Object> paramList = new ArrayList<Object>();
		System.out.println("创建题目信息list");
		JDBCUtil02 jdbcUtil = null;
		try {
			jdbcUtil = new JDBCUtil02();
			JDBCUtil02.getConn(); // 获取数据库链接
			int line = jdbcUtil.updateByPreparedStatement(sql.toString(), paramList);
			System.out.println("创建试卷");
			if (line == 1) {
				//查询插入试卷生产的试卷号
				System.out.println("插入成功，正在获取试卷号");
				String sql1="select * from EXAMINATION";
				//System.out.println("SQL语句就绪");
				List<Object> paramList1 = new ArrayList<Object>();
				//System.out.println("创建学生信息list");
				try {
					JDBCUtil02.getConn(); // 获取数据库链接
					List<Map<Object, Object>> paperList = jdbcUtil.findResult(sql1.toString(), paramList1);
					System.out.println("试卷号为"+paperList.size());
					paperNum= paperList.size();
				} catch (Exception e) {
					System.out.println(this.getClass() + "查询试卷号操作抛出异常！");
					e.printStackTrace();
				} finally {
					if (jdbcUtil != null) {
						JDBCUtil02.release(JDBCUtil02.getConn(),JDBCUtil02.getPreparedStatement(),JDBCUtil02.getResultSet()); // 一定要释放资源
					}
				}
			}
		} catch (Exception e) {
			System.out.println(this.getClass() + "执行新建试卷操作抛出异常！");
			e.printStackTrace();
		} finally {
			if (jdbcUtil != null) {
				JDBCUtil02.release(JDBCUtil02.getConn(),JDBCUtil02.getPreparedStatement(),JDBCUtil02.getResultSet()); // 一定要释放资源
			}
		}
		
		//根据试卷号给试卷插入题目
		String insertsql="";
		for(int i=1;i<=ChoiceQuestion;i++)
		{//循环插入选择题的sql语句
			String sqli="INSERT INTO EXAMINATION_QUESTIONS(EXAMINATIONID,QUESTIONSID,STYLE) VALUES('"+paperNum+"','"+i+"','1')";
			List<Object> pList = new ArrayList<Object>();
			System.out.println(sqli);
			try {
				JDBCUtil02.getConn(); // 获取数据库链接
				int line = jdbcUtil.updateByPreparedStatement(sqli.toString(), pList);
				System.out.println("插入选择题"+line);
				if (line == 1) {	}
			} catch (Exception e) {
				System.out.println(this.getClass() + "执行插入选择题操作抛出异常！");
				e.printStackTrace();
			} finally {
				if (jdbcUtil != null) {
					JDBCUtil02.release(JDBCUtil02.getConn(),JDBCUtil02.getPreparedStatement(),JDBCUtil02.getResultSet()); // 一定要释放资源
				}
			}
		}
		for(int i=1;i<=TrueOrFalse;i++)
		{//循环插入判断题的sql语句
			String sqli="INSERT INTO EXAMINATION_QUESTIONS(EXAMINATIONID,QUESTIONSID,STYLE) VALUES('"+paperNum+"','"+i+"','2')";
			List<Object> pList = new ArrayList<Object>();
			try {
				JDBCUtil02.getConn(); // 获取数据库链接
				int line = jdbcUtil.updateByPreparedStatement(sqli.toString(), pList);
				System.out.println("插入判断题"+line);
				if (line == 1) {	}
			} catch (Exception e) {
				System.out.println(this.getClass() + "执行插入判断题操作抛出异常！");
				e.printStackTrace();
			} finally {
				if (jdbcUtil != null) {
					JDBCUtil02.release(JDBCUtil02.getConn(),JDBCUtil02.getPreparedStatement(),JDBCUtil02.getResultSet()); // 一定要释放资源
				}
			}
		}
		for(int i=1;i<=FillInTheBlank;i++)
		{//循环插入填空题的sql语句
			String sqli="INSERT INTO EXAMINATION_QUESTIONS(EXAMINATIONID,QUESTIONSID,STYLE) VALUES('"+paperNum+"','"+i+"','3')";
			List<Object> pList = new ArrayList<Object>();
			try {
				JDBCUtil02.getConn(); // 获取数据库链接
				int line = jdbcUtil.updateByPreparedStatement(sqli.toString(), pList);
				System.out.println("插入填空题"+line);
				if (line == 1) {	}
			} catch (Exception e) {
				System.out.println(this.getClass() + "执行插入填空题操作抛出异常！");
				e.printStackTrace();
			} finally {
				if (jdbcUtil != null) {
					JDBCUtil02.release(JDBCUtil02.getConn(),JDBCUtil02.getPreparedStatement(),JDBCUtil02.getResultSet()); // 一定要释放资源
				}
			}
		}
		for(int i=1;i<=ShortAnswerQuestion;i++)
		{//循环插入简答题的sql语句
			String sqli="INSERT INTO EXAMINATION_QUESTIONS(EXAMINATIONID,QUESTIONSID,STYLE) VALUES('"+paperNum+"','"+i+"','4')";
			List<Object> pList = new ArrayList<Object>();
			try {
				JDBCUtil02.getConn(); // 获取数据库链接
				int line = jdbcUtil.updateByPreparedStatement(sqli.toString(), pList);
				System.out.println("插入简答题"+line);
				if (line == 1) {	}
			} catch (Exception e) {
				System.out.println(this.getClass() + "执行插入简答题操作抛出异常！");
				e.printStackTrace();
			} finally {
				if (jdbcUtil != null) {
					JDBCUtil02.release(JDBCUtil02.getConn(),JDBCUtil02.getPreparedStatement(),JDBCUtil02.getResultSet()); // 一定要释放资源
				}
			}
		}
		for(int i=1;i<=CalculationProblems;i++)
		{//循环插入计算题的sql语句
			String sqli="INSERT INTO EXAMINATION_QUESTIONS(EXAMINATIONID,QUESTIONSID,STYLE) VALUES('"+paperNum+"','"+i+"','5')";
			List<Object> pList = new ArrayList<Object>();
			try {
				JDBCUtil02.getConn(); // 获取数据库链接
				int line = jdbcUtil.updateByPreparedStatement(sqli.toString(), pList);
				System.out.println("插入计算题"+line);
				if (line == 1) {	}
			} catch (Exception e) {
				System.out.println(this.getClass() + "执行插入计算题操作抛出异常！");
				e.printStackTrace();
			} finally {
				if (jdbcUtil != null) {
					JDBCUtil02.release(JDBCUtil02.getConn(),JDBCUtil02.getPreparedStatement(),JDBCUtil02.getResultSet()); // 一定要释放资源
				}
			}
		}
		return paperNum;
	}
}
