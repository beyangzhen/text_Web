package jdbcAdvanced.batch;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.Test;

import jdbcAdvanced.JdbcUtil;

public class StatementBatchTest {

	@Test
	public void test(){
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		try {
			connection = JdbcUtil.getConnection();
			statement = connection.createStatement();
			//使用批处理
			statement.addBatch("insert into user(name, password) values ('admin', 'admin')");
			statement.addBatch("insert into user(name, password) values ('tomcat', 'tomcat')");
			statement.addBatch("insert into user(name, password) values ('jetty', 'jetty')");
			statement.addBatch("insert into user(name, password) values ('glashfish', 'glashfish')");
			statement.addBatch("insert into user(name, password) values ('spring', 'spring')");
			//执行批处理
			statement.executeBatch();
			//清理
			statement.clearBatch();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.release(connection, statement, resultSet);
		}
	}
}
