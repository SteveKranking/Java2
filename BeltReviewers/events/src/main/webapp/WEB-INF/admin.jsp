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
        
		<h1> Hey admin is for horse admins </h1>
		
		<table>
			<thead>
				<tr>
					<td> Name </td>
					<td> Next Due Payment Date </td>
					<td> Payment Due</td>
					<td> Type of Subscription</td>
				</tr>
			</thead>
			<c:forEach items="${allUsers}" var="iuser">
				<tr>
					<td> ${iuser.firstName} </td>
					<td> ${iuser.subscribedTo.subDate} </td>
					<td> ${iuser.subscribedTo.cost} </td>
					<td> ${iuser.subscribedTo.subType} </td>
				</tr>
			</c:forEach>
			</table>
			
			<h1> Subscription Packages </h1>

			<table>
					<thead>
						<tr>
							<td> Name </td>
							<td> Cost </td>
							<td> Available</td>
							<td> Actions</td>
						</tr>
					</thead>
					<c:forEach items="${allSubscriptions}" var="sub">
						<tr>
							<td> ${sub.subType} </td>							
							<td> ${sub.cost} </td>
							<td> Available </td>
							<td> Actions </td>
						</tr>
					</c:forEach>
					</table>
		</table>



		<h2>Create a new Subscription</h2>
		<form method="POST" action="/admin">

			<p><label>Name: <input type="text" name="subType"></label></p>
			
			<p><label>Cost: <input type="text" name="cost"></label></p>

			<p><button type="submit"> Add Subscription </button></p>

		</form>
		
    </body>
    
</html>