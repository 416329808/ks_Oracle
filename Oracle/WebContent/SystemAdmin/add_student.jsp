<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
   <script type="text/javascript" src="../js/jquery-1.11.0.js"></script>
	<link rel="stylesheet" href="../css/bootstrap.css">
	<script type="text/javascript" src="../js/bootstrap.js"></script>
	<meta name="viewpoint" content="width=device-width,initial-scale=1">
</head>
<script type="text/javascript">
$(document).ready(function(){ 
	$("#cancel").click(function(){	
		location.href="/Oracle/QueryAllStudentServlet";
		});});
		
$(document).ready(function(){ 
	$("#sure").click(function(){	
		location.href="/Oracle/AddStudentServlet?StudentID="+$("#studentID").val()+
				"&StuentName="+$("#studentName").val()+"&Sex="+$("#Sex").find("option:selected").text()
				+"&institutename="+$("#institutename").find("option:selected").text()
				+"&proname="+$("#proname").find("option:selected").text()
				+"&classname="+$("#classname").find("option:selected").text();
		});});	
</script>

<body>
    <div class="container">
     
     <br>
     <div class="row">
     <table class="table table-bordered">
		  <thead>
		    <tr>
		      <th>学号</th>
		      <th>姓名</th>
		      <th>性别</th>
		      <th>院系</th>
		      <th>专业</th>
		      <th>班级</th>
		    </tr>
		  </thead>
		  <tbody>
		    <tr>
		      <td>
		          <input type="text" class="form-control" style="width: 100%" id="studentID">
		      </td>
		      <td>
		         <input type="text" class="form-control" style="width: 100%" id="studentName">
		      </td>
		      <td>
		         <select class="form-control" style="text-align: center;text-align-last:center;" id="Sex">
		            <option>--请选择--</option>
		            <option>女</option>
		            <option>男</option>
		         </select>
		      </td>
		      <td>
		         <select class="form-control" style="text-align: center;text-align-last:center;" id="institutename">
		            <option>--请选择--</option>
		            <option>计算机与信息工程学院</option>
		            <option>体育学院</option>
		         </select>
		      </td>
		      <td>
		         <select class="form-control" style="text-align: center;text-align-last:center;" id="proname">
		            <option>软件工程</option>
		            <option>计算机科学与技术</option>
		            <option>通信工程</option>
		         </select>
		      </td>
		      <td>
		         <select class="form-control" style="text-align: center;text-align-last:center;" id="classname">
		            <option>软件工程1601班</option>
		            <option>软件工程1602班</option>
		            <option>计算机科学与技术1601班</option>
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