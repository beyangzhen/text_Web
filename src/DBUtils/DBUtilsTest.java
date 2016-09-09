package com.wxhledu.cn.dbcp;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.junit.Test;

import com.wxhledu.cn.domain.Account;
import com.zaxxer.hikari.HikariDataSource;

public class DBUtilsTest {

	@Test
	public void test1(){
		//1. 设置数据源
		HikariDataSource ds = new HikariDataSource();
		ds.setJdbcUrl("jdbc:mysql://localhost:3306/day18");
		ds.setUsername("root");
		ds.setPassword("");
		// 数据库记录 ==》 javabean对象
		// 2. 创建QueryRunner
		QueryRunner runner = new QueryRunner(ds);
		// 3. 创建结果集处理器
		ResultSetHandler<Account> rsh = new BeanHandler<>(Account.class);
		try {
			// 查询数据
			Account account = runner.query("select * from account where name='dd'", rsh);
			System.out.println(account);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
