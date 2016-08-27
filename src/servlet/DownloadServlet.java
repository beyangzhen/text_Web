package servlet;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/DownloadServlet")
public class DownloadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public DownloadServlet() {
		super();
	}

	/**
	 * 1. 直接按照路径的方式（） .pdf （chrome, firefox）<br>
	 * 2. 设置消息头：Content-Disposition:attachment;filename=文件名
	 * 
	 * 3. 断点下载：设备消息头 Content-length, Content-Rage:
	 * 
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
				
		// tomcat7 默认ISO-8859-1
		response.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode("断点下载.png", "UTF-8"));
		// 内容部分
		InputStream is = getServletContext().getResourceAsStream("/断点下载.png");
		OutputStream os = response.getOutputStream();
		byte[] bs = new byte[1024];
		int len = 0;
		while ((len = is.read(bs)) != -1) {
			os.write(bs, 0, len);
		}
		is.close();	
		//os.close(); // tomcat容器会给我们关掉
	}

}
