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
	<style>
table{
    table-layout:fixed;
}
td{  
    overflow:hidden;
    text-overflow:ellipsis;
    white-space:nowrap;
}
</style>
<script type="text/javascript">
$(document).ready(function(){ 
	$("#add").click(function(){	
		location.href="add_question.jsp";
		});});
</script>
</head>
<body>
     <br>
   <div class="container">
     <div class="row">
        <div class="col-md-6">
            课程：
            <select name="course_select">
               <option value="1">--请选择--</option>
               <option value="11">操作系统</option>
               <option value="12">计算机组成原理</option>
               <option value="13">计算机网络</option>
            </select>
            章节：
            <select name="chapter_select">
               <option value="2">--请选择--</option>
               <option value="21">第一章</option>
               <option value="22">第二章</option>
               <option value="23">第三章</option>
            </select>
            题型：
            <select name="question_type_select">
               <option value="3">--请选择--</option>
               <option value="31">选择题</option>
               <option value="32">填空题</option>
               <option value="33">简答题</option>
            </select>
        </div>
        <div class="col-md-2">
            <input type="text" class="form-control" id="teaName" placeholder="请输入查询条件" style="width: 100%">
      </div>
      <div class="col-md-2">     
            <button class="btn btn-primary btn-sm" id="searchBtn">查询</button>
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
		      <th>题目号</th>
		      <th>题目内容</th>
		      <th>所属课程</th>
		      <th>所属章节</th>
		      <th>所属题型</th>
		      <th>分数</th>
		      <th>难度</th>
		      <th>录入日期</th>
		      <th>操作</th>
		    </tr>
		  </thead>
		  <tbody>
		    <tr>
		      <td></td>
		      <td></td>
		      <td><a href="details.jsp">衬衫的价格</a></td>
		      <td></td>
		      <td></td>
		      <td></td>
		      <td></td>
		      <td></td>
		      <td></td>
		      <td><a href="#">删除</a>|<a href="change_question.jsp" >修改</a></td>
 	       </tr>
		    <tr>
		      <td></td>
		      <td></td>
		      <td></td>
		      <td></td>
		      <td></td>
		      <td></td>
		      <td></td>
		      <td></td>
		      <td></td>
		      <td><a href="#">删除</a>|<a href="change_question.jsp" >修改</a></td>
		    </tr>
		    <tr>
		      <td></td>
		      <td></td>
		      <td></td>
		      <td></td>
		      <td></td>
		      <td></td>
		      <td></td>
		      <td></td>
		      <td></td>
		      <td><a href="#">删除</a>|<a href="change_question.jsp" >修改</a></td>
		    </tr>
		  </tbody>
     </table>
  </div> 


</body>
</html>