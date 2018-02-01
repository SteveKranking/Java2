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
		<div id="Gold">
			<h2>Gold: </h2>
			<fieldset>
				<h2>${gold}</h2>
			</fieldset>
		</div>

		<div class = "box">
			<fieldset >
				<h2>Farm</h2>
				<p>(Earns 10-20 gold)</p>
				<form action="/farm"  method="post">
					<input type="submit" value="gold">
				</form>
			</fieldset>
		</div>
		<div class = "box">
			<fieldset >
				<h2>cave</h2>
				<p>(Earns 5-10 gold)</p>
				<form action="/cave" method="post">
					<input type="submit" value="gold">
				</form>
			</fieldset>
		</div>
		<div class = "box">
			<fieldset >
				<h2>House</h2>
				<p>(Earns 0 gold)</p>
				<form action="/house" method="post">
					<input type="submit" value="gold">
				</form>
			</fieldset>
		</div>
		<div class = "box">
			<fieldset >
				<h2>casino</h2>
				<p>(Earns/takes 0-50 gold)</p>
				<form action="/casino" method="post">
					<input type="submit" value="gold">
				</form>
			</fieldset>
		</div>

		<div>
			<h2>Activites:</h2>
			<fieldset id="Passions">
				<c:forEach items ="${passions}" var ="passion">
					<p>${passion}</p>
				</c:forEach>
			</fieldset>
		</div>

		<div>
			<form action="/reset" method="post">
			<input type="submit" value="reset">
			</form>
		</div>
	</body>
</html>