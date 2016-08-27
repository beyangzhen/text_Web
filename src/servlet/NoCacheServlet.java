package servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 禁用浏览器缓存
 * 1. Cache-Control: no-cache , Pragma: no-cache, Expires: -1
 * 2. 在请求路径里添加?_dc=1472205435880[用js产生：new Date().getTime() --》 extjs ]
 */
public class NoCacheServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public NoCacheServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setHeader("Cache-Control", "no-cache");
		response.setHeader("Pragma", "no-cache");
		response.setDateHeader("Expires", -1);
		// 产生当前时间字符串
		String date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
		response.getWriter().write(date);
	}

}
