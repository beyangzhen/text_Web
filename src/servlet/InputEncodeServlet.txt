package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/InputEncodeServlet2")
public class MyServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//get请求的转码方式
		System.out.println(new String(request.getParameter("name").getBytes("ISO-8859-1"), "utf-8"));
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//post请求的转码方式
		request.setCharacterEncoding("utf-8");
		System.out.println(String.format("名字：%s", request.getParameter("name")));
	}

}
