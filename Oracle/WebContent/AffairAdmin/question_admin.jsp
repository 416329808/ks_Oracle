<%@page import="javax.crypto.interfaces.PBEKey"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="com.oracle.daomain.Questions"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="js/jquery-1.11.0.js"></script>
<link rel="stylesheet" href="css/bootstrap.css">
<script type="text/javascript" src="js/bootstrap.js"></script>
<meta name="viewpoint" content="width=device-width,initial-scale=1">
<style>
table {
	table-layout: fixed;
}

td {
	overflow: hidden;
	text-overflow: ellipsis;
	white-space: nowrap;
}
</style>
<script type="text/javascript">
	
function Update_sure(){
    var gnl=confirm("确定修改该课程信息?");
    if (gnl==true){
      return true;
    }else{
       return false;
   }
 };
 
 function Delete_sure(){
     var gnl=confirm("确定删除该课程信息?");
     if (gnl==true){
       return true;
     }else{
        return false;
    }
  };
  
  function getBranchByBrandName() {
	var operTypeSelect = document.getElementById("operTypeSelect");
	var operTypeValue = operTypeSelect.value;
	var brandId = operTypeValue;
	$("#brandId").val(brandId);
	$("#modelsId").empty();
	$.ajax({
		mode:"abort",
		contentType:"application/x-www-form-urlencoded;charset=UTF-8",
		data:{"brandId":brandId},
		type:"POST",
		url:"/Oracle/CourseChapterQuestionServlet?style=chapter",
		cache:false,
		async:false,
		processData:true,
		dataType:"json",
		success:function(courselist) {
			//alert("''");
			var majorList=courselist;//将json字符串转换为json对象
			if (majorList != null && majorList.length > 0) {
				var str = "<option value=''> " + "请选择" + "</option>;";
					$.each(majorList, function(i, item) {
					if (item != "") {
						str = str + "<option value="+item.chapterID+"> " + item.chapterName + "</option>;";
						$("#operSelect").html(str);
					} else {
						<!--$("#operSelect").html("<option id = oper value=''>请选择</option>");-->
					}
				});
			} else {
				<!--$("#operSelect").html("<option id = oper>请选择</option>");-->
			}
			$("#operSelect").select();
			$("#modelsId").html("<option value=''>请选择</option>");
			$("#modelsId").select();
		}
	});
}
function getModelByBranchName() {
	var brandId = $("#operTypeSelect").val();
	var branchId = $("#operSelect").val();
	$("#bannerId").val(branchId);
	$.ajax({
		mode:"abort",
		contentType:"application/x-www-form-urlencoded;charset=UTF-8",
		data:{"brandId":brandId,"branchId":branchId},
		type:"POST",
		url:"/Oracle/CourseChapterQuestionServlet?style=questionstyle",
		cache:false,
		async:true,
		processData:true,
		dataType:"json",
		success:function(tCdCarModelList) {
			var majorList=tCdCarModelList;
			if (majorList != null && majorList.length > 0) {
				var str = "<option value=''> " + "请选择" + "</option>;";
				$.each(majorList, function(i, item) {
					if (item != "") {
						str = str + "<option value="+item.questionTypePronoun+"> " + item.meaning + "</option>;";
						$("#modelsId").html(str);
					} else {
						$("#modelsId").html("<option value=''>请选择</option>");
					}
				});
			} else {
				<!--$("#operSelect").html("<option value=''>请选择</option>");-->
			}
			$("#modelsId").select();
		}
	});
}
function selectall(){
	var brandId = $("#operTypeSelect").val();
	var branchId = $("#operSelect").val();
	var questiontype= $("#modelsId").val();
	location.href= "/Oracle/QuestionsinfoServlet?pageNum=1&Style=change&courseId="+brandId+"&chapterId="+branchId+"&questiontype="+questiontype+"";
};
</script>
</head>
<body>
	<div class="container">
		<div class="row">
		
			<div class="col-md-2">
			
				课程：			
				<select id="operTypeSelect" path="bannerId"
					 onchange="getBranchByBrandName()" style="width:100px;">
					<option selected="selected" value="0">请选择</option>
					<c:forEach items="${tCdCarBrandList}" var="item" varStatus="status">
						<option value="${item.courseID }">${item.courseID }</option>
					</c:forEach>
				</select>
				
				</div>
				
				<div class="col-md-2">
				 章节：<select id="operSelect" name="branchId" 
					onClick="getModelByBranchName()" style="width:100px;">
					<option selected="selected" value="">请选择</option>
					<c:forEach items="${courselist}" var="item" varStatus="status">
						
					</c:forEach>
				</select> 
				</div>
				
				<div class="col-md-2">
				 题型：<select id="modelsId" name="modelId" 
					 onchange="selectall()" style="width:100px;">
					<option selected="selected" value="0">请选择</option>
					<c:forEach items="${tCdCarModelList}" var="item" varStatus="status">
					
					</c:forEach>
				</select>
			</div>
			<!-- <div class="col-md-2">
				<input type="text" class="form-control" id="teaName"
					placeholder="请输入查询条件" style="width: 100%">
			</div>
			<div class="col-md-1">
				<button type="button" class="btn btn-primary" id="searchBtn">查询</button>
			</div> -->

			<div class="col-md-1">
				<button type="button" class="btn btn-primary" style="float: right;"
					id="add" onclick="location.href='AffairAdmin/add_question.jsp'">添加</button>
			</div>
			
			
			
				<div class="col-md-1">
					<button class="btn btn-primary" id="cBtn"
						onclick="location.href='/Oracle/QuestionsinfoServlet?choice=choice&pageNum=1'">选择题</button>
				</div>
			
				<div class="col-md-1">
					<button class="btn btn-primary" id="oBtn"
						onclick="location.href='/Oracle/QuestionsinfoServlet?pageNum=1'">others</button>
				</div>
			
			<br /> <br /> <br />
			<table class="table table-bordered">
				<thead>
					<tr>
						<th>序号</th>
						<th>题目号</th>
						<th>题目内容</th>
						<th>分数</th>
						<th>难度</th>
						<th>题目类型</th>
						<th>抽取次数</th>
						<th>所属章节</th>
						<th>所属课程</th>
						<th>录入员工号</th>
						<th>录入日期</th>
						<th>操作</th>
					</tr>
				</thead>
				<tbody>
					<c:set var="a" value="${(pb.pageNum-1)*10+1}"></c:set>
					<c:forEach var="questionslist" items="${pb.getList()}">
						<tr>
							<td>${a}</td>
							<td>${questionslist.getQuestionsID()}</td>
							<td><a
								href="/Oracle/QuestionsinfoServlet?Style=${questionslist.getStyle()}&questionID=${questionslist.getQuestionsID()}">${questionslist.getTopics()}</a></td>
							<td>${questionslist.getScore()}</td>
							<td>${questionslist.getDifficult()}</td>
							<td>${questionslist.getStyle()}</td>
							<td>${questionslist.getExtractNum()}</td>
							<td>${questionslist.getChapterName()}</td>
							<td>${questionslist.getCourseName()}</td>
							<td>${questionslist.getReporterID()}</td>
							<td>${questionslist.getCreationDate()}</td>
							<c:set var="a" value="${a+1}"></c:set>
							<td><a
								href="/Oracle/QuestionsDeleteServlet?ID=${questionslist.getQuestionsID()}&style=${questionslist.getStyle()}"
								onclick="return Delete_sure()">删除</a>| <a
								href="/Oracle/QuestionsUpdateServlet?opertion=read&ID=${questionslist.getQuestionsID()}&style=${questionslist.getStyle()}&course_select=${questionslist.getCourseID()}&chapter_select=${questionslist.getChapterID()}"
								onclick="return Update_sure()">修改</a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>

			<%-- 构建分页导航 --%>
			<div align="center">
				<ul class="pagination">
					<h4>共有${pb.totalRecord}个问题，共${pb.totalPage }页，当前为${pb.pageNum}页</h4>
					<li><a href="/Oracle/QuestionsinfoServlet?pageNum=1">首页</a></li>
					<%--如果当前页为第一页时，就没有上一页这个超链接显示 --%>
					<c:if test="${pb.pageNum ==1}">
						<c:forEach begin="${pb.start}" end="${pb.end}" step="1" var="i">
							<c:if test="${pb.pageNum == i}">
								<li><a href="#">${i}</a></li>
							</c:if>
							<c:if test="${pb.pageNum != i}">
								<li><a href="/Oracle/QuestionsinfoServlet?pageNum=${i}">${i}</a></li>
							</c:if>
						</c:forEach>
						<li><a
							href="/Oracle/QuestionsinfoServlet?pageNum=${pb.pageNum+1}">下一页</a></li>
					</c:if>

					<%--如果当前页不是第一页也不是最后一页，则有上一页和下一页这个超链接显示 --%>
					<c:if test="${pb.pageNum > 1 && pb.pageNum < pb.totalPage}">
						<li><a
							href="/Oracle/QuestionsinfoServlet?pageNum=${pb.pageNum-1}">上一页</a></li>
						<c:forEach begin="${pb.start}" end="${pb.end}" step="1" var="i">
							<c:if test="${pb.pageNum == i}">
								<li><a href="#">${i}</a></li>
							</c:if>
							<c:if test="${pb.pageNum != i}">
								<li><a href="/Oracle/QuestionsinfoServlet?pageNum=${i}">${i}</a>
								</li>
							</c:if>
						</c:forEach>
						<li><a
							href="/Oracle/QuestionsinfoServlet?pageNum=${pb.pageNum+1}">下一页</a>
						</li>
					</c:if>

					<%-- 如果当前页是最后一页，则只有上一页这个超链接显示，下一页没有 --%>
					<c:if test="${pb.pageNum == pb.totalPage}">
						<li><a
							href="/Oracle/QuestionsinfoServlet?pageNum=${pb.pageNum-1}">上一页</a></li>
						<c:forEach begin="${pb.start}" end="${pb.end}" step="1" var="i">
							<c:if test="${pb.pageNum == i}">
								<li><a href="#">${i}</a></li>
							</c:if>
							<c:if test="${pb.pageNum != i}">
								<li><a href="/Oracle/QuestionsinfoServlet?pageNum=${i}">${i}</a></li>
							</c:if>
						</c:forEach>
					</c:if>
					<%--尾页 --%>
					<li><a
						href="/Oracle/QuestionsinfoServlet?pageNum=${pb.totalPage}">尾页</a></li>
				</ul>
			</div>

		</div>
</body>
</html>