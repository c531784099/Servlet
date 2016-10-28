<!-- 用来设定和整个网页相关的 属性 language:代码片段的编程语言  contenttype:响应结果的类型 pageEncoding:本页的编码 session:指定本页是否启用session-->
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>测试JSP</title>
</head>
<body>
<!-- 静态包含其他文件 可以是html 或者jsp 但不可以是servlet -->

<%@ include file="jsp_1.jsp" %>
good morning!
<!-- 声明标签、是jsp对应servlet类的成员变量和成员方法 -->

<%!int v1=0; %>

<!-- 代码片段 默认在service（）方法中 -->

<%System.out.println(v1++); %>
<%if(v1%2==0){ %>
wo shi ou shu
<%} else{ %>
wo bushi yige hao ren 
<%} %>
<!-- 将表达式的值 输出到前台-->

<%=v1%>

<!-- Jsp中的隐含对象 9个  这里用了2个  都是固定引用变量、是service中的局部变量 -->

<%String username=request.getParameter("username");
  out.write(username);
%> 

<!-- Jsp 的请求转发  源jsp的输出不会输出到前台。相对路径或者绝对路径 -->
<jsp:forward page="target.jsp">
<!-- 通过jsp:param 向目标组件传递额外的参数。 -->
  <jsp:param value="xiang" name="use"/>
  <jsp:param value="1234" name="password"/>
</jsp:forward>





</body>
</html>