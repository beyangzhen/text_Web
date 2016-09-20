package AjaxServlet.JQuery;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


WebServlet("/jsonServlet)
public class JsonServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public JsonServlet() {
        super();
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//response.setContentType("text/html;charset=UTF-8");
		response.setContentType("application/json;charset=UTF-8");
		
		StringBuffer url = request.getRequestURL();
		String uri = request.getRequestURI();
		System.out.println("url:"+url);
		System.out.println("uri:"+uri);
		
		Enumeration<String> names = request.getParameterNames();
		while (names.hasMoreElements()) {
			String name = (String) names.nextElement();
			System.out.println("name:" + name + "\tvalue:" + request.getParameter(name));
		}
		response.getWriter().write("{\"username\":\"dd\",\"password\":\"123456\",\"age\":18,\"IC\":null,\"IQ\":250}");
	}

}
