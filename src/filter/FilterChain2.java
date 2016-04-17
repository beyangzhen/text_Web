package filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class FilterChain2 implements Filter{
	
	//tomcat启动过程中调用
	@Override
	public void init(FilterConfig arg0) throws ServletException {
		
	}

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2) throws IOException, ServletException {
		System.out.println("执行第二个Filter");
		arg2.doFilter(arg0, arg1);
		System.out.println("第二个Filter执行结束");
	}
	
	@Override
	public void destroy() {
		
	}
	
}
