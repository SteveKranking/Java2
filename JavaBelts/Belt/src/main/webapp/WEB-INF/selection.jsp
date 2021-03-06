<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Dashboard</title>
		<link rel="stylesheet" type="text/css" href="/css/styles.css">	
		<script src="/js/main.js"></script>
	</head>

	<body>
		<h1>Greetings, ${ user.firstName }</h1>
        <h3>Get started with your subscription!</h3>
            <!-- <form:form modelAttribute="subscription" path="/subscription">

                    <form:label path="lastName">Last Name: 
                            <form:input type="Date" path="subDate"></form:input>
                            <form:errors path="subDate"></form:errors>
                        </form:label>
                    </p>
                    <p>
                        <form:label path="subType"> Subscription Type: 
                            <form:input path="subType"></form:input>
                            <form:errors path="subType"></form:errors>
                        </form:label>
                    </p>

			<button type="submit">Create</button>
		</form:form>
		<a href="/logout">Logout</a> -->
	</body>
</html>