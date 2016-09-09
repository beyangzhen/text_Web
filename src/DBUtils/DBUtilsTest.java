package DBUtils;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.junit.Test;

import com.zaxxer.hikari.HikariDataSource;

public class DBUtilsTest {

	@Test
	public void test(){
		//1. 设置数据源
		HikariDataSource ds = new HikariDataSource();
		ds.setJdbcUrl("jdbc:mysql://localhost:3306/day18");
		ds.setUsername("root");
		ds.setPassword("");
		
		// 2. 创建QueryRunner
		QueryRunner runner = new QueryRunner(ds);
		// 3. 创建结果集处理器
		ResultSetHandler<Account> rsh = new BeanHandler<>(Account.class);
		try {
			// 查询数据（记录结果 直接映射成 java对象）
			Account account = runner.query("select * from account where name='dd'", rsh);
			System.out.println(account);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
