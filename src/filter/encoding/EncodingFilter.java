package filter.encoding;

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
		HttpServletRequest myRequest = new MyRequest2(request); // 增强request（将编码处理部分，嵌入增强request的getParameter()方法中）
		// HttpServletRequest myRequest = new MyRequest1(request);
		
		chain.doFilter(myRequest, response);
	}

	public void init(FilterConfig fConfig) throws ServletException {
		this.encode = fConfig.getInitParameter("encode");
	}

}

/** 
 *   方式一（只强化了getParameter()）
 * 	     --> getParameter()每获取一个参数,只会将一个参数编码处理
 *   	     --> 不用考虑两次编码处理后，编码乱了
 * /
public class MyHttpRequest1 extends HttpServletRequestWrapper {
    HttpServletRequest req;
    
    public MyHttpRequest(HttpServletRequest old) {
        super(old);
        this.req=old;
    }
    @Override
    public String getParameter(String name) {
        String method = req.getMethod();
        if("get".equalsIgnoreCase(method)){
            String par = req.getParameter(name);
            if(par!=null){
                String result = null;
                try {
                    result=new String(par.getBytes("iso8859-1"), "utf-8");
                } catch (UnsupportedEncodingException e) {
                    throw new RuntimeException(e);
                }
                return result;
            }
            
        }
        
        return req.getParameter(name);
    }
}

/** 
 *   方式二（强化了getParameter()/getParameterMap()/getParameterValues()）
 *           --> 是在getParameterMap()中编码处理，导致getParameter()每获取一个参数，就会将整个参数map都编码处理掉
 *           --> 需要设置的flag，来避免两次编码处理后，编码又乱了
 * 
 * /
public class MyHttpRequest2 extends HttpServletRequestWrapper {
	
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
