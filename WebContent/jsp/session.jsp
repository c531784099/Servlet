<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="utf-8"%>
<%@ page session="true"  %>
<!-- session设置为true  标识jsp支持session会话、会将sessionid 添加到cookie  name：JESSESSION -->
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
zhonghuarenminggongheguo！
<%Cookie[] cookie=request.getCookies();
if(cookie==null){
	out.println("No cookies");
	return;
}
for(int i=0;i<cookie.length;i++){
%>
<b>cookie name:</b>
<%=cookie[i].getName() %>
<b>cookie value:</b>
<%=cookie[i].getValue() %>
<b>max Age:</b>
<%=cookie[i].getMaxAge() %>
<%} %>
</body>
</html>