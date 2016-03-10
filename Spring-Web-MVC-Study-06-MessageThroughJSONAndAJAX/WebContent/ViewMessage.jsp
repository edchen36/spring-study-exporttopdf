<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dt()d">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Spring Application 06 - Viewing Message Through JSON and AJAX</title>
</head>
<body>
	<h1>
		Message To WebMaster
		<a href="${pageContext.request.contextPath}" class="btn btn-primary">
			<span class="glyphicon glyphicon-home"></span>&nbsp;&nbsp;Home		
		</a>	
	</h1>
	<div id="mymessages">
	
	</div>
	<script type="text/javascript">
		function showMessage(data){
			//alert("inside function")
			$("div#mymessages").html("");
			for(var i=0;i<data.mymessageList.length;i++){
				var msg = data.mymessageList[i];
				var msgDiv=document.createElement("a");
				msgDiv.setAttribute("class", "list-group-item");
				var msgSubjectSpan=document.createElement("h3");
				msgSubjectSpan.setAttribute("class", "list-group-item heading text-primary");
				msgSubjectSpan.appendChild(document.createTextNode(msg.subject));
				
				var msgContentSpan = document.appendChild(document.createElement("p"));
				msgContentSpan.setAttribute("class", "list-group-item-text h4");
				msgContentSpan.appendChild(document.createTextNode(msg.text));
				msgContentSpan.appendChild(document.createElement("br"));
				
				var contactDetails=msgContentSpan.appendChild(document.createElement("p"));
				contactDetails.setAttribute("class","list-group-item-text h5 text-muted");
				contactDetails.appendChild(document.createTextNode(msg.personName+"("+ msg.email+")"));
				
				msgDiv.appendChild(msgSubjectSpan);
				msgDiv.appendChild(msgContentSpan);
				msgDiv.appendChild(contactDetails);
				$("div#mymessages").append(msgDiv);
							
			}
		}
		
		function updatePage(){
			// alert("calling showMessages");
			$.getJSON("<c:url value="/getAllMessages"/>",showMessages);
		}
		
		function onload (){
			//alert("Page Loaded")
			updatePage();
			window.setInterval(updatePage, 3000);
		}
	
		$(document).ready(onload);
		
	</script>
	

</body>
</html>