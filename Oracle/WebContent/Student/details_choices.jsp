<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="com.oracle.daomain.Questions"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
   <script type="text/javascript" src="js/jquery-1.11.0.js"></script>
	<link rel="stylesheet" href="css/bootstrap.css">
	<script type="text/javascript" src="js/bootstrap.js"></script>
	<meta name="viewpoint" content="width=device-width,initial-scale=1">
</head>
<body>
	<%
		Questions questions2 = (Questions) request.getAttribute("questions2");
		if (questions2 != null) {
			String topics = questions2.getTopics();//章节号
			String answer = questions2.getAnswer();//章节名
			String analysiss =questions2.getAnalysiss();//课程编号
			String optionA = questions2.getOptionA();
			String optionB = questions2.getOptionB();
			String optionC = questions2.getOptionC();
			String optionD = questions2.getOptionD();

	%>
<div class="container">
<div class="row">
  <table class="table table-condensed">
  <thead>
    <tr>
      <th style="text-align: center;"><h2>题目详情</h2></th>
     </tr>
  </thead>
	  <tbody>
	    <tr>
	      <td>
	        <textarea class="form-control" style="height: 300px" readonly="readonly">
			      <%=topics%>
			</textarea>
	      </td>
	    </tr>
	    <tr>
	      <td>
			 <form class="form-horizontal" role="form">
				  <div class="form-group col-md-3">
				    <label class="col-sm-2 control-label">A.</label>
				    <div class="col-sm-10">
				      <input type="text" class="form-control" id="inputA" value=<%=optionA%> readonly="readonly">
				    </div>
				  </div>
				  <div class="form-group col-md-3">
				    <label class="col-sm-2 control-label">B.</label>
				    <div class="col-sm-10">
				      <input type="text" class="form-control" id="inputB" value=<%=optionB%> readonly="readonly">
				    </div>
				  </div>
				  <div class="form-group col-md-3">
				    <label class="col-sm-2 control-label">C.</label>
				    <div class="col-sm-10">
				      <input type="text" class="form-control" id="inputC" value=<%=optionC%> readonly="readonly">
				    </div>
				  </div>
				  <div class="form-group col-md-3">
				    <label class="col-sm-2 control-label">D.</label>
				    <div class="col-sm-10">
				      <input type="text" class="form-control" id="inputD" value=<%=optionD%> readonly="readonly">
				    </div>
				  </div>
				</form>
	      </td>
	    </tr>
	    <tr>
	      <td>
	      <div class="col-md-6">答案：
	         <input type="text" class="form-control" style="width: 100%;height: 200px" readonly="readonly" value=<%=answer%> ></div>
	      <div class="col-md-6">解析：
	         <input type="text" class="form-control" style="width: 100%;height: 200px" readonly="readonly" value=<%=analysiss%>></div>
	      </td>
	      
	    </tr>    
	  </tbody>
  </table>
  	</div>
  	<div class="row">
        <div class="col-md-4"></div>
        <div class="col-md-2">
             <button type="button" class="btn btn-primary" id="sure">确认</button>
        </div>
        <div class="col-md-2">
             <button type="button" class="btn btn-primary" id="cancel">取消</button>
        </div>
        <div class="col-md-4"></div>
    </div>
</div>
<%
	}
 %>
</body>
</html>