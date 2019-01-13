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
<script type="text/javascript">
$(document).ready(function(){ 
	$("#cancel").click(function(){	
		location.href="/Oracle/QuestionsinfoServlet?pageNum=1";
		});});
</script>
<body>
	<div class="container">
			<form id="form" name="form" class="form-horizontal"
				action="/Oracle/QuestionsAddServlet" method="post">
		<br>
		<div class="row">

				<table class="table table-bordered">
					<thead>
						<tr>
							<th>所属课程号</th>
							<th>所属章节号</th>
							<th>类型</th>
							<th>分数</th>
							<th>难度</th>
							<th>录入员工号</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td><select name="course_select">
									<option value="1">--请选择--</option>
									<option value="1104201506">1104201506</option>
									<option value="1104201507">1104201507</option>
									<option value="1104201508">1104201508</option>
									<option value="1104201509">1104201509</option>
							</select></td>
							<td><select name="chapter_select">
									<option value="0">--请选择--</option>
									<option value="1">1</option>
									<option value="2">2</option>
									<option value="3">3</option>
									<option value="4">4</option>
									<option value="5">5</option>
							</select></td>
							<td><select name="question_type_select">
									<option value="0">--请选择--</option>
									<option value="1">1</option>
									<option value="2">2</option>
									<option value="3">3</option>
									<option value="4">4</option>
									<option value="5">5</option>
							</select></td>
							<td><input type="text" class="form-control"
								style="width: 100%" id="Score" name="score"></td>
							<td><input type="text" class="form-control"
								style="width: 100%" id="Difficult" name="difficult"></td>
							<td><select id="BusinessAdminsID" name="businessadminsid">
									<option value="0">--请选择--</option>
									<option value="10000">10000</option>
									<option value="10001">10001</option>
									<option value="10002">10002</option>
							</select></td>
						</tr>
					</tbody>
				</table>
				<table class="table table-condensed">
					<thead>
						<tr>
							<th style="text-align: center;"><h4>题目详情</h4></th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td><textarea class="form-control" style="height: 300px"
									name="topic">
			      
			</textarea></td>
						</tr>
						<tr>
							<td>
								<div class="form-group col-md-3">
									<label class="col-sm-2 control-label">A:</label>
									<div class="col-sm-10">
										<input type="text" class="form-control" id="inputA"
											name="inputA">
									</div>
								</div>
								<div class="form-group col-md-3">
									<label class="col-sm-2 control-label">B:</label>
									<div class="col-sm-10">
										<input type="text" class="form-control" id="inputB"
											name="inputB">
									</div>
								</div>
								<div class="form-group col-md-3">
									<label class="col-sm-2 control-label">C:</label>
									<div class="col-sm-10">
										<input type="text" class="form-control" id="inputC"
											name="inputC">
									</div>
								</div>
								<div class="form-group col-md-3">
									<label class="col-sm-2 control-label">D:</label>
									<div class="col-sm-10">
										<input type="text" class="form-control" id="inputD"
											name="inputD">
									</div>
								</div>
							</td>
						</tr>
						<tr>
							<td>
								<div class="col-md-6">
									答案： <input type="text" class="form-control"
										style="width: 100%;height: 200px" name="answer">
								</div>
								<div class="col-md-6">
									解析： <input type="text" class="form-control"
										style="width: 100%;height: 200px" name="analysiss">
								</div>
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
	</form>
	</div>

</body>
</html>