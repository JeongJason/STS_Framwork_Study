<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	table{
	text-aling: center;
	}
</style>
</head>
<body>
	<h1>ex04</h1>
	<table border="1">
		<tr>
			<th>이름</th>
			<th>나이</th>
		</tr>
		<tr>
			<th><c:out value="${dto.name}"/></th>
			<th><c:out value="${dto.age}"/></th>
		</tr>
	</table>

</body>
</html>