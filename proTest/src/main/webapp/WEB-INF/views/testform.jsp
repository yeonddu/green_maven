<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath }" />
<% request.setCharacterEncoding("UTF-8"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>회원 정보</title>
</head>
<body>
	<form method="post" action="${contextPath }/test9.do">
	<input type="submit" value="회원 정보 조회">
	</form>
</body>
</html>