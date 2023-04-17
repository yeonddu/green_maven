<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath }" />
<% request.setCharacterEncoding("UTF-8"); %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ȸ������ ���â</title>
</head>
<body>
	<h2 align="center">ȸ������</h2>
	<table border="1" align="center" width="80%">
		<tr align="center" bgcolor="#DED6F0">
			<td><b>���̵�</b></td>
			<td><b>��й�ȣ</b></td>
			<td><b>�̸�</b></td>
			<td><b>�̸���</b></td>
			<td><b>������</b></td>
			<td><b>����</b></td>
			<td><b>����</b></td>
		</tr>

	<c:forEach var="member" items= "${membersList }" >
		<tr align="center">
			<td>${member.id }</td>
			<td>${member.pwd }</td>
			<td>${member.name }</td>
			<td>${member.email }</td>
			<td>${member.joinDate }</td>
			<td><a href="${contextPath }/member/modMember.do?id=${member.id }">�����ϱ�</a></td>
			<td><a href="${contextPath }/member/removeMember.do?id=${member.id }" style="color:#C83CBD">�����ϱ�</a></td>
		</tr>
	</c:forEach>	
	</table>
</body>
</html>