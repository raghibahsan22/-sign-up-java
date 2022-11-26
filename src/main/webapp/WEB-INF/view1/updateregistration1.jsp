<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ include file= "menu1.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update Registration</title>
</head>
<body>
<h2>Welcome</h2>
<p>update registration</p>
<form action="update" method="post">
<pre>
          Email<input type="text" name="email" value="<%=request.getAttribute("email")%>"/>
          Mobile<input type="text" name="mobile" value="<%=request.getAttribute("mobile")%>"/>
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