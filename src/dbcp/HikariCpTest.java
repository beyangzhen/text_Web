package dbcp;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import org.junit.Test;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

// https://github.com/brettwooldridge/HikariCP
public class HikariCpTest {

	// ①硬编码的方式
	@Test
	public void test1() throws SQLException{	
		// 设置配置
		HikariConfig config = new HikariConfig();
		config.setJdbcUrl("jdbc:mysql://localhost:3306/day18");
		config.setUsername("root");
		config.setPassword("");
		config.addDataSourceProperty("cachePrepStmts", "true");
		config.addDataSourceProperty("prepStmtCacheSize", "250");
		config.addDataSourceProperty("prepStmtCacheSqlLimit", "2048");
		// 建立连接池
		HikariDataSource dataSource = new HikariDataSource(config);
		
		// 获取连接对象
		Connection connection = dataSource.getConnection();
		// 进行数据查询
		ResultSet resultSet = connection.createStatement().executeQuery("select * from account");
		while (resultSet.next()) {
			System.out.println(resultSet.getInt(1) + "\t" + resultSet.getString(2));
		}
		
		// 关闭资源
		resultSet.close();
		connection.close();
	}
	
	@Test
	public void test2() throws SQLException{
		// 建立连接池
		HikariDataSource dataSource = new HikariDataSource();
		dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/day18");
		dataSource.setUsername("root");
		dataSource.setPassword("");
		// 获取连接对象
		Connection connection = dataSource.getConnection();
		// 进行数据查询
		ResultSet resultSet = connection.createStatement().executeQuery("select * from account");
		while (resultSet.next()) {
			System.out.println(resultSet.getInt(1) + "\t" + resultSet.getString(2));
		}
		
		// 关闭资源
		resultSet.close();
		connection.close();
	}
	
	/*
	 // ②配置文件方式（hikari.properties）
	 @Test
	 public void test3() throws SQLException, IOException{
		Properties props = new Properties();
		props.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("hikari.properties"));
		HikariConfig config = new HikariConfig(props );
		HikariDataSource ds = new HikariDataSource(config);
		C3p0Test.doQuery(ds);
	}
	*/
}
