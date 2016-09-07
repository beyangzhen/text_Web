package jdbcAdvanced.genkey;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.Test;

import jdbcAdvanced.JdbcUtil;

/**
 * 生成主键
 * @author yz
 *
 */
public class GeneratedKeysTest {

	@Test
	public void test(){
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		
		try {
			connection = JdbcUtil.getConnection();
			
			String sql = "insert into user(name, password) values (?,?)";
			statement = connection.prepareStatement(sql , Statement.RETURN_GENERATED_KEYS); // 设置生成主键
			statement.setString(1, "小二");
			statement.setString(2, "123");
			
			statement.executeUpdate(); // 插入，返回是记录条数（不是ResultSet）
			resultSet = statement.getGeneratedKeys(); // 获取生成主键的结果集
			while(resultSet.next()){
				System.out.println(resultSet.getInt(1));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.release(connection, statement, resultSet);
		}
	}
}
