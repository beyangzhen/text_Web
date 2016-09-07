package jdbc.savaProcedure;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;

import org.junit.Test;

import jdbc.JdbcUtil;

public class saveProcedureTest {

	@Test
	public void test(){
		Connection connection = null;
		CallableStatement statement = null;
		ResultSet resultSet = null;
		
		try {
			connection = JdbcUtil.getConnection();
			statement = connection.prepareCall("{call simpleproc (?)}");
			statement.registerOutParameter(1, Types.VARCHAR);
			statement.execute();
			System.out.println(statement.getString(1));
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.release(connection, statement, resultSet);
		}
	}
}
