<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style>
	@import url('https://fonts.googleapis.com/css2?family=Gowun+Dodum&display=swap');
	* {
		font-family: 'Cafe24Oneprettynight';
		font-family: 'Gowun Dodum', sans-serif; 
		text-decoration:none;
	}
	#container {
		width:100%;
		margin:0px auto;
		boreder:0;
		text-align:cetner;
	}
	
	#header {
		padding:5px;
		margin-bottom:5px;
		border:0;
		background-color:#EFECF4;
	}
	
	#sidebar-left {
		width:15%;
		height:700px;
		padding:5px;
		margin-right:5px;
		margin-bottom:5px;
		float:left;
		background-color:#E8E3F2;
		border:0;
		font-size:10px;
		text-align:center;
	}
	
	#content {
		width:80%;
		padding:10px;
		margin-right:5px;
		float:left;
		border:0;
	}
	
	#footer {
		padding:5px;
		clear:both;
		border:0;
		background-color:#D1C9E3;
	}

</style>
<title><tiles:insertAttribute name="title"/></title>
</head>
<body>
	<div id="container">
		<div id="header">
			<tiles:insertAttribute name="header" />
		</div>
		<div id="sidebar-left">
			<tiles:insertAttribute name="side" />
		</div>
		<div id="content">
			<tiles:insertAttribute name="body" />
		</div>
		<div id="footer">
			<tiles:insertAttribute name="footer" />
		</div>
	</div>
</body>
</html>