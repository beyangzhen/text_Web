package dbcp;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

public class MyDataSourceTest {

	public static void main(String[] args) throws SQLException {
		// 获取连接池
		DataSource dataSourse = new MyDataSourse();
		// 获取连接对象
		Connection connection = dataSourse.getConnection();
		ResultSet resultSet = connection.createStatement().executeQuery("select * from account");
		while (resultSet.next()) {
			System.out.println(resultSet.getInt(1) + "\t" + resultSet.getString(2) + "\t" + resultSet.getDouble(3));
		}
		
		resultSet.close();
		connection.close();
	}

}
