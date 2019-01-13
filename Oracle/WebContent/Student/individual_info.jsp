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
<body>
    <div class="container-fluid">
      <div class="row" style="text-align: center;font-size: 40px">我的信息</div>
      <br>
      <br>
      <div class="row" >
         <div class="col-md-2"> </div>
         <div class="col-md-8" style="text-align: center">
            <form class="form-horizontal" role="form">
	           <div class="form-group">
		         <label for="no" class="col-md-2 control-label">学号:</label>
		         <div class="col-md-8">
			     <input type="text" class="form-control" id="no" style="border-style: none"  value="${ student.studentID}" readonly>
		       </div>
	           </div>
	           <br>
            <div class="form-group">
		   <label for="lastname" class="col-md-2 control-label">姓名:</label>
		     <div class="col-md-8">
			 <input type="text" class="form-control" id="lastname" style="border-style: none" value="${ student.studentName}" readonly>
		     </div>
	     </div>
	     <br>
	     <div class="form-group">
		     <label for="yuan" class="col-md-2 control-label">性别:</label>
		     <div class="col-md-8">
			 <input type="text" class="form-control" id="yuan" style="border-style: none" value="${ student.sex}" readonly>
		     </div>
	     </div> 
    
	<div class="form-group">      
         <a href="AffairAdmin/change_password.jsp?ID=${ student.studentID}" class="btn btn-link"><font color="red" size="5px">修改密码</font></a>
       
      </div>
	     <br>
       </form>
       </div>

    </div>
    </div>
</body>
</html>