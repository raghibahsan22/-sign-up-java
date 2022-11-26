<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>signup here....</title>
</head>
<body>
<h2>signup your account</h2>
<form action="signupinfo" method="post">
LoginID<input type="text" name ="email"/>
Password<input type="text" name ="password"/>
<input type="submit" value="save">
</form>

<%
if(request.getAttribute("msg")!=null){
	
	out.println(request.getAttribute("msg"));
}
%>

</body>
</html>