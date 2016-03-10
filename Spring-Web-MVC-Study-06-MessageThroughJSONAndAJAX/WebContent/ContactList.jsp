<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Spring Application 06 Viewing Message with JSON</title>
<link rel="stylesheet" href ="bootstrap/dist/css/bootstrap.min.css">
<script src="src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
</head>
<body>
	<h1>Contact List</h1>
		<a href="${pageContext.request.contextPath}" class="btn btn-primary">
			<span class="glyphicon glyphicon-home"></span>&nbsp;&nbsp;Home
		</a>
		<a href="ContactListExcel" class="btn btn-success">
		 <span class="glyphicon glyphicon-save"></span>&nbsp;&nbsp;Save As Excel
		</a>
		<a href="ContactListPDF" class="btn btn-warning">
			<span class="glyphicon glyphicon-download-alt"></span>&nbsp;&nbsp;Download As PDF
		</a>

	<c:if test="${!empty allContacts }">
		<table class="table table-striped table-bordered ">
			<tr>
				<th>Name</th>
				<th>Gender</th>
				<th>Mobile</th>
				<th>Email Address</th>
				<th colspan="2">Actions</th>
			</tr>
		<c:forEach items="${allContacts}" var="contacts">
				<tr>
					<td>${contacts.getFirstName()} ${contacts.getLastName()}</td>
					<td>${contacts.getGender()}</td>
					<td>${contacts.getMobile()}</td>
					<td>${contacts.getEmail()}</td>
					<td>
						<a href="edit/${contacts.getContactId()}" class="btn btn-info">
							<span class="glyphicon glyphicon-edit"></span>&nbsp;&nbsp;Edit
						</a>
					</td>
					<td>
						<a href="delete/${contacts.getContactId()}" class="btn btn-warning">
							<span class="glyphicon glyphicon-remove"></span>&nbsp;&nbsp;Delete
						</a>
					</td>
				</tr>	
		</c:forEach>
		</table>
		<a class="btn btn-default disabled">
			Total Contacts:<span id="counter" class="badge"></span>
		</a>
		<script type="text/javascript">
			function updateCounter(data){
				$("#counter").text(data.total);
			}
			function updatePage(){
				$.getJSON("<c:url value="/getContacts"/>",updateCounter);
			}
			
			function onload(){
				updatePage();
				window.setInterval(updatePage, 3000);
			}
			
			$(document).ready(onload);
		</script>
	</c:if>
</body>
</html>