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
</head>

<body>
  <br>
  <div class="container_fluid">
    <div class="row">
      <div class="col-md-8">
	      <label>课程:</label>
	      <select name="Course_type_select">
	        <option value="0">--请选择--</option>
	        <option value="computer_net">计算机网络</option>
	        <option value="operation">操作系统</option>
	      </select>
	      <label>章节:</label>
	      <select name="Chapter_type_select">
	         <option value="0">第1章</option>
	         <option value="1">第2章</option>
	         <option value="2">第3章</option>
	      </select>
	      <label>题型:</label>
	      <select name="Type_type_select">
	         <option value="select">选择题</option>
	         <option value="fill">填空题</option>
	         <option value="answer">简答题</option>
	      </select>
      </div>
      <div class="col-md-2">
          <input type="text" class="form-control" id="teaName" placeholder="请输入查询条件" style="width: 100%">
      </div>
      <div class="col-md-2">     
         <button class="btn btn-primary btn-sm" id="searchBtn">查询</button>
      </div>        
   </div> 
   <br>
   
  <!--  显示题目 -->
  <table class="table table-condensed">
  <thead>
    <tr>
      <th>编号</th>
      <th>题目内容</th>
     </tr>
  </thead>
  <tbody>
    <tr>
      <td width="10%">1</td>
      <td width="90%" >
      <a href="details.jsp" style="overflow: hidden;text-overflow: ellipsis;">
                    衬衫的价格是多少亟待解决急急急急急急急急急急急急急急急你们的身份五日加快速度买奶粉
                    是南方么计划任务美女部分然后我，傲慢的反对你们是危机恶化情况美女的角色我看
                    农村的教科文城堡内的金额我看还是被v哦多克
      </a>
      </td>
      </tr>
    <tr>
      <td>2</td>
      <td><a href="details.jsp">李华和小明是朋友</a></td>
      </tr>
    <tr>
      <td>3</td>
      <td><a href="details.jsp">玛丽和小明不是朋友</a></td>
      </tr>
  </tbody>
</table>
</div>

<!-- 分页 -->
<div style="text-align: center;">
<nav class="navbar navbar-default navbar-fixed-bottom" role="navigation" >
<ul class="pagination">
    <li><a href="#">&laquo;</a></li>
    <li><a href="#">1</a></li>
    <li><a href="#">2</a></li>
    <li><a href="#">3</a></li>
    <li><a href="#">4</a></li>
    <li><a href="#">5</a></li>
    <li><a href="#">&raquo;</a></li>
</ul>
</nav>
</div>
</body>
</html>