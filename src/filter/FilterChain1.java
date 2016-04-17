package filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class FilterChain1 implements Filter {
	
	@Override
	public void init(FilterConfig arg0) throws ServletException {
		
	}
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		System.out.println("执行第一个Filter");
		chain.doFilter(request, response); //该Filter执行完，FilterChain调用下一个Filter执行
		System.out.println("第一个Filter执行结束");
	}
	
	@Override
	public void destroy() {
		
	}
}
