<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
<% pageContext.setAttribute("username", "chengixangfeng", PageContext.PAGE_SCOPE); 
	pageContext.setAttribute("username1", "chengxiangfeng1",PageContext.REQUEST_SCOPE);
	pageContext.setAttribute("useername2", "chengxiangfeng2",PageContext.SESSION_SCOPE);
	pageContext.setAttribute("username3", "chengixangfeng3",PageContext.APPLICATION_SCOPE);

%>
<% 
out.println(pageContext.getAttribute("username"));
%>
</body>
</html>