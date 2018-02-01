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

			<p> Welcome, ${user.username} </p>
			<p> <a href="/logout" > Logout </a> </p>
			<p> <a href="/addClasses"> Add Classes </a> </p>

			<p> My Schedule </p>

			<p> Drop down menu here </p>
			<label> Choose Semester To View </label>
			<c:for:Each items=${user.semesters} var="thisSemester" >

					<option value="${thisSemester.id}"> ${thisSemester.id} </option>

			</c:for:Each>

			<table>
				<thead>
					<tr> 
						<td> Classes Enrolled  </td>
						<td> Instructor </td>
						<td> Days  </td>
						<td> Time </td>
						<td> Action </td>
					</tr>
				</thead>
			</table>
	</body>

</html>