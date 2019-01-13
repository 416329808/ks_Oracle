package com.oracle.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.dbutils.QueryRunner;

import com.oracle.dao.logindao;
import com.oracle.dao.questiondao;
import com.oracle.util.JDBCUtil02;
import com.oracle.util.md5;
import com.oracle.daomain.Chapter;
import com.oracle.daomain.Course;
import com.oracle.daomain.QuestionType_Chapter;
import com.oracle.daomain.checkperson;
import com.oracle.daomain.question;

public class questiondaoimpl implements questiondao {

	private static final Course Course = null;

	@SuppressWarnings("null")
	@Override

	public List<Course> course() throws SQLException {// 获取课程列表
		// TODO Auto-generated method stub
		QueryRunner runner = new QueryRunner(JDBCUtil02.getDataSource());
		String sql = "select * from Course";
		List<Object> paramList = new ArrayList<Object>();
		JDBCUtil02 jdbcUtil = null;
		List<Course> CourseList = new ArrayList<Course>();
		try {
			jdbcUtil = new JDBCUtil02();
			//System.out.println("获取连接");
			JDBCUtil02.getConn(); // 获取数据库链接
			List<Map<Object, Object>> mapList = jdbcUtil.findResult(sql.toString(), paramList);
			//System.out.println("拉取课程表" + (String) mapList.get(0).get("COURSEID"));
			if (mapList.size() != 0) {
				for (int i = 0; i < mapList.size(); i++) {
					//System.out.println("获取课程" + i + "行的值");
					Map<Object, Object> map = mapList.get(i);
					Course Course1 = null;// 实例化Course初始化后添加到CourseLIST
					Course1 = new Course();
					// System.out.println("实例化Course");
					Course1.setCourseName((String) map.get("COURSENAME"));
					//System.out.println("赋值CourseName" + (String) map.get("COURSENAME"));
					//System.out.println("赋值章节数" + map.get("CHAPTERNUM"));
					Course1.setCourseID((String) map.get("COURSEID"));
					//System.out.println("赋值CourseID" + (String) map.get("COURSEID"));
					// Course1.setChapterNum( (int) map.get("CHAPTERNUM"));
					Object a = map.get("CHAPTERNUM");
					//System.out.println("赋值12112" + a.toString());
					CourseList.add(Course1);
					//System.out.println("添加到CourseList");
				}
			}
		} catch (Exception e) {
			System.out.println(this.getClass() + "执行课程查询操作抛出异常！");
			e.printStackTrace();
		} finally {
			if (jdbcUtil != null) {
				JDBCUtil02.release(JDBCUtil02.getConn(), JDBCUtil02.getPreparedStatement(), JDBCUtil02.getResultSet()); // 一定要释放资源
			}
		}
		return CourseList;
	}

	@SuppressWarnings("null")
	@Override
	public String Chapter(String CourseID) throws SQLException {// 获取章节列表
		System.out.println("章节dao开始" + CourseID);
		if (CourseID != null) {
			QueryRunner runner = new QueryRunner(JDBCUtil02.getDataSource());
			String sql = "select ChapterNum from Course where CourseID=?";
			//System.out.println("章节SQL语句" + CourseID);
			List<Object> paramList = new ArrayList<Object>();
			paramList.add(CourseID);
			//System.out.println("SQL语句就绪");
			JDBCUtil02 jdbcUtil = null;
			String Chapter = "";
			try {
				//System.out.println("实例化章节数据库连接");
				jdbcUtil = new JDBCUtil02();
				//System.out.println("获取连接");
				JDBCUtil02.getConn(); // 获取数据库链接
				List<Map<Object, Object>> mapList = jdbcUtil.findResult(sql.toString(), paramList);
				if (mapList.size() != 0) {
					Map<Object, Object> map = mapList.get(0);
					Chapter = map.get("CHAPTERNUM").toString();
				//	System.out.println("章节数=" + Chapter);
				}
			} catch (Exception e) {
				System.out.println(this.getClass() + "执行章节查询操作抛出异常！");
				e.printStackTrace();
			} finally {
				if (jdbcUtil != null) {
					JDBCUtil02.release(JDBCUtil02.getConn(), JDBCUtil02.getPreparedStatement(), JDBCUtil02.getResultSet()); // 一定要释放资源
				}
			}
			return Chapter;
		} else {
			System.out.println("课程号为空");
			return "0";
		}
		// TODO Auto-generated method stub
	}

	@Override
	public List<QuestionType_Chapter> QuestionType_Chapter(String CourseID, String ChapterID) throws SQLException {
		// TODO Auto-generated method stub
		// 获取具体题型列表
		return null;
	}

	@Override
	public List<question> allQuestion(String CourseID, String Chapter, String Type, String name) throws SQLException {
		// TODO Auto-generated method stub
		//System.out.println("题目查询dao开始");
		QueryRunner runner = new QueryRunner(JDBCUtil02.getDataSource());
		List<Object> paramList = new ArrayList<Object>();
		//System.out.println("超长SQL语句就绪");
		String Style = "ChoiceQuestion";//随便设一个初值，这个变量要作为表名，因为表名不能为空。
	try {
		switch (Type) {
		case "1": {
			Style = "ChoiceQuestion";
			break;
		}
		case "2": {
			Style = "TrueOrFalse";
			break;
		}
		case "3": {
			Style = "FillInTheBlank";
			break;
		}
		case "4": {
			Style = "ShortAnswerQuestion";
			break;
		}
		case "5": {
			Style = "CalculationProblems";
			break;
		}
		}
		//System.out.println(Style);
	} catch (Exception e) {
		System.out.println(this.getClass() + "Switch抛出异常！");
		e.printStackTrace();
	}
	//System.out.println("Switch就绪");
	String sql = "select Questions.*,"+Style+".* from Questions inner join "+Style+" on "+Style+".QuestionsID=Questions.QuestionsID where Questions.CourseID like '"+CourseID+"' and Questions.ChapterID like '"+Chapter+"' and Questions.Style like '"+Type+"' and "+Style+".Topics like '%"+name+"%'";
		System.out.println("题目超长SQL语句就绪"+sql);
		JDBCUtil02 jdbcUtil = null;
		List<question> Qlist = new ArrayList<question>();
		try {
			//System.out.println("题目数据库连接");
			jdbcUtil = new JDBCUtil02();
			//System.out.println("获取连接");
			JDBCUtil02.getConn(); // 获取数据库链接
			List<Map<Object, Object>> mapList = jdbcUtil.findResult(sql.toString(), paramList);
			//System.out.println("拉取题目表" + (String) mapList.get(0).get("COURSEID"));
			if (mapList.size() != 0) {
				if(Type=="1")
				{
				for (int i = 0; i < mapList.size(); i++) {
					Map<Object, Object> map = mapList.get(i);
					question question = null;// 实例化Course初始化后添加到CourseLIST
					question = new question();
					question.setTopics((String) map.get("TOPICS"));
					question.setOptionA((String) map.get("OPTIONA"));
					question.setOptionB((String) map.get("OPTIONB"));
					question.setOptionC((String) map.get("OPTIONC"));
					question.setOptionD((String) map.get("OPTIOND"));
					question.setAnswer((String) map.get("ANSWER"));
					question.setAnalysiss((String) map.get("ANALYSISS"));
					Qlist.add(question);
				}
				}
				else {
					for (int i = 0; i < mapList.size(); i++) {
						Map<Object, Object> map = mapList.get(i);
						question question = null;// 实例化Course初始化后添加到CourseLIST
						question = new question();
						question.setTopics((String) map.get("TOPICS"));
						question.setAnswer((String) map.get("ANSWER"));
						question.setAnalysiss((String) map.get("ANALYSISS"));
						Qlist.add(question);
					}
				}
			}
		} catch (Exception e) {
			System.out.println(this.getClass() + "执行题目查询操作抛出异常！");
			e.printStackTrace();
		} finally {
			if (jdbcUtil != null) {
				JDBCUtil02.release(JDBCUtil02.getConn(), JDBCUtil02.getPreparedStatement(), JDBCUtil02.getResultSet()); // 一定要释放资源
			}
		}
		return Qlist;
	}

}
