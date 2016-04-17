package servlet;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContextAttributeListener;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*web.xml��������servlet*/
public class HelloServlet extends HttpServlet {
	String username = null;
	String password = null;
	String contextName = null;
	
	//tomcat���������е���
	@Override
	public void init(ServletConfig config) throws ServletException {
		//��ȡweb.xml��servlet�ж���ı���
		username = config.getInitParameter("username"); 
		password = config.getInitParameter("password");
		
		super.init(config); //���super()������ɾ��
	}

	@Override
	public void destroy() {
		super.destroy();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//super.doGet(req, resp); //���super()����ɾ��
		resp.getWriter().println("doGet!");	
		
		//����ServletContextAttributeListener����
		this.getServletContext().setAttribute("listener", "listener");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//��ȡweb.xml��contextParam����
		contextName = this.getServletContext().getInitParameter("contextName");
		resp.getWriter().println("doPost!");
		resp.getWriter().println(username);
		resp.getWriter().println(password);
		resp.getWriter().println(contextName);
	}

}
