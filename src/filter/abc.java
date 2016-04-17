package filter;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/*每个servlet运行时都会(经过)运行写好的所有Filter*/
/*Filter执行的顺序是配置文件中filter-mapping写的顺序*/

public class abc implements Filter {
	
	//tomcat启动过程中调用
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		Enumeration names = filterConfig.getInitParameterNames();
		while(names.hasMoreElements()) {
			System.out.println(names.nextElement());
		}
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		System.out.println("do filter");
		chain.doFilter(request, response); //该Filter执行完，FilterChain调用下一个Filter执行
	}
	
	@Override
	public void destroy() {
		
	}
	
}
