package jdbcAdvanced.bigData;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.Test;

import jdbcAdvanced.JdbcUtil;

public class BlobTest {

	@Test
	public void testSave() throws FileNotFoundException {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		try {
			// 获取连接
			connection = JdbcUtil.getConnection();
			// 获取prearedStatement
			statement = connection.prepareStatement("insert into myblob values(null, ?)");

			File file = new File("C:\\Users\\qinhaizong\\Downloads\\The Cucumber for Java Book.pdf");
			FileInputStream fis = new FileInputStream(file);
			statement.setBinaryStream(1, fis, file.length());

			int executeUpdate = statement.executeUpdate();
			if (executeUpdate != 0) {
				System.out.println("插入成功");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			//释放资源
			JdbcUtil.release(connection, statement, resultSet);
		}
	}
	
	@Test
	public void testQuery() throws IOException{
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		try {
			connection = JdbcUtil.getConnection();
			statement = connection.prepareStatement("select * from myblob where id=?");
			statement.setInt(1, 2);
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				InputStream stream = resultSet.getBinaryStream("content");
				
				FileOutputStream fos = new FileOutputStream("a.pdf");
				
				int len;
				byte[] b = new byte[1024*100];
				while((len = stream.read(b)) != -1) {
					fos.write(b, 0, len);
					fos.flush();
				}
				fos.close();
				stream.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.release(connection, statement, resultSet);
		}
	}
	
}
