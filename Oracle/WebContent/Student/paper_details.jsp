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
<body>
<br>
<br>
    <div class="container">
   
   	    <table class="table table-condensed">
		  <thead>
		    <tr>
		      <th><h4>选择题</h4></th>
		     </tr>
		  </thead>
	  	  <tbody>
	  	  <%for(int i=0;i<4;i++) {%>
		    <tr>
		      <td>
		         <div class="form-group col-md-11">
		         <!-- 序号 -->
					<label class="col-sm-1 control-label">1</label>
					<!--  题目 -->
					<div class="col-sm-11">
					 打击恐怖v的
					</div>
				</div>
				<!-- 填入的答案 -->
				<div class="col-md-1">
				<input type="text" class="form-control ">
				</div>
		      </td>
		    </tr>
           <% }%>
	       <tr>
	         <td><h4>填空题</h4></td>
	       </tr>
	       
           <%for(int i=0;i<4;i++) {%>
       	    <tr>
	         <td>
	         <div class="form-group col-md-10">
	         <!-- 序号 -->
				<label class="col-sm-1 control-label">1</label>
				<!--  题目 -->
				<div class="col-sm-11">
				 打击恐怖v的
				</div>
			</div>
			<!-- 填入的答案 -->
			<div class="col-md-2">
			<input type="text" class="form-control ">
			</div>
	      </td>
	    </tr>
       <% }%>
          <tr>
         <td><h4>判断题</h4></td>
       </tr>
        <%for(int i=0;i<4;i++) {%>
       	    <tr>
	      <td>
	         <div class="form-group col-md-11">
	         <!-- 序号 -->
				<label class="col-sm-1 control-label">1</label>
				<!--  题目 -->
				<div class="col-sm-11">
				 打击恐怖v的
				</div>
			</div>
			<!-- 填入的答案 -->
			<div class="col-md-1">
			<input type="text" class="form-control ">
			</div>
	      </td>
	    </tr>   
	    <% }%>
	             <tr>
         <td><h4>计算题</h4></td>
       </tr>
        <%for(int i=0;i<4;i++) {%>
       	    <tr>
	      <td>
	         <div class="form-group col-md-10">
	         <!-- 序号 -->
				<label class="col-sm-1 control-label">1</label>
				<!--  题目 -->
				<div class="col-sm-11">
				 打击恐怖v的
				</div>
			</div>
			<!-- 填入的答案 -->
			<div class="col-md-2">
			<input type="text" class="form-control ">
			</div>
	      </td>
	    </tr>
	    <% }%>   
	     
	    	             <tr>
         <td><h4>简答题</h4></td>
       </tr>
       <%for(int i=0;i<4;i++) {%>
       	    <tr>
	      <td>
	         <div class="form-group">
	         <!-- 序号 -->
				<label class="col-sm-1 control-label">1</label>
				<!--  题目 -->
				<div class="col-sm-11">
				 打击恐怖v的
				</div>
			</div>
			<!-- 填入的答案 -->
			<div class="row">
				        <textarea class="form-control" style="height: 150px">
			      
			</textarea>
			</div>
	      </td>
	    </tr>   
	    <% }%>
	  </tbody>
  </table>
  </div>
</body>
</html>