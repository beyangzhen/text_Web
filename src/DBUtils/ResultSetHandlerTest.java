package com.wxhledu.cn.dbcp;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.junit.Test;

import com.mchange.v2.c3p0.DataSources;
import com.wxhledu.cn.domain.Account;

public class ResultSetHandlerTest {

	@Test
	public void test() throws SQLException{
		// 1.创建QueryRunner对象
		QueryRunner runner = new QueryRunner(DataSources.unpooledDataSource("jdbc:mysql:///day18", "root", ""));
		// 3.创建结果集处理器
		ResultSetHandler<List<Account>> rsh = new ResultSetHandler<List<Account>>() {

			@Override
			public List<Account> handle(ResultSet rs) throws SQLException {
				if (!rs.next()) {
		            return null;
		        }
				List<Account> list = new ArrayList<>();
				while (rs.next()) {
					/*Account account = new Account();
					account.setId(id);
					account.setName(name);
					account.setMoney(money);*/
					list.add(new Account(rs.getInt(1), rs.getString(2), rs.getDouble(3)));
				}
				return list;
			}
		};
		// 2.查询数据库，返回（带结果集处理器）
		List<Account> list = runner.query("select * from account", rsh);
		System.out.println(list);
		
	}
}
