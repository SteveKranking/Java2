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
		<h1>Admin Dashboard</h1>
		<a href="/logout">logout</a>

		<h3>Coustomers</h3>
		<table>
			<thead>
				<tr>
					<th>Name</th>
					<th>Next Due Date</th>
					<th>Amount Due</th>
					<th>Package Type</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${users}" var="user">
					<c:if test="${!user.isAdmin()}">
							<c:if test="${user.deal != null}">
							
								<tr>
									<td>${user.firstName} ${user.lastName}</td>
									<td>${user.fullDate}</td>
									<td>${user.deal.cost}</td>
									<td>${user.deal.name}</td>
								</tr>
								
							</c:if>
					</c:if>
				</c:forEach>
			</tbody>
		</table>
		<h3>Packages</h3>
		<table>
			<thead>
				<tr>
					<th>Package Name</th>
					<th>Package Cost</th>
					<th>Avaliable</th>
					<th>Users</th>
					<th>Actions</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items ="${deals}" var ="deal">
					<tr>
						<td>${deal.name}</td>
						<td>$ ${deal.cost}</td>
						<td>
								<c:if test="${deal.isActive()}">
								Available
								</c:if>
								<c:if test="${!deal.isActive()}">
								Unavaliable
								</c:if>
						</td>
						<td>${deal.payers.size()}</td>
						<td>
							<c:if test="${deal.isActive()}">
								<a href="/deal/${deal.id}/deactivate">deactivate</a>
							</c:if>
							<c:if test="${!deal.isActive()}">
								<a href="/deal/${deal.id}/activate">activate</a>
							</c:if>
							<c:if test="${deal.payers.size() == 0}">
								<a href="/deal/${deal.id}/delete">delete</a>
							</c:if>
						</td>
					</tr>

				</c:forEach>
			</tbody>
		</table>

		<fieldset>
			<legend>Create Package</legend>
		<form:form method="POST" action="/newDeal" modelAttribute="deal">
			<p>
				<form:label path="name">Package Name:
				<form:errors path="name"></form:errors>
				<form:input path="name"/>
				</form:label>
			</p>
			<p>
				<form:label path="cost">Cost:
				<form:errors path="cost"></form:errors>
				<form:input type="number"  path="cost"/>
				</form:label>
			</p>
			
		<input type="submit" value="Create new Package">
	</form:form>
		</fieldset>
	</body>
</html>