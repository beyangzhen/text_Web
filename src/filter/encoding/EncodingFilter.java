package filter;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;

/**
 * GET|POST 编码转换
 */
public class EncodingFilter implements Filter {

	private String encode;

	public EncodingFilter() {
	}

	public void destroy() {
	}

	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
			throws IOException, ServletException {

		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) res;
				/* 解决post方式，中文乱码 */
		// request.setCharacterEncoding(encode);
		
				/* 解决get方式，中文乱码 */
		// 因为 String name = new String(name.getBytes("ISO-8859-1"), "UTF-8")编码处理后的name值，传不到接下来的servlet中
		HttpServletRequest myRequest = new MyRequest(request); // 增强request（将编码处理部分，嵌入增强request的getParameter()方法中）

		chain.doFilter(myRequest, response);
	}

	public void init(FilterConfig fConfig) throws ServletException {
		this.encode = fConfig.getInitParameter("encode");
	}

}

class MyRequest extends HttpServletRequestWrapper {
	
	private HttpServletRequest request;
	
	private boolean flag = true;
	
	public MyRequest(HttpServletRequest old) {
		super(request);
		this.request = old;
	}

	@Override
	public String getParameter(String name) {
		// 参数为空处理
		if (name == null) {
			return null;
		}
		Map<String, String[]> map = getParameterMap();
		String[] strings = map.get(name);
		// 为空处理
		if (strings == null || strings.length == 0) {
			return null;

		}
		return strings[0];
	}

	@Override
	public Map<String, String[]> getParameterMap() {
		// 1. 得到所有请求参数map
		Map<String, String[]> map = request.getParameterMap();
		if (flag ) { // 避免获取第二个参数时，又将整个map编码处理一遍（两次编码处理，编码又乱了）
			// 2. 乱码解决
			for (String key : map.keySet()) {
				String[] values = map.get(key);
				for (int i = 0; i < values.length; i++) {
					try {
						values[i] = new String(values[i].getBytes("ISO-8859-1"), "UTF-8");
					} catch (UnsupportedEncodingException e) {
						e.printStackTrace();
					}
				}
			}
			flag = false;
		}
		return map;
	}

	@Override
	public String[] getParameterValues(String name) {
		// 参数为空处理
		if (name == null) {
			return null;
		}
		return getParameterMap().get(name);
	}

}