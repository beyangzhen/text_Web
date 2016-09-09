package dbcp;

import java.io.PrintWriter;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.util.LinkedList;
import java.util.logging.Logger;

import javax.sql.DataSource;


/**
 *  
 *  自定义 数据库连接池
 */
public class MyDataSourse implements DataSource {
	
	//连接池容器
	private LinkedList<Connection> pool;
	
	public MyDataSourse() throws SQLException {
		pool = new LinkedList<>(); // 容器初始化
		
		addDefaultConnection();
	}
	
	// 设置默认连接对象个数
	private void addDefaultConnection() throws SQLException{
		for (int i = 0; i < 5; i++) {
			pool.add(JdbcUtil.getConnection()); // 连接池中添加连接
		}
	}
	
	@Override
	public PrintWriter getLogWriter() throws SQLException {
		return null;
	}

	@Override
	public void setLogWriter(PrintWriter out) throws SQLException {

	}

	@Override
	public void setLoginTimeout(int seconds) throws SQLException {

	}

	@Override
	public int getLoginTimeout() throws SQLException {
		return 0;
	}

	@Override
	public Logger getParentLogger() throws SQLFeatureNotSupportedException {
		return null;
	}

	@Override
	public <T> T unwrap(Class<T> iface) throws SQLException {
		return null;
	}

	@Override
	public boolean isWrapperFor(Class<?> iface) throws SQLException {
		return false;
	}

	// 从连接池中获取连接
	@Override
	public Connection getConnection() throws SQLException {
		if(pool.isEmpty()){
			addDefaultConnection(); // 如果池里没有连接对象，创建连接（默认个数）
		}
		
		// 取一个连接对象
		final Connection first = pool.removeFirst();
		
		// 通过 "动态代理" 把连接对象放回池里（更改了close()方法）
		Class<? extends Connection> _class = first.getClass();
		InvocationHandler handler = new InvocationHandler() {
			
			@Override
			public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
				if("close".equals(method.getName())){
					// 把连接对象放回池里
					System.out.println("把连接对象放回池里");
					pool.add(first);
				}
				return method.invoke(first, args);
			}
		};
		Connection p = (Connection)Proxy.newProxyInstance(_class.getClassLoader(), _class.getInterfaces(), handler);
		
		return p;
	}

	@Override
	public Connection getConnection(String username, String password) throws SQLException {
		return null;
	}

}
