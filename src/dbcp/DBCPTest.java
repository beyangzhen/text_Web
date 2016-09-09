package dbcp;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.commons.dbcp2.BasicDataSourceFactory;
import org.junit.Test;

/**
 * 1. 硬编码的方式
 * 2. 配置文件的方式
 * @author yz
 *
 */
public class DBCPTest {
	
	// ①硬编码的方式
	@Test
	public void test1() throws SQLException{		
		// 建立连接池
		BasicDataSource dataSource = new BasicDataSource();
		// 设置配置
		dataSource.setUrl("jdbc:mysql://localhost:3306/test");
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUsername("root");
		dataSource.setPassword("");
		// 获取连接对象
		Connection connection = dataSource.getConnection();
		// 进行数据查询
		ResultSet resultSet = connection.createStatement().executeQuery("select * from account");
		
		while (resultSet.next()) {
			System.out.println(resultSet.getInt(1) + "\t" + resultSet.getString(2) + "\t" + resultSet.getDouble(3));
		}
		// 关闭资源
		resultSet.close();	
		connection.close();
		dataSource.close(); // web应用里最后关闭（即：连接池）
	}
	
	// ②配置文件方式（jdbc.properties）
	@Test
	public void test2() throws Exception{
		// 设置配置
		Properties props = new Properties();
		props.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("jdbc.properties"));
		// 建立连接池
		BasicDataSource dataSource = BasicDataSourceFactory.createDataSource(props );
		// 获取连接对象
		Connection connection = dataSource.getConnection();
		// 进行数据查询
		ResultSet resultSet = connection.createStatement().executeQuery("select * from account");
		
		while (resultSet.next()) {
			System.out.println(resultSet.getInt(1) + "\t" + resultSet.getString(2) + "\t" + resultSet.getDouble(3));
		}
		// 关闭资源
		resultSet.close();	
		connection.close();		
		dataSource.close(); // web应用里最后关闭
	}

}
