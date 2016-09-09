package DBUtils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.junit.Test;

import com.mchange.v2.c3p0.DataSources;

/**
 * 		
 * @author yz
 *
 */
public class QueryRunnerTest {
	
	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	// 1. QueryRunner() ：query(conn, sql, rsh)  （connection方式可以设置事务）
	@Test
	public void testQuery1() throws SQLException, ClassNotFoundException{
		QueryRunner runner = new QueryRunner();
		Connection conn = null;
		try {
			conn = DriverManager.getConnection("jdbc:mysql:///test", "root", "");
			//conn.setAutoCommit(false);
			ResultSetHandler<List<Account>> rsh = new BeanListHandler<>(Account.class);
			List<Account> list = runner.query(conn, "select * from account", rsh);
			System.out.println(list);
		} finally {
			//conn.commit();
			conn.close();
		}
		
	}
	
	/**
	 *  javaBean => 表格记录字段不一致
	 */
	// 2. QueryRunner(DataSource ds) ：query(sql, rsh) 和 update(sql, ...)  （不好设置事务）
	@Test
	public void testQuery2() throws SQLException{
		// 1.使用带数据源的构造器创建QueryRunner
		QueryRunner runner = new QueryRunner(DataSources.unpooledDataSource("jdbc:mysql:///test", "root", ""));
		// 3. 创建结果集处理器
		ResultSetHandler<List<Acc>> rsh = new ResultSetHandler<List<Acc>>() {
		
			@Override
			public List<Acc> handle(ResultSet rs) throws SQLException {
				// 解决javaBean 与 表格记录字段不一致
				List<Acc> list = new ArrayList<>();
				while (rs.next()) {
					/*
					Acc acc = new Acc();
					acc.setIdx(rs.getInt(1));
					acc.setUsername(rs.getString(2));
					acc.setRmb(rs.getDouble(3));
					list.add(acc);
					*/
					list.add(new Account(rs.getInt(1), rs.getString(2), rs.getDouble(3)));
				}
				return list;
			}
		};
		// 2. 使用QueryRunner进入查询操作
		List<Acc> list = runner.query("select * from account", rsh);
		// 4. 打印结果
		System.out.println(list);
	}
	
	
}
