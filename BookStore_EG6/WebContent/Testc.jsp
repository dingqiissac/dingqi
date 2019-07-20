<%@page import="java.util.ArrayList"%>
<%@page import="com.atguigu.entity.User"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		List<User> l = new ArrayList<User>();
		/* l.add(new User(1002,"丁奇","123","qq@"));
		l.add(new User(1003,"许仕鹏","123","qq@"));
		l.add(new User(1004,"蔡海平","123","qq@"));
		l.add(new User(1005,"汪成棒","123","qq@")); */
		request.setAttribute("group", l);
		
	%>
	<c:if test="${empty group}">
		<c:out value="kongjihe"></c:out>
	</c:if>
	
	<br>
	
	<c:choose>
		<c:when test="${empty group}">
			jieh wei kong
		</c:when>
		
		<c:otherwise>
			bu weikong		
		</c:otherwise>
	
	</c:choose>
	
	
	
	
	<table border="1" bordercolor="red">
		<c:forEach items="${group}" var="u" varStatus="r">
			<tr>
				<td>${r.index+1}</td>
				<td>${u.getId()}</td>
				<td>${u.getName()}</td>
				<td>${u.getPassword()}</td>
				<td>${u.getEmail()}</td>
				<td>${r.index}</td>
			</tr>
		</c:forEach>
	</table>
	
	
	<c:set var="key" value="value" scope="request"></c:set>
	<c:out value="${key}"></c:out>
</body>
</html>