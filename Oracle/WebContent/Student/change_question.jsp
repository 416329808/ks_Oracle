<%@page import="com.oracle.daomain.Questions"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="js/jquery-1.11.0.js"></script>
	<link rel="stylesheet" href="css/bootstrap.css">
	<script type="text/javascript" src="js/bootstrap.js"></script>
	<meta name="viewpoint" content="width=device-width,initial-scale=1">
<script type="text/javascript">
$(document).ready(function(){ 
	$("#cancel").click(function(){	
		location.href="/Oracle/QuestionsinfoServlet";
		});});
</script>

<body>
	<%
		Questions questions = (Questions) request.getAttribute("questions");
		if (questions != null) {
		String ID=questions.getQuestionsID();
		String courseID = questions.getCourseID();
		String chapterID = questions.getChapterID();
		String style = questions.getStyle();
		String score = questions.getScore();
		String difficult = questions.getDifficult();
		String businessadminsid = questions.getReporterID();
		String topics = questions.getTopics();
		String optionA = questions.getOptionA();
		String optionB = questions.getOptionB();
		String optionC = questions.getOptionC();
		String optionD = questions.getOptionD();
		String answer = questions.getAnswer();
		String analysiss = questions.getAnalysiss();
	%>
    <div class="container">
    <form id="form" name="form" class="form-horizontal" action="/Oracle/QuestionsUpdateServlet?opertion=add" method="post">
     <br>
     <div class="row">
         <table class="table table-bordered">
		  <thead>
		    <tr>
	          <th>题目号</th>
		      <th>所属课程号</th>
		      <th>所属章节号</th>
		      <th>所属题型</th>
		      <th>分数</th>
		      <th>难度</th>
		      <th>录入员工号</th>
		    </tr>
		  </thead>
		<tbody>
		    <tr>
		      <td>
		        <input type="text" class="form-control" style="width: 100%" id="ID" name="ID" value=<%=ID %> readonly="readonly">
		      </td>
		      <td>
		         <select name="course_select">
               <option value=<%=courseID %>><%=courseID %></option>
               <option value="1104201506">1104201506</option>
               <option value="1104201507">1104201507</option>
               <option value="1104201508">1104201508</option>
            </select>
		      </td>
		      <td>
		       <select name="chapter_select">
               <option value=<%=chapterID %>><%=chapterID %></option>
               <option value="1">1</option>
               <option value="2">2</option>
               <option value="3">3</option>
            </select>
            </td>
            <td>
            	<input type="text" class="form-control" style="width: 100%" id="style" name="style"  value=<%=style %> readonly="readonly">
            </td>
            <td>
		        <input type="text" class="form-control" style="width: 100%" id="Score" name="score"  value=<%=score %>>
		      </td>
		      <td>
		         <input type="text" class="form-control" style="width: 100%" id="Difficult" name="difficult" value=<%=difficult %>>
		      </td>
		       <td>     
            	<input type="text" class="form-control" style="width: 100%" id="businessadminsid" name="businessadminsid"  value=<%=businessadminsid %> readonly="readonly">
            </td>
 	       </tr>
		  </tbody>
     </table>
       <table class="table table-condensed">
  <thead>
    <tr>
      <th style="text-align: center;"><h2>题目详情</h2></th>
     </tr>
  </thead>
	  <tbody>
	    <tr>
	      <td>
	        <textarea class="form-control" style="height: 300px" name="topic" value=<%=topics %>>     
			<%=topics %>
			</textarea>
	      </td>
	    </tr>
	    <tr>
	      <td>
				  <div class="form-group col-md-3">
				    <label class="col-sm-2 control-label">A:</label>
				    <div class="col-sm-10">
				      <input type="text" class="form-control" id="inputA" name="inputA" value=<%=optionA %>>
				    </div>
				  </div>
				  <div class="form-group col-md-3">
				    <label class="col-sm-2 control-label">B:</label>
				    <div class="col-sm-10">
				      <input type="text" class="form-control" id="inputB" name="inputB" value=<%=optionB %>>
				    </div>
				  </div>
				  <div class="form-group col-md-3">
				    <label class="col-sm-2 control-label" >C:</label>
				    <div class="col-sm-10">
				      <input type="text" class="form-control" id="inputC" name="inputC" value=<%=optionC %>>
				    </div>
				  </div>
				  <div class="form-group col-md-3">
				    <label class="col-sm-2 control-label">D:</label>
				    <div class="col-sm-10">
				      <input type="text" class="form-control" id="inputD" name="inputD" value=<%=optionD %>>
				    </div>
				  </div>
	      </td>
	    </tr>
	    <tr>
	      <td>
	      <div class="col-md-6">答案：
	         <input type="text" class="form-control" style="width: 100%;height: 200px" name="answer" value=<%=answer %>> </div>
	      <div class="col-md-6">解析：
	         <input type="text" class="form-control" style="width: 100%;height: 200px" name="analysiss" value=<%=analysiss %>>  </div>
	      </td>
	      
	    </tr>    
	  </tbody>
     </table>

    </div> 
    <div class="row">
        <div class="col-md-4"></div>
        <div class="col-md-2">
             <button type="submit" class="btn btn-primary" id="sure">确认</button>
        </div>
        <div class="col-md-2">
             <button type="button" class="btn btn-primary" id="cancel">取消</button>
        </div>
        <div class="col-md-4"></div>
    </div>
         </form>
</div>

<%
	}
 %>>
</body>
</html>