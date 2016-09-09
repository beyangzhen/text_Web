package dbcp;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.junit.Test;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.mchange.v2.c3p0.DataSources;

public class C3p0Test {

	// ①硬编码的方式
	@Test
	public void test1() throws SQLException {
		/*
		  ComboPooledDataSource cpds = new ComboPooledDataSource();
		  cpds.setDriverClass( "org.postgresql.Driver" );            
		  cpds.setJdbcUrl( "jdbc:postgresql://localhost/testdb" );
		  cpds.setUser("dbuser");                                  
		  cpds.setPassword("dbpassword");  
		*/
		
		// 建立连接池
		DataSource unpooled = DataSources.unpooledDataSource("jdbc:mysql:///test", "root", "root");
		DataSource dataSource = DataSources.pooledDataSource(unpooled);
		// 获取连接和相关数据库操作
		doQuery(dataSource);

	}

	// ②配置文件方式（c3p0-config.xml）
	@Test
	public void test2() throws SQLException{
		ComboPooledDataSource cpds = new ComboPooledDataSource();
		doQuery(cpds);
	}
	
	public void doQuery(DataSource dataSource) throws SQLException {
		Connection connection = dataSource.getConnection();
		
		ResultSet resultSet = connection.createStatement().executeQuery("select * from account");
		while (resultSet.next()) {
			System.out.println(resultSet.getInt(1) + "\t" + resultSet.getString(2));
		}
		// 关闭资源
		resultSet.close();
		connection.close();
	}
}
