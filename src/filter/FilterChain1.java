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
		System.out.println("ִ�е�һ��Filter");
		chain.doFilter(request, response); //��Filterִ���꣬FilterChain������һ��Filterִ��
		System.out.println("��һ��Filterִ�н���");
	}
	
	@Override
	public void destroy() {
		
	}
}