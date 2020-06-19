<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>学生信息管理系统 —— 首页</title>
</head>
<body>

	<a href="list">返回列表页面</a>

	<form action="addStu" method="POST">
		ID：<input type="text" name="id"> <br>
		姓名：<input type="text" name="name"> <br>
		性別：<input type="text" name="gender"> <br>
		年龄：<input type="text" name="age"> <br>
		成绩：<input type="text" name="score"> <br>
		<input type="submit">
	</form>

</body>
</html>