<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Register</title>
		<link rel="stylesheet" type="text/css" href="/css/styles.css">	
		<script src="/js/main.js"></script>
	</head>

	<body>
        
        <h1> Welcome, ${currentUser.firstName}!</h1>
		<h2> Start by selecting your subscription type here!</h2>
		
		<form:form action="/subscribe" method="POST" modelAttribute="user">

		    <p>
				<form:label path="payDate"> Subscription Date: 
					<form:input type="date" path="payDate"></form:input>
					<form:errors path="payDate"></form:errors>
				</form:label>
			</p>
			<p>
				<form:label path="subscribedTo"> Subscription Type: 

				<form:select path="subscribedTo">
							
					<c:forEach items="${allSubscriptions}" var="sub">

					<form:option value="${sub.id}"> ${sub.subType} </form:option>
					
					</c:forEach>
						
					</form:select>
				
				<form:errors path="subscribedTo"></form:errors>
				</form:label>
			</p>

			<p><form:errors path="user.*"/></p>
		    <input type="submit" value="Subscribe">

		</form:form>

	</body>
</html>