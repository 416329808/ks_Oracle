<%@page import="com.oracle.daomain.student"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
    <script type="text/javascript" src="js/jquery-1.11.0.js"></script>
	<link rel="stylesheet" href="../css/bootstrap.css">
	<script type="text/javascript" src="js/bootstrap.js"></script>
	<meta name="viewpoint" content="width=device-width,initial-scale=1">
</head>
<body>
    <div class="container-fluid">
      <div class="row" style="text-align: center;font-size: 40px">题目</div>
      <br>
      <br>
      <div class="row" >
         <div class="col-md-2"> </div>
         <div class="col-md-8" style="text-align: center">
            <form class="form-horizontal" role="form">
	           <div class="form-group">
		         <label for="no" class="col-md-2 control-label">题目:</label>
		         <div class="col-md-8">
		         <%
String QuestionTopics=(String)request.getParameter("QuestionTopics");
String QuestionAnswer=(String)request.getParameter("QuestionAnswer");
String QuestionAnaly=(String)request.getParameter("QuestionAnaly");
%>
			     <input type="text" class="form-control" id="no" style="border-style: none"  value=<%=QuestionTopics%> readonly>
		       </div>
	           </div>
	           <br>
           <div class="form-group">
		   <label for="lastname" class="col-md-2 control-label">答案:</label>
		     <div class="col-md-8">
			 <input type="text" class="form-control" id="lastname" style="border-style: none" value=<%= QuestionAnswer%> readonly>
		     </div>
	     </div>
	     </br>
	                <div class="form-group">
		   <label for="lastname" class="col-md-2 control-label">解析:</label>
		     <div class="col-md-8">
			 <input type="text" class="form-control" id="lastname" style="border-style: none" value=<%= QuestionAnaly%> readonly>
		     </div>
	     </div>
       </form>
       </div>
      
      </div>
   </div>
</body>
</html>