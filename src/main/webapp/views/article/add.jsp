<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Article Add</title>
</head>
<body>
	<div class="container">
		<h2>Add Article</h2>

		<form:form method="post" modelAttribute="articles">

			<div class="form-group">
				<label>
					Title: 
					<form:input class="form-control" path="title" />
					<form:errors path="title" />
				</label> 
			</div>
			
			<div class="form-group">
				<label>
					Content: 
					<form:input type="text" class="form-control" path="content" />
					<form:errors path="content" />
				</label>
			</div>
			
			<div class="form-group">
				<label>
					Author: 
					<form:select itemLabel="lastName" itemValue="id" class="form-control" path="author.id" items="${authors}" />
				</label>
			</div>
			
			<div class="form-group">
				<label>
					Categories: 
					<form:select itemLabel="name" itemValue="id" class="form-control" path="categories" items="${categories}" multiple="true" />
				</label>
			</div>

			<input type="submit" class="btn btn-default" value="Save">

		</form:form>


	</div>
</body>
</html> 