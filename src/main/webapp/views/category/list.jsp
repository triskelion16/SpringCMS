<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Category list</title>
</head>
<body>
	<div class="container">
		<h2>Categories</h2>
		
		<table class="table">
			<tr>
				<th colspan="3"><h4><a href="<c:url   value="/category/add"/>">Add Category</a></h4></th>
			</tr>
			<tr>
				<th>Id</th>
				<th>Name</th>
				<th>Description</th>
				<th colspan="2">Action</th>
			</tr>
			<c:forEach var="category" items="${categories}">
				<tr>
					<td>${category.id}</td>
					<td>${category.name}</td>
					<td>${category.description}</td>
					<td><a href="<c:url value="/category/edit/${category.id}"/>">Edit</a></td>
					<td><a href="<c:url value="/category/delete/${category.id}"/>">Delete</a></td>
				</tr>
			</c:forEach>
		</table>

	</div>
</body>
</html>
