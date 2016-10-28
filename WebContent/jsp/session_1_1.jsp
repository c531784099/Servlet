<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
 pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%String str=(String)session.getAttribute("username");
out.println(str);
//这里第一次访问会有数据、但是刷新到第二次  就会不存在了、因为session会话已经销毁了。
session.invalidate();//销毁会话在前、检查session对象在后、没有session对应的httpsession对象就会、发送sessionid到客户端。
%>

<% 
//这里每次来一个请求都会 查找servlet容器、是否包含相应sessionid的httpsession对象、
Cookie[] cookie=request.getCookies();
  if(cookie==null){
	  out.println("No cookie");
  }
for(int i=0;i<cookie.length;i++){
	out.println(cookie[i].getName()+"==="+cookie[i].getValue());
}
%>
</body>
</html>