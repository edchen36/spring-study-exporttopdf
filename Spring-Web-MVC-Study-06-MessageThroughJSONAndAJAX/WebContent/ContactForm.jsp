<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Spring Application 06 - Viewing Message Through JSON and AJAX</title>
<!-- Display field error in red -->
<link type="text/css" rel="stylesheet" href="css/error.css">
<!-- Latest compiled and minified css -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
<!-- Optional Theme -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap-theme.min.css">
</head>
<body>
	<h1>Contact Form</h1>
	<div class="container">
		<div class="row">
			<div class="span8">
				<form:form action="addContact" method="post" cssClass="form-horizontal" commandName="contact">
					<div class="control-group">
						<label for="firstName" class="control-label">
						<spring:message code="label.firstName"/>
						</label>					
						<div class="controls">
							<form:input path="firstName" size="30"/>
							<form:errors path="firstName" cssClass="fieldErrors"/>
						</div>
					</div>
					<div class="control-group">
						<label for="lastName" class="control-label">
						<spring:message code="label.lastName"/>
						</label>
						<div class="controls">
							<form:input path="lastName" size="30"/>
							<form:errors path="lastName" cssClass="fieldErrors"/>
						</div>
					</div>
					<div class="control-group">
						<label for="mobile" class="control-label">
						<spring:message code="label.mobile"/>
						</label>
						<div class="controls">
							<form:input path="mobile" size="30"/>
							<form:errors path="mobile" cssClass="fieldErrors"/>
						</div>
					</div>
					<div class="control-group">
						<label for="email" class="control-label">
						<spring:message code="label.email"/>
						</label>
						<div class="controls">
							<form:input path="email" size="50"/>
							<form:errors path="email" cssClass="fieldErrors"/>
						</div>
					</div>
					<div class="control-group">
						<label for="gender" class="control-label">
						<spring:message code="label.gender"/>
						</label>
						<div class="controls">
						<form:radiobutton path="gender" value="Male"/>
						<spring:message code="label.male"/>
						<form:radiobutton path="gender" value="Female"/>
						<spring:message code="label.female"/>
						</div>
					</div>
					<div class="form-actions">
						<button type="submit" class=" btn btn-large btn-success">Add a New Contact</button>
						<a href="${pageContext.request.contextPath}" class="btn btn-primary">
							<span class="gryphicon gryphicon-home" ></span>&nbsp;&nbsp;Home
						</a>
					</div>
				</form:form>	
			</div>
		</div>
	</div>
</body>
</html>