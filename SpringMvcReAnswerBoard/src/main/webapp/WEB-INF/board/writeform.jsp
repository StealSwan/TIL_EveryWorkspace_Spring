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
<body>

	<div style="margin-left: 50px;">
		<form action="insert" method="post" enctype="multipart/form-data">
			
			<!-- 답글일때 대비해 hidden 5개 -->
			<input type="hidden" name="num" value="${num}">
			<input type="hidden" name="currentPage" value="${currentPage}">
			<input type="hidden" name="regroup" value="${regroup}">
			<input type="hidden" name="restep" value="${restep}">
			<input type="hidden" name="relevel" value="${relevel}">
			
			<table class="table table-bordered" style="width: 500px;">
				<caption><b>
					<c:if test="${num==0}">새글쓰기</c:if>
					<c:if test="${num!=0}">답글쓰기</c:if>
				</b></caption>
				
				<tr>
					<th width="100">작성자</th>
					<td>
						<input type="text" name="writer" class="form-control" required="required">
					</td>
					
					<th width="100">비밀번호</th>
					<td>
						<input type="password" name="pass" class="form-control" required="required">
					</td>
				</tr>
				
				<tr>
					<th width="100">제목</th>
					<td colspan="3">
						<input type="text" name="subject" class="form-control" required="required">
					</td>
				</tr>
				
				<tr>
					<th width="100">사진</th>
					<td colspan="3">
						<input type="file" name="upload" class="form-control" multiple="multiple">
					</td>
				</tr>
				
				<tr>
					<td colspan="4">
						<textarea style="width: 500px; height: 150px;" name="content" class="form-control" required="required"></textarea>
					</td>
				</tr>
				
				<tr>
					<td colspan="4" align="center">
						<button type="submit" class="btn btn-info" style="width: 120px;">저장하기</button>
						<button type="button" class="btn btn-info" style="width: 120px;"
						onclick="history.back()">이전으로</button>
					</td>
				</tr>										
			</table>
			
		</form>
	</div>

</body>
</html>