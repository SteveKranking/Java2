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
		<h1>${product.name}</h1>
		<h3>Catagories:</h3>
		<c:forEach items="${catagories}" var="catagory">
				<p>	- ${catagory.name}</p>
		</c:forEach>

		<form action="add/${id}" method="post">
			<select name="category_id">
			<c:forEach items="${allCategories}" var="category">
				<c:if test="${product != category.product}">
				<option value="${category.id}">${category.name}</option>
			</c:if>
			</c:forEach>
		</select>
		<input type="submit" value="GO">

		</form>
	</body>
</html>