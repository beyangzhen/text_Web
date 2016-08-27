package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * ∑¿µ¡¡¥
 */
@WebServlet("/RefererServlet")
public class RefererServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String ref = request.getHeader("Referer");
		
		if (ref == null || ref == "" || !ref.startsWith("http://localhost")) {
			response.sendRedirect(request.getContextPath() + "/homePage.html");
		} else {
			this.getServletContext().getRequestDispatcher("/WEB-INF/fengjie.html").forward(request, response);
		}
	}

}
