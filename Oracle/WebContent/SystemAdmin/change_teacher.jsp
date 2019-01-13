<%@page import="com.oracle.daomain.Teacher"%>
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
</head>
<script type="text/javascript">
$(document).ready(function(){ 
	$("#cancel").click(function(){	
		location.href="QueryAllTeacherServlet";
		});});
		
$(document).ready(function(){ 
	$("#sure").click(function(){	
		location.href="/Oracle/UpdateTeacherServlet?TeacherID="+$("#TeacherID").val()+
				"&TeacherName="+$("#TeacherName").val()+"&Sex="+$("#Sex").find("option:selected").text()
				+"&BelongsInstituteName="+$("#BelongsInstituteName").find("option:selected").text();
		});});
		
		
		
		
</script>

<body>
    <div class="container">    
     <br>
     <div class="row">
     <table class="table table-bordered">
		  <thead>
		    <tr>
		      <th style="text-align: center;">工号</th>
		      <th style="text-align: center;">姓名</th>
		      <th style="text-align: center;">性别</th>
		      <th style="text-align: center;">所属院系名</th>
		    </tr>
		  </thead>
		  <%Teacher teacher=(Teacher)request.getAttribute("teacher"); %>
		  <tbody>
		    <tr>
		      <td>
		          <input type="text" class="form-control" style="width: 100%;text-align: center;" value="<%=teacher.getTeacherID()%>" id="TeacherID" readonly="readonly">
               </td>
		      <td>
		         <input type="text" class="form-control" style="width: 100%;text-align: center;" value="<%=teacher.getTeacherName()%>" id="TeacherName">
		      </td>
		      <td>
		         <select class="form-control" style="text-align: center;text-align-last:center;" id="Sex">
		            <option>--请选择--</option>
		            <option style="text-align: center;">女</option>
		            <option style="text-align: center;">男</option>
		         </select>
		      </td>
		      <td>
		         <select class="form-control" style="text-align: center;text-align-last:center;" id="BelongsInstituteName">
		            <option>--请选择--</option>
		            <option>计算机与信息工程学院</option>
		            <option>体育学院</option>
		         </select>
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

</body>
</html>