<%@page import="com.oracle.daomain.Course"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>管理员课程管理页面</title>
    <script type="text/javascript" src="js/jquery-1.11.0.js"></script>
	<link rel="stylesheet" href="css/bootstrap.css">
	<script type="text/javascript" src="js/bootstrap.js"></script>
	<meta name="viewpoint" content="width=device-width,initial-scale=1">
<script type="text/javascript">
$(document).ready(function(){ 
	$("#add").click(function(){	
		location.href="AffairAdmin/add_course.jsp";
		});});
		
function Update_sure(){
    var gnl=confirm("确定修改该课程信息?");
    if (gnl==true){
      return true;
    }else{
       return false;
   }
 };
 
 function Delete_sure(){
     var gnl=confirm("确定删除该课程信息?");
     if (gnl==true){
       return true;
     }else{
        return false;
    }
  };
</script>
</head>
<body>
   <br>
   <div class="container">
     <div class="row">
        <div class="col-md-10"></div>
        <div class="col-md-2">
           <button type="button" class="btn btn-primary" style="float: right;" id="add">添加</button>
        </div>
     </div>
     <br>
     <table class="table table-bordered">
		  <thead>
		    <tr>
		      <th style="text-align: center;">序号</th>
		      <th style="text-align: center;">课程号</th>
		      <th style="text-align: center;">课程名</th>
		      <th style="text-align: center;">所属院系</th>
		      <th style="text-align: center;">章节数</th>
		      <th style="text-align: center;">题目数</th>
		      <th style="text-align: center;">操作</th>
		    </tr>
		  </thead>
		  <tbody>
		   <%List<Course> courses=(List<Course>)request.getAttribute("courses");
		   int i=1;
		      for(Course c:courses){
		    %>
		    <tr>
		      <td style="text-align: center;"><%=i %></td>
		      <td style="text-align: center;"><%=c.getCourseID() %></td>
		      <td style="text-align: center;"><%=c.getCourseName() %></td>
		      <td style="text-align: center;"><%=c.getBelongsInstituteName() %></td>
		      <td style="text-align: center;"><%=c.getChapterNum() %></td>
		      <td style="text-align: center;"><%=c.getTotalProblemNumber() %></td>
		      <td style="text-align: center;"><a href="DeleteCourseServlet?CourseID=<%=c.getCourseID() %>" onclick="return Delete_sure()">删除</a>|<a href="QueryCourseByIdServlet?CourseID=<%=c.getCourseID() %>" onclick="return Update_sure()">修改</a></td>
 	       </tr>
 	       <%i++;
 	       } %>
		  </tbody>
     </table>
  </div> 

</body>
</html>