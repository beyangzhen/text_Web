package AjaxServlet.JQuery;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/ajax")
public class AjaxServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public AjaxServlet() {
        super();
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/json;charset=utf-8");
		System.out.println("method:" + request.getMethod());
		
		Enumeration<String> names = request.getParameterNames();
		while (names.hasMoreElements()) {
			String name = (String) names.nextElement();
			System.out.println(name  + "=" + request.getParameter(name));
		}
		response.getWriter().write("{\"a\":1,\"b\":\"hello\"}");
	}

}
