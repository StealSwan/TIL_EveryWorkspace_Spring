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

<style type="text/css">

ul.menu{
	list-style: none;
}

ul.menu li{
	width: 150px;
	height: 80px;
	line-height: 80px;
	text-align: center;
	font-size: 15px;
	border: 2px solid gray;
	float: left;
	margin-right: 20px;
	font-family: 'Dokdo';
}

ul.menu li:hover {
	background-color: pink;
}
</style>

<title>Insert title here</title>
</head>

	<c:set var="root" value="<%=request.getContextPath() %>"/>
	
<body>

	<ul class="menu">
		<li>
			<a href="${root}/">Home</a>
		</li>

		<li>
			<a href="${root}/member/form">회원가입</a>
		</li>

		<li>
			<a href="${root}/login/main">로그인</a>
		</li>

		<li>
			<a href="${root}/shop/shopform">상품등록</a>
		</li>

		<li>
			<a href="${root}/guest/list">방명록</a>
		</li>

		<li>
			<a href="${root}/board/list">게시판</a>
		</li>
	</ul>

</body>
</html>