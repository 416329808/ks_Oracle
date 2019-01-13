<%@page import="com.oracle.daomain.QuestionsStylePronoun"%>
<%@page import="java.util.List"%>
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
	$("#add").click(function(){	
		location.href="AffairAdmin/add_question_type.jsp";
		});});
		
function Update_sure(){
	var s=confirm("确定要修改该题型信息吗？");
	if(s==true) return true;
	else return false;
};
function Delete_sure(){
	var s=confirm("确定要修改该题型信息吗？");
	if(s==true) return true;
	else return false;
};
</script>
</head>
<body>
     <br>
   <div class="container">
     <div class="row">
        <div class="col-md-2">
            <!-- <select class="form-control" name="course_select" style="text-align: center;text-align-last:center;">
               <option value="0">--请选择--</option>
               <option value="1">操作系统</option>
               <option value="2">计算机组成原理</option>
               <option value="3">计算机网络</option>
            </select> -->
        </div>
        <div class="col-md-8"></div>
        <div class="col-md-2">
           <button type="button" class="btn btn-primary" style="float: right;" id="add">添加</button>
        </div>
     </div>
     <br>
     <table class="table table-bordered">
		  <thead>
		    <tr>
		      <th style="text-align: center;">序号</th>
		      <th style="text-align: center;">题型号</th>
		      <th style="text-align: center;">题型名</th>
		      <th style="text-align: center;">题目数</th>
		      <th style="text-align: center;">操作</th>
		    </tr>
		  </thead>
		  <tbody>
		  <%
		  /*  String flag=(String)request.getAttribute("flag");
		  if(flag!=null){
			  //删除成功与否的提示信息
			  if("yes".equals(flag)){} 
			  else if("no".equals(flag)) {} 
		  }  */
		  List<QuestionsStylePronoun> questionTypes=(List<QuestionsStylePronoun>)request.getAttribute("questionTypes");
		  int i=1;
		  for(QuestionsStylePronoun questionType:questionTypes){%>
		    <tr>
		      <td style="text-align: center;"><%=i %></td>
		      <td style="text-align: center;"><%=questionType.getPronoun() %></td>
		      <td style="text-align: center;"><%=questionType.getMeaning() %></td>
		      <td style="text-align: center;"><%=questionType.getQuestionsNum() %></td>
		      <td style="text-align: center;"><a href="DeleteQuestionTypeServlet?Pronoun=<%=questionType.getPronoun() %>"onclick="return Delete_sure()">删除</a>|<a href="QueryQuestionTypeByPronounServlet?Pronoun=<%=questionType.getPronoun() %>" onclick="return Update_sure()">修改</a></td>
 	       </tr>
 	       <%i++;
 	       } %>
		  </tbody>
     </table>
  </div> 


</body>
</html>