<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>学生信息管理系统</title>
</head>
<body>

	<a href="list">返回列表页面</a>

	<form action="updateStu" method="POST">
		<input type="hidden" name="id" value="${stu.id}">
		姓名：<input type="text" name="name" value="${stu.name}"> <br>
		性別：<input type="text" name="gender" value="${stu.gender}"> <br>
		年龄：<input type="text" name="age" value="${stu.age}"> <br>
		成绩：<input type="text" name="score" value="${stu.score}"> <br>
		<input type="submit">
	</form>

</body>
</html>