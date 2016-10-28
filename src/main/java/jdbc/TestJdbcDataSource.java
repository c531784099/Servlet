package jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class TestJdbcDataSource {
//这个类是不能运行的测试Datasource是在datasource.jsp中测试的。
//	测试地址  http://127.0.0.1:8080/servletstudy/data  jsp在web.xml中配置了访问地址。
	public static void main(String[] args) {
		
		
		try {
			Connection con;
			Statement stmt;
			ResultSet rs;
//			使用名字服务需要 在context.xml中设置标签</Context>  <Resource  和在web.xml中设置 <resource-ref>标签
//			负责查找 JDIN资源 
//			Datasource一般由servlet容器创建。
			Context ctx=new InitialContext();
			//通过名字服务来获得  需要的DataSource对象。
			DataSource ds=(DataSource) ctx.lookup("java:comp/env/jdbc/TestDB");
			//从DataSource中获得一个connection连接对象。剩下的操作就和jdbc相同了。
			con=ds.getConnection();
			
			String sql="select id ,name,address from jdbc_1 ";
			
		    stmt=con.createStatement();
			rs=stmt.executeQuery(sql);
			
			while(rs.next()){
				String col2=rs.getString(2);
				int col1=rs.getInt(1);
				String col3=rs.getString(3);
				System.out.println(col1+col2+col3);
			}
//			这里的关闭不是释放资源、而是将资源还给了Datasource
			con.close();
		
		} catch (Exception e) {
		e.printStackTrace();
		}
	}

}
