<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加章节</title>
    <script type="text/javascript" src="../js/jquery-1.11.0.js"></script>
	<link rel="stylesheet" href="../css/bootstrap.css">
	<script type="text/javascript" src="../js/bootstrap.js"></script>
	<meta name="viewpoint" content="width=device-width,initial-scale=1">
</head>
<script type="text/javascript">
$(document).ready(function(){ 
	$("#cancel").click(function(){	
		location.href="/Oracle/ChapterinfoServlet";
		});});
</script>

<body>
    <div class="container">
     
     <br>
     <div class="row">
     <form id="form" name="form" class="form-horizontal"
					action="/Oracle/ChapterAddServlet" method="post">
     <table class="table table-bordered">
		  <thead>
		    <tr>
		      <th>章节号</th>
		      <th>章节名</th>
		      <th>所属课程号</th>
		      <th>包含题型</th>
		    </tr>
		  </thead>
		  <tbody>
		    <tr>
		      <td>
		         <input type="text" class="form-control" name="ChapterID" style="width: 100%">
		      </td>
		      <td>
		        <input type="text" class="form-control" name="ChapterName" style="width: 100%">
		      </td>
		      <td>
		         <select name="courseselect">
               <option value="0">--请选择--</option>
               <option value="1104201509">操作系统</option>
               <option value="1104201506">计算机组成原理</option>
               <option value="1104201507">计算机网络</option>
               <option value="1104201508">数据结构</option>
            </select>
		      </td>
		      <td>
		      	 <input type="checkbox" value="1" name="boxes">选择题<br>
		         <input type="checkbox" value="3" name="boxes">填空题<br>
		         <input type="checkbox" value="5" name="boxes">计算题<br>
		         <input type="checkbox" value="4" name="boxes">简答题<br>
		         <input type="checkbox" value="2" name="boxes">判断题<br>
		         </td>
 	       </tr>

		  </tbody>
		
     </table>
         <div class="row">
        <div class="col-md-4"></div>
        <div class="col-md-2">
             <input type="submit" class="btn btn-primary" id="sure" name="sure" value="确认">
        </div>
        <div class="col-md-2">
             <button type="button" class="btn btn-primary" id="cancel">取消</button>
        </div>
        <div class="col-md-4"></div>
    </div>
       </form>
       
    </div> 

</div>
</body>
</html>