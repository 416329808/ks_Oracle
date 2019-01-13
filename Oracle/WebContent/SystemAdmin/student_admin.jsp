<%@page import="com.oracle.daomain.student"%>
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
/*  $(document).ready(function(){ 
	$("#add").click(function(){	
		location.href="add_teacher.jsp";
		});});  */
		
 
 function Add(){
		window.location.href="SystemAdmin/add_student.jsp";
	}
			
function delete_sure(){
	var flag=confirm("确认删除该学生信息吗？");
	if(flag) return true;
	else return false;
};

function update_sure(){
	var flag=confirm("确认修改该学生信息吗？");
	if(flag) return true;
	else return false;
};
</script>
</head>
<body>
    <br>
   <div class="container">
     <div class="row">
     
     
     <form action="/Oracle/QueryStudentBytextServlet" method="post">
        <div class="col-md-2">
            <input type="text" class="form-control" id="searhText" name="searhText"  placeholder="请输入查询条件" style="width: 100%">
      </div>
      <div class="col-md-2">     
            <button type="submit" class="btn btn-primary btn-sm" id="searchBtn" >查询</button>
      </div> 
      </form>
      
      <div class="col-md-6"></div>    
        <div class="col-md-2">
           <input type="button" class="btn btn-primary" style="float: right;" value="添加"  onclick="Add()" >
        </div>
     </div>
     <br>
     <table class="table table-bordered">
		  <thead>
		    <tr>
		      <th style="text-align: center;">序号</th>
		      <th style="text-align: center;">学号</th>
		      <th style="text-align: center;">姓名</th>
		      <th style="text-align: center;">班级</th>
		      <th style="text-align: center;">性别</th>
		      <th style="text-align: center;">专业</th>
		      <th style="text-align: center;">学院</th>
		      <th style="text-align: center;">操作</th>
		    </tr>
		  </thead>
		  <tbody>
		     <%List<student> students=(List<student>)request.getAttribute("students");
		  int i=1;
		  if(students!=null){
		  for(student t:students){
		  %>
		    <tr>
		      <td style="text-align: center;"><%=i %></td>
		      <td style="text-align: center;"><%=t.getStudentID() %></td>
		      <td style="text-align: center;"><%=t.getStudentName()%></td>
		      <td style="text-align: center;"><%=t.getClassesName() %></td>
		      <td style="text-align: center;"><%=t.getSex() %></td>
		      <td style="text-align: center;"><%=t.getProfessionName() %></td>
		      <td style="text-align: center;"><%=t.getInstituteName() %></td>
		      <td style="text-align: center;"><a href="DeleteStudentServlet?StudentID=<%=t.getStudentID()%>" onclick="return delete_sure()">删除</a>|<a href="QueryStudentByIdServlet?StudentID=<%=t.getStudentID()%>" onclick="return update_sure()">修改</a></td>
 	       </tr>
 	       <%i++;} 
 	       }%>
     </table>
  </div> 


</body>
</html>