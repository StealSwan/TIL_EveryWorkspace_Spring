<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<link href="https://fonts.googleapis.com/css2?family=Dokdo&family=Gaegu&family=Gugi&family=Nanum+Pen+Script&display=swap" rel="stylesheet">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script src="https://code.jquery.com/jquery-3.5.0.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

<title>Insert title here</title>
</head>

	<c:set var="root" value="<%=request.getContextPath() %>"/>

<body>

	<div style="margin-left: 100px; margin-top: 50px;">
		<img alt="" src="${root}/photo/9.png" width="200" align="left" hspace="20">
		
		<br><br>
		
		<b>${name}님</b>
		
		<br><br>
		
		<button type="button" class="btn btn-danger"
		style="width: 100px;" onclick="location.href='logoutprocess'">로그아웃</button>
	</div>

</body>
</html>