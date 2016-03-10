<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@taglib prefix ="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Spring Application 06 Viewing Message Through JSON and AJAX</title>
<!-- Include Bootstrap Reference -->
<link rel="stylesheet" href="bootstrap/dist/css/bootstrap.min.css">
<!-- Include JQuery version 1.11.3 -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
</head>
<body>
	<h1> Welcome to Spring Contact and Message Form</h1>
	<h3><a href="newContactForm" class="btn btn-primary btn-lg btn-block">Add A Contact Form</a></h3>
	<h3><a href="listAllContacts" class="btn btn-success btn-lg btn-block">
		View Contact List
		<span id = "counter" class="badge"></span>
	</a></h3>
	<h3><a href="newMsgForm" class="btn btn-warning btn-lg btn-block">Contact Web Master</a></h3>
	<h3><a href="viewMessages" class="btn btn-info btn-lg btn-block">
		View Message
		<span id="mymessages" class="badge"></span> 
	</a></h3>
	<script type="text/javascript">
			function updateCounter(data){
				$("#counter").text(data.total);
			}
			function updateMsgCounter(data){
				$("#mymessages").text(data.total);
			}
			
			function updatePage(){
				$.getJSON("<c:url value="/getContacts"/>",updateCounter);
				$.getJSON("<c:url value="/getAllMessages"/>",updateMsgCounter);
			}
			
			function onload(){
				updatePage();
				window.setInterval(updatePage, 3000);
			}
			$(document).ready(onload);
			
	</script>

</body>
</html>