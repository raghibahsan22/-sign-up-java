<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   
   
<!DOCTYPE html>
<html>
<head>
<style>

<meta charset="ISO-8859-1">
<title>Login</title>
</head>
<body>
<h2>Login here</h2>
<form action="logincontroller1" method="post">
Username <input type ="email" name="email"/>
</br>


Password <input type ="password" name="password"/>
</br>
<br>
<input type="submit" value ="login">

</form>
<form action="signup" method="post">
<input type="submit" value="signup">
</form>



<% 

if(request.getAttribute("error")!= null){
	out.println(request.getAttribute("error"));
}
%>
</body>
</html>