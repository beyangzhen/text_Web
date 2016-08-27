package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 浏览器定时刷新 <br>
 * refresh: 时间[秒];url=
 * 
 */
public class RefreshServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public RefreshServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setHeader("refresh", "5;url=/day09/ValidateCodeServlet");
		response.setContentType("text/html;charset=UTF-8");
		response.getWriter().write("<h1>看我定时刷新</h1>");
	}

}
