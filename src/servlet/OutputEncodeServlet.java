package servlet;

import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 输出中文乱码
 */
@WebServlet("/OutputEncodeServlet")
public class OutputEncodeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public OutputEncodeServlet() {
        super();
    }

	/**
	 * ①字节的输出中文乱码
	 * 		不一定乱码 --》 浏览器使用的编码
	 * 解决
	 * 		设置浏览打开文件时采用的编码 Content-Type: text/html;charset=UTF-8
	 * 		获得字符串bytes数组时编码和打开时编码一致： .getBytes("UTF-8");
	 *
	 * *注意设置顺序：先设置响应头，然后再输出响应体
	 */
	private void run1(HttpServletResponse response) throws IOException {
		// 设置浏览器打开时的编码
		response.setHeader("Content-Type", "text/html;charset=UTF-8");
		// 获取字节输出流
		OutputStream os = response.getOutputStream();
		// 输出中文
		os.write("吃饭，睡觉，打豆豆".getBytes("UTF-8")); // ****** getBytes() FindBugs, PMD 静态代码检测工具的告诉你
	}

	/**
	 * ②字符输出中文乱码
	 * 		肯定乱码    --》 默认使用ISO-8859-1
	 * 解决
	 *	 方式一
			设置编码  response.setCharacterEncoding("UTF-8");
	 * 	    设置浏览器打开文件所采用的编码  response.setHeader("Content-Type", "text/html;charset=UTF-8");
	 *   方式二（简单方式）
	 * 	    response.setContentType("text/html;charset=UTF-8");	
	 */
	private void run2(HttpServletResponse response) throws IOException {
		System.out.println("2-------------------");
		/**方式一**/
		// 设置charsetEncoding
		//response.setCharacterEncoding("UTF-8");
		// 设置浏览器打开文件所采用的编码
		//response.setHeader("Content-Type", "text/html;charset=UTF-8");
		
		/**方式二（简单方式）**/
		response.setContentType("text/html;charset=UTF-8");
		
		// 字符输出
		response.getWriter().write("吃饭，睡觉，打豆豆"); // 默认使用ISO-8859-1
	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 字节流出
		//run1(response);
		// 字符输出
		run2(response);
	}
	
}
