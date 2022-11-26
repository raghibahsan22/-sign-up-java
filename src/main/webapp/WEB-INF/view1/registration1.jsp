<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ include file= "menu1.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>registration</title>
</head>
<body>
<h2>Welcome to Insure</h2>
<p>please enter your detail</p>
<form action="savereg1" method="post">
<pre>
                 Name<input type="text" name="name"/>
                 City<input type="text" name="city"/>
                 Email<input type="text" name="email"/>
                 Mobile<input type="tel" name="mobile"/>
                 <input type="submit" value ="save">
</pre>



</form>
<%
if(request.getAttribute("msg")!=null){
	
	out.println(request.getAttribute("msg"));
}
%>

</body>
</html>