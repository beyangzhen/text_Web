package dbcp;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class JdbcUtil {
	
	private static Properties config = new Properties();

	// 1.注册驱动
	static {
		try {
			JdbcUtil.class.getClassLoader();
			config.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("jdbc.properties"));
			//config.load(JdbcUtil.class.getClassLoader().getSystemResourceAsStream("database.properties"));
			//config.load(ClassLoader.getSystemResourceAsStream("database.properties"));
			Class.forName(config.getProperty("driverClassName"));
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	// 2.获得链接对象
	public static Connection getConnection() throws SQLException {
		return DriverManager.getConnection(config.getProperty("url"), config.getProperty("username"), config.getProperty("password"));
	}
	
	// 6.释放资源
	public static void release(Connection connection, Statement statement, ResultSet resultSet){
	
		if (resultSet != null) {
			try {
				resultSet.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			resultSet = null;
		}
		
		if (statement != null) {
			try {
				statement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			statement = null;
		}
	
		if (connection != null) {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
