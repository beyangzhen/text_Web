package DBUtils;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.junit.Test;

import com.zaxxer.hikari.HikariDataSource;

public class DBUtilsTest {

	// QueryRunner(DataSource ds) ：query(sql, rsh) 和 update(sql, ...)  （不好设置事务）
	// BeanHandler()
	@Test
	public void testQuery1(){
		//1. 设置数据源
		HikariDataSource ds = new HikariDataSource();
		ds.setJdbcUrl("jdbc:mysql://localhost:3306/test");
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
	
	// QueryRunner() ：query(conn, sql, rsh)  （connection方式可以设置事务）
	// BeanListHandler()
	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	@Test
	public void testQuery2() throws SQLException, ClassNotFoundException{
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
	// QueryRunner(DataSource ds) 
	// ResultSetHandler()
	@Test
	public void testQuery3() throws SQLException{
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
