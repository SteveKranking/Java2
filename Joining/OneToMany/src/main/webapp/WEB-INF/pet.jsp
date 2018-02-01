<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Index</title>
		<link rel="stylesheet" type="text/css" href="/css/style.css">	
		<script src="/js/main.js"></script>
	</head>

	<body>
		<form:form action="pets/new" method="post" modelAttribute="pet">
			<form:label path="name">
			<form:errors path="name"></form:errors>
			<form:input path="name"></form:input>
			</form:label>

			<form:label path="species">
			<form:errors path="species"></form:errors>
			<form:input path="species"></form:input>
			</form:label>


			
				<form:select path="user">
				<c:forEach items="${users}" var="user">
					<form:option value="${user.id}">${user.name}</form:option>
				</c:forEach></form:select>
		
			<input type="submit" value="Register Pet">
		</form:form>
	</body>
</html>