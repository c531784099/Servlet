<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="utf-8"%>
    <%@ page session="true" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<!-- 这里的情况是  浏览器不支持cookie、jsp支持会话 使用该方法来保证客户相关的多个请求   -->
<form action="<%= response.encodeURL("contene.jsp") %>">
<!-- 该方法执行流程：首先检查该jsp是否支持会话、不支持会话  请求路径是content.jsp 
  jsp支持会话、下一步检查浏览器是否支持cookie、支持  路径为content.jsp  不支持  content.jsp;jsession=DJFSLJSLD324L423LJ5L4353L
通过该手段就解决了  浏览器不支持会话的情况。
 -->
</form>
</body>
</html>