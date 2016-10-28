package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.PreparedStatement;

public class TestJdbc {

	public static void main(String[] args) {
		 try {
			 //向Drivermanager注册数据库的驱动实例
			Class.forName("com.mysql.jdbc.Driver") ;
			//准备数据库的用户名、密码、url
			String url="jdbc:mysql://localhost:3306/servlet";
			String username="root";
			String password="root";			
			Connection con=DriverManager.getConnection(url, username, password);
			Statement stmt=con.createStatement();
//			String sql="select id,name,address from jdbc_1";
			String sqlu="update jdbc_1 set name ='chengxiangfeng' where id=1";
			String sqlu1="update jdbc_1 set address='meiguo' where id=1";
			//设置事物为手动提交\不是自动提交的话就会是每次执行一个sql语句都会 提交一次数据。
			con.setAutoCommit(false);
			stmt.executeUpdate(sqlu);
			stmt.executeUpdate(sqlu1);
			con.commit();//提交事物
			//准备预编译sql语句
			String sqlp="select name,id,address from jdbc_1 where id=?";
			//获得预编译实现对象、preparestatment接口继承了statment接口。
			PreparedStatement ps=(PreparedStatement) con.prepareStatement(sqlp);
			ps.setInt(1, 2);
			ResultSet rs=ps.executeQuery();//这是select语句执行的结果集
//			String sql="select id,name,address from jdbc_1";
//			ResultSet rs=stmt.executeQuery(sql);
			while(rs.next()){//返回下一条记录
				//这里的1 2 3 对应的是sql语句中的select 后面的投影的下标。
//				使用下标来获取
				String col1=rs.getString(1);
				int col2=rs.getInt(2);
				String col3=rs.getString(3);
				//使用name来获取
				String colname1=rs.getString("name");
				System.out.println(col1+"--"+col2+"--"+col3);
//				输出使用name获取的 数据库的数据。
				System.out.println(colname1);
			}
			//关闭资源
			rs.close();
			stmt.close();
			con.close();
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  finally{
//			一般在这里关闭资源
		} 

	}

}
