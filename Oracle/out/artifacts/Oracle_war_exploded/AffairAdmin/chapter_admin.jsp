<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>章节管理</title>
 <script type="text/javascript" src="../js/jquery-1.11.0.js"></script>
	<link rel="stylesheet" href="../css/bootstrap.css">
	<script type="text/javascript" src="../js/bootstrap.js"></script>
	<meta name="viewpoint" content="width=device-width,initial-scale=1">
<script type="text/javascript">
$(document).ready(function(){ 
	$("#add").click(function(){	
		location.href="add_chapter.jsp";
		});});
</script>
</head>
<body>
     <br>
   <div class="container">
     <div class="row">
        <div class="col-md-10">
            <select name="chapter_select">
               <option value="0">--请选择--</option>
               <option value="1">操作系统</option>
               <option value="2">计算机组成原理</option>
               <option value="3">计算机网络</option>
            </select>
        </div>
        <div class="col-md-2">
           <button type="button" class="btn btn-primary" style="float: right;" id="add">添加</button>
        </div>
     </div>
     <br>
     <table class="table table-bordered">
		  <thead>
		    <tr>
		      <th>序号</th>
		      <th>章节号</th>
		      <th>章节名</th>
		      <th>所属课程</th>
		      <th>包含题型</th>
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
		      <td><a href="#">删除</a>|<a href="change_chapter.jsp" >修改</a></td>
 	       </tr>
		    <tr>
		      <td></td>
		      <td></td>
		      <td></td>
		      <td></td>
		      <td></td>
		      <td></td>
		      <td><a href="#">删除</a>|<a href="change_chapter.jsp" >修改</a></td>
		    </tr>
		    <tr>
		      <td></td>
		      <td></td>
		      <td></td>
		      <td></td>
		      <td></td>
		      <td></td>
		      <td><a href="#">删除</a>|<a href="change_chapter.jsp" >修改</a></td>
		    </tr>
		  </tbody>
     </table>
  </div> 

</body>
</html>