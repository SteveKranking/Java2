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
		<h1> Persons New</h1> 
		<a href="/"> Home </a>

		<form:form method="POST" action="/person/new" modelAttribute="person">
			<p> <form:label path="first"> First Name </form:label> </p>	
			<form:input type="text" name="first_name" path="first" /></span>
			
			<form:input type="text" name="last_name"  path="last" /></span>

			<input type="submit" value="Add"/>
	
		</form:form> 
	</body>
</html>