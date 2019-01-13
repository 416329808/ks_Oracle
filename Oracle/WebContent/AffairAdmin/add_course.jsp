<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加课程</title>
    <script type="text/javascript" src="../js/jquery-1.11.0.js"></script>
	<link rel="stylesheet" href="../css/bootstrap.css">
	<script type="text/javascript" src="../js/bootstrap.js"></script>
	<meta name="viewpoint" content="width=device-width,initial-scale=1">
</head>
<script type="text/javascript">
$(document).ready(function(){ 
	$("#cancel").click(function(){	
		location.href="../QueryAllCourseServlet";
		});});
</script>

<body>
<form action="/Oracle/AddCourseServlet" method="post">
    <div class="container">
     
     <br>
     <div class="row">
     <table class="table table-bordered">
		  <thead>
		    <tr>
		      <th style="text-align: center;">课程号</th>
		      <th style="text-align: center;">课程名</th>
		      <!-- <th style="text-align: center;">所属院系号</th> -->
		      <th style="text-align: center;">所属院系名</th>
		    </tr>
		  </thead>
		  <tbody>
		    <tr>
		      <td>
		          <input type="text" class="form-control" style="width: 100%;text-align: center;" name="CourseID">
		      </td>
		      <td>
		         <input type="text" class="form-control" style="width: 100%;text-align: center;" name="CourseName">
		      </td>
		      <!-- <td>
		         <select class="form-control" style="text-align: center;text-align-last:center;">
		            <option>--请选择--</option>
		            <option>100</option>
		            <option>101</option>
		            <option>102</option>
		            <option>103</option>
		            <option>104</option>
		            <option>105</option>
		            <option>106</option>
		         </select>
		      </td> -->
		      <td>
		         <select class="form-control"  style="text-align: center;text-align-last:center;"  id="BelongsInstituteName" name="BelongsInstituteName">
		            <option>--请选择--</option>
		            <option>生命科学学院</option>
		            <option>商学院</option>
		            <option>政法与公共管理学院</option>
		            <option>文学院</option>
		            <option>体育学院</option>
		            <option>教育学院</option>
		            <option>历史文化学院</option>
		         </select>
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
</div>
</form>
</body>
</html>