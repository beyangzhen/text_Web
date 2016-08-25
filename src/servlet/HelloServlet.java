package servlet;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContextAttributeListener;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*web.xml中配置了servlet*/
public class HelloServlet extends HttpServlet {
	String username = null;
	String password = null;
	String contextName = null;
	
	//tomcat启动过程中调用
	@Override
	public void init(ServletConfig config) throws ServletException {
		//获取web.xml中servlet中定义的变量
		username = config.getInitParameter("username"); 
		password = config.getInitParameter("password");
		
		super.init(config); //这个super()不可以删除
	}

	//必须执行了init()后，关闭时destory()才会被执行
	@Override
	public void destroy() {
		super.destroy();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//super.doGet(req, resp); //这个super()必须删除
		
		response.getWriter().write("<h1>deGet!<h1>");
		response.getWriter().println("<h1>deGet!<h1>");
		
		//查看项目部署的真实路径
		String path = getServletContext().getRealPath("com/servlet/MyServlet");
		response.getWriter().println(path);
		
		//实现重定向
		response.setStatus(302);
		response.setHeader("location", "index.jsp");	
		
		//用于ServletContextAttributeListener监听
		this.getServletContext().setAttribute("listener", "listener");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//获取web.xml中contextParam变量
		contextName = this.getServletContext().getInitParameter("contextName");
		resp.getWriter().println("<h1>doPost!</h1>");
		resp.getWriter().println(username);
		resp.getWriter().println(password);
		resp.getWriter().println(contextName);
	}

}
