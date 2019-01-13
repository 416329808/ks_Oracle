<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>管理员课程管理页面</title>
    <script type="text/javascript" src="../js/jquery-1.11.0.js"></script>
	<link rel="stylesheet" href="../css/bootstrap.css">
	<script type="text/javascript" src="../js/bootstrap.js"></script>
	<meta name="viewpoint" content="width=device-width,initial-scale=1">
<script type="text/javascript">
$(document).ready(function(){ 
	$("#add").click(function(){	
		location.href="add_course.jsp";
		});});
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
		      <th>序号</th>
		      <th>课程号</th>
		      <th>课程名</th>
		      <th>所属院系</th>
		      <th>章节数</th>
		      <th>题目数</th>
		      <th>操作</th>
		    </tr>
		  </thead>
		  <tbody>
		    <tr>
		      <td></td>
		      <td></td>
		      <td></td>
		      <td></td>
		      <td></td>
		      <td></td>
		      <td><a href="#">删除</a>|<a href="change_course.jsp" >修改</a></td>
 	       </tr>
		    <tr>
		      <td></td>
		      <td></td>
		      <td></td>
		      <td></td>
		      <td></td>
		      <td></td>
		      <td><a href="#">删除</a>|<a href="change_course.jsp" >修改</a></td>
		    </tr>
		    <tr>
		      <td></td>
		      <td></td>
		      <td></td>
		      <td></td>
		      <td></td>
		      <td></td>
		      <td><a href="#">删除</a>|<a href="change_course.jsp" >修改</a></td>
		    </tr>
		  </tbody>
     </table>
  </div> 

</body>
</html>