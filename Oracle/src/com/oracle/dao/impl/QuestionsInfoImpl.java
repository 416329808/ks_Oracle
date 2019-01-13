package com.oracle.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.oracle.dao.QuestionInfo;
import com.oracle.daomain.Questions;
import com.oracle.util.JDBCUtil02;

public class QuestionsInfoImpl implements QuestionInfo {

	public QuestionsInfoImpl() {
		
	}

	@Override
	public List<Questions> findAllQuestions(String str ,int pageNum,int pageSize) throws SQLException {
		List<Questions> questionsList = new ArrayList<Questions>();
		List<Object> paramList = new ArrayList<Object>();
		String sql; 
		boolean flag=false;
		if ("choice".equals(str)) {
			sql="select * from CHOICEQUESTION_QUESTIONS where rownum<?  minus  select * from CHOICEQUESTION_QUESTIONS where rownum<?";
			flag=true;
		}else {
			sql="select * from  UN_CHOICEQUESTION_QUESTIONS where rownum<?  minus  select * from UN_CHOICEQUESTION_QUESTIONS where rownum<?";//创建视图
		}		
		paramList.add(pageNum*pageSize+1);
		//System.out.println(pageNum*pageSize+1);
		paramList.add((pageNum-1)*pageSize+1);
		//System.out.println((pageNum-1)*pageSize+1);
		JDBCUtil02 jdbcUtil = new JDBCUtil02();
		Questions questions = null;
		try {
			JDBCUtil02.getConn();
			List<Map<Object, Object>> mapList = jdbcUtil.findResult(sql.toString(), paramList);
			int size = mapList.size();
			if (size >= 1) {
				for (int i = 0; i < size; i++) {
					Map<Object, Object> map = mapList.get(i);
					questions = new Questions();
					questions.setChapterID((String) map.get("CHAPTERID"));
					questions.setChapterName((String) map.get("CHAPTERNAME"));
					questions.setQuestionsID(map.get("QUESTIONSID").toString());
					questions.setCourseID((String) map.get("COURSEID"));
					questions.setCourseName((String) map.get("COURSENAME"));
					questions.setStyle((String) map.get("STYLE"));
					questions.setTopics((String) map.get("TOPICS"));
					questions.setScore(map.get("SCORE").toString());
					questions.setDifficult(map.get("DIFFICULT").toString());
					questions.setCreationDate(map.get("CREATIONDATE").toString());
					questions.setExtractNum(map.get("EXTRACTNUM").toString());
					questions.setAnswer((String) map.get("ANSWER"));
					questions.setAnalysiss((String) map.get("ANALYSISS"));
					questions.setReporterID((String) map.get("REPORTERID"));
					if (flag==true) {
						questions.setOptionA((String) map.get("OPTIONA"));
						questions.setOptionB((String) map.get("OPTIONB"));
						questions.setOptionC((String) map.get("OPTIONC"));
						questions.setOptionD((String) map.get("OPTIOND"));
					}
					//System.out.println(questions);
					questionsList.add(questions);
				}

			}

		} catch (SQLException e) {
			System.out.println(this.getClass() + "执行查询操作抛出异常！");
			e.printStackTrace();
		} finally {
			if (jdbcUtil != null) {
				JDBCUtil02.release(JDBCUtil02.getConn(), JDBCUtil02.getPreparedStatement(),
						JDBCUtil02.getResultSet());
			}
		}

		return questionsList;
	}

	@Override
	public Questions findByID(Questions questions) throws SQLException {
		Questions questions2= new Questions();
		String sql;
		Boolean flag= false;
		JDBCUtil02 jdbcUtil = new JDBCUtil02();
		Connection connection=JDBCUtil02.getConn();
		List<Object> paramList = new ArrayList<Object>();
		//System.out.println(questions.getStyle());
		if ("1".equals((questions.getStyle()).replace("'", ""))) {
			sql="select * from CHOICEQUESTION_QUESTIONS where STYLE=? AND QUESTIONSID= ?";
			flag=true;
		}else {
			sql= "select * from  UN_CHOICEQUESTION_QUESTIONS where STYLE=? AND QUESTIONSID= ?";//创建视图
		}
		paramList.add((questions.getStyle()).replace("'", ""));
		paramList.add((questions.getQuestionsID()).replace("'", ""));
		System.out.println(paramList);
		try {
			List<Map<Object, Object>> mapList = jdbcUtil.findResult(sql.toString(), paramList);
			//System.out.println(size);
			if (mapList.size() >= 1) {
				Map<Object, Object> map = mapList.get(0);
				System.out.println(map);
				questions2.setChapterID((String) map.get("CHAPTERID"));
				questions2.setChapterName((String) map.get("CHAPTERNAME"));
				questions2.setQuestionsID(map.get("QUESTIONSID").toString());
				questions2.setCourseID((String) map.get("COURSEID"));
				questions2.setCourseName((String) map.get("COURSENAME"));
				questions2.setStyle((String) map.get("STYLE"));
				questions2.setTopics((String) map.get("TOPICS"));
				questions2.setScore(map.get("SCORE").toString());
				questions2.setDifficult(map.get("DIFFICULT").toString());
				questions2.setCreationDate(map.get("CREATIONDATE").toString());
				questions2.setExtractNum(map.get("EXTRACTNUM").toString());
				questions2.setAnswer((String) map.get("ANSWER"));
				questions2.setAnalysiss((String) map.get("ANALYSISS"));
				questions2.setReporterID((String) map.get("REPORTERID"));
				if (flag==true) {
					questions2.setOptionA((String) map.get("OPTIONA"));
					questions2.setOptionB((String) map.get("OPTIONB"));
					questions2.setOptionC((String) map.get("OPTIONC"));
					questions2.setOptionD((String) map.get("OPTIOND"));
				}
				
			}
		} catch (Exception e) {
		}finally {
			if (jdbcUtil != null) {
				JDBCUtil02.release(connection, JDBCUtil02.getPreparedStatement(), JDBCUtil02.getResultSet()); 
			}
		}

		return questions2;
	}
	
	@Override
	public  List<Questions> findAllQuestionsWithPage(String str) throws SQLException {
		List<Questions> questionsList = new ArrayList<Questions>();
		String sql; 
		boolean flag=false;
		if ("choice".equals(str)) {
			sql="select * from CHOICEQUESTION_QUESTIONS";
			flag=true;
		}else {
			sql= "select * from  UN_CHOICEQUESTION_QUESTIONS";//创建视图
		}
		JDBCUtil02 jdbcUtil = new JDBCUtil02();
		List<Object> paramList = new ArrayList<Object>();
		Questions questions = null;
		try {
			JDBCUtil02.getConn();
			List<Map<Object, Object>> mapList = jdbcUtil.findResult(sql.toString(), paramList);
			int size = mapList.size();
			if (size >= 1) {
				for (int i = 0; i < size; i++) {
					Map<Object, Object> map = mapList.get(i);
					questions = new Questions();
					questions.setChapterID((String) map.get("CHAPTERID"));
					questions.setChapterName((String) map.get("CHAPTERNAME"));
					questions.setQuestionsID(map.get("QUESTIONSID").toString());
					questions.setCourseID((String) map.get("COURSEID"));
					questions.setCourseName((String) map.get("COURSENAME"));
					questions.setStyle((String) map.get("STYLE"));
					questions.setTopics((String) map.get("TOPICS"));
					questions.setScore(map.get("SCORE").toString());
					questions.setDifficult(map.get("DIFFICULT").toString());
					questions.setCreationDate(map.get("CREATIONDATE").toString());
					questions.setExtractNum(map.get("EXTRACTNUM").toString());
					questions.setAnswer((String) map.get("ANSWER"));
					questions.setAnalysiss((String) map.get("ANALYSISS"));
					questions.setReporterID((String) map.get("REPORTERID"));
					if (flag==true) {
						questions.setOptionA((String) map.get("OPTIONA"));
						questions.setOptionB((String) map.get("OPTIONB"));
						questions.setOptionC((String) map.get("OPTIONC"));
						questions.setOptionD((String) map.get("OPTIOND"));
					}
					//System.out.println(questions);
					questionsList.add(questions);
				}

			}

		} catch (SQLException e) {
			System.out.println(this.getClass() + "执行查询操作抛出异常！");
			e.printStackTrace();
		} finally {
			if (jdbcUtil != null) {
				JDBCUtil02.release(JDBCUtil02.getConn(), JDBCUtil02.getPreparedStatement(), JDBCUtil02.getResultSet()); 
			}
		}

		return questionsList;
	}
	@Override
	public int addquestions(Questions questions) throws SQLException {
		JDBCUtil02 jdbcUtil = new JDBCUtil02();
		JDBCUtil02.getConn();
		List<Object> paramList = new ArrayList<Object>();
		String sql;
		int r = -1;
		if ("1".equals(questions.getStyle())) {
			sql="insert into ChoiceQuestion(Topics,Score,Answer,Analysiss,Difficult,ReporterID,OptionA,OptionB,OptionC,OptionD) values(?,?,?,?,?,?,?,?,?,?)";
		}else if ("2".equals(questions.getStyle())) {
			 sql="insert into TrueOrFalse(Topics,Score,Answer,Analysiss,Difficult,ReporterID) values(?,?,?,?,?,?)";
		}else if("3".equals(questions.getStyle())){
			sql="insert into FillInTheBlank(Topics,Score,Answer,Analysiss,Difficult,ReporterID) values(?,?,?,?,?,?)";
		}else if("4".equals(questions.getStyle())){
			sql="insert into ShortAnswerQuestion(Topics,Score,Answer,Analysiss,Difficult,ReporterID) values(?,?,?,?,?,?)";
		}else{
			sql="insert into CalculationProblems(Topics,Score,Answer,Analysiss,Difficult,ReporterID) values(?,?,?,?,?,?)";
		}
		paramList.add(questions.getTopics());
		paramList.add(questions.getScore());
		paramList.add(questions.getAnswer());
		paramList.add(questions.getAnalysiss());
		paramList.add(questions.getDifficult());
		paramList.add(questions.getReporterID());
		if ("1".equals(questions.getStyle())) {
			paramList.add(questions.getOptionA());
			paramList.add(questions.getOptionB());
			paramList.add(questions.getOptionC());
			paramList.add(questions.getOptionD());
		}try {
			r=jdbcUtil.updateByPreparedStatement(sql, paramList);
			int q=insertQuestion(questions);
		} catch (Exception e) {
			
		}finally {
			if (jdbcUtil != null) {
				JDBCUtil02.release(JDBCUtil02.getConn(), JDBCUtil02.getPreparedStatement(), JDBCUtil02.getResultSet()); 
			}
		}
		return r;
	
	}
	public int insertQuestion(Questions questions) throws SQLException{
		JDBCUtil02 jdbcUtil01 = new JDBCUtil02();
		JDBCUtil02.getConn();
		int q=0;
		String sql;
		List<Object> paramslist = new ArrayList<Object>();
		try {
			if ("1".equals(questions.getStyle())) {
				sql="select * from ChoiceQuestion";
			}else if ("2".equals(questions.getStyle())) {
				 sql="select * from TrueOrFalse";
			}else if("3".equals(questions.getStyle())){
				sql="select * from FillInTheBlank";
			}else if("4".equals(questions.getStyle())){
				sql="select * from ShortAnswerQuestion";
			}else{
				sql="select * from CalculationProblems";
			}
		List<Map<Object, Object>> mapList = jdbcUtil01.findResult(sql, paramslist);
		ResultSet result=JDBCUtil02.getResultSet();
		int row=result.getRow();
		//获取表的总行数  数据集
		String sqlq="insert into Questions(QuestionsID,ChapterID,CourseID,Style) values(?,?,?,?)";
		List<Object> params = new ArrayList<Object>();
		params.add(row);
		params.add(questions.getChapterID());
		params.add(questions.getCourseID());
		params.add(questions.getStyle());		
			q=jdbcUtil01.updateByPreparedStatement(sqlq, params);
		} catch (SQLIntegrityConstraintViolationException e) {
			System.out.println("课程中已存在该题!");
		}finally {
			if (jdbcUtil01 != null) {
				JDBCUtil02.release(JDBCUtil02.getConn(), JDBCUtil02.getPreparedStatement(), JDBCUtil02.getResultSet()); 
			}
		}
		return q;
	}
	/*
	 * 在数据类型表中删除问题
	 * @see com.oracle.dao.QuestionInfo#deleteQuestionsByID(com.oracle.daomain.Questions)
	 */
	@Override
	public int deleteQuestionsByID(Questions questions) throws SQLException {
		JDBCUtil02 jdbcUtil = null;
		List<Object> paramlist = new ArrayList<Object>();
		List<Object> paramlist1 = new ArrayList<Object>();
		int r=0;
		String sql;
		try {
			jdbcUtil = new JDBCUtil02();
			// 获取数据库链接
			JDBCUtil02.getConn();
			if ("1".equals(questions.getStyle())) {
				sql="delete from ChoiceQuestion where QUESTIONSID = ?";
			}else if ("2".equals(questions.getStyle())) {
				 sql="delete from TrueOrFalse where QUESTIONSID = ?";
			}else if("3".equals(questions.getStyle())){
				sql="delete from FillInTheBlank where QUESTIONSID = ? ";
			}else if("4".equals(questions.getStyle())){
				sql="delete from ShortAnswerQuestion where QUESTIONSID = ?";
			}else{
				sql="delete from CalculationProblems where QUESTIONSID = ?";
			}
			paramlist.add(questions.getQuestionsID());
			r = jdbcUtil.updateByPreparedStatement(sql.toString(), paramlist);
			sql="delete from QUESTIONS where QUESTIONSID = ? AND STYLE = ?";
			paramlist1.add(questions.getQuestionsID());
			paramlist1.add(questions.getStyle());
			r = jdbcUtil.updateByPreparedStatement(sql.toString(), paramlist1);
		} catch (Exception e) {
			System.out.println("删除失败");
			e.printStackTrace();
		}finally {
		if (jdbcUtil != null) {
			JDBCUtil02.release(JDBCUtil02.getConn(), JDBCUtil02.getPreparedStatement(), JDBCUtil02.getResultSet()); 
		}
		}
		return r;
	}

	@Override
	public int updateQuestionsByID(Questions questions) throws SQLException {
		JDBCUtil02 jdbcUtil = new JDBCUtil02();
		JDBCUtil02.getConn();
		int q=0;
		String sql;
		List<Object> paramslist = new ArrayList<Object>();
		try {
			if ("1".equals(questions.getStyle())) {
				sql="update ChoiceQuestion set Topics=?,Score=?,Answer=?,Analysiss=?,Difficult=?,OptionA=?,OptionB=?,OptionC=?,OptionD=? where QuestionsID=?";
			}else if ("2".equals(questions.getStyle())) {
				 sql="update TrueOrFalse set Topics=?,Score=?,Answer=?,Analysiss=?,Difficult=? where QuestionsID=?";
			}else if("3".equals(questions.getStyle())){
				sql="update FillInTheBlank set Topics=?,Score=?,Answer=?,Analysiss=?,Difficult=? where QuestionsID=?";
			}else if("4".equals(questions.getStyle())){
				sql="update ShortAnswerQuestion set Topics=?,Score=?,Answer=?,Analysiss=?,Difficult=? where QuestionsID=?";
			}else{
				sql="update CalculationProblems set Topics=?,Score=?,Answer=?,Analysiss=?,Difficult=? where QuestionsID=?";
			}
			paramslist.add(questions.getTopics());
			paramslist.add(questions.getScore());
			paramslist.add(questions.getAnswer());
			paramslist.add(questions.getAnalysiss());
			paramslist.add(questions.getDifficult());
			if ("1".equals(questions.getStyle())) {
				paramslist.add(questions.getOptionA());
				paramslist.add(questions.getOptionB());
				paramslist.add(questions.getOptionC());
				paramslist.add(questions.getOptionD());
			}

			paramslist.add(questions.getQuestionsID());
			System.out.println(paramslist);
			q=jdbcUtil.updateByPreparedStatement(sql, paramslist);
		} catch (Exception e) {
			System.out.println("出错了");
		}finally {
			if (jdbcUtil != null) {
				JDBCUtil02.release(JDBCUtil02.getConn(), JDBCUtil02.getPreparedStatement(), JDBCUtil02.getResultSet()); 
			}
		}
		return q;
	}

	@Override
	public List<Questions> findsomeQuestionsWithPage(Questions questions) throws SQLException {
		List<Questions> questionsList = new ArrayList<Questions>();
		Questions questions2= new Questions();
		String sql;
		Boolean flag= false;
		JDBCUtil02 jdbcUtil = new JDBCUtil02();
		Connection connection=JDBCUtil02.getConn();
		List<Object> paramList = new ArrayList<Object>();
		//System.out.println(questions.getStyle());
		if ("1".equals((questions.getStyle()).replace("'", ""))) {
			sql="select * from CHOICEQUESTION_QUESTIONS where STYLE=? AND COURSEID= ? AND CHAPTERID= ?";
			flag=true;
		}else {
			sql= "select * from  UN_CHOICEQUESTION_QUESTIONS where STYLE=? AND COURSEID= ? AND CHAPTERID= ?";//创建视图
		}
		paramList.add((questions.getStyle()).replace("'", ""));
		paramList.add((questions.getCourseID()).replace("'", ""));
		paramList.add((questions.getChapterID()).replace("'", ""));
		System.out.println(paramList);
		try {
			JDBCUtil02.getConn();
			List<Map<Object, Object>> mapList = jdbcUtil.findResult(sql.toString(), paramList);
			int size = mapList.size();
			System.out.println("大小"+size);
			if (size >= 1) {
				for (int i = 0; i < size; i++) {
					Map<Object, Object> map = mapList.get(i);
					questions2 = new Questions();
					questions2.setChapterID((String) map.get("CHAPTERID"));
					questions2.setChapterName((String) map.get("CHAPTERNAME"));
					questions2.setQuestionsID(map.get("QUESTIONSID").toString());
					questions2.setCourseID((String) map.get("COURSEID"));
					questions2.setCourseName((String) map.get("COURSENAME"));
					questions2.setStyle((String) map.get("STYLE"));
					questions2.setTopics((String) map.get("TOPICS"));
					questions2.setScore(map.get("SCORE").toString());
					questions2.setDifficult(map.get("DIFFICULT").toString());
					questions2.setCreationDate(map.get("CREATIONDATE").toString());
					questions2.setExtractNum(map.get("EXTRACTNUM").toString());
					questions2.setAnswer((String) map.get("ANSWER"));
					questions2.setAnalysiss((String) map.get("ANALYSISS"));
					questions2.setReporterID((String) map.get("REPORTERID"));
					if (flag==true) {
						questions2.setOptionA((String) map.get("OPTIONA"));
						questions2.setOptionB((String) map.get("OPTIONB"));
						questions2.setOptionC((String) map.get("OPTIONC"));
						questions2.setOptionD((String) map.get("OPTIOND"));
					}
					//System.out.println(questions);
					questionsList.add(questions2);
				}

			}

		} catch (Exception e) {
		}finally {
			if (jdbcUtil != null) {
				JDBCUtil02.release(connection, JDBCUtil02.getPreparedStatement(), JDBCUtil02.getResultSet()); 
			}
		}

		return questionsList;
	}

	@Override
	public List<Questions> findsomeQuestions(Questions questions, int pageNum, int pageSize) throws SQLException {
		List<Questions> questionsList = new ArrayList<Questions>();
		Questions questions2= new Questions();
		String sql;
		Boolean flag= false;
		JDBCUtil02 jdbcUtil = new JDBCUtil02();
		Connection connection=JDBCUtil02.getConn();
		List<Object> paramList = new ArrayList<Object>();
		//System.out.println(questions.getStyle());
		if ("1".equals((questions.getStyle()).replace("'", ""))) {
			sql="select * from CHOICEQUESTION_QUESTIONS where STYLE=? AND COURSEID= ? AND CHAPTERID= ? and rownum<? minus select * from CHOICEQUESTION_QUESTIONS where STYLE=? AND COURSEID= ? AND CHAPTERID= ? and rownum<?";
			flag=true;
		}else {
			sql= "select * from  UN_CHOICEQUESTION_QUESTIONS where STYLE=? AND COURSEID= ? AND CHAPTERID= ? and rownum<? minus select * from UN_CHOICEQUESTION_QUESTIONS where STYLE=? AND COURSEID= ? AND CHAPTERID= ? and rownum<?";//创建视图
		}
		paramList.add((questions.getStyle()).replace("'", ""));
		paramList.add((questions.getCourseID()).replace("'", ""));
		paramList.add((questions.getChapterID()).replace("'", ""));
		paramList.add(pageNum*pageSize+1);
		paramList.add((questions.getStyle()).replace("'", ""));
		paramList.add((questions.getCourseID()).replace("'", ""));
		paramList.add((questions.getChapterID()).replace("'", ""));
		paramList.add((pageNum-1)*pageSize+1);
		System.out.println("---------"+paramList);
		try {
			JDBCUtil02.getConn();
			List<Map<Object, Object>> mapList = jdbcUtil.findResult(sql.toString(), paramList);
			int size = mapList.size();
			if (size >= 1) {
				for (int i = 0; i < size; i++) {
					Map<Object, Object> map = mapList.get(i);
					questions2 = new Questions();
					questions2.setChapterID((String) map.get("CHAPTERID"));
					questions2.setChapterName((String) map.get("CHAPTERNAME"));
					questions2.setQuestionsID(map.get("QUESTIONSID").toString());
					questions2.setCourseID((String) map.get("COURSEID"));
					questions2.setCourseName((String) map.get("COURSENAME"));
					questions2.setStyle((String) map.get("STYLE"));
					questions2.setTopics((String) map.get("TOPICS"));
					questions2.setScore(map.get("SCORE").toString());
					questions2.setDifficult(map.get("DIFFICULT").toString());
					questions2.setCreationDate(map.get("CREATIONDATE").toString());
					questions2.setExtractNum(map.get("EXTRACTNUM").toString());
					questions2.setAnswer((String) map.get("ANSWER"));
					questions2.setAnalysiss((String) map.get("ANALYSISS"));
					questions2.setReporterID((String) map.get("REPORTERID"));
					if (flag==true) {
						questions2.setOptionA((String) map.get("OPTIONA"));
						questions2.setOptionB((String) map.get("OPTIONB"));
						questions2.setOptionC((String) map.get("OPTIONC"));
						questions2.setOptionD((String) map.get("OPTIOND"));
					}
					System.out.println("[][][][][]"+questions2);
					questionsList.add(questions2);
				}

			}

		} catch (Exception e) {
		}finally {
			if (jdbcUtil != null) {
				JDBCUtil02.release(connection, JDBCUtil02.getPreparedStatement(), JDBCUtil02.getResultSet()); 
			}
		}

		return questionsList;
	}



}
