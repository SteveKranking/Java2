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
		<a href="/logout">Logout</a>
		<h1>Welcome to Dojoscriptions ${user.firstName}!</h1>
		<h3>Please Choose a subscription and start date</h3>
		<form method ="POST" action="/addUserDeal">
			<label> Due Day <input type="number" name="due" id="due" value="1" min="1" max="31">
			</label>
			<select name="deal">
				<c:forEach items = "${deals}" var = "deal">
					<c:if test ="${deal.isActive()}">
						<option value="${deal.id}">${deal.name} ($ ${deal.cost})</option>
					</c:if>
				</c:forEach>
			</select>

			

			<input type="submit" value="Sign Up!">
		</form>
	</body>
</html>