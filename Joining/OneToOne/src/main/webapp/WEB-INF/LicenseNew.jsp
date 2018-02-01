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
		<h1> License New</h1>
		<a href="/"> Home </a>

		<form:form method="POST" action="/license/new" modelAttribute="license">
            
            <p> <form:label path="person"> Person </form:label> </p>	
			
			<form:select path="person">
			
					<c:forEach items="${ persons }" var="person" varStatus="loop">
					   <form:option value="${ person.id }"> ${person.first} ${person.last} </form:option>
					</c:forEach> 
		   
			</form:select>
			
            <form:input type="text"  path="state" /> 
            
            <form:input type="date"  path="expirationDate" /> 

			<input type="submit" value="Add"/>


			<form:errors path="person"></form:errors>
			<form:errors path="state"></form:errors>
			<form:errors path="expirationDate"></form:errors>


		</form:form>
	</body>
</html>