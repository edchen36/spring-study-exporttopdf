<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Spring Application 06 - Viewing Message Through JSON and AJAX</title>
</head>
<body>
	<h1>Welcome ${contact.getFirstName()} ${contact.getLastName()} !</h1>
	<h3><a href="${pageContext.request.contextPath}">Home</a></h3>

</body>
</html>