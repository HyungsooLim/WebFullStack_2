<%@page import="com.hs.s1.member.MemberDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
String result = (String) request.getAttribute("r");
MemberDTO memberDTO = (MemberDTO) request.getAttribute("DTO");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>memberResult</title>
</head>
<body>
	<h1>Member Result Page</h1>
	<h1><%=result%></h1>
	
	<%if(memberDTO!=null){ %>
	<h1>
		ID :
		<%=memberDTO.getId()%>
		<br> PW :
		<%=memberDTO.getPw()%>
		<br> NAME :
		<%=memberDTO.getName()%>
		<br> PHONE :
		<%=memberDTO.getPhone()%>
		<br> EMAIL :
		<%=memberDTO.getEmail()%>
		<br>
	</h1>
	<%} %>
</body>
</html>