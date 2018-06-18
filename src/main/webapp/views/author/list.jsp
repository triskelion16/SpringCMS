<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Authors list</title>
</head>
<body>
	<div class="container">
		<h2>Authors</h2>
		
		<table class="table">
			<tr>
				<th colspan="3"><h4><a href="<c:url   value="/author/add"/>">Add Author</a></h4></th>
			</tr>
			<tr>
				<th>Id</th>
				<th>First Name</th>
				<th>Last Name</th>
				<th colspan="2">Action</th>
			</tr>
			<c:forEach var="author" items="${authors}">
				<tr>
					<td>${author.id}</td>
					<td>${author.firstName}</td>
					<td>${author.lastName}</td>
					<td><a href="<c:url value="/author/edit/${author.id}"/>">Edit</a></td>
					<td><a href="<c:url value="/author/delete/${author.id}"/>">Delete</a></td>
				</tr>
			</c:forEach>
		</table>

	</div>
</body>
</html>
