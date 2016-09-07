package jdbc.bigData;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.Test;

import jdbc.JdbcUtil;

public class TextTest {

	//插入text
	@Test
	public void testSave() throws FileNotFoundException{
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		try {
			connection = JdbcUtil.getConnection();
			String sql = "insert into mytext (context) values (?)";
			statement = connection.prepareStatement(sql );
			
			File file = new File("C:\\Users\\qinhaizong\\WXHL\\2016_haizong\\workspace_std\\day18\\README.md");
			Reader reader = new FileReader(file);
			statement.setCharacterStream(1, reader, file.length());
			int update = statement.executeUpdate();
			if(update >0) {
				System.out.println("OK");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.release(connection, statement, resultSet);
		}
	}
	
	//获取text
	@Test
	public void get() throws IOException{
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		try {
			// 1.获取Connection
			connection = JdbcUtil.getConnection();
			// 2.获取PreparedStatement
			statement = connection.prepareStatement("select context from mytext where id=?");
			statement.setInt(1, 1);
			// 3.得到结果集
			resultSet = statement.executeQuery();
			// 4.遍历结果集
			while (resultSet.next()) {
				Reader reader = resultSet.getCharacterStream(1);
				// 5. IO处理
				FileWriter writer = new FileWriter("笔记.txt");
				
				int len;
				char[] ch  = new char[1024*100];
				while ((len=reader.read(ch)) != -1) {
					writer.write(ch, 0, len);
					writer.flush();
				}
				writer.close();
				reader.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.release(connection, statement, resultSet);
		}
	}
}
