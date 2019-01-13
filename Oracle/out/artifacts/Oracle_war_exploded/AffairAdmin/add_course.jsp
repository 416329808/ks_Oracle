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
		location.href="course_admin.jsp";
		});});
</script>

<body>
    <div class="container">
     
     <br>
     <div class="row">
     <table class="table table-bordered">
		  <thead>
		    <tr>
		      <th>课程号</th>
		      <th>课程名</th>
		      <th>所属院系</th>
		    </tr>
		  </thead>
		  <tbody>
		    <tr>
		      <td>
		          <input type="text" class="form-control" style="width: 100%">
		      </td>
		      <td>
		         <input type="text" class="form-control" style="width: 100%">
		      </td>
		      <td>
		         <select>
		            <option>--请选择--</option>
		            <option>计算机与信息工程学院</option>
		            <option>体育学院</option>
		         </select>
		      </td>
 	       </tr>
		    <tr>
		      <td></td>
		      <td></td>
		      <td></td>
		    </tr>
		    <tr>
		      <td></td>
		      <td></td>
		      <td></td>
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