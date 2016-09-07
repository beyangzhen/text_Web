package jdbc.batch;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.Test;

import jdbc.JdbcUtil;

public class PreparedStatementBatchTest {

	@Test
	public void test() {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		try {
			connection = JdbcUtil.getConnection();
			statement = connection.prepareStatement("insert into user (name, password) values(?,?)");

			long start = System.currentTimeMillis();
			
			// 循环插入数据
			for (int i = 1; i < 100000; i++) {
				// 设置预编译语句
				statement.setString(1, "name" + i);
				statement.setString(2, "123456");
				// 添加批处理
				statement.addBatch();
				if (i % 1000 == 0) {
					// 执行批处理
					statement.executeBatch();
					// 清理
					statement.clearBatch();
				}
			}

			long end = System.currentTimeMillis();
			System.out.println(String.format("start:%d, end:%d, duration: %d", start, end, end - start));
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.release(connection, statement, resultSet);
		}
	}
}
