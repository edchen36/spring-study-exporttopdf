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
<!-- Display Error Message in Red -->
<link type="text/css" rel="stylesheet" href="css/error.css">
<!-- Latest Compiled and Minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
<!-- Include Optional Theme -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap-theme.min.css">
</head>
<body>
	<h1>Send Message Form</h1>
	<div class="container">
		<div class="row">
			<div class="span8">
				<form:form action="sendMessage" method="post" cssClass="form-horizontal" commandName="message">
					<div class="control-group">
						<label for="personName" class="control-label">
						Name
						</label>
						<div class="controls">
							<form:input path="personName" size="30"/>
							<form:errors path="personName" cssClass="fieldErrors"/>
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
						<label for="subject" class="control-label">
						<spring:message code="label.subject"></spring:message>
						</label>
						<div class="controls">
							<form:input path="subject" size="60"/>
							<form:errors path="subject" cssClass="fieldErrors"/>
						</div>
					</div>
					<div class="control-group">
						<label for="text" class="control-label">
						<spring:message code="label.text"/>
						</label>
						<div class="controls">
							<form:textarea path="text" cssClass="span4"/>
							<form:errors path="text" cssClass="fieldErrors"/>
						</div>
					</div>
					<div class="form-actions">
						<button type="submit" class="btn btn-success btn-large">Send Message</button>
						<a href="${pageContext.request.contextPath}" class="btn btn-primary">
							<span class="glyphicon glyphicon-home"></span>&nbsp;&nbsp;Home
						</a>
					</div>
				</form:form>
			</div>
		</div>
	</div>
</body>
</html>