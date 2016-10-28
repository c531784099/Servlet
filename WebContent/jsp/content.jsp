<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="utf-8"%>
<!--<%@ page errorPage="errorpage.jsp" %>-->
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%!int var=1; %>
<%out.println(var++); %>
<% pageContext.setAttribute("username", "chengixangfeng", PageContext.PAGE_SCOPE); 
	pageContext.setAttribute("username1", "chengxiangfeng1",PageContext.REQUEST_SCOPE);
	pageContext.setAttribute("useername2", "chengxiangfeng2",PageContext.SESSION_SCOPE);
	pageContext.setAttribute("username3", "chengixangfeng3",PageContext.APPLICATION_SCOPE);
%>
<% 
out.println(request.getAttribute("username1")+"\r\n");
out.println(pageContext.getAttribute("username")+"\r\n");
%>

<%ServletRequest sq=pageContext.getRequest();
if(sq instanceof ServletRequest)
	out.println("wo shi ServletRequet  ");
%>
ggo
<!-- 注释也会响应到客户端的 -->
<!-- 在这个jsp中  request等内置对象和前一个jsp不会共享  隐含对象的使用范围的 因为是不同的jsp对应的servlet对象。 -->




</body>
</html>