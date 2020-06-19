<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>学生信息管理系统 —— 首页</title>
</head>
<body>

	<a href="addStu">添加学生</a>
	<table border="1" cellspacing="0">
		<thead>
			<tr>
				<th>ID</th>
				<th>姓名</th>
				<th>性别</th>
				<th>年龄</th>
				<th>成绩</th>
				<th>操作</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${stus}" var="stu">
				<tr>
					<td>${stu.id}</td>
					<td>${stu.name}</td>
					<td>${stu.gender}</td>
					<td>${stu.age}</td>
					<td>${stu.score}</td>
					<td><a href='updateStu?id=${stu.id}'>修改</a> | <a href='deleteStu?id=${stu.id}'>删除</a></td>
				</tr>
			</c:forEach>	
		</tbody>
	</table>


</body>
</html>
