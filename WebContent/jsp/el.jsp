<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>EL</title>
</head>
<body>
<%request.setAttribute("username1", "wangzhengfei"); %>
${param.username} &nbsp
${requestScope.username1} &nbsp
${param.username} 
<%session.setAttribute("session", "zhongguo"); 
//application.setAttribute("context", session);


session.invalidate();

%>

</body>
</html>