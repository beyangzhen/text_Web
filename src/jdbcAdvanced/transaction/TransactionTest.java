package com.wxhledu.cn.transaction;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.Test;

import com.wxhledu.cn.util.JdbcUtil;

public class TransactionTest {

	@Test
	public void test(){
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		try {
			connection = JdbcUtil.getConnection();
			//设置隔离级别
			connection.setTransactionIsolation(Connection.TRANSACTION_REPEATABLE_READ);
			//1. 开启事务
			connection.setAutoCommit(false);
			//执行语句操作
			statement = connection.createStatement();
			statement.executeUpdate("update account set money=5000 where name='my'");
			
		} catch (SQLException e) {
			e.printStackTrace();
			// 2.事务回滚
			try {
				connection.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		} finally {
			// 3.事务提交
			if (null != connection) {
				try {
					connection.commit();
				} catch (SQLException e) {
					e.printStackTrace();
				} 
			}
			JdbcUtil.release(connection, statement, resultSet);
		}
	}
}
