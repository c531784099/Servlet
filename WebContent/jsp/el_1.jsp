<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="listener.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<% session.setAttribute("session1", "meiguo");
session.setAttribute("session2", "meiguo");
session.removeAttribute("session2");

MyData my=new MyData();
session.setAttribute("object", my);

session.removeAttribute("object");



%>
${sessionScope.session1}
${sessionScope["session1"] }
</body>
</html>