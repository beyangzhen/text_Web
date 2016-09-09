package com.wxhledu.cn.dbcp;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ArrayHandler;
import org.apache.commons.dbutils.handlers.ArrayListHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.mchange.v2.c3p0.DataSources;
import com.wxhledu.cn.domain.Account;

/**
 * 	ArrayHandler：把结果集中的第一行数据转成对象数组。
	ArrayListHandler：把结果集中的每一行数据都转成一个数组，再存放到List中。
	BeanHandler：将结果集中的第一行数据封装到一个对应的JavaBean实例中。*****
	BeanListHandler：将结果集中的每一行数据都封装到一个对应的JavaBean实例中，存放到List里。*****
 * @author wxhl
 *
 */
public class ResultSetHandlerImplTest {
	
	
	private QueryRunner queryRunner;
	private String sql = "select * from account";

	@Before
	public void setup() throws SQLException{
		System.out.println("准备测试****");
		// 1.创建QueryRunner对象
		queryRunner = new QueryRunner(DataSources.unpooledDataSource("jdbc:mysql:///day18", "root", ""));
	}

	@After
	public void teardown(){
		System.out.println("结束测试*****");
	}
	
	@Test
	public void testArrayHandler() throws SQLException{
		// 2. 进行查询
		Object[] query = queryRunner.query(sql , new ArrayHandler());
		// 3. 处理返回
		System.out.println(Arrays.toString(query));
	}
	
	@Test
	public void testArrayListHandler() throws SQLException{
		List<Object[]> list = queryRunner.query(sql, new ArrayListHandler());
		for (Object[] objects : list) {
			System.out.println(Arrays.toString(objects));
		}
	}
	
	@Test
	public void testBeanHandler() throws SQLException{
		Account query = queryRunner.query(sql + " where name = 'dd'", new BeanHandler<Account>(Account.class));
		System.out.println(query);
	}
	
	@Test
	public void testBeanListHandler() throws SQLException{
		List<Account> query = queryRunner.query(sql, new BeanListHandler<Account>(Account.class));
		System.out.println(query);
	}
	
	
}
