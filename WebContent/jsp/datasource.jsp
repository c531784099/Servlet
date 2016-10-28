<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
 <%@ page import="java.io.*" %>
 <%@ page import="java.util.*" %>
 <%@ page import="java.sql.*" %>
 <%@ page import="javax.sql.*" %>
 <%@ page import="javax.naming.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>jdbc_datasource</title>
</head>
<body>
<%  try {
	Connection con;
	Statement stmt;
	ResultSet rs;
	
	Context ctx=new InitialContext();
	DataSource ds=(DataSource) ctx.lookup("java:comp/env/jdbc/TestDB");
	
	con=ds.getConnection();
	
	String sql="select id ,name,address from jdbc_1 ";
	
    stmt=con.createStatement();
	rs=stmt.executeQuery(sql);
	
	while(rs.next()){
		String col2=rs.getString(2);
		int col1=rs.getInt(1);
		String col3=rs.getString(3);
		out.println(""+col1+col2+col3);
	}
	
	rs.close();
	stmt.close();
	con.close();
} catch (Exception e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
} %>
</body>
</html>