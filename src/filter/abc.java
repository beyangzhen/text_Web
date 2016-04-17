package filter;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/*ÿ��servlet����ʱ����(����)����д�õ�����Filter*/
/*Filterִ�е�˳���������ļ���filter-mappingд��˳��*/

public class abc implements Filter {
	
	//tomcat���������е���
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
		chain.doFilter(request, response); //��Filterִ���꣬FilterChain������һ��Filterִ��
	}
	
	@Override
	public void destroy() {
		
	}
	
}
